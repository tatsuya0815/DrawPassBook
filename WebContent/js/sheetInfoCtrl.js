//window.onload = function () {
//	getValue();
//	var $formObject = document.getElementById("formObject");
//	for( var $i = 0; $i < $formObject.length; $i++ ) {
//		$formObject.elements[$i].onkeyup = function(){
//			getValue();
//		};
//		$formObject.elements[$i].onchange = function(){
//			getValue();
//		};
//	}
//}
//	
//function getValue() {
//	
//	var $formObject = document.getElementById("formObject");
//	
//	var rows = document.getElementById("view-table").rows;
//	var column = document.getElementById("view-table").columns;
//	//var cell = rows[row].cells[column];
//	//cell.style.textAlign = "center";
//	
//	// tableの大きさ
//	document.getElementById("view-table").style.width = "500px";
//	document.getElementById("view-table").style.height = "400px";
//	
//	// 要素追加
//	var mainTr = document.getElementById('main');
//	for (i = 0; i < 10; i++){
//        //tr エレメントを新規作成(ただ生成するだけ)
//        var tr = document.createElement('tr');
//        //列(td)用のループ
//        for (j = 0; j < 3; j++){
//            //tdエレメントを生成
//            var td = document.createElement('td');
//            //tdの中に入れたいモノをセット
//            td.innerHTML = 'こんにちは' + j;
//            //生成したtdをtrにセット
//            tr.appendChild(td);
//        }//列用のループ閉じ
//        //tr エレメントをtbody内に追加(ここではじめて表示される)
//        tbody.appendChild(tr);
//    }//行用のループ閉じ
//
//	
//	
//	document.getElementById("test1").innerHTML = $formObject.sheetSize.value;
//	document.getElementById("test2").innerHTML = $formObject.sheetDirection.value;
//	document.getElementById("test3").innerHTML = $formObject.charStartRowPosition.value;
//	document.getElementById("test4").innerHTML = $formObject.charStartColumnPosition.value;
//	document.getElementById("test5").innerHTML = $formObject.betweenLine.value;
//	document.getElementById("test6").innerHTML = $formObject.maxLine.value;
//}