package com.ravega.bean.session;

import java.util.List;

import javax.ejb.Remote;

import com.ravega.bean.entity.Messages;

@Remote
public interface MainSessionRemote {
	public String getMessage();
	public void setMessage(Messages m_);
	public List<Messages> getMessages();
	public void deleteMessage(Messages m_);

}
