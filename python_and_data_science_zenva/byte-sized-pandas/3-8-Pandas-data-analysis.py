import pandas as pd
import numpy as np

# leer excel
tracks = pd.read_excel('pandas/Tracks.xlsx', sheet_name=0)

print(tracks)

#Imprimir columnas
print(tracks.columns)

#Imprimir una columna
print(tracks['Milliseconds'])


# leer csv
flights = pd.read_csv('pandas/flights.csv') #Toma la primera fila columna como índice
print(flights)

flights = pd.read_csv('pandas/flights.csv', index_col = False) #Indicamos que no haya columna de indices
print(flights)

print(flights['ORIGIN'])
print(flights[['ORIGIN','DEST']])
print(flights[:3])

# Seleccionar el dato de la primera fila y primera columna
print(flights.iloc[0,0])

# Seleccionar el dato de la tercera fila y segunda columna
print(flights.iloc[2,1])

# Seleccionar el dato de la columna DAY_OF_MONTH de la tercera fila
print(flights.iloc[2, flights.columns.get_loc('DAY_OF_MONTH')])

# Ordenar por columnas
print(flights.sort_values(by=['DISTANCE']))
print(flights.sort_values(by=['DISTANCE'], ascending=False))
print(flights.sort_values(by=['DISTANCE', 'AIR_TIME'], ascending=False))

#Filtros
print(flights['MONTH']==1) #Imprime el resultado de la evaluación
print(flights[flights['MONTH']==1]) # Imprime los registros que cumplen con la evaluación

long_flights = flights[flights['DISTANCE'] > 4000]
print(long_flights)

print(long_flights[long_flights['ORIGIN_STATE_NM'] == "Hawaii"])
print(long_flights[(long_flights['ORIGIN_STATE_NM'] == "Hawaii") | (long_flights['DEST_STATE_NM'] == "Hawaii")])
print(flights[(flights['DISTANCE'] > 4000) & ~(flights['MONTH'] == 1)])

# Agregacion
flights_by_month = flights.groupby('MONTH')

print(flights_by_month.get_group(12))
print(flights_by_month['DISTANCE'].aggregate(np.sum))
print(flights_by_month['DISTANCE'].aggregate(np.mean))
print(flights_by_month['DISTANCE'].aggregate(np.sum).idxmax())
