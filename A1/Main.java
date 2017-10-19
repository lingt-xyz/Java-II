
/**
 * Ling Tan, 40014082 
 * COMP249 
 * Assignment 1 
 * Due Date: 2016/09/26
 * 
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Main class. Deal with game starting, input and output.
 * 
 * @author Ling Tan
 *
 */
public class Main {

	private Game game;
	private Scanner keyboard;
	private String[][] playBoard = new String[8][8];

	/**
	 * Initiate Game object and initiate the grid.
	 */
	public Main() {
		game = new Game();
		this.initPlayBoard();
	}

	public static void main(String[] args) {
		Main run = new Main();
		run.start();
	}

	private void initPlayBoard() {
		for (String[] ss : this.playBoard) {
			Arrays.fill(ss, "_");
		}
	}

	/**
	 * start to play the game.
	 */
	private void start() {
		keyboard = new Scanner(System.in);
		System.out.println("Hi, let’s play Battleship!");
		this.initUserPieces();// initiate user's pieces
		game.getReady();// initiate computer's pieces and other necessary information.
		System.out.println("OK, the computer placed its ships and grenades at random. Let’s play.");
		System.out.println();
		while (!game.isDone()) {// before the game is done, keep calling position
			while (game.getStepsCanBeUsedForNow() != 0) {// if the current player can play more than once.
				System.out.print("Position of " + (game.getCurrentPlayer() == Owner.COMPUTER ? "my" : "your") + " rocket: ");
				int[] position = { 0, 0 };
				if (game.getCurrentPlayer() == Owner.COMPUTER) {// generate call position randomly
					Random r = new Random();
					position[0] = r.nextInt(8);
					char firstLetter = (char) (position[0] + (int) ('A'));
					position[1] = r.nextInt(8);
					System.out.println(firstLetter + "" + (position[1] + 1));
				} else {
					String positionStr = keyboard.nextLine();
					char[] chars = positionStr.toUpperCase().toCharArray();
					if (this.isOutOfRange(chars)) {
						System.out.println("Sorry, coordinates outside the grid. Try again.");
						continue;
					}
					position = castCharToInt(positionStr.toUpperCase().toCharArray());
				}

				Cell originalCell = game.shoot(position[0], position[1]);
				if (!originalCell.isBeCalled()) {
					switch (originalCell.getType()) {
					case SHIP:
						this.playBoard[position[0]][position[1]] = originalCell.getOwner() == Owner.COMPUTER ? "S" : "s";
						System.out.println("Ship hit.");
						break;
					case GRENADE:
						this.playBoard[position[0]][position[1]] = originalCell.getOwner() == Owner.COMPUTER ? "G" : "g";
						System.out.println("Boom! Grenade.");
						break;
					case NOTHING:
						this.playBoard[position[0]][position[1]] = "*";
						System.out.println("Nothing.");
						break;
					}
				} else {
					System.out.println("Position already called.");
				}
				if (!game.isDone()) {
					this.printCurrentStates();
				}
			}
			game.switchPlayer();

		}
		System.out.println((game.getWinner() == Owner.COMPUTER ? "I" : "You") + " win!");
		this.printCurrentStates();
		this.keyboard.close();
	}

	private void initUserPieces() {
		this.placeShips();
		this.placeGrenades();
	}

	/**
	 * Place user's ships, according the position offered by user.
	 */
	private void placeShips() {
		int haveGenerated = 0;
		while (haveGenerated < Game.TOTAL_NUMBER_OF_SHIP) {
			System.out.print("Enter the coordinates of your ship #" + (++haveGenerated) + ": ");
			String positionStr = keyboard.nextLine();
			char[] chars = positionStr.toUpperCase().toCharArray();
			if (this.isOutOfRange(chars)) {
				System.out.println("Sorry, coordinates outside the grid. Try again.");
				--haveGenerated;
				continue;
			} else if (this.isOccupied(chars)) {
				System.out.println("Sorry, coordinates already used. Try again.");
				--haveGenerated;
				continue;
			} else {
				int[] position = castCharToInt(chars);
				game.setCell(new Cell(position[0], position[1], Type.SHIP, Owner.USER));
			}
		}
		System.out.println();
	}

	/**
	 * Place user's grenades, according the position offered by user.
	 */
	private void placeGrenades() {
		int haveGenerated = 0;
		while (haveGenerated < Game.TOTAL_NUMBER_OF_GRENADE) {
			System.out.print("Enter the coordinates of your grenade #" + (++haveGenerated) + ": ");
			String positionStr = keyboard.nextLine();
			char[] chars = positionStr.toUpperCase().toCharArray();
			if (this.isOutOfRange(chars)) {
				System.out.println("Sorry, coordinates outside the grid. Try again.");
				--haveGenerated;
				continue;
			} else if (this.isOccupied(chars)) {
				System.out.println("Sorry, coordinates already used. Try again.");
				--haveGenerated;
				continue;
			} else {
				int[] position = castCharToInt(chars);
				game.setCell(new Cell(position[0], position[1], Type.GRENADE, Owner.USER));
			}
		}
		System.out.println();
	}

	/**
	 * Check whether the input is out of range.
	 * 
	 * @param chars
	 * @return true, if out of range; otherwise, false.
	 */
	private boolean isOutOfRange(char[] chars) {
		if ('A' <= chars[0] && chars[0] <= 'H' && 1 <= Character.getNumericValue(chars[1]) && Character.getNumericValue(chars[1]) <= 8) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Check whether the target position is occupied.
	 * 
	 * @param chars
	 * @return true, if occupied; otherwise, false.
	 */
	private boolean isOccupied(char[] chars) {
		int[] position = castCharToInt(chars);
		return game.isOccupied(position[0], position[1]);
	}

	/**
	 * Convert input char to integer
	 * 
	 * @param chars
	 * @return
	 */
	private int[] castCharToInt(char[] chars) {
		int x = (int) (chars[0]) - (int) ('A');
		int y = Character.getNumericValue(chars[1]) - 1;
		return new int[] { x, y };
	}

	/**
	 * Print out the current grid.
	 */
	private void printCurrentStates() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(playBoard[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
