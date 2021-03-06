package _04_Directory_Iteration;

import java.io.File;

import javax.swing.JFileChooser;

import java.io.FileWriter;
import java.io.IOException;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */

		/*
		 * JFileChooser jfc = new JFileChooser();
		 * jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); int returnVal =
		 * jfc.showOpenDialog(null); if (returnVal == JFileChooser.APPROVE_OPTION) {
		 * File directory = jfc.getSelectedFile(); File[] files = directory.listFiles();
		 * if (files != null) { for (File f : files) {
		 * System.out.println(f.getAbsolutePath()); } } }
		 */

		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */

		JFileChooser srcIterator = new JFileChooser();
		srcIterator.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnValue = srcIterator.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File directory = srcIterator.getSelectedFile();
			File[] files = directory.listFiles();
			findFiles(files);
		}

	}

	static void findFiles(File[] files) {
		if (files != null) {
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
				if (f.listFiles() != null) {
					findFiles(f.listFiles());
				} else if (f.getName().length() > 5) {
					if (f.getName().substring(f.getName().length() - 5).equals(".java")) {
					// if(f.getName().equals("ToDoList.txt")) {
						FileWriter fw;
						try {
							fw = new FileWriter(f.getPath(), true);
							fw.write("\n" + "//Copyright © 2019 Tate Criqui");
							fw.close();
							System.out.println("Success!");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}

//Copyright © 2019 Tate Criqui