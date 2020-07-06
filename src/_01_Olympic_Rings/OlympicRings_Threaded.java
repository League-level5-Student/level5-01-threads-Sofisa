package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	public static void main(String[] args) {

		// Make A Program that uses Threads and robots to draw the Olympic rings. One
		// robot should draw one ring simultaneously with the other 4 robots.
		Robot rob1 = new Robot(400, 700);
		Robot rob2 = new Robot(800, 700);
		Robot rob3 = new Robot(1200, 700);
		Robot rob4 = new Robot(800, 700);
		Robot rob5 = new Robot(1200, 700);

		rob1.setSpeed(10);
		rob2.setSpeed(10);
		rob3.setSpeed(10);
		rob4.setSpeed(10);
		rob5.setSpeed(10);

		Thread r1 = new Thread(() -> {
			for (int i = 0; i < 40; i++) {
			rob1.penDown();
			rob1.turn(10);
			rob1.move(20);
			}
		});

		Thread r2 = new Thread(() -> {
			for (int i = 0; i < 40; i++) {
			rob2.penDown();
			rob2.turn(10);
			rob2.move(20);
			}
		});
		
		Thread r3 = new Thread(() -> {
			rob3.move(100);
			rob3.turn(180);
			for (int i = 0; i < 40; i++) {
			rob3.penDown();
			rob3.turn(10);
			rob3.move(20);
			}
		});
		
		Thread r4 = new Thread(() -> {
			rob4.move(100);
			rob4.turn(180);
			for (int i = 0; i < 40; i++) {
			rob4.penDown();
			rob4.turn(10);
			rob4.move(20);
			}
		});

		Thread r5 = new Thread(() -> {
			rob5.turn(270);
			rob5.move(880);
			for (int i = 0; i < 40; i++) {
			rob5.penDown();
			rob5.turn(10);
			rob5.move(20);
			}
		});
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();

	}
}
