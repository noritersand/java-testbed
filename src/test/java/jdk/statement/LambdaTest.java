package jdk.statement;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 람다 표현식 테스트
 * <p>
 * - https://d2.naver.com/helloworld/4911107
 *
 * @author fixalot
 * @since 2017-07-27
 */
public class LambdaTest {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(LambdaTest.class);

    /**
     * 이게 대체 뭐냐
     *
     * @author fixalot
     */
    @Test
    public void test1() {
        Map<String, Object> goods = new HashMap<>();
        goods.put("adultYn", "1");
        Predicate<Map<String, Object>> isAdultGoods = g -> StringUtils.equals(MapUtils.getString(g, "adultYn"), "1");
        assertTrue(isAdultGoods.test(goods));
    }
}
