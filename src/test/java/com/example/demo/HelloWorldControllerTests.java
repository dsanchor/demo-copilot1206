package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }

    @Test
    public void testReverseString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", "Hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("olleH"));
    }

    @Test
    public void testReverseStringWithSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", "Hello!@#$%^&*()"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(")(*&^%$#@!olleH"));
    }

    // test reverse con input vacio
    @Test
    public void testReverseStringEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testNoVowels() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/noVowels").param("input", "Hello World"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hll Wrld"));
    }

    // test noVowels con input vacio
    @Test
    public void testNoVowelsEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/noVowels").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    // test noVowels con input sin vocales
    @Test
    public void testNoVowelsNoVowels() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/noVowels").param("input", "Hll Wrld"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hll Wrld"));
    }
}