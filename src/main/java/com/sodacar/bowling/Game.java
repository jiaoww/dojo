package com.sodacar.bowling;

/**
 * Created by evin on 2018/4/27.
 */
public class Game {
    private int[][] scores = new int[10][3];

    private int frame = 0;
    private int rollNum = 0;

    public void init() {
        scores = new int[10][3];
        frame = 0;
        rollNum = 0;
    }

    public void roll(int pins) {
        scores[frame][rollNum] = pins;
        if (((pins == 10 || scores[frame][0] + scores[frame][1] == 10) && frame < 9) || (rollNum == 1 && frame < 9)) {
            frame++;
            rollNum = 0;
        } else {
            rollNum++;
        }
    }

    public int score() {
        int totalScore = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 9) {
                if (scores[i][0] == 10) {
                    if (scores[i + 1][0] == 10) {
                        totalScore += scores[i + 1][0] + 10 + 10;
                    } else {
                        totalScore += scores[i + 1][0] + scores[i + 1][1] + 10;
                    }
                } else if (scores[i][0] + scores[i][1] == 10) {
                    totalScore += scores[i + 1][0] + 10;
                } else {
                    totalScore += scores[i][0] + scores[i][1];
                }
            } else {
                totalScore += scores[i][0]
                        + scores[i][1]
                        + scores[i][2];
            }
        }
        return totalScore;
    }
}
