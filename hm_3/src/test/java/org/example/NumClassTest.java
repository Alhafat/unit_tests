package org.example;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumClassTest {

    static NumClass num;

    @BeforeAll
    static void initClass() {
        num = new NumClass();
    }

    @Test
    void evenOddNumberTrue() {
        assertTrue(num.evenOddNumber(2));
    }

    @Test
    void numberInIntervalTrue() {
        assertTrue(num.numberInInterval(25));
        assertTrue(num.numberInInterval(30));
        assertTrue(num.numberInInterval(100));
    }

    //скорее всего необязательные, но на всякий случай
    @Test
    void numberInIntervalFalse() {
        assertFalse(num.numberInInterval(24));
        assertFalse(num.numberInInterval(101));
    }

    @Test
    void evenOddNumberFalse() {
        assertFalse(num.evenOddNumber(3));
    }
}