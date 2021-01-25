# EAFileIO - Experis Academy Task 2.

The program is a Java console application that manipulates files found in src/Files/ directory. Program logs execution time of file manipulation functions. The log file is placed in src/Logs.

A hashtable implementation has been added to the program. The program reads all words from the provided textfile (Files/Dracula.txt) and puts them in a hashtable. Words are keys and values are how many times the word occured in the Dracula textfile.

Program supports following commands:

ls -- lists all files in the Files dir

ls 'extension' -- lists all files in Files dir with the given extension (replace extension with txt/jpg for example).

txt name -- prints name of the provided .txt file.

txt size -- prints the size of provided .txt file.

txt lines -- prints how many lines the provided .txt file has.

txt search 'word' -- searches for word in the .txt file. Replace 'word' with any string you want.

txt count 'word' -- counts how many times word appears in .txt. Replace 'word' with any string you want.

hashtable search 'word' -- searches if word is in textfile using hashtable. Replace 'word' with any string you want
.
hashtable count 'word' -- prints how many times word occures in text file using hashtable. Replace 'word' with any string you want. 

help -- prints out all the supported commands.

quit -- quits the program.


<h3 align="center"> Screenshot of the javac commands to compile project in out folder.</h3>

![javac](/screenshots/javac.png?raw=true "Optional Title")

<h3 align="center"> Screenshot of the command to compile a jar file in out folder.</h3>

![jar](/screenshots/jar.png?raw=true "Optional Title")

<h3 align="center">Screenshot of the jar running.</h3>

![run](/screenshots/runningprog.png?raw=true "Optional Title")
