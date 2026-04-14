/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package code.mysql.demo.db;

import code.entities.IAEntity;

/**
 *
 * @author Gyana-VIS
 */
public interface DatabaseManager {
    
    public void insert(IAEntity entity)throws Exception;
    
}
