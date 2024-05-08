<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="styles/main.css" type="text/css/">

<c:import url="/includeFiles/DRFSBanner.html"/>


<h2 style="text-align:center;">Add a Book</h2>
<form action="DRFSAddBook" method="post" id="addBookForm">
<c:forEach items="${errors}" var="error">
    <li style="color: red">${error}</li><br>
</c:forEach>
    
    <label for="code">Code:</label>
    <input type="text" id="code" name="code" value="${code}">
    
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${description}">
    
    <label for="quantity">Quantity:</label>
    <input type="text" id="quantity" name="quantity" value="${empty quantity ? '0': quantity}">
    
    
    <input type="submit" value="Save" formmethod="post" formaction="DRFSAddBook">
    
    <input type="button" value="Cancel" onclick="window.location.href='DRFSDisplayBooks'">

   </form> 
 
        
   <style>
       body{ 
        background-color:#F9E8D9;
        }   
        
    img {
    position: absolute;
    top: 30px;
    left: 30px;
    height: 80px;
    width: 60px;
    }
        
     input[type=text], select {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    
    label {
    display: block;
    margin-bottom: 5px;
    }
            
    </style>
    
    
 
<c:import url="/includeFiles/DRFSFooter.jsp"/>