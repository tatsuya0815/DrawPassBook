package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SentenceInputBean;
import beans.SheetInfoCtrlBean;
import model.CreatePdf;
import utils.CheckParamUtil;
import utils.ViewPdfFileUtil;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(name = "sentence-input", urlPatterns = { "/sentence-input" })
public class SentenceInput extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String FROM_SHEET_INFO_CTRL = "1";
	private static final String FROM_SENTENCE_INPUT = "0";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SentenceInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文章入力画面の初期表示フラグ.
		String fromSheetInfoCtrlFlg = request.getParameter("from-sheet-info-ctrl");

		// 用紙情報管理画面の入力情報を取得.
		SheetInfoCtrlBean sheetInfoCtrlBean = new SheetInfoCtrlBean();
		sheetInfoCtrlBean.setImagePath(request.getParameter("imagePath"));
		sheetInfoCtrlBean.setSheetSize(request.getParameter("sheetSize"));
		sheetInfoCtrlBean.setSheetDirection(request.getParameter("sheetDirection"));
		sheetInfoCtrlBean.setCharStartRowPosition(request.getParameter("charStartRowPosition"));
		sheetInfoCtrlBean.setCharStartColumnPosition(request.getParameter("charStartColumnPosition"));
		sheetInfoCtrlBean.setBetweenLine(request.getParameter("betweenLine"));
		sheetInfoCtrlBean.setMaxLine(request.getParameter("maxLine"));

		// 用紙情報管理画面のパラメータをセット.
		request.setAttribute("sheetInfoCtrlBean", sheetInfoCtrlBean);

		// 用紙情報管理画面の入力情報中身チェック.
		CheckParamUtil.checkSheetInfoCtrlParam(sheetInfoCtrlBean);

		// 文章入力画面の入力情報.
		ArrayList<SentenceInputBean> sentenceInputBeanList = new ArrayList<>();

		// 文章入力画面からロジック到達した場合は以下処理を実施.
		if (FROM_SENTENCE_INPUT.equals(fromSheetInfoCtrlFlg)) {

			// 文章入力画面の入力情報を取得.
			for (int i = 1; i <= Integer.parseInt(sheetInfoCtrlBean.getMaxLine()); i++) {

				SentenceInputBean sentenceInputBean = new SentenceInputBean();
				sentenceInputBean.setCharColor(request.getParameter("char-color-" + i));
				sentenceInputBean.setLeftPosition(request.getParameter("left-position-" + i));
				sentenceInputBean.setRightPosition(request.getParameter("right-position-" + i));
				sentenceInputBean.setTopPosition(request.getParameter("top-position-" + i));
				sentenceInputBean.setBottomPosition(request.getParameter("bottom-position-" + i));
				sentenceInputBean.setCharBlockPosition1(request.getParameter("char-block-positioin-" + i + "-1"));
				sentenceInputBean.setCharBlockPosition2(request.getParameter("char-block-positioin-" + i + "-2"));
				sentenceInputBean.setCharBlockPosition3(request.getParameter("char-block-positioin-" + i + "-3"));
				sentenceInputBean.setCharBlockPosition4(request.getParameter("char-block-positioin-" + i + "-4"));
				sentenceInputBean.setCharBlockPosition5(request.getParameter("char-block-positioin-" + i + "-5"));
				sentenceInputBean.setInputTextArea1(request.getParameter("input-text-area-" + i + "-1"));
				sentenceInputBean.setInputTextArea2(request.getParameter("input-text-area-" + i + "-2"));
				sentenceInputBean.setInputTextArea3(request.getParameter("input-text-area-" + i + "-3"));
				sentenceInputBean.setInputTextArea4(request.getParameter("input-text-area-" + i + "-4"));
				sentenceInputBean.setInputTextArea5(request.getParameter("input-text-area-" + i + "-5"));
				sentenceInputBean.setBlockMargin1(request.getParameter("block-margin-" + i + "-1"));
				sentenceInputBean.setBlockMargin2(request.getParameter("block-margin-" + i + "-2"));
				sentenceInputBean.setBlockMargin3(request.getParameter("block-margin-" + i + "-3"));
				sentenceInputBean.setBlockMargin4(request.getParameter("block-margin-" + i + "-4"));
				sentenceInputBean.setBlockMargin5(request.getParameter("block-margin-" + i + "-5"));
				sentenceInputBean.setBlockMargin6(request.getParameter("block-margin-" + i + "-6"));

				// 入力画面の入力情報中身チェック.
				CheckParamUtil.checkSentenceInputParam(sentenceInputBean);

				sentenceInputBeanList.add(sentenceInputBean);
			}

			// PDF出力関数を呼出.
			CreatePdf.execute(sheetInfoCtrlBean, sentenceInputBeanList);

			// PDFのプレビュー.
			ViewPdfFileUtil.execute();
		}

		// 用紙情報管理画面からロジック到達した場合は以下処理を実施.
		if (FROM_SHEET_INFO_CTRL.equals(fromSheetInfoCtrlFlg)) {

			// 文章入力画面のパラメータ初期値セット.
			for (int i = 1; i <= Integer.parseInt(sheetInfoCtrlBean.getMaxLine()); i++) {
				sentenceInputBeanList.add(new SentenceInputBean("default"));
			}
		}

		// 文章入力画面のパラメータをセット.
		request.setAttribute("sentenceInputBeanList", sentenceInputBeanList);

		// 入力画面を表示.
		RequestDispatcher dispatch = request.getRequestDispatcher("/sentence-input.jsp");
		dispatch.forward(request, response);
	}

}
