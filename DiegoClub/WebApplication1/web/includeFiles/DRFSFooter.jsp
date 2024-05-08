<%@ page import ="java.util.GregorianCalendar, java.util.Calendar" %>

<% 
    GregorianCalendar currentDate = new GregorianCalendar();
    
    int currentYear = currentDate.get(Calendar.YEAR);
    
   %>
   <footer>
 <p>&copy; Copyright <%=currentYear%> Diego Ramos & Faizan Subhani</p>
   </footer>
</body>
</html>
