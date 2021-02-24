package TestRunner;

import java.util.ArrayList;
import java.util.List;

public class Output<T> {
	static Output obj = new Output();

	public List<T> outArgs = new ArrayList<>();

	private Output() {

	}

	public static Output getInstance() {
		return obj;
	}

	public void add(T ar) {
		outArgs.add(ar);
	}
}
