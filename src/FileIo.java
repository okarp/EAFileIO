/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 2
 * Okko Partanen
 * 
 * FileIo exercise. Program lets user 'manipulate' files in resources/Files directory. 
 * Program also logs execution time of the manipulation methods.
 * Prints out the supported commands on the start of the program and when user inputs 'help' 
 * 
 */
public class FileIo {
    public static void main(String[] args) {        
        UserInterface ui = new UserInterface();        
        //Starts the main loop of the program.
        ui.run();        
    }   
}
