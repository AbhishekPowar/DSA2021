package TestRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static boolean minimal = false;

	static public void run(Input input, Output expectedOutput, Class obj, String funcName) {
		List<Method> l = Arrays.asList(obj.getMethods());
		Method func = l.stream().filter(e -> e.getName().contains(funcName)).collect(Collectors.toList()).get(0);

		if (input.inArgs.size() != expectedOutput.outArgs.size()) {
			System.out.println("NO match");
			return;
		}
		int passCount = 0;
		for (int i = 0; i < input.inArgs.size(); i++) {
			try {
				Object ans = func.invoke(obj.newInstance(), input.getAsObjectArray(i));
				boolean pass = expectedOutput.printData(ans).equals(expectedOutput.print(i));
				if (pass) {
					passCount++;
				}
				// If not minimal or test case fails
				if (!minimal || !pass) {
					System.out.print("Input :" + input.print(i));
					System.out.println("Expected Output : " + expectedOutput.print(i));
					System.out.println("Output : " + expectedOutput.printData(ans));
					System.out.println("Testcase " + (pass ? "Passed ✓" : "Failed X"));
					System.out.println("-------------------------------------");
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| InstantiationException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Cleared " + passCount + " out of " + input.inArgs.size() + " cases");
	}
}
