#Collections

#Tuple
size = (100, 200)
print(size)
print("width: ",size[0])
print("height: ",size[1])

new_size = size + (300,)
print(new_size)

print(len(size))
print(max(size))
print(min(size))
print(100 in size)
print(50 in size)


#Array
movement = [5, -2, -3, 4, -1]
print(movement)
first_movement = movement[0]
movement[0] = 7

print(first_movement)
print(movement[0])

movement.append(-5)
print(movement)

movement.remove(-3)
print(movement)


#Dictionaries
starting_positions = {'p_0':50, 'p_1':100, 'p_2':150}
print(starting_positions)
print(starting_positions['p_0'])

#se pueden añadir y eliminar valores con .append .remove poniendo el indice
print(starting_positions.keys())
