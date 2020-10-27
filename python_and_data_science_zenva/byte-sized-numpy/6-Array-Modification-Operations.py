#numpy modification operations
import numpy as np

an_array = np.arange(0,6)
print(an_array)

an_array[0]=10
print(an_array)

an_array = np.arange(0,6)
#creates a new array appending a digit at the end
print(np.append(an_array, 6))

an_array = np.arange(0,6)
#creates a new array appending a list at the end
print(np.append(an_array, [6, 7]))

#Insert items into an array at 0 position
print(np.insert(an_array, 0, [10, 11]))

#deletes item at postion
print(np.delete(an_array, 3))

print(an_array * 2)
print(an_array +2)

#sort
another_array = np.array([3,6,21,9,10,1])
print(np.sort(another_array))
