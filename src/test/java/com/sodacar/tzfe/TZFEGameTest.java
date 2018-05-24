package com.sodacar.tzfe;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by evin on 2018/5/8.
 */
public class TZFEGameTest {

    @Test
    public void testMoveLeftOne() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 4, 2);
        tzfeGame.moveLeft();
        int[][] moved = new int[4][4];
        moved[2][0] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testMoveLeftMore() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 3, 2);
        tzfeGame.place(4, 3, 2);
        tzfeGame.moveLeft();
        int[][] moved = new int[4][4];
        moved[2][0] = 2;
        moved[3][0] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }


    @Test
    public void testMoveRightOne() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 4, 2);
        tzfeGame.moveRight();
        int[][] moved = new int[4][4];
        moved[2][3] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testMoveRightMore() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 1, 2);
        tzfeGame.place(2, 2, 2);
        tzfeGame.moveRight();
        int[][] moved = new int[4][4];
        moved[1][3] = 2;
        moved[2][3] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testMoveUpOne() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 4, 2);
        tzfeGame.moveUp();

        int[][] moved = new int[4][4];
        moved[0][3] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testMoveUpMore() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(1, 4, 2);
        tzfeGame.place(2, 3, 2);
        tzfeGame.place(3, 2, 2);
        tzfeGame.moveUp();
        int[][] moved = new int[4][4];
        moved[0][3] = 2;
        moved[0][2] = 2;
        moved[0][1] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testMoveDownOne() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 2, 2);
        tzfeGame.moveDown();

        int[][] moved = new int[4][4];
        moved[3][1] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testMoveDownMore() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 4, 2);
        tzfeGame.place(2, 3, 2);
        tzfeGame.place(1, 4, 2);
        tzfeGame.moveDown();
        int[][] moved = new int[4][4];
        moved[2][3] = 2;
        moved[3][2] = 2;
        moved[3][3] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testLeft() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 4, 2);
        tzfeGame.place(2, 3, 2);
        tzfeGame.place(2, 4, 2);
        tzfeGame.left();
        int[][] moved = new int[4][4];
        moved[1][0] = 4;
        moved[2][0] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }


    @Test
    public void testRight() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 4, 2);
        tzfeGame.place(2, 3, 2);
        tzfeGame.place(2, 4, 2);
        tzfeGame.right();
        int[][] moved = new int[4][4];
        moved[1][3] = 4;
        moved[2][3] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testUp() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 4, 2);
        tzfeGame.place(2, 3, 2);
        tzfeGame.place(2, 4, 2);
        tzfeGame.up();
        int[][] moved = new int[4][4];
        moved[0][3] = 4;
        moved[0][2] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }

    @Test
    public void testDown() {
        TZFEGame tzfeGame = new TZFEGame();
        tzfeGame.place(3, 4, 2);
        tzfeGame.place(2, 3, 2);
        tzfeGame.place(2, 4, 2);
        tzfeGame.place(1, 4, 2);
        tzfeGame.down();
        int[][] moved = new int[4][4];
        moved[3][3] = 4;
        moved[3][2] = 2;
        moved[2][3] = 2;
        Assert.assertEquals(tzfeGame.getBoard(), moved);
    }
}
