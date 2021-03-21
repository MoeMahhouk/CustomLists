package unitTests;

import errors.StackIsEmptyException;
import lists.stack.SimpleStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleStackTest {
    private static SimpleStack<Integer> simpleStackTest;
    @BeforeAll
    static void beforeAll() {
        simpleStackTest = new SimpleStack<>();
    }
    @BeforeEach
    void cleanUp() {
        simpleStackTest = new SimpleStack<>();
    }

    @Test
    void push() {
        simpleStackTest.push(10);
        assertEquals(10,simpleStackTest.getTopStackItem().getValue());
    }

    @Test
    void pop() {
        assertThrows(StackIsEmptyException.class, () -> simpleStackTest.pop());
        simpleStackTest.push(10);
        simpleStackTest.push(20);
        simpleStackTest.push(30);
        simpleStackTest.push(40);
        simpleStackTest.push(50);

        try {
            assertEquals(50,simpleStackTest.pop());
            assertEquals(40,simpleStackTest.pop());
            assertEquals(30,simpleStackTest.pop());
            assertEquals(20,simpleStackTest.pop());
            assertEquals(10,simpleStackTest.pop());
        } catch (StackIsEmptyException e) {
            e.printStackTrace();
        }
    }

    @Test
    void peek() {
        assertThrows(StackIsEmptyException.class, () -> simpleStackTest.peek());
        simpleStackTest.push(10);
        try {
            assertEquals(10,simpleStackTest.pop());
        } catch (StackIsEmptyException e) {
            e.printStackTrace();
        }
    }
}