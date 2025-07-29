
# Análisis de Tiempo usando Sumatorias

Este documento contiene el análisis de tiempo de ejecución de varios fragmentos de código utilizando sumatorias, y su simplificación para obtener la notación Big-O.

---

## Caso 1: `for (i = 1; i <= n; i++)`

Este `for` se ejecuta exactamente `n` veces.

**Sumatoria**:  
\[
T(n) = \sum_{i=1}^{n} 1 = n
\]

**Orden**:  
\[
\mathcal{O}(n)
\]

---

## Caso 2: `for (i = 1; i <= n; i++) for (j = 1; j <= n; j++)`

Dos bucles anidados independientes.

**Sumatoria**:  
\[
T(n) = \sum_{i=1}^{n} \sum_{j=1}^{n} 1 = n \cdot n = n^2
\]

**Orden**:  
\[
\mathcal{O}(n^2)
\]

---

## Caso 3: `for (i = 1; i <= n; i++) for (j = 1; j <= i; j++)`

Segundo bucle depende del índice `i`.

**Sumatoria**:  
\[
T(n) = \sum_{i=1}^{n} \sum_{j=1}^{i} 1 = \sum_{i=1}^{n} i = \frac{n(n+1)}{2}
\]

**Orden**:  
\[
\mathcal{O}(n^2)
\]

---

## Caso 4: `for (i = 1; i <= n; i *= 2)`

El índice `i` se multiplica por 2 en cada iteración.

**Cantidad de iteraciones**:  
\[
i = 1, 2, 4, 8, ..., \text{hasta que } i > n
\]

Eso ocurre aproximadamente \( \log_2(n) \) veces.

**Orden**:  
\[
\mathcal{O}(\log n)
\]

---

## Caso 5: `for (j = 1; j < n; j += n/2)`

Aquí el incremento no es constante: `j` crece de a `n/2`.

**Cantidad de iteraciones**:
\[
\left\lceil \frac{n - 1}{n/2} \right\rceil = 2
\]

**Sumatoria**:
\[
T(n) = \sum_{j=1}^{n} 1 \quad \text{(solo se ejecuta 2 veces)}
\]

**Orden**:  
\[
\mathcal{O}(1)
\]

---
