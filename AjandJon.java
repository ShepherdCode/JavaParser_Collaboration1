import java.io.*;
import java.nio.*;
import java.util.*;

/**
 * Copied from JavaParser.
 * Parses a Java program into individual words and sorts them alphabetically.
 *
 * @author Jason Miller, Aj & Jon Moody
 * @version 1.0
 */
public class AjandJon{
    BufferedReader reader;
    String filename;
    String delimiters = " ";
    ArrayList<String> words = new ArrayList<String>();
    
    /**
     * Constructor for objects of class JavaParser.
     * @param filename Name of file to read. Current directory assumed.
     */
    public AjandJon(String filename) {
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
        AjandJon jp = new AjandJon("AjandJon.java");
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
     * After all words have been read, sort the ArrayList in alphabetical order
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
            Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
            System.out.println(words);
        }
    }
    /**
     * Break the given string into words.
     * Use the delimiter that belongs to this.
     * On each word, call addToList().
     */
    public void printWordByWord (String oneline) {
        String word;
        StringTokenizer splitter = new StringTokenizer (oneline,delimiters);
        while (splitter.hasMoreTokens()) {
            word = splitter.nextToken();
            addToList(word);
        }
    }
    /**
     * Send the given string to the Array List
     */
    public void addToList (String s) {
        words.add(s);
    }
}