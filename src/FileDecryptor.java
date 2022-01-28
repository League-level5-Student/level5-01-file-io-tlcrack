package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		FileEncryptor fe = new FileEncryptor();
		BufferedReader fw;
		String text = "";
		try {
			fw = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/EncryptedMessage.txt"));
			text = fw.readLine();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "";
		int originalChar = 0;

		boolean keyEnded = false;
		int key = 0;
		for (int i = 0; i < text.length(); i++) {
			char iChar = text.charAt(i);

			if (keyEnded == false) {
				if (iChar == ' ') {
					keyEnded = true;
					String s = text.substring(0, i);
					key = Integer.parseInt(s);
				}
			} else {
				if (Character.isAlphabetic(iChar)) {
					if (Character.isLowerCase(iChar)) {
						originalChar = iChar - key;

						while (originalChar < 97) {
							originalChar += 26;
						}
					}
					if (Character.isUpperCase(iChar)) {
						originalChar = iChar - key;

						while (originalChar < 65) {
							originalChar += 26;
						}
					}
					message += (char) originalChar;
				} else {
					message += iChar;
				}
			}
		}
		System.out.println(message);
	}
}
