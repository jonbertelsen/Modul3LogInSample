/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author jobe
 */
public class ItemList {

    private int[][] brickArray;

    public static final int FRONTWALL = 0;
    public static final int BACKWALL = 1;
    public static final int RIGHTWALL = 2;
    public static final int LEFTWALL = 3;
    public static final int ONE = 0;
    public static final int TWO = 1;
    public static final int FOUR = 2;

    public ItemList(Order order) {
        brickArray = new int[4][3]; // 0,1,2 walls and 0,1,2 One, Two, Four Bricks
        for (int walls = 0; walls < 4; walls++) {
            for (int bricks = 0; bricks < 3; bricks++) {
                brickArray[walls][bricks] = 0;
            }
        }
        generateItemList(order);
    }

    public int[][] getItemList() {

        return brickArray;
    }

    // Calculate all 4 walls in put result into brickArray
    private void generateItemList(Order order) {

        calcWall(order.getLength(), order.getHeight(), FRONTWALL);
        calcWall(order.getLength(), order.getHeight(), BACKWALL);
        calcWall(order.getWidth() - 4, order.getHeight(), LEFTWALL);
        calcWall(order.getWidth() - 4, order.getHeight(), RIGHTWALL);
    }

    private void calcWall(int length, int height, int wall) {
        int remainingBricks;
        int numberOfFours;
        int numberOfTwos;
        int numberOfOnes;

        for (int row = 0; row < height; row++) {
            numberOfFours = length / 4;
            remainingBricks = length % 4;
            this.brickArray[wall][FOUR] += numberOfFours;
            numberOfTwos = remainingBricks / 2;
            remainingBricks = remainingBricks % 2;
            this.brickArray[wall][TWO] += numberOfTwos;
            numberOfOnes = remainingBricks / 1;
            this.brickArray[wall][ONE] += numberOfOnes;
        }
    }

    public int sumColumn(int brickColumn) {

        int sum = 0;

        for (int row = FRONTWALL; row < LEFTWALL; row++) {
            sum += brickArray[row][brickColumn];
        }
        return sum;
    }

}
