package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ColorChangeUtil {
	public static ArrayList<BufferedImage> getColorChangeImage(String[] splitString, String charColor, String imagePath)
			throws IOException {

		ArrayList<BufferedImage> bufferedImageList = new ArrayList<>();

		// 画面で取得した色をセット.
		int r = Integer.parseInt(charColor.substring(1, 3), 16);
		LoggerUtil.execute("r:", String.valueOf(r), null, null);
		int g = Integer.parseInt(charColor.substring(3, 5), 16);
		LoggerUtil.execute("g:", String.valueOf(g), null, null);
		int b = Integer.parseInt(charColor.substring(5, 7), 16);
		LoggerUtil.execute("b:", String.valueOf(b), null, null);

		// 分割された文字の分だけ以下の処理を実行.
		for (int i = 0; i < splitString.length; i++) {

			// 入力された文字のチェック.
			String convert = ConvertUtil.convert(splitString[i]);
			LoggerUtil.execute("convertInputString:", convert, null, null);

			// 該当ファイルを開く.
			File filePath = new File(imagePath + convert + ".png");
			BufferedImage image = ImageIO.read(filePath);

			// 画像の高さ、幅を取得.
			int w = image.getWidth();
			int h = image.getHeight();

			BufferedImage write = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

			// ピクセルの色を取得.
			for (int y = 0; y < h; y++) {
				Color preColor = new Color(255,255,255);
				for (int x = 0; x < w; x++) {

					Color color = new Color(image.getRGB(x, y));
					int red = color.getRed();
					int green = color.getGreen();
					int blue = color.getBlue();

					// 取得した色を判定.
					if (red > 220 && preColor.getRed() > 240) {
						
						// 白~灰色の場合、色を白に.
						int rgb = ColorUtil.rgb(red, green, blue);
						write.setRGB(x, y, rgb);

					} else {

						// 黒であれば色変更.
						int rgb = ColorUtil.rgb(r, g, b);
						write.setRGB(x, y, rgb);
					}
					preColor = color;
				}
			}
			// 色を変更したimageをListに格納.
			bufferedImageList.add(write);
		}
		return bufferedImageList;
	}
}
