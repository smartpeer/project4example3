package com.mycompany.util;

public class Message {
	
	private boolean msgRendrer = false;
	private String msgValue;
	private MessageType msgType;
	
	
	
	public Message() {
		super();
		msgRendrer = false;
		msgValue = "";
		msgType = MessageType.IDLE;
		
	}
	public Message(boolean mesgRendrer, String msgValue, MessageType msgType) {
		super();
		this.msgRendrer = mesgRendrer;
		this.msgValue = msgValue;
		this.msgType = msgType;
	}
	public boolean isMsgRendrer() {
		return msgRendrer;
	}
	public void setMsgRendrer(boolean mesgRendrer) {
		this.msgRendrer = mesgRendrer;
	}
	public String getMsgValue() {
		return msgValue;
	}
	public void setMsgValue(String msgValue) {
		this.msgValue = msgValue;
	}
	public MessageType getMsgType() {
		return msgType;
	}
	public void setMsgType(MessageType msgType) {
		this.msgType = msgType;
	}
	
	
	
	

}
