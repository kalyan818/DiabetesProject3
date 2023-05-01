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
			<form action="/Form" method="post">
			<center><label>Diabetes</label></center><br>
			<table>
			<tr>
			<td>
			<label>Date:</label>
			</td>
			 
			<td>
			<input type="date" id="Date" name="Date"/>
			</td>
			</tr>
			<tr>
			<td>
			<label>Time:</label>
			</td>
			
			<td>
			<input type="time" id="Time1" name="Time1"/>
			</td>
			</tr>
			<tr>
			<td>
			<label>BloodSugar Level</label>
			</td>
			
			<td>
			<input type="number" id="Sugar_Level1" name="Sugar_Level1" />
			</td>
			</tr>
			
			<tr>
			<td>
			<label>Time:</label>
			</td>
			
			<td>
			<input type="time" id="Time2" name="Time2"/>
			</td>
			</tr>
			<tr>
			<td>
			<label>BloodSugar Level</label>
			</td>
			
			<td>
			<input type="number" id="Sugar_Level2" name="Sugar_Level2"/>
			</td>
			</tr>
			
			
			
			<tr>
			<td>
			<label>Breakfast:</label>
			</td>
			
			<td>
			<input type="text" id="BreakFast" name="BreakFast"/>
			</td>
			</tr>
			
			<tr>
			<td>
			<label>Lunch:</label>
			</td>
			
			<td>
			<input type="text" id="Lunch" name="Lunch"/>
			</td>
			</tr>
			
			<tr>
			<td>
			<label>Dinner:</label>
			</td>
			
			<td>
			<input type="text" id="Dinner" name="Dinner"/>
			</td>
			</tr>
			</table>
			
			
			<input type="submit" value="Save and exit"/>
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