package CommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Bhavesh
 *
 */
public class CommandPrompt {
	ArrayList<Directory> directories = new ArrayList<Directory>();

	/**
	 * this method add the directory to the list
	 * 
	 * @param dir
	 *            the directory that have to add in directories list
	 */
	public void addDirectory(Directory dir) {
		this.directories.add(dir);
	}

	/**
	 * this method show the current directory address
	 * 
	 * @param dir
	 *            the directory to show the current directory
	 */
	public void showCurrentDirectory(Directory dir) {
		String str = dir.getName() + " > ";
		Directory temp = dir;
		while (temp.getParent() != null) {
			str = temp.getParent().getName() + " > " + str;
			temp = temp.getParent();
		}
		System.out.println(str);
	}

	/**
	 * 
	 * @param subDirectories
	 *            list of all subDirectories of given directory
	 * @param name
	 *            of the directory to find
	 * @return null is directory not found else its address
	 */
	public Directory findDirectory(ArrayList<Directory> subDirectories,
			String name) {
		Directory directory = null;
		for (int i = 0; i < subDirectories.size(); i++) {
			if (name.equalsIgnoreCase(subDirectories.get(i).getName())) {
				directory = subDirectories.get(i);
				break;
			}
		}
		return directory;
	}

	/**
	 * this method show details the directory and its sub directories
	 * 
	 * @param dir
	 *            the address to directory to show details
	 */
	public void showDirectoryDetail(Directory dir) {
		System.out.println("current directory");
		System.out.println("name = " + dir.getName() + "   time = "
				+ dir.getTime());
		System.out.println("sub directories");
		for (int i = 0; i < dir.getSubDirectories().size(); i++) {
			System.out.println("name = "
					+ dir.getSubDirectories().get(i).getName() + "   time = "
					+ dir.getSubDirectories().get(i).getTime());
		}
	}

	/**
	 * this take back to parent directory
	 * 
	 * @param dir
	 *            the address of current directory
	 * @return parent directory address if present else current directory
	 *         address
	 */
	public Directory goBack(Directory dir) {
		if (dir.getParent() != null) {
			dir = dir.getParent();
		}
		this.showCurrentDirectory(dir);
		return dir;
	}

	/**
	 * this method find item in any sub directory
	 * 
	 * @param dir
	 *            the current directory address
	 * @param name
	 *            of directory that have to find in all sub directory and their
	 *            sub directory
	 */
	public void findInAllDirectory(Directory dir, String name) {

		if (dir.getSubDirectories().size() == 0) {
			return;
		} else {
			for (int j = 0; j < dir.getSubDirectories().size(); j++) {
				if (name.equals(dir.getSubDirectories().get(j).getName())) {
					System.out.println("directory found at address");
					this.showCurrentDirectory(dir.getSubDirectories().get(j));
				}
				this.findInAllDirectory(dir.getSubDirectories().get(j), name);
			}
		}

	}

	/**
	 * this methods draw the tree of directories
	 * 
	 * @param dir
	 *            the current directory address
	 * @param str
	 *            the escape string to print in alignment
	 */
	public void drawTree(Directory dir, String str) {
		System.out.println(str + "--->" + dir.getName());
		str = str + "      ";
		if (dir.getSubDirectories().size() == 0) {
			return;
		} else {
			for (int i = 0; i < dir.getSubDirectories().size(); i++) {
				this.drawTree(dir.getSubDirectories().get(i), str);
			}
		}
	}

	/**
	 * show tree representation of directories
	 * 
	 * @param dir
	 *            current directory
	 */
	public void showTree(Directory dir) {
		Directory temp = dir;
		while (temp.getParent() != null) {
			temp = temp.getParent();
		}
		this.drawTree(temp, "");
	}

	public static void main(String[] args) {
		CommandPrompt cmd = new CommandPrompt();
		Directory dir = new Directory(null, new Date(), "computer");
		cmd.addDirectory(dir);
		Directory cd = dir;
		cmd.showCurrentDirectory(cd);
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			String command = "";
			String commandName = "";
			String str = "";
			//Split String into 3 parts
			String[] arrOfStr = input.split(" ", 3);
			if (arrOfStr.length >= 1) 
				command = arrOfStr[0];
			if (arrOfStr.length >= 2) 
				commandName = arrOfStr[1];
			if (arrOfStr.length >= 3)
				str = arrOfStr[2];

			if (str.equals("") || str.equals(" ")) {
				if (command.equalsIgnoreCase("mkdir")) {
					if (commandName.equalsIgnoreCase(" ")
							|| commandName.equalsIgnoreCase("")) {
						System.out.println("invalid command");
						cmd.showCurrentDirectory(cd);
					} else {
						dir = cmd.findDirectory(cd.getSubDirectories(),
								commandName);
						if (dir == null) {
							dir = new Directory(cd, new Date(), commandName);
							cmd.addDirectory(dir);
							cd.addSubDirectory(dir);
							cd = dir;
							cmd.showCurrentDirectory(cd);
						} else {
							System.out.println("directory already exist");
							cmd.showCurrentDirectory(cd);
						}
					}

				} else if (command.equalsIgnoreCase("cd")) {
					if (commandName.equalsIgnoreCase(" ")
							|| commandName.equalsIgnoreCase("")) {
						System.out.println("invalid command");
						cmd.showCurrentDirectory(cd);
					} else {
						dir = cmd.findDirectory(cd.getSubDirectories(),
								commandName);
						if (dir == null) {
							System.out.println("no directory found");
						} else {
							cd = dir;
							cmd.showCurrentDirectory(cd);
						}
					}
				} else if (command.equalsIgnoreCase("ls")) {
					if (commandName.equalsIgnoreCase(" ")
							|| commandName.equalsIgnoreCase("")) {
						cmd.showDirectoryDetail(cd);
					} else {
						System.out.println("invalid command");
						cmd.showCurrentDirectory(cd);
					}
				} else if (command.equalsIgnoreCase("back")) {
					if (commandName.equalsIgnoreCase(" ")
							|| commandName.equalsIgnoreCase("")) {
						cd = cmd.goBack(cd);
					} else {
						System.out.println("invalid command");
						cmd.showCurrentDirectory(cd);
					}
				} else if (command.equalsIgnoreCase("find")) {
					if (commandName.equalsIgnoreCase(" ")
							|| commandName.equalsIgnoreCase("")) {
						System.out.println("invalid command");
						cmd.showCurrentDirectory(cd);
					} else {
						cmd.findInAllDirectory(cd, commandName);
					}
				} else if (command.equalsIgnoreCase("tree")) {
					if (commandName.equalsIgnoreCase(" ")
							|| commandName.equalsIgnoreCase("")) {
						cmd.showTree(cd);
						cmd.showCurrentDirectory(cd);
					} else {
						System.out.println("invalid command");
						cmd.showCurrentDirectory(cd);
					}
				} else if (command.equalsIgnoreCase("exit")) {
					sc.close();
					System.exit(1);
				} else {
					System.out.println("invalid command");
					cmd.showCurrentDirectory(cd);
				}
			} else {
				System.out.println("invalid command");
				cmd.showCurrentDirectory(cd);

			}
		}

	}

}
