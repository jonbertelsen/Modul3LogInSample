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
    
    private static final int ONE = 0;
    private static final int TWO = 1;
    private static final int FOUR = 2;
    private static final int FRONTWALL = 0;
    private static final int BACKWALL = 1;
    private static final int SIDEWALL = 2;

    public ItemList(Order order) {
        brickArray = new int[3][3]; // 0,1,2 walls and 0,1,2 One, Two, Four Bricks
        for (int walls = 0; walls < 3; walls++) {
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
        int remainingBricks;
        int numberOfFours;
        int numberOfTwos;
        int numberOfOnes;

            // Calc front wall
            for (int height = 0; height < order.getHeight(); height++) {
                numberOfFours = order.getLength() / 4;
                remainingBricks = order.getLength() % 4;       
                this.brickArray[FRONTWALL][FOUR] += numberOfFours;
                numberOfTwos = remainingBricks / 2;
                remainingBricks = remainingBricks % 2;       
                this.brickArray[FRONTWALL][TWO] += numberOfTwos;
                numberOfOnes = remainingBricks / 1;
                this.brickArray[FRONTWALL][ONE] += numberOfOnes;
           }
        }
     
        // Calc back wall
                
        
        // Calc side wall x 2
    }
