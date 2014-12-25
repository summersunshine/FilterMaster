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
 * ����������� �������ȣ��Աȶȣ����Ͷȣ�ɫ��ĵ���
 * */
public class BasicAdjustPanel extends JPanel implements AdjustmentListener, MouseListener
{

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	// ����
	public static int				intensityValue;
	// �Աȶ�
	public static int				contrastValue;
	// ���Ͷ�
	public static int				saturationValue;
	// ɫ��
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

	// ���Ȼ�����
	private JScrollBar	intensityScrollBar;

	// �ԱȶȻ�����
	private JScrollBar	contrastScrollBar;

	// ���ͶȻ�����
	private JScrollBar	saturationScrollBar;

	// ɫ�໬����
	private JScrollBar	hueScrollBar;

	// ���ȱ�ǩ
	private JLabel		intensityLabel;

	// �Աȶȱ�ǩ
	private JLabel		contrastLabel;

	// ���Ͷȱ�ǩ
	private JLabel		saturationLabel;

	// ɫ���ǩ
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
	 * ��ʼ�����Ȼ������ͱ�ǩ
	 * */
	private void initIntensityBarAndLabel()
	{
		intensityScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, -100, 100);
		intensityScrollBar.setUnitIncrement(5);
		intensityScrollBar.setBlockIncrement(10);
		intensityScrollBar.addAdjustmentListener(this);
		intensityScrollBar.addMouseListener(this);

		intensityLabel = new JLabel("����");

		this.add(intensityLabel);
		this.add(intensityScrollBar);

	}

	/**
	 * ��ʼ���ԱȶȻ������ͱ�ǩ
	 * */
	private void initContrastBarAndLabel()
	{
		contrastScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, -100, 100);
		contrastScrollBar.setUnitIncrement(5);
		contrastScrollBar.setBlockIncrement(10);
		contrastScrollBar.addAdjustmentListener(this);
		contrastScrollBar.addMouseListener(this);

		contrastLabel = new JLabel("�Աȶ�");

		this.add(contrastLabel);
		this.add(contrastScrollBar);

	}

	/**
	 * ��ʼ�����ͶȻ������ͱ�ǩ
	 * */
	private void initSaturationBarAndLabel()
	{
		saturationScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, -100, 100);
		saturationScrollBar.setUnitIncrement(5);
		saturationScrollBar.setBlockIncrement(10);
		saturationScrollBar.addAdjustmentListener(this);
		saturationScrollBar.addMouseListener(this);

		saturationLabel = new JLabel("���Ͷ�");

		this.add(saturationLabel);
		this.add(saturationScrollBar);

	}

	/**
	 * ��ʼ��ɫ�໬�����ͱ�ǩ
	 * */
	private void initHueBarAndLabel()
	{
		// TODO Auto-generated method stub
		hueScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, -100, 100);
		hueScrollBar.setUnitIncrement(5);
		hueScrollBar.setBlockIncrement(10);
		hueScrollBar.addAdjustmentListener(this);
		hueScrollBar.addMouseListener(this);

		hueLabel = new JLabel("ɫ��");

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
