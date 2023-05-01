<%@page import="com.example.demo4.Login"%>
<%@page import="com.example.demo4.FormModel"%>
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
			<center><h2>Welcome</h2></center><br>
			<div class="button-container">
				<a href="/Form"><input type="button" value="Add Data+"/></a>
			</div>
			<form action="/Second_Password" method="post">
				 <table class="my-table">
        <thead>
            <tr>
                <th>UserName</th>
                <th>Date</th>
                <th>Time</th>
                <th>BloodLevel</th>
                <th>Breakfast</th>
                <th>Lunch</th>
                <th>Dinner</th>
                <th>Time</th>
                <th>BloodLevel</th>
            </tr>
        </thead>
        <tbody>
        <% 
            List<FormModel> Details = (List<FormModel>) request.getAttribute("Details");
        	Login login = (Login) request.getAttribute("Login");
            for (FormModel data : Details) {
            %>
            <tr>
                <td><%= login.getUsername()%></td>
                <td><%= data.getDate() %></td>
                <td><%= data.getTime1()%></td>
                <td><%= data.getSugar_Level1()%></td>
                <td><%= data.getBreakFast()%></td>
                <td><%= data.getLunch() %></td>
                <td><%= data.getDinner()%></td>
                <td><%= data.getTime2()%></td>
                <td><%= data.getSugar_Level2()%></td>
            </tr>
            <% } %>
            </tbody>
    </table><br>
			</form>
		</div>
	</div>
</body> 
</html>