package notepad.design;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import notepad.event.NotepadEvent;

@SuppressWarnings("serial")
public class NotepadDesign extends JFrame {
	
	private JMenuItem jmiNewNote, jmiOpenNote, jmiSaveNote, jmiSaveNewNote, jmiQuitNote, jmiLineWrap, jmiFont, jmiNoteInfo;
	private JTextArea jtaNote;
	
	public NotepadDesign() {
		super("메모장");
		addMenuBar();
		addTextArea();
		addListener();
		
		setBounds(100, 100, 500, 500);
		setVisible(true);
	}	// NotepadDesign
	
	/**
	 * 메뉴바를 추가하는 일
	 * - 메뉴바 추가
	 * - 메뉴 추가
	 * - 메뉴아이템 추가
	 */
	private void addMenuBar() {
		JMenuBar jMenuBar = new JMenuBar();
		
		JMenu jmFile = new JMenu("파일");
		JMenu jmEdit = new JMenu("편집");
		JMenu jmForm = new JMenu("서식");
		JMenu jmHelp = new JMenu("도움말");
		
		jmiNewNote = new JMenuItem("새글");
		jmiOpenNote = new JMenuItem("열기");
		jmiSaveNote = new JMenuItem("저장");
		jmiSaveNewNote = new JMenuItem("새이름 저장");
		jmiQuitNote = new JMenuItem("종료");
		jmiLineWrap = new JMenuItem("줄바꿈");
		jmiFont = new JMenuItem("글꼴");
		jmiNoteInfo = new JMenuItem("메모장 정보");
		
		jmFile.add(jmiNewNote);
		jmFile.addSeparator();
		jmFile.add(jmiOpenNote);
		jmFile.add(jmiSaveNote);
		jmFile.add(jmiSaveNewNote);
		jmFile.addSeparator();
		jmFile.add(jmiQuitNote);
		jmEdit.add(jmiLineWrap);
		jmForm.add(jmiFont);
		jmHelp.add(jmiNoteInfo);
		
		jMenuBar.add(jmFile);
		jMenuBar.add(jmEdit);
		jMenuBar.add(jmForm);
		jMenuBar.add(jmHelp);
		setJMenuBar(jMenuBar);
	}	// setMenu
	
	/**
	 * 메모장의 텍스트 작성 부분을 추가하는 일
	 */
	private void addTextArea() {
		jtaNote = new JTextArea();
		JScrollPane jsp = new JScrollPane(jtaNote);
		add(jsp);
	}	// addTextArea
	
	/**
	 * 메뉴아이템에 리스너를 추가하는 일
	 */
	private void addListener() {
		NotepadEvent ne = new NotepadEvent(this);
		
		addWindowListener(ne);
		jmiNewNote.addActionListener(ne);
		jmiOpenNote.addActionListener(ne);
		jmiSaveNote.addActionListener(ne);
		jmiSaveNewNote.addActionListener(ne);
		jmiQuitNote.addActionListener(ne);
		jmiLineWrap.addActionListener(ne);
		jmiFont.addActionListener(ne);
		jmiNoteInfo.addActionListener(ne);
	}	// addActionListener

	public JMenuItem getJmiNewNote() {
		return jmiNewNote;
	}

	public JMenuItem getJmiOpenNote() {
		return jmiOpenNote;
	}

	public JMenuItem getJmiSaveNote() {
		return jmiSaveNote;
	}

	public JMenuItem getJmiSaveNewNote() {
		return jmiSaveNewNote;
	}

	public JMenuItem getJmiQuitNote() {
		return jmiQuitNote;
	}

	public JMenuItem getJmiLineWrap() {
		return jmiLineWrap;
	}

	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public JMenuItem getJmiNoteInfo() {
		return jmiNoteInfo;
	}

	public JTextArea getJtaNote() {
		return jtaNote;
	}

}	// class