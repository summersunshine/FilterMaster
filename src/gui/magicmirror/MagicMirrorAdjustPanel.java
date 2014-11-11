package gui.magicmirror;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import algorithm.Constants;

public class MagicMirrorAdjustPanel extends JPanel implements AdjustmentListener, ActionListener, MouseListener
{

	// ����
	private int type;

	// �뾶
	private float radius;

	// ͹��
	private JButton convexButton;

	// ����
	private JButton concaveButton;

	// �����̶ȹ�����
	private JScrollBar levelScrollBar;

	// ������ǩ
	private JLabel levelLabel;

	// ������
	MagicMirrorFrame parent;

	public MagicMirrorAdjustPanel(MagicMirrorFrame parent) throws HeadlessException
	{
		this.setLayout(null);

		this.parent = parent;

		this.type = Constants.TYPE_MAGIC_MIRROIR_1;

		this.radius = 100;

		initLevelBarAndLabel();

		initButtons();

		this.addMouseListener(this);

		setBounds(0, 200, 200, 200);
	}

	/**
	 * ��ʼ���뾶�������ͱ�ǩ
	 * */
	private void initLevelBarAndLabel()
	{
		levelLabel = new JLabel("����");
		levelLabel.setBounds(100, 110, 30, 40);

		levelScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 2000);
		levelScrollBar.setBounds(20, 140, 160, 20);
		levelScrollBar.setUnitIncrement(5);
		levelScrollBar.setBlockIncrement(10);
		levelScrollBar.addAdjustmentListener(this);

		this.add(levelLabel);
		this.add(levelScrollBar);

	}

	/**
	 * ��ʼ����ť��
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		convexButton = new JButton("͹͸��");
		convexButton.setBounds(0, 0, 100, 40);
		convexButton.addActionListener(this);

		concaveButton = new JButton("��͸��");
		concaveButton.setBounds(100, 0, 100, 40);
		concaveButton.addActionListener(this);
		convexButton.setSelected(false);

		this.add(convexButton);
		this.add(concaveButton);

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == levelScrollBar)
		{
			radius = e.getValue();
			System.out.println(radius);
			parent.setImagePanel(radius, type);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == concaveButton)
		{
			concaveButton.setSelected(false);
			convexButton.setSelected(true);
			type = Constants.TYPE_MAGIC_MIRROIR_1;

			parent.setImagePanel(radius, type);
		}

		if (e.getSource() == convexButton)
		{
			convexButton.setSelected(false);
			concaveButton.setSelected(true);
			type = Constants.TYPE_MAGIC_MIRROIR_2;

			parent.setImagePanel(radius, type);
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		System.out.println("click");
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		parent.setImagePanel(radius, type);
	}
}
