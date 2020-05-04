package piecePack;

import java.util.ArrayList;
import generic.Color;
import generic.Tile;

/**
 * The Queen Class. This class models the Queen piece.
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class Queen extends Piece {

	/**
	 * The constructor method for the Queen class.
	 * 
	 * @param _color	color of the Piece
	 */
	public Queen(Color _color) {
		super(_color, "Q");
	}

	/**
	 * The move validation method for the Queen class.
	 * 
	 * @param t1			origin Tile
	 * @param t2			destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isValidMove(Tile t1, Tile t2) {
		boolean outcome = false;
		int difference = Math.abs(t2.getRow() - t1.getRow());
		int xdiff = Math.abs(t2.getColumn() - t1.getColumn());
		if (difference > 0 && xdiff == 0) {
			outcome = true;
		} else if (difference == 0 && xdiff > 0) {
			outcome = true;
		} else if (difference == xdiff) {
			outcome = true;
		}
		return outcome;
	}
	
	/**
	 * The path validation method for the Queen class. Checks if cells in path are occupied.
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
		} else if (xdiff == 0) {
			k = Math.abs(difference);
		} else {
			k = Math.abs(xdiff);
		}
		while (k > 0) {
			if (Math.abs(difference) == Math.abs(xdiff)) {
				Tile _tile = board[t1.getRow() + difference][t1.getColumn() + xdiff];
				if (_tile.isOccupied() && !_tile.equals(t2)) {
					result = true;
					break;
				}
				if (xdiff > 0) {
					xdiff--;
				} else {
					xdiff++;
				}
				if (difference > 0) {
					difference--;
				} else {
					difference++;
				}
			} else if (Math.abs(difference) == 0) {
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
			} else {
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
			}
			k--;
		}
		return result;
	}

	/**
	 * The overtake validation method for the Queen class.
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
	 * This method returns the specific tiles in the Queen move path.
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
			if (Math.abs(difference) == Math.abs(xdiff)) {
				Tile _tile = board[t1.getRow() + difference][t1.getColumn() + xdiff];
				if (!_tile.equals(t2)) {
					tileList.add(_tile);
				}
				if (xdiff > 0) {
					xdiff--;
				} else {
					xdiff++;
				}
				if (difference > 0) {
					difference--;
				} else {
					difference++;
				}
			} else if (Math.abs(difference) == 0) {
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