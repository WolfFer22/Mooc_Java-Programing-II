
public class Program {

    public static void main(String[] args) {

//        int[][] matrix = {
//            {3, 2, 7, 6},
//            {2, 4, 1, 0},
//            {3, 2, 1, 0}
//        };
//
//        // 3 rows; 4 colums
//        
//        System.out.println(arrayAsString(matrix));
//        int rows = 2;
//        int columns = 3;
//        
//        int[][] matrix2 = new int[rows][columns];
//        
//        matrix2[0][1] = 5;
//        matrix2[1][0] = 3;
//        matrix2[1][2] = 7;
//        
//        System.out.println(arrayAsString(matrix2));
//
        int[][] matrix = {
            {1},
            {2, 2},
            {3, 3, 3},
            {4, 4, 4, 4}
        };
        
        System.out.println(arrayAsString(matrix));
        
        
    }

    public static String arrayAsString(int[][] array) {

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < array.length; row++) {

            for (int column = 0; column < array[row].length; column++) {

                sb.append(array[row][column]);
            }
            
            if (row < array.length - 1){
                sb.append("\n");
            }
        }

        return sb.toString();
    }

}
