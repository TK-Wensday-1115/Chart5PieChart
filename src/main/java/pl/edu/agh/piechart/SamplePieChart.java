package pl.edu.agh.piechart;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class SamplePieChart {
    public static void main(final String[] args) {
        // Create main JFrame for testing
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create JPanels (PieCharts)
        PieChart pie = new PieChart("testing", 600, 600);
        PieChart pie2 = new PieChart("testing 2");

        // add JPanels to JFrame
        frame.getContentPane().add(pie, BorderLayout.WEST);
        frame.getContentPane().add(pie2, BorderLayout.EAST);
        frame.setSize(1100, 700);
        frame.setVisible(true);
        frame.setResizable(false);

        // add some data
        pie.setChartValue("Python", 37);
        pie2.setChartValue("Rain", 23);
        pie2.setChartValue("Sunny", 44);

        // wait 3 seconds and add some data
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        pie.setChartValue("Ada", 220);
        pie.setChartValue("C", 22);
        pie.setChartValue("ASM", -22);
        pie2.setChartValue("Rain", -1);
        pie2.setChartValue("Cloudy", 2);
    }
}
