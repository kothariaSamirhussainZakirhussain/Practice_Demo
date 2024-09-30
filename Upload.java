package Random;

import java.util.Random;

public class Upload {
	
	public static String Upload() {
		Random random = new Random();
		String[] upload= {
			"file-example_PDF_1MB",
			"KnownDefects_HotelApp",
			"sample",
			"Sample-TestCases_HotelApplication",
			"Selenium Full Material Updated Greens"
		};
		int index = random.nextInt(upload.length);
	    String ran_upload = upload[index];
		return ran_upload;
	}

	public static void main(String[] args) {
		String Path = "D:/Gaurav/Material/" + Upload() +".pdf";
		System.out.println(Path);
	}

}
