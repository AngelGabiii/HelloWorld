/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Angelis
 */
public class FileHandler extends HomeController {
    Formatter creator;
    Scanner reader;
    String content;
    
    
    public void creatFile(String fileName)throws Exception{
        creator = new Formatter(fileName);
    }

    public void writeToFile(String fileContent) throws Exception{
        creator.format("%s", fileContent);
        creator.flush();
    }
    
    public void closeFile(){
        creator.close();
    }
    
    public void openFile(String fileName){
        try{ 
            reader = new Scanner( new File(fileName));
        }catch(Exception ex){
            System.err.print(ex);
        }
    }
    
    
    public  String  readFile() throws Exception{
        while(reader.hasNext()){
            String  content = reader.nextLine();
             System.out.format("%s ", content);
                                              // But in here, it gives me the vale of content
            }      
        System.out.println("This is the   " + content); // The value of content gives me null here
       return content;   
    }
    
    public void closeReadFile(){
        reader.close();
    }
    
    
    public void openParsedFile(String dFilePath){
        try {
            Scanner reader = new Scanner(new File(dFilePath));
           while(reader.hasNext()){
               String msg = reader.next();
               System.out.printf("%s ", msg);
           }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
   public void createParsedFile(String dFilePath){
        Formatter creator;
        try {
            creator = new Formatter(dFilePath);
            creator.format("%s", "SomeString");
            creator.flush();
            creator.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
    
    
    
    
}
