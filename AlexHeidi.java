
/**
 * Alex Flamand and Heidi Reichert try the homework.
 * Most work done by Professor Jason Miller, insofar as parsing is concerned.
 *
 * @author Alex Flamand
 * @author Heidi Reichert
 * @version 3
 */

import java.io.*;
import java.nio.*;
import java.util.*;

public class AlexHeidi {
    BufferedReader reader;
    String filename;
    String delimiters = " ";

    /**
     * Constructor for objects of class JavaParser.
     * @param filename Name of file to read. Current directory assumed.
     */
    public static void JavaParser(String filename) {
        this.filename = filename;
    }

    /**
     * Show the filename associated with this class.
     * @return filename that was given to the constructor.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Open the file associated with this class.
     * If a file was already open, this would close it.
     * @return true if the file could be opened.
     */
    public void openFile () throws FileNotFoundException {
        reader = null;
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        reader = new BufferedReader(fr);
    }

    /**
     * Demonstrates how to use this class.
     * Parses this Java program.
     * Assumes the program is in the current directory.
     * @param No parameter is required.
     */
    public static void main (String[] args) {
        JavaParser jp = new JavaParser("JavaParser.java");
        try {
            jp.openFile();
            jp.printLineByLine();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: cannot open "+jp.getFilename());
        } catch (IOException e) {
            System.err.println("ERROR: while reading "+jp.getFilename());
        }
    }   

    /**
     * Take input from the reader.
     * Break the input into lines.
     * On each line, call printWordByWord().
     * Do nothing unless openFile() has run successfully.
     */
    public void printLineByLine() throws IOException {
        String line;
        if (reader!=null) {
            do {  
                line=reader.readLine();
                if (line != null) {
                    printWordByWord(line);
                }
            } while (line != null);
        }
    }

    /**
     * Break the given string into words.
     * Use the delimiter that belongs to this.
     * On each word, call printout().
     */
    public void printWordByWord (String oneline) {
        String word;
        StringTokenizer splitter = new StringTokenizer (oneline,delimiters);
        while (splitter.hasMoreTokens()) {
            word = splitter.nextToken();
            printout(word);
        }
    }
    
     /**
     * Add each string to a String array.
     */
    //String[] = new String[file.length];
    public void fillAray (String oneword) {
        String word;

    //    while (splitter.hasMoreTokens()) {
    //        word = splitter.nextToken();
    //        printout(word);
    //    }
    }

    public int compare (String input1, String input2) {
        int difference = input1.compareTo(input2);
        if(difference > 0) return 1;
        if(difference < 0) return -1;
        return 0;
    }

    /**
     * Send the given string to the console.
     */
    public void printout (String s) {
        System.out.println(s);
    }
    /**
     * Add each string to a String array.
     */
    public void fillAray (String oneword) {
        String word;
        String fileWords[] = new String[filename.length()];
	for(int i=0; i<filename.length(); i++) {
    fileWords[i] = printWordByWord(oneword);
}
    }
}
<<<<<<< HEAD

//WHY MUST WE SUFFER?
=======
// compare each word in String array with the next using the comparison method
// rearrange in array
// print out alphabetically, overriding the original print line-by-line
>>>>>>> 8629716a8f90b47afaa28722440affeb90f20724
