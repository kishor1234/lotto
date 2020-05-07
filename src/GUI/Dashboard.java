/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import api.httpAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import invoice.claimJSON;
import invoice.invoiceJSON;
import invoice.singleResult;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.json.JSONException;
import org.json.JSONObject;
import table.tickets;

/**
 *
 * @author asksoft
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public SeriesClass sc = new SeriesClass();
    private static final Map<String, JButton> buttonMap = new HashMap<>();
    private Map<String, JTextField> jField = new HashMap<>();
    private Map<String, JTextField> horizontalTextField = new HashMap<>();
    private Map<String, JTextField> varticalTextField = new HashMap<>();

    public String NSystem;
    public static String SelectedSingleSeries;
    public static int LEFT_TO_RIGHT = 1;
    public static int RIGHT_TO_LEFT = 2;
    String text;
    int Option;
    int Speed;
    public static Map<String, Map> series = new HashMap<>();
    public static ArrayList<String> multiSeries;//multi series option
    public static ArrayList<Map> advanceDrawArray;//multi series option
    public static Map<String, Map> advanceDraw = new HashMap<>();//multi series option
    static int interval;
    static Timer timer;
    public static Map<String, Integer> final_Map;
    public static Map<String, JTextField> totalField = new HashMap<>();

    public Dashboard(String data) {
        try {
            initComponents();
            advanceDrawArray = new ArrayList<>();
            NSystems.setVisible(false);
            subSeriesNo.setVisible(false);
            alls.setVisible(false);
            CMulti.setVisible(false);
            advance.setVisible(false);
            start.setVisible(false);
            end.setVisible(false);
            //id.setVisible(false);
            this.mapButton();
            this.mapJTextField();
            Dashboard.runNSOutput();
            this.setLocationRelativeTo(null);
            this.setMessageBar();
            mapVarticalTextField();
            mapHorizontalTextField();
            JSONObject myResponse = new JSONObject(data);
            //System.out.println(myResponse.getString("id"));
            userid.setText(myResponse.getString("userid"));
            id.setText(myResponse.getString("id"));
            uid.setText(myResponse.getString("name") + " " + myResponse.getString("userid"));

//            for (int i = 0; i < 100; i++) {
//                JTextField jf = jField.get("E_" + i);
//                jf.setText("");
//
//            }
            for (int i = 0; i < 100; i++) {
                JTextField jf = jField.get("E_" + i);
                int p = i;

                jf.addKeyListener(new java.awt.event.KeyAdapter() {

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        //Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        inputSystem(p, jf);

                    }
                });
                jf.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lMouseClicked(evt);
                    }

                    private void lMouseClicked(MouseEvent evt) {
                        try {
                            if (!"".equals(jf.getText())) {
                                //int temp = Integer.parseInt(jf.getText());
                                jf.setText("");
                            }
                        } catch (Exception ed) {
                            System.out.println(ed.getMessage());
                        }
                    }
                });

                jf.addFocusListener(new java.awt.event.FocusAdapter() {
                    String focusData = jf.getText();

                    @Override
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        try {
                            //System.out.println(" Old : " + focusData);
                            jf.setText("");
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }

                    @Override
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        try {
                            //System.out.println(" Oldw : " + focusData);
                            if (jf.getText().equals("")) {
                                jf.setText(focusData);
                            }
                        } catch (Exception ep) {
                            System.out.println(ep.getMessage());
                        }
                    }
                });
            }
            Dashboard.selectDefaultSeries(0);
            selectSubSeries(B0);
            setDefaultColorOfInputPoitBox();
            showTimer();
            inisetClockCounter();
            setTotalField();
            updateBalance();
            resultBoard("ALL");
            setLabelColor();
            loadPrinter();
            lastTransaction();
        } catch (JSONException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        uid = new javax.swing.JLabel();
        singout = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        seriesLable = new javax.swing.JLabel();
        complaint = new javax.swing.JLabel();
        B0 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        E_0 = new javax.swing.JTextField();
        E_1 = new javax.swing.JTextField();
        E_2 = new javax.swing.JTextField();
        E_3 = new javax.swing.JTextField();
        E_4 = new javax.swing.JTextField();
        E_5 = new javax.swing.JTextField();
        E_6 = new javax.swing.JTextField();
        E_7 = new javax.swing.JTextField();
        E_8 = new javax.swing.JTextField();
        E_9 = new javax.swing.JTextField();
        I_0 = new javax.swing.JTextField();
        B1 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        E_10 = new javax.swing.JTextField();
        E_11 = new javax.swing.JTextField();
        E_12 = new javax.swing.JTextField();
        E_13 = new javax.swing.JTextField();
        E_14 = new javax.swing.JTextField();
        E_15 = new javax.swing.JTextField();
        E_16 = new javax.swing.JTextField();
        E_17 = new javax.swing.JTextField();
        E_18 = new javax.swing.JTextField();
        E_19 = new javax.swing.JTextField();
        I_10 = new javax.swing.JTextField();
        E_26 = new javax.swing.JTextField();
        E_20 = new javax.swing.JTextField();
        B2 = new javax.swing.JButton();
        E_27 = new javax.swing.JTextField();
        E_22 = new javax.swing.JTextField();
        E_28 = new javax.swing.JTextField();
        E_21 = new javax.swing.JTextField();
        E_29 = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        E_23 = new javax.swing.JTextField();
        E_25 = new javax.swing.JTextField();
        I_20 = new javax.swing.JTextField();
        E_24 = new javax.swing.JTextField();
        jCheckBox4 = new javax.swing.JCheckBox();
        B3 = new javax.swing.JButton();
        E_32 = new javax.swing.JTextField();
        E_33 = new javax.swing.JTextField();
        E_30 = new javax.swing.JTextField();
        E_36 = new javax.swing.JTextField();
        E_37 = new javax.swing.JTextField();
        I_30 = new javax.swing.JTextField();
        E_39 = new javax.swing.JTextField();
        E_34 = new javax.swing.JTextField();
        E_38 = new javax.swing.JTextField();
        E_35 = new javax.swing.JTextField();
        E_31 = new javax.swing.JTextField();
        B4 = new javax.swing.JButton();
        jCheckBox5 = new javax.swing.JCheckBox();
        E_40 = new javax.swing.JTextField();
        E_41 = new javax.swing.JTextField();
        E_42 = new javax.swing.JTextField();
        E_43 = new javax.swing.JTextField();
        E_44 = new javax.swing.JTextField();
        E_45 = new javax.swing.JTextField();
        E_46 = new javax.swing.JTextField();
        E_47 = new javax.swing.JTextField();
        E_48 = new javax.swing.JTextField();
        E_49 = new javax.swing.JTextField();
        I_40 = new javax.swing.JTextField();
        B5 = new javax.swing.JButton();
        E_50 = new javax.swing.JTextField();
        jCheckBox6 = new javax.swing.JCheckBox();
        E_56 = new javax.swing.JTextField();
        E_52 = new javax.swing.JTextField();
        E_53 = new javax.swing.JTextField();
        E_59 = new javax.swing.JTextField();
        I_50 = new javax.swing.JTextField();
        E_54 = new javax.swing.JTextField();
        E_57 = new javax.swing.JTextField();
        E_55 = new javax.swing.JTextField();
        E_51 = new javax.swing.JTextField();
        E_58 = new javax.swing.JTextField();
        E_63 = new javax.swing.JTextField();
        E_68 = new javax.swing.JTextField();
        E_60 = new javax.swing.JTextField();
        jCheckBox7 = new javax.swing.JCheckBox();
        E_62 = new javax.swing.JTextField();
        E_69 = new javax.swing.JTextField();
        E_61 = new javax.swing.JTextField();
        E_65 = new javax.swing.JTextField();
        E_64 = new javax.swing.JTextField();
        B6 = new javax.swing.JButton();
        E_67 = new javax.swing.JTextField();
        I_60 = new javax.swing.JTextField();
        E_66 = new javax.swing.JTextField();
        E_73 = new javax.swing.JTextField();
        E_75 = new javax.swing.JTextField();
        E_70 = new javax.swing.JTextField();
        jCheckBox8 = new javax.swing.JCheckBox();
        B7 = new javax.swing.JButton();
        E_77 = new javax.swing.JTextField();
        E_72 = new javax.swing.JTextField();
        E_71 = new javax.swing.JTextField();
        E_74 = new javax.swing.JTextField();
        I_70 = new javax.swing.JTextField();
        E_78 = new javax.swing.JTextField();
        E_79 = new javax.swing.JTextField();
        E_76 = new javax.swing.JTextField();
        B8 = new javax.swing.JButton();
        E_85 = new javax.swing.JTextField();
        E_89 = new javax.swing.JTextField();
        E_87 = new javax.swing.JTextField();
        jCheckBox9 = new javax.swing.JCheckBox();
        E_86 = new javax.swing.JTextField();
        E_81 = new javax.swing.JTextField();
        E_80 = new javax.swing.JTextField();
        E_83 = new javax.swing.JTextField();
        E_88 = new javax.swing.JTextField();
        E_82 = new javax.swing.JTextField();
        E_84 = new javax.swing.JTextField();
        I_80 = new javax.swing.JTextField();
        E_99 = new javax.swing.JTextField();
        E_93 = new javax.swing.JTextField();
        E_91 = new javax.swing.JTextField();
        E_96 = new javax.swing.JTextField();
        E_98 = new javax.swing.JTextField();
        E_97 = new javax.swing.JTextField();
        jCheckBox10 = new javax.swing.JCheckBox();
        E_94 = new javax.swing.JTextField();
        E_92 = new javax.swing.JTextField();
        E_95 = new javax.swing.JTextField();
        E_90 = new javax.swing.JTextField();
        B9 = new javax.swing.JButton();
        I_90 = new javax.swing.JTextField();
        BALL = new javax.swing.JButton();
        B_0 = new javax.swing.JTextField();
        B_1 = new javax.swing.JTextField();
        B_2 = new javax.swing.JTextField();
        B_3 = new javax.swing.JTextField();
        B_4 = new javax.swing.JTextField();
        B_5 = new javax.swing.JTextField();
        B_6 = new javax.swing.JTextField();
        B_7 = new javax.swing.JTextField();
        B_8 = new javax.swing.JTextField();
        B_9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Q1000_1900 = new javax.swing.JTextField();
        A1000_1900 = new javax.swing.JTextField();
        Q2000_2900 = new javax.swing.JTextField();
        A2000_2900 = new javax.swing.JTextField();
        Q3000_3900 = new javax.swing.JTextField();
        A3000_3900 = new javax.swing.JTextField();
        Q4000_4900 = new javax.swing.JTextField();
        A4000_4900 = new javax.swing.JTextField();
        Q5000_5900 = new javax.swing.JTextField();
        A5000_5900 = new javax.swing.JTextField();
        Q6000_6900 = new javax.swing.JTextField();
        A6000_6900 = new javax.swing.JTextField();
        Q7000_7900 = new javax.swing.JTextField();
        A7000_7900 = new javax.swing.JTextField();
        Q8000_8900 = new javax.swing.JTextField();
        A8000_8900 = new javax.swing.JTextField();
        Q9000_9900 = new javax.swing.JTextField();
        A9000_9900 = new javax.swing.JTextField();
        Q10000_10900 = new javax.swing.JTextField();
        A10000_10900 = new javax.swing.JTextField();
        totalqty = new javax.swing.JTextField();
        totalamt = new javax.swing.JTextField();
        buy = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fixed = new javax.swing.JCheckBox();
        odd = new javax.swing.JCheckBox();
        even = new javax.swing.JCheckBox();
        cross = new javax.swing.JCheckBox();
        NSystems = new javax.swing.JTextField();
        subSeriesNo = new javax.swing.JTextField();
        CMulti = new javax.swing.JTextField();
        alls = new javax.swing.JTextField();
        start = new javax.swing.JTextField();
        end = new javax.swing.JTextField();
        advance = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        drawClock = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dTime = new javax.swing.JLabel();
        cDate = new javax.swing.JLabel();
        account = new javax.swing.JLabel();
        operator = new javax.swing.JLabel();
        reprint = new javax.swing.JLabel();
        cancel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        last = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lastamt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        printerPanel = new javax.swing.JPanel();
        printer = new javax.swing.JLabel();
        rBox = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        claimReader = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        bSeries = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        resultPane = new javax.swing.JPanel();
        result = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        clockLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel22.setText("jLabel22");

        jLabel24.setText("jLabel24");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 61, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel2KeyReleased(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uid.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        uid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uid.setText("D6 9523");
        uid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 168, 28));

        singout.setBackground(new java.awt.Color(141, 235, 237));
        singout.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        singout.setForeground(new java.awt.Color(1, 1, 1));
        singout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        singout.setText("Sign Off ");
        singout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        singout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                singoutMouseClicked(evt);
            }
        });
        jPanel2.add(singout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 100, 26));

        password.setBackground(new java.awt.Color(141, 235, 237));
        password.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(1, 1, 1));
        password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        password.setText("Password");
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 100, 26));

        seriesLable.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        seriesLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seriesLable.setText("1000-1900");
        seriesLable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seriesLable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seriesLableMouseClicked(evt);
            }
        });
        jPanel2.add(seriesLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 168, 26));

        complaint.setBackground(new java.awt.Color(141, 235, 237));
        complaint.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        complaint.setForeground(new java.awt.Color(1, 1, 1));
        complaint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        complaint.setText("Complaint");
        complaint.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(complaint, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 100, 26));

        B0.setBackground(new java.awt.Color(255, 255, 255));
        B0.setText("1000-2000");
        B0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B0ActionPerformed(evt);
            }
        });
        jPanel2.add(B0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 30));

        jCheckBox1.setBackground(new java.awt.Color(212, 133, 194));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("2 * 01=0180");
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 129, 30));

        E_0.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        E_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_0.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 60, 30));

        E_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_1.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 60, 30));

        E_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_2.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 60, 30));

        E_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_3.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 60, 30));

        E_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_4.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 60, 30));

        E_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_5.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 60, 30));

        E_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_6.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 60, 30));

        E_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_7.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 60, 30));

        E_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_8.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 60, 30));

        E_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_9.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 60, 30));

        I_0.setBackground(new java.awt.Color(113, 232, 244));
        I_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_0.setMinimumSize(new java.awt.Dimension(10, 32));
        I_0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_0KeyReleased(evt);
            }
        });
        jPanel2.add(I_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 60, 30));

        B1.setBackground(new java.awt.Color(255, 255, 255));
        B1.setText("1000-2000");
        B1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        jPanel2.add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 30));

        jCheckBox2.setBackground(new java.awt.Color(130, 180, 126));
        jCheckBox2.setText("2 * 01=0180");
        jPanel2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 129, 30));

        E_10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_10.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 60, 30));

        E_11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_11.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 60, 30));

        E_12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_12.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 60, 30));

        E_13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_13.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 60, 30));

        E_14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_14.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 60, 30));

        E_15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_15.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 60, 30));

        E_16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_16.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 60, 30));

        E_17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_17.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 60, 30));

        E_18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_18.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 60, 30));

        E_19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_19.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 60, 30));

        I_10.setBackground(new java.awt.Color(113, 232, 244));
        I_10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_10.setMinimumSize(new java.awt.Dimension(10, 32));
        I_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_10KeyReleased(evt);
            }
        });
        jPanel2.add(I_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, 60, 30));

        E_26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_26.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 60, 30));

        E_20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_20.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 60, 30));

        B2.setBackground(new java.awt.Color(255, 255, 255));
        B2.setText("1000-2000");
        B2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        jPanel2.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, 30));

        E_27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_27.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 60, 30));

        E_22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_22.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 60, 30));

        E_28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_28.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 60, 30));

        E_21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_21.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 60, 30));

        E_29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_29.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 60, 30));

        jCheckBox3.setBackground(new java.awt.Color(122, 180, 232));
        jCheckBox3.setText("2 * 02=0360");
        jPanel2.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 129, 30));

        E_23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_23.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 60, 30));

        E_25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_25.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 60, 30));

        I_20.setBackground(new java.awt.Color(113, 232, 244));
        I_20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_20.setMinimumSize(new java.awt.Dimension(10, 32));
        I_20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_20KeyReleased(evt);
            }
        });
        jPanel2.add(I_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 60, 30));

        E_24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_24.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 60, 30));

        jCheckBox4.setBackground(new java.awt.Color(91, 163, 106));
        jCheckBox4.setText("2 * 03=0540");
        jPanel2.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 129, 30));

        B3.setBackground(new java.awt.Color(255, 255, 255));
        B3.setText("1000-2000");
        B3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });
        jPanel2.add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 30));

        E_32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_32.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_32, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 60, 30));

        E_33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_33.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_33, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 60, 30));

        E_30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_30.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 60, 30));

        E_36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_36.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_36, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 60, 30));

        E_37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_37.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_37, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 60, 30));

        I_30.setBackground(new java.awt.Color(113, 232, 244));
        I_30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_30.setMinimumSize(new java.awt.Dimension(10, 32));
        I_30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_30KeyReleased(evt);
            }
        });
        jPanel2.add(I_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 60, 30));

        E_39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_39.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_39, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 60, 30));

        E_34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_34.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_34, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 60, 30));

        E_38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_38.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_38, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 60, 30));

        E_35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_35.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_35, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 60, 30));

        E_31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_31.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_31, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 60, 30));

        B4.setBackground(new java.awt.Color(255, 255, 255));
        B4.setText("1000-2000");
        B4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });
        jPanel2.add(B4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 120, 30));

        jCheckBox5.setBackground(new java.awt.Color(217, 141, 129));
        jCheckBox5.setText("2 * 05=0900");
        jPanel2.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 129, 30));

        E_40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_40.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_40, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 60, 30));

        E_41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_41.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_41, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 60, 30));

        E_42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_42.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_42, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 60, 30));

        E_43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_43.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_43, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 60, 30));

        E_44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_44.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_44, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 60, 30));

        E_45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_45.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_45, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 60, 30));

        E_46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_46.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_46, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 60, 30));

        E_47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_47.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_47, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 60, 30));

        E_48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_48.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_48, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 60, 30));

        E_49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_49.setMinimumSize(new java.awt.Dimension(10, 32));
        E_49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E_49ActionPerformed(evt);
            }
        });
        jPanel2.add(E_49, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 60, 30));

        I_40.setBackground(new java.awt.Color(113, 232, 244));
        I_40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_40.setMinimumSize(new java.awt.Dimension(10, 32));
        I_40.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_40KeyReleased(evt);
            }
        });
        jPanel2.add(I_40, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 60, 30));

        B5.setBackground(new java.awt.Color(255, 255, 255));
        B5.setText("1000-2000");
        B5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });
        jPanel2.add(B5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 120, 30));

        E_50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_50.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_50, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 60, 30));

        jCheckBox6.setBackground(new java.awt.Color(185, 177, 230));
        jCheckBox6.setText("2 * 05=0900");
        jPanel2.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 129, 30));

        E_56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_56.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_56, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 60, 30));

        E_52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_52.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_52, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 60, 30));

        E_53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_53.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_53, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 60, 30));

        E_59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_59.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_59, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 60, 30));

        I_50.setBackground(new java.awt.Color(113, 232, 244));
        I_50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_50.setMinimumSize(new java.awt.Dimension(10, 32));
        I_50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_50KeyReleased(evt);
            }
        });
        jPanel2.add(I_50, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 60, 30));

        E_54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_54.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_54, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 60, 30));

        E_57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_57.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_57, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 60, 30));

        E_55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_55.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_55, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 60, 30));

        E_51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_51.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_51, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 60, 30));

        E_58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_58.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_58, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 60, 30));

        E_63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_63.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_63, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 60, 30));

        E_68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_68.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_68, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 60, 30));

        E_60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_60.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_60, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 60, 30));

        jCheckBox7.setBackground(new java.awt.Color(234, 158, 123));
        jCheckBox7.setText("2 * 10=1800");
        jPanel2.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 129, 30));

        E_62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_62.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_62, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 60, 30));

        E_69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_69.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_69, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 60, 30));

        E_61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_61.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_61, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 60, 30));

        E_65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_65.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_65, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 60, 30));

        E_64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_64.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_64, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 60, 30));

        B6.setBackground(new java.awt.Color(255, 255, 255));
        B6.setText("1000-2000");
        B6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });
        jPanel2.add(B6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 120, 30));

        E_67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_67.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_67, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 60, 30));

        I_60.setBackground(new java.awt.Color(113, 232, 244));
        I_60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_60.setMinimumSize(new java.awt.Dimension(10, 32));
        I_60.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_60KeyReleased(evt);
            }
        });
        jPanel2.add(I_60, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 310, 60, 30));

        E_66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_66.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_66, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 60, 30));

        E_73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_73.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_73, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 60, 30));

        E_75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_75.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_75, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 60, 30));

        E_70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_70.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_70, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 60, 30));

        jCheckBox8.setBackground(new java.awt.Color(164, 204, 90));
        jCheckBox8.setText("2 * 20=3600");
        jPanel2.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 129, 30));

        B7.setBackground(new java.awt.Color(255, 255, 255));
        B7.setText("1000-2000");
        B7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });
        jPanel2.add(B7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 120, 30));

        E_77.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_77.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_77, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 60, 30));

        E_72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_72.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_72, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 60, 30));

        E_71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_71.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_71, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 60, 30));

        E_74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_74.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_74, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 60, 30));

        I_70.setBackground(new java.awt.Color(113, 232, 244));
        I_70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_70.setMinimumSize(new java.awt.Dimension(10, 32));
        I_70.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_70KeyReleased(evt);
            }
        });
        jPanel2.add(I_70, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 60, 30));

        E_78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_78.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_78, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, 60, 30));

        E_79.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_79.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_79, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 60, 30));

        E_76.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_76.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_76, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 60, 30));

        B8.setBackground(new java.awt.Color(255, 255, 255));
        B8.setText("1000-2000");
        B8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });
        jPanel2.add(B8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 120, 30));

        E_85.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_85.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_85, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 60, 30));

        E_89.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_89.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_89, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 370, 60, 30));

        E_87.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_87.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_87, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 60, 30));

        jCheckBox9.setBackground(new java.awt.Color(201, 189, 175));
        jCheckBox9.setText("2 * 25=4500");
        jPanel2.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 129, 30));

        E_86.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_86.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_86, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 60, 30));

        E_81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_81.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_81, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 60, 30));

        E_80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_80.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_80, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 60, 30));

        E_83.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_83.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_83, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 60, 30));

        E_88.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_88.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_88, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 60, 30));

        E_82.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_82.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_82, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 60, 30));

        E_84.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_84.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_84, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 60, 30));

        I_80.setBackground(new java.awt.Color(113, 232, 244));
        I_80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_80.setMinimumSize(new java.awt.Dimension(10, 32));
        I_80.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_80KeyReleased(evt);
            }
        });
        jPanel2.add(I_80, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 60, 30));

        E_99.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_99.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_99, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, 60, 30));

        E_93.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_93.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_93, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 60, 30));

        E_91.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_91.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_91, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 60, 30));

        E_96.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_96.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_96, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 60, 30));

        E_98.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_98.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_98, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 60, 30));

        E_97.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_97.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_97, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 60, 30));

        jCheckBox10.setBackground(new java.awt.Color(23, 188, 189));
        jCheckBox10.setText("2 * 25=4500");
        jPanel2.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 129, 30));

        E_94.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_94.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_94, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 60, 30));

        E_92.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_92.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_92, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 60, 30));

        E_95.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_95.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_95, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 60, 30));

        E_90.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E_90.setMinimumSize(new java.awt.Dimension(10, 32));
        jPanel2.add(E_90, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 60, 30));

        B9.setBackground(new java.awt.Color(255, 255, 255));
        B9.setText("1000-2000");
        B9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });
        jPanel2.add(B9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 120, 30));

        I_90.setBackground(new java.awt.Color(113, 232, 244));
        I_90.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I_90.setMinimumSize(new java.awt.Dimension(10, 32));
        I_90.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I_90KeyReleased(evt);
            }
        });
        jPanel2.add(I_90, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 60, 30));

        BALL.setBackground(new java.awt.Color(255, 255, 255));
        BALL.setText("All Series");
        BALL.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BALL.setBorderPainted(false);
        BALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BALLActionPerformed(evt);
            }
        });
        jPanel2.add(BALL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 120, 30));

        B_0.setBackground(new java.awt.Color(113, 232, 244));
        B_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_0.setMinimumSize(new java.awt.Dimension(10, 32));
        B_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_0ActionPerformed(evt);
            }
        });
        B_0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_0KeyReleased(evt);
            }
        });
        jPanel2.add(B_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 60, 30));

        B_1.setBackground(new java.awt.Color(113, 232, 244));
        B_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_1.setMinimumSize(new java.awt.Dimension(10, 32));
        B_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_1KeyReleased(evt);
            }
        });
        jPanel2.add(B_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 60, 30));

        B_2.setBackground(new java.awt.Color(113, 232, 244));
        B_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_2.setMinimumSize(new java.awt.Dimension(10, 32));
        B_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_2KeyReleased(evt);
            }
        });
        jPanel2.add(B_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 60, 30));

        B_3.setBackground(new java.awt.Color(113, 232, 244));
        B_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_3.setMinimumSize(new java.awt.Dimension(10, 32));
        B_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_3KeyReleased(evt);
            }
        });
        jPanel2.add(B_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 60, 30));

        B_4.setBackground(new java.awt.Color(113, 232, 244));
        B_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_4.setMinimumSize(new java.awt.Dimension(10, 32));
        B_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_4KeyReleased(evt);
            }
        });
        jPanel2.add(B_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 60, 30));

        B_5.setBackground(new java.awt.Color(113, 232, 244));
        B_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_5.setMinimumSize(new java.awt.Dimension(10, 32));
        B_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_5KeyReleased(evt);
            }
        });
        jPanel2.add(B_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 60, 30));

        B_6.setBackground(new java.awt.Color(113, 232, 244));
        B_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_6.setMinimumSize(new java.awt.Dimension(10, 32));
        B_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_6KeyReleased(evt);
            }
        });
        jPanel2.add(B_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 60, 30));

        B_7.setBackground(new java.awt.Color(113, 232, 244));
        B_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_7.setMinimumSize(new java.awt.Dimension(10, 32));
        B_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_7KeyReleased(evt);
            }
        });
        jPanel2.add(B_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 60, 30));

        B_8.setBackground(new java.awt.Color(113, 232, 244));
        B_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_8.setMinimumSize(new java.awt.Dimension(10, 32));
        B_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_8KeyReleased(evt);
            }
        });
        jPanel2.add(B_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 60, 30));

        B_9.setBackground(new java.awt.Color(113, 232, 244));
        B_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B_9.setMinimumSize(new java.awt.Dimension(10, 32));
        B_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_9ActionPerformed(evt);
            }
        });
        B_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_9KeyReleased(evt);
            }
        });
        jPanel2.add(B_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, 60, 30));

        jLabel16.setBackground(new java.awt.Color(100, 63, 250));
        jLabel16.setFont(new java.awt.Font("Manjari Bold", 1, 8)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(35, 16, 16));
        jLabel16.setText("LUCKY NUMBERS");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 130, 30));

        Q1000_1900.setEditable(false);
        Q1000_1900.setBackground(new java.awt.Color(76, 240, 155));
        Q1000_1900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q1000_1900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q1000_1900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, 120, 30));

        A1000_1900.setEditable(false);
        A1000_1900.setBackground(new java.awt.Color(244, 254, 164));
        A1000_1900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A1000_1900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A1000_1900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 130, 120, 30));

        Q2000_2900.setEditable(false);
        Q2000_2900.setBackground(new java.awt.Color(76, 240, 155));
        Q2000_2900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q2000_2900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q2000_2900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, 120, 30));

        A2000_2900.setEditable(false);
        A2000_2900.setBackground(new java.awt.Color(244, 254, 164));
        A2000_2900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A2000_2900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A2000_2900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 160, 120, 30));

        Q3000_3900.setEditable(false);
        Q3000_3900.setBackground(new java.awt.Color(76, 240, 155));
        Q3000_3900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q3000_3900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q3000_3900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 120, 30));

        A3000_3900.setEditable(false);
        A3000_3900.setBackground(new java.awt.Color(244, 254, 164));
        A3000_3900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A3000_3900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A3000_3900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 190, 120, 30));

        Q4000_4900.setEditable(false);
        Q4000_4900.setBackground(new java.awt.Color(76, 240, 155));
        Q4000_4900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q4000_4900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q4000_4900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, 120, 30));

        A4000_4900.setEditable(false);
        A4000_4900.setBackground(new java.awt.Color(244, 254, 164));
        A4000_4900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A4000_4900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A4000_4900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 220, 120, 30));

        Q5000_5900.setEditable(false);
        Q5000_5900.setBackground(new java.awt.Color(76, 240, 155));
        Q5000_5900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q5000_5900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q5000_5900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, 120, 30));

        A5000_5900.setEditable(false);
        A5000_5900.setBackground(new java.awt.Color(244, 254, 164));
        A5000_5900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A5000_5900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A5000_5900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 120, 30));

        Q6000_6900.setEditable(false);
        Q6000_6900.setBackground(new java.awt.Color(76, 240, 155));
        Q6000_6900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q6000_6900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q6000_6900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, 120, 30));

        A6000_6900.setEditable(false);
        A6000_6900.setBackground(new java.awt.Color(244, 254, 164));
        A6000_6900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A6000_6900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A6000_6900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 280, 120, 30));

        Q7000_7900.setEditable(false);
        Q7000_7900.setBackground(new java.awt.Color(76, 240, 155));
        Q7000_7900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q7000_7900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q7000_7900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 120, 30));

        A7000_7900.setEditable(false);
        A7000_7900.setBackground(new java.awt.Color(244, 254, 164));
        A7000_7900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A7000_7900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A7000_7900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, 120, 30));

        Q8000_8900.setEditable(false);
        Q8000_8900.setBackground(new java.awt.Color(76, 240, 155));
        Q8000_8900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q8000_8900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q8000_8900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 340, 120, 30));

        A8000_8900.setEditable(false);
        A8000_8900.setBackground(new java.awt.Color(244, 254, 164));
        A8000_8900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A8000_8900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A8000_8900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 340, 120, 30));

        Q9000_9900.setEditable(false);
        Q9000_9900.setBackground(new java.awt.Color(76, 240, 155));
        Q9000_9900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q9000_9900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q9000_9900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, 120, 30));

        A9000_9900.setEditable(false);
        A9000_9900.setBackground(new java.awt.Color(244, 254, 164));
        A9000_9900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A9000_9900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A9000_9900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 370, 120, 30));

        Q10000_10900.setEditable(false);
        Q10000_10900.setBackground(new java.awt.Color(76, 240, 155));
        Q10000_10900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        Q10000_10900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(Q10000_10900, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, 120, 30));

        A10000_10900.setEditable(false);
        A10000_10900.setBackground(new java.awt.Color(244, 254, 164));
        A10000_10900.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        A10000_10900.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(A10000_10900, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 400, 120, 30));

        totalqty.setEditable(false);
        totalqty.setBackground(new java.awt.Color(76, 240, 155));
        totalqty.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        totalqty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(totalqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 120, 30));

        totalamt.setEditable(false);
        totalamt.setBackground(new java.awt.Color(244, 254, 164));
        totalamt.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        totalamt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(totalamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, 120, 30));

        buy.setBackground(new java.awt.Color(255, 0, 18));
        buy.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        buy.setForeground(new java.awt.Color(254, 242, 242));
        buy.setText("Buy [F6]");
        buy.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });
        buy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buyKeyPressed(evt);
            }
        });
        jPanel2.add(buy, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 460, 240, 30));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel7.setText("QTY");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, -1, -1));

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel17.setText("AMT ₹ ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, -1, -1));

        fixed.setBackground(new java.awt.Color(255, 255, 255));
        fixed.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        fixed.setText("Fixed Play");
        fixed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixedActionPerformed(evt);
            }
        });
        jPanel2.add(fixed, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, -1, -1));

        multi.setBackground(new java.awt.Color(255, 255, 255));
        multi.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        multi.setText("Multi");
        multi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiActionPerformed(evt);
            }
        });
        jPanel2.add(multi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        odd.setBackground(new java.awt.Color(255, 255, 255));
        odd.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        odd.setText("ODD");
        odd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                oddItemStateChanged(evt);
            }
        });
        odd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oddActionPerformed(evt);
            }
        });
        jPanel2.add(odd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        even.setBackground(new java.awt.Color(255, 255, 255));
        even.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        even.setText("EVEN");
        even.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                evenItemStateChanged(evt);
            }
        });
        even.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evenActionPerformed(evt);
            }
        });
        jPanel2.add(even, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        cross.setBackground(new java.awt.Color(255, 255, 255));
        cross.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        cross.setText("Cross Play");
        cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossMouseClicked(evt);
            }
        });
        cross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crossActionPerformed(evt);
            }
        });
        jPanel2.add(cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, -1));

        NSystems.setEditable(false);
        NSystems.setEnabled(false);
        jPanel2.add(NSystems, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 50, -1));

        subSeriesNo.setText("series");
        jPanel2.add(subSeriesNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        CMulti.setText("m");
        jPanel2.add(CMulti, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        alls.setText("alls");
        jPanel2.add(alls, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        start.setText("jTextField1");
        jPanel2.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        end.setText("jTextField2");
        jPanel2.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        advance.setText("false");
        jPanel2.add(advance, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jPanel3.setBackground(new java.awt.Color(250, 244, 154));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(216, 43, 43));
        jLabel4.setText("Dr. Date");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        drawClock.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        drawClock.setForeground(new java.awt.Color(255, 0, 0));
        drawClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        drawClock.setText("00:02:33");
        drawClock.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(drawClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, -1));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(216, 43, 43));
        jLabel5.setText("Time To Dr.");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 20));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(216, 43, 43));
        jLabel6.setText("Dr. Time");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, -1));

        dTime.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        dTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dTime.setText("03:20 PM");
        jPanel3.add(dTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 110, -1));

        cDate.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        cDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cDate.setText("05-01-2020");
        jPanel3.add(cDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 110, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 36, 440, 60));

        account.setBackground(new java.awt.Color(141, 235, 237));
        account.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        account.setForeground(new java.awt.Color(1, 1, 1));
        account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account.setText("Account");
        account.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(account, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 120, 26));

        operator.setBackground(new java.awt.Color(141, 235, 237));
        operator.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        operator.setForeground(new java.awt.Color(1, 1, 1));
        operator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        operator.setText("Operator");
        operator.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(operator, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 100, 26));

        reprint.setBackground(new java.awt.Color(141, 235, 237));
        reprint.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        reprint.setForeground(new java.awt.Color(1, 1, 1));
        reprint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reprint.setText("Reprint");
        reprint.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        reprint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reprintMouseClicked(evt);
            }
        });
        jPanel2.add(reprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 100, 26));

        cancel.setBackground(new java.awt.Color(141, 235, 237));
        cancel.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(1, 1, 1));
        cancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancel.setText("Cancel");
        cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 100, 26));

        jPanel4.setBackground(new java.awt.Color(250, 244, 154));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Limit Update");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 1, 0)));
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 26));

        balance.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balance.setText("*****");
        balance.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel4.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 30, 110, 26));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 36, -1, 60));

        jPanel5.setBackground(new java.awt.Color(250, 244, 154));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(216, 43, 43));
        jLabel23.setText("Last Tr. No");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        last.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        last.setForeground(new java.awt.Color(38, 58, 227));
        last.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        last.setText("ask5e8dc8429f16f");
        jPanel5.add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 36, 150, 60));

        jPanel6.setBackground(new java.awt.Color(250, 244, 154));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(216, 43, 43));
        jLabel25.setText("Last Sale Amt.");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        lastamt.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lastamt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastamt.setText("Rs. 60.00");
        jPanel6.add(lastamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 130, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 36, 130, 60));

        jButton1.setBackground(new java.awt.Color(227, 227, 62));
        jButton1.setText("Result Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 170, 40));

        printerPanel.setBackground(new java.awt.Color(255, 255, 255));
        printerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Printer"));

        javax.swing.GroupLayout printerPanelLayout = new javax.swing.GroupLayout(printerPanel);
        printerPanel.setLayout(printerPanelLayout);
        printerPanelLayout.setHorizontalGroup(
            printerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(printer, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        printerPanelLayout.setVerticalGroup(
            printerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, printerPanelLayout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(printer, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(printerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 138, 95));

        rBox.setBackground(new java.awt.Color(141, 235, 237));
        rBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Result", "Today Result", "Past Result" }));
        rBox.setAutoscrolls(true);
        rBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        rBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rBox.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        rBox.setEditor(null);
        rBox.setFocusCycleRoot(true);
        rBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBoxActionPerformed(evt);
            }
        });
        jPanel2.add(rBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 120, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1170, 500));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        claimReader.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                claimReaderKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                claimReaderKeyReleased(evt);
            }
        });
        jPanel13.add(claimReader, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 5, 163, 35));

        b1.setBackground(new java.awt.Color(109, 106, 225));
        b1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        b1.setForeground(new java.awt.Color(254, 254, 254));
        b1.setText("ADVANCE DRAW");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel13.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 170, 35));

        b2.setBackground(new java.awt.Color(109, 106, 225));
        b2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        b2.setForeground(new java.awt.Color(254, 254, 254));
        b2.setText("REFRESH");
        b2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel13.add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 5, 110, 35));

        b3.setBackground(new java.awt.Color(109, 106, 225));
        b3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        b3.setForeground(new java.awt.Color(254, 254, 254));
        b3.setText("REPORT[F4]");
        b3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel13.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 5, 130, 35));

        bSeries.setBackground(new java.awt.Color(109, 106, 225));
        bSeries.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        bSeries.setForeground(new java.awt.Color(254, 254, 254));
        bSeries.setText("SERIES");
        bSeries.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeriesActionPerformed(evt);
            }
        });
        jPanel13.add(bSeries, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 5, 110, 35));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mobile-phone-signal-strength.png"))); // NOI18N
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 48, 43));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1170, 45));

        resultPane.setBackground(new java.awt.Color(254, 254, 254));
        resultPane.setAutoscrolls(true);

        result.setBackground(new java.awt.Color(141, 235, 237));
        result.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        result.setForeground(new java.awt.Color(1, 1, 1));
        result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result.setText("Result");
        result.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout resultPaneLayout = new javax.swing.GroupLayout(resultPane);
        resultPane.setLayout(resultPaneLayout);
        resultPaneLayout.setHorizontalGroup(
            resultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPaneLayout.createSequentialGroup()
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 710, Short.MAX_VALUE))
        );
        resultPaneLayout.setVerticalGroup(
            resultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPaneLayout.createSequentialGroup()
                .addGap(0, 74, Short.MAX_VALUE)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(resultPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 830, 100));

        imagePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rajashri4.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 100));

        jPanel7.setBackground(new java.awt.Color(234, 47, 50));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id.setText("D_49");
        id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel7.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 20));

        userid.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        userid.setForeground(new java.awt.Color(255, 255, 255));
        userid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userid.setText("9523");
        userid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel7.add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 80, 20));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 190, 20));

        jPanel8.setBackground(new java.awt.Color(244, 188, 64));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clockLabel.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        clockLabel.setForeground(new java.awt.Color(4, 2, 2));
        clockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clockLabel.setText("D6");
        clockLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.add(clockLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 190, 30));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Rajalaxmi Lottery");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 190, 50));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Software Version 1.0");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B_9ActionPerformed

    private void B0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B0ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B0.setBackground(new Color(237, 93, 226));
        this.selectSubSeries(B0);
        this.getPreviousNumber(B0);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B0ActionPerformed

    private void E_49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E_49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E_49ActionPerformed

    private void crossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseClicked
        // TODO add your handling code here:
        //System.out.println(cross.isSelected());
    }//GEN-LAST:event_crossMouseClicked

    private void crossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crossActionPerformed
        // TODO add your handling code here:

        if (cross.isSelected()) {
            NSystems.setText("cross");
            //multi.setSelected(false);
            //odd.setSelected(false);
            //even.setSelected(false);
            fixed.setSelected(false);
        } else {
            NSystems.setText("");
        }

    }//GEN-LAST:event_crossActionPerformed

    private void multiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiActionPerformed
        // TODO add your handling code here:
        if (multi.isSelected()) {
            CMulti.setText("Multi");
            Dashboard.multiSeries = new ArrayList<>();
            Dashboard.multiSeries.add("1000-1900");
            //series.clear();
        } else {
            CMulti.setText("");

            //Dashboard.setMainSeries("1000-1900");
        }
    }//GEN-LAST:event_multiActionPerformed

    private void oddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oddActionPerformed
        // TODO add your handling code here:
        if (odd.isSelected()) {
            //NSystems.setText("odd");
            //multi.setSelected(false);
            //cross.setSelected(false);
            even.setSelected(false);
            //fixed.setSelected(false);
        } else {
            //NSystems.setText("");
        }
    }//GEN-LAST:event_oddActionPerformed

    private void evenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evenActionPerformed
        // TODO add your handling code here:
        if (even.isSelected()) {
            //NSystems.setText("even");
            // multi.setSelected(false);
            odd.setSelected(false);
            //cross.setSelected(false);
            //fixed.setSelected(false);
        } else {
            //NSystems.setText("");
        }
    }//GEN-LAST:event_evenActionPerformed

    private void fixedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixedActionPerformed
        // TODO add your handling code here:
        if (fixed.isSelected()) {
            NSystems.setText("fixed");
            //multi.setSelected(false);
            //odd.setSelected(false);
            //even.setSelected(false);
            cross.setSelected(false);
        } else {
            NSystems.setText("");
        }
    }//GEN-LAST:event_fixedActionPerformed

    private void singoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_singoutMouseClicked

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        // TODO add your handling code here:
        new ChangePassword().setVisible(true);
        ChangePassword.id.setText(userid.getText());
    }//GEN-LAST:event_passwordMouseClicked

    private void seriesLableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seriesLableMouseClicked
        // TODO add your handling code here:
        //Dashboard.multiSeries = null;
        new series().setVisible(true);
    }//GEN-LAST:event_seriesLableMouseClicked

    private void oddItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_oddItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
            int i = 0;
            while (i < 100) {
                JTextField temp = jField.get("E_" + i);
                if (i % 2 != 0) {
                    temp.setEnabled(false);
                }
                i++;
            }
        } else {//checkbox has been deselected
            int i = 0;
            while (i < 100) {
                JTextField temp = jField.get("E_" + i);
                if (i % 2 != 0) {
                    temp.setEnabled(true);
                }
                i++;
            }
        }

    }//GEN-LAST:event_oddItemStateChanged

    private void evenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_evenItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
            int i = 0;
            while (i < 100) {
                JTextField temp = jField.get("E_" + i);
                if (i % 2 == 0) {
                    temp.setEnabled(false);
                }
                i++;
            }
        } else {//checkbox has been deselected
            int i = 0;
            while (i < 100) {
                JTextField temp = jField.get("E_" + i);
                if (i % 2 == 0) {
                    temp.setEnabled(true);
                }
                i++;

            }
        }
    }//GEN-LAST:event_evenItemStateChanged

    private void B_0KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_0KeyReleased
        // TODO add your handling code here:
        try {
            int i = 0;
            BulkNumberWrite(i, B_0.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_B_0KeyReleased

    private void B_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_1KeyReleased
        // TODO add your handling code here:
        try {
            int i = 1;
            BulkNumberWrite(i, B_1.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_B_1KeyReleased

    private void B_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_2KeyReleased
        // TODO add your handling code here:
        try {
            int i = 2;
            BulkNumberWrite(i, B_2.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_B_2KeyReleased

    private void B_3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_3KeyReleased
        // TODO add your handling code here:
        try {
            int i = 3;
            BulkNumberWrite(i, B_3.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_3KeyReleased

    private void B_4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_4KeyReleased
        // TODO add your handling code here:
        try {
            int i = 4;
            BulkNumberWrite(i, B_4.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_4KeyReleased

    private void B_5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_5KeyReleased
        // TODO add your handling code here:
        try {
            int i = 5;
            BulkNumberWrite(i, B_5.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_5KeyReleased

    private void B_6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_6KeyReleased
        // TODO add your handling code here:
        try {
            int i = 6;
            BulkNumberWrite(i, B_6.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_6KeyReleased

    private void B_7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_7KeyReleased
        // TODO add your handling code here:
        try {
            int i = 7;
            BulkNumberWrite(i, B_7.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_7KeyReleased

    private void B_8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_8KeyReleased
        // TODO add your handling code here:
        try {
            int i = 8;
            BulkNumberWrite(i, B_8.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_8KeyReleased

    private void B_9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_9KeyReleased
        // TODO add your handling code here:
        try {
            int i = 9;
            BulkNumberWrite(i, B_9.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_9KeyReleased

    private void I_0KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_0KeyReleased
        // TODO add your handling code here:
        try {
            int i = 0;
            BulkNumberWriteVartical(i, I_0.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_0KeyReleased

    private void I_10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_10KeyReleased
        // TODO add your handling code here:
        try {
            int i = 10;
            BulkNumberWriteVartical(i, I_10.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_10KeyReleased

    private void I_20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_20KeyReleased
        // TODO add your handling code here:
        try {
            int i = 20;
            BulkNumberWriteVartical(i, I_20.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_20KeyReleased

    private void I_30KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_30KeyReleased
        // TODO add your handling code here:
        try {
            int i = 30;
            BulkNumberWriteVartical(i, I_30.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//  JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_30KeyReleased

    private void I_40KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_40KeyReleased
        // TODO add your handling code here:
        try {
            int i = 40;
            BulkNumberWriteVartical(i, I_40.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_40KeyReleased

    private void I_50KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_50KeyReleased
        // TODO add your handling code here:
        try {
            int i = 50;
            BulkNumberWriteVartical(i, I_50.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_50KeyReleased

    private void I_60KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_60KeyReleased
        // TODO add your handling code here:
        try {
            int i = 60;
            BulkNumberWriteVartical(i, I_60.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_60KeyReleased

    private void I_70KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_70KeyReleased
        // TODO add your handling code here:
        try {
            int i = 70;
            BulkNumberWriteVartical(i, I_70.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_70KeyReleased

    private void I_80KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_80KeyReleased
        // TODO add your handling code here:
        try {
            int i = 80;
            BulkNumberWriteVartical(i, I_80.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_80KeyReleased

    private void I_90KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I_90KeyReleased
        // TODO add your handling code here:
        try {
            int i = 90;
            BulkNumberWriteVartical(i, I_90.getText(), evt);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_I_90KeyReleased

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(this, "TEST");
        this.setMessageBar();

        try {
            Thread t = new Thread() {
                String msg = "";

                @Override
                public void run() {
                    try {
                        String qt = totalqty.getText();
                        String am = totalamt.getText();
                        if (qt.equals("") && am.equals("")) {
                            qt = "0";
                            am = "0";
                        }
                        if (Integer.parseInt(qt) <= 0 && Integer.parseInt(am) <= 0) {
                            JOptionPane.showMessageDialog(null, "Please fill lottry point");

                        } else {

                            if (advance.getText().equals("true")) {
                                for (int i = 0; i < Dashboard.advanceDrawArray.size(); i++) {
                                    Map<String, String> advanceDraw = Dashboard.advanceDrawArray.get(i);
                                    Map<String, Map> finalMap = new HashMap<>();
                                    Map<String, String> data = new HashMap<>();
                                    data.put("userid", userid.getText());

                                    data.put("drawid", advanceDraw.get("gametimeid"));
                                    data.put("totalqty", totalqty.getText());
                                    data.put("totalamt", totalamt.getText());
                                    data.put("perPoint", "2");
                                    data.put("start", advanceDraw.get("gametime"));
                                    data.put("end", advanceDraw.get("gameendtime"));
                                    data.put("ip", "127.0.0.1");
                                    finalMap.put("basic", data);
                                    finalMap.put("data", Dashboard.series);
                                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                    String jsonEmp = gson.toJson(finalMap);
                                    //System.out.println(jsonEmp);

                                    String Data = httpAPI._jsonRequest("?r=invoice", jsonEmp);
                                    //System.out.println("Data \n" + Data);
                                    msg = invoiceJSON.invoiceJSONPrint(Data);
                                    lastTransaction();
                                }
                            } else {
                                Map<String, Map> finalMap = new HashMap<>();
                                Map<String, String> data = new HashMap<>();
                                data.put("userid", userid.getText());
                                String did[] = id.getText().split("_");
                                data.put("drawid", did[1]);
                                data.put("totalqty", totalqty.getText());
                                data.put("totalamt", totalamt.getText());
                                data.put("perPoint", "2");
                                data.put("start", start.getText());
                                data.put("end", end.getText());
                                data.put("ip", "127.0.0.1");
                                finalMap.put("basic", data);
                                finalMap.put("data", Dashboard.series);
                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                String jsonEmp = gson.toJson(finalMap);
                                //System.out.println(jsonEmp);
                                String Data = httpAPI._jsonRequest("?r=invoice", jsonEmp);
                                //System.out.println("Data \n" + Data);
                                invoiceJSON.invoiceJSONPrint(Data);
                                msg = invoiceJSON.invoiceJSONPrint(Data);
                                lastTransaction();

                            }

                            JOptionPane.showMessageDialog(null, msg);

                        }

                        resetAll();
                        buy.setEnabled(true);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            };
            buy.setEnabled(false);
            t.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Exception message " + ex.getMessage());

        }
    }//GEN-LAST:event_buyActionPerformed

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B1.setBackground(new Color(70, 176, 216));
        this.selectSubSeries(B1);
        this.getPreviousNumber(B1);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B2.setBackground(new Color(116, 205, 239));
        this.selectSubSeries(B2);
        this.getPreviousNumber(B2);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B3.setBackground(new Color(243, 244, 165));
        this.selectSubSeries(B3);
        this.getPreviousNumber(B3);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B4.setBackground(new Color(165, 232, 123));
        this.selectSubSeries(B4);
        this.getPreviousNumber(B4);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B5.setBackground(new Color(237, 93, 226));
        this.selectSubSeries(B5);
        this.getPreviousNumber(B5);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B5ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B6.setBackground(new Color(70, 176, 216));
        this.selectSubSeries(B6);
        this.getPreviousNumber(B6);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B6ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B7.setBackground(new Color(116, 205, 239));
        this.selectSubSeries(B7);
        this.getPreviousNumber(B7);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B7ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B8.setBackground(new Color(243, 244, 165));
        this.selectSubSeries(B8);
        this.getPreviousNumber(B8);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B8ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        // TODO add your handling code here:
        this.setDefauldButtonColor();
        B9.setBackground(new Color(165, 232, 123));
        this.selectSubSeries(B9);
        this.getPreviousNumber(B9);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
    }//GEN-LAST:event_B9ActionPerformed

    private void BALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BALLActionPerformed
        // TODO add your handling code here:
        if (alls.getText().equals("true")) {
            alls.setText("false");
            this.selectAll(Color.WHITE);
            subSeriesNo.setText("");
        } else {
            alls.setText("true");
            this.selectAll(Color.cyan);
            subSeriesNo.setText(seriesLable.getText());
        }
    }//GEN-LAST:event_BALLActionPerformed

    private void jPanel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyReleased
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, evt.getKeyChar());
    }//GEN-LAST:event_jPanel2KeyReleased

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        new advance().setVisible(true);
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        resultBoard("ALL");
        resetAll();
    }//GEN-LAST:event_b2ActionPerformed

    private void B_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B_0ActionPerformed

    private void claimReaderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claimReaderKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        Map<String, String> finalMap = new HashMap<>();
                        finalMap.put("id", claimReader.getText());
                        finalMap.put("userid", userid.getText());
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonEmp = gson.toJson(finalMap);
                        //System.out.println(jsonEmp);
                        String data = httpAPI._jsonRequest("?r=checkWinner", jsonEmp);
                        //System.out.println(data);
                        String msg = claimJSON.claimJSONPrint(data);
                        JOptionPane.showMessageDialog(null, msg);
                        claimReader.setText("");
                    } catch (Exception ex) {
                        System.out.println("Error on ClaimReadr Exceptione " + ex.getMessage());
                    }
                }
            };
            t.start();
        }
    }//GEN-LAST:event_claimReaderKeyReleased

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_b3ActionPerformed

    private void bSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeriesActionPerformed
        // TODO add your handling code here:
        new series().setVisible(true);
    }//GEN-LAST:event_bSeriesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (multi.isSelected()) {
                //call default
                resultBoard("ALL");
            } else {
                /// single display
                resultBoard(seriesLable.getText());
            }
        } catch (Exception ed) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBoxActionPerformed
        // TODO add your handling code here:
        ResultWed rw = new ResultWed();
        switch (rBox.getSelectedItem().toString()) {
            case "Today Result":
                Thread resutlToday = new Thread() {
                    @Override
                    public void run() {
                        rw.showResult();
                    }
                };
                resutlToday.start();

                break;
            case "Past Result":
//                new Result().setVisible(true);
                Thread resultP = new Thread() {
                    @Override
                    public void run() {
                        rw.showResult();
                    }
                };
                resultP.start();
                break;
            default:
                break;
        }
        rBox.setSelectedIndex(0);
    }//GEN-LAST:event_rBoxActionPerformed

    private void reprintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reprintMouseClicked
        // TODO add your handling code here:
        new tickets("Print").setVisible(true);
    }//GEN-LAST:event_reprintMouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
        new tickets("Cancel").setVisible(true);
    }//GEN-LAST:event_cancelMouseClicked

    private void buyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buyKeyPressed
        // TODO add your handling code here:
//        if (evt.getKeyCode() == KeyEvent.VK_F6) {
//            System.out.println("Hello");
//            JOptionPane.showMessageDialog(this, "You've Submitted the name ");
//        }
//
//        
    }//GEN-LAST:event_buyKeyPressed

    private void claimReaderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claimReaderKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_claimReaderKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField A10000_10900;
    private javax.swing.JTextField A1000_1900;
    private javax.swing.JTextField A2000_2900;
    private javax.swing.JTextField A3000_3900;
    private javax.swing.JTextField A4000_4900;
    private javax.swing.JTextField A5000_5900;
    private javax.swing.JTextField A6000_6900;
    private javax.swing.JTextField A7000_7900;
    private javax.swing.JTextField A8000_8900;
    private javax.swing.JTextField A9000_9900;
    private javax.swing.JButton B0;
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton B9;
    private javax.swing.JButton BALL;
    private javax.swing.JTextField B_0;
    private javax.swing.JTextField B_1;
    private javax.swing.JTextField B_2;
    private javax.swing.JTextField B_3;
    private javax.swing.JTextField B_4;
    private javax.swing.JTextField B_5;
    private javax.swing.JTextField B_6;
    private javax.swing.JTextField B_7;
    private javax.swing.JTextField B_8;
    private javax.swing.JTextField B_9;
    private javax.swing.JTextField CMulti;
    private javax.swing.JTextField E_0;
    private javax.swing.JTextField E_1;
    private javax.swing.JTextField E_10;
    private javax.swing.JTextField E_11;
    private javax.swing.JTextField E_12;
    private javax.swing.JTextField E_13;
    private javax.swing.JTextField E_14;
    private javax.swing.JTextField E_15;
    private javax.swing.JTextField E_16;
    private javax.swing.JTextField E_17;
    private javax.swing.JTextField E_18;
    private javax.swing.JTextField E_19;
    private javax.swing.JTextField E_2;
    private javax.swing.JTextField E_20;
    private javax.swing.JTextField E_21;
    private javax.swing.JTextField E_22;
    private javax.swing.JTextField E_23;
    private javax.swing.JTextField E_24;
    private javax.swing.JTextField E_25;
    private javax.swing.JTextField E_26;
    private javax.swing.JTextField E_27;
    private javax.swing.JTextField E_28;
    private javax.swing.JTextField E_29;
    private javax.swing.JTextField E_3;
    private javax.swing.JTextField E_30;
    private javax.swing.JTextField E_31;
    private javax.swing.JTextField E_32;
    private javax.swing.JTextField E_33;
    private javax.swing.JTextField E_34;
    private javax.swing.JTextField E_35;
    private javax.swing.JTextField E_36;
    private javax.swing.JTextField E_37;
    private javax.swing.JTextField E_38;
    private javax.swing.JTextField E_39;
    private javax.swing.JTextField E_4;
    private javax.swing.JTextField E_40;
    private javax.swing.JTextField E_41;
    private javax.swing.JTextField E_42;
    private javax.swing.JTextField E_43;
    private javax.swing.JTextField E_44;
    private javax.swing.JTextField E_45;
    private javax.swing.JTextField E_46;
    private javax.swing.JTextField E_47;
    private javax.swing.JTextField E_48;
    private javax.swing.JTextField E_49;
    private javax.swing.JTextField E_5;
    private javax.swing.JTextField E_50;
    private javax.swing.JTextField E_51;
    private javax.swing.JTextField E_52;
    private javax.swing.JTextField E_53;
    private javax.swing.JTextField E_54;
    private javax.swing.JTextField E_55;
    private javax.swing.JTextField E_56;
    private javax.swing.JTextField E_57;
    private javax.swing.JTextField E_58;
    private javax.swing.JTextField E_59;
    private javax.swing.JTextField E_6;
    private javax.swing.JTextField E_60;
    private javax.swing.JTextField E_61;
    private javax.swing.JTextField E_62;
    private javax.swing.JTextField E_63;
    private javax.swing.JTextField E_64;
    private javax.swing.JTextField E_65;
    private javax.swing.JTextField E_66;
    private javax.swing.JTextField E_67;
    private javax.swing.JTextField E_68;
    private javax.swing.JTextField E_69;
    private javax.swing.JTextField E_7;
    private javax.swing.JTextField E_70;
    private javax.swing.JTextField E_71;
    private javax.swing.JTextField E_72;
    private javax.swing.JTextField E_73;
    private javax.swing.JTextField E_74;
    private javax.swing.JTextField E_75;
    private javax.swing.JTextField E_76;
    private javax.swing.JTextField E_77;
    private javax.swing.JTextField E_78;
    private javax.swing.JTextField E_79;
    private javax.swing.JTextField E_8;
    private javax.swing.JTextField E_80;
    private javax.swing.JTextField E_81;
    private javax.swing.JTextField E_82;
    private javax.swing.JTextField E_83;
    private javax.swing.JTextField E_84;
    private javax.swing.JTextField E_85;
    private javax.swing.JTextField E_86;
    private javax.swing.JTextField E_87;
    private javax.swing.JTextField E_88;
    private javax.swing.JTextField E_89;
    private javax.swing.JTextField E_9;
    private javax.swing.JTextField E_90;
    private javax.swing.JTextField E_91;
    private javax.swing.JTextField E_92;
    private javax.swing.JTextField E_93;
    private javax.swing.JTextField E_94;
    private javax.swing.JTextField E_95;
    private javax.swing.JTextField E_96;
    private javax.swing.JTextField E_97;
    private javax.swing.JTextField E_98;
    private javax.swing.JTextField E_99;
    private javax.swing.JTextField I_0;
    private javax.swing.JTextField I_10;
    private javax.swing.JTextField I_20;
    private javax.swing.JTextField I_30;
    private javax.swing.JTextField I_40;
    private javax.swing.JTextField I_50;
    private javax.swing.JTextField I_60;
    private javax.swing.JTextField I_70;
    private javax.swing.JTextField I_80;
    private javax.swing.JTextField I_90;
    private javax.swing.JTextField NSystems;
    private javax.swing.JTextField Q10000_10900;
    private javax.swing.JTextField Q1000_1900;
    private javax.swing.JTextField Q2000_2900;
    private javax.swing.JTextField Q3000_3900;
    private javax.swing.JTextField Q4000_4900;
    private javax.swing.JTextField Q5000_5900;
    private javax.swing.JTextField Q6000_6900;
    private javax.swing.JTextField Q7000_7900;
    private javax.swing.JTextField Q8000_8900;
    private javax.swing.JTextField Q9000_9900;
    private javax.swing.JLabel account;
    public static javax.swing.JTextField advance;
    private javax.swing.JTextField alls;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton bSeries;
    private javax.swing.JLabel balance;
    public static javax.swing.JButton buy;
    private javax.swing.JLabel cDate;
    private javax.swing.JLabel cancel;
    private javax.swing.JTextField claimReader;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JLabel complaint;
    private javax.swing.JCheckBox cross;
    public static javax.swing.JLabel dTime;
    public static javax.swing.JLabel drawClock;
    public static javax.swing.JTextField end;
    private javax.swing.JCheckBox even;
    private javax.swing.JCheckBox fixed;
    public static javax.swing.JLabel id;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel last;
    private javax.swing.JLabel lastamt;
    public static final javax.swing.JCheckBox multi = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox odd;
    private javax.swing.JLabel operator;
    private javax.swing.JLabel password;
    public static javax.swing.JLabel printer;
    private javax.swing.JPanel printerPanel;
    private javax.swing.JComboBox rBox;
    private javax.swing.JLabel reprint;
    private javax.swing.JLabel result;
    public static javax.swing.JPanel resultPane;
    public static javax.swing.JLabel seriesLable;
    private javax.swing.JLabel singout;
    public static javax.swing.JTextField start;
    private javax.swing.JTextField subSeriesNo;
    public static javax.swing.JTextField totalamt;
    public static javax.swing.JTextField totalqty;
    private javax.swing.JLabel uid;
    public static javax.swing.JLabel userid;
    // End of variables declaration//GEN-END:variables

    public static void selectDefaultSeries(int i) {
        ArrayList<String> temp = new ArrayList<>();
        temp = SeriesClass.series.get(i);

        Iterator litr = temp.listIterator();
        int k = 0;
        while (litr.hasNext()) {
            JButton jbutton = buttonMap.get("B" + k);
            jbutton.setText((String) litr.next());
            k++;
        }
        Dashboard.setMainSeries(seriesLable.getText());
    }

    public static void selectDefaultSeriesMulti(int i) {
        ArrayList<String> temp = new ArrayList<>();
        temp = SeriesClass.series.get(i);

        Iterator litr = temp.listIterator();
        int k = 0;
        while (litr.hasNext()) {
            JButton jbutton = buttonMap.get("B" + k);
            jbutton.setText((String) litr.next());
            k++;
        }
        //Dashboard.setMainSeries(seriesLable.getText());
    }

    public void refreshMessageTimer() {
        try {
        } catch (Exception ex) {
        }
    }

    private void showTimer() {

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    DateFormat f = new SimpleDateFormat("dd-MM-YYYY");
                    Date dobj = new Date();
                    cDate.setText(f.format(dobj));
                    while (true) {
                        DateFormat df = new SimpleDateFormat("hh:mm:ss aa");
                        Date dateobj = new Date();
                        clockLabel.setText(df.format(dateobj));
                        Thread.sleep(100);

                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t.start();
        //System.out.println();
    }

    private void mapButton() {
        try {
            buttonMap.put("B0", B0);
            buttonMap.put("B1", B1);
            buttonMap.put("B2", B2);
            buttonMap.put("B3", B3);
            buttonMap.put("B4", B4);
            buttonMap.put("B5", B5);
            buttonMap.put("B6", B6);
            buttonMap.put("B7", B7);
            buttonMap.put("B8", B8);
            buttonMap.put("B9", B9);
        } catch (Exception ex) {

        }
    }

    private void mapHorizontalTextField() {
        try {
            horizontalTextField.put("B_0", B_0);
            horizontalTextField.put("B_1", B_1);
            horizontalTextField.put("B_2", B_2);
            horizontalTextField.put("B_3", B_3);
            horizontalTextField.put("B_4", B_4);
            horizontalTextField.put("B_5", B_5);
            horizontalTextField.put("B_6", B_6);
            horizontalTextField.put("B_7", B_7);
            horizontalTextField.put("B_8", B_8);
            horizontalTextField.put("B_9", B_9);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setTotalField() {
        try {
            totalField.put("Q1000_1900", Q1000_1900);
            totalField.put("A1000_1900", A1000_1900);
            totalField.put("Q2000_2900", Q2000_2900);
            totalField.put("A2000_2900", A2000_2900);
            totalField.put("Q3000_3900", Q3000_3900);
            totalField.put("A3000_3900", A3000_3900);
            totalField.put("Q4000_4900", Q4000_4900);
            totalField.put("A4000_4900", A4000_4900);
            totalField.put("Q5000_5900", Q5000_5900);
            totalField.put("A5000_5900", A5000_5900);
            totalField.put("Q6000_6900", Q6000_6900);
            totalField.put("A6000_6900", A6000_6900);
            totalField.put("Q7000_7900", Q7000_7900);
            totalField.put("A7000_7900", A7000_7900);
            totalField.put("Q8000_8900", Q8000_8900);
            totalField.put("A8000_8900", A8000_8900);
            totalField.put("Q9000_9900", Q9000_9900);
            totalField.put("A9000_9900", A9000_9900);
            totalField.put("Q10000_10900", Q10000_10900);
            totalField.put("A10000_10900", A10000_10900);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void mapVarticalTextField() {
        try {
            varticalTextField.put("I_0", I_0);
            varticalTextField.put("I_10", I_10);
            varticalTextField.put("I_20", I_20);
            varticalTextField.put("I_30", I_30);
            varticalTextField.put("I_40", I_40);
            varticalTextField.put("I_50", I_50);
            varticalTextField.put("I_60", I_60);
            varticalTextField.put("I_70", I_70);
            varticalTextField.put("I_80", I_80);
            varticalTextField.put("I_90", I_90);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void mapJTextField() {
        try {
            jField.put("E_0", E_0);
            jField.put("E_1", E_1);
            jField.put("E_2", E_2);
            jField.put("E_3", E_3);
            jField.put("E_4", E_4);
            jField.put("E_5", E_5);
            jField.put("E_6", E_6);
            jField.put("E_7", E_7);
            jField.put("E_8", E_8);
            jField.put("E_9", E_9);
            jField.put("E_10", E_10);
            jField.put("E_11", E_11);
            jField.put("E_12", E_12);
            jField.put("E_13", E_13);
            jField.put("E_14", E_14);
            jField.put("E_15", E_15);
            jField.put("E_16", E_16);
            jField.put("E_17", E_17);
            jField.put("E_18", E_18);
            jField.put("E_19", E_19);
            jField.put("E_20", E_20);
            jField.put("E_21", E_21);
            jField.put("E_22", E_22);
            jField.put("E_23", E_23);
            jField.put("E_24", E_24);
            jField.put("E_25", E_25);
            jField.put("E_26", E_26);
            jField.put("E_27", E_27);
            jField.put("E_28", E_28);
            jField.put("E_29", E_29);
            jField.put("E_30", E_30);
            jField.put("E_31", E_31);
            jField.put("E_32", E_32);
            jField.put("E_33", E_33);
            jField.put("E_34", E_34);
            jField.put("E_35", E_35);
            jField.put("E_36", E_36);
            jField.put("E_37", E_37);
            jField.put("E_38", E_38);
            jField.put("E_39", E_39);
            jField.put("E_40", E_40);
            jField.put("E_41", E_41);
            jField.put("E_42", E_42);
            jField.put("E_43", E_43);
            jField.put("E_44", E_44);
            jField.put("E_45", E_45);
            jField.put("E_46", E_46);
            jField.put("E_47", E_47);
            jField.put("E_48", E_48);
            jField.put("E_49", E_49);
            jField.put("E_50", E_50);
            jField.put("E_51", E_51);
            jField.put("E_52", E_52);
            jField.put("E_53", E_53);
            jField.put("E_54", E_54);
            jField.put("E_55", E_55);
            jField.put("E_56", E_56);
            jField.put("E_57", E_57);
            jField.put("E_58", E_58);
            jField.put("E_59", E_59);
            jField.put("E_60", E_60);
            jField.put("E_61", E_61);
            jField.put("E_62", E_62);
            jField.put("E_63", E_63);
            jField.put("E_64", E_64);
            jField.put("E_65", E_65);
            jField.put("E_66", E_66);
            jField.put("E_67", E_67);
            jField.put("E_68", E_68);
            jField.put("E_69", E_69);
            jField.put("E_70", E_70);
            jField.put("E_71", E_71);
            jField.put("E_72", E_72);
            jField.put("E_73", E_73);
            jField.put("E_74", E_74);
            jField.put("E_75", E_75);
            jField.put("E_76", E_76);
            jField.put("E_77", E_77);
            jField.put("E_78", E_78);
            jField.put("E_79", E_79);
            jField.put("E_80", E_80);
            jField.put("E_81", E_81);
            jField.put("E_82", E_82);
            jField.put("E_83", E_83);
            jField.put("E_84", E_84);
            jField.put("E_85", E_85);
            jField.put("E_86", E_86);
            jField.put("E_87", E_87);
            jField.put("E_88", E_88);
            jField.put("E_89", E_89);
            jField.put("E_90", E_90);
            jField.put("E_91", E_91);
            jField.put("E_92", E_92);
            jField.put("E_93", E_93);
            jField.put("E_94", E_94);
            jField.put("E_95", E_95);
            jField.put("E_96", E_96);
            jField.put("E_97", E_97);
            jField.put("E_98", E_98);
            jField.put("E_99", E_99);
        } catch (Exception ex) {

        }
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        JOptionPane.showMessageDialog(null, "Simple Information Message" + str);
    }

    public void setMessageBar() {
        try {
            String data = httpAPI._jsonRequest("?r=message", "");
            //System.out.println("Message: " + data);
            JLabel myLable = new MarqueeLabel(data, MarqueeLabel.RIGHT_TO_LEFT, 20);
            myLable.setForeground(Color.red);
            myLable.setBounds(10, 460, 800, 30);
            jPanel2.add(myLable);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void setMainSeries(String Series) {
        Map<String, Map> tempSeries = new HashMap<>();
        Dashboard.series.put(Series, tempSeries);
    }

    public static void removeMainSeries(String Series) {
        //Map<String, Map> tempSeries = new HashMap<>();
        Dashboard.series.remove(Series);
    }

    public static void setSubSeries(String subSeries, String Main) {//Mian=1000-1900
        try {
            Map<String, Map> mainSeries = Dashboard.series.get(Main);//get Main   
            Map<String, ArrayList> tempSubSeries = new HashMap<>();
            ArrayList<Map> aMap = new ArrayList<>();
            String s[] = subSeries.split("-");
            tempSubSeries.put(s[0], aMap);
            mainSeries.put(s[0], tempSubSeries);
            //System.out.println(mainSeries);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static final void setNumber(String index, String value, String Main, String Sub) {
        try {
            // Map<String, Map> mainSeries = Dashboard.series.get(Main);//Main
            String ss[] = Sub.split("-");
            for (int s = Integer.parseInt(ss[0]); s <= Integer.parseInt(ss[1]); s = s + 100) {
                Map<String, Map> mainSeries = Dashboard.series.get(Main);//Main
                String sp = s + "";
                //System.out.println(Dashboard.series);
                if (mainSeries.get(sp) == null) {
                    Dashboard.setSubSeries(sp, Main);
                }
                Map<String, ArrayList> tempSubSeries = mainSeries.get(sp);//Sub
                ArrayList<Map> aMap = tempSubSeries.get(sp);//Array
                boolean flag = false;
                for (int i = 0; i < aMap.size(); ++i) {
                    Map<String, String> numberTemp = aMap.get(i);
                    for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                        if (finas.getKey().equals(index)) {
                            numberTemp.replace(finas.getKey(), value);
                            flag = true;
                        }
                    }

                }
                if (!flag) {
                    Map<String, String> number = new HashMap<>();
                    number.put(index, value);
                    aMap.add(number);
                }
            }
//            Map<String, ArrayList> tempSubSeries = mainSeries.get(ss[0]);//Sub
//            ArrayList<Map> aMap = tempSubSeries.get(ss[0]);//Array
//            Map<String, String> number = new HashMap<>();
//            number.put(index, value);
//            aMap.add(number);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static final void setNumberMulti(String index, String value, String Main, String Sub, String state) {
        try {

            for (String series : Dashboard.multiSeries) {
                if (state.equals("true")) {
                    String ss[] = series.split("-");
                    for (int s = Integer.parseInt(ss[0]); s <= Integer.parseInt(ss[1]); s = s + 100) {
                        Map<String, Map> mainSeries = Dashboard.series.get(series);//Main
                        String sp = s + "";
                        //System.out.println(Dashboard.series);
                        if (mainSeries.get(sp) == null) {
                            Dashboard.setSubSeries(sp, series);
                        }

                        Map<String, ArrayList> tempSubSeries = mainSeries.get(sp);//Sub
                        ArrayList<Map> aMap = tempSubSeries.get(sp);//Array
                        boolean flag = false;
                        for (int i = 0; i < aMap.size(); ++i) {
                            Map<String, String> numberTemp = aMap.get(i);
                            for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                                if (finas.getKey().equals(index)) {
                                    numberTemp.replace(finas.getKey(), value);
                                    flag = true;
                                }
                            }

                        }
                        if (!flag) {
                            Map<String, String> number = new HashMap<>();
                            number.put(index, value);
                            aMap.add(number);
                        }

                    }
                } else {
//                    
                    String ss[] = Sub.split("-");
                    String ser[] = series.split("-");
                    Map<String, Map> mainSeries = Dashboard.series.get(series);//Main
                    int sp = Integer.parseInt(ss[0]) + Integer.parseInt(ser[0]) - 1000;
                    if (mainSeries.get("" + sp) == null) {
                        Dashboard.setSubSeries("" + sp, series);
                    }
                    Map<String, ArrayList> tempSubSeries = mainSeries.get("" + sp);//Sub
                    ArrayList<Map> aMap = tempSubSeries.get("" + sp);//Array
                    boolean flag = false;
                    for (int i = 0; i < aMap.size(); ++i) {
                        Map<String, String> numberTemp = aMap.get(i);
                        for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                            if (finas.getKey().equals(index)) {
                                numberTemp.replace(finas.getKey(), value);
                                flag = true;
                            }
                        }

                    }
                    if (!flag) {
                        Map<String, String> number = new HashMap<>();
                        number.put(index, value);
                        aMap.add(number);
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new ArrayList 
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list 
        for (T element : list) {

            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list 
        return newList;
    }

    public static void runNSOutput() {
        try {
            Thread t = new Thread() {

                @Override
                public void run() {
//                    while (true) {
//                        System.out.println("Modified ArrayList : " + Dashboard.multiSeries);
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ex) {
//                            System.out.println(ex.getMessage());
//                        }
//                    }

                    //Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    while (true) {
                        //System.out.println(Dashboard.series);
                        //  String jsonEmp = gson.toJson(Dashboard.multiSeries);
                        // System.out.println(jsonEmp);
                        //System.out.println(advanceDrawArray);
                        Dashboard.calculateTotal();

                        try {
                            Thread.sleep(1000);
                            Dashboard.resetFinalTotal();
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            };
            t.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void BulkNumberWrite(int i, String p, java.awt.event.KeyEvent e) {
        // System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
//            case 38:
//
//                break;
//            case 40:
//
//                break;
            case 37://left
                int tempN = i - 1;
                if (horizontalTextField.get("B_" + tempN) != null) {
                    JTextField tpf = horizontalTextField.get("B_" + tempN);
                    tpf.requestFocus();
                }
                break;
            case 39://right
                int tempP = i + 1;
                if (horizontalTextField.get("B_" + tempP) != null) {
                    JTextField tpf = horizontalTextField.get("B_" + tempP);
                    tpf.requestFocus();
                }
                break;
            default:
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || "".equals(p)) {
                    int vartical = 0;//add 10
                    while (i <= 99) {
                        JTextField varticalTF = varticalTextField.get("I_" + vartical);
                        JTextField jf = jField.get("E_" + i);
                        e.getKeyChar();
                        if (!"".equals(varticalTF.getText())) {
                            int vPoint = Integer.parseInt(varticalTF.getText());
                            int t = vPoint + Integer.parseInt(p);
                            jf.setText(t + "");
                            this.inputSystem(i, jf);
                        } else {
                            jf.setText(p);
                            this.inputSystem(i, jf);
                        }
                        i = i + 10;
                        vartical = vartical + 10;
                    }
                } else {
                    //JOptionPane.showMessageDialog(this, "Enter Valid Number", "Error Message Box", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

    }

    private void BulkNumberWriteVartical(int i, String p, KeyEvent e) {
        // System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case 38:
                int tempN = i - 10;
                if (varticalTextField.get("I_" + tempN) != null) {
                    JTextField tpf = varticalTextField.get("I_" + tempN);
                    tpf.requestFocus();
                }

                break;
            case 40:
                int tempP = i + 10;
                if (varticalTextField.get("I_" + tempP) != null) {
                    JTextField tpfp = varticalTextField.get("I_" + tempP);
                    tpfp.requestFocus();
                }
                break;
            case 37://left
                break;
            case 39://right
                break;
            default:
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || "".equals(p)) {
                    int horizontal = 0;//add 10
                    int tp = i + 10;
                    while (i < tp) {
                        JTextField varticalTF = horizontalTextField.get("B_" + horizontal);
                        JTextField jf = jField.get("E_" + i);
                        e.getKeyChar();
                        if (!"".equals(varticalTF.getText())) {
                            int vPoint = Integer.parseInt(varticalTF.getText());
                            int t = vPoint + Integer.parseInt(p);
                            jf.setText(t + "");
                            this.inputSystem(i, jf);
                        } else {
                            jf.setText(p);
                            this.inputSystem(i, jf);
                        }
                        i++;
                        horizontal++;
                    }
                } else {
                    //JOptionPane.showMessageDialog(this, "Enter Valid Number", "Error Message Box", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

    }

    public final void setDefaultColorOfInputPoitBox() {
        try {
            int i = 0;
            while (i < 100) {
                // System.out.println("E_" + i);
                JTextField jf = jField.get("E_" + i);
                jf.setBackground(Color.WHITE);
                jf.setFont(new java.awt.Font("Ubuntu", 1, 15));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void selectSubSeries(JButton B0) {
        String btxt = B0.getText();
        subSeriesNo.setText(btxt);
        if (Dashboard.checkSubSeries(btxt, seriesLable.getText())) {

        } else {
            Dashboard.setSubSeries(btxt, seriesLable.getText());
        }

        String s[] = btxt.split("-");

        int end = Integer.parseInt(s[1]);
        int i = 0;
        for (int start = Integer.parseInt(s[0]); start <= end; start++) {
            JTextField jf = jField.get("E_" + i);
            jf.setForeground(Color.GRAY);
            jf.setBackground(Color.white);
            jf.setText("" + start);
            //jf.setForeground(Color.BLACK);
            // System.out.println("E_"+start);
            i++;
        }
    }

    private void setDefauldButtonColor() {
        B0.setBackground(new Color(255, 255, 255));
        B1.setBackground(new Color(255, 255, 255));
        B2.setBackground(new Color(255, 255, 255));
        B3.setBackground(new Color(255, 255, 255));
        B4.setBackground(new Color(255, 255, 255));
        B5.setBackground(new Color(255, 255, 255));
        B6.setBackground(new Color(255, 255, 255));
        B7.setBackground(new Color(255, 255, 255));
        B8.setBackground(new Color(255, 255, 255));
        B9.setBackground(new Color(255, 255, 255));
    }

    private void selectAll(Color WHITE) {
        B0.setBackground(WHITE);
        //this.selectSubSeries(B0);
        B1.setBackground(WHITE);
        //this.selectSubSeries(B1);
        B2.setBackground(WHITE);
        //this.selectSubSeries(B2);
        B3.setBackground(WHITE);
        //this.selectSubSeries(B3);
        B4.setBackground(WHITE);
        //this.selectSubSeries(B4);
        B5.setBackground(WHITE);
        //this.selectSubSeries(B5);
        B6.setBackground(WHITE);
        //this.selectSubSeries(B6);
        B7.setBackground(WHITE);
        //this.selectSubSeries(B7);
        B8.setBackground(WHITE);
        //this.selectSubSeries(B8);
        B9.setBackground(WHITE);
        //this.selectSubSeries(B9);
    }

    public void resetVarticalInput() {
        I_0.setText("");
        I_10.setText("");
        I_20.setText("");
        I_30.setText("");
        I_40.setText("");
        I_50.setText("");
        I_60.setText("");
        I_70.setText("");
        I_80.setText("");
        I_90.setText("");
    }

    public void resetHorizontalInput() {
        B_0.setText("");
        B_1.setText("");
        B_2.setText("");
        B_3.setText("");
        B_4.setText("");
        B_5.setText("");
        B_6.setText("");
        B_7.setText("");
        B_8.setText("");
        B_9.setText("");
    }

    public static void resetClock() {
        try {
            String data = httpAPI._jsonRequest("?r=updateGameRound", "");
            // System.out.println(data);
            JSONObject myResponse = new JSONObject(data);
            buy.setEnabled(true);
            id.setText("D_" + myResponse.getString("id"));
            start.setText(myResponse.getString("stime"));
            end.setText(myResponse.getString("etime"));
            String strTime = myResponse.getString("etime");
//            DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
//            Date d = dateFormat.parse(strTime);
            dTime.setText(TimeFormats.timeConvert(strTime));
            interval = Integer.parseInt(myResponse.getString("time"));
            Dashboard.resultBoard("ALL");

        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void inisetClockCounter() {
        try {
            String data = httpAPI._jsonRequest("?r=updateGameRound", "");
            System.out.println("Draw Data " + data);
            JSONObject myResponse = new JSONObject(data);
            buy.setEnabled(true);
            id.setText("D_" + myResponse.getString("id"));
            start.setText(myResponse.getString("stime"));
            end.setText(myResponse.getString("etime"));
            String strTime = myResponse.getString("etime");
//            DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
//            Date d = dateFormat.parse(strTime);
            dTime.setText(TimeFormats.timeConvert(strTime));
            Dashboard.closckDraw(myResponse.getString("time"));
        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void closckDraw(String secs) {

        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        //System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                drawClock.setText(formatSeconds(setInterval()));

            }
        }, delay, period);
    }

    private static final int setInterval() {
        if (interval == 10) {
            buy.setEnabled(false);
        }
        if (interval == 0) {
            Dashboard.resetClock();
        }
        return --interval;
    }

    public static String formatSeconds(int timeInSeconds) {
        int hours = timeInSeconds / 3600;
        int secondsLeft = timeInSeconds - hours * 3600;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String formattedTime = "";
        if (hours < 10) {
            formattedTime += "0";
        }
        formattedTime += hours + ":";

        if (minutes < 10) {
            formattedTime += "0";
        }
        formattedTime += minutes + ":";

        if (seconds < 10) {
            formattedTime += "0";
        }
        formattedTime += seconds;

        return formattedTime;
    }

    public static void calculateTotal() {
        try {
            int qty = 0;
            String sr = "";

            Dashboard.final_Map = new HashMap<>();
            for (Map.Entry<String, Map> entry : Dashboard.series.entrySet()) {
                Map<String, ArrayList> test = entry.getValue();
                for (Map.Entry<String, ArrayList> entrys : test.entrySet()) {
                    sr = entry.getKey();
                    Map<String, ArrayList> tp = new HashMap<>();
                    tp = (Map<String, ArrayList>) entrys.getValue();
                    //System.out.println(tp);
                    for (Map.Entry<String, ArrayList> num : tp.entrySet()) {
                        //System.out.println(num.getValue());
                        ArrayList<Map> number = num.getValue();
                        for (int i = 0; i < number.size(); i++) {
                            Map<String, String> numF = (number.get(i));
                            for (Map.Entry<String, String> finas : numF.entrySet()) {
                                String userNumber = finas.getValue();
                                if (userNumber.equals("")) {
                                    number.remove(i);
                                } else {
                                    int userQty = Integer.parseInt(userNumber);
                                    qty = qty + userQty;

                                }
                            }
                        }
                    }
                }
                Dashboard.final_Map.put(sr, qty);
                qty = 0;

                //System.out.println("Key = " + entry.getKey()
                //    + ", Value = " + entry.getValue());
            }
            //System.out.println(Dashboard.final_Map);
            //System.out.println("total Qty: " + qty);
            Dashboard.dispalyTotal();
            //System.out.println(Dashboard.multiSeries);

        } catch (Exception ex) {

        }

    }

    public static void dispalyTotal() {
        try {
            int finalQty = 0;
            int finalAmt = 0;
            //Dashboard.ResttotalField();
            for (Map.Entry<String, Integer> entry : Dashboard.final_Map.entrySet()) {
                String newString = entry.getKey().replace("-", "_");
                JTextField qtyField = totalField.get("Q" + newString);
                qtyField.setText(entry.getValue() + "");
                JTextField amtField = totalField.get("A" + newString);
                amtField.setText((entry.getValue() * 2) + "");
                finalQty = finalQty + entry.getValue();
            }
            finalAmt = finalQty * 2;
            totalqty.setText(finalQty + "");
            totalamt.setText(finalAmt + "");
        } catch (Exception edx) {

        }
    }

    public static void ResttotalField() {
        int i = 1;

        while (i <= 10) {
            int tstart = 1000 * i;
            int tend = tstart * 900;
            String newString = tstart + "_" + tend;
            JTextField qtyField = totalField.get("Q" + newString);
            qtyField.setText("");
            JTextField amtField = totalField.get("A" + newString);
            amtField.setText("");
            totalqty.setText("");
            totalamt.setText("");
            i++;
        }
    }

    public void inputSystem(int p, JTextField jf) {
        try {
            if (multi.isSelected()) {
                if ("".equals(subSeriesNo.getText()) && Dashboard.multiSeries.size() <= 0) {
                    JOptionPane.showMessageDialog(null, "Please select sereis first");

                } else {

                    String index = "" + p;
                    int tQty = 0;
                    int tPoint = 0;

                    switch (NSystems.getText()) {
                        case "cross":
                            ArrayList<String> numb = Dashboard.cross(p);

                            String K;
                            for (int i = 0; i < numb.size(); i++) {
                                K = numb.get(i);
                               // System.out.println("Cross K " + K);
                                JTextField temp = jField.get("E_" + K);
                                temp.setText(jf.getText());
                                temp.setBackground(Color.yellow);
                                index = "" + K;
                                tQty = tQty + Integer.parseInt(jf.getText());
                                Dashboard.setNumberMulti(index, jf.getText(), seriesLable.getText(), subSeriesNo.getText(), alls.getText());

                            }

                            break;
                        case "fixed":
                            try {

                                Map<String, String> jString = new HashMap<>();
                                JTextField temp = jField.get("E_" + p);
                                temp.setBackground(Color.yellow);
                                jString.put("num", p + "");
                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                String jsonEmp = gson.toJson(jString);
                                //System.out.println(jsonEmp);
                                String data = httpAPI._jsonRequest("?r=fpNumber", jsonEmp);
                               // System.out.println(data);
                                JSONObject myResponse = new JSONObject(data);

                                int so = 1;
                                while (so <= myResponse.length()) {
                                    JTextField temdp = jField.get("E_" + myResponse.getString("" + so));
                                    temdp.setText(jf.getText());
                                    temdp.setBackground(Color.yellow);
                                    Dashboard.setNumberMulti(myResponse.getString("" + so), temdp.getText(), seriesLable.getText(), subSeriesNo.getText(), alls.getText());
                                    so++;
                                }
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;

                        default:
                            index = "" + p;
                            JTextField temp = jField.get("E_" + p);
                            temp.setBackground(Color.yellow);
                            Dashboard.setNumberMulti(index, temp.getText(), seriesLable.getText(), subSeriesNo.getText(), alls.getText());
                            break;
                    }

//                                tPoint = tQty * 2;
//                                Q1000_1900.setText(tQty + "");
//                                A1000_1900.setText(tPoint + "");
                }
            } else {
                String index = "" + p;
                int tQty = 0;
                int tPoint = 0;

                switch (NSystems.getText()) {
                    case "cross":
                        ArrayList<String> numb = Dashboard.cross(p);
                        String K;
                        for (int i = 0; i < numb.size(); i++) {
                            K = numb.get(i);
                            JTextField temp = jField.get("E_" + K);
                            temp.setText(jf.getText());
                            temp.setBackground(Color.yellow);
                            index = "" + K;
                            tQty = tQty + Integer.parseInt(jf.getText());
                            Dashboard.setNumber(index, jf.getText(), seriesLable.getText(), subSeriesNo.getText());

                        }

                        break;
                    case "fixed":
                        try {

                            Map<String, String> jString = new HashMap<>();
                            JTextField temp = jField.get("E_" + p);
                            temp.setBackground(Color.yellow);
                            jString.put("num", p + "");
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            String jsonEmp = gson.toJson(jString);
                            //System.out.println(jsonEmp);
                            String data = httpAPI._jsonRequest("?r=fpNumber", jsonEmp);
                            //System.out.println(data);
                            JSONObject myResponse = new JSONObject(data);

                            int so = 1;
                            while (so <= myResponse.length()) {
                                JTextField temdp = jField.get("E_" + myResponse.getString("" + so));
                                temdp.setText(jf.getText());
                                temdp.setBackground(Color.yellow);
                                Dashboard.setNumber(myResponse.getString("" + so), temdp.getText(), seriesLable.getText(), subSeriesNo.getText());
                                so++;
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;

                    default:
                        index = "" + p;
                        JTextField temp = jField.get("E_" + p);
                        temp.setBackground(Color.yellow);
                        Dashboard.setNumber(index, temp.getText(), seriesLable.getText(), subSeriesNo.getText());
                        break;
                }

            }
            Dashboard.calculateTotal();
        } catch (Exception ex) {

        }
    }

    private void getPreviousNumber(JButton B0) {
        try {
            JTextField temp;
            String MainSeries = seriesLable.getText();
            // System.out.println(Dashboard.series.get("1000-1900"));
            Map<String, Map> subSeries = Dashboard.series.get(MainSeries);
            //System.out.println(subSeries.get("1000-1099"));
            String s[] = B0.getText().split("-");
            Map<String, ArrayList> aMap = subSeries.get(s[0]);
            ArrayList<Map> aListMap = aMap.get(s[0]);
            for (Map aListMap1 : aListMap) {
                Map<String, String> fi = aListMap1;
                for (Map.Entry<String, String> entry : fi.entrySet()) {
                    //System.out.println(entry.getKey());
                    temp = jField.get("E_" + entry.getKey());
                    temp.setText(entry.getValue());
                    temp.setBackground(Color.yellow);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void resetFinalTotal() {
        for (int i = 1000; i <= 10990; i = i + 1000) {
            int t = i + 900;
            //System.out.println("Q" + i + "_" + t);
            JTextField tm = totalField.get("Q" + i + "_" + t);
            tm.setText("");
            tm = totalField.get("A" + i + "_" + t);
            tm.setText("");

        }

    }

    private static boolean checkSubSeries(String btxt, String text) {
        boolean r = false;
        try {
            Map<String, Map> subSeries = Dashboard.series.get(text);
            String s[] = btxt.split("-");
            Map<String, ArrayList> aMap = subSeries.get(s[0]);
            ArrayList<Map> aListMap = aMap.get(s[0]);
            if (aListMap.size() > 0) {
                r = true;
            } else {
                r = false;
            }
        } catch (Exception ex) {

        }
        return r;

    }

    private static ArrayList<String> cross(int p) {
        String index = "" + p;
        ArrayList<String> num = new ArrayList<>();
        try {
            int last = (((p / 10) + 1) * 10) - 1;
            int rightbottom = last - p; //bottom right difference
            int back = (p / 10) * 10;
            int leftbottom = p - back;//bottom left

            num.add("" + p);
            int K = p + 11;
            int s = 1;
            while (K <= 99 && s <= rightbottom) {

                num.add("" + K);
                K = K + 11;
                s++;
            }
            K = p - 11;
            s = 1;
            while (K >= 0 && s <= rightbottom) {

                num.add("" + K);
                K = K - 11;
                s++;
            }
            K = p + 9;
            s = 1;
            while (K <= 99 && s <= leftbottom) {

                num.add("" + K);
                K = K + 9;
                s++;
            }
            K = p - 9;
            s = 1;
            while (K > 0 && s <= leftbottom) {

                num.add("" + K);
                K = K - 9;
                s++;
            }
            //int rightbottom = last - p; //right difference
            //index = "" + p;
            //System.out.println(num);
        } catch (Exception ex) {

        }
        return num;
    }

    private void updateBalance() {
        Thread Balance = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Map<String, String> jsonData = new HashMap<>();
                        jsonData.put("userid", userid.getText());
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonEmp = gson.toJson(jsonData);
                        //System.out.println(jsonEmp);
                        String data = httpAPI._jsonRequest("?r=UpdateBalance", jsonEmp);
                        JSONObject myResponse = new JSONObject(data);
                        if (myResponse.getString("status").equals("1")) {
                            balance.setText(myResponse.getString("balance"));
                        } else {
                            balance.setText(myResponse.getString("balance"));
                        }
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Balance Thread Error " + e.getMessage());
                    }
                }
            }
        };
        Balance.start();
    }

    private void resetAll() {
        try {
            subSeriesNo.setText("");
            alls.setText("");
            CMulti.setText("");
            NSystems.setText("");

            multi.setSelected(false);
            cross.setSelected(false);
            odd.setSelected(false);
            even.setSelected(false);
            fixed.setSelected(false);

            totalamt.setText("");
            totalqty.setText("");
            Dashboard.advance.setText("false");
            Dashboard.advanceDraw.clear();
            Dashboard.advanceDrawArray.clear();
            this.selectSubSeries(B0);
            this.selectAll(Color.WHITE);
            resetVarticalInput();
            resetHorizontalInput();
            if (Dashboard.series.size() >= 0) {
                Dashboard.series.clear();
                seriesLable.setText("1000-1900");
                Dashboard.selectDefaultSeries(0);
                this.selectSubSeries(B0);
            }
            if (Dashboard.multiSeries.size() >= 0) {
                Dashboard.multiSeries.clear();
            }
            this.lastTransaction();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void resultBoard(String srs) {
        try {
            resultPane.removeAll();
            resultPane.repaint();
            Map<String, String> finalMap = new HashMap<>();
            String ids[] = id.getText().split("_");
            finalMap.put("drawid", ids[1]);
            finalMap.put("series", srs);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonEmp = gson.toJson(finalMap);
            //System.out.println(jsonEmp);
            String Data = httpAPI._jsonRequest("?r=singleResult", jsonEmp);

            ArrayList<Map> wPoint = singleResult.singleResultJSONPrint(Data);

            int ip = 0;
            int x = 10;
            int y = 5;
            int a = 79;
            int b = 29;

            String ColorArray[] = new String[]{"212,133,194", "130,180,126", "122,180,232", "91,163,106", "217,141,129", "185,177,230", "234,158,123", "164,204,90", "201,189,175", "23,188,189"};
            // resultPane.setLayout()
            //resultPane.setLayout(new FlowLayout());
            for (int j = 0; j < wPoint.size(); j++) {
                Map<String, String> dPoint = wPoint.get(j);
                int ks = 0;
                //System.out.println("Data \n" + dPoint);
                String subSeries[] = null;
                for (Map.Entry<String, String> finas : dPoint.entrySet()) {
                    if (finas.getKey().equals("series")) {
                        subSeries = finas.getValue().split("-");
                    }
                }
                for (Map.Entry<String, String> finas : dPoint.entrySet()) {
                    if (finas.getKey().equals("series")) {
                        //subSeries = finas.getValue().split("-");
                    } else {
                        int key = Integer.parseInt(finas.getKey());
                        int i = Integer.parseInt(subSeries[0]) + (100 * key);
                        int fl = i + Integer.parseInt(finas.getValue());
                        //System.out.println("" + fl);
                        JLabel jLable = new JLabel("" + fl);
                        jLable.setBounds(x, y, a, b);
                        jLable.setFont(new java.awt.Font("Monospaced", 1, 30)); // NOI18N
                        String col[] = ColorArray[ks].split(",");
                        //System.out.println(ColorArray[ks]);
                        jLable.setOpaque(true);
                        jLable.setBackground(new java.awt.Color(Integer.parseInt(col[0]), Integer.parseInt(col[1]), Integer.parseInt(col[2])));
                        jLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLable.setText("" + fl);
                        jLable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        resultPane.add(jLable);

                        if (ip == 9) {
                            y = 30 + y;
                            x = 10;
                            ip = -1;
                        } else {
                            x = 80 + x;
                            //break;
                        }
                        ip++;

                        ks++;

                    }
                }

            }
//            try {
//                Thread.sleep(20000);
//            } catch (InterruptedException ex) {
//
//            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
//        try {
//            Thread t = new Thread() {
//                @Override
//                public void run() {
//                    if (true) {
//                        
//                    }
//                }
//            };
//            t.start();
//        } catch (Exception ex) {
//            System.out.println();
//        }
    }

    public void setLabelColor() {
        result.setOpaque(true);
        result.setBackground(new java.awt.Color(141, 235, 237));
        account.setOpaque(true);
        account.setBackground(new java.awt.Color(141, 235, 237));
        operator.setOpaque(true);
        operator.setBackground(new java.awt.Color(141, 235, 237));
        reprint.setOpaque(true);
        reprint.setBackground(new java.awt.Color(141, 235, 237));
        cancel.setOpaque(true);
        cancel.setBackground(new java.awt.Color(141, 235, 237));
        password.setOpaque(true);
        password.setBackground(new java.awt.Color(141, 235, 237));
        complaint.setOpaque(true);
        complaint.setBackground(new java.awt.Color(141, 235, 237));
        singout.setOpaque(true);
        singout.setBackground(new java.awt.Color(141, 235, 237));

    }

    public void loadPrinter() {
        try {
            printer.setVisible(true);
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

            PrintService printServices[] = PrintServiceLookup.lookupPrintServices(
                    flavor, pras);
            boolean flag = true;
            int ip = 0;
            int x = 10;
            int y = 20;
            int a = 100;
            int b = 15;
            ButtonGroup bg = new ButtonGroup();
            for (PrintService printerService : printServices) {
                JRadioButton jButtong = new JRadioButton(printerService.getName());
                if (flag) {
                    jButtong.setBounds(x, y, a, b);
                    jButtong.setSelected(true);
                    flag = false;
                    printer.setText(printerService.getName());
                } else {
                    jButtong.setBounds(x, y, a, b);
                }
                jButtong.setBackground(new Color(255, 255, 255));
                jButtong.setText(printerService.getName());
                jButtong.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        printer.setText(jButtong.getText());
                    }
                });
                if (ip == 0) {
                    y = 15 + y;
                    x = 10;
                    ip = -1;
                } else {
                    x = 100 + x;
                    //break;
                }
                ip++;
                bg.add(jButtong);
                printerPanel.add(jButtong);

                //System.out.println("Printer = " + printerService.getName());
            }

        } catch (Exception ex) {

        }
    }

    public void lastTransaction() {
        try {
            Map<String, String> finalMap = new HashMap<>();
            finalMap.put("userid", userid.getText());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String finalData = gson.toJson(finalMap);
            String data = httpAPI._jsonRequest("?r=lastTransaction", finalData);
            JSONObject myResponse = new JSONObject(data);
            last.setText(myResponse.getString("last"));
            lastamt.setText("Rs. " + myResponse.getString("lastamt"));
        } catch (Exception ex) {

        }
    }
}
