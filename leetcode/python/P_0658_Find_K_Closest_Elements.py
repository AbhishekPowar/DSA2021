import heapq


def findClosestK(arr, k, x):
    class num:
        def __init__(self, data):
            self.data = data

        def __lt__(self, other):
            # An integer a is closer to x than an integer b if:

            # |a - x| < |b - x|, or
            # |a - x| == |b - x| and a < b
            a = self.data
            b = other.data
            x = num.x
            return (
                    (abs(a-x) < abs(b-x))
                    or
                    ((abs(a - x) == abs(b-x)) and (a < b))
                    )

    num.x = x
    objar = [num(i) for i in arr]
    heapq.heapify(objar)
    ans = []
    for i in range(0, k):
        val = heapq.heappop(objar).data
        ans.append(val)
    return sorted(ans)


ar = [1, 2, 3, 5, 6]
k = 4
x = 3
findClosestK(ar, k, x)
