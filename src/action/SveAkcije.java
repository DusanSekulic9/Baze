package action;

public class SveAkcije {
	
	private CommitAction commit;
	private AddAction add;
	private DeleteAction delete;
	private FilterAndSortAction fAndS;
	private RefreshAction refresh;
	
	public SveAkcije() {
		commit = new CommitAction();
		add = new AddAction();
		delete = new DeleteAction();
		fAndS = new FilterAndSortAction();
		refresh = new RefreshAction();
	}

	public CommitAction getCommit() {
		return commit;
	}

	public void setCommit(CommitAction commit) {
		this.commit = commit;
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

	public RefreshAction getRefresh() {
		return refresh;
	}

	public void setRefresh(RefreshAction refresh) {
		this.refresh = refresh;
	}
	
	
}
