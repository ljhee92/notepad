package notepad.design;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import notepad.font.Font;
import notepad.font.FontStyle;

@SuppressWarnings("serial")
public class NotepadFontDesign extends JDialog {
	
	private JTextField jtfFont, jtfStyle, jtfSize;
	
	public NotepadFontDesign(NotepadDesign nd) {
		super(nd, "글꼴", true);
		setLayout(null);
		
		addLabel();
		addTextField();
		addList();
		
		setBounds(nd.getX()+20, nd.getY()+20, 455, 400);
		setResizable(false);
		setVisible(true);
	}	// NotepadFontDesign
	
	/**
	 * 라벨을 추가하는 일
	 */
	private void addLabel() {
		JLabel jlFont = new JLabel("글꼴(F):");
		JLabel jlStyle = new JLabel("글꼴 스타일(Y):");
		JLabel jlSize = new JLabel("크기(S):");
		
		jlFont.setBounds(10, 15, 100, 30);
		jlStyle.setBounds(180, 15, 100, 30);
		jlSize.setBounds(340, 15, 80, 30);
		
		add(jlFont);
		add(jlStyle);
		add(jlSize);
	}	// addLabel
	
	/**
	 * 텍스트 필드를 추가하는 일
	 */
	private void addTextField() {
		jtfFont = new JTextField();
		jtfStyle = new JTextField();
		jtfSize = new JTextField();
		
		jtfFont.setBounds(10, 45, 150, 30);
		jtfStyle.setBounds(180, 45, 140, 30);
		jtfSize.setBounds(340, 45, 80, 30);
		
		add(jtfFont);
		add(jtfStyle);
		add(jtfSize);
	}	// addTextField
	
	/**
	 * 리스트를 추가하는 일
	 */
	private void addList() {
		DefaultListModel<String> dlmFont = new DefaultListModel<String>();
		JList<String> jlFont = new JList<String>(dlmFont);
		JScrollPane jspFont = new JScrollPane(jlFont);
		
		DefaultListModel<String> dlmFontStyle = new DefaultListModel<String>();
		JList<String> jlFontStyle = new JList<String>(dlmFontStyle);
		JScrollPane jspFontStyle = new JScrollPane(jlFontStyle);
		
		DefaultListModel<Integer> dlmFontSize = new DefaultListModel<Integer>();
		JList<Integer> jlFontSize = new JList<Integer>(dlmFontSize);
		JScrollPane jspFontSize = new JScrollPane(jlFontSize);

		for(Font font : Font.GOTHIC.values()) {
			dlmFont.addElement(font.getName());
		}	// end for

		for(FontStyle fontStyle : FontStyle.PLAIN.values()) {
			dlmFontStyle.addElement(fontStyle.getName());
		}	// end for
		
		for(int i = 8; i < 12; i++) {
			dlmFontSize.addElement(i);
		}	// end for
		
		for(int i = 12; i < 81; i+=2) {
			dlmFontSize.addElement(i);
		}	// end for
		
		jspFont.setBounds(10, 80, 150, 100);
		jspFontStyle.setBounds(180, 80, 140, 100);
		jspFontSize.setBounds(340, 80, 80, 100);
		
		add(jspFont);
		add(jspFontStyle);
		add(jspFontSize);
	}	// addList

}	// class