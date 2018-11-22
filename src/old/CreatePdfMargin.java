package old;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import beans.SentenceInputBean;
import beans.SheetInfoCtrlBean;
import constant.Const;
import model.EditCharacter;
import utils.BufferdImageConvertUtil;
import utils.LoggerUtil;

public class CreatePdfMargin {

	public static void execute(SheetInfoCtrlBean sheetInfoCtrlBean,
			ArrayList<SentenceInputBean> sentenceInputBeanList) {

		// 用紙サイズ.
		String sheetSize = sheetInfoCtrlBean.getSheetSize();
		// 用紙向き.
		String sheetDirection = sheetInfoCtrlBean.getSheetDirection();
		// 画像パス.
		String imagePath = sheetInfoCtrlBean.getImagePath();
		// 文字開始位置(縦)
		int charStartRowPosition = Integer.parseInt(sheetInfoCtrlBean.getCharStartRowPosition());
		// 文字開始位置(横)
		int charStartColumnPosition = Integer.parseInt(sheetInfoCtrlBean.getCharStartColumnPosition());
		// 行間.
		int betweenLine = Integer.parseInt(sheetInfoCtrlBean.getBetweenLine());

		try {

			// 用紙サイズを決定.
			PDRectangle rectangle = new PDRectangle();
			if ("A0".equals(sheetSize)) {
				rectangle = PDRectangle.A0;
			}
			if ("A1".equals(sheetSize)) {
				rectangle = PDRectangle.A1;
			}
			if ("A2".equals(sheetSize)) {
				rectangle = PDRectangle.A2;
			}
			if ("A3".equals(sheetSize)) {
				rectangle = PDRectangle.A3;
			}
			if ("A4".equals(sheetSize)) {
				rectangle = PDRectangle.A4;
			}
			if ("A5".equals(sheetSize)) {
				rectangle = PDRectangle.A5;
			}
			if ("A6".equals(sheetSize)) {
				rectangle = PDRectangle.A6;
			}

			// 画像描画用のドキュメント生成.
			PDPage page = new PDPage(rectangle);
			PDDocument document = new PDDocument();

			// 横向き指定の場合は用紙を90°回転させる.
			if ("column".equals(sheetDirection)) {
				page.setRotation(90);
			}

			// 画像描画ストリームを生成.
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// 行数分ループ.
			int index = 0;
			for (SentenceInputBean sentenceInputBean : sentenceInputBeanList) {

				// 文字位置(上).
				int topPosition = Integer.parseInt(sentenceInputBean.getTopPosition());
				// 文字位置(下).
				int bottomPosition = Integer.parseInt(sentenceInputBean.getBottomPosition());
				// 文字位置(左).
				int leftPosition = Integer.parseInt(sentenceInputBean.getLeftPosition());
				// 文字位置(右).
				int rightPosition = Integer.parseInt(sentenceInputBean.getRightPosition());

				// テキストエリア.
				ArrayList<String> inputStringList = new ArrayList<>();
				inputStringList.add(sentenceInputBean.getInputTextArea1());
				inputStringList.add(sentenceInputBean.getInputTextArea2());
				inputStringList.add(sentenceInputBean.getInputTextArea3());
				inputStringList.add(sentenceInputBean.getInputTextArea4());
				inputStringList.add(sentenceInputBean.getInputTextArea5());

				// マージン.
				ArrayList<Integer> blockMarginList = new ArrayList<>();
				blockMarginList.add(Integer.parseInt(sentenceInputBean.getBlockMargin1()));
				blockMarginList.add(Integer.parseInt(sentenceInputBean.getBlockMargin2()));
				blockMarginList.add(Integer.parseInt(sentenceInputBean.getBlockMargin3()));
				blockMarginList.add(Integer.parseInt(sentenceInputBean.getBlockMargin4()));
				blockMarginList.add(Integer.parseInt(sentenceInputBean.getBlockMargin5()));
				blockMarginList.add(Integer.parseInt(sentenceInputBean.getBlockMargin6()));

				// PDFの高さを取得.
				int height = (int) Math.floor(rectangle.getHeight());
				// PDFの幅を取得.
				int width = (int) Math.floor(rectangle.getWidth());

				// 入力文字の編集.
				ArrayList<ArrayList<BufferedImage>> imageList = EditCharacter.execute(inputStringList,
						sentenceInputBean.getCharColor(), imagePath);

				// テキストエリアごとのブロック幅合計.
				int blockWidthSum = 0;

				// ブロック分ループ.
				for (int i = 0; i < imageList.size(); i++) {

					// テキストエリアのブロック幅.
					int blockWidth = 0;

					// 要素(文字)分ループ.
					for (int j = 0; j < imageList.get(i).size(); j++) {

						// 画像オブジェクトを作成.
						PDImageXObject image = PDImageXObject.createFromByteArray(document,
								BufferdImageConvertUtil.getImageBytes(imageList.get(i).get(j), "png"), null);

						// テキストエリアの画像幅合計 = ブロック幅.
						blockWidth += image.getWidth();

						// マージン幅合計.
						int marginSum = 0;
						for (int k = 0; k <= i; k++) {
							marginSum += blockMarginList.get(k);
						}

						LoggerUtil.execute("PDF幅:", String.valueOf(width), "画像幅:", String.valueOf(image.getWidth()));
						LoggerUtil.execute("PDF高さ:", String.valueOf(height), "画像高さ:", String.valueOf(image.getHeight()));

						// 画像を描写.
						contentStream.drawImage(image,
								marginSum + blockWidthSum + j * image.getWidth() + charStartColumnPosition + topPosition
										- bottomPosition,
								height - index * (betweenLine + image.getHeight()) - image.getHeight()
										- charStartRowPosition + rightPosition - leftPosition);
					}
					blockWidthSum += blockWidth;
				}
				index++;
			}

			// ストリームを閉じる.
			contentStream.close();

			// ドキュメントを保存.
			document.save(Const.OUT_PATH);
			document.close();
			System.out.println("FINISH");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
