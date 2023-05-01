<%@page import="java.util.Base64"%>
<%@page import="com.example.demo4.Images"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>
<html>
<head>
<style>
.container {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

</style>
</head>
<body bgcolor="#FFE833">
	<div class="container">
		<div>
			<center>
				<label><h2 style="color: red;">${message}</h2></label>
			</center>
			<center>
				<h2>Login</h2>
			</center>
			<br>
			<form action="/Second_Password_Login" method="post">
				<table>

					<tr>
						<td><label>Username:</label></td>
						<td><input type="text" id="Username" name="Username" required /></td>
					</tr>
					<tr>
						<td><label>First Password:</label></td>
						<td><input type="password" id="Password" name="Password"
							required /></td>
					</tr>
					<tr>
						<td><a href="/ForgetPassword">Forget Password?</a></td>
						<td><input type="submit" value="Login"
							style="float: right;" /></td>
					</tr>
					<tr>
						<td><a href="/Register">create new account</a></td>
					
					</tr>
				</table>
				<br>

			</form>
		</div>
	</div>
	<script>
		var passwordInput = document.getElementById("Password");
		passwordInput
				.setCustomValidity("Password should contain at least 8 characters, one uppercase letter, one lowercase letter, one symbol, and one number");
		passwordInput
				.addEventListener(
						"input",
						function(event) {
							var password = passwordInput.value;
							var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
							if (regex.test(password)) {
								passwordInput.setCustomValidity("");
							}
						});
	</script>
</body>

</html>