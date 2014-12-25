package gui.main;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import util.image.IntensityAndContrast;
import util.image.SaturationAndHue;

/**
 * 基础调节面板 包括亮度，对比度，饱和度，色相的调节
 * */
public class BasicAdjustPanel extends JPanel implements AdjustmentListener, MouseListener
{

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	// 亮度
	public static int				intensityValue;
	// 对比度
	public static int				contrastValue;
	// 饱和度
	public static int				saturationValue;
	// 色相
	public static int				hueValue;

	private boolean					isAdjustIntensityAndContrast;

	private static BasicAdjustPanel	instance;

	public static BasicAdjustPanel getInstance()
	{
		if (instance == null)
		{
			instance = new BasicAdjustPanel();
		}
		return instance;
	}

	// 亮度滑动条
	private JScrollBar	intensityScrollBar;

	// 对比度滑动条
	private JScrollBar	contrastScrollBar;

	// 饱和度滑动条
	private JScrollBar	saturationScrollBar;

	// 色相滑动条
	private JScrollBar	hueScrollBar;

	// 亮度标签
	private JLabel		intensityLabel;

	// 对比度标签
	private JLabel		contrastLabel;

	// 饱和度标签
	private JLabel		saturationLabel;

	// 色相标签
	private JLabel		hueLabel;

	public BasicAdjustPanel() throws HeadlessException
	{

		this.setLayout(new GridLayout(8, 1));

		initIntensityBarAndLabel();

		initContrastBarAndLabel();

		initSaturationBarAndLabel();

		initHueBarAndLabel();

		isAdjustIntensityAndContrast = false;

		setBounds(0, 30, 200, 300);
	}

	/**
	 * 初始化亮度滑动条和标签
	 * */
	private void initIntensityBarAndLabel()
	{
		intensityScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, -100, 100);
		intensityScrollBar.setUnitIncrement(5);
		intensityScrollBar.setBlockIncrement(10);
		intensityScrollBar.addAdjustmentListener(this);
		intensityScrollBar.addMouseListener(this);

		intensityLabel = new JLabel("亮度");

		this.add(intensityLabel);
		this.add(intensityScrollBar);

	}

	/**
	 * 初始化对比度滑动条和标签
	 * */
	private void initContrastBarAndLabel()
	{
		contrastScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, -100, 100);
		contrastScrollBar.setUnitIncrement(5);
		contrastScrollBar.setBlockIncrement(10);
		contrastScrollBar.addAdjustmentListener(this);
		contrastScrollBar.addMouseListener(this);

		contrastLabel = new JLabel("对比度");

		this.add(contrastLabel);
		this.add(contrastScrollBar);

	}

	/**
	 * 初始化饱和度滑动条和标签
	 * */
	private void initSaturationBarAndLabel()
	{
		saturationScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, -100, 100);
		saturationScrollBar.setUnitIncrement(5);
		saturationScrollBar.setBlockIncrement(10);
		saturationScrollBar.addAdjustmentListener(this);
		saturationScrollBar.addMouseListener(this);

		saturationLabel = new JLabel("饱和度");

		this.add(saturationLabel);
		this.add(saturationScrollBar);

	}

	/**
	 * 初始化色相滑动条和标签
	 * */
	private void initHueBarAndLabel()
	{
		// TODO Auto-generated method stub
		hueScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, -100, 100);
		hueScrollBar.setUnitIncrement(5);
		hueScrollBar.setBlockIncrement(10);
		hueScrollBar.addAdjustmentListener(this);
		hueScrollBar.addMouseListener(this);

		hueLabel = new JLabel("色相");

		this.add(hueLabel);
		this.add(hueScrollBar);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == intensityScrollBar)
		{
			intensityValue = e.getValue();
			isAdjustIntensityAndContrast = true;
		}
		else if (e.getSource() == contrastScrollBar)
		{
			contrastValue = e.getValue();
			isAdjustIntensityAndContrast = true;
		}
		else if (e.getSource() == saturationScrollBar)
		{
			saturationValue = e.getValue();
			isAdjustIntensityAndContrast = false;
		}
		else
		{
			hueValue = e.getValue();
			isAdjustIntensityAndContrast = false;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		//
		if (isAdjustIntensityAndContrast)
		{
			BufferedImage sourceImage = MainFrame.getInstance().getSourceImage();
			BufferedImage displayImage = IntensityAndContrast.getImage(sourceImage, intensityValue, contrastValue);
			MainFrame.getInstance().setImagePanel(displayImage);
		}
		else
		{
			BufferedImage sourceImage = MainFrame.getInstance().getDisplayImage();
			BufferedImage displayImage = SaturationAndHue.getImage(sourceImage, intensityValue, contrastValue);
			MainFrame.getInstance().setImagePanel(displayImage);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
