/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe;

/**
 * 井字游戏：玩家分为X和O，在一个 3*3 的棋盘上轮流放子，先在横、竖或者对角线上放满 3 个子的胜出。
 *
 * @author wung 2019-07-17.
 */
public class TicTacToe {
	
	private Character[][] board = {
			{'\0', '\0', '\0'},
			{'\0', '\0', '\0'},
			{'\0', '\0', '\0'}
	};
	
	private static final int SIZE = 3;
	
	private char lastPlayer = '\0';
	
	public String play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();
		setBox(x, y, lastPlayer);
		
		if (isWin()) {
			return lastPlayer + " winner";
		}
		return "No winner";
	}
	
	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}
	
	private void checkAxis(int axis) {
		if (axis < 1 || axis > SIZE) {
			throw new RuntimeException("Y is outside board!");
		}
	}
	
	private void setBox(int x, int y, char lastPlayer) {
		if (board[x - 1][y - 1] != '\0') {
			throw new RuntimeException("Box is occupied");
		}
		else {
			board[x - 1][y - 1] = lastPlayer;
		}
	}
	
	private boolean isWin() {
		for (int index = 0; index < SIZE; index++) {
			if (board[0][index].equals(lastPlayer) &&
					board[1][index].equals(lastPlayer) &&
					board[2][index].equals(lastPlayer)
					) {
				return true;
			}
			if (board[index][0].equals(lastPlayer) &&
					board[index][1].equals(lastPlayer) &&
					board[index][2].equals(lastPlayer)
					) {
				return true;
			}
		}
		
		if (board[0][0].equals(lastPlayer) &&
				board[1][1].equals(lastPlayer) &&
				board[2][2].equals(lastPlayer)
				) {
			return true;
		}
		if (board[0][2].equals(lastPlayer) &&
				board[1][1].equals(lastPlayer) &&
				board[2][0].equals(lastPlayer)
				) {
			return true;
		}

		return false;
	}
}
