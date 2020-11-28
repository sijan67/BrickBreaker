package BrickBreakerGame;

import BrickBreakerGame.GamePlay;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame obj = new JFrame ();
        GamePlay gamePlay = new GamePlay();

        obj.setBounds(300,10, 700 , 600);  //set x, y position to display frame and also width and height
        obj.setTitle("Brick Breaker");  //title of frame
        obj.setResizable(false);  //can either resize or not resize the frame
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add (gamePlay);

    }
}
