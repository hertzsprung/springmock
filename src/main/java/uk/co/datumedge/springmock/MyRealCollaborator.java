package uk.co.datumedge.springmock;

public class MyRealCollaborator implements MyCollaborator {
	public int compute() {
		throw new UnsupportedOperationException("I shouldn't be called from tests");
	}
}
