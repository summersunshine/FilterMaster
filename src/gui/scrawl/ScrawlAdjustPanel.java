package gui.scrawl;

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

public class ScrawlAdjustPanel extends JPanel implements ActionListener, AdjustmentListener
{
	// 画笔大小滚动条
	private JScrollBar sizeScrollBar;

	// 画笔大小标签
	private JLabel sizeLabel;
	
	//涂鸦区域透明度滚动条
	private JScrollBar alphaScrollBar;
	
	//涂鸦区域透明度标签
	private JLabel alphaLabel;

	// 画笔
	private JButton paintButton;

	// 擦除
	private JButton eraseButton;

	// 父面板
	private ScrawlFrame parent;

	public ScrawlAdjustPanel(ScrawlFrame parent) throws HeadlessException
	{
		this.parent = parent;
		this.setBounds(ScrawlSetting.ADJUST_PANEL_RECTANGLE);
		this.setLayout(null);

		

		initSizeBarAndLabel();
		//initAlphaBarAndLabel();
		
		initButtons();
		
		setVisible(true);
	}

	/**
	 * 初始化画笔大小滚动条和标签
	 * */
	private void initSizeBarAndLabel()
	{
		sizeLabel = new JLabel("大小");
		sizeLabel.setBounds(ScrawlSetting.SIZE_LABEL_RECTANGLE);

		int extent = ScrawlSetting.sizeExtent;
		int min = ScrawlSetting.minSizeValue;
		int max = ScrawlSetting.maxSizeValue;

		sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min, extent, min, max);
		sizeScrollBar.setBounds(ScrawlSetting.SIZE_SCROLLBAR_RECTANGLE);
		sizeScrollBar.setUnitIncrement(extent);
		sizeScrollBar.setBlockIncrement(extent);
		sizeScrollBar.addAdjustmentListener(this);

		this.add(sizeLabel);
		this.add(sizeScrollBar);

	}
	
	/**
	 * 初始化涂鸦区域透明度滚动条和标签
	 * */
	private void initAlphaBarAndLabel()
	{
		alphaLabel = new JLabel("涂鸦透明");
		alphaLabel.setBounds(ScrawlSetting.ALPHA_LABEL_RECTANGLE);

		int extent = ScrawlSetting.alphaExtent;
		int min = ScrawlSetting.minAlphaValue;
		int max = ScrawlSetting.maxAlphaValue;

		alphaScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, min, extent, min, max);
		alphaScrollBar.setBounds(ScrawlSetting.ALPHA_SCROLLBAR_RECTANGLE);
		alphaScrollBar.setUnitIncrement(extent);
		alphaScrollBar.setBlockIncrement(extent);
		alphaScrollBar.addAdjustmentListener(this);

		this.add(alphaLabel);
		this.add(alphaScrollBar);
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
			ScrawlSetting.sizeValue = e.getValue();
		}
		
		if (e.getSource() == alphaScrollBar)
		{
			ScrawlSetting.alphaValue = e.getValue();
			
			parent.updateDrawingALpha();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == paintButton)
		{
			// sizeValue = e.getValue();
			ScrawlSetting.type = Constants.TYPE_BAISC;
		}

		if (e.getSource() == eraseButton)
		{
			ScrawlSetting.type = Constants.TYPE_ERASE;
		}
	}
}
