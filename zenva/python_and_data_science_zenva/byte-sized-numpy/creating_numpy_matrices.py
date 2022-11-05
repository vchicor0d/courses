import numpy as np

two_by_two = np.matrix([[1,2],[3,4]])
print(two_by_two)

two_by_three = np.matrix('1 2; 3 4; 5 6')
print(two_by_three)

print(np.zeros([3,2]))

#fetch
a_matrix = np.matrix([[1,2,3],[4,5,6],[7,8,9]])
print(a_matrix)
print(a_matrix[0])
print(a_matrix[1,0])
print(a_matrix[2, 1:3])

print(a_matrix.size)
print(a_matrix.shape)

#modification
a_matrix = np.matrix([[1,2],[3,4]])
print(a_matrix)

a_matrix[1,0]=10
a_matrix[0]=[6,3]
print(a_matrix)

#transpose
print(a_matrix.T)

#flatten
print(a_matrix.flatten())

print(np.matmul(a_matrix, a_matrix))

#matrix operations
image_matrix = np.matrix([[0,0,1,0,0],[0,0,1,0,0],[1,1,1,1,1],[0,0,1,0,0],[0,0,1,0,0]])
print(image_matrix)

rows = image_matrix.shape[0]
columns = image_matrix.shape[1]
print(rows)
print(columns)

for row in range(rows):
    for column in range(columns):
        if image_matrix[row, column] == 0:
            image_matrix[row, column] = 1
        else:
            image_matrix[row, column] = 0
print(image_matrix)

