package com.danyarmarkin.crypto;

public class TransferNote extends Note{

    public TransferNote(int coins, long senderId, long receivedId) {
        super(coins, senderId, receivedId);
    }

    @Override
    public String toString() {
        return String.format("%d Coin Transfer from %d to %d: %d coins",
                this.getHash(),
                this.getSenderId(),
                this.getReceivedId(),
                this.getCoins());
    }
}
