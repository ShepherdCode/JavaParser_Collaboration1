import java.util.*;
import java.io.*;
import java.nio.*;
/**
 * Write a description of class KurtAndZach here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KurtAndZach
{
    // instance variables - replace the example below with your own
    
    BufferedReader reader;
    String filename;
    String delimiters = " ";

     /**
     * Constructor for objects of class JavaParser.
     * @param filename Name of file to read. Current directory assumed.
     */
    public KurtAndZach(String filename) {
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
        KurtAndZach kz = new KurtAndZach("KurtAndZach.java");
        try {
            kz.openFile();
            kz.printLineByLine();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: cannot open "+kz.getFilename());
        } catch (IOException e) {
            System.err.println("ERROR: while reading "+kz.getFilename());
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
            alphabetically(word);
        }
    }
    /**
     * Sorts the given string alphabetically. 
     * Sends the given string to the console.
     */
    public void alphabetically (String s) 
    {
        char[] javp = s.toCharArray();
        Arrays.sort(javp);
        String alphabeticalString = String.valueOf(javp);
        System.out.println(alphabeticalString);
    }
    
}
