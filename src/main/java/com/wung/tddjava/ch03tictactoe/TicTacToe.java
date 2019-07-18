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
	
	private static final char DEFAULT_CHAR = '\0';
	
	private Character[][] board = {
			{DEFAULT_CHAR, DEFAULT_CHAR, DEFAULT_CHAR},
			{DEFAULT_CHAR, DEFAULT_CHAR, DEFAULT_CHAR},
			{DEFAULT_CHAR, DEFAULT_CHAR, DEFAULT_CHAR}
		};
	
	private static final int SIZE = 3;
	
	private char lastPlayer = DEFAULT_CHAR;
	
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
		if (board[x - 1][y - 1] != DEFAULT_CHAR) {
			throw new RuntimeException("Box is occupied");
		}
		board[x - 1][y - 1] = lastPlayer;
	}
	
	private boolean isWin() {
		int playerTotal = lastPlayer * 3;
		int diagonal1 = DEFAULT_CHAR;
		int diagonal2 = DEFAULT_CHAR;
		for (int index = 0; index < SIZE; index++) {
			diagonal1 += board[index][index];
			diagonal2 += board[index][SIZE - index - 1];
			// 水平
			if (board[0][index] + board[1][index] + board[2][index] == playerTotal) {
				return true;
			}
			// 垂直
			if (board[index][0] + board[index][1] + board[index][2] == playerTotal) {
				return true;
			}
		}
		
		// 对角线
		return (diagonal1 == playerTotal || diagonal2 == playerTotal);
		
	}
}
