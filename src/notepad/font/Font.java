package notepad.font;

/**
 * 폰트 이름 리스트 ENUM
 */
public enum Font {
	
	GOTHIC("고딕체"),
	GUNGSEO("궁서체"),
	CONSOLAS("Consolas"),
	GULLIM("새굴림"),
	MALGEUN_GOTHIC("맑은고딕");
	
	private String name;

	private Font(String name) {
		this.name = name;
	}	// Font

	public String getName() {
		return name;
	}
	
}	// enum