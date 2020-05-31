package action;

public class SveAkcije {
	
	private Pretraga pretraga;
	private AddAction add;
	private DeleteAction delete;
	private FilterAndSortAction fAndS;
	private UpdateAction refresh;
	private Izvestaj izvestaj;
	
	public SveAkcije() {
		pretraga = new Pretraga();
		add = new AddAction();
		delete = new DeleteAction();
		fAndS = new FilterAndSortAction();
		refresh = new UpdateAction();
		izvestaj = new Izvestaj();
	}

	public Pretraga getCommit() {
		return pretraga;
	}

	public void setCommit(Pretraga pretraga) {
		this.pretraga = pretraga;
	}

	public AddAction getAdd() {
		return add;
	}

	public void setAdd(AddAction add) {
		this.add = add;
	}

	public DeleteAction getDelete() {
		return delete;
	}

	public void setDelete(DeleteAction delete) {
		this.delete = delete;
	}

	public FilterAndSortAction getfAndS() {
		return fAndS;
	}

	public void setfAndS(FilterAndSortAction fAndS) {
		this.fAndS = fAndS;
	}

	public UpdateAction getRefresh() {
		return refresh;
	}

	public void setRefresh(UpdateAction refresh) {
		this.refresh = refresh;
	}

	public Pretraga getPretraga() {
		return pretraga;
	}

	public void setPretraga(Pretraga pretraga) {
		this.pretraga = pretraga;
	}

	public Izvestaj getIzvestaj() {
		return izvestaj;
	}

	public void setIzvestaj(Izvestaj izvestaj) {
		this.izvestaj = izvestaj;
	}
	
	
}
