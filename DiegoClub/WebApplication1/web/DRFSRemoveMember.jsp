<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includeFiles/DRFSBanner.html"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<h1>Do you want to delete this member?</h1>

<form type="hidden" name="action" method="deleteMembers">
    <input type="hidden" name="action" value="deleteMembers">    
  
    
    <label>Email:</label>
    <input type="email" name="email" value="${member.emailAddress}" readonly><br><br>
       <label>Full Name:</label>
    <input type="text" name="fullName" value="${member.fullName}" readonly><br><br>
    <label>Phone:</label>
    <input type="phone" name="phone" value="${member.phoneNumber}" readonly><br><br>
    <label>IT Program:</label>
    <select name="program" value="${member.programName}" readonly>
        <option value="CAS">CAS</option>
        <option value="SQATE">SQATE</option>
        <option value="CPA">CPA</option>
        <option value="ITID" selected>ITID</option>
        <option value="CAD">CAD</option>
        <option value="ITSS">ITSS</option>
    </select><br><br>
        <label>Year Level:</label>
     <select name="yearLevel" value="${member.yearLevel}" readonly>
        <option value="1" selected>1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
     </select><br><br>

 
     <input type="submit" value="Yes" class="margin_left">
      
      <input type="reset" value="No" class="margin_left">
</form><br>



<c:import url="/includeFiles/DRFSFooter.jsp"/>
