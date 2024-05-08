<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="styles/main.css" type="text/css">


<c:import url="/includeFiles/DRFSBanner.html"/>

<h1>List of Books</h1>

<table border="1">
    <thead>
        <tr>
            <th>Code</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
    </thead>
    
<tbody>
    <c:forEach var="book" items="${books}"> 
        <tr>  
            <td>${book.code}</td>  
            <td>${book.description}</td> 
            <td>${book.quantity}</td>         
        </tr>
     </c:forEach>
   </tbody>
</table>

<a href="DRFSAddBook.jsp">
    
    <button style="
    padding: 10px;
    margin-top: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;" type="button">Add Book</button>
</a>

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