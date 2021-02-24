package TestRunner;

import java.util.ArrayList;
import java.util.Arrays;
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

	public String print(int i) {

		StringBuilder sb = new StringBuilder("");
		Object obj = this.outArgs.get(i);

		if (obj.getClass().isArray()) {
			sb.append(printArray(obj));
		} else {
			sb.append(obj.toString());
		}

		return sb.toString();
	}

	public String printData(Object i) {

		StringBuilder sb = new StringBuilder("");
		Object obj = i;

		if (obj.getClass().isArray()) {
			sb.append(printArray(obj));
		} else {
			sb.append(obj.toString());
		}

		return sb.toString();
	}

	public String printArray(Object o) {
		if (o.getClass() == String[].class) {
			return Arrays.toString((String[]) o);
		}
		if (o.getClass() == Integer[].class) {
			return Arrays.toString((Integer[]) o);
		}
		if (o.getClass() == int[].class) {
			return Arrays.toString((int[]) o);
		}

		return "error";
	}
}
