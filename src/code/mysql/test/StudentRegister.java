/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.mysql.test;

import CrsCde.CODE.Common.Utils.DATEUtil;
import code.mysql.demo.entites.Student;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gyana-VIS
 */
public class StudentRegister {
    
   static String name;
    static String rollNO;
    
    
    public static Student SaveStudent(){
        
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        
        while(true){
            System.out.println("enter Student Name");
            name = scanner.nextLine();
            
            if(name.isEmpty()|| name==null){
                System.out.println("sorry student;s name should not be Blank");
                  continue;
            }else if(name.length()>20){
                System.out.println(" student Name's length should not be Greater than 20");
                continue;
            }
           break;
        }
        
    
        
        
        while(true){
            System.out.println("enter Rollno");
            rollNO = scanner.nextLine();
            
            if(rollNO.isEmpty()|| rollNO==null){
                System.out.println("sorry student's rollNO should not be Blank");
                  continue;
            }else if(rollNO.length()>10){
                System.out.println("rollNO's length should not be Greater than 10");
                continue;
            }
           break;
        }
        
        // Set student feild 
        
        student.setRollNo(rollNO);
        student.setSname(name);
        student.setCreateDate(DATEUtil.Now());
        return student;
    }
}
