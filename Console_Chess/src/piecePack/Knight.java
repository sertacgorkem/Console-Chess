package piecePack;

import generic.Color;
import generic.Tile;

/**
 * The Knight Class. This class models the Knight piece.
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class Knight extends Piece {

	/**
	 * The constructor method for the Knight class.
	 * 
	 * @param _color	color of the Piece
	 */
	public Knight(Color _color) {
		super(_color, "N");
	}

	/**
	 * The move method for the Knight class.
	 * 
	 * @return boolean
	 */
	public boolean move() {
		boolean outcome = false;
		int _color = 0;
		switch (_color) {
		case 0:
			break;
		case 1:
			break;
		}
		return outcome;
	}

	/**
	 * The move validation method for the Knight class.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isValidMove(Tile t1, Tile t2) {
		int difference = Math.abs(t2.getRow() - t1.getRow());
		int xdiff = Math.abs(t2.getColumn() - t1.getColumn());
		if (xdiff == 1 && difference == 2) {
			return true;
		} else if (xdiff == 2 && difference == 1) {
			return true;
		}
		return false;
	}

	/**
	 * The overtake validation method for the Knight class.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isOvertake(Tile t1, Tile t2) {
		if (t1.getPiece().getColor() == t2.getPiece().getColor()) {
			return false;
		}
		return true;
	}
}