package movable.main;

import movable.clase.MovableCircle;
import movable.clase.MovablePoint;
import movable.exceptions.HowMuchExc;
import movable.exceptions.RadiusExc;
import movable.exceptions.SpeedExc;
import movable.exceptions.XoutOfPlainExc;
import movable.exceptions.YoutOfPlainExc;
import movable.interfata.Movable;

public class Main {

	public static void main(String[] args) throws XoutOfPlainExc, YoutOfPlainExc, SpeedExc, HowMuchExc, RadiusExc {
		MovablePoint p = new MovablePoint(7, 4, 4, 7);
		System.out.println(p.toString());
		p.moveDown();
		System.out.println(p.toString());
		//                           x   y   xspeed yspeed radius
		Movable p1 = new MovableCircle(40, 70, 400, 1000, 50);
		System.out.println(p1.toString());
		p1.moveUp();
		p1.moveRight();
		System.out.println(p1.toString());

	}

}
