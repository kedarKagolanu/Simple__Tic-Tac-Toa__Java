package tictactoe;

public class Evaluator {

    static char[][] arr;
    static int emptyCells = 0;

    Evaluator(char[][] array) {
        arr = array;
    }

    static void evalute(char[][] array) throws Exception{
        char r0,r1,r2,c0,c1,c2,d0,d1;
        Evaluator ev = new Evaluator(array);

        for(int i=0;i<3;i++) {
            ev.parseRow(i);
            ev.parseColumn(i);
            if(i == 1){
                continue;
            }
            ev.parseDiagonal(i);
        }

        ev.countEmptyCells();

        if(emptyCells == 0) {
            throw new Exception("Draw");
        }
    }

    void parseRow(int rowIndex) throws Exception {
        char returnChar = arr[rowIndex][0];
        if(returnChar == ' ')
            return;

        for(char c : arr[rowIndex]) {
            if(returnChar != c) {
                return;
            }
        }

        throw new Exception(returnChar + " wins");
    }

    void parseColumn(int colIndex) throws Exception {
        char returnChar = arr[0][colIndex];
        if(returnChar == ' ')
            return;

        for (int i=1;i<3;i++) {
            if (returnChar != arr[i][colIndex]) {
                return;
            }
        }

        throw new Exception(returnChar + " wins");
    }

    void parseDiagonal(int diagonalNum) throws Exception {
        int val = diagonalNum;
        int incrementVal = (diagonalNum == 0) ? 1 : -1;
        char returnChar = arr[0][val];
        if(returnChar == ' ')
            return;

        for(int i=1;i<3;i++) {
            val += incrementVal;
            if(returnChar != arr[i][val]) {
                return;
            }
        }

        throw new Exception(returnChar + " wins");
    }

    void countEmptyCells() {
        for(char[] subArray : arr) {
            for(char ch : subArray) {
                if(ch == ' ') {
                    emptyCells++;
                }
            }
        }
    }

}
