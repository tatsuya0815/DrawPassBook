package utils;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import constant.Const;

public class ViewPdfFileUtil {
	
	public static void execute(){
		Desktop desktop = Desktop.getDesktop();
		String uriString = Const.OPEN_PATH;
		try {
			URI uri = new URI(uriString);
			desktop.browse(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
