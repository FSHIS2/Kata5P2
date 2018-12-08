package kata5.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata5.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    
    private final Histogram <String> histogram;
    public HistogramDisplay(Histogram <String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension (500, 400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", 
                                                            "Dominios email", 
                                                            "Nº de emails", 
                                                            dataSet, PlotOrientation.VERTICAL, 
                                                            false, rootPaneCheckingEnabled, 
                                                            rootPaneCheckingEnabled);
        return chart;
    }
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //Operación funcional, se podría haber usado también
        //for(String key: histogram.keyset()) {}
        histogram.keyset().forEach((key) -> {
            dataset.addValue(histogram.get(key), "", (Comparable) key);
        });
        return dataset;
    }  
}

