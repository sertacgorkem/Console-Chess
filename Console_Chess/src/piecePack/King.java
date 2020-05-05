package piecePack;

import generic.Color;
import generic.Tile;

/**
 * The King Class. This class models the King piece.
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class King extends Piece {

	private boolean isCheck = false;

	/**
	 * The constructor method for the King class.
	 * 
	 * @param _color		color of the Piece
	 */
	public King(Color _color) {
		super(_color, "K");
	}

	/**
	 * The check validation method for the King class.
	 *
	 * @return boolean
	 */
	public boolean getCheck() {
		return isCheck;
	}

	/**
	 * The check setting method for the King class.
	 * 
	 * @param check			whether King is in check
	 */
	public void setCheck(boolean check) {
		isCheck = check;
	}

	/**
	 * The move validation method for the King class.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isValidMove(Tile t1, Tile t2) {
		int difference = Math.abs(t2.getRow() - t1.getRow());
		int xdiff = Math.abs(t2.getColumn() - t1.getColumn());
		if (difference == 1 && xdiff == 1) {
			return true;
		} else if (difference == 1 && xdiff == 0) {
			return true;
		} else if (difference == 0 && xdiff == 1) {
			return true;
		}
		return false;
	}

	/**
	 * The overtake validation method for the King class.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isOvertake(Tile t1, Tile t2) {
		if (t1.getPiece().getColor() == t2.getPiece().getColor()) {
			System.out.print("Same color piece on tile. Try again");
			return false;
		}
		return true;
	}

	/**
	 * The path validation method for the King class. Checks if cells in path are occupied.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @param board			board array
	 * @return boolean
	 */
	@Override
	public boolean inPath(Tile t1, Tile t2, Tile[][] board) {
		return false;
	}
}