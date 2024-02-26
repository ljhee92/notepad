package notepad.event;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import notepad.design.NotepadDesign;
import notepad.design.NotepadFontDesign;
import notepad.design.NotepadInfoDesign;

public class NotepadEvent extends WindowAdapter implements ActionListener {
	
	private NotepadDesign nd;
	private FileDialog fdOpen, fdSave;
	private String fdOpenDirectory, fdOpenFile, fdSaveDirectory, fdSaveFile;
	
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
			nd.getJtaNote().setText("");
		}	// end if
		
		// 열기 클릭 
		if(e.getSource() == nd.getJmiOpenNote()) {
			chkFileOpen();
		}	// end if
		
		// 저장 클릭
		if(e.getSource() == nd.getJmiSaveNote()) {
			chkFileSave();
		}	// end if
		
		// 새이름 저장 클릭
		if(e.getSource() == nd.getJmiSaveNewNote()) {
			saveNewFile();
		}	// end if
		
		// 종료 클릭
		if(e.getSource() == nd.getJmiQuitNote()) {
			quitNotepad();
		}	// end if
		
		// 줄바꿈 클릭
		if(e.getSource() == nd.getJmiLineWrap()) {
			setLineWrap();
		}	// end if
				
		// 글꼴 클릭
		if(e.getSource() == nd.getJmiFont()) {
			new NotepadFontDesign(nd);
		}	// end if
		
		// 메모장 정보 클릭
		if(e.getSource() == nd.getJmiNoteInfo()) {
			new NotepadInfoDesign(nd);
		}	// end if
		
	}	// actionPerformed
	
	
	/**
	 * 한 번이라도 열린 파일인지, 열리지 않은 파일인지 확인하는 일
	 */
	private void chkFileOpen() {
		// TextArea에 내용이 없는 상태(한 번이라도 열린 적이 없는 상태)
		if(nd.getJtaNote().getText().isEmpty()) {
			openFile();
			return;
		}	// end if
		
		// TextArea에 내용이 있는 상태
		if(!nd.getJtaNote().getText().isEmpty() && (nd.getTitle().equals("메모장-새글") || nd.getTitle().equals("메모장"))) {
			// 한 번이라도 열린 적이 없는 상태
			chkSave();
		} else {
			// 열린 적이 있는 상태
			chkChangeContents();
		}	// end else
	}	// chkFileSave
	
	/**
	 * 이전에 열기한 내용과 현재의 내용에 변경이 있는지 확인하는 일
	 */
	private void chkChangeContents() {
		int chkChange = JOptionPane.showConfirmDialog(nd, "변경된 내용이 있나요?");
		switch(chkChange) {
		case JOptionPane.CANCEL_OPTION : break;
		case JOptionPane.OK_OPTION : chkSave(); break;
		case JOptionPane.NO_OPTION : openFile();
		}	// end case
	}	// chkChangeContents
	
	/**
	 * 저장 여부를 확인하는 일
	 */
	private void chkSave() {
		int chkSave = JOptionPane.showConfirmDialog(nd, "저장하시겠습니까?");
		switch(chkSave) {
		case JOptionPane.CANCEL_OPTION : break;
		case JOptionPane.OK_OPTION : saveNewFile();
		case JOptionPane.NO_OPTION : openFile();
		}	// end case
	}	// chkSave
	
	/**
	 * 파일을 여는 일
	 */
	private void openFile() {
		fdOpen = new FileDialog(nd, "파일 열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		fdOpenDirectory = fdOpen.getDirectory();
		fdOpenFile = fdOpen.getFile();
		
		if(fdOpenDirectory == null) {
			return;
		}	// end if
		
		try {
			nd.setTitle(fdOpenDirectory + fdOpenFile);
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// openFile
	
	/**
	 * 선택한 파일을 불러오는 일
	 * @throws IOException 
	 */
	private void readFile() throws IOException {
		File readFile = new File(fdOpenDirectory + fdOpenFile);
		
		BufferedReader br = null;
		String readData = "";
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(readFile));
			
			while((readData = br.readLine()) != null) {
				sb.append(readData).append("\n");
			}	// end while
			readData = sb.toString();
			nd.getJtaNote().setText(readData);
		} finally {
			if(br != null) {
				br.close();
			}	// end if
		}	// end finally
	}	// readFile
	
	/**
	 * 저장을 위해 한 번이라도 열린 파일인지, 열리지 않은 파일인지 확인하는 일
	 */
	private void chkFileSave() {
		if(nd.getTitle().equals("메모장-새글") || nd.getTitle().equals("메모장")) {
			saveNewFile();
		} else {
			saveExistFile();
		}	// end else
	}	// chkFileSave
	
	/**
	 * 파일을 저장하는 일
	 */
	private void saveNewFile() {
		fdSave = new FileDialog(nd, "다른 이름으로 저장", FileDialog.SAVE);
		fdSave.setVisible(true);
		fdSaveDirectory = fdSave.getDirectory();
		fdSaveFile = fdSave.getFile();
		
		if(fdSaveDirectory == null) {
			return;
		}	// end if
		
		nd.setTitle(fdSaveDirectory + fdSaveFile + ".txt");
		writeFile();
	}	// saveFile
	
	/**
	 * 선택한 파일을 쓰는 일
	 */
	private void writeFile() {
		File saveFile = new File(fdSaveDirectory + fdSaveFile + ".txt");
		
		if(fdSave.getFile().endsWith(".txt")) {
			saveFile = new File(fdSaveDirectory + fdSaveFile);
		}	// end if
		
		try(FileWriter fw = new FileWriter(saveFile)) {
			fw.write(nd.getJtaNote().getText());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// writeFile
	
	/**
	 * 기존의 파일에 덮어쓰기 저장하는 일
	 */
	private void saveExistFile() {
		String fileTitle = nd.getTitle();
		File existFile = new File(fileTitle);
		
		try(FileWriter fw = new FileWriter(existFile)) {
			fw.write(nd.getJtaNote().getText());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// saveExistFile

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
	
	/**
	 * TextArea의 줄바꿈을 설정, 해제하는 일
	 */
	private void setLineWrap() {
		// 한 번 더 클릭 시 줄바꿈 해제
		if(nd.getJtaNote().getLineWrap()) {
			nd.getJtaNote().setLineWrap(false);
			return;
		}	// end if
		nd.getJtaNote().setLineWrap(true);
	}	// setLineWrap
}	// class