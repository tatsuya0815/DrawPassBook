package utils;

public class ConvertUtil {
    // 次の9文字は使用不可(< > : * ? " / \ |).
    final static String FORBIDDEN1 = "<";
    final static String FORBIDDEN2 = ">";
    final static String FORBIDDEN3 = ":";
    final static String FORBIDDEN4 = "*";
    final static String FORBIDDEN5 = "?";
    final static String FORBIDDEN6 = "\"";
    final static String FORBIDDEN7 = "/";
    final static String FORBIDDEN8 = "\\";
    final static String FORBIDDEN9 = "|";
    final static String FORBIDDEN10 = "　";
    final static String FORBIDDEN11 = " ";
    
    // 返却する文字列.
    final static String LESS_THAN = "小なり";
    final static String GREATER_THAN = "大なり";
    final static String COLON = "コロン";
    final static String ASTERISK = "アスタリスク";
    final static String QUESTION = "クエスチョン";
    final static String DOUBLE_QUORTATION = "ダブルクォーテーション";
    final static String SLASH = "スラッシュ";
    final static String BACK_SLASH = "バックスラッシュ";
    final static String BAR = "パイプライン";
    final static String SPACE_EM = "スペース(全角)";
    final static String SPACE_HALF = "スペース(半角)";
    
    public static String convert(String string) {
    	// 禁則文字に該当すれば変換した文字列を、該当しなければそのまま返却.
    	switch (string) {
    	case FORBIDDEN1:
    		return LESS_THAN;
		case FORBIDDEN2:
    		return GREATER_THAN;
    	case FORBIDDEN3:
    		return COLON;
    	case FORBIDDEN4:
    		return ASTERISK;
    	case FORBIDDEN5:
    		return QUESTION;  		
    	case FORBIDDEN6:
    		return DOUBLE_QUORTATION;
    	case FORBIDDEN7:
    		return SLASH;
    	case FORBIDDEN8:
    		return BACK_SLASH;
    	case FORBIDDEN9:
    		return BAR;
    	case FORBIDDEN10:
    		return SPACE_EM;
    	case FORBIDDEN11:
    		return SPACE_HALF;
    	default :
    		return string;
    	}
    }

}
