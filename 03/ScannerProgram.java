import java.util.*;
import java.io.*;

public class ScannerProgram{

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String readScan = sc.nextLine();
            readScan = readScan.toUpperCase();
            System.out.println(readScan);
        }
    }
}
