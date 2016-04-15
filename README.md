# Chart5PieChart
Komponent pozwalający na wyświetlanie wykresu kołowego.

## Inicjalizacja i użycie komponentu

Demko gotowe do uruchomienia można znaleźć tutaj: [SamplePieChart.java](https://github.com/TK-Wensday-1115/Chart5PieChart/blob/master/src/main/java/pl/edu/agh/piechart/SamplePieChart.java)

1. Inicjalizacja komponentu
    ```
    final PieChart demo = new PieChart("Testing...");
    ```

2. Ustawianie wartości
    - jeśli klucz istnieje, to zmiana obecnej na podaną
    - jeśli wartość jest ujemna to elemnt nie zostanie wyświetlony na wykresie
    ```
    demo.setChartValue("JS", 7.2);
    demo.setChartValue("Ada", -10.2); // <-- ujemna! nie zostanie wyświetona
    demo.setChartValue("C++", 12.0);
    demo.setChartValue("Python", 37.2);
    ```
    
3. Zmiana rozmiarów okna z wykresem
    ```
    demo.setChartSize(1200, 600);
    ```
