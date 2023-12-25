package org.atras.messages.data;

import java.io.Serializable;

import org.atras.core.data.ECAM;

public class Message implements Serializable{

	private String source;
	private ECAM payload;
	
	public Message(String source, ECAM payload) {
		super();
		this.source = source;
		this.payload = payload;
	}
	
	public String getSource() {
		return source;
	}

	public ECAM getPayload() {
		return payload;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setPayload(ECAM payload) {
		this.payload = payload;
	}
}
