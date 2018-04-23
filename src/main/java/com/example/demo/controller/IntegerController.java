package com.example.demo.controller;

import com.example.demo.model.Element;
import com.example.demo.model.Stack;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/stack/integers")
public class IntegerController {

    private static final int STACK_SIZE = 5;
    private Stack stack = null;

    @PostConstruct
    public void initializeStack() {
        stack = new Stack(STACK_SIZE);
    }


    @GetMapping("/top")
    public ResponseEntity<Integer> getInt() {
        int number = stack.peek();
        return new ResponseEntity<>(number, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> pushInt(@RequestBody Element element) {
        stack.push(element.getElement());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/top")
    public ResponseEntity<Integer> popInt() {
        return new ResponseEntity<>(stack.pop(), HttpStatus.OK);
    }



}
