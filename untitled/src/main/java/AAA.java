import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AAA {
    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("id","a");
        obj.put("rel","父");
        array.put(obj);
        obj = new JSONObject();
        obj.put("id","c");
        obj.put("rel","父");
        array.put(obj);
        obj = new JSONObject();
        obj.put("id","b");
        obj.put("rel","父");
        array.put(obj);
        obj = new JSONObject();
        obj.put("id","a");
        obj.put("rel","子");
        array.put(obj);
        AAA.a(array);
    }

    private static JSONObject a(JSONArray arr) {
        JSONObject vv = new JSONObject();
        Set<String> idSet = new HashSet<>();
        for (int i = 0; i < arr.length(); i++) {
            String id = arr.getJSONObject(i).getString("id");
            String rel = arr.getJSONObject(i).getString("rel");
            if (!idSet.contains(id)) {
                idSet.add(id);
                vv.put(id,arr.getJSONObject(i));
            } else {
                JSONObject av = (JSONObject) vv.get(id);
                av.put("rel", av.getString("rel") + rel);
            }
        }
        return vv;
    }
}
