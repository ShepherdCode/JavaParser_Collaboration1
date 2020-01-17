import java.io.*;
import java.nio.*;
import java.util.*;

/**
 * Write a description of class JeffryAndBrady here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JeffryAndBrady
{
    BufferedReader reader;
    String filename;
    String delimiters = " ";

    /**
     * Constructor for objects of class JavaParser.
     * @param filename Name of file to read. Current directory assumed.
     */
    public JeffryAndBrady(String filename) {
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
        JeffryAndBrady jb = new JeffryAndBrady("JeffryAndBrady.java");
        try {
            jb.openFile();
            ArrayList<String> parsedFile = jb.buildWordList();
            Collections.sort(parsedFile);
            for (String word : parsedFile)
            {
            System.out.println(word);
        }
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: cannot open "+jb.getFilename());
        } catch (IOException e) {
            System.err.println("ERROR: while reading "+jb.getFilename());
        }
    }   
    public ArrayList<String> buildWordList() throws IOException
    {
        ArrayList<String> entireFile = new ArrayList<String>();
        String line;
        if (reader!=null) {
            do {  
                line=reader.readLine();
                if (line != null) {
                    for (String word: splitLine(line)){
                        entireFile.add(word);
                    };
                }
            } while (line != null);
        }
        return entireFile;
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
                    for (String word: splitLine(line)){
                    
                    };
                }
            } while (line != null);
        }
    }
    /**
     * Break the given string into words.
     * Use the delimiter that belongs to this.
     * On each word, call printout().
     */
    public ArrayList<String> splitLine (String oneline) {
        ArrayList<String> wordList = new ArrayList<String>();
        String word;
        StringTokenizer splitter = new StringTokenizer (oneline,delimiters);
        while (splitter.hasMoreTokens()) {
            word = splitter.nextToken();
            wordList.add(word);
        }
        return wordList;
    }
    /**
     * Send the given string to the console.
     */
    public void printout (String s) {
        System.out.println(s);
    }
}