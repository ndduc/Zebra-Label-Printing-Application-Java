


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class GUI_Mod implements ActionListener
{
    private static final int W = 420;
    private static final int H = 260;
    
    private final JTextField jtfLine1;
    private final JTextField jtfLine2;
    private final JTextField jtfLine3;
    private final JTextField jtfLine4;
    private final JTextField jtfLine5;
    private final JButton btnPrint;
    private final JTextField jtfNum;
    
    private JFrame frame;
    
    io_read read = new io_read();
    public GUI_Mod()
    {
        frame = new JFrame();
        frame.setLayout(null);
        jtfLine1 = new JTextField(23);
        jtfLine2 = new JTextField(30);
        jtfLine3 = new JTextField(30);;
        jtfLine4 = new JTextField(30);
        jtfLine5 = new JTextField(30);
        jtfNum = new JTextField(5);
        jtfNum.setText("1");
        btnPrint = new JButton("Print");
        btnPrint.addActionListener(this);
        addComponentPane(frame.getContentPane());
        
        frame.setTitle("Free Print Form");
        frame.setSize(W, H);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        frame.setVisible(true);        
    }
    private void addComponentPane(Container pane)
    {
        pane.setLayout(new GridLayout(7,0));
        
        JPanel pnl_Flow01 = new JPanel(new FlowLayout());
        pnl_Flow01.add(new JLabel("Line 1: "));
        pnl_Flow01.add(jtfLine1);
        JPanel pnl_Flow02 = new JPanel(new FlowLayout());
        pnl_Flow02.add(new JLabel("Line 2: "));
        pnl_Flow02.add(jtfLine2);
        JPanel pnl_Flow03 = new JPanel(new FlowLayout());
        pnl_Flow03.add(new JLabel("Line 3: "));
        pnl_Flow03.add(jtfLine3);
        JPanel pnl_Flow04 = new JPanel(new FlowLayout());
        pnl_Flow04.add(new JLabel("Line 4: "));
        pnl_Flow04.add(jtfLine4);
        JPanel pnl_Flow05 = new JPanel(new FlowLayout());
        pnl_Flow05.add(new JLabel("Line 5: "));
        pnl_Flow05.add(jtfLine5);
        JPanel pnl_Flow06 = new JPanel(new FlowLayout());
        pnl_Flow06.add(new JLabel("QTY: "));
        pnl_Flow06.add(jtfNum);
        
        JPanel pnl_Flow07 = new JPanel(new FlowLayout());
        pnl_Flow07.add(btnPrint);
       
        pane.add(pnl_Flow01);
        pane.add(pnl_Flow02);
        pane.add(pnl_Flow03);
        pane.add(pnl_Flow04);
        pane.add(pnl_Flow05);
        pane.add(pnl_Flow06);
        pane.add(pnl_Flow07);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int convert = Integer.parseInt(jtfNum.getText());
        if(e.getActionCommand().equalsIgnoreCase("Print") && convert > 1 )          
        {
            try
            {
                for (int i = 0; i < convert; i++)
                {
                setStatement();
                }
            }
            catch(IOException exp)
            {
                exp.printStackTrace();
            }
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Print") && (convert == 1 || convert == 0) )
        {
            try
            {
                setStatement();
            }
            catch(IOException exp)
            {
                exp.printStackTrace();
            }
        }
    }
    private void setStatement() throws IOException
    { 
        Socket clientSocket=new Socket(read.read_ZebIp(),Integer.parseInt(read.read_ZebPort()));
                    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream() );

                    //Description /Start first
                    String cmdLine1_01 = "^FO10,30";     //Position x , y| x: horizontal   y: vertical 
                    String cmdLine1_02 = "^A050,40";     //Font x , y | x: Style       y: Size
                    String cmdLine1_03 = "^FD" + jtfLine1.getText(); //Command to print description //FD:

                    //Price
                    String cmdLine2_01 = "^FO10,80";
                    String cmdLine2_02 = "^A050,30";
                    String cmdLine2_03 = "^FD" + jtfLine2.getText();
                    
                    String cmdLine3_01 = "^FO10,130";
                    String cmdLine3_02 = "^A050,30";
                    String cmdLine3_03 = "^FD" + jtfLine3.getText();
                    
                    String cmdLine4_01 = "^FO10,180";
                    String cmdLine4_02 = "^A050,30";
                    String cmdLine4_03 = "^FD" + jtfLine4.getText();
                    
                    String cmdLine5_01 = "^FO10,230";
                    String cmdLine5_02 = "^A050,30";
                    String cmdLine5_03 = "^FD" + jtfLine5.getText();
                            
                    
                    String cmdNext = "^FS"; //next line
                    String cmdEnd = "^XZ"; //end line
                    String cmdStart = "^XA"; //start line
                    
                    String command = 
                            cmdStart + cmdLine1_01 + cmdLine1_02 + cmdLine1_03 +
                            cmdNext + cmdLine2_01 + cmdLine2_02 + cmdLine2_03 +
                            cmdNext + cmdLine3_01 + cmdLine3_02 + cmdLine3_03 +
                            cmdNext + cmdLine4_01 + cmdLine4_02 + cmdLine4_03 +
                            cmdNext + cmdLine5_01 + cmdLine5_02 + cmdLine5_03 +
                            cmdEnd;
                   outToServer.writeBytes(command);
                    clientSocket.close();         
    }             
    public void clear()
    {
        jtfLine1.setText("");
        jtfLine2.setText("");
        jtfLine3.setText("");
        jtfNum.setText("1");
        jtfLine1.requestFocus();
    }
}

