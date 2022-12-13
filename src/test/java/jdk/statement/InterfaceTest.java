package jdk.statement;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 인터페이스 테스트 슈트
 *
 * @author noritersand
 * @since 2021-01-06
 */
public class InterfaceTest {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(InterfaceTest.class);

    @Test
    public void test() {
        String fourfivesix = ImplementMe.fourFiveSix;
        assertEquals(fourfivesix, "456");
        ImplementMe aa = new ImplementMe() {

            @Override
            public String getText2() {

                return null;
            }
        };
        assertEquals("Hi.", aa.sayHello());
    }
}

interface ImplementMe {
    final String oneTwoThree = "123";
    final String fourFiveSix = "456";

    static String getAng() {
        return "ang?";
    }

    String getText2();

    default String sayHello() {
        return "Hi.";
    }
}
