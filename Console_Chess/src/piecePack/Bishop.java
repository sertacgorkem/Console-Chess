package piecePack;

import generic.Color;
import generic.Tile;
import java.util.*;

/**
 * The Bishop Class. This class models the Bishop piece.
 *
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class Bishop extends Piece {

	/**
	 * The constructor method for the Bishop class.
	 * 
	 * @param _color Color of piece
	 */
	public Bishop(Color _color) {
		super(_color, "B");
	}

	/**
	 * The move method for the Bishop class.
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
	 * The move validation method for the Bishop class.
	 * 
	 * @param t1 origin Tile
	 * @param t2 destination Tile
	 * @return boolean
	 */
	@Override
	public boolean isValidMove(Tile t1, Tile t2) {
		int difference = Math.abs(t2.getRow() - t1.getRow());
		int xdiff = Math.abs(t2.getColumn() - t1.getColumn());
		if (difference == xdiff) {
			return true;
		}
		return false;
	}

	/**
	 * The overtake validation method for the Bishop class.
	 * 
	 * @param t1 origin Tile
	 * @param t2 destination Tile
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
	 * The path validation method for the Bishop class. Checks if cells in path are
	 * occupied.
	 * 
	 * @param t1    origin Tile
	 * @param t2    destination Tile
	 * @param board board array
	 * @return boolean
	 */
	@Override
	public boolean inPath(Tile t1, Tile t2, Tile[][] board) {
		int difference = t2.getRow() - t1.getRow();
		int xdiff = t2.getColumn() - t1.getColumn();
		int k = Math.abs(xdiff);
		while (k > 0) {
			Tile _tile = board[t1.getRow() + difference][t1.getColumn() + xdiff];
			if (_tile.isOccupied() && !_tile.equals(t2)) {
				return true;
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
			k--;
		}
		return false;
	}

	/**
	 * This method returns the specific tiles in the Bishop move path.
	 * 
	 * @param t1    origin Tile
	 * @param t2    destination Tile
	 * @param board board array
	 * @return ArrayList
	 */
	@Override
	public ArrayList<Tile> tilesInBetween(Tile t1, Tile t2, Tile[][] board) {
		ArrayList<Tile> tileList = new ArrayList<Tile>();
		int difference = t2.getRow() - t1.getRow();
		int xdiff = t2.getColumn() - t1.getColumn();
		int k = Math.abs(xdiff);
		while (k > 0) {
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
			k--;
		}
		return tileList;
	}
}