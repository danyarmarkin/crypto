package com.danyarmarkin.crypto;

import java.util.Random;

public class Mine extends Thread{
    private User user;
    private Chain chain;
    private boolean started;
    Random random;

    public Mine(User user, Chain chain) {
        this.user = user;
        this.chain = chain;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();

        while (started) {
            Block b = chain.getCurrentBlock();
            String t = b.getText();
            int i = random.nextInt(255);
            char c = (char) i;
            t += c;
            String hash = Integer.toBinaryString(t.hashCode());
            if (hash.length() < 8) continue;
            if (hash.substring(hash.length() - 7).equals("0000000")) {
                b.setText(t);
                chain.add(b, user.getId());
                user.addCoins(1);
            }
        }
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public synchronized void start() {
        super.start();
        started = true;
    }

    public void stopThread() {
        started = false;
    }

}
