package view;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.AttributeType;
import main.AppCore;
import main.MainFrame;
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
		setSize(1400, 1000);
		setLocationRelativeTo(null);
		entity = AppCore.getInstance().getIr().getEntity(name);
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS); 	
		this.setLayout(new FlowLayout());
		panel.setLayout(boxlayout);

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
					ArrayList<Attribute> at = new ArrayList<Attribute>();
					ArrayList<String> oper = new ArrayList<String>();
					ArrayList<String> znak = new ArrayList<String>();
					ArrayList<String> param = new ArrayList<String>();
					for(JComboBox cb : kolone) {
						at.add((Attribute) cb.getSelectedItem());
					}
					for(JComboBox cb : operacije) {
						oper.add((String) cb.getSelectedItem());
					}
					for(JComboBox cb : znakovi) {
						znak.add((String) cb.getSelectedItem());
					}
					for(JTextField tf : broj) {
						param.add(tf.getText());
					}
					AppCore.getInstance().search(entity, at, oper, znak, param);
					MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
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
		this.add(panel);
		this.pack();
		this.setVisible(true);
		
	}

	public ArrayList<JPanel> getPaneli() {
		return paneli;
	}


	
}
