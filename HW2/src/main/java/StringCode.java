import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int res = 1;
		int cnt = 1;
		StringBuilder s = new StringBuilder();
		s.append(str);
		int len = s.length();
		if (len == 0){
			return 0;
		}
		else {
			for (int i = 0; i < len - 1; i++) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					cnt = cnt + 1;
					res = (cnt > res) ? cnt : res;
				} else {
					cnt = 1;
				}
			}
			return res;
		}
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder s = new StringBuilder();
		s.append(str);
		int len = s.length();
		String res = "";
		if (len == 0){
			return res;
		}else{
			for (int i = 0; i < len - 1; i++){
				if (s.charAt(i) <= '9' && s.charAt(i) >= '0'){
					int cnt = s.charAt(i) - '0';
					for (int j = 0; j < cnt; j++){
						res += s.charAt(i + 1);
					}
				}else{
					res = res + s.charAt(i);
				}
			}
			if (!(s.charAt(len - 1) <= '9' && s.charAt(len - 1) >= '0')) res += s.charAt(len - 1);
			return res;
		}
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> set1 = new HashSet<>();
		HashSet<String> set2 = new HashSet<>();
		for (int i = 0; i < a.length() - len + 1; i++){
			set1.add(a.substring(i, i + len));
		}
		for (int i = 0; i < b.length() - len + 1; i++){
			set2.add(b.substring(i, i + len));
		}
		for(String element : set1){
			if (set2.contains(element)) return true;
		}
		return false;
	}
}
