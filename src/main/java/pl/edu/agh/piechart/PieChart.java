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
 * Pie chart with a custom label generator.
 */
public class PieChart extends ApplicationFrame {

    private String title;
    private Map<String, Double> data;
    private PieDataset dataset;
    private JFreeChart chart;
    private ChartPanel chartPanel;

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
    
    private void createDataSet(){
        DefaultPieDataset result = new DefaultPieDataset();
        for (String name : this.data.keySet()) {
            result.setValue(name, this.data.get(name));
        }
        result.setValue("Java", new Double(43.2));
        this.dataset = result;
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
     * Recreates PieChart with current data set.
     */
    private void updatePieChart(){
        this.chart = createChart(this.title, this.dataset);
        this.chartPanel = new ChartPanel(chart);
        this.chartPanel.setPreferredSize(new java.awt.Dimension(640, 480));
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
