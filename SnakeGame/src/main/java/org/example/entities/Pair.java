package org.example.entities;

public class Pair {
    int val1;
    int val2;

    public Pair(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.val1 == ((Pair)obj).val1 && this.val2 == ((Pair)obj).val2) {
            return true;
        }
        return super.equals(obj);
    }
}
