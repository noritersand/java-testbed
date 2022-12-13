package jdk.java.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayDequeTest {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ArrayDequeTest.class);

    @Test
    public void test() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("a"); // add(): 큐에 요소 추가
        queue.add("b");

        // element(): 맨 앞의 요소를 반환하되 큐에서 삭제하지 않는다. 큐에 요소가 없으면 NoSuchElementException 예외가 던져진다.
        assertEquals("a", queue.element());
        // peek(): 맨 앞의 요소를 반환하되 큐에서 삭제하지 않는다. element()와 다르게 요소가 없어도 예외가 발생하지 않는다.
        assertEquals("a", queue.peek());

        // poll(); 맨 앞의 요소를 반환하되 큐에서 삭제한다.
        assertEquals("a", queue.poll());
        assertEquals("b", queue.poll());
        assertTrue(queue.isEmpty());
    }
}
