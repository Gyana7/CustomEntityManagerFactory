/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.mysql.demo.db;

import code.db.jpa.mysql.EMFProperties;
import code.db.jpa.mysql.MySQLem;
import code.db.jpa.mysql.MySQLemFactory;
import code.entities.IAEntity;
import code.mysql.demo.DBProperties;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Gyana-VIS
 */
public class MySQLDB implements DatabaseManager{
    
    
      private MySQLem _entityManager;

    public MySQLDB(ArrayList<String> classnames)throws Exception {
        
        
        // for Extra hibernate properties
        Properties hybernateProperties = new Properties();
        hybernateProperties.put("hibernate.jdbc.time_zone", "UTC");
        
        
        
        
        EMFProperties emfprop = new EMFProperties();
        emfprop.setConnPoolMaxSize(DBProperties.Temp_DB_MaxConnection);
        emfprop.setShow_sql(Boolean.TRUE);
        emfprop.setId_new_generator_mappings(Boolean.TRUE);
        emfprop.setXtra_Properties(hybernateProperties);
        
        
        
        MySQLemFactory mysqlFactory = new MySQLemFactory(MySQLemFactory.MySQLVer.Ver8);
        
        String PersistanceunitFileName = DBProperties.PersistanceUnitFilePath + File.separator + DBManagerFactory.getPersistanceUnitName()+ "_persistence.xml";
        
        System.out.println(PersistanceunitFileName);
        
         _entityManager = mysqlFactory.CreateEM(PersistanceunitFileName,DBManagerFactory.getPersistanceUnitName(),emfprop,
                  DBProperties.DB_HostName,DBProperties.DB_ServerPort,"testdb",DBProperties.DB_userName,
                  DBProperties.DB_Password,classnames,Boolean.FALSE, new String[0]
          );
        
        
    }
    
    
    
    

    @Override
    public void insert(IAEntity entity) throws Exception {
        _entityManager.Insert(entity);
    }
    
}
