<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/sentenceInput.css">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script type="text/javascript" src="./js/sentenceInput.js"></script>
		<title>文章入力画面</title>
	</head>
	<body>
		<h1>文章入力画面</h1>

		<form method="post" action="sentence-input">
			
			<c:forEach var="i" begin="1" end="${sheetInfoCtrlBean.maxLine}" step="1">
			
				<!-- 一旦消す 
				<div class="setting-char-color-density">
					<label>色濃度:</label>
					<input type="range" name="char-color-density">
				</div>
				-->
				<div class="line-number">
					<h2>${i}行目:</h2>
				</div>
				<div class="setting-char-color">
					<label>文字カラー:</label>
					<input type="color" value="${sentenceInputBeanList[i-1].charColor}" name="char-color-${i}">
				</div>
				<div class="setting-char-position">
					<label>文字位置の調整:</label>
					<label>左</label>
					<input type="text" value="${sentenceInputBeanList[i-1].leftPosition}" name="left-position-${i}" size="2"><font size="1">px</font>
					<label>右</label>
					<input type="text" value="${sentenceInputBeanList[i-1].rightPosition}" name="right-position-${i}" size="2"><font size="1">px</font>
					<label>上</label>
					<input type="text" value="${sentenceInputBeanList[i-1].topPosition}" name="top-position-${i}" size="2"><font size="1">px</font>
					<label>下</label>
					<input type="text" value="${sentenceInputBeanList[i-1].bottomPosition}" name="bottom-position-${i}" size="2"><font size="1">px</font>
				</div>
				<div style="float:left" class="input-text-area-1">
					<label style="float:left">エリア1　</label>
					<span class="segmented">
				    	<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition1 == 'left'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="left" checked><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition1 == 'center'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="center" checked><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition1 == 'right'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-1" value="right" checked><span class="label">右</span></label>
						</c:if>
				  	</span><br>
				</div>
				<div style="float:left" class="input-text-area-2">
					<label style="float:left">エリア2　</label>
					<span class="segmented">
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition2 == 'left'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="left" checked><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition2 == 'center'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="center" checked><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition2 == 'right'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-2" value="right" checked><span class="label">右</span></label>
						</c:if>
				  	</span><br>
				</div>
				<div style="float:left" class="input-text-area-3">
					<label style="float:left">エリア3　</label>
					<span class="segmented">
				    	<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition3 == 'left'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="left" checked><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition3 == 'center'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="center" checked><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition3 == 'right'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-3" value="right" checked><span class="label">右</span></label>
						</c:if>
				  	</span><br>
				</div>
				<div style="float:left" class="input-text-area-4">
					<label style="float:left">エリア4　</label>
					<span class="segmented">
				    	<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition4 == 'left'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="left" checked><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition4 == 'center'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="center" checked><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition4 == 'right'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-4" value="right" checked><span class="label">右</span></label>
						</c:if>
				  	</span><br>
				</div>
				<div style="float:left" class="input-text-area-5">
					<label style="float:left">エリア5　</label>
					<span class="segmented">
				    	<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition5 == 'left'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="left" checked><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition5 == 'center'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="center" checked><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="right"><span class="label">右</span></label>
						</c:if>
						<c:if test = "${sentenceInputBeanList[i-1].charBlockPosition5 == 'right'}">
							<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="left"><span class="label">左</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="center"><span class="label">中央</span></label>
					    	<label><input type="radio" class="radio" name="char-block-positioin-${i}-5" value="right" checked><span class="label">右</span></label>
						</c:if>
				  	</span><br>
				</div>
				<div class="view-message" style="clear:left">
					<table>
						<tr>
							<td class="setting-margin">
								<img border="0" src="./image/margin_icon.png" width="45" height="10" alt="margin_icon" style="float:left"><br>
								<input type="text" value="${sentenceInputBeanList[i-1].blockMargin1}" name="block-margin-${i}-1" size="2"><font size="1">px</font>
								<input type="text" value="${sentenceInputBeanList[i-1].inputTextArea1}" name="input-text-area-${i}-1" size="20">
							</td>
							<td class="setting-margin">
								<img border="0" src="./image/margin_icon.png" width="45" height="10" alt="margin_icon" style="float:left"><br>
								<input type="text" value="${sentenceInputBeanList[i-1].blockMargin2}" name="block-margin-${i}-2" size="2"><font size="1">px</font>
								<input type="text" value="${sentenceInputBeanList[i-1].inputTextArea2}" name="input-text-area-${i}-2" size="20">
							</td>
							<td class="setting-margin">
								<img border="0" src="./image/margin_icon.png" width="45" height="10" alt="margin_icon" style="float:left"><br>
								<input type="text" value="${sentenceInputBeanList[i-1].blockMargin3}" name="block-margin-${i}-3" size="2"><font size="1">px</font>
								<input type="text" value="${sentenceInputBeanList[i-1].inputTextArea3}" name="input-text-area-${i}-3" size="20">
							</td>
							<td class="setting-margin">
								<img border="0" src="./image/margin_icon.png" width="45" height="10" alt="margin_icon" style="float:left"><br>
								<input type="text" value="${sentenceInputBeanList[i-1].blockMargin4}" name="block-margin-${i}-4" size="2"><font size="1">px</font>
								<input type="text" value="${sentenceInputBeanList[i-1].inputTextArea4}" name="input-text-area-${i}-4" size="20">
							</td>
							<td class="setting-margin">
								<img border="0" src="./image/margin_icon.png" width="45" height="10" alt="margin_icon" style="float:left"><br>
								<input type="text" value="${sentenceInputBeanList[i-1].blockMargin5}" name="block-margin-${i}-5" size="2"><font size="1">px</font>
								<input type="text" value="${sentenceInputBeanList[i-1].inputTextArea5}" name="input-text-area-${i}-5" size="20">
							</td>
							<!-- <td class="setting-margin">
								<img border="0" src="./image/margin_icon.png" width="45" height="10" alt="margin_icon"><br>
								<input type="text" value="${sentenceInputBeanList[i-1].blockMargin6}" name="block-margin-${i}-6" size="2"><font size="1">px</font>
							</td>
							 -->
						</tr>
					</table>
				</div>
			</c:forEach>
				<input type="hidden" name="imagePath" value="${sheetInfoCtrlBean.imagePath}">
				<input type="hidden" name="sheetSize" value="${sheetInfoCtrlBean.sheetSize}">
				<input type="hidden" name="sheetDirection" value="${sheetInfoCtrlBean.sheetDirection}">
				<input type="hidden" name="charStartRowPosition" value="${sheetInfoCtrlBean.charStartRowPosition}">
				<input type="hidden" name="charStartColumnPosition" value="${sheetInfoCtrlBean.charStartColumnPosition}">
				<input type="hidden" name="betweenLine" value="${sheetInfoCtrlBean.betweenLine}">
				<input type="hidden" name="maxLine" value="${sheetInfoCtrlBean.maxLine}">
				<input type="hidden" name="from-sheet-info-ctrl" value="0">
				
				<div class="pdf-output-button">
					<input type="submit" value="PDF出力"> 
				</div>
		</form>
	</body>
</html>