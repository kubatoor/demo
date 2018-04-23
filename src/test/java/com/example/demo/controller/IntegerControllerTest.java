package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IntegerControllerTest {

    private IntegerController integerController;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        integerController = new IntegerController();
        integerController.initializeStack();
        mockMvc = MockMvcBuilders.standaloneSetup(integerController).build();
    }

    @Test
    public void getInt() throws Exception {
        pushInt();
        mockMvc.perform(get("/stack/integers")).andExpect(status().isOk());
    }

    @Test
    public void pushInt() throws Exception {
        String requestContent = "{\n" +
                "\t\"element\": 4\n" +
                "}";
        mockMvc.perform(post("/stack/integers").content(requestContent).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isCreated());
    }

    @Test
    public void popInt() throws Exception {
    }

}