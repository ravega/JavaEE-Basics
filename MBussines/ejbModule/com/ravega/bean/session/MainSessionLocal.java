package com.ravega.bean.session;

import java.util.List;

import javax.ejb.Local;

import com.ravega.bean.entity.Messages;

@Local
public interface MainSessionLocal {
	public String getMessage();
	public void setMessage(Messages m_);
	public List<Messages> getMessages();
	public void deleteMessage(Messages m_);
}
