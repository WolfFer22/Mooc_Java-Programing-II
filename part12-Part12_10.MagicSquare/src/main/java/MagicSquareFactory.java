
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        
        int startingValue = 1;

        square.placeValue(square.getWidth() / 2, 0, startingValue);
        square.placeValue(square.getWidth() / 2 + 1, square.getHeight() - 1, startingValue * 2);

        int positionX = square.getWidth() / 2 + 1;
        int positionY = square.getHeight() - 1;

        for (int i = 3; i <= (size * size); i++) {

            positionX++;
            positionY--;

            if (positionX == square.getWidth()) {
                positionX = 0;
                
            } else if (positionY < 0) {
                positionY = square.getHeight() - 1;
            }            

            if (square.readValue(positionX, positionY) == 0) {

                square.placeValue(positionX, positionY, i * startingValue);

            } else {
                positionY += 2;
                
                if (positionX == 0 ) {
                    positionX = square.getWidth() - 1;                    
                    square.placeValue(positionX, positionY, i * startingValue);

                } else {
                    positionX--;                    
                    square.placeValue(positionX, positionY, i * startingValue);
                }
            }
        }

        return square;
    }
    
}
