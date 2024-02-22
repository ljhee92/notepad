package notepad.font;

/**
 * 폰트 스타일 리스트 ENUM
 */
public enum FontStyle {
	
	PLAIN("일반"),
	BOLD("굵게"),
	ITALIC("기울임꼴"),
	BOLD_ITALIC("굵은 기울임꼴");
	
	private String name;
	
	private FontStyle(String name) {
		this.name = name;
	}	// FontStyle

	public String getName() {
		return name;
	}

}	// enum