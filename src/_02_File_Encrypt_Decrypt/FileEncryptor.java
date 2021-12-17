package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static int key;
	public static void main(String[] args) {
		String val = JOptionPane.showInputDialog("Please enter your message.");
		key = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer to encrypt your message. (e.g. 4)"));
		String zep = "";
		int newChar = 0;

		for (int i = 0; i < val.length(); i++) {
			char iChar = val.charAt(i);
			if (Character.isAlphabetic(iChar)) {
				if (Character.isLowerCase(iChar)) {
					newChar = iChar + key;

					if (iChar + key > 122) {
						newChar -= 26;
					}
				}
				if (Character.isUpperCase(iChar)) {
					newChar = iChar + key;

					if (iChar + key > 90) {
						newChar -= 26;
					}
				}
				zep += (char)newChar;
			}
			else {
				zep += iChar;
			}
		}
		System.out.println(zep);
		
		FileWriter fw;
		try {
			fw = new FileWriter("src/_02_File_Encrypt_Decrypt/EncryptedMessage.txt");
			fw.write(zep);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
