import java.io.*;
public class Caesar{
    public static void main(String [] args){
        InputStream in = System.in;
        OutputStream out = System.out;
        int shift = 0, input = 0;
        
        if (args.length > 0) {
            try {
                shift = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }

        try{
            while((input = in.read()) != -1){
                out.write((input + shift) % 256);
            }
            out.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}

