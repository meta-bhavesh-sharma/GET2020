import java.util.*;
interface abs
{
	NorthZone n1 = new NorthZone();
		WestZone n2 = new WestZone();
		SouthZone n3 = new SouthZone();
}
class CageAllocation implements abs{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Animal x;
		while (true) {
			System.out.println("choose options");
			System.out.println("1.Add Animals");
			System.out.println("2.If any animal is dead");
			System.out.println("3.Add new Cage");
			System.out.println("4.Exit");
			int choise = sc.nextInt();
			switch (choise) {
			case 1:
				System.out.println("enter the type of animal");
				String s = sc.next();
				if ("Mammel".equals(s)) {
					System.out.println("enter the animal name");
					String m = sc.next();
					if ("cow".equals(m)) {
						x = new Cow("c11", 44, 12);
						if(n1.alocateAnimal(x))
						{
							System.out.println("Success");
						}
					}
				}break;
			case 2:
			System.out.println("enter the type of animal");
				s = sc.next();
				if ("Mammel".equals(s)) {
					System.out.println("enter the animal name");
					String m = sc.next();
					if ("cow".equals(m)) {
						x = new Cow("c11", 44, 12);
						if(n1.removeAnimal(x))
							System.out.println("Success");
					}
				}break;
			case 3:
			System.out.println("enter the type of animal");
				s = sc.next();
				if("Mammel".equals(s))
					n1.createNewCage();
				break;
			case 4:
				sc.close();
				System.exit(0);
			}
		}

	}
}