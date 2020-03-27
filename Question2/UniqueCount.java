package Question2;

import java.util.*;
public class UniqueCount {
	
	static Map<String,Integer> result=new HashMap<String,Integer>();
	static void count(String str)
	{
		if(result.containsKey(str))
		{
			System.out.println(result.get(str));
			return;
		}
		Map<Character,Integer> character=new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++)
		{
			character.put(str.charAt(i), 1);
		}
		System.out.println(character);
		System.out.println(character.size());
		result.put(str,character.size() );
	}
	public static void main(String args[])
	{
			count("jicgdfbrgvgeiuciqubuciqwgtedioqbxihwvg");
			count("jicgdfbrgvgeiuciqubuciqwgtedioqbxihwvg");
			count("jicgdfbrgvgeiuciqubuciqwgtedioqbxihwvg");
			count("jicgdfbrgvdjkegrihcasok;hcdisgeiuciqubuciqwgtedioqbxihwvg");
			count("jicgdfbrgvdjkegrihcasok;hcdisgeiuciqubuciqwgtedioqbxihwvg");
			count("jicgdfbrgvdjkegrihcasok;hcdisgeiuciqubuci%$^&%^&%&^$#*^*$^$**^$*ihwvg");
			
	}

}
