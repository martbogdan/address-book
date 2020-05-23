package com.softserve.ita;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/sort")
public class SortAddressBookServlet extends HttpServlet {
    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortType = request.getParameter("sortType");
        switch (sortType) {
            case "ASC":
                addressBook.sortedBy(SortOrder.ASC);
                break;
            case "DESC":
                addressBook.sortedBy(SortOrder.DESC);
                break;
        }
        request.setAttribute("addresses", addressBook.readAll());
        request.getRequestDispatcher("/WEB-INF/address-book-list.jsp").forward(request, response);

    }
}
