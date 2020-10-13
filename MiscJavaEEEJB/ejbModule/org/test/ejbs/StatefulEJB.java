package org.test.ejbs;

import java.io.Serializable;

import javax.ejb.Stateful;


/**
 * 
 * @author Istvan Szilagyi
 */
@Stateful
public class StatefulEJB implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int field = 0;
	
	public String call1() {
		this.field = 1;
		try {
			return "Call ".concat(String.valueOf(this.field));
		}finally {
			this.field = 2;
		}

	}
	
	public String call2() {
		try {
			final String note = (this.field != 2 ? "<-----":"");
			return "Call ".concat(String.valueOf(this.field)).concat(note);
		}finally {
			this.field = 3;
		}
	}
}
