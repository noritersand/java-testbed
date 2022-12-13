package misc;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author fixalot
 * @since 2017-07-27
 */
public class PrimitiveTest {
    private static final Logger logger = LoggerFactory.getLogger(PrimitiveTest.class);

    @Test
    @SuppressWarnings("unused")
    public void useEscapeCharacter() {
        Byte bt = 123;
        byte bt2 = 123;
        Short st = 0;
        short st2 = 0;
        Integer it = 12345;
        int it2 = 12345;
        Long lg = 1234L;
        long lg2 = 1234l;
        Float flt = 1234F;
        float flt2 = 1234f;
        Double db = 1234D;
        double db2 = 1234d;
    }

    @Test
    public void getMinMaxRange() {
        assertEquals(-128, Byte.MIN_VALUE);
        assertEquals(127, Byte.MAX_VALUE);
        assertEquals(-32768, Short.MIN_VALUE);
        assertEquals(32767, Short.MAX_VALUE);
        assertEquals(-2147483648, Integer.MIN_VALUE);
        assertEquals(2147483647, Integer.MAX_VALUE);
        assertEquals(-9223372036854775808L, Long.MIN_VALUE);
        assertEquals(9223372036854775807L, Long.MAX_VALUE);
        assertEquals("1.4E-45", String.valueOf(Float.MIN_VALUE));
        assertEquals("3.4028235E38", String.valueOf(Float.MAX_VALUE));
        assertEquals("4.9E-324", String.valueOf(Double.MIN_VALUE));
        assertEquals("1.7976931348623157E308", String.valueOf(Double.MAX_VALUE));
    }

    @Test
    public void autoBoxing() {
        assertEquals(1, (long) Long.valueOf(1));
    }

    @Test
    public void testValueOf() {
        int number = Integer.valueOf("1");
        assertEquals(1, number);
        try {
            Integer.valueOf(""); // 빈 문자열은 valueOf 불가
        } catch (NumberFormatException e) {
            logger.debug("NumberFormatException 발생: {}", e.getMessage());
        }
        try {
            Integer.valueOf(null); // null은 valueOf 불가
        } catch (NumberFormatException e) {
            logger.debug("NumberFormatException 발생: {}", e.getMessage());
        }
    }

    @Test
    public void floatCalculateErrorRange() {
        double val1 = 1.5;
        double val2 = 0.3;

        // 오차 허용 안함
        assertEquals(0.44999999999999996, val1 * val2, 0);

        // 0.0000000000000001까지 오차 허용
        assertEquals(0.45, val1 * val2, 0.0000000000000001);
    }
}
