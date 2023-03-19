import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void TestStack_BaseCases(){
        Stack<String> stack = new Stack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        String s1 = stack.pop();
        String s2 = stack.pop();
        String s3 = stack.pop();
        stack.push("Four");

        assertEquals("Three", s1);
        assertEquals("Two", s2);
        assertEquals("One", s3);

        assertFalse(stack.isEmpty());
    }
}
