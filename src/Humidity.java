import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C6684E2D-2590-A0E4-E84C-C36127C2A4A3]
// </editor-fold> 
public class Humidity implements Observer {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E6A8E2BE-C9A6-5268-7C95-BC01587F76AF]
    // </editor-fold> 
    private String percentage;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D20CFD80-C5C1-D1DA-6D0B-F169C260F5E1]
    // </editor-fold> 
    public Humidity () {
    }

     @Override
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0BBEE4F7-EC93-93E3-A1DF-4E87F448C22F]
    // </editor-fold> 
    public void Update (JPanel MainPanel) {
         try {
        String query = "SELECT name, humidity FROM forecast";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(Mysql.getConnection(), query);
        JFreeChart chart = ChartFactory.createBarChart3D("Humidity Chart", "District", "Humidity in %", dataset, PlotOrientation.VERTICAL, false, true, true);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(209, 193, 190));
        plot.getRenderer().setSeriesPaint(0, new Color(0, 102, 255));
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        BarRenderer br = (BarRenderer) categoryPlot.getRenderer();
        br.setMaximumBarWidth(.03); 
        ChartPanel panel = new ChartPanel(chart);
        MainPanel.add(panel);
        
         
         panel.setSize(800,185); 
         panel.setLocation(50, 400);
        
        }
        catch(Exception except){
        
        except.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.49291E35-684D-63AE-BFF9-CCFA3F512955]
    // </editor-fold> 
    public String getPercentage () {
        return percentage;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E7BD2C82-7122-4D64-7B64-DE163BB9AF20]
    // </editor-fold> 
    public void setPercentage (String val) {
        this.percentage = val;
    }

}

