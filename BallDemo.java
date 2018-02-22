import java.awt.Color;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] myBalls;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line

        myBalls = new BouncingBall[numberOfBalls];
        
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        //creamos tantas bolas como indiquemos
        for(int i =0;i < numberOfBalls; i++){
            BouncingBall ball = new BouncingBall(50+(10*i),50,10,Color.BLUE, ground,myCanvas);
            ball.draw();
            myBalls[i] = ball;
        }
        
        
        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            
            for(int i=0;i< numberOfBalls;i++){
                myBalls[i].move();
                
                // stop once ball has travelled a certain distance on x axis
                if(myBalls[i].getXPosition() >= 550){
                    finished = true;
                }
            }
        }
    }
}
