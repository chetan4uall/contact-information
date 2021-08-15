package com.cz.ci.service;

import java.util.List;
import com.cz.ci.model.Contact;

public interface ContactService {
	
	List<Contact> getAllContacts();
	
	void saveContact(Contact contact);
	
	Contact getContactById(long id);
	
	void deleteContactById(long id);
}
