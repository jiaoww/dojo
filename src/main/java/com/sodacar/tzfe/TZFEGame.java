package com.sodacar.tzfe;

/**
 * Created by evin on 2018/5/8.
 */
public class TZFEGame {

    private int[][] board = new int[4][4];

    public void place(int i, int j, int value) {
        this.board[i - 1][j - 1] = value;
    }

    public void moveLeft() {
        int i, j, k;
        for (i = 0; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                k = j;
                while (k - 1 >= 0 && board[i][k - 1] == 0) {
                    int temp = board[i][k];
                    board[i][k] = board[i][k - 1];
                    board[i][k - 1] = temp;
                    k--;
                }
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void moveRight() {
        int i, j, k;
        for (i = 0; i < 4; i++) {
            for (j = 2; j >= 0; j--) {
                k = j;
                while (k + 1 <= 3 && board[i][k + 1] == 0) {
                    int temp = board[i][k];
                    board[i][k] = board[i][k + 1];
                    board[i][k + 1] = temp;
                    k++;
                }
            }
        }
    }

    public void moveUp() {
        int i, j, k;
        for (j = 0; j < 4; j++) {
            for (i = 1; i < 4; i++) {
                k = i;
                while (k - 1 >= 0 && board[k - 1][j] == 0) {
                    int temp = board[k][j];
                    board[k][j] = board[k - 1][j];
                    board[k - 1][j] = temp;
                    k--;
                }
            }
        }
    }

    public void moveDown() {
        int i, j, k;
        for (j = 0; j < 4; j++) {
            for (i = 2; i >= 0; i--) {
                k = i;
                while (k + 1 <= 3 && board[k + 1][j] == 0) {
                    int temp = board[k][j];
                    board[k][j] = board[k + 1][j];
                    board[k + 1][j] = temp;
                    k++;
                }
            }
        }
    }

    public void left() {
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 3; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    board[i][j] += board[i][j + 1];
                    board[i][j + 1] = 0;
                    moveLeft();
                }
            }
        }
    }

    public void right() {
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 3; j >= 1; j--) {
                if (board[i][j] == board[i][j - 1]) {
                    board[i][j] += board[i][j - 1];
                    board[i][j - 1] = 0;
                    moveRight();
                }
            }
        }
    }


    public void up() {
        int i, j;
        for (j = 0; j < 4; j++) {
            for (i = 0; i < 3; i++) {
                if (board[i][j] == board[i + 1][j]) {
                    board[i][j] = board[i][j] + board[i + 1][j];
                    board[i + 1][j] = 0;
                    moveUp();
                }
            }
        }
    }

    public void down() {
        int i, j;
        for (j = 0; j < 4; j++) {
            for (i = 3; i >= 1; i--) {
                if (board[i][j] == board[i - 1][j]) {
                    board[i][j] = board[i][j] + board[i - 1][j];
                    board[i - 1][j] = 0;
                    moveDown();
                }
            }
        }
    }

    public void pri() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================");
    }
}
