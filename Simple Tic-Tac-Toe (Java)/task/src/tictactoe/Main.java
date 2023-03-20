package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        char[][] array = new char[3][3];
        int xCoordinate,yCoordinate;

        String input = in.next();

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                array[i][j] = input.charAt(i*3+j);
            }
        }

        UserInterdace.printGrid(array);
        boolean isInValidInout = true;
        while(isInValidInout) {
            try {

                xCoordinate = in.nextInt();
                yCoordinate = in.nextInt();

                if (xCoordinate > 3 || yCoordinate > 3 || xCoordinate < 0 || yCoordinate < 0) {
                    throw new Exception("Coordinates should be from 1 to 3!");
                }

                if (array[xCoordinate - 1][yCoordinate - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                array[xCoordinate - 1][yCoordinate - 1] = 'X';
                isInValidInout = false;

            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        UserInterdace.printGrid(array);

        //Evaluator.evalute(array);
    }
}
