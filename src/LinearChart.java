import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LinearChart extends JFrame {
    protected ArrayList<Node> LLdataset;
    public LinearChart(ArrayList<Node> LLdataset) {
        super("Gráfico por tempo");
        this.LLdataset = LLdataset;
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createChartPanel() {
        String chartTitle = "Gráfico por tempo";
        String categoryAxisLabel = "Tempo";
        String valueAxisLabel = "Ocorrências";

        DefaultCategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);

        return new ChartPanel(chart);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String series1 = "Sucetíveis";//s
        String series2 = "Recuperados";//r
        String series3 = "Infectados";//i

        for(Node no : LLdataset){
            dataset.addValue(no.s,series1,no.t);
            dataset.addValue(no.r,series2,no.t);
            dataset.addValue(no.i,series3,no.t);
        }

        return dataset;
    }
}