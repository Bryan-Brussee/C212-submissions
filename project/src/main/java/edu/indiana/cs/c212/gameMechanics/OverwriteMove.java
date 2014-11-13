package edu.indiana.cs.c212.gameMechanics;

public class OverwriteMove extends Move {


	public OverwriteMove(int x, int y) {
		super(x, y);	
	}
	
	
	@Override
	public String toString() {
		return "OVEWRITE " + super.toString();
	}
	
	}

