package com.example.parcialarep.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Profile("math")

@RestController
public class LucasController {

    @GetMapping("/lucasseq")
    public LucasResponse lucasSequence(@RequestParam int value) {
        String sequence = computeLucasSequence(value);
        return new LucasResponse("Secuencia de Lucas", value, sequence);
    }

    private String computeLucasSequence(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Value must be non-negative");
        }
        if (n == 0) {
            return "2";
        }
        if (n == 1) {
            return "2, 1";
        }
        long[] lucas = new long[n + 1];
        lucas[0] = 2;
        lucas[1] = 1;
        for (int i = 2; i <= n; i++) {
            lucas[i] = lucas[i - 1] + lucas[i - 2];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if (i > 0) sb.append(", ");
            sb.append(lucas[i]);
        }
        return sb.toString();
    }
}

record LucasResponse(String operation, int input, String output) {}
