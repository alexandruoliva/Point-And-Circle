package movable.interfata;

import movable.exceptions.HowMuchExc;
import movable.exceptions.XoutOfPlainExc;
import movable.exceptions.YoutOfPlainExc;

/**
 * Specifies that a geometric form is movable in a 2D plain.
 */
public interface Movable {

	int PLAIN_X_MAX = 1000;
	int PLAIN_Y_MAX = 1000;
	int PLAIN_X_MIN = -1000;
	int PLAIN_Y_MIN = -1000;

	/**
	 * Moves the form up in the plain. The implementation should take care of
	 * how much will this movement be.
	 * 
	 * @throws HowMuchExc
	 * @throws YoutOfPlainExc
	 * @throws XoutOfPlainExc
	 * @throws HowMuchExc
	 * 
	 */
	void moveUp() throws YoutOfPlainExc, HowMuchExc, XoutOfPlainExc;

	/**
	 * Moves the form down in the plain. The implementation should take care of
	 * how much will this movement be.
	 * 
	 * @throws HowMuchExc
	 * @throws YoutOfPlainExc
	 * @throws XoutOfPlainExc
	 */
	void moveDown() throws YoutOfPlainExc, HowMuchExc, XoutOfPlainExc;

	/**
	 * Moves the form left in the plain. The implementation should take care of
	 * how much will this movement be.
	 * 
	 * @throws HowMuchExc
	 * @throws XoutOfPlainExc
	 * @throws YoutOfPlainExc
	 */
	void moveLeft() throws XoutOfPlainExc, HowMuchExc, YoutOfPlainExc;

	/**
	 * Moves the form right in the plain. The implementation should take care of
	 * how much will this movement be.
	 * 
	 * @throws HowMuchExc
	 * @throws XoutOfPlainExc
	 * @throws YoutOfPlainExc
	 */
	void moveRight() throws XoutOfPlainExc, HowMuchExc, YoutOfPlainExc;

	/**
	 * Moves the form up in the plain with the specified number of points.
	 * 
	 * @param howMuch
	 *            the number of points to move up in the plain
	 * @throws HowMuchExc
	 * @throws XoutOfPlainExc
	 * @throws YoutOfPlainExc
	 */
	void moveUp(int howMuch) throws HowMuchExc, YoutOfPlainExc, XoutOfPlainExc;

	/**
	 * Moves the form down in the plain with the specified number of points.
	 * 
	 * @param howMuch
	 *            the number of points to move down in the plain
	 * @throws HowMuchExc
	 * @throws XoutOfPlainExc
	 * @throws YoutOfPlainExc
	 */
	void moveDown(int howMuch) throws HowMuchExc, YoutOfPlainExc, XoutOfPlainExc;

	/**
	 * Moves the form left in the plain with the specified number of points.
	 * 
	 * @param howMuch
	 *            the number of points to move left in the plain
	 * @throws HowMuchExc
	 * @throws YoutOfPlainExc
	 * @throws XoutOfPlainExc
	 */
	void moveLeft(int howMuch) throws HowMuchExc, XoutOfPlainExc, YoutOfPlainExc;

	/**
	 * Moves the form right in the plain with the specified number of points.
	 * 
	 * @param howMuch
	 *            the number of points to move right in the plain
	 * @throws HowMuchExc
	 * @throws YoutOfPlainExc
	 * @throws XoutOfPlainExc
	 */
	void moveRight(int howMuch) throws HowMuchExc, XoutOfPlainExc, YoutOfPlainExc;
}