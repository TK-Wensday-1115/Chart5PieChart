package pl.edu.agh.piechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

import java.util.HashMap;
import java.util.Map;

/**
 * Pie chart generator.
 */
@SuppressWarnings("WeakerAccess")
public class PieChart extends ApplicationFrame {

    private String title;
    private Map<String, Double> data;
    private PieDataset dataset;

    private int WIN_WIDTH = 640;
    private int WIN_HEIGHT = 480;

    /**
     * Creates a pie chart.
     *
     * @param title  the frame title.
     */
    public PieChart(final String title) {
        super(title);
        this.title = title;
        this.data = new HashMap<String, Double>();
        createDataSet(); // empty one
        updatePieChart();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }

    /**
     * Set value for a key name, if it does not exist - add it.
     * @param name  item name
     * @param value value, negative won't be shown
     */
    public void setChartValue(final String name, final double value) {
        // add value or alter in data map
        this.data.put(name, value);
        // recreate PieDataSet
        createDataSet();
        // Update PieChart
        updatePieChart();
    }

    /**
     * Change window height and width.
     */
    public void setChartSize(final int width, final int height) {
        this.WIN_WIDTH = width;
        this.WIN_HEIGHT = height;
        updatePieChart();
    }

    private void createDataSet(){
        DefaultPieDataset result = new DefaultPieDataset();
        for (String name : this.data.keySet()) {
            result.setValue(name, this.data.get(name));
        }
        this.dataset = result;
    }

    /**
     * Recreates PieChart with current data set.
     */
    private void updatePieChart(){
        JFreeChart chart = createChart(this.title, this.dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(WIN_WIDTH, WIN_HEIGHT));
        setContentPane(chartPanel);
        pack();
    }

    /**
     * Creates the PieChart.
     */
    private JFreeChart createChart(final String title, final PieDataset dataset) {
        final JFreeChart chart = ChartFactory.createPieChart3D(
                title,  // chart title
                dataset,                // data
                true,                   // include legend
                true,
                false
        );

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setNoDataMessage("No data to display");
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator());
        return chart;
    }
}
