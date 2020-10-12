package org.test.ejbs;

import javax.ejb.Stateless;

/**
 * @author Istvan Szilagyi
 */
@Stateless
public class StatelessEJB
{
	private int field = 0;

	public String call1() {
		this.field = 1;
		return "Call " + this.field;
	}
	
	public String call2() {
		try {
			return "Call " + this.field + " " + (this.field != 1 ? "<-----":"");
		}finally {
			this.field = 2;
		}
	}
}
