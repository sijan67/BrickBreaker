package BrickBreakerGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int scores = 0;

    private int totalBricks = 21;

    private Timer timer;
    private int delay = 8;

    private int playerX = 310;

    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;  //increment for location of ball
    private int ballYdir = -2;

    private MapGenerator map; // object of type map generator

    public GamePlay(){
        map = new MapGenerator(3, 7);
        addKeyListener(this);  // so we can use the input from keys of the keyboard
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){

        g.setColor(Color.pink); //setting back ground color of our game
        g.fillRect(1, 1, 692, 592);  //colors and positions of different items placed in the screen

        map.draw((Graphics2D)g);

        g.setColor(Color.black);  //setting the boarder of the screen
        g.fillRect(0,0,5,592); //position of the borders
        g.fillRect(0,0,692,3);
        g.fillRect(680, 0, 10, 592);

        g.setColor(Color.cyan.darker());  //color of the pedal
        g.fillRect(playerX, 500, 120, 20); // to connect the value of pedal to keyboard to move pedal on the screen

        g.setColor(Color.black.brighter()); //the ball
        g.fillOval(ballposX, ballposY, 20, 20); //should move on both x and y direction

        g.dispose(); // to make sure once function is executed , the system will release sources for it

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // what is going to happen when we perform certain action with the keys

        timer.start();

        if (play) {

            // Ball - Pedal interaction
            if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 500, 120, 20))) {
                ballYdir = -ballYdir;
            }

            ballposX += ballXdir;
            ballposY += ballYdir;

            // bouncing from walls
            if (ballposX < 0) {
                ballXdir = -ballXdir;
            }

            if (ballposY < 0) {
                ballYdir = -ballYdir;
            }

            if (ballposX > 670) {
                ballXdir = -ballXdir;  //
            }

            repaint(); // method repaint after certain amount of timer which is 8ps in our case
            // will automatically update our window
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {





    }

    @Override
    public void keyPressed(KeyEvent e) {

        // when we press left arrow we want our pedal to move left and when we press right
        //arrow we want to move it to the right

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //if argument is right key function
            if (playerX >= 600) { // to ensure pedal does not go further down the borders of our Map
                playerX = 600;
            } else {
                moveRight();  // method we will create
            }
        }

        // for left
        if (e.getKeyCode() == KeyEvent.VK_LEFT) { //if argument is right key function
            if (playerX <10) { // to ensure pedal does not go further down the borders of our Map
                playerX = 600;
            } else {
                movLeft();  // method we will create
            }
        }

    }

    public void moveRight(){

        play = true;
        playerX += 20;
    }

    public void movLeft(){

        play = true;
        playerX -= 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
