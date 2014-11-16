package gui.scrawl;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class ScrawlColorSelectPanel extends JPanel implements AdjustmentListener
{
	private JScrollBar redScrollBar;
	private JScrollBar blueScrollBar;
	private JScrollBar greenScrollBar;

	private JLabel redLabel;
	private JLabel blueLabel;
	private JLabel greenLabel;

	private ScrawlFrame parent;

	private final Timer timer = new Timer();

	public ScrawlColorSelectPanel(ScrawlFrame parent) throws HeadlessException
	{
		this.setBounds(ScrawlSetting.COLOR_SELECT_PANEL_RECTANGLE);
		this.parent = parent;
		this.setLayout(null);
		this.initScrollBar();
		this.initLabel();
		this.setVisible(true);
		this.start();
	}

	public void start()
	{
		timer.schedule(new TimerTask()
		{
			public void run()
			{
				paintComponent();
				timer.cancel();
			}

		}, 1000, 100); // 每隔seconds秒运行一次函数doSomething()
	}

	/**
	 * 初始化滑动条
	 * */
	private void initScrollBar()
	{

		int init = ScrawlSetting.minColorValue;
		int min = ScrawlSetting.minColorValue;
		int max = ScrawlSetting.maxColorValue;
		int extent = ScrawlSetting.colorExtent;

		redScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, init, extent, min, max);
		redScrollBar.setBounds(ScrawlSetting.RED_SCROLLBAR_RECTANGLE);
		redScrollBar.setUnitIncrement(5);
		redScrollBar.setBlockIncrement(10);
		redScrollBar.addAdjustmentListener(this);

		greenScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, init, extent, min, max);
		greenScrollBar.setBounds(ScrawlSetting.GREEN_SCROLLBAR_RECTANGLE);
		greenScrollBar.setUnitIncrement(5);
		greenScrollBar.setBlockIncrement(10);
		greenScrollBar.addAdjustmentListener(this);

		blueScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, init, extent, min, max);
		blueScrollBar.setBounds(ScrawlSetting.BLUE_SCROLLBAR_RECTANGLE);
		blueScrollBar.setUnitIncrement(5);
		blueScrollBar.setBlockIncrement(10);
		blueScrollBar.addAdjustmentListener(this);

		this.add(redScrollBar);
		this.add(greenScrollBar);
		this.add(blueScrollBar);
	}

	/**
	 * 初始化标签
	 * */
	private void initLabel()
	{
		redLabel = new JLabel("红色");
		redLabel.setBounds(ScrawlSetting.RED_LABEL_RECTANGLE);

		greenLabel = new JLabel("绿色");
		greenLabel.setBounds(ScrawlSetting.GREEN_LABEL_RECTANGLE);

		blueLabel = new JLabel("蓝色");
		blueLabel.setBounds(ScrawlSetting.BLUE_LABEL_RECTANGLE);

		this.add(redLabel);
		this.add(greenLabel);
		this.add(blueLabel);
	}

	/**
	 * 绘制调色区域
	 * */
	public void paintComponent()
	{
		Graphics2D graphics2d = (Graphics2D) getGraphics();

		ScrawlSetting.updateBrushColor();

		graphics2d.setColor(ScrawlSetting.brushColor);
		graphics2d.fillRect(50, 0, 100, 100);

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == redScrollBar)
		{
			ScrawlSetting.redValue = e.getValue();
		}
		if (e.getSource() == blueScrollBar)
		{
			ScrawlSetting.blueValue = e.getValue();
		}
		if (e.getSource() == greenScrollBar)
		{
			ScrawlSetting.greenValue = e.getValue();
		}

		paintComponent();
	}
}
