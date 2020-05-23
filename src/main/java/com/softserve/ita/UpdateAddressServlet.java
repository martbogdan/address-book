package com.softserve.ita;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/update")
public class UpdateAddressServlet extends HttpServlet {

    private AddressBook addressBook;
    private Address address;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        address.setAddress(request.getParameter("address"));
        addressBook.update(address.getFirstName(), address.getLastName(), address.getAddress());
        response.sendRedirect("/records/list");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        address = addressBook.getAddress(request.getParameter("firstName"), request.getParameter("lastName"));
        if (address == null) {
            response.sendError(404);
        } else {
            request.setAttribute("address", address);
            request.getRequestDispatcher("/WEB-INF/update-address.jsp").forward(request, response);
        }
    }
}
