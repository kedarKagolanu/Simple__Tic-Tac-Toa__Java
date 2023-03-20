package tictactoe;

public class UserInterdace {
    static void printGrid(char [][] array) {
        System.out.println("---------");
        for(int i=0;i<3;i++) {
            System.out.println("| "+array[i][0]+" "+array[i][1]+" "+array[i][2]+" |");
        }
        System.out.println("---------");
    }
}
