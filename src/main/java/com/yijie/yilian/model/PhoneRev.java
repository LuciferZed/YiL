package com.yijie.yilian.model;

import org.springframework.stereotype.Component;

@Component
public class PhoneRev {
	
	private String rev;
	
	private String time;

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public PhoneRev(String rev, String time) {
		super();
		this.rev = rev;
		this.time = time;
	}

	@Override
	public String toString() {
		return "PhoneRev [rev=" + rev + ", time=" + time + "]";
	}

	public PhoneRev() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
