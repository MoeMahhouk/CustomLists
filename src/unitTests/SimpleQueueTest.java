package unitTests;

import errors.QueueIsEmptyException;
import lists.queue.SimpleQueue;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleQueueTest {
    private static SimpleQueue<Integer> queueTest;

    @BeforeAll
    static void beforeAll() {
        queueTest = new SimpleQueue<>();
    }
    @BeforeEach
    void cleanUp() {
        queueTest = new SimpleQueue<>();
    }

    @Test
    void enqueue() {
        queueTest.enqueue(10);
        assertEquals(10, queueTest.getQueueList().getValue());
    }

    @Test
    void dequeue() {
        assertThrows(QueueIsEmptyException.class, () -> queueTest.dequeue());
        queueTest.enqueue(10);
        queueTest.enqueue(20);
        queueTest.enqueue(30);
        queueTest.enqueue(40);
        queueTest.enqueue(50);
        try {
            assertEquals(10, queueTest.dequeue());
            assertEquals(20, queueTest.dequeue());
            assertEquals(30, queueTest.dequeue());
            assertEquals(40, queueTest.dequeue());
            assertEquals(50, queueTest.dequeue());
        } catch (QueueIsEmptyException e) {
            e.printStackTrace();
        }
    }

    @Test
    void peek() {
        assertThrows(QueueIsEmptyException.class, () -> queueTest.peek());
        queueTest.enqueue(10);
        try {
            assertEquals(10, queueTest.peek());
        } catch (QueueIsEmptyException e) {
            e.printStackTrace();
        }
    }
}