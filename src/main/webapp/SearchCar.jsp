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
<title>Insert title here</title>
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
    
    <form action="SearchCar" method="post">
    <div class="searchCar">
        <label for="carSearch">Enter car name:  </label>
        <input type="text" name="carSearch" id="carSearch" class="inputSearch"/>
        <input type="submit" class="searchButton" name="searchCar" value="Search Car"/>
        <input type="hidden" name="userId" value="${userId}" escapeXml="false" /> 

        <%
    ArrayList<Car> array =(ArrayList<Car>) request.getAttribute("array1");
    if(array == null || array.isEmpty()){
        
    }else{
    out.println( "<table class=\"showCarTabl\">");
    out.println("<tr><th>Car Name </th>");
    out.println("<th >Car Model </th>");
    out.println("<th >Car Engine</th>");
    out.println("<th >Car Year</th></tr>");    
    for(Car c : array){               
        out.println("<tr><td >" + c.getCarName() +  "</td>");
        out.println("<td >" + c.getCarModel() +  "</td>");
        out.println("<td >" + c.getCarEngine() +  "</td>");
        out.println("<td >" + c.getCarYear() +  "</td></tr>");
    }
    out.println( "</table>");
    }
    %>
    
    
    </div>
    
    
    
    
    </form>

</body>
</html>