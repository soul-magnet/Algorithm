package MS.OA2017;

import java.util.*;

/**
 * Created by wtnwi on 1/15/2017.
 */
public class MergeEmail {
    HashMap<String, String>hm = new HashMap<>();
    List<List<String>> mergeEmail(HashMap<String, List<String>> a){
        List<List<String>> res = new ArrayList<>();
        if(a==null||a.size()==0)return res;
        HashMap<String, String>email = new HashMap<>();
        for(HashMap.Entry<String, List<String>> now : a.entrySet()){
            if(!hm.containsKey(now.getKey())){
                hm.put(now.getKey(),now.getKey());
            }
            for(String e : now.getValue()){
                if(!email.containsKey(e)){
                    email.put(e,now.getKey());
                }else{
                    union(now.getKey(),email.get(e));
                }
            }
        }
        HashMap<String,HashSet<String>> dic = new HashMap<>();
        for(String now : hm.keySet()){
           String root = find(now);
            if(!dic.containsKey(root)){
                dic.put(root,new HashSet<String>());
            }
            dic.get(root).add(now);
        }
        for(HashSet<String>now :dic.values()){
            res.add(new ArrayList<>(now));
        }
        return res;
    }
    public String find(String x) {
        String father = hm.get(x);
        while (!hm.get(father).equals(father)){
            father=hm.get(father);
        }
        //compress_find from link to star map
        String crt =x;
        while(!hm.get(crt).equals(father) ){
            String tmp= crt;
            crt = hm.get(crt);
            hm.put(tmp, father);
        }
        return father;
    }
    public void union ( String x, String y){
        String fx= hm.get(x);
        String fy= hm.get(y);
        if (fx!= fy){
            hm.put(fx, fy);
        }
    }
}
