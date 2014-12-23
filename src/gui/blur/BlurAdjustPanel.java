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
	
	//父界面
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
	 * 初始化画笔大小滚动条和标签
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("大小");
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
	 * 初始化模糊力度滚动条和标签
	 * */
	private void initLevelBarAndLabel()
	{
		levelLabel = new JLabel("力度");
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
	 * 切换到画笔
	 * */
	private void switchToPaint()
	{
		//画笔实际上是在消除被模糊的部分
		BlurSetting.type = Constants.TYPE_ERASE;
		
		levelLabel.setVisible(true);
		levelScrollBar.setVisible(true);
		
	}
	
	/**
	 * 切换到橡皮
	 * */
	private void switchToEraser()
	{
		// TODO Auto-generated method stub
		//橡皮擦实际是在继续做模糊
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
