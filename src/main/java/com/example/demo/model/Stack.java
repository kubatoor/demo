package com.example.demo.model;

public class Stack {

    private int[] elements = null;
    private int head = -1;


    public Stack(int size) {
        elements = new int[size];

    }

    public void push(int element) {

        if (head == elements.length-1) {
            throw new IllegalArgumentException("Cannot push more elements. Stack is at its limit");
        }
        head++;
        elements[head] = element;
    }

    public int pop() {
        if (head == -1) {
            throw new IllegalArgumentException("Stack is empty");
        }
        int element =  elements[head];
        head--;
        return element;
    }

    public int peek() {
        return elements[head];
    }

    public int size() {
        return head+1;
    }
}
