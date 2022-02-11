package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Say anything you like!");
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/UserInput.txt");
			fw.write(s);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

//Copyright © 2019 Tate Criqui