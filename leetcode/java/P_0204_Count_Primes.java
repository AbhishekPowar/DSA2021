package leetcode;

class P_0204_Count_Primes {
	private boolean isPrime(int num) {
		for (int i = 2; i <= Math.round(Math.sqrt(num)); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int normalMethod(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}

		return count;
	}

	public int countPrimes(int n) {
		if (n < 2)
			return 0;
		int count = 0;
		int allNum[] = new int[n - 1];
		for (int i = 2; i < allNum.length; i++) {
			allNum[i] = 1;
		}
		allNum[0] = 0;
		allNum[1] = 0;
		for (int i = 2; i <= Math.round(Math.sqrt(n)); i++) {
			if (allNum[i] == 1) {
				for (int j = i + i; j < allNum.length; j += i) {
					allNum[j] = 0;
				}
			}
		}
		for (int i = 2; i < allNum.length; i++) {
			if (allNum[i] == 1) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int num = 5000000;
		P_0204_Count_Primes handler = new P_0204_Count_Primes();

		Integer ans = handler.countPrimes(num);
		System.out.println(ans);

	}

}