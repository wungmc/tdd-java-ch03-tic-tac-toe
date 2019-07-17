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
	
	private char lastPlayer = '\0';
	
	public void play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		setBox(x, y);
		lastPlayer = nextPlayer();
	}
	
	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}
	
	private void checkAxis(int axis) {
		if (axis < 1 || axis > 3) {
			throw new RuntimeException("Y is outside board!");
		}
	}
	
	private void setBox(int x, int y) {
		if (board[x - 1][y - 1] != '\0') {
			throw new RuntimeException("Box is occupied");
		}
		else {
			board[x - 1][y - 1] = 'X';
		}
	}
	
}
