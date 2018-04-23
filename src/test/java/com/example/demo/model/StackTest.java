package com.example.demo.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void push() throws Exception {
        stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void push_WithException() throws Exception {
        stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @Test
    public void singlePush() throws Exception {
        stack = new Stack(4);
        stack.push(4);
        assertEquals(1, stack.size());
    }

    @Test
    public void push_noelements() throws Exception {
        stack = new Stack(4);
        assertEquals(0, stack.size());
    }

    @Test
    public void pop() throws Exception {
        stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());

        stack.push(7);
        assertEquals(2, stack.size());
        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_withException() throws Exception {
        stack = new Stack(5);
        stack.pop();
    }

    @Test
    public void peek() throws Exception {

        stack = new Stack(10);
        stack.push(1);
        stack.push(4);
        stack.push(7);

        assertEquals(7, stack.peek());
        assertEquals(3, stack.size());
    }
}