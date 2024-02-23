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
import javax.swing.JTextField;

import notepad.design.NotepadFontDesign;
import notepad.font.FontStyle;
import notepad.font.FontStyleStoI;

public class NotepadFontEvent extends WindowAdapter implements ActionListener, MouseListener {
	
	private NotepadFontDesign nfd;
	private JTextField jtfFont, jtfFontStyle, jtfFontSize;
	private DefaultListModel<String> dlmFont, dlmFontStyle;
	private DefaultListModel<Integer> dlmFontSize;
	private JList<String> jlFont, jlFontStyle;
	private JList<Integer> jlFontSize;
	private JLabel jlSample;
	private Font font;
	
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
		
		jlSample = nfd.getJlSample();
	}	// NotepadFontEvent

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nfd.getJbtnConfrim()) {
			System.out.println("확인 버튼 클릭 테스트");
		}	// end if
		
		if(e.getSource() == nfd.getJbtnCancel()) {
			nfd.dispose();
		}	// end if
	}	// actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == jlFont) {
			jtfFont.setText(dlmFont.getElementAt(jlFont.getSelectedIndex()));
			setSample();
		}	// end if
		
		if(e.getSource() == jlFontStyle) {
			jtfFontStyle.setText(dlmFontStyle.getElementAt(jlFontStyle.getSelectedIndex()));
			setSample();
		}	// end if
		
		if(e.getSource() == jlFontSize) {
			jtfFontSize.setText(dlmFontSize.getElementAt(jlFontSize.getSelectedIndex()).toString());
			setSample();
		}	// end if
	}	// mouseClicked
	
	private void setSample() {
		jlSample.setFont(new Font(dlmFont.getElementAt(jlFont.getSelectedIndex()), 0, 15));
		for(FontStyle fontS : FontStyle.values()) {
			System.out.println(fontS);
		}
		
	}	// setSample

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