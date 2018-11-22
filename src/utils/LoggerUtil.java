package utils;

import org.apache.commons.lang3.StringUtils;

// ログ出力用共通クラス.
public class LoggerUtil {
	
	public static void execute(String index1, String message1, String index2, String message2) {
	
		StackTraceElement[] st = (new Throwable()).getStackTrace();
		String methodName = st[1].getMethodName();
		String className = st[1].getClassName();
		int line = st[1].getLineNumber();
		
		if (!StringUtils.isEmpty(index2) && !StringUtils.isEmpty(message2)) {
			System.out.println("info : where = " + className + "." + methodName 
					+ "():" + line + ", mes1 = " + index1 + message1
					+ ", mes2 = " + index2 + message2);
		} else {
			System.out.println("info : where = " + className + "." + methodName 
					+ "():" + line + ", mes1 = " + index1 + message1);
			
		}

	}
}
