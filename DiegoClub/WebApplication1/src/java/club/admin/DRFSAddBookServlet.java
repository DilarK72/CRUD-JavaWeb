package club.admin;
//package club.business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import club.business.Book;
import club.data.BookIO;
import java.util.ArrayList;


@WebServlet(name = "DRFSAddBookServlet", urlPatterns ={"/DRFSAddBook"})
public class DRFSAddBookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String quantityStr = request.getParameter("quantity");
            
            ArrayList<String> errors = new ArrayList<>();
            
            if(code == null || code.trim().isEmpty()){
                errors.add("Book code is required!");
            }
            if(description == null || description.length()< 3){
               errors.add("Description must have at least 3 characters");
            }
            
            int quantity = 0;
            if(quantityStr == null || quantityStr.trim().isEmpty()){
                errors.add("Quantity is required!");
            }
            else 
            {
                quantity = Integer.parseInt(quantityStr);
                if(quantity <= 0)
                {
                    errors.add("Quantity must be a positive number");
                }
                
            }
            
          // If errors encountered, throw error messages
        if (!errors.isEmpty()) {
            request.setAttribute("code", code);
            request.setAttribute("description", description);
            request.setAttribute("quantity", quantityStr);
            request.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/DRFSAddBook.jsp").forward(request, response);
            return;
        }

        // If input fields are valid, add the book to the text file
        Book book = new Book(code, description, quantity);
        BookIO.insert(book, getServletContext().getRealPath("/WEB-INF/books.txt"));

        // Forward to NDJLDisplayBooks servlet to display the updated list
        response.sendRedirect("DRFSDisplayBooks");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          processRequest(request, response);
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
          
    }
    
    @Override
    public String getServletInfo() {
        return "DRFSAddBookServlet";
    }// </editor-fold>

}
