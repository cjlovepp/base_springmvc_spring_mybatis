<%@ page contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
	<%@ include file="../common/meta.jsp"%>
	<link rel="stylesheet" type="text/css" href="${ctx}/public/easyui/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/public/easyui/themes/icon.css">
	<script type="text/javascript" src="${ctx}/public/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/public/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	${helloWorld}
</body>
<script type="text/javascript">
(function(){
	var msg = "${helloWorld}";
	var realName = "${user.realName}";
	$.messager.show({
		width:300,
		height:200,
		title:"提示",
		msg:"欢迎！"
	});
	$.messager.alert('提示',"您好："+realName,'info');
})();
</script>
</html>
