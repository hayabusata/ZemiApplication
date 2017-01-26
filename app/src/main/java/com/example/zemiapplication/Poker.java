package com.example.zemiapplication;

/**
 * Created by syunta on 2017/01/13.
 */

import android.graphics.Color;

import java.util.Random;

public class Poker {
    private int[] hand;

    private int gameCount;
    private int winCount;
    private int drawCount;
    private int loseCount;

    //private int backColor1;
    //private int backColor2;
    //private int backColor3;
    //private int backColor4;
    //private int backColor5;

    public Poker(int length) {
        Random ran = new Random();
        hand = new int[length];
        for (int i = 0; i < hand.length; i++) {
            hand[i] = ran.nextInt(8) + 1;
        }

        gameCount = 0;
        winCount = 0;
        drawCount = 0;
        loseCount = 0;

        //backColor1 = ran.nextInt(4);
        //backColor2 = ran.nextInt(4);
        //backColor3 = ran.nextInt(4);
        //backColor4 = ran.nextInt(4);
        //backColor5 = ran.nextInt(4);
    }

    public int getRandom() {
        Random ran = new Random();
        return ran.nextInt(8) + 1;
    }

    public int getHand(int num) {
        if (num > 0 && num <= 5) return this.hand[num - 1];
        return -1;
    }

    public int getHandLength() {
        return this.hand.length;
    }

    //1のときchange,0のときそのまま
    public void changeHand(boolean[] check) {
        for (int i = 0; i < check.length && i < this.hand.length; i++) {
            if (check[i] == true) this.hand[i] = this.getRandom();
        }
    }

    public boolean[] decideChangedCard(int level) {
        boolean[] change = new boolean[this.hand.length];

        if (level == 1) {   //level:easy
            for (int i = 0; i < this.hand.length; i++) {
                change[i] = true;
            }
        } else if (level == 0) {    //level:normal
            for (int i = 0; i < change.length; i++) {
                change[i] = true;
            }

            for (int i = 0; i < this.hand.length; i++) {
                for (int j = i + 1; j < this.hand.length; j++) {
                    if (this.hand[i] == this.hand[j]) {
                        change[i] = false;
                        change[j] = false;
                    }
                }
            }
        } else if (level == 2) {    //very hard
            for (int i = 0; i < this.hand.length; i++) {
                change[i] = false;
                if (i == 0) this.hand[i] = this.getRandom();
                else this.hand[i] = this.hand[0];
            }
        }

        return change;
    }

    //カードが５枚の時の役のチェック
    public int checkPrize() {
        int i, j, h = 0;
        int prizeNumber = 0;
        int[] check = new int[this.hand.length];
        int count = 1;
        int[] sum = new int[this.hand.length / 2];

        for (i = 0; i < check.length; i++) {
            check[i] = -1;
            if (i < sum.length) sum[i] = 1;
        }

        for (i = 0; i < this.hand.length; i++) {
            if (check[i] == -1) check[i] = count;

            for (j = i + 1; j < this.hand.length; j++) {
                if (this.hand[i] == this.hand[j] && check[j] == -1) {
                    check[j] = count;
                    if (h < sum.length) sum[h]++;
                }
            }

            count++;

            if (sum[h] != 1 && h == 0) h++;
            //h++;
        }

        if (sum[0] == 2 && sum[1] == 1) prizeNumber = 1;    //1ペア
        else if (sum[0] == 2 && sum[1] == 2) prizeNumber = 2;   //2ペア
        else if (sum[0] == 3 && sum[1] == 1) prizeNumber = 3;   //3カード
        else if ((sum[0] == 3 && sum[1] == 2) || (sum[0] == 2 && sum[1] == 3)) prizeNumber = 4; //フルハウス
        else if (sum[0] == 4 && sum[1] == 1) prizeNumber = 5;   //4カード
        else if (sum[0] == 5 && sum[1] == 1) prizeNumber = 6;   //5カード

        return prizeNumber;
    }

    public String getPrizeString(int result) {
        if (result == 0) return "ノーペア";
        else if (result == 1) return "1ペア";
        else if (result == 2) return "2ペア";
        else if (result == 3) return "3カード";
        else if (result == 4) return "フルハウス";
        else if (result == 5) return "4カード";
        else if (result == 6) return "5カード";
        else return "ノーペア";
    }

    public static String getWinner(int myResult, int yourResult) {
        if (myResult > yourResult) return "あなたの勝ちです";
        else if (myResult == yourResult) return "引き分けです";
        return "相手の勝ちです";
    }

    public static int numToColor(int num) {
        int color = Color.WHITE;

        switch (num) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.parseColor("#4169E1");
                break;
            case 3:
                color = Color.GREEN;
                break;
            case 4:
                color = Color.YELLOW;
                break;
            case 5:
                color = Color.GRAY;
                break;
            case 6:
                color = Color.CYAN;
                break;
            case 7:
                color = Color.MAGENTA;
                break;
            case 8:
                color = Color.parseColor("#F5DEB3");
                break;
            default:
                color = Color.WHITE;
                break;
        }

        return color;
    }

    public void counter(int myResult, int yourResult) {
        gameCount++;

        if (myResult > yourResult) winCount++;
        else if (myResult == yourResult) drawCount++;
        else if (myResult < yourResult) loseCount++;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public int getDrawCount() {
        return this.drawCount;
    }

    public int getLoseCount() {
        return this.loseCount;
    }

    public void setGameCount(int num) {
        this.gameCount = num;
    }

    public void setWinCount(int num) {
        this.winCount = num;
    }

    public void setDrawCount(int num) {
        this.drawCount = num;
    }

    public void setLoseCount(int num) {
        this.loseCount = num;
    }

}
