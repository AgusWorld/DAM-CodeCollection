import java.util.Comparator;

import org.json.JSONObject;

public class JSONObjectComparator implements Comparator<JSONObject>{
	
	public int compare(JSONObject obj1, JSONObject obj2) { 
        int result = 0; 
        if (obj1.getBoolean("won") && !obj2.getBoolean("won")) { 
            result = -1; 
        } else if (!obj1.getBoolean("won") && obj2.getBoolean("won")) { 
            result = 1; 
        } else { 
            result = Integer.compare(obj1.getInt("moves"), obj2.getInt("moves")); 
        } 
        return result;
	}
	
}
