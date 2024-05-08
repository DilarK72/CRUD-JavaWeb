<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>

<c:import url="/includeFiles/DRFSBanner.html"/>

<h1>Admin: Data Maintenance</h1>

<a href="DRFSDisplayBooks">Maintain Books</a> <br>
<a href="DRFSMemberAdmin?action=displayMembers">Display Members</a> <br>

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
    
    img {
    position: absolute;
    top: 0;
    left: 30px;
    height: 80px;
    width: 60px;
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