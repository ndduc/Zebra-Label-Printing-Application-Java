
public class io 
{
    private String strIP;
    private String strTCP;
    private String strInstance;
    private String strDatabaseName;
    private String strZebIp;
    private String strZebPort;
    io_read t = new io_read();
    
    public io()
    {}
    public io(String strIP)
    {
        this.strIP = strIP;
    }
    public io (String strIP, String strTCP, String strInstance, String strDatabaseName , String strZebIp, String strZebPort)
    {
        this.strIP = strIP;
        this.strTCP = strTCP;
        this.strInstance = strInstance;
        this.strDatabaseName = strDatabaseName;
        this.strZebIp = strZebIp;
        this.strZebPort = strZebPort;
    }
    
    public void setIP(String strIP)
    {
        this.strIP = strIP;
    }
    
    
    public String getIP()
    {
        return strIP;
    }
    
    public void strTCP(String strTCP)
    {
        this.strTCP = strTCP;
    }
    
    public String getTPC()
    {
        return strTCP;
    }
    
    public void setInstance(String strInstance)
    {
        this.strInstance = strInstance;
    }
    
    public String getInstance()
    {
        return strInstance;
    }
    
    public void setDatabaseName(String strDatabaseName)
    {
        this.strDatabaseName = strDatabaseName;
    }
    
    public String getDatabaseName()
    {
        return strDatabaseName;
    }
    
    public void setZebIp(String strZebIp)
    {
        this.strZebIp = strZebIp;
    }
    public String getZebIp()
    {
        return strZebIp;
    }
    
    public void setZebPort(String strZebPort)
    {
        this.strZebPort = strZebPort;
    }
    public String getZebPort()
    {
        return strZebPort;
    }
}
