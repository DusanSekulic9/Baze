package main;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar{
	
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnFAndS;
	private JButton btnRefresh;
	private JButton btnIzvestaj;
	private JButton btnPretraga
	;
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);

		add(MainFrame.getInstance().getAkcije().getAdd());
		add(MainFrame.getInstance().getAkcije().getDelete());
		add(MainFrame.getInstance().getAkcije().getfAndS());
		add(MainFrame.getInstance().getAkcije().getRefresh());
		add(MainFrame.getInstance().getAkcije().getIzvestaj());
		add(MainFrame.getInstance().getAkcije().getPretraga());
		addSeparator();
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnFAndS() {
		return btnFAndS;
	}

	public void setBtnFAndS(JButton btnFAndS) {
		this.btnFAndS = btnFAndS;
	}

	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	public void setBtnRefresh(JButton btnRefresh) {
		this.btnRefresh = btnRefresh;
	}

	public JButton getBtnIzvestaj() {
		return btnIzvestaj;
	}

	public void setBtnIzvestaj(JButton btnIzvestaj) {
		this.btnIzvestaj = btnIzvestaj;
	}

	public JButton getBtnPretraga() {
		return btnPretraga;
	}

	public void setBtnPretraga(JButton btnPretraga) {
		this.btnPretraga = btnPretraga;
	}
	
	
}
