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
	// 画笔大小滚动条
	private JScrollBar sizeScrollBar;

	// 模糊程度滚动条
	private JScrollBar levelScrollBar;

	// 画笔大小标签
	private JLabel sizeLabel;

	// 模糊程度标签
	private JLabel levelLabel;
	
	//画笔按钮
	private JButton paintButton;
	
	//橡皮按钮
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
	 * 初始化模糊力度滚动条和标签
	 * */
	private void initLevelBarAndLabel()
	{
		levelLabel = new JLabel("力度");
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
	 * 初始化切换按钮
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		paintButton = new JButton("画笔");
		paintButton.setBounds(0, 0, 100, 40);
		paintButton.addActionListener(this);
		
		eraserButton = new JButton("橡皮擦");
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
			//画笔实际上是在消除被模糊的部分
			BlurSetting.type = Constants.TYPE_ERASE;
		}
		if (e.getSource() == eraserButton)
		{
			//橡皮擦实际是在继续做模糊
			BlurSetting.type = Constants.TYPE_DOUBLE_GUASS_BLUR;
		}
	}

}
