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
// #[regen=yes,id=DCE.91BA8EA1-A505-0F65-F1CB-3A35C9DF2E5B]
// </editor-fold> 
public class Temperature implements Observer {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7B562CCB-C1CB-411B-3F48-DA71F51CF0F2]
    // </editor-fold> 
    private String grades;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DC5EAE21-B489-8D5E-3BA6-C53C29291762]
    // </editor-fold> 
    public Temperature () {
    }

    @Override
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.22C253AB-1FCC-C510-39E5-7B567271E939]
    // </editor-fold> 
    public void Update (JPanel MainPanel) {
      
        try {
        String query = "SELECT name, temperature FROM forecast";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(Mysql.getConnection(), query);
        JFreeChart chart = ChartFactory.createBarChart3D("Temperature Chart", "District", "Temperature in Celsius", dataset, PlotOrientation.VERTICAL, false, true, true);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(209, 193, 190));
        plot.getRenderer().setSeriesPaint(0, new Color(255, 34, 0));
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        BarRenderer br = (BarRenderer) categoryPlot.getRenderer();
        br.setMaximumBarWidth(.03); 
        ChartPanel panel = new ChartPanel(chart);
        MainPanel.add(panel);
        
         
         panel.setSize(800,185); 
         panel.setLocation(50, 5);
        
        }
        catch(Exception except){
        
        except.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.ACB1C5D3-1FA7-DF21-7EB4-22105627913A]
    // </editor-fold> 
    public String getGrades () {
        return grades;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7EA9B025-8FA3-8F2B-3B34-9B60F196248C]
    // </editor-fold> 
    public void setGrades (String val) {
        this.grades = val;
    }

}

