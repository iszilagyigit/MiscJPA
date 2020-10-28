package org.test.ejbs;

import java.util.UUID;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.test.annotations.FixUUID;
import org.test.annotations.RandomUUID;
import org.test.cdi.IntWrapper;

/**
 * Dependent (not session) Bean mit injected dependent member.
 * 
 * @author Istvan Szilagyi
 */
@Dependent
public class BeanWithDependentField
{
	@Inject
	private IntWrapper wrappedInt;

	private final UUID uuid;

	@Inject
	public BeanWithDependentField(@RandomUUID UUID pUUID) {
		this.uuid = pUUID;
	}

	public String info() {
		return " UUID: " + this.uuid.toString();
	}

	public String call1() {
		wrappedInt.setIntVal(1);
		try {
			return "Call (w) "
					.concat(String.valueOf(wrappedInt.getIntVal()));
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
