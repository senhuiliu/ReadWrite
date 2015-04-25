/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Huige1
 */
import java.io.*;
import java.util.*;

public class ReadWrite{
   public static void main(String[] args) throws IOException{
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       HashMap<String,String> lab = new HashMap<String,String>();
       while(true){
           System.out.println("Select one option");
           System.out.println("Write Student Record          : 0");
           System.out.println("Search Student GCPA           : 1");
           System.out.println("QUIT                          : 2");
           int option=Integer.parseInt(reader.readLine());
           if (option>=0 && option<=2){
               if (option == 0){
                   FileWriter fw=new FileWriter("Stu.dat");
                   BufferedWriter sd = new BufferedWriter(fw);
                   System.out.println("Enter the total number of students");
                   int option1=Integer.parseInt(reader.readLine());
                   System.out.println("Enter Student ID and GPA separated by space");
                   while (option1 > 0){
                       String std=reader.readLine();
                       sd.write(std);
                       option1--;
                   }
               }
               else if (option == 1){
                   try {
                       BufferedReader filereader=new BufferedReader(new FileReader("Stu.dat"));
                       String b=filereader.readLine();
                       while (b!=null){
                           StringTokenizer st=new StringTokenizer(b);
                           lab.put(st.nextToken(),st.nextToken());
                           b=filereader.readLine();
                       }
                       filereader.close();
                       while (true){
                           System.out.println("Select one option");
                           System.out.println("Search Student GCPA           : 1");
                           System.out.println("QUIT                          : 2");
                           int integer1 = Integer.parseInt(reader.readLine());
                           if (integer1 == 1){
                               System.out.println("Enter The ID of student whose CGPA is to be checked(Press -100 to quit)");
                               String s = reader.readLine();
                               System.out.println("s is "+s);
                               System.out.println(lab.get(s)+"     "+s);
                           }
                           else{
                               break;
                           }
                       }
                   }catch(FileNotFoundException e){System.out.println("there is no such file");}
               }
               else{
                   break;
               }
           }
       }
   }
}