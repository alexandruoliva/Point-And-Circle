package movable.clase;

import movable.exceptions.HowMuchExc;
import movable.exceptions.RadiusExc;
import movable.exceptions.SpeedExc;
import movable.exceptions.XoutOfPlainExc;
import movable.exceptions.YoutOfPlainExc;
import movable.interfata.Movable;

public class MovableCircle implements Movable {
	private int radius;
	private MovablePoint center;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius)
			throws XoutOfPlainExc, YoutOfPlainExc, SpeedExc, RadiusExc {

		// trebuie un check ca cercul sa fie in plan si fara constrangeri

		if (check(radius, x, y) == false) {
			throw new RadiusExc("raza trebuie sa fie pozitiva");

		} else if (check(radius, x, y) == false) {
			throw new RadiusExc(" cercul este mai mare decat planul");
		} else if (check(radius, x, y)) {
			this.center = new MovablePoint(x, y, xSpeed, ySpeed);
			this.radius = radius;

		}
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius, int x, int y) throws RadiusExc {

		if (check(radius, x, y) == false) {
			throw new RadiusExc("raza trebuie sa fie pozitiva");

		} else if (check(radius, x, y) == false) {
			throw new RadiusExc("cercul nu se afla in plan");
		}

		else if (check(radius, x, y)) {
			this.radius = radius;

		}
	}

	public boolean check(int radius, int x, int y) throws RadiusExc {
		boolean i;
		if (radius < 0 || radius == 0 || (radius + x) > PLAIN_X_MAX || (x - radius) < PLAIN_X_MIN
				|| (radius + y) > PLAIN_Y_MAX || (y - radius) < PLAIN_Y_MIN) {
			i = false;
		} else {
			i = true;
		}
		return i;
	}

	public MovablePoint getCenter() {
		return center;
	}

	public void setCenter(MovablePoint center) {
		this.center = center;
	}

	public int getCenterX() {
		return center.getX();
	}

	public void setCenterX(int x) throws XoutOfPlainExc {
		center.setX(x);
	}

	public int getCenterY() {
		return center.getY();
	}

	public void setCenterY(int y) throws YoutOfPlainExc {
		center.setY(y);
	}

	@Override
	public String toString() {
		return "MovableCircle [raza=" + radius + ", centru=" + center + "]";
	}

	@Override
	public void moveUp() throws YoutOfPlainExc, HowMuchExc, XoutOfPlainExc {

		moveUp(this.center.getySpeed());

	}

	@Override
	public void moveDown() throws YoutOfPlainExc, HowMuchExc, XoutOfPlainExc {
		moveUp(this.center.getySpeed());

	}

	@Override
	public void moveLeft() throws XoutOfPlainExc, HowMuchExc, YoutOfPlainExc {

		moveLeft(this.center.getxSpeed());
	}

	@Override
	public void moveRight() throws XoutOfPlainExc, HowMuchExc, YoutOfPlainExc {
		moveRight(this.center.getxSpeed());

	}

	@Override
	public void moveUp(int howMuch) throws HowMuchExc, YoutOfPlainExc, XoutOfPlainExc {
		if (howMuch < 0) {
			throw new HowMuchExc("numarul de  puncte nu poate fi negativ ");
		} else if (this.getCenterX() > PLAIN_X_MAX || this.getCenterX() < PLAIN_X_MIN) {
			throw new XoutOfPlainExc("X e in afara planului ");
		} else if (this.getCenterY() > PLAIN_Y_MAX || this.getCenterY() < PLAIN_Y_MIN) {
			throw new YoutOfPlainExc("Y e in afara planului");
		} else if (howMuch > 0) {
			int y = this.getCenterY();
			y += howMuch;
			this.setCenterY(y);
		}

	}

	@Override
	public void moveDown(int howMuch) throws HowMuchExc, YoutOfPlainExc, XoutOfPlainExc {
		if (howMuch < 0) {
			throw new HowMuchExc("numarul de  puncte nu poate fi negativ ");
		} else if (this.getCenterX() > PLAIN_X_MAX || this.getCenterX() < PLAIN_X_MIN) {
			throw new XoutOfPlainExc("X e in afara planului ");
		} else if (this.getCenterY() > PLAIN_Y_MAX || this.getCenterY() < PLAIN_Y_MIN) {
			throw new YoutOfPlainExc("Y e in afara planului");
		} else if (howMuch > 0) {
			int y = this.getCenterY();
			y -= howMuch;
			this.setCenterY(y);
		}
	}

	@Override
	public void moveLeft(int howMuch) throws HowMuchExc, XoutOfPlainExc, YoutOfPlainExc {
		if (howMuch < 0) {
			throw new HowMuchExc("numarul de  puncte nu poate fi negativ ");
		} else if (this.getCenterX() > PLAIN_X_MAX || this.getCenterX() < PLAIN_X_MIN) {
			throw new XoutOfPlainExc("X e in afara planului ");
		} else if (this.getCenterY() > PLAIN_Y_MAX || this.getCenterY() < PLAIN_Y_MIN) {
			throw new YoutOfPlainExc("Y e in afara planului");
		} else if (howMuch > 0) {
			int x = this.getCenterX();
			x -= howMuch;
			this.setCenterX(x);
		}
	}

	@Override
	public void moveRight(int howMuch) throws HowMuchExc, XoutOfPlainExc, YoutOfPlainExc {
		if (howMuch < 0) {
			throw new HowMuchExc("numarul de  puncte nu poate fi negativ ");
		} else if (this.getCenterX() > PLAIN_X_MAX || this.getCenterX() < PLAIN_X_MIN) {
			throw new XoutOfPlainExc("X e in afara planului ");
		} else if (this.getCenterY() > PLAIN_Y_MAX || this.getCenterY() < PLAIN_Y_MIN) {
			throw new YoutOfPlainExc("Y e in afara planului");
		} else if (howMuch > 0) {
			int x = this.getCenterX();
			x += howMuch;
			this.setCenterX(x);
		}
		
		
	}

	

}
