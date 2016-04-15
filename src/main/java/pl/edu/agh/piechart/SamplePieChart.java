package pl.edu.agh.piechart;


public class SamplePieChart {
    public static void main(final String[] args) {
        // 1. init
        final PieChart demo = new PieChart("Testing...");
        // 2. (kinda optional, we start with empty data set) set some values
        demo.setChartValue("JS", 7.2);
        demo.setChartValue("Ada", -10.2); // won't be shown (negative val)
        demo.setChartValue("Python", 37.2);
        demo.setChartValue("C++", 25.0);
        // wait 5 seconds and alter C++
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        demo.setChartValue("C++", 50.0);
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        // 3. (optional) change chart size
        demo.setChartSize(1200, 600);
    }
}
