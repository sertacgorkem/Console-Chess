package chess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import generic.*;

/**
 * Two Player Chess Runner. The Chess runner calls the board class to control the flow of the game.
 *
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class Chess {

	/**
	 * This is the test method which makes use of Board class and batch commands.
	 * 
	 * @param args			Unused.
	 */
	private static String[] commandReader() {
		String[] commands = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("chessInput.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
//		        sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			commands = everything.split(",");
			if (commands != null) {
				for (int i = 0; i < commands.length; i++) {
					commands[i] = commands[i].strip();

				}
			}
			br.close();
		} catch (Exception ex) {

		}
		return null;
	}
	
	/**
	 * This is the main method which handles normal game flow.
	 * 
	 * @param args			Unused.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board _board = new Board(2);

		String[] commands = commandReader();
		int commandCounter = 0;

		Scanner sc = new Scanner(System.in);
		while (_board.getState() == GameState.CONTINUE) {

			System.out.println();
			System.out.println();
			_board.printBoard();
			System.out.println();
			System.out.println();

			if (_board.getTurn() == Color.WHITE) {
				System.out.println("White Turn");
			} else {
				System.out.println("Black Turn");
			}
			boolean isDraw = _board.getDraw();
			
			
			String move = "";
			
			if(commands != null) {
				if (commandCounter < commands.length) {
					System.out.println("Press enter to continue");
					sc.nextLine();
					move = commands[commandCounter];
					System.out.println(move);
				} 
			}
			if(move == null){
				move = sc.nextLine();
			}
			else if(move.length() == 0) {
				move = sc.nextLine();
			}
			
			if (move.toLowerCase().equals("draw")) {
				_board.makeDraw(true);
			} else if (move.toLowerCase().equals("resign")) {
				if (_board.getTurn() == Color.WHITE) {
					_board.setState(GameState.BLACK_WINS);
				} else {
					_board.setState(GameState.WHITE_WINS);
				}
			} else {
				int firstPosition = -1;
				int secondPosition = -1;
				String pawnProm = "Q";
				if (move != "") {
					if (move.length() > 0) {
						try {
							String[] _moveArr = move.split(" ");
							firstPosition = GenericFunctions.convertInputs(_moveArr[0]);
							secondPosition = GenericFunctions.convertInputs(_moveArr[1]);
							if (_moveArr.length > 2) {
								pawnProm = _moveArr[2];
							}
						} catch (Exception ex) {
							System.out.print("Input exception error. Please try again");
							continue;
						}
					}
				} else {
					continue;
				}
				if (firstPosition != -1 && secondPosition != -1) {
					if (isDraw == true) {
						_board.makeDraw(false);
					}
					_board.move(firstPosition, secondPosition, pawnProm);
					commandCounter++;
				} else {
					System.out.print("Input exception error. Please try again");
				}
			}
		}
		if (_board.getState() == GameState.BLACK_WINS) {
			System.out.println("Black Wins");
		} else if (_board.getState() == GameState.WHITE_WINS) {
			System.out.println("White Wins");
		} else if (_board.getState() == GameState.DRAW) {
			System.out.println("DRAW");
		}
		sc.close();
	}
}