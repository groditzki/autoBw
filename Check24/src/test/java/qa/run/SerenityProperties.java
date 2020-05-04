package qa.run;

import java.io.File;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class SerenityProperties {
	private static EnvironmentVariables pro = null;
	
	public static synchronized EnvironmentVariables getInstance(){
		if(pro == null)
	    	pro= SystemEnvironmentVariables.createEnvironmentVariables();
	    return pro;
	}
	
	public static String getProperty(String value) {
		return getInstance().getProperty(value);
	}
	
	public static String getPath() {
		String env = SerenityProperties.getProperty("project.env");
		if(env.contains("PRO"))  
			env = "prod";
		else
			env = "ta";
		return SerenityProperties.getProperty("project.base.path") + env + "/";
	}
	public static String getDiff() {
		String dirname = getPath()+"diff/";
		File dir = new File(dirname);
		if (!dir.isDirectory())
			dir.mkdir();  
		return dirname;
	}
	public static String getBase() {
		String dirname = getPath()+"base/";
		File dir = new File(dirname);
		if (!dir.isDirectory())
			dir.mkdir();  
		return dirname;
	}
	public static String getTake() {
		String dirname = getPath()+"take/";
		File dir = new File(dirname);
		if (!dir.isDirectory())
			dir.mkdir();  
		return dirname;
	}
	
	
	
	public static void main(String[] args) {
	
	
		System.out.println(SerenityProperties.getProperty("project.base.path"));
		System.out.println(SerenityProperties.getPath());
		System.out.println(SerenityProperties.getTake());
		System.out.println(SerenityProperties.getDiff());
		System.out.println(SerenityProperties.getBase());
		

		
		
 	}
}
