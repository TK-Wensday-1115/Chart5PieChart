package pl.edu.agh.chart5;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

import java.text.AttributedString;

/**
 * A sample pie chart with a custom label generator.
 */
public class ChartTest extends ApplicationFrame {

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public ChartTest(final String title) {

        super(title);
        final PieDataset dataset = createSampleDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset for the demo.
     *
     * @return A sample dataset.
     */
    private PieDataset createSampleDataset() {

        final DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Java", new Double(43.2));
        result.setValue("Visual Basic", new Double(-10.0)); // won't be shown
        result.setValue("C/C++", new Double(17.5));
        result.setValue("Python", new Double(37.5));
        result.setValue("Perl", new Double(0.0)); // todo: hide for zeros
        return result;

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return A chart.
     */
    private JFreeChart createChart(final PieDataset dataset) {

        final JFreeChart chart = ChartFactory.createPieChart3D(
                "Pie Chart 3D Demo 4",  // chart title
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
        plot.setLabelGenerator(new CustomLabelGenerator());
        return chart;

    }

    public static void main(final String[] args) {

        final ChartTest demo = new ChartTest("Pie Chart 3D Demo 4");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

    /**
     * A custom label generator (returns null for one item as a test).
     */
    private static class CustomLabelGenerator implements PieSectionLabelGenerator {

        /**
         * Generates a label for a pie section.
         *
         * @param dataset  the dataset (<code>null</code> not permitted).
         * @param key  the section key (<code>null</code> not permitted).
         *
         * @return the label (possibly <code>null</code>).
         */
        public String generateSectionLabel(final PieDataset dataset, final Comparable key) {
            String result = null;
            if (dataset != null) {
                if (!key.equals("PHP")) {
                    result = key.toString();
                }
            }
            return result;
        }

        public AttributedString generateAttributedSectionLabel(PieDataset pieDataset, Comparable comparable) {
            return null; // TODO: 4/13/16 get rid of this...
        }
    }
}
