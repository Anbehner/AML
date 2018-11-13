package GUISwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import javafx.stage.FileChooser;

public class editor extends JFrame implements ActionListener {

	// Swing Gui, Texteditor um mit der Bibliothek vertraut zu machen

	JTextArea t;

	JFrame f;

	editor() {
		f = new JFrame("editor");

		try {

			// Farbwahl war reine Neugier wie das aussieht :D Standard ist wohl besser
			
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 

			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		} catch (Exception e) {
		}
		t = new JTextArea();

		JMenuBar mb = new JMenuBar();

		JMenu m1 = new JMenu("File");

		// 1. Menü

		JMenuItem item1 = new JMenuItem("New");
		JMenuItem item2 = new JMenuItem("Open");
		JMenuItem item3 = new JMenuItem("Save");
		JMenuItem item4 = new JMenuItem("Print");

		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);

		// Zum menü hinzufügen

		m1.add(item1);
		m1.add(item2);
		m1.add(item3);
		m1.add(item4);

		// 2 Menü

		JMenu m2 = new JMenu("Edit");

		JMenuItem item5 = new JMenuItem("Cut");
		JMenuItem item6 = new JMenuItem("Copy");
		JMenuItem item7 = new JMenuItem("Paste");

		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);

		m2.add(item5);
		m2.add(item6);
		m2.add(item7);

		// Close

		JMenuItem close = new JMenuItem("Close");

		close.addActionListener(this);

		mb.add(m1); // Wahrscheinlich wäre es klug vielsagendere Namen zu vergeben anstelle von
					// item und m
		mb.add(m2);
		mb.add(close);

		f.setJMenuBar(mb);
		f.add(t);
		f.setSize(500, 500);
		f.setVisible(true); // f.show deprecated, stattdessen f.setvisible?
	}

	// Actions Klick auf Menü

	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand();

		if (s.equals("Cut")) {
			t.cut();
		} else if (s.equals("Copy")) {
			t.copy();
		} else if (s.equals("Paste")) {
			t.paste();
		} else if (s.equals("Save")) {

			// JFilechooser class Objekt erzeugen

			JFileChooser j = new JFileChooser("f:");

			int r = j.showSaveDialog(null);

			if (r == JFileChooser.APPROVE_OPTION) {

				File file = new File(j.getSelectedFile().getAbsolutePath());

				try {
					FileWriter filewriter = new FileWriter(file, false);

					BufferedWriter bw = new BufferedWriter(filewriter);

					bw.write(t.getText());

					bw.flush();
					bw.close();
				} catch (Exception evt) {
					JOptionPane.showMessageDialog(f, evt.getMessage());
				}
			} else
				JOptionPane.showMessageDialog(f, "Cancelled by user");
		} else if (s.equals("Print")) {
			try {
				t.print();
			} catch (Exception evt) {
				JOptionPane.showMessageDialog(f, evt.getMessage());
			}
		} else if (s.equals("Open")) {
			JFileChooser j = new JFileChooser("f:");

			int r = j.showOpenDialog(null);

			if (r == JFileChooser.APPROVE_OPTION) {

				File file = new File(j.getSelectedFile().getAbsolutePath());

				try {

					String s1 = "", sl = "";

					FileReader filereader = new FileReader(file);

					BufferedReader br = new BufferedReader(filereader);

					sl = br.readLine();

					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}

					t.setText(sl);
				} catch (Exception evt) {
					JOptionPane.showMessageDialog(f, evt.getMessage());

				}
			}

			else
				JOptionPane.showMessageDialog(f, "Cancelled by user");
		} else if (s.equals("New")) {
			t.setText("");
		} else if (s.equals("Close")) {
			f.setVisible(false);
		}

	}

	public static void main(String args[]) {
		editor e = new editor();
	}

}
