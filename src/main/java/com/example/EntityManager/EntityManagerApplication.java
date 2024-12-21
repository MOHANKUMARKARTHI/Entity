package com.example.EntityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.EntityManager.Repository.ContactRepository;

@SpringBootApplication
@ComponentScan
public class EntityManagerApplication  implements CommandLineRunner {
	 @Autowired
	 private ContactRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(EntityManagerApplication.class, args);
		
	}
	
	    @Override
	    public void run(String... args) throws Exception {
	        createContact();
	        updateContact();
	        listContacts();
//	        getContact();
//	        deleteContact();
	    }
	 
	 private void createContact() {
	        Contact newContact = new Contact();
	 
	        newContact.setName("Raina");
	        newContact.setEmail("Raina@gmail.com");
	        newContact.setAddress("London");
	        newContact.setPhone("9878695812");
	         
	        repo.save(newContact);     
	    }
	 
	      
	 private void updateContact() {
	     Contact existContact = new Contact();
	      
	     existContact.setId(2);
	     existContact.setName("sandeep Smith");
	     existContact.setEmail("sandeep.smith@gmail.com");
	     existContact.setAddress("USA");
	     existContact.setPhone("12345");
	      
	     Contact updatedContact = repo.update(existContact);
	      
	 }
	 
	 private void listContacts() {
		    List<Contact> listContacts = repo.findAll();
		    System.out.println(listContacts);
		}
	 
	 private void getContact() {
		    Integer contactId = 1;
		    Contact contact = repo.findById(contactId);
		     
		    System.out.println(contact);
		}
	 
	 private void deleteContact() {
		    Integer contactId = 1;     
		    repo.delete(contactId);
		}

}
