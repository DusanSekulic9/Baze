package view;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PretragaGui extends JFrame{
	
	private JComboBox<String> kolone;
	private JComboBox<String> operacije;
	private JButton like;
	private JTextField broj;
	private JButton and;
	private JButton or;
	private JButton finish;
	
	public PretragaGui() {
		setTitle("Pretraga");
		setSize(800, 550);
		setLocationRelativeTo(null);
	}
	
	public void inicijalizacija() {
		kolone = new JComboBox<String>();
		operacije = new JComboBox<String>();
		like = new JButton("Like");
		and = new JButton("And");
		or = new JButton("Or");
		finish = new JButton("Finish");
		broj = new JTextField();
	}
	
	public void dodaj() {
		JPanel levo = new JPanel();
		JPanel centar = new JPanel();
		JPanel desno = new JPanel();
		
		levo.setLayout(new BorderLayout());
		centar.setLayout(new BorderLayout());
		desno.setLayout(new BorderLayout());
		
		levo.add(kolone, BorderLayout.NORTH);
		levo.add(operacije, BorderLayout.CENTER);
		centar.add(broj, BorderLayout.NORTH);
		centar.add(like, BorderLayout.CENTER);
		desno.add(and, BorderLayout.NORTH);
		desno.add(or, BorderLayout.CENTER);
		desno.add(finish, BorderLayout.SOUTH);
		
		this.add(levo, BorderLayout.WEST);
		this.add(centar,BorderLayout.CENTER);
		this.add(desno,BorderLayout.EAST);
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

	public JButton getAnd() {
		return and;
	}

	public void setAnd(JButton and) {
		this.and = and;
	}

	public JButton getOr() {
		return or;
	}

	public void setOr(JButton or) {
		this.or = or;
	}

	public JButton getFinish() {
		return finish;
	}

	public void setFinish(JButton finish) {
		this.finish = finish;
	}
	
	
}
