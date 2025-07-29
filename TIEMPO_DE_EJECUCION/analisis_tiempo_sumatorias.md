# ⌛ Análisis de Tiempo de Ejecución Usando Sumatorias

Este documento presenta ejemplos prácticos de análisis de complejidad temporal mediante sumatorias, diferenciando casos de bucles independientes y dependientes.

---

## 🎯 Ejercicio 1 – Bucle simple lineal

```cpp
for (int i = 0; i < n; i++) {
    x = x + 1;
}
```

### Sumatoria:
\[ T(n) = \sum_{i=0}^{n-1} 1 = n \]

### Resultado:
\[ \boxed{O(n)} \]

---

## 🎯 Ejercicio 2 – Bucles anidados independientes

```cpp
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        x = x + 1;
    }
}
```

### Sumatoria:
\[ T(n) = \sum_{i=0}^{n-1} \sum_{j=0}^{n-1} 1 = \sum_{i=0}^{n-1} n = n^2 \]

### Resultado:
\[ \boxed{O(n^2)} \]

---

## 🎯 Ejercicio 3 – Bucle anidado dependiente

```cpp
for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
        x = x + 1;
    }
}
```

### Sumatoria:
\[ T(n) = \sum_{i=0}^{n-1} \sum_{j=0}^{i-1} 1 = \sum_{i=0}^{n-1} i = \frac{n(n-1)}{2} \]

### Resultado:
\[ \boxed{O(n^2)} \]

---

## 🎯 Ejercicio 4 – Bucle logarítmico

```cpp
for (int i = 1; i < n; i *= 2) {
    x = x + 1;
}
```

### Análisis:
\[ i = 2^k < n \Rightarrow k < \log_2 n \]

### Sumatoria:
\[ T(n) = \sum_{i=1}^{<n,\;i *= 2} 1 = \lfloor \log_2 n \rfloor \]

### Resultado:
\[ \boxed{O(\log n)} \]

---

## 🎯 Ejercicio 5 – Combinación de lineal y logarítmico

```cpp
for (int i = 0; i < n; i++) {
    for (int j = 1; j < n; j *= 2) {
        x = x + 1;
    }
}
```

### Sumatoria:
\[ T(n) = \sum_{i=0}^{n-1} \sum_{j=1}^{<n,\;j *= 2} 1 = \sum_{i=0}^{n-1} O(\log n) = n \cdot \log n \]

### Resultado:
\[ \boxed{O(n \log n)} \]

---

## 🎯 Ejercicio 6 – Bucle con incremento proporcional a `n`

```cpp
for (int j = 1; j < n; j += n/2) {
    x = x + 1;
}
```

### Análisis:
- `j` toma los valores: 1, 1 + n/2, 1 + n
- Esto implica que el bucle se ejecuta **a lo sumo dos veces** (constante)

### Sumatoria:
\[ T(n) = \sum_{j=1}^{<n,\;j+=n/2} 1 = O(1) \]

### Resultado:
\[ \boxed{O(1)} \]

### ¿Y si está dentro de otro bucle?

```cpp
for (int i = 0; i < n; i++) {
    for (int j = 1; j < n; j += n/2) {
        x = x + 1;
    }
}
```

- Bucle externo: \( O(n) \)
- Bucle interno: \( O(1) \)

\[ T(n) = O(n) \cdot O(1) = \boxed{O(n)} \]

---

## 📄 Resumen de fórmulas útiles

- \( \sum_{i=1}^{n} 1 = n \)
- \( \sum_{i=1}^{n} i = \frac{n(n+1)}{2} = O(n^2) \)
- \( \sum_{i=1}^{n} \log i = O(n \log n) \)
- \( \sum_{i=0}^{\log n} 2^i = O(n) \)
- \( \sum_{i=1}^{n} \frac{1}{i} = O(\log n) \)

---

💡 **Tip**: Para cada bucle, preguntate:
- ¿Cuántas veces se ejecuta?
- ¿Depende del índice externo?
- ¿El incremento es lineal o multiplicativo?

📝 Este material está listo para usar como guía de estudio. Puedes copiarlo o transformarlo en PDF o documento impreso. ¡Buena práctica!
