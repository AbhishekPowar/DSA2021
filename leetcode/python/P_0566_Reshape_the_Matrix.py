class Solution():
    # Code is kept verbose 
    def matrixReshape(self, mat, r: int, c: int):
        row = len(mat)
        col = len(mat[0])
        if r*c != row*col:
            return mat
        else:
            elemNum = 0
            newMat = [[0 for _ in range(c)] for _ in range(r)]
            print(newMat)
            for x in range(row):
                for y in range(col):
                    elem = mat[x][y]
                    newRow, newCol = int(elemNum/c), elemNum % c
                    newMat[newRow][newCol] = elem
                    elemNum += 1
            return newMat


if __name__ == "__main__":
    mat = [[1, 2, 3, 4], [5, 6, 7, 8]]
    r = 4
    c = 2
    reshapedMat = Solution().matrixReshape(mat, r, c)
    print(reshapedMat)
