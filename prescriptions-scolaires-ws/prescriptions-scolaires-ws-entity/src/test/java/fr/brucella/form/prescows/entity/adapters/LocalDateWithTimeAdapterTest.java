package fr.brucella.form.prescows.entity.adapters;

import java.time.LocalDateTime;
import junit.framework.Assert;
import org.junit.Test;

/**
 * LocalDateWithTimeAdapter unit test.
 *
 * @author BRUCELLA2
 */
public class LocalDateWithTimeAdapterTest {


  // ===== Constructor =====

  /** Default Constructor */
  public LocalDateWithTimeAdapterTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * unmarshal testing.
   */
  @Test
  public void unmarshalTest() {

    final LocalDateWithTimeAdapter adapter = new LocalDateWithTimeAdapter();
    final String stringDate = "01-02-2010 12:55:20";
    final LocalDateTime date = adapter.unmarshal(stringDate);

    Assert.assertEquals(01, date.getDayOfMonth());
    Assert.assertEquals(02, date.getMonthValue());
    Assert.assertEquals(2010, date.getYear());
    Assert.assertEquals(12, date.getHour());
    Assert.assertEquals(55, date.getMinute());
    Assert.assertEquals(20, date.getSecond());
  }

  /**
   * marshal testing.
   */
  @Test
  public void marshalTest() {

    final LocalDateWithTimeAdapter adapter = new LocalDateWithTimeAdapter();
    final LocalDateTime date = LocalDateTime.of(2010,02,01,12,55,20);
    final String stringDate = adapter.marshal(date);

    Assert.assertEquals("01-02-2010 12:55:20", stringDate);
  }
}