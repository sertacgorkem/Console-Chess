package piecePack;

import java.util.ArrayList;
import generic.Color;
import generic.Tile;


/**
 * The Piece Class. This class models the generic piece. All methods are
 * inherited by the other pieces
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */

public class Piece {

	private Color color;
	private String name;
	private boolean hasMoved = false;
	public boolean toDelete = false;
	private int row;
	private int column;

	
	public Piece() {
	}

	/**
	 * The constructor method for the Piece class.
	 * 
	 * @param _color color of the Piece
	 * @param _name  Name of piece
	 */
	public Piece(Color _color, String _name) {
		color = _color;
		name = _name;
	}

	/**
	 * The Print method for the Piece class.
	 * 
	 * @return String
	 */
	public String print() {
		String toPrint = "";
		if (color == Color.BLACK) {
			toPrint = "b";
		} else {
			toPrint = "w";
		}
		toPrint += name + " ";
		return toPrint;
	}

	/**
	 * The has moved getter for the generic piece class.
	 * 
	 * @return boolean
	 */
	public boolean hasMoved() {
		return hasMoved;
	}

	/**
	 * The has moved setter method for the generic piece class.
	 * 
	 * 
	 */
	public void setMoved() {
		hasMoved = true;
	}

	/**
	 * The color getter method for the generic piece class.
	 * 
	 * @return Color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * The move validation method for the generic piece class.
	 * 
	 * @param original origin Tile
	 * @param goal     destination Tile
	 * @return boolean
	 */
	public boolean isValidMove(Tile original, Tile goal) {
		return false;
	}

	/**
	 * The overtake validation method for the generic piece class.
	 * 
	 * @param original origin Tile
	 * @param goal     destination Tile
	 * @return boolean
	 */
	public boolean isOvertake(Tile original, Tile goal) {
		return false;
	}

	/**
	 * The path validation method for the generic piece class. Checks if cells in
	 * path are occupied.
	 * 
	 * @param original origin Tile
	 * @param goal     destination Tile
	 * @param board    board array
	 * @return boolean
	 */
	public boolean inPath(Tile original, Tile goal, Tile[][] board) {
		return false;
	}

	/**
	 * The row setter method for the generic piece class
	 * 
	 * @param x y coordinate value
	 */
	public void setRow(int x) {
		row = x;
	}

	/**
	 * The column setter method for the generic piece class
	 * 
	 * @param y y coordinate value
	 */
	public void setColumn(int y) {
		column = y;
	}

	/**
	 * The row getter method for the generic piece class
	 * 
	 * @return int
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * The column getter method for the generic piece class
	 * 
	 * @return int
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * The row and column setter method for the generic piece class
	 * 
	 * @param x y coordinate value
	 * @param y y coordinate value
	 */
	public void setLocation(int x, int y) {
		this.row = x;
		this.column = y;
	}

	/**
	 * This method returns the specific tiles in the pieces move path.
	 * 
	 * @param original origin Tile
	 * @param goal     destination Tile
	 * @param board    board array
	 * @return ArrayList
	 */
	public ArrayList<Tile> tilesInBetween(Tile original, Tile goal, Tile[][] board) {
		return null;
	}
}