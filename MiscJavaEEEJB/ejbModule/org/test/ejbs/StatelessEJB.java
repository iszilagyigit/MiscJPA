package org.test.ejbs;

import javax.ejb.Stateless;

/**
 * Example of a not correctly annotated EJB  (@Stateless annotation)
 * regarding the implementation.
 * 
 * @author Istvan Szilagyi
 */
@Stateless
public class StatelessEJB
{
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
			this.field = 0;
		}
	}
}
