package _03_To_Do_List;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton viewTasks = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();

	boolean taskAdded = false;
	String startingTasks = "";

	ArrayList<String> taskList = new ArrayList<String>();

	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setPreferredSize(new Dimension(350, 80));
		panel.add(addTask);
		addTask.setText("addTask");
		addTask.addActionListener(this);
		panel.add(viewTasks);
		viewTasks.setText("viewTasks");
		viewTasks.addActionListener(this);
		panel.add(removeTask);
		removeTask.setText("removeTask");
		removeTask.addActionListener(this);
		panel.add(saveList);
		saveList.setText("saveList");
		saveList.addActionListener(this);
		panel.add(loadList);
		loadList.setText("loadList");
		loadList.addActionListener(this);

		frame.pack();
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoList.txt"));
			String l = "";
			while(l!=null) {
				l = br.readLine();
				taskList.add(l);
				taskAdded = true;
			}
		}
		catch(Exception e) {
			System.out.println("ERROR: could not load previous file");
		}
	}
	//when a button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(addTask)) {
			String task = JOptionPane.showInputDialog("What task would you like to add?");
			taskList.add(task);
			taskAdded = true;
		}

		else if (e.getSource().equals(viewTasks)) {
			String allTasks = "";
			if (taskAdded == true) {
				for (int i = 0; i < taskList.size(); i++) {
					allTasks += taskList.get(i) + ", ";
				}
				allTasks = allTasks.substring(0, allTasks.length() - 2);
				JOptionPane.showMessageDialog(null, allTasks);
			} else {
				JOptionPane.showMessageDialog(null, "The task list is empty.");
			}
		}

		else if (e.getSource().equals(removeTask)) {
			if (taskAdded == true) {
				String taskToRemove = JOptionPane.showInputDialog("Which task would you like to remove?");
				boolean taskFound = false;
				for (int i = 0; i < taskList.size()-1; i++) {
					if (taskList.get(i).equals(taskToRemove)) {
						taskList.remove(i);
						JOptionPane.showMessageDialog(null, "Task successfully removed!");
						if (taskList.size() == 0) {
							taskAdded = false;
						}
						taskFound = true;
						break;
					}
				}
				if (taskFound == false) {
					JOptionPane.showMessageDialog(null, "Task was not found.");
				}

			} else {
				JOptionPane.showMessageDialog(null, "There are no tasks to remove.");
			}
		}

		else if (e.getSource().equals(saveList)) {
			if (taskAdded == true) {
				
				String allTasks = "";
				for (int i = 0; i < taskList.size(); i++) {
					allTasks += taskList.get(i) + "\n";
				}
				allTasks = allTasks.substring(0, allTasks.length() - 1);
				
				FileWriter fw;
				try {
					fw = new FileWriter("src/_03_To_Do_List/ToDoList.txt");
					fw.write(allTasks);
					fw.close();
				} catch (Exception f) {
					System.out.println("ERROR: saveList triggers its exception");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "The task list is empty.");
			}
		}
		else if(e.getSource().equals(loadList)) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoList.txt"));
				JOptionPane.showMessageDialog(null, br.read());
			}
			catch(Exception f){
				
			}
		}
		

	}
}
