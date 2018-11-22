package utils;

import org.apache.commons.lang3.StringUtils;

import beans.SentenceInputBean;
import beans.SheetInfoCtrlBean;
import constant.Const;

public class CheckParamUtil {
	
	public static void checkSheetInfoCtrlParam(SheetInfoCtrlBean sheetInfoCtrlBean){
		
		// 文字開始位置(縦)のチェック.
		if (StringUtils.isEmpty(sheetInfoCtrlBean.getCharStartRowPosition())) {
			sheetInfoCtrlBean.setCharStartRowPosition("0");
		}
		
		// 文字開始位置(横)のチェック.
		if (StringUtils.isEmpty(sheetInfoCtrlBean.getCharStartColumnPosition())) {
			sheetInfoCtrlBean.setCharStartColumnPosition("0");
		}
		
		// 行間チェック.
		if(StringUtils.isEmpty(sheetInfoCtrlBean.getBetweenLine())){
			sheetInfoCtrlBean.setBetweenLine("0");
		}
		
		// 最大行数チェック.
		if(StringUtils.isEmpty(sheetInfoCtrlBean.getMaxLine())){
			sheetInfoCtrlBean.setMaxLine("1");
		}
		
		// 読み込み画像パスチェック.
		if(StringUtils.isEmpty(sheetInfoCtrlBean.getImagePath())){
			sheetInfoCtrlBean.setImagePath(Const.IN_PATH);
			System.out.println("IN_PATH: " + Const.IN_PATH);
		}
	}
	
	public static void checkSentenceInputParam(SentenceInputBean sentenceInputBean){
		
		// 行毎の文字位置チェック.
		if (StringUtils.isEmpty(sentenceInputBean.getTopPosition())) {
			sentenceInputBean.setTopPosition("0");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getBottomPosition())) {
			sentenceInputBean.setBottomPosition("0");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getRightPosition())) {
			sentenceInputBean.setRightPosition("0");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getLeftPosition())) {
			sentenceInputBean.setLeftPosition("0");
		}
		
		// 入力文字チェック.
		if (StringUtils.isEmpty(sentenceInputBean.getInputTextArea1())) {
			sentenceInputBean.setInputTextArea1(" ");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getInputTextArea2())) {
			sentenceInputBean.setInputTextArea2(" ");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getInputTextArea3())) {
			sentenceInputBean.setInputTextArea3(" ");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getInputTextArea4())) {
			sentenceInputBean.setInputTextArea4(" ");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getInputTextArea5())) {
			sentenceInputBean.setInputTextArea5(" ");
		}
		
		// マージンチェック.
		if (StringUtils.isEmpty(sentenceInputBean.getBlockMargin1())) {
			sentenceInputBean.setBlockMargin1("0");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getBlockMargin2())) {
			sentenceInputBean.setBlockMargin2("0");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getBlockMargin3())) {
			sentenceInputBean.setBlockMargin3("0");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getBlockMargin4())) {
			sentenceInputBean.setBlockMargin4("0");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getBlockMargin5())) {
			sentenceInputBean.setBlockMargin5("0");
		}
		if (StringUtils.isEmpty(sentenceInputBean.getBlockMargin6())) {
			sentenceInputBean.setBlockMargin6("0");
		}
	}
}
