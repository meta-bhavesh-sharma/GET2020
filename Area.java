package Assignment3;

import java.util.*;

class Area {
	/**
	 * 
	 * @param base base of trianble in double
	 * @param hight hight of triangle in double
	 * @return area of triangle
	 */
	double areaTriangle(double base, double hight) {
		return 0.5 * base * hight;
	}
	/**
	 * 
	 * @param width ractangle width in double
	 * @param hight ractangle hight in double
	 * @return area of ractangle
	 */
	double areaRectangle(double width, double hight) {
		return width * hight;
	}
/**
 * 
 * @param width width of square in double
 * @return area of square
 */
	double areaSquare(double width) {
		return width * width;
	}
/**
 * 
 * @param redius circle redius in double
 * @return circle area
 */
	double areaCircle(double redius) {
		return 3.14 * redius * redius;
	}
}
