def customMergeSort(ar, low, high, mapping):
    def joinArrays(ar, low, mid, high, mapping):
        output = []
        ptr1, ptr2 = low, mid+1
        while ptr1 <= mid and ptr2 <= high:
            if mapping.get(ar[ptr1], 27) < mapping.get(ar[ptr2], 27):
                output.append(ar[ptr1])
                ptr1 += 1
            else:
                output.append(ar[ptr2])
                ptr2 += 1
        while ptr1 <= mid:
            output.append(ar[ptr1])
            ptr1 += 1
        while ptr2 <= high:
            output.append(ar[ptr2])
            ptr2 += 1
        return output
    if high-1 > low:
        mid = (low+high)//2
        ar[low:mid+1] = customMergeSort(ar, low, mid, mapping)
        ar[mid+1:high+1] = customMergeSort(ar, mid+1, high, mapping)
        return joinArrays(ar, low, mid, high, mapping)
    else:
        if mapping.get(ar[low], 27) < mapping.get(ar[high], 27):
            return ar[low:high+1]
        else:
            return ar[low:high+1][::-1]


class Solution:
    def customSortStringWithMergeSort(self, order, s):
        mapping = {}
        for idx, ch in enumerate(order):
            mapping[ch] = idx
        ar = list(s)
        return ''.join(customMergeSort(ar, 0, len(ar)-1, mapping))

    def customSortStringBuiltinMethod(self, order, s):
        d = {ch: idx for idx, ch in enumerate(order)}
        return ''.join(sorted(s, key=lambda x: d.get(x, 27)))

    def customSortString(self, order, s):
        counter = {}
        for ch in s:
            counter[ch] = counter.get(ch, 0)+1
        output = []
        for ch in order:
            output.append(ch * counter.get(ch, 0))
            counter[ch] = 0
        for ch in counter.keys():
            output.append(ch * counter.get(ch, 0))
        return ''.join(output)


if __name__ == "__main__":
    order = 'cba'
    s = 'abcd'
    output = Solution().customSortString(order, s)
    print(output)
