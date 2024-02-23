package notepad.design;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import notepad.event.NotepadFontEvent;
import notepad.font.Font;
import notepad.font.FontStyle;

@SuppressWarnings("serial")
public class NotepadFontDesign extends JDialog {
	
	private JTextField jtfFont, jtfFontStyle, jtfFontSize;
	private DefaultListModel<String> dlmFont, dlmFontStyle;
	private DefaultListModel<Integer> dlmFontSize;
	private JList<String> jlFont, jlFontStyle;
	private JList<Integer> jlFontSize;
	private JButton jbtnConfrim, jbtnCancel;
	private JLabel jlSample;
	
	public NotepadFontDesign(NotepadDesign nd) {
		super(nd, "글꼴", true);
		setLayout(null);
		
		addLabel();
		addTextField();
		addList();
		addButton();
		addListener();
		
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
		jlSample = new JLabel("AaBbYyZz");
		
		jlFont.setBounds(10, 15, 100, 30);
		jlStyle.setBounds(180, 15, 100, 30);
		jlSize.setBounds(340, 15, 80, 30);
		jlSample.setBounds(180, 190, 230, 100);
		
		jlSample.setHorizontalAlignment(JLabel.CENTER);
		jlSample.setBorder(new TitledBorder("보기"));
		
		add(jlFont);
		add(jlStyle);
		add(jlSize);
		add(jlSample);
	}	// addLabel
	
	/**
	 * 텍스트 필드를 추가하는 일
	 */
	private void addTextField() {
		jtfFont = new JTextField();
		jtfFontStyle = new JTextField();
		jtfFontSize = new JTextField();
		
		jtfFont.setBounds(10, 45, 150, 30);
		jtfFontStyle.setBounds(180, 45, 140, 30);
		jtfFontSize.setBounds(340, 45, 80, 30);
		
		add(jtfFont);
		add(jtfFontStyle);
		add(jtfFontSize);
	}	// addTextField
	
	/**
	 * 리스트를 추가하는 일
	 */
	private void addList() {
		dlmFont = new DefaultListModel<String>();
		jlFont = new JList<String>(dlmFont);
		JScrollPane jspFont = new JScrollPane(jlFont);
		
		dlmFontStyle = new DefaultListModel<String>();
		jlFontStyle = new JList<String>(dlmFontStyle);
		JScrollPane jspFontStyle = new JScrollPane(jlFontStyle);
		
		dlmFontSize = new DefaultListModel<Integer>();
		jlFontSize = new JList<Integer>(dlmFontSize);
		JScrollPane jspFontSize = new JScrollPane(jlFontSize);

		for(Font font : Font.values()) {
			dlmFont.addElement(font.getName());
		}	// end for

		for(FontStyle fontStyle : FontStyle.values()) {
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
	
	/**
	 * 버튼을 추가하는 일
	 */
	private void addButton() {
		jbtnConfrim = new JButton("확인");
		jbtnCancel = new JButton("취소");
		
		jbtnConfrim.setBounds(185, 310, 100, 35);
		jbtnCancel.setBounds(305, 310, 100, 35);
		
		add(jbtnConfrim);
		add(jbtnCancel);
	}	// addButton
	
	/**
	 * 리스트, 버튼에 리스너를 추가하는 일
	 */
	private void addListener() {
		NotepadFontEvent nfe = new NotepadFontEvent(this);
		
		addWindowListener(nfe);
		
		jlFont.addMouseListener(nfe);
		jlFontStyle.addMouseListener(nfe);
		jlFontSize.addMouseListener(nfe);
		
		jbtnConfrim.addActionListener(nfe);
		jbtnCancel.addActionListener(nfe);
	}	// addActionListener

	public JList<String> getJlFont() {
		return jlFont;
	}

	public JList<String> getJlFontStyle() {
		return jlFontStyle;
	}

	public JList<Integer> getJlFontSize() {
		return jlFontSize;
	}

	public DefaultListModel<String> getDlmFont() {
		return dlmFont;
	}

	public DefaultListModel<String> getDlmFontStyle() {
		return dlmFontStyle;
	}

	public DefaultListModel<Integer> getDlmFontSize() {
		return dlmFontSize;
	}

	public JButton getJbtnConfrim() {
		return jbtnConfrim;
	}

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}

	public JTextField getJtfFont() {
		return jtfFont;
	}

	public JTextField getJtfFontStyle() {
		return jtfFontStyle;
	}

	public JTextField getJtfFontSize() {
		return jtfFontSize;
	}

	public JLabel getJlSample() {
		return jlSample;
	}

}	// class