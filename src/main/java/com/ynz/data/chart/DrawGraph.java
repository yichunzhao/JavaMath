package com.ynz.data.chart;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;

public class DrawGraph extends JFrame {
    public DrawGraph() {
        super("Neural Network Visualization");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            // Layer 1 (Input Layer)
            Object v1 = graph.insertVertex(parent, null, "Input 1", 20, 150, 80, 30);
            Object v2 = graph.insertVertex(parent, null, "Input 2", 20, 250, 80, 30);

            // Layer 2 (Hidden Layer)
            Object v3 = graph.insertVertex(parent, null, "Hidden 1", 200, 100, 80, 30);
            Object v4 = graph.insertVertex(parent, null, "Hidden 2", 200, 200, 80, 30);
            Object v5 = graph.insertVertex(parent, null, "Hidden 3", 200, 300, 80, 30);

            // Layer 3 (Output Layer)
            Object v6 = graph.insertVertex(parent, null, "Output 1", 380, 150, 80, 30);
            Object v7 = graph.insertVertex(parent, null, "Output 2", 380, 250, 80, 30);

            // Edges between Input and Hidden Layer
            graph.insertEdge(parent, null, "", v1, v3);
            graph.insertEdge(parent, null, "", v1, v4);
            graph.insertEdge(parent, null, "", v1, v5);
            graph.insertEdge(parent, null, "", v2, v3);
            graph.insertEdge(parent, null, "", v2, v4);
            graph.insertEdge(parent, null, "", v2, v5);

            // Edges between Hidden and Output Layer
            graph.insertEdge(parent, null, "", v3, v6);
            graph.insertEdge(parent, null, "", v3, v7);
            graph.insertEdge(parent, null, "", v4, v6);
            graph.insertEdge(parent, null, "", v4, v7);
            graph.insertEdge(parent, null, "", v5, v6);
            graph.insertEdge(parent, null, "", v5, v7);

        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);

        // Layout
        mxCircleLayout layout = new mxCircleLayout(graph);
        layout.execute(graph.getDefaultParent());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawGraph frame = new DrawGraph();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setVisible(true);
        });
    }
}
