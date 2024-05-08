package club.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import club.business.Member;
import club.data.MemberDB;


public class DRFSMemberAdminControllerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        
        HttpSession session = request.getSession();
        String url = "/DRFSDisplayMembers.jsp";
        
        //get current action
        String action = request.getParameter("action");
        if(action == null){
        
            action = "displayMembers"; //default action
        }
        
        
        if(action.equals("displayMembers")){
        
            ArrayList<Member> members = MemberDB.selectMembers();
            request.setAttribute("members",members);
        }
        else if(action.equals("addMember")){
        
           url = "/DRFSAddMember.jsp";
           
        
        }
        else if(action.equals("deleteMembers")){
              
            //get the member
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            
            //delete the member
            MemberDB.delete(member);
            
            //get the list of members
             ArrayList<Member> members = MemberDB.selectMembers();
            request.setAttribute("members", members);
        }
        
        else if(action.equals("display_members"))
        {
            //get the member
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            session.setAttribute("member",member);
            url = "/DRFSDisplayMembers.jsp";
            
        }
        
        else if(action.equals("saveMember"))
        {
            String emailAddress = request.getParameter("emailAddress");
            String fullName = request.getParameter("fullName");
            String programName = request.getParameter("programName");
            String phoneNumber = request.getParameter("phoneNumber");
            int yearLevel = Integer.parseInt(request.getParameter("yearLevel"));            
            String db_operation = request.getParameter("db_operation");
            Member member = new Member("John Doe", "test@example.com", "5558884444", "ITID", 1);
            member.setFullName(request.getParameter("fullName"));
            member.setEmailAddress(request.getParameter("emailAddress"));
         
            
            if(db_operation.equals("update"))
            {
                
                if (member.isValid()){
                //get and update member
                member = (Member) session.getAttribute("member");
                member.setEmailAddress(emailAddress);
                member.setFullName(fullName);
                member.setProgramName(programName);
                member.setPhoneNumber(phoneNumber);
                member.setYearLevel(yearLevel);
                //member.isValid();
                MemberDB.update(member);
                //response.sendRedirect("DRFSDisplayMembers.jsp");
                }
                else{
                
                String errorMessage = "Please enter valid full name and email address.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("DRFSEditMember.jsp").forward(request, response);
                
                }              
           
            }
            else if (db_operation.equals("insert"))
            {
            
               if(member.isValid())
                {
                member = new Member("John Doe", "test@example.com", "5558884444", "ITID", 1);
                member.setEmailAddress(emailAddress);
                member.setFullName(fullName);
                member.setProgramName(programName);
                member.setPhoneNumber(phoneNumber);
                member.setYearLevel(yearLevel);

                MemberDB.insert(member);
                
              }else {
                
                String errorMessage = "Please enter valid full name and email address.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("DRFSAddMember.jsp").forward(request, response);
                
                }
                           
            }
            //get list of members
            ArrayList<Member> members = MemberDB.selectMembers();
            request.setAttribute("members", members);
            
        }
        
        else if (action.equals("editMember"))
        {
            //get parameters from request
            
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            url = "/DRFSEditMember.jsp";
            session.setAttribute("member",member);

            //get the list of members            
            request.setAttribute("member", member);       
            
            
        }
        
        else if (action.equals("removeMembers"))
        {
            
            //get parameters from request
                        
            String email = request.getParameter("email");
            Member member = MemberDB.selectMember(email);
            url = "/DRFSRemoveMember.jsp";
            session.setAttribute("member",member);
            
            //get the list of members
            request.setAttribute("member",member);
        
        }
               
        getServletContext().getRequestDispatcher(url).forward(request, response);
        
    }

}
