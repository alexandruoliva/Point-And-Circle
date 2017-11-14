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

		if (radius < 0 || radius == 0) {
			throw new RadiusExc("raza trebuie sa fie pozitiva");

		} else if (check(radius, x, y, xSpeed, ySpeed) == false) {
			throw new RadiusExc(" cercul este mai mare decat planul");
		} else if (check(radius, x, y, xSpeed, ySpeed)) {
			this.center = new MovablePoint(x, y, xSpeed, ySpeed);
			this.radius = radius;

		}
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius, int x, int y, int xSpeed, int ySpeed) throws RadiusExc {

		if (check(radius, x, y, xSpeed, ySpeed) == false) {
			throw new RadiusExc("raza trebuie sa fie pozitiva");

		} else if (check(radius, x, y, xSpeed, ySpeed) == false) {
			throw new RadiusExc("cercul nu se afla in plan");
		}

		else if (check(radius, x, y, xSpeed, ySpeed)) {
			this.radius = radius;

		}
	}

	public boolean check(int radius, int x, int y, int xSpeed, int ySpeed) {
		boolean i;
		if (radius < 0 || radius == 0 || (radius + x + xSpeed) > PLAIN_X_MAX || (x - radius - xSpeed) < PLAIN_X_MIN
				|| (radius + y + ySpeed) > PLAIN_Y_MAX || (y - radius - ySpeed) < PLAIN_Y_MIN) {
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

	public int getSpeedX() {
		return center.getxSpeed();
	}

	public int getSpeedY() {
		return center.getySpeed();
	}

	@Override
	public void moveUp() throws YoutOfPlainExc, HowMuchExc, XoutOfPlainExc {
		if ((this.getRadius() + this.getCenterX() + this.getSpeedX()) > PLAIN_X_MAX
				|| (this.getCenterX() - this.getRadius() - this.getSpeedX()) < PLAIN_X_MIN
				|| (this.getRadius() + this.getCenterY() + this.getSpeedY()) > PLAIN_Y_MAX
				|| (this.getCenterY() - this.getRadius() - this.getSpeedY()) < PLAIN_Y_MIN) {
			throw new HowMuchExc("cercul s-a deplasat prea mult in sus ");
		} else {
			center.moveUp(this.center.getySpeed());
		}

	}

	@Override
	public void moveDown() throws YoutOfPlainExc, HowMuchExc, XoutOfPlainExc {

		if ((this.getRadius() + this.getCenterX() + this.getSpeedX()) > PLAIN_X_MAX
				|| (this.getCenterX() - this.getRadius() - this.getSpeedX()) < PLAIN_X_MIN
				|| (this.getRadius() + this.getCenterY() + this.getSpeedY()) > PLAIN_Y_MAX
				|| (this.getCenterY() - this.getRadius() - this.getSpeedY()) < PLAIN_Y_MIN) {
			throw new HowMuchExc("cercul s-a deplasat prea mult in jos ");
		} else {

			center.moveDown(this.center.getySpeed());
		}

	}

	@Override
	public void moveLeft() throws XoutOfPlainExc, HowMuchExc, YoutOfPlainExc {
		if ((this.getRadius() + this.getCenterX() + this.getSpeedX()) > PLAIN_X_MAX
				|| (this.getCenterX() - this.getRadius() - this.getSpeedX()) < PLAIN_X_MIN
				|| (this.getRadius() + this.getCenterY() + this.getSpeedY()) > PLAIN_Y_MAX
				|| (this.getCenterY() - this.getRadius() - this.getSpeedY()) < PLAIN_Y_MIN) {
			throw new HowMuchExc("cercul s-a deplasat prea mult in stanga ");
		} else {
			center.moveLeft(this.center.getxSpeed());
		}
	}

	@Override
	public void moveRight() throws XoutOfPlainExc, HowMuchExc, YoutOfPlainExc {
		if ((this.getRadius() + this.getCenterX() + this.getSpeedX()) > PLAIN_X_MAX
				|| (this.getCenterX() - this.getRadius() - this.getSpeedX()) < PLAIN_X_MIN
				|| (this.getRadius() + this.getCenterY() + this.getSpeedY()) > PLAIN_Y_MAX
				|| (this.getCenterY() - this.getRadius() - this.getSpeedY()) < PLAIN_Y_MIN) {
			throw new HowMuchExc("cercul s-a deplasat prea mult in dreapta ");
		} else {
			center.moveRight(this.center.getxSpeed());
		}

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
		// int y=this.getCenterY();
		// int radius= this.getRadius();
		// int x=this.getCenterX();

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
