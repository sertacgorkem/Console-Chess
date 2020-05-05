package chess;

import java.util.*;
import generic.*;
import piecePack.*;

/**
 * Board Class. The Maintains the state of the Board and the Pieces
 *
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class Board {

	private boolean[] drawArr;
	private boolean[] resignArr;
	private Tile[][] board;
	private Color gameTurn = Color.WHITE;
	private GameState gameState;
	private King whiteKing;
	private King blackKing;
	private ArrayList<Piece> pieceList;

	/**
	 * The constructor method for the Board class.
	 * 
	 * @param customLoadOut			board number
	 */
	public Board(int customLoadOut) {
		pieceList = new ArrayList<Piece>();
		drawArr = new boolean[2];
		Arrays.fill(drawArr, false);
		resignArr = new boolean[2];
		Arrays.fill(resignArr, false);
		board = new Tile[8][8];
		if (customLoadOut == 0) {
			customLoad();
		} else if (customLoadOut == 1) {
			customLoad2();
		} else if (customLoadOut == 2) {
			setup();
		} else {
			setup();
		}
		gameState = GameState.CONTINUE;
	}


	/**
	 * This method setup the board in default configuration.
	 *
	 */
	private void setup() {
		int[] setupArr = { 0, 1, 6, 7 };
		int row = 0;
		Color _color = Color.BLACK;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tile _tile;
				String tileColor = GenericFunctions.tileColorFinder(i, j);
				if (i == setupArr[row]) {
					if (i == 0 || i == 7) {
						int _column = 0;
						String _tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _rook = new Rook(_color);
						_tile = new Tile(i, _column, _rook, _tcolor);
						pieceList.add(_rook);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						board[i][_column] = _tile;
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _knight = new Knight(_color);
						_tile = new Tile(i, _column, _knight, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_knight);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _bishop = new Bishop(_color);
						_tile = new Tile(i, _column, _bishop, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_bishop);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _queen = new Queen(_color);
						_tile = new Tile(i, _column, _queen, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_queen);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _king = new King(_color);
						_tile = new Tile(i, _column, _king, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_king);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						if (blackKing == null) {
							blackKing = (King) _king;
						} else {
							whiteKing = (King) _king;
						}
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _bishop2 = new Bishop(_color);
						_tile = new Tile(i, _column, _bishop2, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_bishop2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _knight2 = new Knight(_color);
						_tile = new Tile(i, _column, _knight2, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_knight2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _rook2 = new Rook(_color);
						_tile = new Tile(i, _column, _rook2, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_rook2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						break;
					} else {
						Piece _pawn = new Pawn(_color);
						_tile = new Tile(i, j, _pawn, tileColor);
						pieceList.add(_pawn);
						pieceList.get(pieceList.size() - 1).setLocation(i, j);
						board[i][j] = _tile;
					}
				} else {
					board[i][j] = new Tile(tileColor, i, j);
				}
			}
			if (i == setupArr[row]) {
				row++;
				if (row > 1)
					_color = Color.WHITE;
			}
		}
	}


	/**
	 * This method setup the board in test configuration 1.
	 *
	 */
	private void customLoad() {
		int[] setupArr = { 0, 1, 4, 7 };
		int row = 0;
		Color _color = Color.BLACK;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tile _tile;
				String tileColor = GenericFunctions.tileColorFinder(i, j);
				if (i == setupArr[row]) {
					if (i == 0 || i == 7) {
						int _column = 0;
						String _tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _rook = new Rook(_color);
						_tile = new Tile(i, _column, _rook, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_rook);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _knight = new Knight(_color);
						_tile = new Tile(i, _column, _knight, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_knight);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _bishop = new Bishop(_color);
						_tile = new Tile(i, _column, _bishop, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_bishop);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _queen = new Queen(_color);
						_tile = new Tile(i, _column, _queen, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_queen);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _king = new King(_color);
						_tile = new Tile(i, _column, _king, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_king);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						if (blackKing == null) {
							blackKing = (King) _king;
						} else {
							whiteKing = (King) _king;
						}
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _bishop2 = new Bishop(_color);
						_tile = new Tile(i, _column, _bishop2, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_bishop2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _knight2 = new Knight(_color);
						_tile = new Tile(i, _column, _knight2, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_knight2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _rook2 = new Rook(_color);
						_tile = new Tile(i, _column, _rook2, _tcolor);
						pieceList.add(_rook2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						board[i][_column] = _tile;
						break;
					} else {
						Piece _pawn = new Pawn(_color);
						_tile = new Tile(i, j, _pawn, tileColor);
						pieceList.add(_pawn);
						pieceList.get(pieceList.size() - 1).setLocation(i, j);
						board[i][j] = _tile;
					}
				} else {
					board[i][j] = new Tile(tileColor, i, j);
				}
			}
			if (i == setupArr[row]) {
				row++;
				if (row > 1)
					_color = Color.WHITE;
			}
		}
	}

	/**
	 * This method setup the board in test configuration 2.
	 *
	 */
	private void customLoad2() {
		int[] setupArr = { 0, 7 };
		int row = 0;
		Color _color = Color.BLACK;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tile _tile;
				String tileColor = GenericFunctions.tileColorFinder(i, j);
				if (i == setupArr[row]) {
					if (i == 0 || i == 7) {
						int _column = 0;
						String _tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _rook = new Rook(_color);
						_tile = new Tile(i, _column, _rook, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_rook);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _knight = new Knight(_color);
						_tile = new Tile(i, _column, _knight, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_knight);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _bishop = new Bishop(_color);
						_tile = new Tile(i, _column, _bishop, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_bishop);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _queen = new Queen(_color);
						_tile = new Tile(i, _column, _queen, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_queen);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _king = new King(_color);
						_tile = new Tile(i, _column, _king, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_king);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						if (blackKing == null) {
							blackKing = (King) _king;
						} else {
							whiteKing = (King) _king;
						}
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _bishop2 = new Bishop(_color);
						_tile = new Tile(i, _column, _bishop2, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_bishop2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _knight2 = new Knight(_color);
						_tile = new Tile(i, _column, _knight2, _tcolor);
						board[i][_column] = _tile;
						pieceList.add(_knight2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						_column++;
						_tcolor = GenericFunctions.tileColorFinder(i, _column);
						Piece _rook2 = new Rook(_color);
						_tile = new Tile(i, _column, _rook2, _tcolor);
						pieceList.add(_rook2);
						pieceList.get(pieceList.size() - 1).setLocation(i, _column);
						board[i][_column] = _tile;
						if (_color == Color.BLACK) {
							_tcolor = GenericFunctions.tileColorFinder(1, 3);
							Piece _pawn = new Pawn(_color);
							_tile = new Tile(1, 3, _pawn, tileColor);
							pieceList.add(_pawn);
							pieceList.get(pieceList.size() - 1).setLocation(1, 3);
							board[1][3] = _tile;
							_tcolor = GenericFunctions.tileColorFinder(1, 5);
							_pawn = new Pawn(_color);
							_tile = new Tile(1, 5, _pawn, tileColor);
							pieceList.add(_pawn);
							pieceList.get(pieceList.size() - 1).setLocation(1, 5);
							board[1][5] = _tile;
						}
						break;
					} else {
						Piece _pawn = new Pawn(_color);
						_tile = new Tile(i, j, _pawn, tileColor);
						pieceList.add(_pawn);
						pieceList.get(pieceList.size() - 1).setLocation(i, j);
						board[i][j] = _tile;
					}
				} else {
					if (board[i][j] == null) {
						board[i][j] = new Tile(tileColor, i, j);
					}
				}
			}
			if (i == setupArr[row]) {
				row++;
				if (row > 0)
					_color = Color.WHITE;
			}
		}
	}

	/**
	 * This method returns the gameState value, called after each turn
	 *
	 * @return GameState 
	 */
	public GameState getState() {
		return gameState;
	}

	/**
	 * This method sets the gamestate of the board. Called to end game.
	 * 
	 * @param _gs	the state of the game
	 */
	public void setState(GameState _gs) {
		gameState = _gs;
	}

	/**
	 * This method returns the color of the current turn.
	 * 
	 * @return Color 
	 */
	public Color getTurn() {
		return gameTurn;
	}

	/**
	 * This method sets the gamestate to draw.
	 * 
	 * @param val whether draw was requested
	 */
	public void makeDraw(boolean val) {
		if (val == true) {
			if (drawArr[0] == true) {
				drawArr[1] = true;
				this.setState(GameState.DRAW);
			} else {
				drawArr[0] = true;
				this.setTurn(this.getTurn().getOpposite());
			}
		} else {
			if (drawArr[0] == true) {
				drawArr[0] = false;
			}
		}
	}

	/**
	 * This method returns the value of the drawArr to see if the current turn
	 * requested a draw.
	 * 
	 * @return boolean
	 */
	public boolean getDraw() {
		return drawArr[0];
	}

	/**
	 * This method sets the color of the current turn.
	 * 
	 * @param _turn			Color of current turn
	 */
	public void setTurn(Color _turn) {
		gameTurn = _turn;
	}



	/**
	 * This method prints the board in default configuration.
	 *
	 */
	public void printBoard() {
		int rowCounter = 8;
		for (int i = 0; i < 9; i++) {
			if (i < 8) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece() != null) {
						System.out.print(board[i][j].getPiece().print());
					} else {
						System.out.print(board[i][j].getPrintColor());
					}
					if (j == 7) {
						System.out.println(rowCounter);
						rowCounter--;
					}
				}
			} else {
				System.out.print(" a ");
				System.out.print(" b ");
				System.out.print(" c ");
				System.out.print(" d ");
				System.out.print(" e ");
				System.out.print(" f ");
				System.out.print(" g ");
				System.out.print(" h ");
			}
		}
	}

	/**
	 * This method executes requested moves.
	 *
	 * @param firstPosition 	origin positio
	 * @param secondPosition 	destination position
	 * @param prom 				value of promotion string
	 */
	public void move(int firstPosition, int secondPosition, String prom) {
		int _x1 = -1;
		int _y1 = -1;
		int _x2 = -1;
		int _y2 = -1;
		try {
			if (firstPosition >= 64 || secondPosition >= 64 || firstPosition < 0 || secondPosition < 0) {
				throw new Exception();
			}
			_x1 = firstPosition / 8;
			_y1 = firstPosition % 8;

			_x2 = secondPosition / 8;
			_y2 = secondPosition % 8;
		} catch (Exception ex) {
			System.out.print("Input error while moving. Try Again");
			return;
		}
		if (_x1 != -1 && _y1 != -1 && _x2 != -1 && _y2 != -1) {
			Tile _t1 = board[_x1][_y1];
			if (_t1.getPiece() == null) {
				System.out.print("Must have a piece at starting position. Try Again");
				return;
			}
			Piece _piece = _t1.getPiece();
			if (_piece.getColor() != getTurn()) {
				System.out.println("Must select with matching color at starting position. Try Again");
				return;
			}
			Tile _t2 = board[_x2][_y2];
			Tile _t3 = board[_x2][_y2];
			boolean isValid = _piece.isValidMove(_t1, _t2);
			boolean hasMoved = false;
			boolean illegalMove = false;
			boolean enPassant = false;
			boolean canCastle = false;
			boolean queenSide = false;
			if (_piece instanceof King && isValid == false) {
				if (_piece.hasMoved() == false) {
					if (_t1.getRow() == _t2.getRow()) {
						canCastle = this.checkCastle(_t1, _t2);
						if (canCastle == true) {
							if (_t2.getColumn() == 2) {
								queenSide = true;
							}
							isValid = true;
						} else {
							System.out.print("Cannot castle. Try Again");
						}
					}
				}
			}
			if (_piece instanceof Pawn && isValid == false) {
				if (_y2 != 0 && _y2 != 7) {
					int addPassant = 0;
					if (this.getTurn() == Color.WHITE) {
						addPassant++;
					} else {
						addPassant--;
					}
					_t3 = board[_x2 + addPassant][_y2];
					if (_t3.isOccupied() == true) {
						Piece minusOne = _t3.getPiece();
						if (minusOne instanceof Pawn) {
							Pawn _pawn = (Pawn) minusOne;
							if (_pawn.hasMoved2() == true) {
								enPassant = true;
								isValid = true;
							}
						}
					}
				}
			}
			if (isValid == true) {
				if (_t2.getPiece() != null || enPassant == true) {
					boolean canOvertake = _piece.isOvertake(_t1, _t2);
					boolean inPath = _piece.inPath(_t1, _t2, board);
					if (inPath == false) {
						if (canOvertake == true) {
							Piece _otherPiece = _t2.getPiece();
							if (enPassant == true) {
								_otherPiece = _t3.getPiece();
							}
							if (_otherPiece.getColor() != _piece.getColor()) {
								_t1.clearPiece();
								_t2.clearPiece();
								_t2.setPiece(_piece);
								_piece.setLocation(_t2.getRow(), _t2.getColumn());
								if (enPassant == true) {
									_t3.clearPiece();
								}
								this.removePieceFromList(_otherPiece);
								Tile isSelfCheck = this.isCheck(_piece.getColor());
								if (isSelfCheck != null) {
									_t1.setPiece(_piece);
									_t2.clearPiece();
									_t2.setPiece(_otherPiece);
									_piece.setLocation(_t1.getRow(), _t1.getColumn());
									pieceList.add(_otherPiece);
									if (enPassant == true) {
										_t3.setPiece(_otherPiece);
									}
									illegalMove = true;
								}
								if (illegalMove == false) {
									hasMoved = true;
									if (_piece.hasMoved() == false) {
										_piece.setMoved();
									}
								}
							} else {
								System.out.print("Obstacle in path. Try again.");
							}
						}
					}
				} else {
					boolean inPath = _piece.inPath(_t1, _t2, board);
					if (inPath == false) {
						_t1.clearPiece();
						_t2.setPiece(_piece);
						_piece.setLocation(_t2.getRow(), _t2.getColumn());
						Tile isSelfCheck = this.isCheck(_piece.getColor());
						if (canCastle == false) {
							if (isSelfCheck != null) {
								_t1.setPiece(_piece);
								_t2.clearPiece();
								_piece.setLocation(_t1.getRow(), _t1.getColumn());
								illegalMove = true;
							}
						} else {
							int rookColumn = 0;
							int newPosition = 3;
							if (queenSide == false) {
								rookColumn = 7;
								newPosition = 5;
							}
							Piece _rook = board[_t1.getRow()][rookColumn].getPiece();
							if (_rook.hasMoved() == false) {
								_rook.setMoved();
							}
							board[_t1.getRow()][rookColumn].clearPiece();
							board[_t1.getRow()][newPosition].setPiece(_rook);
						}
						if (illegalMove == false) {
							hasMoved = true;
						}
						if (_piece.hasMoved() == false && hasMoved == true) {
							_piece.setMoved();
							if (Math.abs(_t2.getRow() - _t1.getRow()) == 2) {
								if ((_piece instanceof Pawn) && (Math.abs(_t2.getRow() - _t1.getRow()) == 2)) {
									Pawn _pawn = (Pawn) _piece;
									_pawn.setMoved2(true);
								}
							}
						}
					} else {
						System.out.print("Obstacle in path. Try again");
					}
				}
				if (hasMoved == true) {
					int _rowdiff = Math.abs(_t2.getRow() - _t1.getRow());
					if (_piece instanceof Pawn) {
						Pawn _pawn = (Pawn) _piece;
						if (_pawn.hasMoved2() == true && _rowdiff == 1) {
							_pawn.setMoved2(false);
						}
						if (_pawn.getRow() == 7 || _pawn.getRow() == 0) {
							this.pawnPromotion(_piece, prom);
						}
					}
					Color currentColor = _piece.getColor();
					Tile isCheck = this.isCheck(_piece.getColor().getOpposite());
					if (isCheck != null) {
						System.out.print("Check");
						if (currentColor.getOpposite() == Color.WHITE) {
							whiteKing.setCheck(true);
						} else {
							blackKing.setCheck(true);
						}
						boolean moveMate = this.isMate(_piece.getColor().getOpposite(), isCheck);
						if (moveMate == true) {
							System.out.println(" Mate");
							if (currentColor.getOpposite() == Color.WHITE) {
								gameState = GameState.BLACK_WINS;
							} else {
								gameState = GameState.WHITE_WINS;
							}
						}
					} else {
						King checkedKing;
						if (currentColor == Color.WHITE) {
							checkedKing = whiteKing;
						} else {
							checkedKing = blackKing;
						}
						if (checkedKing.getCheck() == true) {
							checkedKing.setCheck(false);
						}
					}
					this.setTurn(this.getTurn().getOpposite());
				} else if (illegalMove == true) {
					System.out.print("Illegal Move. Try Again");
				}
			}
		}
	}
	/**
	 * This method checks whether the board conditions for castling are satisfied.
	 * 
	 * @param  _t1 				Origin Tile
	 * @param  _t2				Dest Tile 
	 * @return boolean
	 */
	private boolean checkCastle(Tile _t1, Tile _t2) {
		boolean result = false;
		Tile _rookTile = null;
		Piece _rp;
		int collDiff = 0;
		if (_t2.getColumn() == 2) {
			_rookTile = board[_t1.getRow()][0];
			collDiff = -2;
		} else if (_t2.getColumn() == 6) {
			_rookTile = board[_t1.getRow()][7];
			collDiff = 2;
		}
		if (_rookTile != null) {
			if (_rookTile.isOccupied() == true) {
				_rp = _rookTile.getPiece();
				if (_rp instanceof Rook && _rp.hasMoved() == false) {
					boolean isValid = _rp.isValidMove(_rookTile, _t1);
					boolean inPath = _rp.inPath(_rookTile, _t1, this.board);
					if (isValid == true && inPath == false) {
						ArrayList<Tile> _inbetween = new ArrayList<Tile>();
						int counter = 0;
						int absDiff = Math.abs(collDiff);
						while (counter <= absDiff) {
							Tile _innerTile = this.board[_t1.getRow()][_t1.getColumn() + collDiff];
							if (_innerTile.isOccupied() == true) {
								break;
							} else {
								_inbetween.add(_innerTile);
							}
							if (collDiff < 0) {
								collDiff++;
							} else {
								collDiff--;
							}
							counter++;
						}
						if (_inbetween != null) {
							if (_inbetween.size() > 0) {
								boolean cantCheck = false;
								for (int i = 0; i < _inbetween.size(); i++) {
									Tile _innerTile = _inbetween.get(i);
									boolean resultOfCheck = isCheck(_t1.getPiece().getColor(), _innerTile,
											this.pieceList);
									if (resultOfCheck == true) {
										cantCheck = true;
									}
								}
								if (cantCheck == false) {
									result = true;
								}
							}
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * This method checks whether the tile conditions for check are satisfied.
	 * 
	 * @param  _color			color of current turn
	 * @return Tile
	 */
	private Tile isCheck(Color _color) {
		Tile checkTile = null;
		Tile kingTile;
		if (_color == Color.WHITE) {
			kingTile = board[whiteKing.getRow()][whiteKing.getColumn()];
		} else {
			kingTile = board[blackKing.getRow()][blackKing.getColumn()];
		}
		for (Piece _piece : pieceList) {

			if (_piece.getColor() != _color) {
				Tile pieceTile = board[_piece.getRow()][_piece.getColumn()];
				boolean isValid = _piece.isValidMove(pieceTile, kingTile);
				if(isValid == true) {
					boolean inPath = _piece.inPath(pieceTile, kingTile, this.board);
					if (inPath == false) {
						checkTile = pieceTile;
						break;
					}
				}
			}
		}
		return checkTile;
	}

	/**
	 * This method checks whether the board conditions for check are satisfied.
	 * 
	 * @param _color				color of current turn
	 * @param potentialTile			input tile
	 * @param plist					list of active tiles
	 * @return boolean 
	 */
	private boolean isCheck(Color _color, Tile potentialTile, ArrayList<Piece> plist) {
		boolean check = false;
		Tile kingTile = potentialTile;

		for (Piece _piece : plist) {

			if (_piece.getColor() != _color) {
				Tile pieceTile = board[_piece.getRow()][_piece.getColumn()];
				boolean isValid = _piece.isValidMove(pieceTile, kingTile);
				boolean inPath = _piece.inPath(pieceTile, kingTile, this.board);

				if (isValid == true && inPath == false) {
					check = true;
					break;
				}
			}
		}
		return check;
	}

	/**
	 * This method checks whether the board conditions for checkmate are satisfied.
	 * 
	 * @param  _color 			Color of current turn
	 * @param  attacker			Tile Attacking 
	 * @return boolean 
	 */
	private boolean isMate(Color _color, Tile attacker) {
		boolean mate = false;
		Tile kingTile;
		if (_color == Color.WHITE) {
			kingTile = board[whiteKing.getRow()][whiteKing.getColumn()];
		} else {
			kingTile = board[blackKing.getRow()][blackKing.getColumn()];
		}
		ArrayList<Tile> neighbors = new ArrayList<Tile>();
		int currRow = kingTile.getRow() - 1;
		int currCol = kingTile.getColumn() - 1;
		for (int i = 0; i < 3; i++) {
			int tempCol = currCol;
			for (int j = 0; j < 3; j++) {
				if (currRow >= 0 && currRow <= 7 && tempCol >= 0 && tempCol <= 7) {
					Tile _tile = this.board[currRow][tempCol];
					if (!_tile.equals(kingTile) && _tile.isOccupied() == false) {
						neighbors.add(_tile);
					}
				}
				tempCol++;
			}
			currRow++;
		}
		boolean isValidSpot = false;
		for (Tile neighbor : neighbors) {
			boolean isCheckForTile = this.isCheck(_color, neighbor, this.pieceList);
			if (isCheckForTile == false) {
				isValidSpot = true;
				break;
			}
		}
		if (isValidSpot == false) {
			for (Piece _piece : pieceList) {
				if (_piece.getColor() == _color) {
					Tile _pieceTile = this.board[_piece.getRow()][_piece.getColumn()];
					boolean isValid = _piece.isValidMove(_pieceTile, attacker);
					boolean inPath = _piece.inPath(_pieceTile, attacker, this.board);
					if (isValid == true && inPath == false) {
						ArrayList<Piece> tempPieceList = (ArrayList<Piece>) pieceList.clone();
						_piece.setLocation(attacker.getRow(), attacker.getColumn());
						if (_piece instanceof King) {
							kingTile = board[_piece.getRow()][_piece.getColumn()];
						}
						tempPieceList = removePieceFromList(attacker.getPiece(), tempPieceList);
						boolean isCheckForTile = this.isCheck(_color, kingTile, tempPieceList);
						_piece.setLocation(_pieceTile.getRow(), _pieceTile.getColumn());
						if (_piece instanceof King) {
							kingTile = board[_piece.getRow()][_piece.getColumn()];
						}

						if (isCheckForTile == false) {
							isValidSpot = true;
							break;
						}
					}
				}
			}
		}
		if (isValidSpot == false) {
			ArrayList<Tile> tileList = attacker.getPiece().tilesInBetween(attacker, kingTile, this.board);
			if (tileList != null) {
				for (int i = 0; i < tileList.size(); i++) {
					Tile _tileBetween = tileList.get(i);
					if (isValidSpot == true) {
						break;
					}
					for (Piece _piece : pieceList) {
						if (isValidSpot == true) {
							break;
						}
						if (_piece.getColor() == _color) {
							Tile _pieceTile = this.board[_piece.getRow()][_piece.getColumn()];
							boolean isValid = _piece.isValidMove(_pieceTile, _tileBetween);
							boolean inPath = _piece.inPath(_pieceTile, _tileBetween, this.board);
							if (isValid == true && inPath == false) {
								if (!(_piece instanceof King)) {
									_piece.setLocation(_tileBetween.getRow(), _tileBetween.getColumn());
									_tileBetween.setPiece(_piece);
									boolean isCheckForTile = this.isCheck(_color, kingTile, this.pieceList);
									_piece.setLocation(_pieceTile.getRow(), _pieceTile.getColumn());
									_tileBetween.clearPiece();
									if (isCheckForTile == false) {
										isValidSpot = true;
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		if (isValidSpot == false) {
			mate = true;
		}
		return mate;
	}
	
	/**
	 * This method handles pawn promotion.
	 * 
	 * @param _piece 			piece being promoted
	 * @param newPiece			new piece value
	 */
	private void pawnPromotion(Piece _piece, String newPiece) {
		String pcStr = newPiece.toLowerCase();
		Color _color = _piece.getColor();
		Piece _pointerPiece;
		if (pcStr.equals("b")) {
			Piece _npiece = new Bishop(_color);
			_npiece.setLocation(_piece.getRow(), _piece.getColumn());
			this.removePieceFromList(_npiece);
			pieceList.add(_npiece);
			_pointerPiece = _npiece;
		} else if (pcStr.equals("n")) {
			Piece _npiece = new Knight(_color);
			_npiece.setLocation(_piece.getRow(), _piece.getColumn());
			this.removePieceFromList(_piece);
			pieceList.add(_npiece);
			_pointerPiece = _npiece;
		} else if (pcStr.equals("r")) {
			Piece _npiece = new Rook(_color);
			_npiece.setLocation(_piece.getRow(), _piece.getColumn());
			this.removePieceFromList(_piece);
			pieceList.add(_npiece);
			_pointerPiece = _npiece;
		} else {
			Piece _npiece = new Queen(_color);
			_npiece.setLocation(_piece.getRow(), _piece.getColumn());
			this.removePieceFromList(_piece);
			pieceList.add(_npiece);
			_pointerPiece = _npiece;
		}
		this.board[_pointerPiece.getRow()][_pointerPiece.getColumn()].clearPiece();
		this.board[_pointerPiece.getRow()][_pointerPiece.getColumn()].setPiece(_pointerPiece);
	}

	/**
	 * This method removes piece from piecelist.
	 * 
	 * @param _piece			removes piece from active pieces
	 */
	private void removePieceFromList(Piece _piece) {
		for (int i = 0; i < pieceList.size(); i++) {
			Piece _pi = pieceList.get(i);
			if (_pi.getRow() == _piece.getRow() && _pi.getColumn() == _piece.getColumn()
					&& _piece.getColor() == _pi.getColor()) {
				pieceList.remove(i);
				break;
			}
		}
		return;
	}
	
	/**
	 * This method returns ArrayList of Pieces after removing specified piece
	 * 
	 * @param _piece			piece to be removed 
	 * @param localList			list of active pieces
	 * @return ArrayList<Piece> 
	 */
	private ArrayList<Piece> removePieceFromList(Piece _piece, ArrayList<Piece> localList) {
		for (int i = 0; i < localList.size(); i++) {
			Piece _pi = localList.get(i);
			if (_pi.getRow() == _piece.getRow() && _pi.getColumn() == _piece.getColumn()
					&& _piece.getColor() == _pi.getColor()) {
				localList.remove(i);
				break;
			}
		}
		return localList;
	}
}