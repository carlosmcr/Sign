package com.carlos.sign.model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dates {
	
	@Id
	@GeneratedValue
	private int idDate;
	private GregorianCalendar calendar;
	private String state;
	private boolean expired;
	
	public Dates(int idDate, GregorianCalendar calendar, String state, boolean expired) {
		super();
		this.idDate = idDate;
		this.calendar = calendar;
		this.state = state;
		this.expired = false;
	}
	
	public Dates() {
	}

	public int getIdDate() {
		return idDate;
	}

	public void setIdDate(int idDate) {
		this.idDate = idDate;
	}

	public GregorianCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	@Override
	public String toString() {
		return "Dates [idDate=" + idDate + ", calendar=" + calendar + ", state=" + state + ", expired=" + expired + "]";
	}



	
}
