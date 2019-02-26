import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI_IpSetup {
    private JTextField jtfIp;
    private final JLabel lblIp;
    
    private JTextField jtfTCP;
    private final JLabel lblTCP;
    
    private JTextField jtfInstance;
    private final JLabel lblInstance;
    
    private JTextField jtfDatabaseName;
    private final JLabel lblDatabaseName;
    
    private JTextField jtfPath;
    private JLabel lblPath;
    
    private JTextField jtfZebIp;
    private JLabel lblZebIp;
    
    private JTextField jtfZebPort;
    private JLabel lblZebPort;
    
    private final JFrame frame;
    private final JButton btnEnter;
    
    io_read t = new io_read();
   // private final JPanel pnl_Main;
    
    public GUI_IpSetup()
    {
        jtfIp = new JTextField();
        jtfIp.setPreferredSize(new Dimension(200, 30));
        setIp();
        lblIp = new JLabel();
        lblIp.setText("IP address: ");
        lblIp.setPreferredSize(new Dimension(100, 30));
        
        jtfTCP = new JTextField();
        jtfTCP.setPreferredSize(new Dimension(200, 30));
        setTCP();
        lblTCP = new JLabel();
        lblTCP.setText("TCP: ");
        lblTCP.setPreferredSize(new Dimension(100, 30));
        
        jtfDatabaseName = new JTextField();
        jtfDatabaseName.setPreferredSize(new Dimension(200, 30));
        setData();
        lblDatabaseName = new JLabel();
        lblDatabaseName.setText("Database: ");
        lblDatabaseName.setPreferredSize(new Dimension(100, 30));
        
        jtfInstance = new JTextField();
        jtfInstance.setPreferredSize(new Dimension(200, 30));
        setInstance();
        lblInstance = new JLabel();
        lblInstance.setText("Instance: ");
        lblInstance.setPreferredSize(new Dimension(100, 30));
        
        jtfPath = new JTextField();
        jtfPath.setPreferredSize(new Dimension(200, 30));
        lblPath = new JLabel();
        lblPath.setText("Directory: ");
        lblPath.setPreferredSize(new Dimension(100, 30));
        
        jtfZebIp = new JTextField();
        jtfZebIp.setPreferredSize(new Dimension(200, 30));
        setZebIp();
        lblZebIp = new JLabel();
        lblZebIp.setText("Zebra IP: ");
        lblZebIp.setPreferredSize(new Dimension(100, 30));
        
        jtfZebPort = new JTextField();
        jtfZebPort.setPreferredSize(new Dimension(200, 30));
        setZebPort();
        lblZebPort = new JLabel();
        lblZebPort.setText("Zebra Port: ");
        lblZebPort.setPreferredSize(new Dimension(100, 30));
        
        
        
        btnEnter = new JButton("Save");
        btnEnter.setPreferredSize(new Dimension(100, 30));
        btnEnter.addActionListener(enter);
        
        
        
        frame = new JFrame();
        
        frame.setLayout(null);
        frame.setSize(400, 430);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        
        
        addComponentToPane(frame.getContentPane());;
        frame.setVisible(true);
    }
    ActionListener enter = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("save"))
            {
                io i = new io(jtfIp.getText(), jtfTCP.getText(), jtfInstance.getText(), jtfDatabaseName.getText(), jtfZebIp.getText(), jtfZebPort.getText());
                io_write iw1 = new io_write(i.getIP());
                iw1.start_ip();
                io_write iw2 = new io_write(i.getTPC());
                iw2.start_TCP();
                io_write iw3 = new io_write(i.getInstance());
                iw3.start_Instance();
                io_write iw4 = new io_write(i.getDatabaseName());
                iw4.start_Database();
                io_write iw5 = new io_write(i.getZebIp());
                iw5.start_ZebIp();
                io_write iw6 = new io_write(i.getZebPort());
                iw6.start_ZebPort();
            }
        }
    };
    private void addComponentToPane(Container pane)
    {
        pane.setLayout(new GridLayout(11,0));
        
        JPanel pnl_Flow = new JPanel();
        pnl_Flow.setLayout(new FlowLayout());
        pnl_Flow.add(lblIp);
        pnl_Flow.add(jtfIp);
       
        JPanel pnl_Flow_2 = new JPanel();
        pnl_Flow_2.setLayout(new FlowLayout());
        pnl_Flow_2.add(lblTCP);
        pnl_Flow_2.add(jtfTCP);
        
        JPanel pnl_Flow_3 = new JPanel();
        pnl_Flow_3.setLayout(new FlowLayout());
        pnl_Flow_3.add(lblInstance);
        pnl_Flow_3.add(jtfInstance);
        
        JPanel pnl_Flow_4 = new JPanel();
        pnl_Flow_4.setLayout(new FlowLayout());
        pnl_Flow_4.add(lblDatabaseName);
        pnl_Flow_4.add(jtfDatabaseName);
        
        
        JPanel pnl_Flow_5 = new JPanel();
        pnl_Flow_5.setLayout(new FlowLayout());
        pnl_Flow_5.add(lblPath);
        pnl_Flow_5.add(jtfPath);
        
        
        
        
        JPanel pnl_Flow_6 = new JPanel();
        pnl_Flow_6.setLayout(new FlowLayout());
        pnl_Flow_6.add(lblZebIp);
        pnl_Flow_6.add(jtfZebIp);
        
        JPanel pnl_Flow_7 = new JPanel();
        pnl_Flow_7.setLayout(new FlowLayout());
        pnl_Flow_7.add(lblZebPort);
        pnl_Flow_7.add(jtfZebPort);
        
        JPanel pnl_Flow_8 = new JPanel();
        pnl_Flow_8.setLayout(new FlowLayout());
        pnl_Flow_8.add(btnEnter);
        
        pane.add(pnl_Flow);
        pane.add(pnl_Flow_2);
        pane.add(pnl_Flow_3);
        pane.add(pnl_Flow_4);
        pane.add(pnl_Flow_5);
        pane.add(pnl_Flow_6);
        pane.add(pnl_Flow_7);
        pane.add(pnl_Flow_8);
        
    }
    

    
    private void setIp()
    {
        jtfIp.setText(t.read_ip());
    }
    private void setTCP()
    {
        jtfTCP.setText(t.read_TCP());
    }
    private void setInstance()
    {
        jtfInstance.setText(t.read_Instance());
    }
    private void setData()
    {
        jtfDatabaseName.setText(t.read_Data());
    }
    private void setZebIp()
    {
        jtfZebIp.setText(t.read_ZebIp());
    }
    private void setZebPort()
    {
        jtfZebPort.setText(t.read_ZebPort());
    }
}
