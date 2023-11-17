package org.example;

public class NumClass {
    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numberInInterval(int n) {
        return 100 >= n && n >= 25;
    }
}
