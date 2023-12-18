package org.example.Money;

public class Won {
    private int won;

    public Won(int won) {
        this.won = won;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    @Override
    public String toString() {
        return String.format("%,d원", won);
    }
}
