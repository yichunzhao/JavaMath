package com.ynz.data.regression;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class LinearRegressionExample extends JFrame {

    public LinearRegressionExample(String title) {
        super(title);

        // Create dataset
        XYSeriesCollection dataset = createDataset();
        SimpleRegression regression = performRegression(dataset);

        // Create chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Linear Regression Example",
                "X-Axis", "Y-Axis", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the plot with the regression line
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // Add regression line to the dataset
        XYSeries regressionSeries = new XYSeries("Regression Line");
        double minX = dataset.getSeries(0).getMinX();
        double maxX = dataset.getSeries(0).getMaxX();
        regressionSeries.add(minX, regression.predict(minX));
        regressionSeries.add(maxX, regression.predict(maxX));
        dataset.addSeries(regressionSeries);

        // Add the chart to a panel
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(800, 600));
        setContentPane(panel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries series = new XYSeries("Data Points");

        // Sample data (you can replace it with your own dataset)
        double[][] data = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 8},
                {7, 9},
                {8, 10},
                {9, 12},
                {10, 13}
        };

        for (double[] point : data) {
            series.add(point[0], point[1]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private SimpleRegression performRegression(XYSeriesCollection dataset) {
        SimpleRegression regression = new SimpleRegression();
        for (int i = 0; i < dataset.getSeries(0).getItemCount(); i++) {
            regression.addData(dataset.getSeries(0).getX(i).doubleValue(), dataset.getSeries(0).getY(i).doubleValue());
        }
        return regression;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LinearRegressionExample example = new LinearRegressionExample("Linear Regression Example");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
