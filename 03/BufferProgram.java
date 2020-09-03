import java.io.*;

public class BufferProgram{

    public static void main(String [] args){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));;

        try{
            
            String readIn = in.readLine();

            while(readIn != null){
                StringBuilder sb = new StringBuilder(readIn);
                sb.reverse();
                System.out.println(sb);
                readIn = in.readLine();
            }
        }
        
        catch(IOException e){
            System.out.println(e);
        }
    }
}
