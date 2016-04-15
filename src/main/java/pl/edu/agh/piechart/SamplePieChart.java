package pl.edu.agh.piechart;


public class SamplePieChart {
    public static void main(final String[] args) {
        // 1. init
        final PieChart demo = new PieChart("Testing...");
        // 2. (kinda optional, we start with empty data set) set some vals
        demo.setChartValue("JS", 7.2);
        demo.setChartValue("Ada", -10.2); // won't be shown (negative lav)
        demo.setChartValue("C++", 12.0);
        demo.setChartValue("Python", 37.2);
        // 3. (optional) change chart size
        demo.setChartSize(1200, 600);
    }
}
