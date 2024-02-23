package notepad.font;

import java.awt.Font;

/**
 * 폰트 스타일 리스트 ENUM
 */
public enum FontStyle {
	
	PLAIN("일반", Font.PLAIN),
	BOLD("굵게", Font.BOLD),
	ITALIC("기울임꼴", Font.ITALIC),
	BOLD_ITALIC("굵은 기울임꼴", Font.BOLD | Font.ITALIC);
	
	private String name;
	private int type;
	
	private FontStyle(String name, int type) {
		this.name = name;
		this.type = type;
	}	// FontStyle

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

}	// enum