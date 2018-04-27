package com.sodacar.bowling;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by evin on 2018/4/27.
 */
public class GamesTest {

    /**
     * 全部全中的情况
     */
    @Test
    public void testGame1() {
        Games games = new Games();
        for (int i = 0; i < 12; i++) {
            games.roll(10);
        }
        Assert.assertEquals(games.score(), 300);
    }

    /**
     * 全部补中的情况 每次击倒5个瓶
     */
    @Test
    public void testGame2() {
        Games games = new Games();
        for (int i = 0; i < 21; i++) {
            games.roll(5);
        }
        Assert.assertEquals(games.score(), 9 * 15 + 15);
    }

    /**
     * 全部失误的情况
     */
    @Test
    public void testGame3() {
        Games games = new Games();
        for (int i = 0; i < 21; i++) {
            games.roll(0);
        }
        Assert.assertEquals(games.score(), 0);
    }

    /**
     * 全中 补中 失误 混合的情况
     */
    @Test
    public void testGame4(){
        Games games = new Games();
        //frame1   14
        games.roll(5);
        games.roll(5);
        //frame2   8
        games.roll(4);
        games.roll(4);
        //frame3   9
        games.roll(3);
        games.roll(6);
        //frame4   20
        games.roll(10);
        //frame5   17
        games.roll(4);
        games.roll(6);
        //frame6   9
        games.roll(7);
        games.roll(2);
        //frame7   19
        games.roll(10);
        //frame8   9
        games.roll(9);
        games.roll(0);
        //frame9   9
        games.roll(5);
        games.roll(4);
        //frame10   20
        games.roll(10);
        games.roll(8);
        games.roll(2);

        Assert.assertEquals(games.score(), 14 + 8 + 9 + 20 + 17 + 9 + 19 + 9 + 9 + 20);
    }

}
