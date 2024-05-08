<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includeFiles/DRFSBanner.html"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>
    <h1>List of Members</h1>
    
    <form type="hidden" name="action" method="addMember">
        <input type="hidden" name="action" value="addMember">
        
    <table>
            <tr>
                <th>Email</th>
                <th>Full Name</th>
                <th>Program</th>
                <th>Phone Number</th>
                <th>Year</th>
            </tr>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.emailAddress}</td>
                    <td>${member.fullName}</td>
                    <td>${member.programName}</td>
                    <td>${member.phoneNumber}</td>
                    <td>${member.yearLevel}</td>
                    <td><a href="DRFSMemberAdmin?action=editMember&email=${member.emailAddress}">Edit</a></td>
                    <td><a href="DRFSMemberAdmin?action=removeMembers&email=${member.emailAddress}">Remove</a></td>
                </tr>
            </c:forEach>
        </table>
    

        <input type="submit" value="Add Member" class="btnForm">            
    </form>
    
</body>


<c:import url="/includeFiles/DRFSFooter.jsp"/>