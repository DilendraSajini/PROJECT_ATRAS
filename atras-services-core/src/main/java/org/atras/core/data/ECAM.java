package org.atras.core.data;

import java.io.Serializable;
import java.util.List;

public class ECAM implements Serializable{

	private String pilot_id;
	
	private List<Attempt> attemptsData;
	
	public ECAM(String pilot_id, List<Attempt> attemptsData) {
		super();
		this.pilot_id = pilot_id;
		this.attemptsData = attemptsData;
	}

	@Override
	public String toString() {
		return "ECAM [pilot_id=" + pilot_id + ", attemptsData=" + attemptsData + "]";
	}	
}
