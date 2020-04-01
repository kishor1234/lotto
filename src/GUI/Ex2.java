package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
 
 
public class Ex2  {
   
           
 
 
    public static void main(String[] args)  {
 
            JFrame jf = new JFrame();
            jf.setVisible(true);
            jf.setSize(400, 400);
            jf.setLocationRelativeTo(null);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
            JPanel jp = new JPanel();
            jf.add(jp);
            jp.setSize(400, 400);
            jp.setVisible(true);
             
             final DateFormat df = new SimpleDateFormat("HH:mm:ss");
            final Calendar cal = Calendar.getInstance();
            System.out.println(df.format(cal.getTime()));
         String ti = df.format(cal.getTime());
         
            final JLabel jl = new JLabel(ti, SwingConstants.CENTER);
            jp.add(jl);
            jl.setVisible(true);
            jl.setSize(400, 200);
            Font labelFont = jl.getFont();
            jl.setFont(new Font(labelFont.getName(), Font.PLAIN, 40));
          
            TimerTask tt = new TimerTask() {
 
                @Override
                public void run() {
                    String string = df.format(cal.getTime());
                   jl.setText(string);
                }
            };
             
            Timer timer = new Timer();
             
            timer.scheduleAtFixedRate(tt, 0, 100);
    }
     
}