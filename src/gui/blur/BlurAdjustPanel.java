package gui.blur;

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

public class BlurAdjustPanel extends JPanel implements AdjustmentListener, ActionListener
{
	// ���ʴ�С������
	private JScrollBar sizeScrollBar;

	// ģ���̶ȹ�����
	private JScrollBar levelScrollBar;

	// ���ʴ�С��ǩ
	private JLabel sizeLabel;

	// ģ���̶ȱ�ǩ
	private JLabel levelLabel;
	
	//���ʰ�ť
	private JButton paintButton;
	
	//��Ƥ��ť
	private JButton eraserButton;

	public BlurAdjustPanel() throws HeadlessException
	{
		this.setLayout(null);

		initButtons();
		initSizeBarAndLabel();
		initLevelBarAndLabel();

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
	 * ��ʼ��ģ�����ȹ������ͱ�ǩ
	 * */
	private void initLevelBarAndLabel()
	{
		levelLabel = new JLabel("����");
		levelLabel.setBounds(100, 110, 30, 40);

		levelScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 40, 1, 40, 200);
		levelScrollBar.setBounds(20, 140, 160, 20);
		levelScrollBar.setUnitIncrement(5);
		levelScrollBar.setBlockIncrement(10);
		levelScrollBar.addAdjustmentListener(this);

		this.add(levelLabel);
		this.add(levelScrollBar);

	}
	
	/**
	 * ��ʼ���л���ť
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		paintButton = new JButton("����");
		paintButton.setBounds(0, 0, 100, 40);
		paintButton.addActionListener(this);
		
		eraserButton = new JButton("��Ƥ��");
		eraserButton.setBounds(100,0,100,40);
		eraserButton.addActionListener(this);
		
		this.add(paintButton);
		this.add(eraserButton);
		
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == sizeScrollBar)
		{
			BlurSetting.sizeValue = e.getValue();
		}
		if (e.getSource() == levelScrollBar)
		{
			BlurSetting.levelValue = e.getValue();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == paintButton)
		{
			//����ʵ��������������ģ���Ĳ���
			BlurSetting.type = Constants.TYPE_ERASE;
		}
		if (e.getSource() == eraserButton)
		{
			//��Ƥ��ʵ�����ڼ�����ģ��
			BlurSetting.type = Constants.TYPE_DOUBLE_GUASS_BLUR;
		}
	}

}
