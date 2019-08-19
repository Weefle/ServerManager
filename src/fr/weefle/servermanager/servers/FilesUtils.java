package fr.weefle.servermanager.servers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesUtils {

    public static void copyFolder(File source, File destination){

        try {
        	if(source.isDirectory()) {
        		
        		if(!destination.exists()) {
        			destination.mkdir();
        		}
        		
        		String[] childrens = source.list();
        		for(int i = 0; i < childrens.length; i++) {
        			copyFolder(new File(source, childrens[i]), new File(destination, childrens[i]));
        		}
        		
        	}else {
        		InputStream in = new FileInputStream(source);
        		OutputStream out = new FileOutputStream(destination);
        		
        		byte[] buffer = new byte[1024];
        		int length;
        		while((length = in.read(buffer)) > 0) {
        			out.write(buffer,0,length);
        		}
        		in.close();
        		out.close();
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteFolder(File source){
        try {
            Files.walk(source.toPath()).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
