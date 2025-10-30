# Análise de Performance de Algoritmos de Sorting
Não foram medidas as trocas realizadas pelo BucketSort, já que não é realizada nenhuma troca de fato no algoritmo auxiliar (InsertionSort).

## Cenário 1: Vetor Semi Organizado

### Ranking por Movimentação de Dados
O `SelectionSort` assume a liderança no tópico de movimentação de dados (18 trocas) por uma margem pequena sobre o `CombSort` (22 trocas). 

| Rank | Algoritmo | Valor (Movimentações) | Tipo |
| :--- | :--- | :--- | :--- |
| 1 | **SelectionSort** | **18** | (Trocas) |
| 2 | CombSort | 22 | (Trocas) |
| 3 | GnomeSort | 78 | (Trocas) |
| 4 | CocktailSort | 78 | (Trocas) |
| 5 | BubbleSort | 78 | (Trocas) |

### Ranking por Iterações
O **BucketSort** é o **vencedor em iterações** (92), tornando-o o algoritmo mais rápido no geral para este caso.

| Rank | Algoritmo | Valor (Iterações) |
| :--- | :--- | :--- |
| 1 | **BucketSort** | **92** |
| 2 | CombSort | 129 |
| 3 | CocktailSort | 154 |
| 4 | GnomeSort | 176 |
| 5 | BubbleSort | 180 |
| 6 | SelectionSort | 190 |

---

## Cenário 2: Vetor Ordenado (Melhor Caso)

### Ranking por Movimentação de Dados
Todos os algoritmos medidos têm um custo de movimentação nulo.

| Rank | Algoritmo | Valor (Movimentações) | Tipo |
| :--- | :--- | :--- | :--- |
| 1 | GnomeSort | 0 | (Trocas) |
| 2 | CocktailSort | 0 | (Trocas) |
| 3 | CombSort | 0 | (Trocas) |
| 4 | BubbleSort | 0 | (Trocas) |
| 5 | SelectionSort | 0 | (Trocas) |

### Ranking por Iterações
Em iterações, os algoritmos Cocktail, Bubble, Gnome vencem por terminarem em Ω(n).

| Rank | Algoritmo | Valor (Iterações) |
| :--- | :--- | :--- |
| 1 | CocktailSort | 19 |
| 2 | BubbleSort | 19 |
| 3 | GnomeSort | 20 |
| 4 | **BucketSort** | **85** |
| 5 | CombSort | 110 |
| 6 | SelectionSort | 190 |

---

## Cenário 3: Vetor Invertido (Pior Caso)

### Ranking por Movimentação de Dados
Este é o cenário mais competitivo. O `SelectionSort` é o campeão em movimentações (10 trocas). O `CombSort` (18 trocas) fica em segundo lugar com a menor contagem.

| Rank | Algoritmo | Valor (Movimentações) | Tipo |
| :--- | :--- | :--- | :--- |
| 1 | **SelectionSort** | **10** | (Trocas) |
| 2 | CombSort | 18 | (Trocas) |
| 3 | GnomeSort | 190 | (Trocas) |
| 4 | CocktailSort | 190 | (Trocas) |
| 5 | BubbleSort | 190 | (Trocas) |

### Ranking por Iterações 
Em iterações, o **`CombSort` (129)** e o **`BucketSort` (132)** estão praticamente empatados, sendo significativamente mais rápidos que todos os outros.

| Rank | Algoritmo | Valor (Iterações) |
| :--- | :--- | :--- |
| 1 | **CombSort** | **129** |
| 2 | **BucketSort** | **132** |
| 3 | CocktailSort | 190 |
| 4 | BubbleSort | 190 |
| 5 | SelectionSort | 190 |
| 6 | GnomeSort | 400 |
