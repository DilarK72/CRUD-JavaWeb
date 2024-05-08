<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includeFiles/DRFSBanner.html"/>

<strong><h2>New Member Registration Form</h2></strong>
 
  <p><i>${errorMessage}</i></p>
<form action="registration" method="post">
    
    <input type="hidden" name="action" value="add">
    
    <label>Full Name:</label>
    <input type="text" name="fullName" value="${user.fullName}" required><br><br>
    <label>Email:</label>
    <input type="email" name="email" value="${user.email}" required><br><br>
    <label>Phone:</label>
    <input type="phone" name="phone" value="${user.phone}" required><br><br>
    <label>IT Program:</label>
    <select name="program" value="${user.program}" required>
        <option value="CAS">CAS</option>
        <option value="SQATE">SQATE</option>
        <option value="CPA">CPA</option>
        <option value="ITID" selected>ITID</option>
        <option value="CAD">CAD</option>
        <option value="ITSS">ITSS</option>
    </select><br><br>
        <label>Year Level:</label>
     <select name="yearLevel" value="${user.yearLevel}" required>
        <option value="1" selected>1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
     </select><br><br>
        
     <input type="submit" value="Register Now!" class="margin_left">
      
      <input type="reset" value="Reset" class="margin_left">
</form><br>
<style>
    label {
         display: inline-block;
        width: 100px; /* Adjust the width as needed */
        text-align: right;
        margin-bottom: 10px;
        font-weight: bold; 
    }
    body{ 
        background-color:#F9E8D9;
    }
  header {
    position: relative;
  }
  img {
    position: absolute;
    top: 0;
    left: 30px;
    height: 80px;
    width: 60px;
  }
     
</style>
<c:import url="/includeFiles/DRFSFooter.jsp"/>
