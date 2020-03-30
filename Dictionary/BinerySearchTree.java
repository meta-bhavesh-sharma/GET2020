package Dictionary;

import java.util.ArrayList;


public interface BinerySearchTree {

	public int get(int key);
	public void add(int key,int value);
	public void delete(int key);
	public ArrayList<Element> sort();
	public ArrayList<Element> sortBetween(int key1,int key2);
}
