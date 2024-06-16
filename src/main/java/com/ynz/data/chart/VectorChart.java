package com.ynz.data.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.VectorRenderer;
import org.jfree.data.xy.VectorSeries;
import org.jfree.data.xy.VectorSeriesCollection;

import javax.swing.*;

public class VectorChart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Vector Chart Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(createVectorChartPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static JPanel createVectorChartPanel() {
        JFreeChart chart = createVectorChart();
        return new ChartPanel(chart);
    }

    private static JFreeChart createVectorChart() {
        VectorSeries series = new VectorSeries("Vector Data");

        // Add some sample vector data (x, y, deltaX, deltaY)
        series.add(0.0, 0.0, 1.0, 1.0);
        series.add(0.0, 0.0, 1.0, 2.0);
        //series.add(2.0, 3.0, -0.5, -0.5);
        //series.add(3.0, 1.0, 1.0, -0.2);

        VectorSeriesCollection dataset = new VectorSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Vector Chart",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = (XYPlot) chart.getPlot();
        VectorRenderer renderer = new VectorRenderer();
        plot.setRenderer(renderer);

        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setRange(0.0, 5.0);
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setRange(0.0, 5.0);
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }
}
