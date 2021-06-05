package com.danyarmarkin.crypto;

public abstract class Note {
    public String text;
    public long hash;
    public long senderId;
    public long receivedId;
    public int coins;

    public Note(int coins, long senderId, long receivedId) {
        this.coins = coins;
        this.senderId = senderId;
        this.receivedId = receivedId;
        text = String.format("%d:%d:%d", senderId, receivedId, coins);
    }

    public Note(int coins, long receivedId) {
        this.receivedId = receivedId;
        this.coins = coins;
        text = String.format("%d:%d", this.receivedId, this.coins);
    }

    public long getHash() {
        hash = text.hashCode();
        return hash;
    }

    public long getSenderId() {
        return senderId;
    }

    public long getReceivedId() {
        return receivedId;
    }

    public int getCoins() {
        return coins;
    }

    public void addText(String text) {
        this.text = text + this.text;
    }

    public String getText() {
        return text;
    }
}
