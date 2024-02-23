package notepad.font;

import java.util.HashMap;
import java.util.Map;

public class FontStyleStoI {
	
	Map<String, Integer> fStyleMap;
	
	public FontStyleStoI() {
		fStyleMap = new HashMap<String, Integer>();
		for(FontStyle fstyle : FontStyle.values()){
			fStyleMap.put(fstyle.getName(), fstyle.getType());
		}	// end for
	}	// FontStyleStoI

	public Map<String, Integer> getfStyleMap() {
		return fStyleMap;
	}
	
}	// class