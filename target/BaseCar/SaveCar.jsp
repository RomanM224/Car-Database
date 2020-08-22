 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="ShowCar.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Car</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
    <%
 //   String userId =(String) request.getAttribute("userId");
 //   System.out.println(userId);
    %>
	<header>
		<div class="container">

			<img src="images/logo.png" alt="logo1" class="logo1" />

			<nav>
                <ul><li><form action="SaveCar" method="post">
                    <input type="submit" class="navButtton" value="Save Car" />
                    <input type="hidden" name="userId" value="${userId}" escapeXml="false" /> 
                    </form></li>
                    <li>
                    <form action="ShowCar" method="post">
                    <input type="submit" class="navButtton" value="Show Car" />
                    <input type="hidden" name="userId" value="${userId}" escapeXml="false" /> 
                    </form>
                    </li>
                    <li>
                    <form action="SearchCar" method="post">
                    <input type="submit" class="navButtton" value="Search Car" />
                    <input type="hidden" name="userId" value="${userId}" escapeXml="false" /> 
                    </form>
                    </li>
                    <li><a href="/BaseCar/Registration.jsp">Exit</a></li>
                </ul>
			</nav>
		</div>
	</header>

   

	<form action="SaveCar" method="post" class="cForm">
		<div class="carForm">
			<div class="lbBlock">
				<label for="carN" class="inputLb">Enter car name: </label> 
				<label for="carM" class="inputLb">Enter car Model: </label> 
				<label for="carE" class="inputLb">Enter engine capacity: </label> 
				<label for="carY" class="inputLb">Enter car year: </label>
			</div>

			<div class="inBlock">
				<input type="text" name="carName" id="carN" placeholder="Name"class="inputIn" /> 
				<input type="text" name="carModel" id="carM"placeholder="Model" maxLenght="50" class="inputIn" /> 
				<input type="text" name="carEngine" id="carE" placeholder="Engine" maxLenght="50" class="inputIn" /> 
				<input type="text"name="carYear" id="carY" placeholder="Year" maxLenght="50" class="inputIn" />
			</div>

			<div class="errorBlock">
				<span class="error"> ${messages1.carName}</span>
                   <span class="error"> ${messages1.carModel}</span>
                   <span class="error"> ${messages1.carEngine}</span>
                   <span class="error"> ${messages1.carYear}</span>

			</div>
			<input type="submit" id="saveBt" name="saveCar" value="Save Car" />
			 <input type="hidden" name="userId" value="${userId}" escapeXml="false" /> 
			${label}
		</div>
		
	</form>





















	<!--      <table border="2" align="left" class="tabl" width="600">
        <tr>
        <th>id</th><th>Car Name</th><th>Car Model</th><th>Engine</th><th>Year</th>
        </tr>
        
        <tr>
        <td></td><td></td><td></td><td></td><td></td>
        </tr>
    
            <tr>
        <td></td><td></td><td></td><td></td><td></td>
        </tr>
                <tr>
        <td></td><td></td><td></td><td></td><td></td>
        </tr>
                <tr>
        <td></td><td></td><td></td><td></td><td></td>
        </tr>
    
    </table>
    -->
</body>
</html>