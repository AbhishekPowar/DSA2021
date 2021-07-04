
import functools


class Solution():
    output = 0
    MOD = 10**9 + 7
    regMap = {
        'a': ['e'],
        'e': ['a', 'i'],
        'i': ['a', 'e', 'o', 'u'],
        'o': ['i', 'u'],
        'u': ['a'],
        's': ['a', 'e', 'i', 'o', 'u'],
    }

    def countVowelPermutation(self, n):
        @functools.lru_cache
        def solve(n, ch):
            total = 0
            if n > 0:
                for c in self.regMap[ch]:
                    total += solve(n-1, c) % self.MOD
            else:
                return 1
            return total
        return solve(n, 's') % self.MOD

    def countVowelPermutationDP(self, n):
        MOD = 10**9 + 7
        a = e = i = o = u = 1
        for _ in range(n-1):
            # a, e, i , o, u = (e) % MOD, (a+i) % MOD, (a+e+o + u) % MOD, (i+u) % MOD, (a) % MOD
            a_new = e         % MOD
            e_new = (a+i)     % MOD
            i_new = (a+e+o+u) % MOD
            o_new = (i+u)     % MOD
            u_new = (a)       % MOD
            a, e, i, o, u = a_new, e_new, i_new, o_new, u_new
        return (a+e+i+o+u) % MOD


if __name__ == '__main__':
    N = 5
    output = Solution().countVowelPermutation(N)
    print(output)
