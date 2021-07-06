from typing import List


class Solution:
    def grayCode(self, n: int) -> List[int]:
        def grayCodeLogic(ar):
            if len(ar) < 2:
                return ar
            mid = len(ar)//2
            return grayCodeLogic(ar[:mid])+grayCodeLogic(ar[mid:])[::-1]

        return grayCodeLogic([num for num in range(0, 2**n)])


if __name__ == "__main__":
    N = 3
    out = Solution().grayCode(N)
    print(out)
