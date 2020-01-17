import java.io.*;
import java.nio.*;
import java.util.*;

/**
 * Write a description of class CadenAndWilliam here.
 *
 * @author Caden James & William Davis
 * @version 01/17/2020
 */
public class CadenAndWilliam
{
    BufferedReader reader;
    String filename;
    String delimiters = " ";
    ArrayList<String> wordsArray = new ArrayList<String>();

    /**
     * Constructor for objects of class JavaParser.
     * @param filename Name of file to read. Current directory assumed.
     */
    public CadenAndWilliam(String filename) {
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
        CadenAndWilliam jp = new CadenAndWilliam("CadenAndWilliam.java");
        try {
            jp.openFile();
            jp.breakLineByLine();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: cannot open "+jp.getFilename());
        } catch (IOException e) {
            System.err.println("ERROR: while reading "+jp.getFilename());
        }
        jp.alphabetizeArray();
        jp.printout();
    }   
    /**
     * Take input from the reader.
     * Break the input into lines.
     * On each line, call printWordByWord().
     * Do nothing unless openFile() has run successfully.
     */
    public void breakLineByLine() throws IOException {
        String line;
        if (reader!=null) {
            do {  
                line=reader.readLine();
                if (line != null) {
                    arrayWordByWord(line);
                }
            } while (line != null);
        }
    }
    /**
     * Break the given string into words.
     * Use the delimiter that belongs to this.
     * On each word, add it to wordsArray.
     */
    public void arrayWordByWord (String oneline) {
        String word;
        StringTokenizer splitter = new StringTokenizer (oneline,delimiters);
        while (splitter.hasMoreTokens()) {
            word = splitter.nextToken();
            wordsArray.add(word);
        }
    }
    /**
     * Send the strings in wordsArray to the console.
     */
    public void printout () {
        for (int i = 0; i < wordsArray.size(); i++){
            System.out.println(wordsArray.get(i));
        }
    }
    /**
     * alphabetize the wordsArray array.
     */
    public void alphabetizeArray (){
        Collections.sort(wordsArray);
    }
	// hi
}
