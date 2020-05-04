package piecePack;

import generic.*;

/**
 * The Pawn Class. This class models the Pawn piece.
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class Pawn extends Piece {

	private boolean moved2 = false;

	/**
	 * The constructor method for the Pawn class.
	 * 
	 * @param _color	color of the Piece
	 */
	public Pawn(Color _color) {
		super(_color, "P");
	}

	/**
	 * The move end set method for the Pawn class.
	 * 
	 * @param val			move status
	 */
	public void setMoved2(boolean val) {
		moved2 = true;
	}
	/**
	 * The move end check method for the Pawn class.
	 * 
	 * @return boolean
	 */
	public boolean hasMoved2() {
		return this.moved2;
	}

	/**
	 * The move validation method for the Pawn class.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isValidMove(Tile t1, Tile t2) {
		boolean outcome = false;
		int difference = t2.getRow() - t1.getRow();
		int xdiff = Math.abs(t2.getColumn() - t1.getColumn());
		if (this.hasMoved() == false && Math.abs(difference) == 2 && xdiff == 0) {
			outcome = true;
		} else if (Math.abs(difference) == 1 && xdiff == 0) {
			outcome = true;
		} else if (Math.abs(difference) == 1 && xdiff == 1 && t2.getPiece() != null) {
			outcome = true;
		}
		if (outcome == true) {
			Color _color = this.getColor();
			if (_color == Color.BLACK) {
				if (difference < 0) {
					outcome = false;
				}
			} else {
				if (difference > 0) {
					outcome = false;
				}
			}
		}
		return outcome;
	}

	/**
	 * The overtake validation method for the Pawn class.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isOvertake(Tile t1, Tile t2) {
		boolean outcome = false;
		Color _color = this.getColor();
		int difference = 0;
		int xdiff = t2.getColumn() - t1.getColumn();
		switch (_color) {
		case BLACK:
			difference = t2.getRow() - t1.getRow();
			if (difference > 0) {
				if (difference == 1 && Math.abs(xdiff) == 1) {
					outcome = true;
				}
			}
			break;
		case WHITE:
			difference = t2.getRow() - t1.getRow();
			if (difference < 0) {
				if (difference == -1 && Math.abs(xdiff) == 1) {
					outcome = true;
				} else {
					System.out.print("Input error, Try again");
				}
			}
			break;
		}
		return outcome;
	}

	/**
	 * The path validation method for the Pawn class. Checks if cells in path are occupied.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @param board			board array
	 * @return boolean
	 */
	@Override
	public boolean inPath(Tile t1, Tile t2, Tile[][] board) {
		boolean result = false;
		Color _color = this.getColor();
		int difference = t2.getRow() - t1.getRow();
		int xdiff = Math.abs(t2.getColumn() - t1.getColumn());
		int k = difference;
		switch (_color) {
		case BLACK:
			while (k > 0) {
				Tile _innerTile = board[t1.getRow() + k][t1.getColumn()];
				if (_innerTile.isOccupied() && xdiff == 0) {
					result = true;
					break;
				}
				k--;
			}
			break;
		case WHITE:
			while (k < 0) {
				Tile _innerTile = board[t1.getRow() + k][t1.getColumn()];
				if (_innerTile.isOccupied() && xdiff == 0) {
					result = true;
					break;
				}
				k++;
			}
			break;
		}
		return result;
	}
}