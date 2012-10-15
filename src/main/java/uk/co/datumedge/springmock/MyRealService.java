package uk.co.datumedge.springmock;

public class MyRealService implements MyService {
	private MyCollaborator collaborator;

	public MyRealService(MyCollaborator collaborator) {
		this.collaborator = collaborator;
	}

	public int performUsefulFunction() {
		return collaborator.compute() * 2;
	}
}
