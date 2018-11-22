package beans;

public class SentenceInputBean {
	/** 文字カラー */
	private String charColor;
	/** 文字位置調整：左 */
	private String leftPosition;
	/** 文字位置調整：右 */
	private String rightPosition;
	/** 文字位置調整：上 */
	private String topPosition;
	/** 文字位置調整：下 */
	private String bottomPosition;
	/** エリア1：位置 */
	private String charBlockPosition1;
	/** エリア2：位置 */
	private String charBlockPosition2;
	/** エリア3：位置 */
	private String charBlockPosition3;
	/** エリア4：位置 */
	private String charBlockPosition4;
	/** エリア5：位置 */
	private String charBlockPosition5;
	/** エリア1：文字 */
	private String inputTextArea1;
	/** エリア2：文字 */
	private String inputTextArea2;
	/** エリア3：文字 */
	private String inputTextArea3;
	/** エリア4：文字 */
	private String inputTextArea4;
	/** エリア5：文字 */
	private String inputTextArea5;
	/** ブロックマージン1 */
	private String blockMargin1;
	/** ブロックマージン2 */
	private String blockMargin2;
	/** ブロックマージン3 */
	private String blockMargin3;
	/** ブロックマージン4 */
	private String blockMargin4;
	/** ブロックマージン5 */
	private String blockMargin5;
	/** ブロックマージン6 */
	private String blockMargin6;

	public SentenceInputBean(String defaultConstructor) {
		charColor = "#010101";
		leftPosition = "";
		rightPosition = "";
		topPosition = "";
		bottomPosition = "";
		charBlockPosition1 = "left";
		charBlockPosition2 = "left";
		charBlockPosition3 = "left";
		charBlockPosition4 = "left";
		charBlockPosition5 = "left";
		inputTextArea1 = "";
		inputTextArea2 = "";
		inputTextArea3 = "";
		inputTextArea4 = "";
		inputTextArea5 = "";
		blockMargin1 = "";
		blockMargin2 = "";
		blockMargin3 = "";
		blockMargin4 = "";
		blockMargin5 = "";
		blockMargin6 = "";
	}
	
	public SentenceInputBean() {
		charColor = null;
		leftPosition = null;
		rightPosition = null;
		topPosition = null;
		bottomPosition = null;
		charBlockPosition1 = null;
		charBlockPosition2 = null;
		charBlockPosition3 = null;
		charBlockPosition4 = null;
		charBlockPosition5 = null;
		inputTextArea1 = null;
		inputTextArea2 = null;
		inputTextArea3 = null;
		inputTextArea4 = null;
		inputTextArea5 = null;
		blockMargin1 = null;
		blockMargin2 = null;
		blockMargin3 = null;
		blockMargin4 = null;
		blockMargin5 = null;
		blockMargin6 = null;
	}

	public String getCharColor() {
		return charColor;
	}

	public void setCharColor(String charColor) {
		this.charColor = charColor;
	}

	public String getLeftPosition() {
		return leftPosition;
	}

	public void setLeftPosition(String leftPosition) {
		this.leftPosition = leftPosition;
	}

	public String getRightPosition() {
		return rightPosition;
	}

	public void setRightPosition(String rightPosition) {
		this.rightPosition = rightPosition;
	}

	public String getTopPosition() {
		return topPosition;
	}

	public void setTopPosition(String topPosition) {
		this.topPosition = topPosition;
	}

	public String getBottomPosition() {
		return bottomPosition;
	}

	public void setBottomPosition(String bottomPosition) {
		this.bottomPosition = bottomPosition;
	}

	public String getCharBlockPosition1() {
		return charBlockPosition1;
	}

	public void setCharBlockPosition1(String charBlockPosition1) {
		this.charBlockPosition1 = charBlockPosition1;
	}

	public String getCharBlockPosition2() {
		return charBlockPosition2;
	}

	public void setCharBlockPosition2(String charBlockPosition2) {
		this.charBlockPosition2 = charBlockPosition2;
	}

	public String getCharBlockPosition3() {
		return charBlockPosition3;
	}

	public void setCharBlockPosition3(String charBlockPosition3) {
		this.charBlockPosition3 = charBlockPosition3;
	}

	public String getCharBlockPosition4() {
		return charBlockPosition4;
	}

	public void setCharBlockPosition4(String charBlockPosition4) {
		this.charBlockPosition4 = charBlockPosition4;
	}

	public String getCharBlockPosition5() {
		return charBlockPosition5;
	}

	public void setCharBlockPosition5(String charBlockPosition5) {
		this.charBlockPosition5 = charBlockPosition5;
	}

	public String getInputTextArea1() {
		return inputTextArea1;
	}

	public void setInputTextArea1(String inputTextArea1) {
		this.inputTextArea1 = inputTextArea1;
	}

	public String getInputTextArea2() {
		return inputTextArea2;
	}

	public void setInputTextArea2(String inputTextArea2) {
		this.inputTextArea2 = inputTextArea2;
	}

	public String getInputTextArea3() {
		return inputTextArea3;
	}

	public void setInputTextArea3(String inputTextArea3) {
		this.inputTextArea3 = inputTextArea3;
	}

	public String getInputTextArea4() {
		return inputTextArea4;
	}

	public void setInputTextArea4(String inputTextArea4) {
		this.inputTextArea4 = inputTextArea4;
	}

	public String getInputTextArea5() {
		return inputTextArea5;
	}

	public void setInputTextArea5(String inputTextArea5) {
		this.inputTextArea5 = inputTextArea5;
	}

	public String getBlockMargin1() {
		return blockMargin1;
	}

	public void setBlockMargin1(String blockMargin1) {
		this.blockMargin1 = blockMargin1;
	}

	public String getBlockMargin2() {
		return blockMargin2;
	}

	public void setBlockMargin2(String blockMargin2) {
		this.blockMargin2 = blockMargin2;
	}

	public String getBlockMargin3() {
		return blockMargin3;
	}

	public void setBlockMargin3(String blockMargin3) {
		this.blockMargin3 = blockMargin3;
	}

	public String getBlockMargin4() {
		return blockMargin4;
	}

	public void setBlockMargin4(String blockMargin4) {
		this.blockMargin4 = blockMargin4;
	}

	public String getBlockMargin5() {
		return blockMargin5;
	}

	public void setBlockMargin5(String blockMargin5) {
		this.blockMargin5 = blockMargin5;
	}

	public String getBlockMargin6() {
		return blockMargin6;
	}

	public void setBlockMargin6(String blockMargin6) {
		this.blockMargin6 = blockMargin6;
	}
}
