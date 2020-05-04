package generic;

/**
 * The GenericFunctions Class. This class contains helper functions for the gameplay..
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public class GenericFunctions {

	/**
	 * This method returns the color of the Tile at the given indexes.
	 * 
	 * @param x		x position
	 * @param y		y position
	 * @return String
	 */
	public static String tileColorFinder(int x, int y) {
		String colorStr = "";
		if (x % 2 == 0 && y % 2 == 0) {
			colorStr = "   ";
		} else if (x % 2 == 0 && y % 2 == 1) {
			colorStr = "## ";
		} else if (x % 2 == 1 && y % 2 == 0) {
			colorStr = "## ";
		} else {
			colorStr = "   ";
		}
		return colorStr;
	}
	
	/**
	 * This method returns the opposite of the given color.
	 * 
	 * @param _current		current turn color
	 * @return Color
	 */
	public static Color changeColor(Color _current) {
		Color value;
		if(_current == Color.WHITE) {
			value = Color.BLACK;
		}
		else {
			value = Color.WHITE;
		}
		return value;
	}

	/**
	 * This method converts the input string to chess coordinates.
	 * 
	 * @param position		input chess command string
	 * @return int
	 */
	public static int convertInputs(String position) {
		int result = -1;
		int row = -1;
		int column = -1;
		if(position.length() == 2) {
			char c = Character.toLowerCase(position.charAt(0));
			switch(c) {
			case 'a':
				column = 0;
				break;
			case 'b':
				column = 1;
				break;
			case 'c':
				column = 2;
				break;
			case 'd':
				column = 3;
				break;
			case 'e':
				column = 4;
				break;
			case 'f':
				column = 5;
				break;
			case 'g':
				column = 6;
				break;
			case 'h':
				column = 7;
				break;
			}
			if(column > -1) {
				char number = position.charAt(1);
				row = (int) number - '0' ;
				row = 8 - row;
				result = row * 8 + column;
			}
		}
		return result;
	}
}