import java.net.*;
import java.util.*;
import java.io.*;

public class MultiServer extends Thread{

    private static List<PrintWriter> clients = new LinkedList<PrintWriter>();
    
    public static void main(String[] args){
        
        try{
            int port = Integer.parseInt(args[0]);
            ServerSocket serverSocket = new ServerSocket(port);
            new MultiServer().start();
            System.err.println("Waiting for a client to connect");
            while(true){
            Socket socket = serverSocket.accept();
            synchronized(clients){
                clients.add(new PrintWriter(socket.getOutputStream(), true));
            }
            System.err.println("Accepted connection on port " + port);
            new ReadWriteThread(socket.getInputStream(), System.out).start();
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("\nUsage: java Server <port>");
        }
    }

    public void run(){
        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNextLine()){
            String line = stdin.nextLine();
            synchronized(clients){
                for(PrintWriter client : clients){
                    client.println(line);
                }
            }
        }
    }
}
