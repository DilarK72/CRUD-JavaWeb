<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includeFiles/DRFSBanner.html"/>

<h1>Thanks for joining our club!</h1>

    <p>Here is the information that you entered:</p>
    
    <jsp:useBean id="user" scope="request" class="murach.business.User1"/>
    <label>Full Name:</label>
    <span><jsp:getProperty name="user" property="fullName"/></span><br>
    
    <label>Email:</label>
    <span><jsp:getProperty name="user" property="email"/></span><br>
    
    <label>Phone:</label>
    <span><jsp:getProperty name="user" property="phone"/></span><br>
    
    <label>Program:</label>
    <span><jsp:getProperty name="user" property="program"/></span><br>
    
    <label>Year Level:</label>
    <span><jsp:getProperty name="user" property="yearLevel"/></span><br>
    
    
     <p>To register another member, click on the Back button in your browser or 
     the Return button shown below.</p>

    <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
     
     <style>
       label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold; /* Add this line to make the labels bold */
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

 