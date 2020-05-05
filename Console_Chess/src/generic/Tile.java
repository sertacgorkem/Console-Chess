package generic;

import piecePack.Piece;

/**
 * The Tile Class. This class models the Tiles of the Board.
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class Tile {

	Piece tilePiece = null;
	private int row;
	private int column;
	private String tileColor;

	/**
	 * The constructor method for the Tile class.
	 * 
	 */
	public Tile() {
		tilePiece = null;
	}

	/**
	 * The overloaded constructor method for the Tile class.
	 * 
	 * @param _color	color of tile
	 * @param _x		x position of tile
	 * @param _y		y position of tile
	 */
	public Tile(String _color, int _x, int _y) {
		tileColor = _color;
		row = _x;
		column = _y;
	}

	/**
	 * The overloaded constructor method for the Tile class.
	 * 
	 * @param _x		x position of tile
	 * @param _y		y position of tile
	 * @param _piece	piece occupying tile
	 * @param _color	color of tile
	 */
	public Tile(int _x, int _y, Piece _piece, String _color) {
		row = _x;
		column = _y;
		tilePiece = _piece;
		tileColor = _color;
	}

	/**
	 * This method returns the Piece occupying the tile.
	 * 
	 * @return Piece
	 */
	public Piece getPiece() {
		return tilePiece;
	}
	/**
	 * This method sets the Piece occupying the tile.
	 * 
	 * @param _piece	piece occupying tile
	 */
	public void setPiece(Piece _piece) {
		tilePiece = _piece;
	}

	/**
	 * This method sets the Piece occupying the tile to null.
	 *
	 */
	public void clearPiece() {
		tilePiece = null;
	}

	/**
	 * This method checks if there is a Piece occupying the tile.
	 * 
	 * @return boolean
	 */
	public boolean isOccupied() {
		return (tilePiece != null);
	}

	/**
	 * This method returns the printable color of the tile.
	 * 
	 * @return String
	 */
	public String getPrintColor() {
		return tileColor;
	}

	/**
	 * The row getter method for the Tile class
	 * 
	 * @return int 
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * The column getter method for the Tile class
	 * 
	 * @return int 
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * This method checks to see if the input tile is at the same coordinates as the object calling the method.
	 * 
	 * @param _tile		Tile to check against
	 * @return boolean 
	 */
	public boolean equals(Tile _tile) {
		if (_tile.getRow() == this.getRow() && _tile.getColumn() == this.getColumn()) {
			return true;
		} else {
			return false;
		}
	}
}