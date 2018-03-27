package com.rand.projetomaven.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer stauts;
	private String msg;
	private Long TimeStamp;
	
	public StandardError(Integer stauts, String msg, Long timeStamp) {
		super();
		this.stauts = stauts;
		this.msg = msg;
		TimeStamp = timeStamp;
	}

	public Integer getStauts() {
		return stauts;
	}

	public void setStauts(Integer stauts) {
		this.stauts = stauts;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		TimeStamp = timeStamp;
	}

	
}
