package org.test.ejbs;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.test.cdi.IntWrapper;

/**
 * Stateless EJB mit injected dependent member.
 * 
 * @author Istvan Szilagyi
 */
@Stateless
public class StatelessEJBWithDependentField
{
	@Inject
	private IntWrapper wrappedInt;

	public String call1() {
		wrappedInt.setIntVal(1);
		try {
			return "Call (w) ".concat(String.valueOf(wrappedInt.getIntVal()));
		}finally {
			wrappedInt.setIntVal(2);
		}
	}
	
	public String call2() {
		try {
			final String note = (wrappedInt.getIntVal() != 2 ? "<-----":"");
			return "Call (w) ".concat(String.valueOf(wrappedInt.getIntVal())).concat(note);
		}finally {
			wrappedInt.setIntVal(0);
		}
	}
}
