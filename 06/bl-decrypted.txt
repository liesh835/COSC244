import java.io.*;
import java.util.*;

public class BitLevel{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String key;
        byte [] keys;
        int input = 0, pos = 0;
        

        System.out.println("Enter key:");
        key = sc.next();
        keys = key.getBytes();

        try{
          
            InputStream in = new FileInputStream(args[0]);
            OutputStream out = new FileOutputStream(args[1]);
            
            while((input = in.read()) != -1){
                if(pos == key.length()){
                    pos = 0;
                }
                
                out.write(input ^ keys[pos]);
                pos++;
            }
            out.close();
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
}

        
        
        
