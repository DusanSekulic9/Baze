package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.layout.FlowPane;

public class PretragaGui extends JFrame{
	
	
	private ArrayList<FlowPane> paneli;
	private JComboBox<String> kolone;
	private JComboBox<String> operacije;
	private JComboBox<String> znakovi;
	private JButton like;
	private JTextField broj;

	private FlowLayout experimentLayout = new FlowLayout();
	
	public PretragaGui() {
		setTitle("Pretraga");
		setSize(800, 550);
		setLocationRelativeTo(null);
	}
	
	public void inicijalizacija() {
		kolone = new JComboBox<>();
		operacije = new JComboBox<>();
		like = new JButton("Like");
		znakovi = new JComboBox<String>();
		broj = new JTextField();
	}
	
	public void dodaj() {
		JPanel panel = new JPanel();
		panel.setLayout(experimentLayout);
		experimentLayout.setAlignment(FlowLayout.TRAILING);
		JPanel controls = new JPanel();
		controls.setLayout(new FlowLayout());
		 		
		panel.add(kolone);
		panel.add(operacije);
		panel.add(broj);
		panel.add(like);
		panel.add(znakovi);
		

		
	}

	public JComboBox<String> getKolone() {
		return kolone;
	}

	public void setKolone(JComboBox<String> kolone) {
		this.kolone = kolone;
	}

	public JComboBox<String> getOperacije() {
		return operacije;
	}

	public void setOperacije(JComboBox<String> operacije) {
		this.operacije = operacije;
	}

	public JButton getLike() {
		return like;
	}

	public void setLike(JButton like) {
		this.like = like;
	}

	public JTextField getBroj() {
		return broj;
	}

	public void setBroj(JTextField broj) {
		this.broj = broj;
	}

	public ArrayList<FlowPane> getPaneli() {
		return paneli;
	}

	public void setPaneli(ArrayList<FlowPane> paneli) {
		this.paneli = paneli;
	}

	public JComboBox<String> getZnakovi() {
		return znakovi;
	}

	public void setZnakovi(JComboBox<String> znakovi) {
		this.znakovi = znakovi;
	}

	public FlowLayout getExperimentLayout() {
		return experimentLayout;
	}

	public void setExperimentLayout(FlowLayout experimentLayout) {
		this.experimentLayout = experimentLayout;
	}

	
}
