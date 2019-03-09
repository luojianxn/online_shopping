package service;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Base1 extends BaseSer{
	
	public static void main(String[] args) throws Exception {
		
		  File tmp=new File("");
		  String path = tmp.getAbsoluteFile()+"\\src\\service\\";		  
		  URL newurl=new URL("file:"+path);
		  File dir = new File(path);
	      URLClassLoader classLoader=new URLClassLoader(new URL[]{newurl});	     
	      File[] files = dir.listFiles();
	      
         for (int i=0; i < files.length; i++){
       	    String fileName = files[i].getName();      	  
       	    if(fileName.indexOf("Service")!=-1){
	       		String classfile=("service."+fileName).replace(".java", "");
	       	   	Class<?> methtClass = classLoader.loadClass(classfile);
	       	   	Object obj = methtClass.newInstance();       	   	
	       	   	methtClass.getMethod("test").invoke(obj);
	       	    System.out.println("loaded class :" + classfile);
       	   }
         }	      
         classLoader.close();
	}
	
}
