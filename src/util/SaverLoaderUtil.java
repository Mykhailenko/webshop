package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;


public class SaverLoaderUtil {
	public static void saveObjectNTimesToFile(Object obj, String fileName, int times) throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		saveObjectNTimesToOutputStream(obj, fileOutputStream, times);
	}
	private static void saveObjectNTimesToOutputStream(Object obj, OutputStream outputStream, int times) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(outputStream);
		for(int i = 0; i < times; ++i){
			oos.writeObject(obj);
		}
		oos.close();
	}
	public static void saveGZipObjectNTimesToFile(Object obj, String fileName, int times) throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		saveGZipObjectNTimesToOutputStream(obj, fileOutputStream, times);
	}
	private static void saveGZipObjectNTimesToOutputStream(Object obj, OutputStream outputStream, int times) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(outputStream));
		for(int i = 0; i < times; ++i){
			oos.writeObject(obj);
		}
		oos.close();
	}
	public static void saveObjectToFile(Object obj, String fileName) throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		saveObjectToOutputStream(obj, fileOutputStream);
	}
	private static void saveObjectToOutputStream(Object obj, OutputStream outputStream) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(outputStream);
		oos.writeObject(obj);
		oos.close();
	}
	
	public static <T> T loadObjectFromFile(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream(fileName);
		return loadObjectFromInputStream(fileInputStream);
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T loadObjectFromInputStream(InputStream inputStream) throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(inputStream);
		T t = (T) ois.readObject();
		ois.close();
		return t;
	}
}
