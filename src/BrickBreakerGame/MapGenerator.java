package BrickBreakerGame;

import java.awt.*;

public class MapGenerator {

    public int map [][];
    public int brickWidth;
    public int brickHeight;

    // Script that creates a 2 dimensional array
    public MapGenerator(int row, int col){
      map = new int [row][col]; // constructor requires rows and columns
      for (int i = 0;i< map.length; i++ ){
          for (int j=0; j< map[0].length; j++){
              map[i][j] = 1;
          }
      }

      brickWidth = 540/ col; // the brick width
      brickHeight = 150/row;  // height

    }

    // we cannot draw bricks without graphics, we have set position in map, now we use this position to draw them
    public void draw (Graphics2D g){
        for (int i = 0;i< map.length; i++ ) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j]>0){
                    g.setColor(Color.ORANGE);
                    g.fillRect(j*brickWidth+ 80, i*brickHeight+ 50, brickWidth, brickHeight); //starting point

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.pink);
                    g.drawRect(j*brickWidth+ 80, i*brickHeight+ 50, brickWidth, brickHeight);
                }
            }
        }
    }
}
