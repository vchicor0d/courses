#Classes and objects

#Definicion de clase
class GameCharacter:

    #Variable global
    speed = 5

    #Constructor (self es necesario, refiere la propia clase)
    def __init__(self, name, width, height, x_pos, y_pos):
        self.name = name
        self.width = width
        self.height = width
        self.x_pos = x_pos
        self.y_pos = y_pos

    def move(self, x, y):
        self.x_pos += x
        self.y_pos += y

#Instanciacion de la clase, creacion de un objeto, no se le pasa el self
character_0 = GameCharacter('char_0', 50, 100, 100, 100)

print(character_0.name)
print(character_0.x_pos, " ", character_0.y_pos)
character_0.move(50,100)
print(character_0.x_pos, " ", character_0.y_pos)


#Subclases, superclases y herencia
#Se construye una clase a la que se le pasa el nombre de la clase de la que hereda como parametro
class PlayerCharacter(GameCharacter):

    def __init__(self, name, width, height, x_pos, y_pos):
        #Llamamos al constructor de la clase padre
        super().__init__(self, name, width, height, x_pos, y_pos)

player_character = PlayerCharacter('P_character', 100, 100, 100, 100)
print(player_character.name)
print(player_character.x_pos, " ", player_character.y_pos)
player_character.move(50,100)
print(player_character.x_pos, " ", player_character.y_pos)

class PlayerCharacter2(GameCharacter):

    speed = 10
    
    def __init__(self, name, x_pos, y_pos):
        #Llamamos al constructor de la clase padre
        super().__init__(self, name, 100, 100, x_pos, y_pos)

    #Sobreescribimos metodo de la clase padre
    def move(self, y):
        super().move(0,y)

player_character2 = PlayerCharacter('P_character2', 100, 100)
print(player_character2.name)
print(player_character2.x_pos, " ", player_character2.y_pos)
player_character2.move(50)
print(player_character2.x_pos, " ", player_character2.y_pos)
