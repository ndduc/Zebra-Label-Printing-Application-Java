
import java.io.*;
public class io_write 
{
   private FileWriter in;
   private BufferedWriter out;
   private File file;
   protected String str_input;
   
   public io_write()
   {  
   }
   
   public io_write(String str_input)
   {
       this.str_input = str_input;
   }
   protected void start_ip()
   {
       try
       {
           file = new File("files\\ip.txt");
            in = new FileWriter(file);
           out = new BufferedWriter(in);
           out.append(str_input);
           out.close();
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }
   }
   
   protected void start_TCP()
   {
       try
       {
           file = new File("files\\tcp.txt");
            in = new FileWriter(file);
           out = new BufferedWriter(in);
           out.append(str_input);
           out.close();
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }
   }
   
   protected void start_Instance()
   {
       try
       {
           file = new File("files\\instance.txt");
            in = new FileWriter(file);
           out = new BufferedWriter(in);
           out.append(str_input);
           out.close();
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }
   }
   
   protected void start_Database()
   {
       try
       {
           file = new File("files\\data.txt");
            in = new FileWriter(file);
           out = new BufferedWriter(in);
           out.append(str_input);
           out.close();
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }
   }
   
   protected void start_ZebIp()
   {
       try
       {
           file = new File("files\\zebip.txt");
            in = new FileWriter(file);
           out = new BufferedWriter(in);
           out.append(str_input);
           out.close();
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }
   }
   protected void start_ZebPort()
   {
       try
       {
           file = new File("files\\zebport.txt");
            in = new FileWriter(file);
           out = new BufferedWriter(in);
           out.append(str_input);
           out.close();
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }
   }
   
}
