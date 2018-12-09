package kata5.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Histogram <T> {
    private final Map <T,Integer> map = new HashMap <> ();
    public int get(T key){
        int res = 0;
        int i = 0;
        int j = 0;
        if(map.containsKey(key)){
            for(T clave : map.keySet()){
                i++;
                if(clave == key){
                    break;
                }
            }
            for(Integer value : map.values()){
                j++;
                if(i == j){
                    res = value;
                    break;
                }
            }
        }
        return res;
    }
    public Set<T> keyset() {
        Set<T> res = new HashSet<>();
        for (Map.Entry entry : map.entrySet()) {
            T key = (T) entry.getKey();
            res.add(key);
        }
        return res;
    }
    public void increment(T key){
        map.put(key, map.containsKey(key) ? map.get(key)+1 : 1);
    }
    
}
