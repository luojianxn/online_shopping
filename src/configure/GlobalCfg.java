package configure;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

import service.BaseSer;

public class GlobalCfg {
	public static HashMap<String,Object> map=new HashMap<String,Object>();
	
	public static void serviceInit() throws Exception{
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
	       	   GlobalCfg.map.put(classfile, obj);
       	   }
         }	      
         classLoader.close();		
	}

}
