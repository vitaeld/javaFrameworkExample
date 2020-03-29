package helpers;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.TestData.SearchResultData;

public class JsonHelper {

	ObjectMapper mapper = new ObjectMapper();
	
	public <TDataClass> TDataClass converFromJSon(String path, Class<TDataClass> dataClass) throws Exception {
		 try {
	            return  mapper.readValue(
	            		new File(path), dataClass);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw e;
	        }
	}
	 
	public SearchResultData[] converFromJsonArray(String path) throws Exception {
		try {
				SearchResultData[] dataArray = mapper.readValue(new File(path), SearchResultData[].class);
				return dataArray;
			} catch (Exception e) {
	            e.printStackTrace();
	            throw e;
	        }
	}
}
