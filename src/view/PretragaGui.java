package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.AttributeType;
import main.AppCore;
import model.Attribute;
import model.Entity;
import nodes.DBNode;

public class PretragaGui extends JFrame{
	
	
	private ArrayList<JPanel> paneli = new ArrayList<JPanel>();
	private ArrayList<JComboBox<Attribute>> kolone = new ArrayList<JComboBox<Attribute>>();
	private ArrayList<JComboBox<String>> operacije = new ArrayList<JComboBox<String>>();
	private ArrayList<JComboBox<String>> znakovi = new ArrayList<JComboBox<String>>();
	//private JButton like;
	private ArrayList<JTextField> broj = new ArrayList<JTextField>();
	int index = 0;

	JPanel panel = new JPanel();
	
	private Entity entity;
	
	public PretragaGui(String name) {
		setTitle("Pretraga");
		setSize(800, 550);
		setLocationRelativeTo(null);
		entity = AppCore.getInstance().getIr().getEntity(name);
		this.setLayout(new GridLayout());
	}
	
	public void inicijalizacija() {
		kolone.add(new JComboBox<>());
		for(DBNode node : entity.getChildren()) {
			kolone.get(index).addItem((Attribute) node);
		}
		operacije.add(new JComboBox<>());
		kolone.get(index).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Attribute at = (Attribute) kolone.get(index).getSelectedItem();
				operacije.get(index).removeAllItems();
				if(at.getAttributeType().equals(AttributeType.VARCHAR) || at.getAttributeType().equals(AttributeType.CHAR)) {
					operacije.get(index).addItem(new String("like"));
				}else if(at.getAttributeType().equals(AttributeType.DATETIME)){
					operacije.get(index).addItem("=");
				}else {
					operacije.get(index).addItem("=");
					operacije.get(index).addItem("<");
					operacije.get(index).addItem(">");
				}
			}
		});
		//like = new JButton("Like");
		znakovi.add(new JComboBox<String>());
		znakovi.get(index).addItem("AND");
		znakovi.get(index).addItem("OR");
		znakovi.get(index).addItem("FINNISH");
		znakovi.get(index).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = (String) znakovi.get(index).getSelectedItem();
				if(selected.equalsIgnoreCase("finnish")) {
					//appcore.getinstance.search
				}else {
					makeNewSet();
				}
			}
		});
		broj.add(new JTextField());
		broj.get(index).setPreferredSize(new Dimension(50, 30));
	}
	
	protected void makeNewSet() {
		index++;
		inicijalizacija();
		paneli.add(new JPanel());
		dodaj(paneli.get(index));
	}

	public void dodaj(JPanel panel) {
		//flowPane.setAlignment(FlowLayout.CENTER);
//		JPanel controls = new JPanel();
//		controls.setLayout(new FlowLayout());
		
		if(paneli.isEmpty()) {
			paneli.add(panel);
		}
		 		
		panel.add(kolone.get(index));
		panel.add(operacije.get(index));
		panel.add(broj.get(index));
		//panel.add(like);
		panel.add(znakovi.get(index));
		this.add(panel,BorderLayout.CENTER);
		
	}

	public ArrayList<JPanel> getPaneli() {
		return paneli;
	}


	
}
