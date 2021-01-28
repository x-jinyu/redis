window.onload = main;

//监听事件绑定
function main() {
    //1.获得页面中所有的input标签
    var domArray = document.getElementsByTagName("input");
    //2.为标题行checkbox绑定fun1
    domArray[0].onclick = fun1;
    //3.为数据行所有checkbox绑定fun2
    for (var i = 1; i < domArray.length; i++) {
        var dom = domArray[i];
        dom.onclick = fun2;
    }
    //1.获得所有的tr标签关联的DOM
    domArray = document.getElementsByTagName("tr");

    //2.为数据行指定onmouseover/onmouseout关联处理函数
    for (var i = 1; i < domArray.length; i++) {
        var trDom = domArray[i];
        trDom.onmouseover = fun3;
        trDom.onmouseout = fun4;
    }

    //---------基于DOM对象绑定处理函数----------------
}

//全选与全不选--标题行控制数据行
function fun1() {
    //1.定位所有input标签
    var domArray = document.getElementsByTagName("input");
    //2.读取第一个checkbox的【checked状态属性值】
    var dom = domArray[0];
    var flag = dom.checked;
    //3.对数据行中所有checkbox的【checked状态属性值】统一赋值
    for (var i = 1; i < domArray.length; i++) {
        dom = domArray[i];
        dom.checked = flag;
    }
    fun5()
}

//全选与全不选--标题行数据行控制标题行
function fun2() {
    //1.获得数据行所有checkbox个数
    var domArray = document.getElementsByTagName("input");

    //2.获得数据行被选中的checkbox个数
    var checkedNum = 0;
    for (var i = 1; i < domArray.length; i++) {
        var dom = domArray[i];
        if (dom.checked) {
            checkedNum++;
        }
    }

    //3.判断标题行checkbox的选中状态
    if (checkedNum == domArray.length - 1) {
        domArray[0].checked = true;
    } else {
        domArray[0].checked = false;
    }
    fun5()
}

function fun3() {
    //将[鼠标悬停的数据行]背景颜色设置为红色
    this.style.backgroundColor = "black";
    this.style.color = "white";

}

function fun4() {
    //将[鼠标离开的数据行]背景颜色设置为白色
    this.style.backgroundColor = "white";
    this.style.color = "black";
}

//判断【批处理按钮是否可用】
function fun5() {
    var domArray = document.getElementsByName("empNo");
    var sum = 0;
    for (var i = 0; i < domArray.length; i++) {
        var dom = domArray[i];
        if (dom.checked == true) {
            sum++;
        }
    }
    if (sum == 0) {
        document.getElementById("delete").disabled=true;//不可用
    }else {
        document.getElementById("delete").disabled=false;//可用
    }

}