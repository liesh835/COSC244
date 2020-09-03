import java.io.*;
public class IOProgram{

    public static void main(String [] args){
        InputStream in = System.in;
        OutputStream out = System.out;

        try{
            int readIn = in.read();
            out.write(readIn);

            while(readIn != -1){
                readIn = in.read();
                out.write(readIn);
            }
        }
            
        catch(IOException e){
            System.out.println(e);
        }
    }
}

