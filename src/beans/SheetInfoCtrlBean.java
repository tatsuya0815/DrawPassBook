package beans;

public class SheetInfoCtrlBean {
	/** 読み込み画像パス */
	private String imagePath;
	/** 用紙サイズ */
	private String sheetSize;
	/** 用紙の向き */
	private String sheetDirection;
	/** 文字開始位置(縦) */
	private String charStartRowPosition;
	/** 文字開始位置(横) */
	private String charStartColumnPosition;
	/** 行間 */
	private String betweenLine;
	/** 最大行数 */
	private String maxLine;
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getSheetSize() {
		return sheetSize;
	}
	public void setSheetSize(String sheetSize) {
		this.sheetSize = sheetSize;
	}
	public String getSheetDirection() {
		return sheetDirection;
	}
	public void setSheetDirection(String sheetDirection) {
		this.sheetDirection = sheetDirection;
	}
	public String getCharStartRowPosition() {
		return charStartRowPosition;
	}
	public void setCharStartRowPosition(String charStartRowPosition) {
		this.charStartRowPosition = charStartRowPosition;
	}
	public String getCharStartColumnPosition() {
		return charStartColumnPosition;
	}
	public void setCharStartColumnPosition(String charStartColumnPosition) {
		this.charStartColumnPosition = charStartColumnPosition;
	}
	public String getBetweenLine() {
		return betweenLine;
	}
	public void setBetweenLine(String betweenLine) {
		this.betweenLine = betweenLine;
	}
	public String getMaxLine() {
		return maxLine;
	}
	public void setMaxLine(String maxLine) {
		this.maxLine = maxLine;
	}
}
