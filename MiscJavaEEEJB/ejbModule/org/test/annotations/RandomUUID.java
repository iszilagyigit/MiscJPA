package org.test.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import javax.inject.Qualifier;

/**
 * @author Istvan Szilagyi
 */
@Qualifier
@Retention(RUNTIME)
public @interface RandomUUID
{

}
