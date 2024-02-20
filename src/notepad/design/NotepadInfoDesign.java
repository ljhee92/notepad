package notepad.design;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class NotepadInfoDesign extends JDialog implements ActionListener {
	
	private JScrollPane jsp;
	private JButton jbtnQuitInfo;
	
	public NotepadInfoDesign(NotepadDesign nd) {
		super(nd, "메모장 정보", true);
		
		addJTextArea();
		addJButton();
		
		setBounds(nd.getX()+120, nd.getY()+120, 250, 140);
		setVisible(true);
	}	// NotepadInfoDesign
	
	/**
	 * 도움말 정보 텍스트 부분을 추가하는 일
	 */
	private void addJTextArea() {
		JTextArea jtaNoteInfo = new JTextArea("Java 메모장 Version1.0\n"
				+ "이 메모장은 JHPL(JuHee Public License로서 아무나 가져다 변환 및 배포 가능합니다.\n"
				+ "편하게 가져다 사용해주세요.");
		jtaNoteInfo.setEditable(false);
		jtaNoteInfo.setLineWrap(true);	// 줄바꿈 설정
		jtaNoteInfo.setForeground(Color.gray);
		jsp = new JScrollPane(jtaNoteInfo);
		
		add(jsp, "Center");
	}	// addJTextArea
	
	/**
	 * 도움말 정보 닫기 버튼을 추가하는 일
	 */
	private void addJButton() {
		jbtnQuitInfo = new JButton("닫기");
		jbtnQuitInfo.addActionListener(this);
		
		// 버튼 크기 유지를 위한 패널 추가
		JPanel jp = new JPanel();
		jp.add(jbtnQuitInfo);
		
		add(jp, "South");
	}	// addJButton

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtnQuitInfo) {
			this.dispose();
		}	// end if
	}	// actionPerformed

}	// class