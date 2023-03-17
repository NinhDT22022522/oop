import java.util.Collection;
import java.util.HashMap;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<T, Integer> map1 = new HashMap<>();
		HashMap<T, Integer> map2 = new HashMap<>();
		for (T element : a){
			if (!map1.containsKey(element)){
				map1.put(element, 1);
			}else {
				map1.put(element, map1.get(element) + 1);
			}
		}
		for (T element : b){
			if (!map2.containsKey(element)){
				map2.put(element, 1);
			}else {
				map2.put(element, map2.get(element) + 1);
			}
		}
		int res = 0;
		for (T key : map1.keySet()){
			if (map2.containsKey(key)){
				if (map1.get(key) == map2.get(key)){
					res++;
				}
			}
		}
		return res;
	}
	
}
