package tree.util;


public class ObjectUtil {


	public static boolean isNull(Object tree) {
		return tree == null;
	}

	public static String nullToString(Object obj) {
		return obj == null ? "" : obj.toString();
	}
}
