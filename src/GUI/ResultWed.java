/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author asksoft
 */
import api.httpAPI;
import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * SwingFXWebView
 */
public class ResultWed extends JPanel {

    private Stage stage;
    private WebView browser;
    private JFXPanel jfxPanel;
    private JButton swingButton;
    private JButton closeButton;
    private WebEngine webEngine;
    private final static JFrame frame = new JFrame();

    public ResultWed() {
        initComponents();
    }

    public static void main(String... args) {
        // Run this later:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //final JFrame frame = new JFrame();

                frame.getContentPane().add(new ResultWed());

                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setMinimumSize(new Dimension(800, 580));
                frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

                frame.setUndecorated(true);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public void showResult() {
        try {
            frame.getContentPane().add(new ResultWed());
            //frame.pack();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setMinimumSize(new Dimension(800, 580));
            frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

            frame.setUndecorated(true);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception ex) {
            System.out.println("Error on Reuslt Web Fram " + ex.getMessage());
            frame.setVisible(true);
        }
    }

    private void initComponents() {

        jfxPanel = new JFXPanel();
        createScene();

        setLayout(new BorderLayout());
        add(jfxPanel, BorderLayout.CENTER);

        swingButton = new JButton();
        swingButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        webEngine.reload();
                    }
                });
            }
        });
        swingButton.setText("Reload");

        add(swingButton, BorderLayout.NORTH);
        
        closeButton = new JButton();
        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
//                
            }
        });
        closeButton.setText("Close");
        add(closeButton, BorderLayout.SOUTH);
    }

    /**
     * createScene
     *
     * Note: Key is that Scene needs to be created and run on "FX user thread"
     * NOT on the AWT-EventQueue Thread
     *
     */
    private void createScene() {
        PlatformImpl.startup(new Runnable() {
            @Override
            public void run() {

                stage = new Stage();

                stage.setTitle("Hello Java FX");
                stage.setResizable(true);

                Group root = new Group();
                Scene scene = new Scene(root, 90, 20);
                stage.setScene(scene);

                // Set up the embedded browser:
                browser = new WebView();
                webEngine = browser.getEngine();
                webEngine.setJavaScriptEnabled(true);

                // Object response = webEngine.executeScript(value);
                String userid = Dashboard.userid.getText();
                String series = Dashboard.seriesLable.getText();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                //System.out.println(dtf.format(now));
                String gdate = dtf.format(now);
                String url = httpAPI.api_url + "?r=result&userid=" + userid + "&series=" + series + "&gdate=" + gdate;
                webEngine.load(url);

                ObservableList<Node> children = root.getChildren();
                children.add(browser);

                jfxPanel.setScene(scene);
            }
        });
    }
}
