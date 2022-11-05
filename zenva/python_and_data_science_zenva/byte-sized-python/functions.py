#Functions

x_pos = 0
e_x_pos = 5

print(x_pos)

def move():
    #si no le decimos que usemos variable global da error porque aun no ha sido definida en el metodo
    global x_pos
    x_pos+=1

move()

print(x_pos)

def move_by(amount):
    global x_pos
    x_pos += amount

move_by(-5)
print(x_pos)

def check_for_collision():
    global x_pos
    global e_x_pos
    if x_pos == e_x_pos:
        return True
    else:
        return False

did_collide = check_for_collision()

print(did_collide)
