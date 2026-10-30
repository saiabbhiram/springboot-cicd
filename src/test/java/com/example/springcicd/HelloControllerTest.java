package com.example.springcicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Application is UP!"));
    }

    @Test
    public void testGreetEndpointWithName() throws Exception {
        mockMvc.perform(get("/api/greet").param("name", "John"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, John!"));
    }

    @Test
    public void testGreetEndpointDefaultName() throws Exception {
        mockMvc.perform(get("/api/greet"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }
}
