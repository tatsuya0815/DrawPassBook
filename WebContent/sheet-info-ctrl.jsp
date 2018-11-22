<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/sheetInfoCtrl.css">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script type="text/javascript" src="./js/sheetInfoCtrl.js"></script>
		<title>用紙情報管理画面</title>
	</head>
	<body>
		<h1>用紙情報管理画面</h1>
		<!-- 
		<div class="view-table" style="float:right">
			<table id="view-table" border="1" width="750" height="1000" cellspacing="0">
				<tr>
					<td class="top" colspan="3"></td>
				</tr>
				<tr class="main" id="main">
					<td class="left"></td>
					<td class="center"><p class="character">Hello World!</p></td>
					<td class="right"></td>
				</tr>
				<tr class="main">
					<td class="left"></td>
					<td class="center"></td>
					<td class="right"></td>
				</tr>
				<tr class="main">
					<td class="left"></td>
					<td class="center"></td>
					<td class="right"></td>
				</tr>
				<tr class="main">
					<td class="left"></td>
					<td class="center"></td>
					<td class="right"></td>
				</tr>
				<tr class="main">
					<td class="left"></td>
					<td class="center"></td>
					<td class="right"></td>
				</tr>
				<tr class="main">
					<td class="left"></td>
					<td class="center"></td>
					<td class="right"></td>
				</tr>
				<tr class="space">
					<td class="left"></td>
					<td class="center"></td>
					<td class="right"></td>
				</tr>
				<tr>
					<td class="bottom" colspan="3"></td>
				</tr>
			</table>
		</div>
		 -->
		<form method="post" id="formObject" action="sentence-input">
			<div class="setting-sheet-size">
				<label>用紙サイズ：</label>
				<select name="sheetSize">
					<option value="A0">A0</option>
					<option value="A1">A1</option>
					<option value="A2">A2</option>
					<option value="A3">A3</option>
					<option value="A4">A4</option>
					<option value="A5">A5</option>
					<option value="A6">A6</option>
				</select>
			</div>
			<div class="setting-sheet-direction">
				<label>用紙向き：</label>
				<select name="sheetDirection">
					<option value="row">縦</option>
					<option value="column">横</option>
				</select>
			</div>
			<div class="setting-char-start-row-position">
				<label>文字開始位置(縦)：</label>
				<input type="text" name="charStartRowPosition" size="2"><font size="1">px</font>
			</div>
			<div class="setting-char-start-column-position">
				<label>文字開始位置(横)：</label>
				<input type="text" name="charStartColumnPosition" size="2"><font size="1">px</font>
			</div>
			<div class="setting-between-line">
				<label>行間：</label>
				<input type="text" name="betweenLine" size="2"><font size="1">px</font>
			</div>
			<div class="setting-max-line">
				<label>最大行数：</label>
				<input type="text" name="maxLine" size="4">
			</div>
			<div class="setting-image-path">
				<label>読み込み画像パス：</label>
				<input type="text" name="imagePath" size="40">
			</div>
			
			<input type="hidden" name="from-sheet-info-ctrl" value="1">
			
			<div>
				<input type="submit" value="文章入力画面へ進む">
			</div>
		</form>
		
	</body>
</html>