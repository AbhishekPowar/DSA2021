package TestRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

	static Input obj = new Input();

	public List<Object> inArgs = new ArrayList<>();

	private Input() {

	}

	public static Input getInstance() {

		return obj;
	}

	public void add(Object... args) {
		List<Object> temp = new ArrayList<>();
		for (int i = 0; i < args.length; i++) {
			temp.add(args[i]);
		}
		inArgs.add(temp);
	}

	public Object[] getAsObjectArray(int i) {
		List<Object> temp = (List<Object>) this.inArgs.get(i);
		Object[] objArray = new Object[temp.size()];
		for (int j = 0; j < objArray.length; j++) {
			objArray[j] = temp.get(j);
		}
		return objArray;
	}

	public String print(int i) {

		StringBuilder sb = new StringBuilder("[ ");
		Object[] objArray = getAsObjectArray(i);
		List<Object> l = (List<Object>) inArgs.get(i);
		for (int idx = 0; idx < objArray.length; idx++) {
			// Object o = objArray[idx];
			Object o = l.get(idx);

			// if (o.getClass()== Integer[].class) {
			if (o.getClass().isArray()) {
				sb.append(printArray(o));
				// sb.append(Arrays.toString(l.get(idx)));
			} else {
				sb.append(o.toString());
			}
			if (idx < objArray.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(" ]\n");
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