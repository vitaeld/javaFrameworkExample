package helpers;

import java.nio.file.FileSystems;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import data.TestData.SearchResultData;

public class DataProcessingHelper {
	
	public static String getPath(String partPath) {
		var path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
		path = path+partPath;
		return path;
	}
	public static <TDataClass> TDataClass getData(String partPath,Class<TDataClass> dataClass) throws Exception {
		var path = getPath(partPath);
		var jsonHelper = new JsonHelper();
		 var data = jsonHelper.converFromJSon(path, dataClass);
		return data;
	}
 
	public static SearchResultData[] getTestData(String partPath) throws Exception {
		var path = getPath(partPath);
		var jsonHelper = new JsonHelper();
		var data = jsonHelper.converFromJsonArray(path);
		return data;
    }
	
	public static Calendar getCalenderDate(String date) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal  = Calendar.getInstance();
		cal.setTime(df.parse(date));
		return cal;
	}
	
	public static String getGeckoPath() {
		String geckoDriverFile = "\\geckodriver.exe";
		var path = FileSystems.getDefault().getPath("").toAbsolutePath().getParent().toString();
		path = path + geckoDriverFile;
		return path;
	}
}
