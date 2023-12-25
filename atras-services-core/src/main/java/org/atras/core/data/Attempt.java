package org.atras.core.data;

import java.io.Serializable;

public class Attempt implements Serializable{

	private Integer attempt_id;
	
	private Long time;

	public Attempt(Integer attempt_id, Long time) {
		super();
		this.attempt_id = attempt_id;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Attempt [attempt_id=" + attempt_id + ", time=" + time + "]";
	}
	
}
