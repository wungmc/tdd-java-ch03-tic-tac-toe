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
		
		if (isWin(x, y)) {
			return lastPlayer + " winner";
		}
		if (isDraw()) {
			return "draw";
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
			throw new RuntimeException("axis is outside board!");
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
	
	private boolean isWin(int x, int y) {
		int playerTotal = lastPlayer * 3;
		int horizontal = '\0';
		int vertical = '\0';
		int diagonal1 = '\0';
		int diagonal2 = '\0';
		for (int index = 0; index < SIZE; index++) {
			// 无需检查所有条件，只检查与最后一个落子位置相关的获胜条件即可。
			horizontal += board[index][y - 1];
			vertical += board[x - 1][index];
			diagonal1 += board[index][index];
			diagonal2 += board[index][SIZE - index - 1];
			
		}
		
		if (horizontal == playerTotal ||
				vertical == playerTotal ||
				diagonal1 == playerTotal ||
				diagonal2 == playerTotal) {
			return true;
		}

		return false;
	}
	
	private boolean isDraw() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == '\0') {
					return false;
				}
			}
		}
		return true;
	}
	
}
