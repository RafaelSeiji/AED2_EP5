


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.*;

public class Grafico extends ApplicationFrame{

    protected Grafico(String applicationTittle, String chartTitle, Structure grafo){
        super(applicationTittle);
        JFreeChart barChart = ChartFactory.createBarChart(applicationTittle, "IDs dos vertices",
                "Grau dos vertices", createDataset(grafo,chartTitle),
                PlotOrientation.VERTICAL,true,false,false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(900,700));
        setContentPane(chartPanel);
    }

    protected CategoryDataset createDataset(Structure grafo, String desc){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int i = 0;
        for(LinkedList vertice : grafo.lista){
            System.out.println("Iteracao do grafico "+i);
            dataset.addValue(vertice.size(),desc,Integer.toString(i));
            i++;
        }
        return dataset;
    }
}