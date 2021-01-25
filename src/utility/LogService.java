package utility;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 2
 * Okko Partanen
 * 
 * LogService is responsible for writing the logs.
 * 
 */

public class LogService {
    
    //path to the logfile    
    final String PATHTOFILE = "Logs/log.txt";  
    private FileWriter myWriter;   

    public void writeLog(String log){        
        try{
            //open the file without overriding current contents
            myWriter = new FileWriter(PATHTOFILE, true);
            myWriter.write(log); 
            myWriter.close();
        }catch(IOException e){
            System.out.println("Error! Writing to log file failed.");                                  
        }        
    }   
}
