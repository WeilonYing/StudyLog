package studylog;

/*
 * Copyright (C) 2013 Weilon Ying.
 * This program is licensed under the
 * Creative Commons BY 3.0 Australia License.
 * You are free to copy, distribute, display and
 * perform the work, make derivative works and
 * make commercial use of the work under the
 * condition you give ORIGINAL CREDIT to the
 * author (In this case, Weilon Ying); with the
 * understanding that any of the aforementioned
 * conditions can be waived if you get permission
 * from the copyright holder; and where the work or
 * any of its elements is in the public domain
 * under applicable law, that status is in no way
 * affected by the license.
 * You may see the full license here:
 * http://creativecommons.org/licenses/by/3.0/au/



    lol this is stolen straight from Whale's ATM code, so sue me <3
    - Dylan


 */



import java.io.*;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Weilon Ying, code "adapted" by Dylan Zhang (ha)
 */
public class GetData extends MainGUI { //
    static String sourcefile = "Log.txt";
    
    public static int getTimeDylan() {        
        try {
            Properties data = new Properties();
            FileInputStream input = new FileInputStream(sourcefile);
            data.load(input);
            int pin = Integer.parseInt(data.getProperty("Dylan"));
            input.close(); //Closes input stream
            return pin;
        }
        catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }
    public static void setTimeDylan(int TIIIME) { //Sets the isLockedOut variable
        try {
            Properties data = new Properties();   
            FileInputStream input = new FileInputStream(sourcefile);
            
                data.load(input);
                int previousBalance = Integer.parseInt(data.getProperty("Dylan"));
                
                    String totalBalance = Integer.toString(TIIIME);
                    input.close();
                    FileOutputStream output = new FileOutputStream(sourcefile);
                    data.setProperty("Dylan", totalBalance);
                    data.store(output, null);
                    output.close();
  
        }
        catch (Exception e) {
            System.err.println("HOUSTON WE HAVE AN ERROR " + e.getMessage());
        }
        
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int getTimeWeilon() {        
        try {
            Properties data = new Properties();
            FileInputStream input = new FileInputStream(sourcefile);
            data.load(input);
            int pin = Integer.parseInt(data.getProperty("Weilon"));
            input.close(); //Closes input stream
            return pin;
        }
        catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }
    public static void setTimeWeilon(int TIIIME) { //Sets the isLockedOut variable
        try {
            Properties data = new Properties();   
            FileInputStream input = new FileInputStream(sourcefile);
            
                data.load(input);
                int previousBalance = Integer.parseInt(data.getProperty("Weilon"));
                
                    String totalBalance = Integer.toString(TIIIME);
                    input.close();
                    FileOutputStream output = new FileOutputStream(sourcefile);
                    data.setProperty("Weilon", totalBalance);
                    data.store(output, null);
                    output.close();
  
        }
        catch (Exception e) {
            System.err.println("HOUSTON WE HAVE AN ERROR " + e.getMessage());
        }
        
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int getTimeJack() {        
        try {
            Properties data = new Properties();
            FileInputStream input = new FileInputStream(sourcefile);
            data.load(input);
            int pin = Integer.parseInt(data.getProperty("Jack"));
            input.close(); //Closes input stream
            return pin;
        }
        catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }
    public static void setTimeJack(int TIIIME) { //Sets the isLockedOut variable
        try {
            Properties data = new Properties();   
            FileInputStream input = new FileInputStream(sourcefile);
            
                data.load(input);
                int previousBalance = Integer.parseInt(data.getProperty("Jack"));
                
                    String totalBalance = Integer.toString(TIIIME);
                    input.close();
                    FileOutputStream output = new FileOutputStream(sourcefile);
                    data.setProperty("Jack", totalBalance);
                    data.store(output, null);
                    output.close();
  
        }
        catch (Exception e) {
            System.err.println("HOUSTON WE HAVE AN ERROR " + e.getMessage());
        }
        
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int getTimeKatrina() {        
        try {
            Properties data = new Properties();
            FileInputStream input = new FileInputStream(sourcefile);
            data.load(input);
            int pin = Integer.parseInt(data.getProperty("Katrina"));
            input.close(); //Closes input stream
            return pin;
        }
        catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }
    public static void setTimeKatrina(int TIIIME) { //Sets the isLockedOut variable
        try {
            Properties data = new Properties();   
            FileInputStream input = new FileInputStream(sourcefile);
            
                data.load(input);
                int previousBalance = Integer.parseInt(data.getProperty("Katrina"));
                
                    String totalBalance = Integer.toString(TIIIME);
                    input.close();
                    FileOutputStream output = new FileOutputStream(sourcefile);
                    data.setProperty("Katrina", totalBalance);
                    data.store(output, null);
                    output.close();
  
        }
        catch (Exception e) {
            System.err.println("HOUSTON WE HAVE AN ERROR " + e.getMessage());
        }
        
    }
    //General purpose getTime and setTime
    public static String getTime(String name) {        
        try {
            Properties data = new Properties();
            FileInputStream input = new FileInputStream(sourcefile);
            data.load(input);
            String value = data.getProperty(name);
            input.close(); //Closes input stream
            return value;
        }
        catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
    public static void setTime(String name, int time) { //Sets the isLockedOut variable
        try {
            Properties data = new Properties();   
            FileInputStream input = new FileInputStream(sourcefile);
            
                data.load(input);
                int previousBalance = Integer.parseInt(data.getProperty(name));
                
                    String totalBalance = Integer.toString(time);
                    input.close();
                    FileOutputStream output = new FileOutputStream(sourcefile);
                    data.setProperty(name, totalBalance);
                    data.store(output, null);
                    output.close();
  
        }
        catch (Exception e) {
            System.err.println("HOUSTON WE HAVE AN ERROR " + e.getMessage());
        }
        
    }
    
    //File maintenance
        public static boolean checkFileExists(String fileName) {
        /*
            This method tests whether the specified file exists or not.
            If it doesn't exist, the method will return false.
            If it does exist, the method will return true.
        */
        try {
            FileInputStream input = new FileInputStream(fileName);
            //Attempt to open file. If file cannot be found, catch statement will be executed.
            try {
                input.close();
                //If found was found and open, the stream will need to be closed again.
            }
            catch (Exception error) {
                log("Exception occurred when trying to open file " + fileName);
            }
            return true; //Since file was able to be interacted with, return true;
        }
        catch (Exception error) {
            return false; //Since file was unable to be found, return false;
        }
    }
    public static void regenFile(String fileName){
        try {
            PrintWriter file = new PrintWriter(fileName, "UTF-8");
            /*
                ======
                TO DO
                ======
                Add data names when needed.
            */

        }
        catch (FileNotFoundException error) {
            log("FileNotFound Exception occurred. Cannot find file " + fileName);
            log(error.getMessage());
        }
        catch (UnsupportedEncodingException error) {
            log("UnsupportedEncoding Exception occurred when attempting to write to file " + fileName);
            log(error.getMessage());
        }
    }
        public static boolean write(String fileName, String dataName, String dataValue) {
        /* 
            fileName is the name of the file.
            dataName is the name of the data variable being set.
            dataValue is the value of the data variable being set.
        
            The method will return a boolean value. This is to allow other classes
            calling this method able to have error handling themselves should this 
            method encounter any errors. This is optional however.
            E.g. If returned true, do this. If returned false, do something else.
        */
        try {
            /*
                File needs to be loaded into memory before being modified.
                This is to prevent the program from wiping the file.
            */
            Properties file = new Properties(); //Intantialise Properties class in order to interact with file.
            FileInputStream input = new FileInputStream(fileName); //Instantialise FileInputStream class to prepare for file reading.
            try {
                file.load(input);
                input.close(); //Close input stream as program no longer needs to read it.
            }
            catch (IOException error) {
                log("IO Exception error after attempting to read file " + fileName);
                log(error.getMessage());
                return false;
            }
            
            FileOutputStream output = new FileOutputStream(fileName); //Initialise FileOutputStream to prepare for writing in file.
            try {
                file.setProperty(dataName, dataValue);
                file.store(output, null);
                output.close(); //Close output stream as program has finished writing in it.
                return true;
            }
            catch (IOException error) {
                /* 
                    If this occurs, there was a problem with locating the file.
                    Details will be logged to the console, and then the file
                    will be regenerated.
                */
                log("IO Exception error after attempting to read file " + fileName);
                log(error.getMessage());
                JOptionPane.showMessageDialog(null, error);
                return false;
            }
        }
        catch (FileNotFoundException error) {
            log("FileNotFound Exception occurred. Cannot find file " + fileName);
            log(error.getMessage());
            log("Regenerating file...");
            regenFile(fileName);
            return false;
        }
    }
    
    private static void log(String message) {
        System.out.println(message);
    }
    
    
}


