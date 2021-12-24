package _03_To_Do_List;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addTask)) {
			String task = JOptionPane.showInputDialog("What task would you like to add?");
			taskList.add(task);
		}
		if(e.getSource().equals(viewTasks)) {
			String allTasks = "";
			for(int i = 0; i < taskList.size(); i++) {
				allTasks+=taskList.get(i)+", ";
			}
			allTasks = allTasks.substring(0, allTasks.length()-2);
			JOptionPane.showMessageDialog(null, allTasks);
		}
	}
}
