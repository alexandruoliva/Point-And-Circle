/*MovablePoint:

Fields:
x:int
y:int
xSpeed:int
ySpeed:int
Methods & Constructors:
MovablePoint(x:int, y:int, xSpeed:int, ySpeed:int)
toString():String
moveUp():void
moveDown():void
moveLeft():void
moveRight():void
moveUp(howMuch:int):void
moveDown(howMuch:int):void
moveLeft(howMuch:int):void
moveRight(howMuch:int):void

*/

package movable.clase;

import movable.exceptions.HowMuchExc;
import movable.exceptions.SpeedExc;
import movable.exceptions.XoutOfPlainExc;
import movable.exceptions.YoutOfPlainExc;
import movable.interfata.Movable;

public class MovablePoint implements Movable {

	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) throws XoutOfPlainExc, YoutOfPlainExc, SpeedExc {
		if (x > PLAIN_X_MAX || x < PLAIN_X_MIN) {
			throw new XoutOfPlainExc("X nu este in plan ");
		} else {
			this.x = x;
		}

		if (y > PLAIN_Y_MAX || y < PLAIN_Y_MIN) {
			throw new YoutOfPlainExc("Y nu este in plan ");
		} else {
			this.y = y;
		}

		if (xSpeed > 0 && ySpeed > 0) {
			this.xSpeed = xSpeed;
			this.ySpeed = ySpeed;
		} else if (xSpeed == 0 || ySpeed == 0 || xSpeed < 0 || ySpeed < 0) {
			throw new SpeedExc(" viteza este  prea mica ");
		}
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) throws XoutOfPlainExc {

		if (x > PLAIN_X_MAX || x < PLAIN_X_MIN) {
			throw new XoutOfPlainExc("X nu este in plan ");
		} else {
			this.x = x;
		}

	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) throws YoutOfPlainExc {
		if (y > PLAIN_Y_MAX || y < PLAIN_Y_MIN) {
			throw new YoutOfPlainExc("Y nu este in plan ");
		} else {
			this.y = y;
		}
	}

	/**
	 * @return the xSpeed
	 */
	public int getxSpeed() {
		return xSpeed;
	}

	/**
	 * @param xSpeed
	 *            the xSpeed to set
	 */
	public void setxSpeed(int xSpeed) throws SpeedExc {

		if (xSpeed < 0) {
			throw new SpeedExc("the xSpeed should be greater than 0");

		} else if (xSpeed == 0) {
			throw new SpeedExc("the xSpeed should be greater  than 0");

		} else {

			this.xSpeed = xSpeed;
		}
	}

	/**
	 * @return the ySpeed
	 */
	public int getySpeed() {
		return ySpeed;
	}

	/**
	 * @param ySpeed
	 *            the ySpeed to set
	 */
	public void setySpeed(int ySpeed) throws SpeedExc {
		if (ySpeed < 0) {
			throw new SpeedExc("the ySpeed should be greater than 0");
		} else if (ySpeed == 0) {
			throw new SpeedExc("the ySpeed should be greater than 0");
		}

		else {
			this.ySpeed = ySpeed;
		}

	}

	@Override
	public void moveUp() throws YoutOfPlainExc, HowMuchExc {
		if ((this.getY() + this.getySpeed()) > PLAIN_Y_MAX || (this.getY() + this.getySpeed()) < PLAIN_Y_MIN) {
			throw new HowMuchExc(" punctul s-a  dus prea mult in sus ");
		} else {
			moveUp(ySpeed);
		}

	}

	@Override
	public void moveDown() throws YoutOfPlainExc, HowMuchExc {
		if ((this.getY() + this.getySpeed()) > PLAIN_Y_MAX || (this.getY() + this.getySpeed()) < PLAIN_Y_MIN) {
			throw new HowMuchExc(" punctul s-a  dus prea mult in jos  ");
		} else {
			moveDown(ySpeed);
		}

	}

	@Override
	public void moveLeft() throws XoutOfPlainExc, HowMuchExc {
		if ((this.getX() + this.getxSpeed()) > PLAIN_X_MAX || (this.getX() + this.getxSpeed()) < PLAIN_X_MIN) {
			throw new HowMuchExc("punctul s-a dus prea mult in stanga ");
		} else {
			moveLeft(xSpeed);
		}
	}

	@Override
	public void moveRight() throws XoutOfPlainExc, HowMuchExc {
		if ((this.getX() + this.getxSpeed()) > PLAIN_X_MAX || (this.getX() + this.getxSpeed()) < PLAIN_X_MIN) {
			throw new HowMuchExc("punctul s-a dus prea mult in dreapta ");
		} else {
			moveRight(xSpeed);
		}

	}

	@Override
	public void moveUp(int howMuch) throws HowMuchExc {
		if (howMuch < 0) {
			throw new HowMuchExc(" nu poti misca punctul cu o valoare negativa");

		} else if (howMuch > 0)
			y += howMuch;

	}

	@Override
	public void moveDown(int howMuch) throws HowMuchExc {
		if (howMuch < 0) {
			throw new HowMuchExc(" nu poti misca punctul cu o valoare negativa");

		} else if (howMuch > 0)
			y -= howMuch;

	}

	@Override
	public void moveLeft(int howMuch) throws HowMuchExc {
		if (howMuch < 0) {
			throw new HowMuchExc("You cannot move the point with a negative value");
		} else if (howMuch > 0) {
			x -= howMuch;
		}

	}

	@Override
	public void moveRight(int howMuch) throws HowMuchExc {
		if (howMuch < 0) {
			throw new HowMuchExc("You cannot move the point with a negative value");
		}

		else if (howMuch > 0) {
			x += howMuch;
		}

	}

	public boolean check(int var) {
		boolean i = false;
		if (var < 0 || var == 0 || var < -1000 || var > 1000) {
			i = false;
		}
		if (var > 0) {
			i = true;
		}

		return i;

	}

	@Override
	public String toString() {
		return "We have a point with x: " + x + " and y: " + y + " with the speed of xSpeed: " + xSpeed
				+ " and ySpeed: " + ySpeed;
	}

}
