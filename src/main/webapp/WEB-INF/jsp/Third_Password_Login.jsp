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


.image-grid {
	display: grid;
	grid-template-columns: repeat(9, 1fr);
	grid-template-rows: repeat(9, 1fr);
	gap: 10px;
}

.image {
	position: relative;
}

input[type="checkbox"] {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	opacity: 0;
	cursor: pointer;
}


input[type="checkbox"]:checked+label {
	border: 2px solid blue;
}

label {
	display: block;
	width: 100%;
	height: 100%;
	border: 2px solid transparent;
	transition: border-color 0.3s ease;
}
.image-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
}

.image {
  margin: 5px;
  position: relative;
}

img {
  display: block;
 width: 75px;
  height: 75px;
  object-fit: cover;
}

input[type="checkbox"] {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  opacity: 0;
  cursor: pointer;
}


</style>
</head>
<body bgcolor="#FFE833">
	<div class="container">
		<div>
			<center>
				<h2>Third Password</h2>
			</center>
			<br>
			 <% List<Images> images = (List<Images>) request.getAttribute("Images"); %>
			
			
			
			
			<form action="/Main_Page_Login" method="post" id="myForm">
				
				<div class="image-container">
					  <div class="image">
<input type="checkbox" name="image1" id="image1" value="<%= images.get(0).getImageName() %>">
<label for="image1"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(0).getImage())) %>" ></label>
</div>
<div class="image">
<input type="checkbox" name="image1" id="image2" value="<%= images.get(1).getImageName() %>">
<label for="image2"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(1).getImage())) %>" ></label>
</div>
<div class="image">
<input type="checkbox" name="image1" id="image3" value="<%= images.get(2).getImageName() %>">
<label for="image3"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(2).getImage())) %>" ></label>
</div>
					</div>
					
					
					
					
					<div class="image-container">
					  <div class="image">
<input type="checkbox" name="image1" id="image10" value="<%= images.get(9).getImageName() %>">
<label for="image10"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(9).getImage())) %>" ></label>
</div>
<div class="image">
<input type="checkbox" name="image1" id="image11" value="<%= images.get(10).getImageName() %>">
<label for="image11"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(10).getImage())) %>" ></label>
</div>
<div class="image">
<input type="checkbox" name="image1" id="image12" value="<%= images.get(11).getImageName() %>">
<label for="image12"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(11).getImage())) %>" ></label>
</div>
					</div>
					
					
						
					<div class="image-container">
					 <div class="image">
<input type="checkbox" name="image1" id="image19" value="<%= images.get(18).getImageName() %>">
<label for="image19"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(18).getImage())) %>" ></label>
</div>
<div class="image">
<input type="checkbox" name="image1" id="image20" value="<%= images.get(19).getImageName() %>">
<label for="image20"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(19).getImage())) %>" ></label>
</div>
<div class="image">
<input type="checkbox" name="image1" id="image21" value="<%= images.get(20).getImageName() %>">
<label for="image21"><img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(images.get(20).getImage())) %>" ></label>
</div>
</div>
				<br>
				<div class="button-container">
					<input type="submit" value="Save" />
				</div>
			</form>
		</div>
	</div>
	
	<script>
	
	const form = document.getElementById('myForm');

	form.addEventListener('submit', (event) => {
	  const checkboxes = document.querySelectorAll('input[type="checkbox"]');
	  let checkedCount = 0;
	  for (let i = 0; i < checkboxes.length; i++) {
	    if (checkboxes[i].checked) {
	      checkedCount++;
	    }
	  }
	  if (!(checkedCount == 3)) {
	    event.preventDefault();
	    alert('Please select no more than 3 checkboxes');
	  }
	});

	
	</script>

</body>
</html>