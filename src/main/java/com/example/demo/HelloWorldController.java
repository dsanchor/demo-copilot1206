package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("Received request for /hello");
        String response = "Hello World";
        System.out.println("Sending response: " + response);
        return response;
    }

    @GetMapping("/reverse")
    public String reverseString(@RequestParam("input") String input) {
        System.out.println("Received request for /reverse with input: " + input);
        StringBuilder reversedString = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedString.append(input.charAt(i));
        }
        String response = reversedString.toString();
        System.out.println("Sending response: " + response);
        return response;
    }

    // eliminar vocales
    @GetMapping("/noVowels")
    public String noVowels(@RequestParam("input") String input) {
        System.out.println("Received request for /noVowels with input: " + input);
        String response = input.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Sending response: " + response);
        return response;
    }

}