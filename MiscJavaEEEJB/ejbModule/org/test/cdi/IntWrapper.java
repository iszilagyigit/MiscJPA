package org.test.cdi;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

/**
 * A CDI Primitive int Wrapper Bean.
 *
 * @author Istvan Szilagyi
 */
@Dependent
public class IntWrapper
{
  private int intVal;

  @PostConstruct
  private void init() {
    intVal = -1;
  }
  /**
   * Liefert IntVal.
   *
   * @return IntVal
   */
  public int getIntVal()
  {
      return intVal;
  }

  /**
   * Setzt IntVal.
   *
   * @param pIntVal IntVal
   */
  public void setIntVal(final int pIntVal)
  {
      this.intVal = pIntVal;
  }
}
