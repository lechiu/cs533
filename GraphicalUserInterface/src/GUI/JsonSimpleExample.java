package GUI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class JsonSimpleExample {
     public static void main(String[] args) {
 
	JSONParser parser = new JSONParser();
 
	try {
 
		Object obj = parser.parse(new FileReader("mission.json"));
 
		JSONObject jsonObject = (JSONObject) obj;
		

		


		String description = (String) jsonObject.get("description");
		System.out.println(description);
		
		int id = ((Long) jsonObject.get("id")).intValue();
		int left =  ((Long) jsonObject.get("left")).intValue();
		int top =  ((Long) jsonObject.get("top")).intValue();

		

		
		System.out.println(id);
		System.out.println(left);
		System.out.println(top);
		
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
 
     }
 
}