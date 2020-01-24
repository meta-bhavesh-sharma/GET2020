abstract class Animal {
	String type;
	String name;
	float waight;
	int age;

	Animal(String n, float w, int a) {
		name = n;
		waight = w;
		age = a;
	}

	abstract String getSound();
}