package com.ravega.view.jsf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputText;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ravega.bean.entity.Messages;
import com.ravega.bean.session.MainSessionRemote;

@ManagedBean(name = "mView", eager = true)
@RequestScoped
public class MView {

	private HtmlInputText message;
	ArrayList<Messages> messages = new ArrayList<Messages>();	

	public MView() {
		System.out.println("MView started!");
		readMessages();
	}
	
	public ArrayList<Messages> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Messages> messages) {
		this.messages = messages;
	}

	public void setMessage(HtmlInputText message) {
		this.message = message;
	}
	
	public HtmlInputText getMessage() {
	      return message;
	   }
	
	public String moveToInsertMessage() {
	      return "insert";
	   }

	public String moveToInsertAndHome() {
		insertNewMessage();
		return "home";
	}

	private void readMessages() {
		
		MainSessionRemote msr = getSessionRemote();			
		messages = (ArrayList<Messages>)msr.getMessages();
		Iterator<Messages> it = messages.iterator();			
		while (it.hasNext()) {
			System.out.println(((Messages)it.next()).getMessage());
		}		
	}

	private void insertNewMessage() {
		System.out.println(message.getValue());
		
		MainSessionRemote msr = getSessionRemote();
		Messages message_bean = new Messages();
		message_bean.setMessage((String)message.getValue());
		msr.setMessage(message_bean);
		readMessages();
	}
	
	public String deleteMessage(Messages m_) {
		System.out.println("Delete: " + m_.getMessage());
		MainSessionRemote msr = getSessionRemote();		
		msr.deleteMessage(m_);
		readMessages();
		return "home";
		
	}
	
	private MainSessionRemote getSessionRemote() {
        Properties props = new Properties();
		
		props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		props.put(Context.PROVIDER_URL, "localhost");
		
		try {
			InitialContext ctx = new InitialContext();
			
			MainSessionRemote msr = (MainSessionRemote)ctx.lookup("java:global/MProject/BussinesEJB/MainSession!com.ravega.bean.session.MainSessionRemote");
			return msr;
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
