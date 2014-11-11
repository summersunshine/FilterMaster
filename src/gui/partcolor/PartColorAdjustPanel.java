package gui.partcolor;

import gui.backgroundblur.BackgroundBlurFrame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import algorithm.Constants;

public class PartColorAdjustPanel extends JPanel implements AdjustmentListener, ActionListener
{
	// ���ʴ�С������
	private JScrollBar sizeScrollBar;

	// ���ʴ�С��ǩ
	private JLabel sizeLabel;
	
	//���
	private JButton addButton;
	
	//����
	private JButton eraseButton;

	//�����
	private PartColorFrame parent;

	public PartColorAdjustPanel(PartColorFrame parent) throws HeadlessException
	{
		this.setLayout(null);

		this.parent = parent;
		
		initButtons();
		
		initSizeBarAndLabel();

		setBounds(0, 200, 200, 200);
	}

	/**
	 * ��ʼ�����ʴ�С�������ͱ�ǩ
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("��С");
		sizeLabel.setBounds(100, 10, 30, 40);

		sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 40, 1, 40, 200);
		sizeScrollBar.setBounds(20, 40, 160, 20);
		sizeScrollBar.setUnitIncrement(5);
		sizeScrollBar.setBlockIncrement(10);
		sizeScrollBar.addAdjustmentListener(this);

		this.add(sizeLabel);
		this.add(sizeScrollBar);

	}

	/**
	 * ��ʼ����ť��
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		addButton = new JButton("���");
		addButton.setBounds(0, 0, 100, 40);
		addButton.addActionListener(this);
		
		eraseButton = new JButton("����");
		eraseButton.setBounds(100,0,100,40);
		eraseButton.addActionListener(this);
		addButton.setSelected(true);
		
		this.add(addButton);
		this.add(eraseButton);
		
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == sizeScrollBar)
		{
			//sizeValue = e.getValue();
			PartColorFrame.sizeValue = e.getValue();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == addButton)
		{
			//sizeValue = e.getValue();
			PartColorFrame.type = Constants.TYPE_ERASE;
		}
		
		if(e.getSource() == eraseButton)
		{
			PartColorFrame.type = Constants.TYPE_GRAY;
		}
	}
}
