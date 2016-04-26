# Chart5PieChart
Komponent pozwalający na wyświetlanie wykresu kołowego.

## Inicjalizacja i użycie komponentu

Demko gotowe do uruchomienia można znaleźć tutaj: [SamplePieChart.java](https://github.com/TK-Wensday-1115/Chart5PieChart/blob/master/src/main/java/pl/edu/agh/piechart/SamplePieChart.java)

1. Inicjalizacja JFrame i komponentu *PieChartPanel*. Można podać tytuł i rozmiar lub tylko tytuł wykresu.
    ```
    JFrame frame = new JFrame();
    PieChartPanel pie = new PieChartPanel("testing", 600, 600);
    PieChartPanel pie2 = new PieChartPanel("testing 2");
    ```

2. Dodanie PieChartPanel (który rozszerza JPanel) do JFrame
    ```
    frame.getContentPane().add(pie, BorderLayout.WEST);
    frame.getContentPane().add(pie2, BorderLayout.EAST);
    ```

3. Ustawianie wartości
    - jeśli klucz istnieje, to zmiana obecnej na podaną
    - jeśli wartość jest ujemna, to element nie zostanie wyświetlony na wykresie
    ```
    pie.setChartValue("Python", 37);
    pie.setChartValue("ASM", -22);
    pie2.setChartValue("Rain", 23);
    pie2.setChartValue("Sunny", 44);
    ```
