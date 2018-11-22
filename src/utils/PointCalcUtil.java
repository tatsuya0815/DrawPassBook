package utils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

// 計算クラス.
public class PointCalcUtil {
	
	/** 文字位置：左寄せ */
	public final static String LEFT = "left";
		
	/** 文字位置：右寄せ */
	public final static String RIGHT = "right";
	
	/** 文字位置：中央寄せ */
	public final static String CENTER = "center";
	
		// 画像出力範囲.
		public static int pictureArea(int width, int charStartColumnPosition, ArrayList<Integer> blockMarginList) {
			// マージン.
			int margin = 0;
			for (int i = 0; i < blockMarginList.size(); i++) {
				// マージンと初期出力位置を合算.
				margin = charStartColumnPosition + blockMarginList.get(i);
				
			}
			// 上記で算出した値を幅から引き、5で割って1ブロックの幅を算出.
			int pictureArea = (int) Math.floor((width - margin)/5);
			return pictureArea;
		}
		
		// 出力でずらす数値を返却.
		public static int exportPoint(int pictureArea, String position, int imageWidth) {
			//　数値(初期値).
			int res = 0;
			// 文字寄せの方法によって返す数値を決定.
			switch (position) {
			case LEFT:
				res = 0;
				break;
			case RIGHT:
				int right = right(pictureArea, imageWidth);
				res = right;
				break;
			case CENTER:
				int center = center(pictureArea, imageWidth);
				res = center;
				break;
			}
			return res;
		}
		
		// 右寄せ計算.
		public static int right(int pictureArea, int imageWidth) {
			int right = pictureArea - imageWidth;
			// ずらす幅が負になった場合、0を返却.
			if (right < 0) {
				right = 0;
			}
			return right;
		}
		
		// 中央寄せ計算.
		public static int center(int pictureArea, int imageWidth) {
			int center = (pictureArea - imageWidth)/2;
			// ずらす幅が負になった場合、0を返却.
			if (center < 0) {
				center = 0;
			}
			return center;
		}
		
		// 画像幅の合計を返却
		public static Map<Integer, Integer> widthSum(ArrayList<ArrayList<BufferedImage>> imageList) {
			Map<Integer,Integer> widthMap = new LinkedHashMap<>();
			for (int j = 0; j < imageList.size(); j++) {	
				int imageWidth = 0;
				for(int i = 0; i < imageList.get(j).size(); i++) {
					int width = imageList.get(j).get(i).getWidth();
					int withSum = imageWidth + width;
					imageWidth = withSum;
					if (imageList.get(j).size() == i+1) {
						widthMap.put(j, withSum);
					}
				}
			}
			
			return widthMap;
			
		}
		
		// 画像高さの最大値を返却.
		public static int maxHeight(ArrayList<ArrayList<BufferedImage>> imageList) {
			int maxHeight = 0;
			for (int j = 0; j < imageList.size(); j++) {	
				int height = 0;
				for(int i = 0; i < imageList.get(j).size(); i++) {
					height = imageList.get(j).get(i).getHeight();
					
					if (height >= maxHeight) {
						maxHeight = height;
					}
				}
			}	
			return maxHeight;	
		}
		
}
