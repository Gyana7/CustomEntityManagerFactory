/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.mysql.demo;

import code.mysql.demo.db.DBManagerFactory;
import code.mysql.demo.db.DatabaseManager;
import code.mysql.demo.entites.Student;
import code.mysql.test.StudentRegister;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Gyana-VIS
 */
public class Main {
    
    
    public static void main(String[] args) {
        
     try{
           
        DatabaseManager Dbmanager = DBManagerFactory.createDatabase();
         Student registerStudent = registerStudent();
         Dbmanager.insert(registerStudent);
     }catch(Exception e){
         e.printStackTrace();
     }
    }
    
    
    public static Student registerStudent(){
        
        Student registerStudent = StudentRegister.SaveStudent();
        
        System.out.println("student register sucessfully: RollNo:-" 
                +registerStudent.getRollNo()+" "
                + "name:"+registerStudent.getSname()+" "
                +"Createddate is:"+registerStudent.getCreateDate());
                
       return registerStudent;
        
    }
}
