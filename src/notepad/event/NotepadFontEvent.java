package notepad.event;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import notepad.design.NotepadFontDesign;
import notepad.font.FontStyleItoS;
import notepad.font.FontStyleStoI;

public class NotepadFontEvent extends WindowAdapter implements ActionListener, MouseListener, Serializable {
	
	private static final long serialVersionUID = -1626206507790060971L;
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
	FontStyleItoS fontItoS;
	
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
		fontItoS = new FontStyleItoS();
	}	// NotepadFontEvent

	@Override
	public void actionPerformed(ActionEvent e) {
		// 확인 버튼 클릭
		if(e.getSource() == nfd.getJbtnConfrim()) {
			setJtaFont();
		}	// end if
		
		// 취소 버튼 클릭
		if(e.getSource() == nfd.getJbtnCancel()) {
			quitFontDialog();
		}	// end if
	}	// actionPerformed
	
	/**
	 * 확인 버튼이 눌렸을 때 Notepad의 jta에 폰트를 설정하고 다이얼로그를 닫는 일
	 */
	private void setJtaFont() {
		jtaNote.setFont(font);
		try {
			saveFont();
		} catch (NotSerializableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
 			quitFontDialog();
	}	// setJtaFont
	
	/**
	 * 설정한 폰트 객체를 bin 폴더 내부에 저장하는 일
	 * @throws IOException 
	 * @throws NotSerializableException 
	 */
	private void saveFont() throws NotSerializableException, IOException {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("/Users/juhee/eclipse-workspace/notepad/bin/font.txt"));
			oos.writeObject(font);
			oos.flush();
		} finally {
			if(oos != null) {
				oos.close();
			}	// end finally
		}	// end catch
	}	// saveFont
	
	/**
	 * 다이얼로그를 닫는 일
	 */
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

	/**
	 * 폰트 다이얼로그가 열렸을 때 TextArea에 설정되어있던 글꼴 정보가 TextField, sample 라벨에 적용되는 일
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		jtfFont.setText(jtaNote.getFont().getName());
		jtfFontStyle.setText(fontItoS.getfStyleMap().get(jtaNote.getFont().getStyle()));
		jtfFontSize.setText(Integer.toString(jtaNote.getFont().getSize()));
		
		jlSample.setFont(jtaNote.getFont());
	}	// windowOpened

	@Override
	public void windowClosing(WindowEvent e) {
		quitFontDialog();
	}	// windowClosing

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