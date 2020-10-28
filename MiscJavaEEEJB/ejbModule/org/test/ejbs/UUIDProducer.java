package org.test.ejbs;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.test.annotations.FixUUID;
import org.test.annotations.RandomUUID;

/**
 * @author Istvan Szilagyi
 */
@ApplicationScoped
public class UUIDProducer
{
  @Produces
  @RandomUUID
  public UUID newUUIDRandom() {
    return UUID.randomUUID();
  }

  @Produces
  @FixUUID
  public UUID newUUIDFix() {
    return UUID.fromString("4fab62f5-cf72-4b27-bb9c-9458be53d20c");
  }
}
