<%@page import="java.util.Base64"%>
<%@page import="com.example.demo4.Images"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false" %> 
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
			<center><h2>Register</h2></center><br>
			<form action="/Second_Password" method="post">
				<table>
					<tr>
						<td><label>Full Name:</label></td>
						<td><input type="text" id="Full_Name" name="Full_Name" required/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input type="email" id="Email" name="Email" required/></td>
					</tr>
					<tr>
						<td><label>Phone Number:</label></td>
						<td><input type="number" id="Phone_Number" min="10" name="Phone_Number" required/></td>
					</tr>
					<tr>
						<td><label>Date of Birth:</label></td>
						<td><input type="date" id="Date_Of_Birth" name="Date_Of_Birth" required/></td>
					</tr>
					<tr>
						<td><label>Username:</label></td>
						<td><input type="text" id="Username" name="Username" required/></td>
					</tr>
					<tr>
						<td><label>First Password:</label></td>
						<td><input type="password" id="Password" name="Password" required/></td>
					</tr>
				</table><br>
				<div class="button-container">
				<input type="submit" value="Save and Exit" onclick="check()"/>
			</div>
			</form>
		</div>
	</div>
<script>
  var passwordInput = document.getElementById("Password");
  passwordInput.setCustomValidity("Password should contain at least 8 characters, one uppercase letter, one lowercase letter, one symbol, and one number");
  passwordInput.addEventListener("input", function(event) {
    var password = passwordInput.value;
    var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    if (regex.test(password)) {
      passwordInput.setCustomValidity("");
    }
  });
</script>
</body> 
</html>