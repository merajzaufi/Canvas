# Canvas
Challenge2

This challenge has been addressed using Java technology.
StartProg is the main class to initiate the parsing request. This design reads the csv data into string iniitially and then mapped into arraylist of Java objects( type Device class) which holds attributes such as device_id,A,B,C,D,Date.

Here i'm using comparator to sort the value read from csv, reading and writing i'm using buffer read/write which is efficent when excessive IO oprtaions involved.
I'm using multiple date format support while reading date field from csv as there could be null or other date values.

Processing of large file could cause out of memory exception, there are many approaches to handle this situation by reading chuck of lines at a time, write it to a temp file and process merging.

I have written Junit test cases just for testing data set conversion which accepts file data string as input and return split String array for further comparision as Java objects.

I have included ANT scripts which could package, deploy and run the project on to the console just type "ant run" command.
It could be run as simple Java project through command line or eclipse import.

Steps to run:
Copy the .csv file to "src" folder of Java project before running the program
Run using Ant script or with eclipse import or command line support
System would prompt to enter a valid csv file to be sorted - > "abc.csv"
Now system would perform reading, conversion and sorting 
Finally the result will be written to "random_data_sorted.csv" file available under "src" folder of Java project.




