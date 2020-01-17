
/**
 * Alex Flamand and Heidi Reichert try the homework.
 * Most work done by Professor Jason Miller, insofar as parsing is concerned.
 * 
 * @author Alex Flamand
 * @author Heidi Reichert
 * @version 17 January 2020
 */

import java.io.*;
import java.nio.*;
import java.util.*;

public class AlexHeidi {
    BufferedReader reader;
    String filename;
    String delimiters = " ";
    ArrayList<String> fileWords = new ArrayList<String>();
    
    /**
     * Constructor for objects of class AlexHeidi.
     * @param filename Name of file to read. Current directory assumed.
     */
    public AlexHeidi(String filename) {
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
     * Take input from the reader.
     * Breaks the input into lines.
     * Do nothing unless openFile() has run successfully.
     */
    public void printLineByLine() throws IOException {
        String line;
        if (reader!=null) {
            do {  
                line=reader.readLine();
                if (line != null) {
                    fillArray(line);
                }
            } while (line != null);
        }
    }

    /**
     * Break the given string into words.
     * Use the delimiter that belongs to this.
     * @param the strings within the file.
     */
    public String breakApart (String oneline) {
        String word;
        StringTokenizer splitter = new StringTokenizer (oneline,delimiters);
        while (splitter.hasMoreTokens()) {
            word = splitter.nextToken();
            return word;
        }
        return "";
    }

    /**
     * Add each broken-up word to an array list containing all words in the file.
     */
    public void fillArray (String word) {
        fileWords.add(breakApart(word));
    }

    /**
     * Use the inbuilt Colllections.sort() method to sort the list in alphabetical order.
     * Suggestion of the use of this method was stated out-loud in the class.
     */
    public void sortAlphabetically () {
        Collections.sort(fileWords);
    }

    /**
     * Send the given string to the console.
     */
    public void print () {
        for(int i=0; i<fileWords.size(); i++) {
            System.out.println(fileWords.get(i));
        }
    }

    /**
     * Demonstrates how to use this class.
     * Parses this Java program. Sorts all words into alphabetical order
     * Assumes the program is in the current directory.
     */
    public static void main (String[] args) {
        AlexHeidi ah = new AlexHeidi("AlexHeidi.java");
        try {
            ah.openFile();
            ah.printLineByLine();
            ah.sortAlphabetically();
            ah.print();
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open "+ah.getFilename());
        } catch (IOException e) {
            System.err.println("Error while reading "+ah.getFilename());
        }
    }   
}