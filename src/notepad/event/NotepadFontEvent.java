package notepad.event;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import notepad.design.NotepadFontDesign;
import notepad.font.FontStyleStoI;

public class NotepadFontEvent extends WindowAdapter implements ActionListener, MouseListener {
	
	private NotepadFontDesign nfd;
	private JTextField jtfFont, jtfFontStyle, jtfFontSize;
	private DefaultListModel<String> dlmFont, dlmFontStyle;
	private DefaultListModel<Integer> dlmFontSize;
	private JList<String> jlFont, jlFontStyle;
	private JList<Integer> jlFontSize;
	private JLabel jlSample;
	private JTextArea jtaNote;
	private Font font;
	int selectedInd;
	FontStyleStoI fontStoI;
	
	public NotepadFontEvent(NotepadFontDesign nfd) {
		this.nfd = nfd;
		
		jtfFont = nfd.getJtfFont();
		jtfFontStyle = nfd.getJtfFontStyle();
		jtfFontSize = nfd.getJtfFontSize();
		
		jlFont = nfd.getJlFont();
		jlFontStyle = nfd.getJlFontStyle();
		jlFontSize = nfd.getJlFontSize();
		
		dlmFont = nfd.getDlmFont();
		dlmFontStyle = nfd.getDlmFontStyle();
		dlmFontSize = nfd.getDlmFontSize();
		
		jtaNote = nfd.getJtaNote();
		jlSample = nfd.getJlSample();
		
		fontStoI = new FontStyleStoI();
	}	// NotepadFontEvent

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nfd.getJbtnConfrim()) {
			setJtaFont();
		}	// end if
		
		if(e.getSource() == nfd.getJbtnCancel()) {
			quitFontDialog();
		}	// end if
	}	// actionPerformed
	
	/**
	 * 확인 버튼이 눌렸을 때 Notepad의 jta에 폰트를 설정하고 다이얼로그를 닫는 일
	 */
	private void setJtaFont() {
		jtaNote.setFont(font);
		quitFontDialog();
	}	// setJtaFont
	
	private void quitFontDialog() {
		nfd.dispose();
	}	// quitFontDialog

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == jlFont) {
			selectedInd = jlFont.getSelectedIndex();
			jtfFont.setText(dlmFont.getElementAt(selectedInd));
			setJlSampleFont(selectedInd);
		}	// end if
		
		if(e.getSource() == jlFontStyle) {
			selectedInd = jlFontStyle.getSelectedIndex();
			jtfFontStyle.setText(dlmFontStyle.getElementAt(selectedInd));
			setJlSampleFontStyle(selectedInd);
		}	// end if
		
		if(e.getSource() == jlFontSize) {
			selectedInd = jlFontSize.getSelectedIndex();
			jtfFontSize.setText(dlmFontSize.getElementAt(selectedInd).toString());
			setJlSampleFontSize(selectedInd);
		}	// end if
	}	// mouseClicked
	
	/**
	 * 리스트의 폰트명이 눌렸을 때 sample 라벨의 폰트를 설정하는 일
	 * @param selectedInd 눌린 폰트명의 인덱스
	 */
	private void setJlSampleFont(int selectedInd) {
		font = new Font(dlmFont.getElementAt(selectedInd), jlSample.getFont().getStyle(), jlSample.getFont().getSize());
		jlSample.setFont(font);
	}	// set Font
	
	/**
	 * 리스트의 폰트 스타일이 눌렸을 때 sample 라벨의 폰트 스타일을 설정하는 일
	 * @param selectedInd 눌린 폰트 스타일의 인덱스
	 */
	private void setJlSampleFontStyle(int selectedInd) {
		font = new Font(jlSample.getFont().getName(), fontStoI.getfStyleMap().get(dlmFontStyle.getElementAt(selectedInd)), jlSample.getFont().getSize());
		jlSample.setFont(font);
	}	// setFontStyle
	
	/**
	 * 리스트의 폰트 사이즈가 눌렸을 때 sample 라벨의 폰트 사이즈를 설정하는 일
	 * @param selectedInd 눌린 폰트 사이즈의 인덱스
	 */
	private void setJlSampleFontSize(int selectedInd) {
		font = new Font(jlSample.getFont().getName(), jlSample.getFont().getStyle(), dlmFontSize.getElementAt(selectedInd));
		jlSample.setFont(font);
	}	// setFontSize

	@Override
	public void mousePressed(MouseEvent e) {
		
	}	// mousePressed

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}	// mouseReleased

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}	// mouseEntered

	@Override
	public void mouseExited(MouseEvent e) {
		
	}	// mouseExited
	
}	// class