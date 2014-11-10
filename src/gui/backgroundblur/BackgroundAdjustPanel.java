package gui.backgroundblur;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class BackgroundAdjustPanel extends JPanel implements AdjustmentListener
{
	// 画笔大小滚动条
	private JScrollBar sizeScrollBar;

	// 模糊程度滚动条
	private JScrollBar levelScrollBar;

	// 画笔大小标签
	private JLabel sizeLabel;

	// 模糊程度标签
	private JLabel levelLabel;

	public BackgroundAdjustPanel() throws HeadlessException
	{
		this.setLayout(null);

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

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == sizeScrollBar)
		{
			BackgroundBlurFrame.sizeValue = e.getValue();

		}
		if (e.getSource() == levelScrollBar)
		{
			BackgroundBlurFrame.levelValue = e.getValue();
		}
	}

}
