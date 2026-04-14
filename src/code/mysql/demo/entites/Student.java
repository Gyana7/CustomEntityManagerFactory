/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.mysql.demo.entites;

import code.entities.IAEntity;
import code.entities.IEN;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

import jdk.jfr.Timestamp;

/**
 *
 * @author Gyana-VIS
 */
@Entity
@Table(name = "student")
public class Student implements IAEntity<Student> {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Sname",nullable = false,length = 30)
    private String Sname;
    
    @Column(name = "RollNo",nullable = false,length = 10)
    private String RollNo;

   
    
    @Column(name = "createDate")
   // @Temporal(TemporalType.TIMESTAMP)
    @Timestamp
     private Date createDate;
    
    
    // no Argument Constructor
    public Student() {
    }
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
     public String getSname() {
        return Sname;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String RollNo) {
        this.RollNo = RollNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
  

    @Override
    public IEN getEN() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean editedAfter(Student e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
