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
				<h2>Forget Password</h2>
			</center>
			<br>
			<form action="/ForgetPassword" method="post">
				<table>

					<tr>
						<td><label>Email</label></td>
						<td><input type="email" id="Email" name="Email"
							required /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Get OTP"
							style="float: right;" /></td>
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