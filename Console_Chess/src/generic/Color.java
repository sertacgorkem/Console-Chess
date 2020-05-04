package generic;

/**
 * The Color Enum. Restricts the value of colors used to black and white.
 * 
 * @author Sertac Gorkem
 * @version 2.1
 * @since 2020-03-01
 */
public enum Color {
	WHITE, BLACK;

	/**
	 * This method returns the color opposite the current color
	 * 
	 * @return Color
	 */
	public Color getOpposite() {
		Color result;
		if(this == WHITE) {
			result = BLACK;
		}
		else {
			result = WHITE;
		}
		return result;
	}
}