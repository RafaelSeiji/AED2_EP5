import java.awt.Color;
import java.awt.Paint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class StackedBarChart extends ApplicationFrame {

    public int[] vetor;

    public StackedBarChart(final String title, int[] vetor) {
        super(title);
        this.vetor = vetor;
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(590, 350));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();

        result.addValue(vetor[1], "Infectados 1", "1");
        result.addValue(vetor[2], "Recuperados 1", "1");


        return result;
    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                "Infectados e Recuperados",  // chart title
                "Category",                  // domain axis label
                "Ocorrência",                     // range axis label
                dataset,                     // data
                PlotOrientation.VERTICAL,    // the plot orientation
                true,                        // legend
                true,                        // tooltips
                false                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");
        map.mapKeyToGroup("Infectados 1", "G1");
        map.mapKeyToGroup("Recuperados 1", "G1");
        renderer.setSeriesToGroupMap(map);

        renderer.setItemMargin(0.0);

        Paint p1 = new Color(0, 0, 255);//r
        renderer.setSeriesPaint(1, p1);

        Paint p2 = new Color(0,255,0);//i
        renderer.setSeriesPaint(0, p2);

        SubCategoryAxis domainAxis = new SubCategoryAxis("Infectados e Recuperados");
        domainAxis.setCategoryMargin(1);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart;

    }

    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
        LegendItem item1 = new LegendItem("Recuperados", new Color(0, 0, 255));
        LegendItem item2 = new LegendItem("Infectados", new Color(0, 255, 0));
        result.add(item1);
        result.add(item2);
        return result;
    }

}