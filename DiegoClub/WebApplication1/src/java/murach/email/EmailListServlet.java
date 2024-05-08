package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.business.User1;
import murach.data.UserDB;

public class EmailListServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
     String url = "/DRFSIndex.jsp";
     
      // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }
        
        
        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/DRFSRegister.jsp";    // the "join" page
        }
        
        else if(action.equals("add")){
            
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String program = request.getParameter("program");
            String yearLevel = request.getParameter("yearLevel");
            
            
            User1 user = new User1 (fullName,email,phone,program,yearLevel);
            
             String message;
            if (fullName == null || email == null || phone == null || program == null || yearLevel == null ||
                    fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || program.isEmpty() || yearLevel.isEmpty()) {
                message = "Please fill out all five inputs.";
                url = "/DRFSRegister.jsp";
            }
            else
            {
                message = "";
                url = "/DRFSDisplayMember.jsp";
                UserDB.insert(user);
                
            }
            
             request.setAttribute("user", user);
            request.setAttribute("errorMessage", message);
            
        }
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        
        
    }
    
     @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    }   

}