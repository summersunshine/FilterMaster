package gui.blur;

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

import app.Constants;

public class BlurAdjustPanel extends JPanel implements AdjustmentListener, ActionListener,MouseListener
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
	
	//������
	private BlurFrame parent;

	public BlurAdjustPanel(BlurFrame parent) throws HeadlessException
	{
		this.parent = parent;
		this.setLayout(null);

		initButtons();
		initSizeBarAndLabel();
		initLevelBarAndLabel();

		this.setBounds(BlurSetting.ADJUST_PANEL_RECTANGLE);
		levelScrollBar.addMouseListener(this);
	}

	/**
	 * ��ʼ�����ʴ�С�������ͱ�ǩ
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("��С");
		sizeLabel.setBounds(BlurSetting.SIZE_LABEL_RECTANGLE);

		int extent = BlurSetting.sizeExtent;
		int min = BlurSetting.minSizeValue;
		int max = BlurSetting.maxSizeValue;
		
		sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min,extent,min,max);
		sizeScrollBar.setBounds(BlurSetting.SIZE_SCROLLBAR_RECTANGLE);
		sizeScrollBar.setUnitIncrement(extent);
		sizeScrollBar.setBlockIncrement(extent);
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
		levelLabel.setBounds(BlurSetting.LEVEL_LABEL_RECTANGLE);

		int extent = BlurSetting.levelExtent;
		int min = BlurSetting.minLevelValue;
		int max = BlurSetting.maxLevelValue;
		
		levelScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min, extent, min, max);
		levelScrollBar.setBounds(BlurSetting.LEVEL_SCROLLBAR_RECTANGLE);
		levelScrollBar.setUnitIncrement(extent);
		levelScrollBar.setBlockIncrement(extent);
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
		paintButton.setBounds(BlurSetting.PAINT_BUTTON_RECTANGLE);
		paintButton.addActionListener(this);
		
		eraserButton = new JButton("��Ƥ��");
		eraserButton.setBounds(BlurSetting.ERASE_BUTTON_RECTANGLE);
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
			switchToPaint();
		}
		if (e.getSource() == eraserButton)
		{
			switchToEraser();
		}
	}
	
	/**
	 * �л�������
	 * */
	private void switchToPaint()
	{
		//����ʵ��������������ģ���Ĳ���
		BlurSetting.type = Constants.TYPE_ERASE;
		
		levelLabel.setVisible(true);
		levelScrollBar.setVisible(true);
		
	}
	
	/**
	 * �л�����Ƥ
	 * */
	private void switchToEraser()
	{
		// TODO Auto-generated method stub
		//��Ƥ��ʵ�����ڼ�����ģ��
		BlurSetting.type = Constants.TYPE_DOUBLE_GUASS_BLUR;
		
		levelLabel.setVisible(false);
		levelScrollBar.setVisible(false);
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
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
		parent.setImagePanel();
	}

}
