/**
 * This class performs LZW decompression on data read from stdin.  It
 * reads the compressed input from stdin using a BitInputStream which
 * allows a variable width bit field to be used.
 */
public class Decompress {

    /**
     *  The entry point of the program.  Performs LZW decompression on input
     *  read from stdin, and outputs it to stdout.
     *
     * @param  args command line arguments are not used.
     * @exception  Exception  Throws all exceptions (no error handling done)
     */
    public static void main(String[] args) throws Exception {
        int bitFieldSize = 9; // 8 bits for character set + 1 bit for growcode
        BitInputStream in = new BitInputStream(System.in, bitFieldSize);
        LookUpTable table = new LookUpTable(); // initialise the dictionary
        int code;     // the code read from stdin
        String entry = null; // current entry from dictionary
        String prev = null;  // previous entry from dictionary

        /** process the first code value in the compressed file/stream */
        if ((code = in.read())!= -1) {  // if there is input
            entry = table.getString(code); // let entry = table entry for code
            System.out.print(entry);// output entry
        }
      
        /** process the remaining codes in the compressed file/stream */
        while((code = in.read()) != -1){ // while there is input
            if(code == LookUpTable.GROW_CODE){ //    if code is the grow code
                in.setBitFieldSize(++bitFieldSize);
            }else{  //    otherwise
                prev = entry;    //       let prev = entry
                if(table.hasCode(code)){//       if there wasn't a table entry for code then
                    entry = table.getString(code);
                }else{
                    entry = prev + prev.charAt(0); //          let entry = prev + first char of prev
                }
                System.out.print(entry);//       output entry     
                table.add(prev + entry.charAt(0));//       add prev + first char of entry to the table
            }
        }
    }
}

  
    
