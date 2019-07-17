/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe;

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
	
}
