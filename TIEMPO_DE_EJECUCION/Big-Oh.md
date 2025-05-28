# Complejidad Algorítmica con Ejemplos

## Tiempo Constante: `O(1)`

> El tiempo de ejecución no cambia con el tamaño de la entrada.

![Tiempo constante](https://github.com/user-attachments/assets/57b587ba-b36c-4b70-adb9-ae797a379b4c)

---

## Ciclos

### `O(n)` - Tiempo Lineal

> La complejidad depende del tamaño de la entrada: la variable del ciclo **depende de la entrada** e **incrementa o decrementa linealmente**.

![Tiempo lineal](https://github.com/user-attachments/assets/d70b6c30-b191-42d3-ac29-4212a05f243e)

---

### `O(1)` - Tiempo Constante en un Ciclo

> El ciclo **itera una cantidad fija de veces**, no depende de la entrada.

![Ciclo constante](https://github.com/user-attachments/assets/c29ac93c-9228-47e0-b399-c27f4ea87dc1)

---

## Ciclos Anidados

> La complejidad depende de cuántos ciclos anidados tengamos.

![Ciclos anidados](https://github.com/user-attachments/assets/eb74c973-72d6-4857-a34e-ba563d5faef3)

---

### Crecimiento Multiplicativo o Exponencial

#### Multiplicación o División en vez de suma o resta

> Si la variable del ciclo **se multiplica o divide** en cada iteración, la complejidad cambia.

![Multiplicación o división](https://github.com/user-attachments/assets/f3c80f6a-92c8-4327-aa82-65ab0dc82393)

#### Incremento Exponencial

> Si el ciclo crece de forma **exponencial**, la complejidad es mucho mayor.

![Incremento exponencial](https://github.com/user-attachments/assets/7796ef85-8368-4e11-b769-f8cce98aada3)

---

## Notación Big-O

> Big-O es una **expresión asintótica** que describe el comportamiento del algoritmo a medida que crece la entrada.

- **Siempre simplificar**.
- En un algoritmo con múltiples operaciones, **se suma la complejidad de cada parte**.
- Por propiedad de la suma, **solo se conserva el término más significativo** (y se eliminan las constantes).

### Ejemplo
![image](https://github.com/user-attachments/assets/29f69ba8-ab37-47e9-acf1-980d26cc5d14)

