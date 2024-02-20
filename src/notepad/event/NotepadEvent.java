package notepad.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import notepad.design.NotepadDesign;
import notepad.design.NotepadInfoDesign;

public class NotepadEvent extends WindowAdapter implements ActionListener {
	
	private NotepadDesign nd;
	
	public NotepadEvent(NotepadDesign nd) {
		this.nd = nd;
	}	// NotepadEvent

	/**
	 * 메뉴아이템을 클릭했을 때 실행되는 일
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 새글 클릭
		if(e.getSource() == nd.getJmiNewNote()) {
			System.out.println("메뉴 클릭 테스트");
		}	// end if
		
		// 열기 클릭 
		if(e.getSource() == nd.getJmiOpenNote()) {
			System.out.println("메뉴 클릭 테스트");
		}	// end if
		
		// 저장 클릭
		if(e.getSource() == nd.getJmiSaveNote()) {
			System.out.println("메뉴 클릭 테스트");
		}	// end if
		
		// 종료 클릭
		if(e.getSource() == nd.getJmiQuitNote()) {
			quitNotepad();
		}	// end if
		
		// 줄바꿈 클릭
		if(e.getSource() == nd.getJmiLineWrap()) {
			// 한 번 더 클릭 시 줄바꿈 해제
			if(nd.getJtaNote().getLineWrap()) {
				nd.getJtaNote().setLineWrap(false);
				return;
			}	// end if
			nd.getJtaNote().setLineWrap(true);
		}	// end if
				
		// 글꼴 클릭
		if(e.getSource() == nd.getJmiFont()) {
			System.out.println("메뉴 클릭 테스트");
		}	// end if
		
		// 메모장 정보 클릭
		if(e.getSource() == nd.getJmiNoteInfo()) {
			new NotepadInfoDesign(nd);
		}	// end if
		
	}	// actionPerformed

	/**
	 * 윈도우 창 종료 시 메모장 프로그램을 종료하는 method를 호출하는 일
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		quitNotepad();
	}	// windowClosing
	
	/**
	 * 메모장 프로그램을 종료하는 일
	 */
	private void quitNotepad() {
		nd.dispose();
	}	// quitNotepad

}	// class