package com.sg.contactlistspringmvc.controller;

import com.sg.contactlistspringmvc.dao.ContactListDao;
import com.sg.contactlistspringmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author souldj673
 */
@Controller
public class ContactController {

    ContactListDao dao;

    @Inject
    public ContactController(ContactListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayContactsPage", method = RequestMethod.GET)
    public String displayContactsPage(Model model) {
        // Get all the Contacts from the DAO
        List<Contact> contactList = dao.getAllContacts();

        // Put the List of Contacts on the Model
        model.addAttribute("contactList", contactList);

        // Return the logical name of our View component
        return "contacts";
    }

    @RequestMapping(value = "/createContact", method = RequestMethod.POST)
    public String createContact(HttpServletRequest request) {
        // grab the incoming values from the form and create a new Contact
        // object
        Contact contact = new Contact();
        contact.setFirstName(request.getParameter("firstName"));
        contact.setLastName(request.getParameter("lastName"));
        contact.setCompany(request.getParameter("company"));
        contact.setPhone(request.getParameter("phone"));
        contact.setEmail(request.getParameter("email"));

        // persist the new Contact
        dao.addContact(contact);

        // we don't want to forward to a View component - we want to
        // redirect to the endpoint that displays the Contacts Page
        // so it can display the new Contact in the table.
        return "redirect:displayContactsPage";
    }

    @RequestMapping(value = "/displayContactDetails", method = RequestMethod.GET)
    public String displayContactDetails(HttpServletRequest request, Model model) {
        //Grab and Parse ID
        String contactIdParameter = request.getParameter("contactId");
        int contactId = Integer.parseInt(contactIdParameter);
        Contact contact = dao.getContactById(contactId);

        //Add Contact to list
        model.addAttribute("contact", contact);
        return "contactDetails";
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public String deleteContact(HttpServletRequest request) {
        long contactId = Long.parseLong(request.getParameter("contactId"));
        dao.removeContact(contactId);
        return "redirect:displayContactsPage";
    }
}
