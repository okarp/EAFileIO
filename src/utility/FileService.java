package utility;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 2
 * Okko Partanen
 * 
 * FileService class handles the concrete operations on files and printing output -
 * such as searching for a word in text file or constructing hashtable which is used
 * for faster search operations.
 * 
 * FileService class is being called from the interpreter. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class FileService {
    final String SEPERATOR = System.getProperty("file.separator");
    final String PATHTOFILES = "resources" + SEPERATOR + "Files";
    private String[] fileArray;
    private File file;
    private File textFile;
    private Hashtable<String, Integer> hashTable;    

    public FileService(){
        this.file = new File(PATHTOFILES);
        //populate an array with names of the files in the Files folder
        this.fileArray = file.list();
        //path to the Dracula.txt file
        this.textFile = new File(PATHTOFILES + SEPERATOR + "Dracula.txt");
        this.hashTable = new Hashtable<String, Integer>();        
    }
    
    //lists all files in the Files folder
    public void listFiles(){
        try{        
            for (String s: fileArray){
                System.out.println(s);
            }
        }catch (NullPointerException e){
            System.out.println("No files in array. Resources are maybe missing?");
        } 
    }

    //lists all extensions that are found in Files folders files.
    public void listFiles(String extension){ 
        boolean found = false;       
        try{
            for (String s: fileArray){
                //split the fileName string at dot and print out the extension
                String fileName = s.split("\\.")[1];           
                if (fileName.equals(extension)){
                    found = true;
                    System.out.println(s); 
                }               
            }
            //if no file with the given extension was found notify the user
            if (!found)
                System.out.println("Extenstion not found. Use 'ls' to list all files and see available extensions.");
        }catch (NullPointerException e){
            System.out.println("No files in array. Resources are maybe missing?");
        }    
    }

    //searches for given word in the dracula textfile.
    public String searchForWord(String word){
        String returnStr = "";
        boolean found = false;
        try {
            Scanner scanner = new Scanner(textFile);  
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //strip punctuation and make the line lowercase
                String trimmedLine = line.replaceAll("[^A-Za-z']+"," ").toLowerCase();
                //place words in an array and iterate it
                String[] wordArray = trimmedLine.split(" ");
                for (String s: wordArray){
                    if (s.equals(word))
                        found = true;
                    }                
            }
            if (found)
                returnStr = "The word: '" + word + "' was found.";
            else
                returnStr = "The word: '" + word + "' was not found in the textfile.";
            scanner.close();

        } catch(FileNotFoundException e) { 
            returnStr = "Error! Textfile was not found.";            
        }
        return returnStr;           
    }

    //counts the number of times the word appears in the Dracula textfile.
    public String countWord(String word){
        String returnStr = "";
        int count = 0;
        try {
            Scanner scanner = new Scanner(textFile);            
            //read textfile line by line.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String trimmedLine = line.replaceAll("[^A-Za-z']+"," ").toLowerCase();
                String[] wordArray = trimmedLine.split("\\s");
                for (String s: wordArray){                    
                    //if word was found increase counter by one
                    if (s.equals(word))
                        count++;
                }                
            }
            returnStr = "The word '" + word + "' was found " + count + " times.";
            scanner.close();
        } catch(FileNotFoundException e) { 
            returnStr = "Error! Textfile was not found.";            
        }
        return returnStr;                
    }

    //simple method for counting the lines in textfile. Add one to counter on every line and print out the result.
    public String countLines(){
        String returnStr = "";
        try {
            Scanner scanner = new Scanner(textFile);            
            //read line by line
            int lines = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();                
                lines++;                
            }
            returnStr = "The textfile contains " + lines +" lines.";
            scanner.close();
        } catch(FileNotFoundException e) { 
            returnStr = "Error! Textfile was not found";           
        }     
        return returnStr;           
    }
    
    //method for filling Javas hashtable. Words are keys and values are how many times the word occures in the file.
    public void fillHashTable(){        
        try {
            Scanner scanner = new Scanner(textFile);            
            //read textfile line by line.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String trimmedLine = line.replaceAll("[^A-Za-z']+"," ").toLowerCase();
                String[] wordArray = trimmedLine.split("\\s");
                for (String s: wordArray){
                    //If the word is already in the hashtable, increase value by one.
                    if (hashTable.containsKey(s)){                        
                        hashTable.replace(s, hashTable.get(s) + 1);
                    //If word is not in the hashtable, put it in there and set 1 as value.
                    }else{
                        hashTable.put(s, 1);
                    }              
                }
            }
            scanner.close();
            
        }catch(FileNotFoundException e) { 
            System.out.println("Error! Textfile was not found.");            
        }
    }

    //a method for checking if the hashtable (textfile) contains a word
    public String findWordHashTable(String word){        
        if (hashTable.containsKey(word))
            return "The word '" + word + "' found in the hashtable.";
        else
           return "The word was not found in the hashtable.";        
    }

    //a method for checking how many times a word exsists in the hashtable / textfile.
    //in the hashtable words are stored as keys and value is the number of times word is in the textfile.
    public String countWordHashTable(String word){
        if (hashTable.containsKey(word)){
            int res = hashTable.get(word);
            return "The word '" + word + "' was found " + res + " times using hashtable.";
        }else
            return "The word was not found in the hashtable."; 
    }     

    public String printTextFileName(){
        return "Textfiles name is: "+ textFile.getName();
    }

    public String printTextFileSize(){
        return "The textfiles size is: " + textFile.length() +" bytes";
    }
}
