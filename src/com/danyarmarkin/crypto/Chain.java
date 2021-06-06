package com.danyarmarkin.crypto;

import java.util.ArrayList;

public class Chain {
    private final ArrayList<Block> blocks;
    private Block currentBlock;

    public Chain() {
        blocks = new ArrayList<>();
        currentBlock = new Block();
    }

    public void add(Block block, long id) {
        blocks.add(block);
        currentBlock = new Block(String.valueOf(getCurrentHash()));
        currentBlock.add(new AddCoinNote(1, id));
    }

    public long getCurrentHash() {
        String t = blocks.get(blocks.size() - 1).getText();
        return t.hashCode();
    }

    public Block getCurrentBlock() {
        return currentBlock;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
}
