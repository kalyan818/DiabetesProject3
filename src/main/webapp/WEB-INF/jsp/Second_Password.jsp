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
				<h2>Second Password</h2>
			</center>
			<br>
			<form action="/Third_Password" method="post">
				<table>
					<tr>
						<td><select name="Question1"
							id="Question1"
							class="password-select">
								<option
						value="What is the name of a college you applied to but didnt attend?">
						What is the name of a college you applied to but didnt attend?</option>
					<option
						value="What was the name of the first school you remember attending?">
						What was the name of the first school you remember attending?</option>
					<option
						value="Where was the destination of your most memorable school field trip?">
						Where was the destination of your most memorable school field trip?</option>
					<option
						value="What was your maths teachers surname in your 8th year of school?">
						What was your maths teachers surname in your 8th year of school?</option>
					<option
						value="What was the name of your first stuffed toy?">
						What was the name of your first stuffed toy?</option>
					<option
						value="What was your driving instructors first name?">
						What was your driving instructors first name?</option>
						</select>
						</td>
						</tr>
						<tr>
						<td><input type="text" id="Answer1"
							name="Answer1" required="required" /></td>
					</tr>
							<tr>
						<td><select name="Question2"
							id="Question2"
							class="password-select">
								<option
						value="What is the name of a college you applied to but didnt attend?">
						What is the name of a college you applied to but didnt attend?</option>
					<option
						value="What was the name of the first school you remember attending?">
						What was the name of the first school you remember attending?</option>
					<option
						value="Where was the destination of your most memorable school field trip?">
						Where was the destination of your most memorable school field trip?</option>
					<option
						value="What was your maths teachers surname in your 8th year of school?">
						What was your maths teachers surname in your 8th year of school?</option>
					<option
						value="What was the name of your first stuffed toy?">
						What was the name of your first stuffed toy?</option>
					<option
						value="What was your driving instructors first name?">
						What was your driving instructors first name?</option>
						</select>
						</td>
						</tr>
						<tr>
						<td><input type="text" id="Answer2"
							name="Answer2" required="required" /></td>
					</tr>
							<tr>
						<td><select name="Question3"
							id="Question3"
							class="password-select">
								<option
						value="What is the name of a college you applied to but didnt attend?">
						What is the name of a college you applied to but didnt attend?</option>
					<option
						value="What was the name of the first school you remember attending?">
						What was the name of the first school you remember attending?</option>
					<option
						value="Where was the destination of your most memorable school field trip?">
						Where was the destination of your most memorable school field trip?</option>
					<option
						value="What was your maths teachers surname in your 8th year of school?">
						What was your maths teachers surname in your 8th year of school?</option>
					<option
						value="What was the name of your first stuffed toy?">
						What was the name of your first stuffed toy?</option>
					<option
						value="What was your driving instructors first name?">
						What was your driving instructors first name?</option>
						</select>
						</td>
						</tr>
						<tr>
						<td><input type="text" id="Answer3"
							name="Answer3" required="required" /></td>
					</tr>
				</table>
				<br>
				<div class="button-container">
					<input type="submit" value="Save"/>
				</div>
			</form>
		</div>
	</div>

</body>
</html>