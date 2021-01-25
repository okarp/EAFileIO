import utility.*;
/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 2
 * Okko Partanen
 * 
 * UserInterface class interacts with user and reads the userinput.
 * UserInterface class calls methods of interpreter after validating users input.
 * 
 * When program is started a hashtable is populated with words from the provided textfile.
 * Words are stored as keys in hashtables and the values are how many times the word occures in Dracula textfile.
 * Hashtable is implemented to provide faster word count and search function.
 * 
 */
import java.util.Scanner;

public class UserInterface {

    private Interpreter interpreter;
    private Boolean keepRunning; 
    private Scanner sc;

    public UserInterface(){
        this.interpreter = new Interpreter();
        this.keepRunning = true;
        this.sc = new Scanner(System.in);
    }

    public void run(){
        //fills the hashtables with words from the Dracula.txt file.
        interpreter.fillHashTable();     
        System.out.println("Hello. I'm a simple file manipulation program! \n");        
        printCommands();        
        //main loop of the program. Prompts user for input and passes it on. 
        while(keepRunning){
            System.out.println("Enter a command ('help' to list commands, 'quit' to exit)");
            System.out.print(">");
            String userInput = sc.nextLine();
            if (userInput.equals("quit")){
                System.out.println("Bye!");
                this.keepRunning = false;
            }else if (userInput.equals("help")){
                printCommands();
            }else{
                callInterpreter(userInput);
            }
        }               
    }
    //checks that the users input is a supported command and then calls the interpreter.
    private void callInterpreter(String userInput){
        //split the users input into an array
        String[] args = userInput.split("\\s+");
        //commands that are over 3 parameters long aren't supported.
         if (args.length > 3 || args.length == 0)
            System.out.println("Command not supported.");
        //if user typed 'ls' flow goes here
        else if (args[0].equals("ls")){
            if (args.length == 1)
                interpreter.listFiles();
            else if (args.length == 2)
                interpreter.listFiles(args[1]);
            //'ls' command dosen't support more than one argument, prompt with error.
            else
                System.out.println("Command not supported.");
        
        //if user inputs 'txt' commands with one parameter
        }else if (args[0].equals("txt") && args.length == 2){
            //check what's the parameter found in args[1]
            if (args[1].equals("name"))
                interpreter.printTextFileName();
            else if (args[1].equals("size"))
                interpreter.printTextFileSize();
            else if (args[1].equals("lines"))
                interpreter.countLines();
            else
                System.out.println("Command not supported!");

        //if user inputs 'txt' command with two parameters.
        }else if (args.length == 3 && args[0].equals("txt")){
            if (args[1].equals("search"))
                interpreter.searchWord(args[2]);
            else if (args[1].equals("count"))
                interpreter.countWord(args[2]);
            else
                System.out.println("Command not supported!");

        //if user wishes to use the hashtable commands.
        }else if (args.length == 3 && args[0].equals("hashtable")){
            if (args[1].equals("search"))
                interpreter.searchWordHashTable(args[2]);
            else if (args[1].equals("count"))
                interpreter.countWordHashTable(args[2]);
            else
                System.out.println("Command not supported!");        
        //if user inputs anything that is not supported
        }else
            System.out.println("Command not supported!");
    }    
    //printing out the command menu
    private void printCommands(){
        System.out.println("Here are all the commands that are supported:");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("ls -- lists all files in the Files dir");
        System.out.println("ls 'extension' -- lists all files in Files dir with the given extension (replace extension with txt/jpg for example)");
        System.out.println("txt name -- prints name of the provided .txt file");
        System.out.println("txt size -- prints the size of provided .txt file");
        System.out.println("txt lines -- prints how many lines the provided .txt file has");
        System.out.println("txt search 'word' -- searches for word in the .txt file. Replace 'word' with any string you want.");
        System.out.println("txt count 'word' -- counts how many times word appears in .txt. Replace 'word' with any string you want.");
        System.out.println("hashtable search 'word' -- searches if word is in textfile using hashtable. Replace 'word' with any string you want.");
        System.out.println("hashtable count 'word' -- prints how many times word occures in text file using hashtable. Replace 'word' with any string you want."); 
        System.out.println("help -- prints out all the supported commands.");
        System.out.println("quit -- quits the program.");
        System.out.println("---------------------------------------------------------------------------------");
    }
}
