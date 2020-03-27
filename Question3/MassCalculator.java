package Question3;

import java.util.ArrayList;
import java.util.HashMap;

public class MassCalculator {

	static int top = -1;
	static ArrayList<Character> chemichal = new ArrayList<Character>();
	static HashMap<Character, Integer> masses = new HashMap<Character, Integer>();

	static void push(char element) {
		chemichal.add(element);
		top++;
	}

	static char pop() {
		char element = chemichal.get(top);
		chemichal.remove(top);
		top--;
		return element;
	}

	static int calculateMass(String formula) {
		masses.put('C', 12);
		masses.put('H', 1);
		masses.put('O', 16);
		int mass = 0;
		char[] elements = formula.toCharArray();
		for (int i = 0; i < elements.length; i++) {

			if (elements[i] != ')') {
				push(elements[i]);
			} else if (elements[i] == ')') {
				int subMass = 0;
				while (true) {
					char element = pop();
					if (49 <= element && 57 >= element) {
						subMass += masses.get(pop())
								* Integer.parseInt(Character.toString(element));
						continue;
					}
					if (element == '(') {
						if (49 <= elements[i + 1] && 57 >= elements[i + 1]) {
							mass = mass
									+ subMass
									* Integer.parseInt(Character
											.toString(elements[i + 1]));
							i++;
						}
						break;
					}
					subMass += masses.get(element);

				}
			}

		}

		if (chemichal.size() != 0) {
			for (int i = 0; i < chemichal.size(); i++) {
				if (i + 1 < chemichal.size() && 49 <= chemichal.get(i + 1)
						&& 57 >= chemichal.get(i + 1)) {

					mass = mass
							+ masses.get(chemichal.get(i))
							* Integer.parseInt(Character.toString(chemichal
									.get(i + 1)));
					i++;

					continue;
				}
				mass = mass + masses.get(chemichal.get(i));
			}
		}

		return mass;

	}

	public static void main(String args[]) {
		System.out.println(calculateMass("CH3CH3H2O"));
	}

}
