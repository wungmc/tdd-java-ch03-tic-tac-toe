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
	
}
