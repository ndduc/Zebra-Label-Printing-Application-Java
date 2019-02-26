
public class Zeb_ZPL 
{
    
    private String upc;
    private final String description;
    private String price;
    private String section;
    private String command;
    
    private final String cmdNext = "^FS"; //next line
    private final String cmdEnd = "^XZ"; //end line
    private final String cmdStart = "^XA"; //start line    
    
    private String cmdUpcV01;
    private String cmdUpcV02;
    private String cmdUpcV03;
    
    protected Zeb_ZPL(String upc, String description, String price, String section)
    {
        this.upc = upc;
        this.description = description;
        this.price = price;
        this.section = section;
    }
    protected Zeb_ZPL(String description)
    {
        this.description = description;
    }
    
    protected void setCommand_Wire()
    {
        String checker = upc.substring(1); //sub remove first character
        System.out.println(checker);
        
        String cmdUpc01 = "^FO120,82 ^BY2,2";  //x ,y | y = Width of UPC in form x^y   //Old x = 100 //"^FO120,82^BY2"
        //String cmdUpc02 = "^B2N,80,Y,N,N";    //x ,y, z, w| y = Heigth of UPC 
        String cmdUpc02 = "^BEN,80,N,N";
        String cmdUpc03 = "^FO30,115";       //Coordinate x and y
        String cmdUpc04 = "^FD" + checker; //+  "^FS";
        
        String lastString = upc.substring(upc.length()-1).toString();
        
        if(lastString.equalsIgnoreCase("0"))
        {
            String checkUpc = upc.substring(0, upc.length()-1);
            cmdUpcV01 = "^FO07,215";
            cmdUpcV02 = "^A050,40";
            cmdUpcV03 = "^FD" + checkUpc;
        }
        else
        {
            String checkUpc = upc;
            cmdUpcV01 = "^FO07,215";
            cmdUpcV02 = "^A050,40";
            cmdUpcV03 = "^FD" + checkUpc;
        }
        //Description /Start first
        String cmdDesc01 = "^FO15,25";     //Position x , y| x: horizontal   y: vertical //Old position = 05,25
        String cmdDesc02 = "^A050,33";     //Font x , y | x: Style       y: Size
        String cmdDesc03 = "^FD" + description; //Command to print description //FD:
        //Price
        String cmdPrice01 = "^FO225, 60";   //old position y = 60
        String cmdPrice02 = "^A050,75";
        String cmdPrice03 = "^FD" + '$'+ price;
        String cmdVendor01 = "^FO230, 160";//old position y = 160
        String cmdVendor02 = "^A050,30";
        String cmdVendor03 = "^FD" + section;
        command =   cmdStart + 
                    cmdDesc01 + cmdDesc02 + cmdDesc03 + 
                    cmdNext +
                    cmdUpc01 + cmdUpc02 + cmdUpc03 + cmdUpc04 + 
                    cmdNext +   
                    cmdPrice01 + cmdPrice02 + cmdPrice03 +
                    cmdNext + 
                    cmdVendor01+ cmdVendor02 + cmdVendor03 +
                    cmdNext +
                    cmdUpcV01 + cmdUpcV02 + cmdUpcV03 +
                    cmdEnd;
    } 
    protected void setCommand_WireLess()
    {
        String cmdUpc01 = "^FO100,100 ^BY1.38,2";  //x ,y | y = Width of UPC in form x^y   //Old x = 100 //"^FO120,82^BY2"
        String cmdUpc02 = "^B2N,40,Y,N,N";    //x ,y, z, w| y = Heigth of UPC 
        //String cmdUpc03 = "^FO1,120";       //Coordinate x and y
        String cmdUpc04 = "^FD" + upc; //+  "^FS";
        //Description /Start first
        String cmdDesc01 = "^FO20,30";     //Position x , y| x: horizontal   y: vertical //Old position = 05,25
        String cmdDesc02 = "^A050,30";     //Font x , y | x: Style       y: Size
        String cmdDesc03 = "^FD" + description; //Command to print description //FD:     
        //Price
        String cmdPrice01 = "^FO270, 80";   //old position y = 60
        String cmdPrice02 = "^A050,90";
        String cmdPrice03 = "^FD" + '$'+ price;     
        //Section
        
        String cmdVendor01 = "^FO270, 170";//old position y = 160
        String cmdVendor02 = "^A050,30";
        String cmdVendor03 = "^FD" + section;     

        command =   cmdStart 
                    + cmdDesc01 + cmdDesc02 + cmdDesc03 + 
                    cmdNext +
                    cmdUpc01 + cmdUpc02 + cmdUpc04 +
                    cmdNext + 
                    cmdPrice01 + cmdPrice02 + cmdPrice03 +
                    cmdNext +
                    cmdVendor01 + cmdVendor02 + cmdVendor03 +
                    cmdEnd;
    }
    
    
    protected String getCommand()
    {
        return command;
    }

    
    
}