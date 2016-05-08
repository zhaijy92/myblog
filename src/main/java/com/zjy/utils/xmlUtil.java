package com.zjy.utils;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Marshaller;  
import javax.xml.bind.Unmarshaller;  

public class xmlUtil<T> {  
	  
    @SuppressWarnings("unchecked")  
    public T unmarshal(Class<T> clazz, InputStream is) throws JAXBException {  
        JAXBContext context = JAXBContext.newInstance(clazz);  
        Unmarshaller un = context.createUnmarshaller();  
        return (T) un.unmarshal(is);  
    }  
      
    public T unmarshal(Class<T> clazz, File file) throws JAXBException, FileNotFoundException {  
        return unmarshal(clazz,new FileInputStream(file));  
    }  
      
    public void marshal(T element,OutputStream os) throws JAXBException{  
        JAXBContext jc = JAXBContext.newInstance(element.getClass());  
        Marshaller m = jc.createMarshaller();  
        m.marshal(element, os);  
    }  
      
    public void marshal(T element, File output) throws FileNotFoundException, JAXBException{  
        marshal(element,new FileOutputStream(output));  
    }  
      
   
}  
