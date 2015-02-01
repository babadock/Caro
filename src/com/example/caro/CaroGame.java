package com.example.caro;

public class CaroGame {
	// OOP knowledge ???
	private char mBoard[];
	private final static int BOARD_SIZE = 9;

	public final char HUMAN_PLAYER = 'x';
	public final char ANDROID_PLAYER = 'o';
	public final char EMPTY_SPACE = ' ';

	public CaroGame() {
		mBoard = new char[BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			mBoard[i] = EMPTY_SPACE;
		}
	}

	public void clearBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			mBoard[i] = EMPTY_SPACE;
		}
	}

	public int getBOARD_SIZE() {
		return BOARD_SIZE;
	}

	public void setMove(char player, int location) {
		mBoard[location] = player;
	}

	public int checkForWinner() {
		// TODO HERE
		return 0;
	}

	public int getComputerMove() {
		// TODO HERE
		return 0;
	}
}
