

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ZebConn 
{
    private DataOutputStream DATA_OUT;
    private Socket SOCKET;
    private String command;
    
    private String IP;
    private int port;
    
    
    public ZebConn(String IP, int port)
    { 
        this.IP = IP;
        this.port = port;
    }
    public void setCommand(String command)
    {
        this.command = command;
    }
    public String getCommand()
    {
        return command;
    }
    public void setPrinter()
    {
        try
        {
            SOCKET = new Socket(IP,port);
            DATA_OUT = new DataOutputStream(SOCKET.getOutputStream());
            DATA_OUT.writeBytes(command);
            SOCKET.close();
            System.out.println("Printed: " + command);
        }
        catch(IOException exp)
        {
            System.out.println("ZebConn Class Error, Printer IO");
            exp.printStackTrace();
        }
    }
    
}
