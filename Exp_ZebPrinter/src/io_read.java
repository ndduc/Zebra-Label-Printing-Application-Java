
import java.io.*;
public class io_read 
{
  
   private BufferedReader read;
   private FileReader read_file;
   private File file;
   protected String output;
   public io_read()
   {

   }
   protected String read_ip()
   {
       try
       {
            file = new File("files\\ip.txt");
            read_file = new FileReader(file);
            read = new BufferedReader(read_file); 
            output = read.readLine();
            System.out.println("Read Ip Test: "+output);
            read_file.close();
            read.close();    
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }   
       return output;
   }
   protected String read_TCP()
   {
       try
       {
            file = new File("files\\tcp.txt");
            read_file = new FileReader(file);
            read = new BufferedReader(read_file); 
            output = read.readLine();
            System.out.println("Read TCP Test: "+output);
            read_file.close();
            read.close();    
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }   
       return output;
   }
   
   protected String read_Instance()
   {
       try
       {
            file = new File("files\\instance.txt");
            read_file = new FileReader(file);
            read = new BufferedReader(read_file); 
            output = read.readLine();
            System.out.println("Read instance Test: "+output);
            read_file.close();
            read.close();    
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }   
       return output;
   }
   protected String read_Data()
   {
       try
       {
            file = new File("files\\data.txt");
            read_file = new FileReader(file);
            read = new BufferedReader(read_file); 
            output = read.readLine();
            System.out.println("Read data Test: "+output);
            read_file.close();
            read.close();    
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }   
       return output;
   }
   
   protected String read_ZebIp()
   {
       try
       {
            file = new File("files\\zebip.txt");
            read_file = new FileReader(file);
            read = new BufferedReader(read_file); 
            output = read.readLine();
            System.out.println("Read zeb ip Test: "+output);
            read_file.close();
            read.close();    
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }   
       return output;
   }
   protected String read_ZebPort()
   {
       try
       {
            file = new File("files\\zebport.txt");
            read_file = new FileReader(file);
            read = new BufferedReader(read_file); 
            output = read.readLine();
            System.out.println("Read zeb port Test: "+output);
            read_file.close();
            read.close();    
       }
       catch(IOException exp)
       {
           exp.printStackTrace();
       }   
       return output;
   }
   
}
