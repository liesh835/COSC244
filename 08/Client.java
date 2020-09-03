import java.net.*;

public class Client{

    public static void main(String [] args){
        try{
            int port = Integer.parseInt(args[0]);
            Socket socket = new Socket(args[1], port);
            System.err.println("Conected to " + args[1] + " on port " + port);
            new ReadWriteThread(System.in, socket.getOutputStream()).start();
            new ReadWriteThread(socket.getInputStream(), System.out).start();
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\nUsage: java Server <port>");
        }
    }
}
