package com.softserve.ita;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/records/create")
public class CreateAddressBookServlet extends HttpServlet {

    private AddressBook addressBook;
    private String message = "";

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");

        if (addressBook.create(firstName,lastName,address)) {
            response.sendRedirect("/records/list");
        } else {
            message = "An error occurred! Please try again!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/address-book-create.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/address-book-create.jsp").forward(request, response);
    }
}
