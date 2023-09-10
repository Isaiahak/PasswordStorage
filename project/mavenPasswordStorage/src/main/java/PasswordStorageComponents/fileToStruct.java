package PasswordStorageComponents;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.util.Enumeration;
import java.util.Hashtable;
import java.io.*;

public class fileToStruct {
	
	private fileToStruct(){	
	}
	
	private static File file = new File("C:\\Users\\isaiah\\eclipse-workspace\\PasswordStorage\\mavenPasswordStorage\\src\\main\\java\\PasswordStorageComponents\\usernamesAndPasswords.csv");
	private static Hashtable<String, String[] > table =  new Hashtable<String, String[] >();
	
	
	public static void fileToHashtable() {
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] nextRecord = new String[3];
			while((nextRecord = reader.readNext()) != null) {	
				if(nextRecord.length == 1) {
					break;
				}
				String[] array = new String[2];
				array[0] = nextRecord[1];
				array[1] = nextRecord[2];
				table.put(nextRecord[0], array);
				}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void add(String key, String user, String password) {
		if(key.compareTo("") == 0 && user.compareTo("") == 0 && password.compareTo("") == 0) {
			String[] array = new String[2];
			array[0] = user;
			array[1] = password;
			table.put(key, array);	
		}
	}
	
	public static void remove(String key) {
		if(table.contains(key)) {
			table.remove(key);
		}
	}
	
	public static void print() {
		for(Enumeration<String> key = table.keys(); key.hasMoreElements();) {
			StringBuffer print = new StringBuffer();
			String value = key.nextElement();
			String[] userpass =  table.get(value);
			print.append("key is :" + value + ", username is :" + userpass[0] + ", password is :" + userpass[1]);
			System.out.println(print.toString());
		}
	}

	
	public static void main(String[] args) {
		fileToHashtable();
		print();
		add("tester7","aron","grass");
		fileToHashtable();
		System.out.println("asdasd");
		print();
	}

}
