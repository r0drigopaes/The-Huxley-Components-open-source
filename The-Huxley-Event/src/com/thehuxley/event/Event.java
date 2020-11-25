package com.thehuxley.event;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Event implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final int KEY_EVENT_MASK = 1;
	public static final int KEY_NAME = 2;
	public static final int KEY_ACK = 3;
	public static final int KEY_EVENT = 4;
	/*
	 * Os tipos precisam ser potências de 2
	 */
	public static final int TYPE_NEW_SUBMISSION = 1;
	public static final int TYPE_UPDATE_QUESTIONNAIRE_STATISTICS = 2;
	public static final int TYPE_QUESTIONNAIRE_SAVED = 4;
    public static final int TYPE_START_PLAGIUM = 8;

	public Date creationTime;
	public int type	;
	public Map<Object,Object> params;


	public Event(int type, Map<Object,Object> params){

		creationTime = new Date();
		this.type = type;
		this.params = params;

	}

	public String toString(){
		return type+"|"+creationTime;
	}

	/**
	 * Retorna verdadeiro caso o evento esteja contido na máscara passada no parâmetro.
	 * @param typeMask
	 * @return
	 */
	public boolean isContained(int typeMask){
		return (type&typeMask)==type;
	}

	public Map<Object,Object> getParams(){
		return params;
	}

}
