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
        Block b = chain.getCurrentBlock();
        String t1 = b.getText();
        String t = b.getText();
//        System.out.println(t1);
        while (started) {
            b = chain.getCurrentBlock();
            if (!b.getText().equals(t1)) {
                t1 = t = b.getText();
//                System.out.println(t1);
            }
            int i = random.nextInt(255);
            char c = (char) i;
            t += c;
            String hash = Integer.toBinaryString(t.hashCode());
            if (hash.length() <= 17) {
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
