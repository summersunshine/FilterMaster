package gui.partmosaic;

import gui.blur.BlurSetting;

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

public class PartMosaicAdjustPanel extends JPanel implements AdjustmentListener, ActionListener, MouseListener
{
	// 画笔大小滚动条
	private JScrollBar sizeScrollBar;

	// 模糊程度滚动条
	private JScrollBar patchScrollBar;

	// 画笔大小标签
	private JLabel sizeLabel;

	// 马赛克颗粒大小标签
	private JLabel patchLabel;

	// 画笔按钮
	private JButton paintButton;

	// 橡皮按钮
	private JButton eraserButton;

	// 父界面
	private PartMosaicFrame parent;

	public PartMosaicAdjustPanel() throws HeadlessException
	{
		this.setLayout(null);

		initButtons();
		initSizeBarAndLabel();
		initPatchBarAndLabel();

		setBounds(PartMosaicSetting.ADJUST_PANEL_RECTANGLE);
	}

	/**
	 * 初始化画笔大小滚动条和标签
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("画笔大小");
		sizeLabel.setBounds(PartMosaicSetting.SIZE_LABEL_RECTANGLE);

		int extent = PartMosaicSetting.sizeExtent;
		int min = PartMosaicSetting.minSizeValue;
		int max = PartMosaicSetting.maxSizeValue;

		sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min, extent, min, max);
		sizeScrollBar.setBounds(PartMosaicSetting.SIZE_SCROLLBAR_RECTANGLE);
		sizeScrollBar.setUnitIncrement(extent);
		sizeScrollBar.setBlockIncrement(extent);
		sizeScrollBar.addAdjustmentListener(this);

		this.add(sizeLabel);
		this.add(sizeScrollBar);

	}

	/**
	 * 初始化模糊力度滚动条和标签
	 * */
	private void initPatchBarAndLabel()
	{
		patchLabel = new JLabel("马赛克颗粒大小");
		patchLabel.setBounds(PartMosaicSetting.PATCH_LABEL_RECTANGLE);

		int extent = PartMosaicSetting.sizeExtent;
		int min = PartMosaicSetting.minSizeValue;
		int max = PartMosaicSetting.maxSizeValue;

		patchScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min, extent, min, max);
		patchScrollBar.setBounds(PartMosaicSetting.PATCH_SCROLLBAR_RECTANGLE);
		patchScrollBar.setUnitIncrement(extent);
		patchScrollBar.setBlockIncrement(extent);
		patchScrollBar.addAdjustmentListener(this);

		this.add(patchLabel);
		this.add(patchScrollBar);

	}

	/**
	 * 初始化切换按钮
	 * */
	private void initButtons()
	{
		// TODO Auto-generated method stub
		paintButton = new JButton("画笔");
		paintButton.setBounds(BlurSetting.PAINT_BUTTON_RECTANGLE);
		paintButton.addActionListener(this);

		eraserButton = new JButton("橡皮擦");
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
			PartMosaicSetting.sizeValue = e.getValue();
		}
		if (e.getSource() == patchScrollBar)
		{
			PartMosaicSetting.patchValue = e.getValue();
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
	 * 切换到画笔
	 * */
	private void switchToPaint()
	{
		PartMosaicSetting.type = Constants.TYPE_MOSIC;

	}

	/**
	 * 切换到橡皮
	 * */
	private void switchToEraser()
	{
		// TODO Auto-generated method stub
		PartMosaicSetting.type = Constants.TYPE_ERASE;

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
