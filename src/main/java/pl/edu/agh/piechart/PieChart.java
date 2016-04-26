package pl.edu.agh.piechart;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;

public class PieChart extends JPanel {

    private Map<String, Double> data = new HashMap<String, Double>();
    private PiePlot3D piePlot3D = new PiePlot3D();

    /**
     * Creates a pie chart with default size.
     * @param title the frame title.
     */
    public PieChart(final String title) {
        pieChartInit(title, 500, 500);
    }

    public PieChart(final  String title, final int width, final int height){
        pieChartInit(title, width, height);
    }

    /**
     * Set value for a key name, if it does not exist - add it and update data set.
     * @param name  item name
     * @param value value, negative won't be shown
     */
    public void setChartValue(final String name, final double value) {
        this.data.put(name, value);
        piePlot3D.setDataset(makeDataSet());
        repaint();
    }

    private void pieChartInit(final String title, final int width, final int height) {
        JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, piePlot3D, true);
        this.add(new ChartPanel(chart,
                                width, height, width, height, width, height,
                                false, true, true, true, true, true));
        repaint();
    }

    private PieDataset makeDataSet() {
        DefaultPieDataset result = new DefaultPieDataset();
        for (String name : this.data.keySet()) {
            result.setValue(name, this.data.get(name));
        }
        return result;
    }
}