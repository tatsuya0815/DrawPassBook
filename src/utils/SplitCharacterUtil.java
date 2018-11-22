package utils;

import java.util.ArrayList;

public class SplitCharacterUtil {
	
	public static ArrayList<String[]> getSplitCharacter(ArrayList<String> inputStringList){
		
		ArrayList<String[]> splitStringList = new ArrayList<>();
		
		// 文字列を分割.
		for (String inputString : inputStringList) {
			// 出力文字の分割.
			LoggerUtil.execute("inputString:", inputString, null, null);
			String[] strArray = inputString.split("");
			splitStringList.add(strArray);
		}
		return splitStringList;
	}
}
