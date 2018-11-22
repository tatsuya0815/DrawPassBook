package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

import beans.SentenceInputBean;
import beans.SheetInfoCtrlBean;
import constant.Const;
import utils.BufferdImageConvertUtil;
import utils.LoggerUtil;
import utils.PointCalcUtil;

public class CreatePdf {

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
		
		try{
			
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
			PDDocument document = new PDDocument();
			PDPage page = new PDPage(rectangle);
			
			// 横向き指定の場合は用紙を90°回転.
			if ("column".equals(sheetDirection)) {
				page.setRotation(90);
			}
			
			// 画像描画ストリームを生成.
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// //コンテンツを反時計回りに90度回転.
			if ("column".equals(sheetDirection)) {
				contentStream.transform(new Matrix(0, 1, -1, 0, page.getMediaBox().getWidth(), 0));
			}

			// 行数分ループ.
			int index = 0;
			// 出力高さ合計.
			int heightSum = 0;
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
				
				// 出力位置の寄せ方.
				ArrayList<String> charBlockPositionList = new ArrayList<>();
				charBlockPositionList.add(sentenceInputBean.getCharBlockPosition1());
				charBlockPositionList.add(sentenceInputBean.getCharBlockPosition2());
				charBlockPositionList.add(sentenceInputBean.getCharBlockPosition3());
				charBlockPositionList.add(sentenceInputBean.getCharBlockPosition4());
				charBlockPositionList.add(sentenceInputBean.getCharBlockPosition5());

				// PDFの高さ.(横向きの場合は幅=高さ)
				// PDFの幅.(横向きの場合は高さ=幅)
				int height = 0;
				int width = 0;
				if ("column".equals(sheetDirection)) {
					height = (int) Math.floor(rectangle.getWidth());
					width = (int) Math.floor(rectangle.getHeight());
				} else {
					height = (int) Math.floor(rectangle.getHeight());
					width = (int) Math.floor(rectangle.getWidth());
				}

				// 画像出力に使える範囲.
				int pictureArea = PointCalcUtil.pictureArea(width, charStartColumnPosition, blockMarginList);

				// 入力文字の編集.
				ArrayList<ArrayList<BufferedImage>> imageList = EditCharacter.execute(inputStringList,
						sentenceInputBean.getCharColor(), imagePath);
				
				// 画像幅Map.
				Map<Integer, Integer> widthMap = PointCalcUtil.widthSum(imageList);
				
				// 行内の画像の高さ最大値.
				int maxHeight = PointCalcUtil.maxHeight(imageList);
				
				// ブロック分ループ.
				for (int i = 0; i < imageList.size(); i++) {
					// マージン.
					int margin = blockMarginList.get(i);
					
					// 出力開始位置(初期値).
					int startPoint = pictureArea*i + charStartColumnPosition + margin;
					
					// 寄せの計算.				
					int X = PointCalcUtil.exportPoint(pictureArea, charBlockPositionList.get(i), widthMap.get(i));
					
					// 画像幅合計.
					int imageWidth = 0;
					
					// 要素(文字)の数だけループし、Pdfに描写.
					for (int j = 0; j < imageList.get(i).size(); j++) {
						
						// 画像オブジェクトを作成.
						PDImageXObject image = PDImageXObject.createFromByteArray(document,
								BufferdImageConvertUtil.getImageBytes(imageList.get(i).get(j), "png"), null);
						
						LoggerUtil.execute("PDF幅:", String.valueOf(width), "画像幅:" , String.valueOf(image.getWidth()));
						LoggerUtil.execute("PDF高さ:", String.valueOf(height), "画像高さ:" , String.valueOf(image.getHeight()));
						
						// 寄せを考慮した出力位置.
						int exportPoint = startPoint + X + imageWidth;
						
						// 画像を描写.
						contentStream.drawImage(image, exportPoint + rightPosition - leftPosition,
								height - index * betweenLine - (heightSum + maxHeight)
								- charStartRowPosition + topPosition - bottomPosition, image.getWidth(), image.getHeight());
					
						// 画像幅合計に今回出力した画像幅を加算.
						int imageWidthSum = imageWidth + image.getWidth();
						
						// 画像合計幅.
						imageWidth = imageWidthSum;
					}
				}
				index++;
				// 出力高さ合計に今回行の高さを加算.
				heightSum = maxHeight + heightSum;
			}
			
			// ストリームを閉じる.
			contentStream.close();

			// ドキュメントを保存.
			document.save(Const.OUT_PATH);
			document.close();
			LoggerUtil.execute("FINISH!　出力先：", Const.OUT_PATH, null, null);	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
