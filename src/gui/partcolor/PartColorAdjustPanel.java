package gui.partcolor;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import app.Constants;

public class PartColorAdjustPanel extends JPanel implements AdjustmentListener, ActionListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// 画笔大小滚动条
	private JScrollBar			sizeScrollBar;

	// 画笔大小标签
	private JLabel				sizeLabel;

	// 画笔
	private JButton				paintButton;

	// 擦除
	private JButton				eraseButton;

	// 父面板
	private PartColorFrame		parent;

	public PartColorAdjustPanel(PartColorFrame parent) throws HeadlessException
	{
		this.setLayout(null);

		this.setParent(parent);

		initButtons();

		initSizeBarAndLabel();

		setBounds(PartColorSetting.ADJUST_PANEL_RECTANGLE);
	}

	/**
	 * 初始化画笔大小滚动条和标签
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("大小");
		sizeLabel.setBounds(PartColorSetting.SIZE_LABEL_RECTANGLE);

		int value = PartColorSetting.sizeValue;
		int extent = PartColorSetting.sizeExtent;
		int min = PartColorSetting.minSizeValue;
		int max = PartColorSetting.maxSizeValue;

		sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, value, extent, min, max);
		sizeScrollBar.setBounds(PartColorSetting.SIZE_SCROLLBAR_RECTANGLE);
		sizeScrollBar.setUnitIncrement(extent);
		sizeScrollBar.setBlockIncrement(extent);
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
		paintButton = new JButton("画笔");
		paintButton.setBounds(0, 0, 100, 40);
		paintButton.addActionListener(this);

		eraseButton = new JButton("橡皮擦");
		eraseButton.setBounds(100, 0, 100, 40);
		eraseButton.addActionListener(this);
		paintButton.setSelected(true);

		this.add(paintButton);
		this.add(eraseButton);

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == sizeScrollBar)
		{
			// sizeValue = e.getValue();
			PartColorSetting.sizeValue = e.getValue();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == paintButton)
		{
			// sizeValue = e.getValue();
			PartColorSetting.type = Constants.TYPE_ERASE;
		}

		if (e.getSource() == eraseButton)
		{
			PartColorSetting.type = Constants.TYPE_GRAY;
		}
	}

	public PartColorFrame getParent()
	{
		return parent;
	}

	public void setParent(PartColorFrame parent)
	{
		this.parent = parent;
	}
}
