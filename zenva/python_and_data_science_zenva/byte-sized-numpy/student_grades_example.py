# Student Grades Example
import numpy as np

student_grades = np.array([56,78,98,90,58,64,67,72,93,51])
print(student_grades)

class_average = np.average(student_grades)
print(class_average)

highest_grade = np.amax(student_grades)
print(highest_grade)

lowest_grade = np.amin(student_grades)
print(lowest_grade)

print(np.argmax(student_trades))
print(np.argmin(student_trades))

print(np.sort(student_grades))
print(-np.sort(-student_grades))

increased_grades = student_grades * 1.1
print(increased_grades)

print(np.add(student_grades, np.ones(10)))
