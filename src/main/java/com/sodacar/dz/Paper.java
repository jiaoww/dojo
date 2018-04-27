package com.sodacar.dz;

/**
 * Created by evin on 2018/4/23.
 */
public class Paper {
    //count 2-14表示牌面大小  14表示A
    private int num;
    //花色
    private PaperShape shape;

    public Paper(int num, PaperShape shape) {
        this.num = num;
        this.shape = shape;
    }

    public int getNum() {
        return num;
    }

    public PaperShape getShape() {
        return shape;
    }
}
