package builtin.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link HashMap} 테스트
 *
 * @author fixalot
 * @since 2017-07-27
 */
@Slf4j
public class HashMapTest {

    /**
     * 해시맵은 엔트리(내부의 구성 요소)가 같으면 동등하다고 판단함.
     *
     * @author noritersand
     */
    @Test
    void testEquals() {
        HashMap<String, Object> x = new HashMap<>();
        HashMap<String, Object> y = new HashMap<>();
        x.put("a", "b");
        y.put("a", "b");

        // 인스턴스는 다르지만
        assertNotSame(x, y);

        // AbstractMap.hashCode()는 엔트리의 hashCode()를 이어 붙인 값이다. 따라서 같다고 판단한다.
        assertTrue(x.hashCode() == y.hashCode());

        // AbstractMap.equals()는 엔트리의 키:값 구성이 같은지를 비교한다. 따라서 둘은 동등하다.
        assertTrue(x.equals(y));
    }

    @Test
    void testEntry() {
        HashMap<String, String> map = new HashMap<>();
        map.put("first", "1st");
        map.put("second", "2nd");
        map.put("third", "3rd");

        Set<Map.Entry<String, String>> entry = map.entrySet();
        for (Map.Entry<String, String> ele : entry) {
            String key = ele.getKey();
            String value = ele.getValue();
            log.debug("key: {}, value: {}", key, value);
        }
    }

    @Test
    void shouldBeNull() {
        HashMap<String, String> map = new HashMap<>();
        assertNull(map.get("야"));
    }

    @Test
    void checkNPE() {
        Map<String, Object> map = new HashMap<>();
        String empty = (String) map.get("empty");
        assertNull(empty);

        map.put("NOT_NULL", null);
        Object notNull = map.get("NOT_NULL");
        assertNull(notNull);
    }

    /**
     * 맵도 반복문을 돌려서 꺼낼 수 있다.
     * 왜냐믄 맵의 키셋에 iterator가 있기 때문
     *
     * @author fixalot
     */
    @Test
    void possibleLoopStatement() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1234);
        map.put("b", 5678);
        map.put("c", 90);

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            assertNotNull(map.get(key));
        }
    }

    @Test
    void testForEach() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.forEach((k, v) -> {
            log.debug("Item : {} Count : {}", k, v);
        });
    }
}