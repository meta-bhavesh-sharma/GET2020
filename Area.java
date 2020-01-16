package Assignment3;

import java.util.*;

class Area {
	double areaTriangle(double base, double hight) {
		return 0.5 * base * hight;
	}

	double areaRectangle(double width, double hight) {
		return width * hight;
	}

	double areaSquare(double width) {
		return width * width;
	}

	double areaCircle(double redius) {
		return 3.14 * redius * redius;
	}
}
