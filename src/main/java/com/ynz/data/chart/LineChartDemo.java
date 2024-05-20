package com.ynz.data.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;


public class LineChartDemo extends JFrame {

    public LineChartDemo(String title) {
        super(title);

        // Create dataset
        DefaultCategoryDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Average Monthly Temperature",
                "Month",
                "Temperature (°C)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Customize the chart
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(panel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add series (e.g., cities)
        dataset.addValue(1.0, "New York", "January");
        dataset.addValue(4.0, "New York", "February");
        dataset.addValue(6.0, "New York", "March");
        dataset.addValue(8.0, "New York", "April");
        dataset.addValue(15.0, "New York", "May");
        dataset.addValue(20.0, "New York", "June");
        dataset.addValue(25.0, "New York", "July");
        dataset.addValue(30.0, "New York", "August");
        dataset.addValue(24.0, "New York", "September");
        dataset.addValue(18.0, "New York", "October");
        dataset.addValue(10.0, "New York", "November");
        dataset.addValue(5.0, "New York", "December");

        dataset.addValue(5.0, "London", "January");
        dataset.addValue(6.0, "London", "February");
        dataset.addValue(7.0, "London", "March");
        dataset.addValue(10.0, "London", "April");
        dataset.addValue(15.0, "London", "May");
        dataset.addValue(18.0, "London", "June");
        dataset.addValue(20.0, "London", "July");
        dataset.addValue(22.0, "London", "August");
        dataset.addValue(17.0, "London", "September");
        dataset.addValue(12.0, "London", "October");
        dataset.addValue(8.0, "London", "November");
        dataset.addValue(6.0, "London", "December");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var example = new LineChartDemo("Line Chart Example");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}



