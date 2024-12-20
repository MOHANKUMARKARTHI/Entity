package com.example.EntityManager.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.EntityManager.Contact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ContactRepository {
	  @Autowired // @PersistenceContext-->we can use this also
	  private EntityManager entityManager;
	  
	  @Transactional
	    public void save(Contact contact) {
	        entityManager.persist(contact);
	    }
	  
	  @Transactional
	  public Contact update(Contact contact) {
	      return entityManager.merge(contact);
	  }
	  
	  public List<Contact> findAll() {
	        String jpql = "SELECT c FROM Contact c";
	        TypedQuery<Contact> query = entityManager.createQuery(jpql, Contact.class);
	         
	        return query.getResultList();
	    }
	  
	  public Contact findById(Integer id) {
		    return entityManager.find(Contact.class, id);
		}
	  
	  @Transactional
	  public void delete(Integer contactId) {
	      Contact contact = entityManager.find(Contact.class, contactId);    
	      entityManager.remove(contact);
	  }

}