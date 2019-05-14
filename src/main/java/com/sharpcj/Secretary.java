package com.sharpcj;

public class Secretary implements IWork {
    private Leader mLeader;

    public Secretary(Leader mLeader) {
        this.mLeader = mLeader;
    }

    @Override
    public void meeting() {
        System.out.println("秘书先给老板准备材料");
        mLeader.meeting();
    }

    @Override
    public int evaluate(String name) {
        return mLeader.evaluate(name);
    }
}
