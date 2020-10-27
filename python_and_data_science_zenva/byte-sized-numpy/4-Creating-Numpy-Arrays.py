#numpy arrays
import numpy as np

#classic list

list_1 = [1,2,3]
print(list_1)

#numpy arrays

#form existing list
numpy_1 = np.array(list_1)
print(numpy_1)

#array of zeroes
zeros_array = np.zeros(5)
print(zeros_array)

#array of ones
ones_array = np.ones(10)
print(ones_array)

#range array (5 elements)
range_array_1 = np.arange(5)
print(range_array_1)

#range array (from 5 to 11 (excluded))
range_array_2 = np.arange(5,11)
print(range_array_2)

#range array (from 0 to 20 step 2)
range_array_3 = np.arange(0,20,2)
print(range_array_3)

#Creates an array of 5 elements from 0 to 10 both included evenly spaced
linspace_array = np.linspace(0,10,5)
print(linspace_array)
