
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.text.DecimalFormat;
public class GUI_Print 
{
    private final JTextField jtfPrice;
    private final JTextField jtfDescription;
    private final JTextField jtfUpc;
    private final JLabel lblPrice;
    private final JLabel lblDescription;
    private final JLabel lblUpc;
    private final JLabel lblQty;
    private JTextField jtfNum;
    private final JFrame frame_Main;
    private final JPanel pnl_Main_1;
    private final Font ftFont;
    
    static boolean shouldFill = true;
    static boolean shouldWeightx = true;
    static boolean RIGHT_TO_LEFT = false;
    
    io_read read = new io_read();
    
    public GUI_Print()
    {
        ftFont = new Font("Calibri",Font.BOLD,40);
        frame_Main = new JFrame();
        frame_Main.setLayout(null);
        frame_Main.setSize(1280, 1024);
        frame_Main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame_Main.setResizable(true);
        
        pnl_Main_1 = new JPanel();
        pnl_Main_1.setLayout(null);
        
        jtfUpc = new JTextField(20);
        jtfUpc.setPreferredSize(new Dimension(500,50));
        jtfUpc.addActionListener(action);
        jtfUpc.setFont(ftFont);
        jtfDescription = new JTextField(17);
        jtfDescription.setPreferredSize(new Dimension(500,50));
        jtfDescription.setEditable(false);
        jtfDescription.setFont(ftFont);
        jtfPrice = new JTextField(20);
        jtfPrice.setPreferredSize(new Dimension(500,50));
        jtfPrice.setEditable(false); 
        jtfPrice.setFont(ftFont);
        lblUpc = new JLabel("UPC: ");
        lblUpc.setFont(ftFont);
        lblDescription = new JLabel("Description: ");
        lblDescription.setFont(ftFont);
        lblPrice = new JLabel("Price: ");
        lblPrice.setFont(ftFont);
        
        
        lblQty = new JLabel();
        lblQty.setText("Print Number:");
        lblQty.setFont(ftFont);
        lblQty.setEnabled(false);
        lblQty.setVisible(false);
        
        jtfNum = new JTextField();
        jtfNum.setText("1");
        jtfNum.setPreferredSize(new Dimension(0,50));
        jtfNum.setFont(ftFont);
        jtfNum.setEnabled(false);
        jtfNum.setVisible(false);

        addComponensToPane(frame_Main.getContentPane());
        frame_Main.setVisible(true);
    }
    Action action = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int check = Integer.parseInt(jtfNum.getText());
            System.out.println(check);
            try
            {
                if (jtfUpc.getText().equalsIgnoreCase("list"))
                {
                    clear();
                }
                else if (jtfUpc.getText().equalsIgnoreCase("exit"))
                    exit();
                else if (jtfUpc.getText().equalsIgnoreCase("update") || jtfUpc.getText().equalsIgnoreCase("up"))
                {
                    clear();
                }
                else if (jtfUpc.getText().equalsIgnoreCase("mod"))
                {
                    clear();
                    GUI_Mod g = new GUI_Mod();
                }
                else if (jtfUpc.getText().equalsIgnoreCase("setup"))
                {
                    GUI_IpSetup g = new GUI_IpSetup();
                    clear();
                }
                else if (jtfUpc.getText().equalsIgnoreCase("qty") )
                {
                    jtfNum.setEnabled(true);
                    jtfNum.setVisible(true);
                    lblQty.setEnabled(true);
                    lblQty.setVisible(true);
                    jtfUpc.setText("");
                   
                }
                else if (jtfUpc.getText().equalsIgnoreCase("cancel"))
                {
                    jtfNum.setEnabled(false);
                    jtfNum.setVisible(false);
                    lblQty.setEnabled(false);
                    lblQty.setVisible(false);
                    
                    jtfUpc.setText("");
                }
                else if(jtfNum.isEnabled() == true && check > 1)
                {
                    for (int i = 0; i < check; i++)
                    {
                        setStatement();
                        
                    }
                    clear();
                }
                else if(jtfNum.isEnabled() == true && check <= 1)
                {
                    setStatement();
                    clear();
                }    
                else
                {
                    setStatement();
                    clear();
                }
            }
            catch(IOException exp)
            {}
        }
    };
    private final DecimalFormat decFormat = new DecimalFormat(".00"); 
    
    private void addComponensToPane(Container pane)
    {
        if(RIGHT_TO_LEFT)
        {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if(shouldFill)
        {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        if(shouldWeightx)
        {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,60,0,0);  
        pane.add(lblUpc,c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(40,60,0,0);  
        pane.add(lblDescription, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(40,60,0,0);  
        pane.add(lblPrice, c);
        
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(40,60,0,0);  
        pane.add(lblQty, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,0,0,100);  
        c.gridx = 1;       
        c.gridy = 0;      
        pane.add(jtfUpc,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(40,0,0,100);  
        c.gridx = 1;       
        c.gridy = 1;      
        pane.add(jtfDescription,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(40,0,0,100);  
        c.gridx = 1;       
        c.gridy = 2;      
        pane.add(jtfPrice,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(40,0,0,700);  
        c.gridx = 1;       
        c.gridy = 3;      
        pane.add(jtfNum,c);
    
    }
    
    
    private void setStatement() throws IOException
    { 
        String TSQL = 
        "SELECT P.upc, P.description, P.normal_price, COALESCE(LEFT(S.section_name,11),'') as section_name "
                + "FROM Products AS P "
                + "FULL OUTER JOIN Sections AS S "
                + "ON P.section = S.section "
                + "WHERE P.upc = '"+ upcFormatV2() +"'  "
                + "AND P.active <> 0 "
                + "ORDER BY P.upc ASC;";
        
        SQLConn connection = new SQLConn();     
            try
            {
                Statement tsql = connection.con().createStatement();
                ResultSet rs = tsql.executeQuery(TSQL);
            
                if(rs.next())
                {
                    String description = rs.getString("Description");
                    jtfDescription.setText(description);
                    Double price = rs.getDouble("normal_price");
                    String strPrice = price.toString();
                    jtfPrice.setText(strPrice);
                    String strSection = rs.getString("section_name");
                    String upc = rs.getString("upc");
                    String upc_Sub = "0";
                    String upc_F = upc + upc_Sub;
                    
                    Zeb_ZPL zpl = new Zeb_ZPL(upc_F,description,decFormat.format(price), strSection);
                    zpl.setCommand_Wire();
                    ZebConn Z = new ZebConn(read.read_ZebIp(), Integer.parseInt(read.read_ZebPort()));
             
                    System.out.println("Debug: zpl class, print: " + zpl.getCommand());
                    Z.setCommand(zpl.getCommand());
                    Z.setPrinter();
                    connection.con().close();
                }                                   
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }      
            
    }
    private String upcFormatV2()
    {
        return String.format("%013d", Long.parseLong(jtfUpc.getText()));
    }
    
    public void clear()
    {
        jtfUpc.setText("");   
        jtfUpc.requestFocus();
    }
    public void exit(){System.exit(0);}
   
}
