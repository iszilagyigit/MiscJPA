package testjpa;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.dialect.Oracle12cDialect;
import org.hibernate.type.StandardBasicTypes;

public class Oracle19cDialect extends Oracle12cDialect {

    private Map<Integer, String> customNumericTypeMap = new HashMap<>();
    
	public Oracle19cDialect() {
		super();
		customNumericTypeMap.put(18, StandardBasicTypes.LONG.getName());
	}
	

	public String getHibernateTypeName(int code, int length, int precision, int scale) throws HibernateException {
		if (Types.NUMERIC == code &&
			scale == 0 &&
			customNumericTypeMap.containsKey(length)
			) {
			return customNumericTypeMap.get(length);
		}
		return super.getHibernateTypeName(code, length, precision, scale);
	}
	
}
