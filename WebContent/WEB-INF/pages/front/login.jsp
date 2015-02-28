<%@ page contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
	
</head>
<body>
	<div class="containerLogin">
		<div class="login">
			<div class="loginInner">
				<form id="loginForm">
					<div class="placeholderWaper">
						<label for="user">用户名</label>
						<input type="text" value="" name="username" id="user" placeholder="用户名" maxlength="20" needcheck nullmsg="请输入用户名！" limit="6,20" limitmsg="登录名或密码错误" reg="${userIdReg}" errormsg="登录名或密码错误" autocomplete="off" />
					</div>
					<div  class="placeholderWaper">
						<label for="password">密码</label>
						<input type="password" value="" type="password" name="password" id="password" placeholder="密码" needcheck nullmsg="请输入密码！" limit="6,18" limitmsg="登录名或密码错误" autocomplete="off" />
					</div>
					<input type="submit" class="loginBtn" value="登录" />
				</form>
			</div>
		</div>
	</div>
	<script>
	
	</script>
</body>
</html>