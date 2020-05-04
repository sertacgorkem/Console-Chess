package piecePack;

import java.util.ArrayList;
import generic.Color;
import generic.Tile;

/**
 * The Rook Class. This class models the Rook piece.
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class Rook extends Piece {

	/**
	 * The constructor method for the Rook class.
	 * 
	 * @param _color	color of the Piece
	 */
	public Rook(Color _color) {
		super(_color, "R");
	}

	/**
	 * The move method for the Rook class.
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
	 * The move validation method for the Rook class.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isValidMove(Tile t1, Tile t2) {
		int difference = Math.abs(t2.getRow() - t1.getRow());
		int xdiff = Math.abs(t2.getColumn() - t1.getColumn());
		if (difference > 0 && xdiff == 0) {
			return true;
		} else if (difference == 0 && xdiff > 0) {
			return true;
		} 
		return false;
	}

	/**
	 * The overtake validation method for the Rook class.
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
	 * The path validation method for the Rook class. Checks if cells in path are occupied.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @param board			board array
	 * @return boolean
	 */
	@Override
	public boolean inPath(Tile t1, Tile t2, Tile[][] board) {
		boolean result = false;
		int difference = t2.getRow() - t1.getRow();
		int xdiff = t2.getColumn() - t1.getColumn();
		int k = 0;
		if (difference == 0) {
			k = Math.abs(xdiff);
			while (k > 0) {
				Tile _tile = board[t1.getRow()][t1.getColumn() + xdiff];
				if (_tile.isOccupied() && !_tile.equals(t2)) {
					result = true;
					break;
				}
				if (xdiff > 0) {
					xdiff--;
				} else {
					xdiff++;
				}
				k--;
			}
		} else {
			k = Math.abs(difference);
			while (k > 0) {
				Tile _tile = board[t1.getRow() + difference][t1.getColumn()];
				if (_tile.isOccupied() && !_tile.equals(t2)) {
					result = true;
					break;
				}
				if (difference > 0) {
					difference--;
				} else {
					difference++;
				}
				k--;
			}
		}
		return result;
	}

	/**
	 * This method returns the specific tiles in the Rook move path.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @param board			board array
	 * @return ArrayList
	 */
	@Override
	public ArrayList<Tile> tilesInBetween(Tile t1, Tile t2, Tile[][] board) {
		ArrayList<Tile> tileList = new ArrayList<Tile>();
		int difference = t2.getRow() - t1.getRow();
		int xdiff = t2.getColumn() - t1.getColumn();
		int k = 0;
		if (difference == 0) {
			k = Math.abs(xdiff);
		} else if (xdiff == 0) {
			k = Math.abs(difference);
		} else {
			k = Math.abs(xdiff);
		}
		while (k > 0) {
			if (Math.abs(difference) == 0) {
				Tile _tile = board[t1.getRow()][t1.getColumn() + xdiff];
				if (!_tile.equals(t2)) {
					tileList.add(_tile);
				}
				if (xdiff > 0) {
					xdiff--;
				} else {
					xdiff++;
				}
			} else {
				Tile _tile = board[t1.getRow() + difference][t1.getColumn()];
				if (!_tile.equals(t2)) {
					tileList.add(_tile);
				}
				if (difference > 0) {
					difference--;
				} else {
					difference++;
				}
			}
			k--;
		}
		return tileList;
	}
}