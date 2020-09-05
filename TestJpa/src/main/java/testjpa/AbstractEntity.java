package testjpa;

import javax.persistence.ColumnResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@NamedNativeQueries({ 
		@NamedNativeQuery(name = "query19",
				query = "select num19 from t1",
				resultSetMapping = "idlong"
			) 
})
@SqlResultSetMapping(
		name = "idlong",
		columns = {
				@ColumnResult(name = "num19", type = Long.class)
		}
)
@MappedSuperclass
public class AbstractEntity {

}
