package jdk.statement;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * for문 테스트
 *
 * @author fixalot
 * @since 2017-07-27
 */
public class ForStatementTest {
    //	@SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ForStatementTest.class);

    /**
     * usage
     *
     * @author fixalot
     */
    @Test
    public void test() {
        // 기본 사용 방법
        int i;
        for (i = 0; i < 1; i++) {
            logger.debug("{} 바퀴", i);
        }
        assertEquals(1, i);

        // 무한 루프
        for (; ; ) {
            logger.debug("비상탈출!");
            break;
        }

        // 이런 모양으로도 됨.
        int j = 0;
        for (; j < 1; ) {
            j++;
            logger.debug("{} 바퀴", j);
        }
    }

    @Test
    public void testIterator() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            logger.debug(iterator.next());
            // 마지막 요소 삭제
            if (!iterator.hasNext()) {
                iterator.remove();
            }
        }
        assertEquals(3, list.size());
    }

}
