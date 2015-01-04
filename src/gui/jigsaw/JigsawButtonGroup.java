package gui.jigsaw;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import util.image.AlphaMerge;

public class JigsawButtonGroup extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JigsawFrame			parent;
	private JButton				openButton;
	private JButton				openButton1;
	private JButton				openButton2;
	private JButton				openButton3;
	private JButton				openButton4;

	public JigsawButtonGroup(JigsawFrame parent)
	{
		this.parent = parent;
		initButtonGroup();
		this.setBounds(1040, 0, 240, 680);
		this.setVisible(true);
	}

	private void initButtonGroup()
	{
		openButton = new JButton("正常");
		openButton.setSize(100, 30);
		openButton.addActionListener(this);
		openButton1 = new JButton("从左到右");
		openButton1.setSize(100, 30);
		openButton1.addActionListener(this);
		openButton2 = new JButton("从右到左");
		openButton2.setSize(100, 30);
		openButton2.addActionListener(this);
		openButton3 = new JButton("从上到下");
		openButton3.setSize(100, 30);
		openButton3.addActionListener(this);
		openButton4 = new JButton("从下到上");
		openButton4.setSize(100, 30);
		openButton4.addActionListener(this);

		this.setLayout(new GridLayout(5, 1));

		add(openButton);
		add(openButton1);
		add(openButton2);
		add(openButton3);
		add(openButton4);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

		// System.out.println(e.getSource().toString());

		if (parent.getSecondSourceImage() == null)
		{
			JOptionPane.showConfirmDialog(null, "还未选择第二张图片", "提示", JOptionPane.YES_OPTION);
			return;
		}

		if (e.getSource() == openButton)
		{
			parent.setImagePanel(AlphaMerge.DIR_NO);

		}
		else if (e.getSource() == openButton1)
		{
			parent.setImagePanel(AlphaMerge.DIR_LEFT_2_RIGHT);

		}
		else if (e.getSource() == openButton2)
		{
			parent.setImagePanel(AlphaMerge.DIR_RIGHT_2_LEFT);

		}
		else if (e.getSource() == openButton3)
		{
			parent.setImagePanel(AlphaMerge.DIR_UP_2_DOWN);

		}
		else if (e.getSource() == openButton4)
		{
			parent.setImagePanel(AlphaMerge.DIR_DOWN_2_UP);
		}

	}
}
