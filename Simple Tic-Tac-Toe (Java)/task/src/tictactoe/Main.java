package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        char[][] array = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        int xCoordinate,yCoordinate;
        char playerChar = 'X';
        boolean GameisNotOver = true;

        UserInterdace.printGrid(array);
        try {
            while(true) {
                try {
                    xCoordinate = in.nextInt();
                    yCoordinate = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                if (xCoordinate > 3 || yCoordinate > 3 || xCoordinate < 0 || yCoordinate < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                if (array[xCoordinate - 1][yCoordinate - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                array[xCoordinate - 1][yCoordinate - 1] = playerChar;

                playerChar = (playerChar == 'X') ? 'O' : 'X';

                UserInterdace.printGrid(array);

                Evaluator.evalute(array);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Evaluator.evalute(array);
    }
}
