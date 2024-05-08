<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includeFiles/DRFSBanner.html"/>

<strong><h2>Java Web Technologies: Section 1</h2></strong>

<p>Pair Programming Team:</p>

<strong>
    <h2>Assignment 1</h2>
    <h2>Driver: Diego Ramos</h2>
    <h2>Observer: Faizan Subhani</h2>
</strong>

<p>Current Date and Time</p>
<style>
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
    
    <strong class="date"><%=new java.util.Date()%></strong>
<c:import url="/includeFiles/DRFSFooter.jsp"/>