package com.ravega.bean.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ravega.bean.entity.Messages;

/**
 * Session Bean implementation class MainSession
 */
@Stateful
@LocalBean
public class MainSession implements MainSessionRemote, MainSessionLocal {

	@PersistenceContext(unitName="BussinesEJB")
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public MainSession() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Messages> getMessages() {
    	TypedQuery<Messages> query =
    			entityManager.createQuery("SELECT c FROM Messages c", Messages.class);
    	//Query query = entityManager.createQuery("SELECT message FROM Messages m");
        List<Messages> resultList = (List<Messages>) query.getResultList();	        
		return resultList;
    }
    
    public String getMessage() {
    	return "";
    }
    
    public void setMessage(Messages m_) {    	
    	//message = new Messages();
    	//message.setMessage(m_);
    	if (entityManager == null) {
    		System.out.println("Null EM");    	
    	} else {
    		System.out.println("Persisting Message"); 
    		entityManager.persist(m_);
    	}
    }
    
    public void deleteMessage(Messages m_) {
    	if (entityManager == null) {
    		System.out.println("Null EM");    	
    	} else {
    		System.out.println("Delete Message: " + m_.getId() + " : " + m_.getMessage());
    		entityManager.remove(entityManager.find(Messages.class,  m_.getId()));
    		System.out.println("Message Deleted");
    	}     		
    }

}
