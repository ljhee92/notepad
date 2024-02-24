package notepad.font;

import java.util.HashMap;
import java.util.Map;

public class FontStyleItoS {
	
	public static Map<Integer, String> fStyleMap;
	
	public FontStyleItoS() {
		fStyleMap = new HashMap<Integer, String>();
		for(FontStyle fstyle : FontStyle.values()){
			fStyleMap.put(fstyle.getType(), fstyle.getName());
		}	// end for
	}	// FontStyleStoI

	public Map<Integer, String> getfStyleMap() {
		return fStyleMap;
	}
	
}	// class