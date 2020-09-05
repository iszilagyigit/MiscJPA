package org.isz.miscjee.cdi;

public interface Counter {
	long getCount();
	
    default String getName() {
		return this.getClass().getName();
	}
}