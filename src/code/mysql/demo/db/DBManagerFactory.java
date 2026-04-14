/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.mysql.demo.db;

import code.mysql.demo.AppConst;
import jakarta.persistence.Entity;
import java.io.File;
import java.io.IOException;

import java.net.URL;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author Gyana-VIS
 */
public class DBManagerFactory {
    
    public static DatabaseManager createDatabase()throws ClassNotFoundException, IOException, Exception{
        
        
        
            ArrayList<String> entityClassnames = findEntityClassNames();
            
            
            MySQLDB mysqldb = new MySQLDB(entityClassnames);
            
      return mysqldb;
        
    }
    
    
    public static String getPersistanceUnitName(){
        return "MYSQLENTITITESDemoPU";
    }
    
    
    private static ArrayList<String>findEntityClassNames()throws ClassNotFoundException,IOException,Exception{
        
        
        ArrayList<String>entityClassnames = new ArrayList<>();
                
        ArrayList<Class> clases = FindEntityClassInPkg(AppConst.Radius_entities_Pkg);
        
        clases.stream().
                filter( cls -> cls.getAnnotation(Entity.class)!=null).forEachOrdered(cls -> {
                
                    entityClassnames.add(cls.getCanonicalName());
                });
        return entityClassnames;
        
    }
    
    
    private static ArrayList<Class>FindEntityClassInPkg(String packagename)throws ClassNotFoundException,IOException,Exception{
         ArrayList<Class> classes = new ArrayList<>();
        //ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = DBManagerFactory.class.getClassLoader();
         Enumeration<URL> resources = classLoader.getResources(packagename.replace(".", "/"));
         System.out.println("resources :"+resources.toString());
         
         URL url = null;
         
         if(!resources.hasMoreElements()){
             System.out.println("no resource found for package :"+ packagename);
         }
         while(resources.hasMoreElements()){
             
             url = resources.nextElement();
             System.out.println("found"+url);
             // URLConnection connection = url.openConnection();
             String urlpath = url.getPath();
             System.out.println(urlpath);        
             String decodePath = URLDecoder.decode(urlpath, "UTF-8");
             System.out.println("docdepath:-"+ decodePath);
            File dir = new File(decodePath);
             
             if (dir.exists() && dir.isDirectory()){
                 checkDirectory(dir, packagename, classes);   
             }
         }
         return classes;
         
        
    }
    
    
    
    private static void checkDirectory(File directory , String packagename,ArrayList<Class>classes)throws ClassNotFoundException,IOException,Exception{
        
        File tempdirectory;
        
        if(directory.exists() && directory.isDirectory()){
            
            String[] files = directory.list();
            
            for(String file :files ){
                
                if(file.endsWith(".class")){
                    try{
                       // remove .class name from file
                       String className = file.substring(0, file.length()-6);
                       
                        Class<?> loadclass = Class.forName(packagename +"."+className);
                        
                        classes.add(loadclass);
                       
                       
                        
                    }catch(NoClassDefFoundError e){
                        e.getMessage();
                    }
                }else{
                   tempdirectory = new File(directory,file) ;
                   
                   if(tempdirectory.exists() && tempdirectory.isDirectory()){
                       checkDirectory(directory, packagename + "."+ file, classes);
                   }
                    
                }
            }
        }
    }
    
}
