/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author wung 2019-07-17.
 */
public class TicTacToeSpec {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private TicTacToe ticTacToe;
	
	@Before
	public final void before() {
		ticTacToe = new TicTacToe();
	}
	
	@Test
	public void whenXOutsideBoardThenThrowRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(5, 2);
	}
	
	@Test
	public void whenYOutsideBoardThenThrowRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 5);
	}
	
	@Test
	public void whenOccupiedThenThrowRuntimeException() {
		ticTacToe.play(2, 1);
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 1);
	}
	
	// X 先下
	@Test
	public void givenFirstTurnWhenNextPlayerThenX() {
		Assert.assertEquals('X', ticTacToe.nextPlayer());
	}
	
	// X 之后是 O
	@Test
	public void givenLastTurnWasXWhenNextPlayerThenO() {
		ticTacToe.play(1, 1);
		Assert.assertEquals('O', ticTacToe.nextPlayer());
	}
	
	// 该测试写完后，发现不需要修改实现即可通过，不符合：红灯-绿灯-重构 的TDD 流程，所以，这种单测应该删除。
	// @Test
	// public void givenLastTurnWasOWhenNextPlayerThenX() {
	// 	ticTacToe.play(1, 1);
	// 	ticTacToe.play(1, 2);
	// 	Assert.assertEquals('X', ticTacToe.nextPlayer());
	// }
	
	
	// 无人获胜的情况
	@Test
	public void whenPlayThenNoWinner() {
		String actual = ticTacToe.play(1, 1);
		Assert.assertEquals("No winner", actual);
	}
	
	// 水平方向
	@Test
	public void whenPlayAndWholeHorizontalLineThenWinner() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 1); // X
		ticTacToe.play(2, 2); // O
		String acutal = ticTacToe.play(3, 1); // X
		Assert.assertEquals("X winner", acutal);
	}
	
	// 垂直方向
	@Test
	public void whenPlayAndWholeVerticalLineThenWinner() {
		ticTacToe.play(2, 1); // X
		ticTacToe.play(1, 1); // O
		ticTacToe.play(3, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 2); // X
		String acutal = ticTacToe.play(1, 3); // O
		Assert.assertEquals("O winner", acutal);
	}
	
	
	// 左上角到右下角的对角线
	@Test
	public void whenPlayAndWholeTopBottomDiagonalLineThenWinner() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 2); // X
		ticTacToe.play(1, 3); // O
		String acutal = ticTacToe.play(3, 3); // X
		Assert.assertEquals("X winner", acutal);
	}
	
	// 左下角到右上角的对角线
	@Test
	public void whenPlayAndWholeBottomTopDiagonalLineThenWinner() {
		ticTacToe.play(1, 3); // X
		ticTacToe.play(1, 1); // O
		ticTacToe.play(2, 2); // X
		ticTacToe.play(1, 2); // O
		String acutal = ticTacToe.play(3, 1); // X
		Assert.assertEquals("X winner", acutal);
	}
	
	// 平局
	@Test
	public void t() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(1, 3);
		ticTacToe.play(2, 1);
		ticTacToe.play(2, 3);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 1);
		ticTacToe.play(3, 3);
		String actual = ticTacToe.play(3, 2);
		Assert.assertEquals("draw", actual);
	}
	
}
