import java.util.*;
class NorthZone extends Zoo {
	static ArrayList<Cage> cages = new ArrayList<Cage>();
	static int total;

	NorthZone() {
		cages.add(new Cage("Mammel"));
	}

	void createNewCage() {
		cages.add(new Cage("Mammel"));
	}

	boolean alocateAnimal(Animal a) {
		if (total == cages.size() * 10 || a.type=="Mammel") {
			return false;
		} else {
			cages.get(total / 10).list[total % 10] = a;
			total++;
			return true;
		}
	}

	boolean removeAnimal(Animal a) {
		if (total == 0 || a.type=="Mammel") {
			return false;
		} else {
			outer: for (int i = 0; i < cages.size(); i++) {
				for (int j = 0; j < 10; j++) {
					if (a.name == cages.get(i).list[j].name)
					{
						cages.get(i).list[j] = cages.get(total/10).list[total%10-1];
						cages.get(total/10).list[total%10-1]=null;
						total--;
						break outer;
					}
				}
			}
			return true;
		}
	}

}