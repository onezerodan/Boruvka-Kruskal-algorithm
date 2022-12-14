## Описание алгоритма

1. Множество ребер минимального остновного дерева устанавливается пустым
2. Отсортировать ребра в исходном графе в неубывающем порядке
3. Начинаем обзодить множество ребер исходного графа 
4. Если добавление текущего ребра не создаст цикла (вершины ребра принадлежат разным компонентам связности), добавляем ребро в MST
5. Если таких ребер больше нет (или количество ребер стало равно общему количеству вершин исохдного графа -1), то завершаем цикл.
6. MST готов.

## Дополнительный вопрос
Как понять, что 2 вершины в одной компоненте связности?  

Ответ:  
Для этого для каждого узла создаем свой собственный набор, в котором будет содержаться непосредственно сам узел.
На последующих итерациях проверяем, лежат ли вершины одного ребра в разных наборах. Если да - то цикла нет и ребро добавляется в MST.
Если вершины лежат в одном наборе, значит существует цикл => ребро не добавляется.

Реализация:  
с помощью DisjointSet создаем такие наборы для каждой вершины (init).
в методе detectCycle смотрим корень множества для каждой вершины. Если они совпадают, то цикл обнаружен.
Если нет, приравниваем корень одной вершины к корню другой.