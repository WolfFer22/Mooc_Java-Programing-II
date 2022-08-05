
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {        
        
        ArrayList <Integer> sumRows = new ArrayList<>();
        
        // Read matrix rows left->rigth  
        for (int y = 0; y < square.length; y++){
            
            int sumRow = 0;
            //Read matrix columns values of row called
            for (int x = 0; x < square[y].length; x++){ 
                
                sumRow += square[y][x];
            }
            
            sumRows.add(sumRow);
        }
        
        return sumRows;
    }

    public ArrayList<Integer> sumsOfColumns() {
        
        ArrayList <Integer> sumColumns = new ArrayList<>();
        
        // Change reading order of the matrix, 
        // Read matrix columns (top->down => inverter a matrix, left->rigth)
        for (int y = 0; y < square.length; y++){
            
            int sumColumn = 0;           
            // Read matrix rows values of column called         
            for (int x = 0; x < square[y].length; x++){ 
                
                sumColumn += square[x][y];
                
            }
            
            sumColumns.add(sumColumn);
        }
        
        return sumColumns;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        
        ArrayList <Integer> sumDiagonals = new ArrayList<>();

        int sumTopLeftToRigthDown = 0; 
        int sumTopRigthToDownLeft = 0;
        
        for (int x = 0; x < square.length; x++){
            
            for (int y = 0; y < square[x].length; y++){                 
                
                if (x == y){                 
                    sumTopLeftToRigthDown += square[x][y];
                }                                                           
            }
            
            sumTopRigthToDownLeft += square[x][(square.length - 1) - x];
        }
        
        sumDiagonals.add(sumTopLeftToRigthDown);
        sumDiagonals.add(sumTopRigthToDownLeft);        
        
        return sumDiagonals;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
        //return this.square[x][y];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
        //this.square[x][y] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
