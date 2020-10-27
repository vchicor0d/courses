import pandas as pd
import numpy as np

# DataFrame: a 2D table with rows and columns
df_data = {
    'col1': np.random.rand(5),
    'col2': np.random.rand(5),
    'col3': np.random.rand(5)
}

df = pd.DataFrame(df_data)
print(df)

#Obtener las 2 primeras filas
print(df[:2])

#Obtener una columna
print(df['col1'])

#Obtener varias columnas
print(df[['col1','col3']])
