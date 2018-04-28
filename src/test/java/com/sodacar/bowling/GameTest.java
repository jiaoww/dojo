package com.sodacar.bowling;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by evin on 2018/4/27.
 */
public class GameTest {

    /**
     * 全部全中的情况
     */
    @Test
    public void testGame1() {
        Game game = new Game();
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        Assert.assertEquals(game.score(), 300);
    }

    /**
     * 全部补中的情况 每次击倒5个瓶
     */
    @Test
    public void testGame2() {
        Game game = new Game();
        for (int i = 0; i < 21; i++) {
            game.roll(5);
        }
        Assert.assertEquals(game.score(), 9 * 15 + 15);
    }

    /**
     * 全部失误的情况
     */
    @Test
    public void testGame3() {
        Game game = new Game();
        for (int i = 0; i < 21; i++) {
            game.roll(0);
        }
        Assert.assertEquals(game.score(), 0);
    }

    /**
     * 全中 补中 失误 混合的情况
     */
    @Test
    public void testGame4(){
        Game game = new Game();
        //frame1   14
        game.roll(5);
        game.roll(5);
        //frame2   8
        game.roll(4);
        game.roll(4);
        //frame3   9
        game.roll(3);
        game.roll(6);
        //frame4   20
        game.roll(10);
        //frame5   17
        game.roll(4);
        game.roll(6);
        //frame6   9
        game.roll(7);
        game.roll(2);
        //frame7   19
        game.roll(10);
        //frame8   9
        game.roll(9);
        game.roll(0);
        //frame9   9
        game.roll(5);
        game.roll(4);
        //frame10   20
        game.roll(10);
        game.roll(8);
        game.roll(2);

        Assert.assertEquals(game.score(), 14 + 8 + 9 + 20 + 17 + 9 + 19 + 9 + 9 + 20);
    }

}
