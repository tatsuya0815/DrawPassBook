package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import utils.ColorChangeUtil;
import utils.SplitCharacterUtil;

public class EditCharacter {

	public static ArrayList<ArrayList<BufferedImage>> execute(ArrayList<String> inputStringList, String charColor, String imagePath)
			throws IOException {

		// テキストエリアごとに文字分割されたList.
		ArrayList<String[]> splitStringList = SplitCharacterUtil.getSplitCharacter(inputStringList);
		// 分割文字の配列保持のList.
		ArrayList<ArrayList<BufferedImage>> colorChangerImageList = new ArrayList<>();
		// テキストエリアごとの文字の色を変更.
		for (String[] splitString : splitStringList) {
			ArrayList<BufferedImage> bufferedImageList = ColorChangeUtil.getColorChangeImage(splitString, charColor, imagePath);
			colorChangerImageList.add(bufferedImageList);
		}
		// Listを返却.
		return colorChangerImageList;
	}
}