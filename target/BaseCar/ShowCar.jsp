<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="com.maistruk.basecar.Car"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Car</title>
<link rel="stylesheet" href="styles.css">
</head>
<body> 
   <%
    String userId =(String) request.getAttribute("userId");
    System.out.println(userId);
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
    <form action="ShowCar" method="post">
    <button type="submit" name="button1" class="showButton">Show all cars</button>
    <button type="submit" name="button2" class="showButton">Sort by name</button>
    <button type="submit" name="button3" class="showButton">Sort by year</button>

    <input type="hidden" name="userId" value="${userId}" escapeXml="false" /> 
    </form>

    <table class="showCarTabl">
    <tr><th>Car Name </th>
    <th >Car Model </th>
 <th >Car Engine</th>
 <th >Car Year</th></tr> 
    <%

    ArrayList<Car> array =(ArrayList<Car>) request.getAttribute("array");
    if(array == null || array.isEmpty()){
        
   }else{  
    for(Car c : array){               
        out.println("<tr><td >" + c.getCarName() +  "</td>");
        out.println("<td >" + c.getCarModel() +  "</td>");
        out.println("<td >" + c.getCarEngine() +  "</td>");
        out.println("<td >" + c.getCarYear() +  "</td></tr>");
    }

  System.out.println("asda");
    }
    %>
    </table>



</body>
</html>