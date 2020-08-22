<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <div class="container">

            <img src="images/logo.png" alt="logo1" class="logo1" />

            <nav>
                <ul>
                    <li><a href="/BaseCar/Registration.jsp">Home</a></li>

                </ul>
            </nav>
            <form action="Registration" method="post" class="loginForm">
            <span class="inLogin">
            <label for="enterLogin">Enter login: </label>
            <input type="text" name="enterLogin" id="enterLogin">            
            </span>
            
            <span class="inPassword">
            <label for="enterPassword">Enter password: </label>
            <input type="password" name="enterPassword" id="enterPassword">
            <input type="submit" name="logInButton" id="loginBt" value="Login">
            </span>
            
            
            
            </form>
        </div>
    </header>


    <form action="Registration" method="post" class="regForm">
        <div class="regLogin, regDiv">
        <label for="regLogin" class="formFieldLabel">Enter login:</label><br/>
        <input type="text" name="regLogin" id="regLogin" class="formFielInput">
        <span class="regError">${messages.regLogin}</span>
        </div>
        
        <div class="regPassword, regDiv">
        <label for="regPassword" class="formFieldLabel">Enter password:</label><br/>
        <input type="text" name="regPassword" id="regPassword" class="formFielInput">
        <span class="regError"> ${messages.regPassword}</span>
        </div>
        
        <div class="regName, regDiv">
        <label for="regName" class="formFieldLabel">Enter name:</label><br/>
        <input type="text" name="regName" id="regName" class="formFielInput">
        <span class="regError"> ${messages.regName}</span>
        </div>
        
        <div class="regSurname, regDiv">
        <label for="regSurname" class="formFieldLabel">Enter surname:</label><br/>
        <input type="text" name="regSurname" id="regSurname" class="formFielInput">
        <span class="regError"> ${messages.regSurname}</span>
        </div>
        
        <div class="regYear, regDiv">
        <label for="regYear" class="formFieldLabel">Enter year:</label><br/>
        <input type="date" min="1910-01-02" max="2019-08-10" name="regYear" id="regYear" class="formFielInput">
        <span class="regError"> ${messages.regYear}</span>
        </div>
        
        <div class="regEmail, regDiv">
        <label for="regEmail" class="formFieldLabel">Enter email:</label><br/>
        <input type="email" name="regEmail" id="regEmail" class="formFielInput">
        <span class="regError"> ${messages.regEmail}</span>
        </div>
    
        <input type="submit" name="registrationButton" id="saveBt" value="Registration"/>
        ${registration}
    
    
    </form>








</body>
</html>