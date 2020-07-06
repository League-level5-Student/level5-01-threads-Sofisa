package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot[] robots = new Robot[5];
		Random randy = new Random();
		
		for (int i = 0; i < robots.length; i++) {
			robots [i] = new Robot();
			//minaturize commented out
			robots [i].setX(650);
			robots[i].setY(300);
			

			robots[i].setSpeed(randy.nextInt(50)+1);
			
		}
		
		for (int j = 0; j < 2100; j++) {

		for (int k = 0; k < robots.length; k++) {
			int random = randy.nextInt(10);
			
			if (random >= 9) {
				
			
			robots[k].move(20);
			robots[k].turn(-5);
			robots[k].getX();
			
			if(robots[k].getX() > 645 && j > 70) {
				JOptionPane.showMessageDialog(null, "WINNER");
				}
		}
		}
	
	
    	
	}
	}
	
	
}
