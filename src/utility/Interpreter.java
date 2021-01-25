package utility;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 2
 * Okko Partanen
 * 
 * Interpreter is the 'middle man' between user input and the file / log functions.
 * The class calls FileService which in turn executes all manipulation methods on the files.
 * Interpreter tracks the execution times of the methods and calls LogService to save the results in log file.
*/
public class Interpreter {

    private LogService logService;
    private FileService fileService;
    private final String TIMESTAMPFORMAT = "dd.MM.YYYY-HH:mm";

    public Interpreter(){
        this.fileService = new FileService();
        this.logService = new LogService();        
    }

    //calls FileServices word search function and logs the execution time.
    public void searchWord(String word){
        String result = "";
        //get formatted timestamp for log
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        //current system time for calculating execution time
        long startTime = System.currentTimeMillis();
        result = fileService.searchForWord(word);        
        long stopTime = System.currentTimeMillis();
        System.out.println(result);        
        //call logger to write the log        
        logService.writeLog(timeStamp + ": " + result + " Execution time: " + (stopTime - startTime) + "ms\n");
    }
    
    //calls FileServices word count function and logs the execution time.
    public void countWord(String word){
        String result = "";
        //get formatted timestamp for log
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        //current system time for calculating execution time
        long startTime = System.currentTimeMillis();
        result = fileService.countWord(word);        
        long stopTime = System.currentTimeMillis();
        System.out.println(result);        
        //call logger to write the log        
        logService.writeLog(timeStamp + ": " + result + " Execution time: " + (stopTime - startTime) + "ms\n");
    }

    //calls FileServices word count function and logs the execution time.
    public void countLines(){
        String result = "";
        //get formatted timestamp for log
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        //current system time for calculating execution time
        long startTime = System.currentTimeMillis();
        result = fileService.countLines();        
        long stopTime = System.currentTimeMillis();
        System.out.println(result);        
        //call logger to write the log        
        logService.writeLog(timeStamp + ": " + result + " Execution time: " + (stopTime - startTime) + "ms\n");
    }

    //calls FileServices to fill the hashtable with words from the Dracula file and logs execution time.
    public void fillHashTable(){
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        long startTime = System.currentTimeMillis();
        fileService.fillHashTable();
        long stopTime = System.currentTimeMillis();
        String log = timeStamp + ": HashTable constructed and filled with words from the textfile in: " + (stopTime - startTime) + "ms\n";        
        logService.writeLog(log);       
    }

    //calls FileServices to find a word from the hashtable and logs execution time.
    public void searchWordHashTable(String word){
        String result = "";
        //get formatted timestamp for log
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        //current system time for calculating execution time
        long startTime = System.currentTimeMillis();
        result = fileService.findWordHashTable(word);        
        long stopTime = System.currentTimeMillis();
        System.out.println(result);        
        //call logger to write the log        
        logService.writeLog(timeStamp + ": " + result + " Execution time: " + (stopTime - startTime) + "ms\n");
    }    

    //calls FileServices to get a count of how many times a word is in the text (from the hashtable) and logs execution time.
    public void countWordHashTable(String word){
        String result = "";
        //get formatted timestamp for log
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        //current system time for calculating execution time
        long startTime = System.currentTimeMillis();
        result = fileService.countWordHashTable(word);        
        long stopTime = System.currentTimeMillis();
        System.out.println(result);        
        //call logger to write the log        
        logService.writeLog(timeStamp + ": " + result + " Execution time: " + (stopTime - startTime) + "ms\n");
    }

    public void printTextFileName(){
        String result = "";
        //get formatted timestamp for log
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        //current system time for calculating execution time
        long startTime = System.currentTimeMillis();
        result = fileService.printTextFileName();        
        long stopTime = System.currentTimeMillis();
        System.out.println(result);        
        //call logger to write the log        
        logService.writeLog(timeStamp + ": " + result + " Execution time: " + (stopTime - startTime) + "ms\n");
    }

    public void printTextFileSize(){
        String result = "";
        //get formatted timestamp for log
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        //current system time for calculating execution time
        long startTime = System.currentTimeMillis();
        result = fileService.printTextFileSize();        
        long stopTime = System.currentTimeMillis();
        System.out.println(result);        
        //call logger to write the log        
        logService.writeLog(timeStamp + ": " + result + " Execution time: " + (stopTime - startTime) + "ms\n");       
    }    

    public void listFiles(){  
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        long startTime = System.currentTimeMillis();
        fileService.listFiles();
        long stopTime = System.currentTimeMillis();      
        logService.writeLog(timeStamp + ": " + "All files listed." + " Execution time: " + (stopTime - startTime) + "ms\n");         
    }

    public void listFiles(String extension){
        String timeStamp = new SimpleDateFormat(TIMESTAMPFORMAT).format(new Date());
        long startTime = System.currentTimeMillis();
        fileService.listFiles(extension);
        long stopTime = System.currentTimeMillis();      
        logService.writeLog(timeStamp + ": " + "Files with extenstion '" + extension + "' listed." + " Execution time: " + (stopTime - startTime) + "ms\n");      
    }
}