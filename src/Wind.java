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
// #[regen=yes,id=DCE.FDC2EE76-414E-413B-CBAD-3830B7CC2D39]
// </editor-fold> 
public class Wind implements Observer {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.560C2181-6E32-8FFF-6118-FB12733D40B1]
    // </editor-fold> 
    private String speed;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4F719B26-7145-DCD1-3F7C-F4C2BE1EB88F]
    // </editor-fold> 
    private String direction;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.06D26335-2C4C-8A1D-1230-2B542C554D3A]
    // </editor-fold> 
    public Wind () {
    }

     @Override
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.62F0FD8B-B755-C8CE-BF33-37D148C196DB]
    // </editor-fold> 
    public void Update(JPanel MainPanel){
        try {
        String query = "SELECT name, wind FROM forecast";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(Mysql.getConnection(), query);
        JFreeChart chart = ChartFactory.createBarChart3D("Wind Chart", "District", "Wind in km/h", dataset, PlotOrientation.VERTICAL, false, true, true);
       
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(209, 193, 190));
        plot.getRenderer().setSeriesPaint(0, new Color(150, 250, 212));
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        BarRenderer br = (BarRenderer) categoryPlot.getRenderer();
        br.setMaximumBarWidth(.03); 
        ChartPanel panel = new ChartPanel(chart);
        MainPanel.add(panel);
        
         
         panel.setSize(800, 185); 
         panel.setLocation(50, 200);
        
        }
        catch(Exception except){
        
        except.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CE067942-E0BF-8AAE-F491-B5E6CDDE897E]
    // </editor-fold> 
    public String getDirection () {
        return direction;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F43B664E-B9D1-54FC-F5CD-6949FDEC8310]
    // </editor-fold> 
    public void setDirection (String val) {
        this.direction = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.84E6A540-0EF9-FA2A-5EA0-84A262F0752C]
    // </editor-fold> 
    public String getSpeed () {
        return speed;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.533415F0-5D8A-2434-BC29-ADE9109F74B6]
    // </editor-fold> 
    public void setSpeed (String val) {
        this.speed = val;
    }

}

