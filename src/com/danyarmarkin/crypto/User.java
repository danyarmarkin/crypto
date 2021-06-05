package com.danyarmarkin.crypto;

public class User {
    public long id;
    public long coins;

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }

    public void addCoins(int coins){
        this.coins += coins;
    }
}
