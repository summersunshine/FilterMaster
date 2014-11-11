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
	// 画笔大小滚动条
	private JScrollBar sizeScrollBar;

	// 画笔大小标签
	private JLabel sizeLabel;
	
	//添加
	private JButton addButton;
	
	//擦除
	private JButton eraseButton;

	//父面板
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
	 * 初始化画笔大小滚动条和标签
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("大小");
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
	 * 初始化按钮们
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		addButton = new JButton("添加");
		addButton.setBounds(0, 0, 100, 40);
		addButton.addActionListener(this);
		
		eraseButton = new JButton("消除");
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
