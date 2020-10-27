#numpy fetch operations
import numpy as np

an_array = np.arange(0,11)
print(an_array)

#access a single items based on index
first_element = an_array[0]
print(first_element)
last_element = an_array[10]
print(last_element)

#access a range of elements
first_five = an_array[0:5]
print(first_five)
#si no se pone inicio o final de rango va hasta el límite
first_five = an_array[:5]
print(first_five)
last_five = an_array[6:]
print(last_five)
#Sin poner final de rango, de 2 en 2
last_five_step = an_array[6::2]
print(last_five_step)
#Si se pone step negativo irá de mayor a menor índice
first_five_reversed = an_array[4::-1]
print(first_five_reversed)
final_two = an_array[-2:]
print(final_two)

#Functions
print(an_array.size)
print(np.amax(an_array))
print(np.amin(an_array))
print(np.average(an_array))
