package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import algorithm.Constants;
import algorithm.basic.IntensityAndContrast;

public class BasicAdjustPanel extends JPanel implements AdjustmentListener,MouseListener
{

	private JScrollBar intensityScrollBar;
	private JScrollBar contrastScrollBar;
	private JScrollBar saturationScrollBar;
	private JScrollBar hueScrollBar;
	
	private JLabel intensityLabel;
	private JLabel contrastLabel;
	private JLabel saturationLabel;
	private JLabel hueLabel;
	
	//亮度
	public static int intensityValue;
	//对比度
	public static int contrastValue;
	//饱和度
	public static int saturationValue;
	//色相
	public static int hueValue;
	
	private static BasicAdjustPanel instance;
	
	public static BasicAdjustPanel getInstance()
	{
		if (instance == null)
		{
			instance = new BasicAdjustPanel();
		}
		return instance;
	}
	
	
	public BasicAdjustPanel() throws HeadlessException
	{
		intensityScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, -100, 100);
		intensityScrollBar.setUnitIncrement(5);
		intensityScrollBar.setBlockIncrement(10);
		intensityScrollBar.addAdjustmentListener(this);
		intensityScrollBar.addMouseListener(this);

		contrastScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, -100, 100);
		contrastScrollBar.setUnitIncrement(5);
		contrastScrollBar.setBlockIncrement(10);
		contrastScrollBar.addAdjustmentListener(this);
		contrastScrollBar.addMouseListener(this);
		
		saturationScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10,-100, 100);
		saturationScrollBar.setUnitIncrement(5);
		saturationScrollBar.setBlockIncrement(10);
		saturationScrollBar.addAdjustmentListener(this);
		saturationScrollBar.addMouseListener(this);

		hueScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10,-100, 100);
		hueScrollBar.setUnitIncrement(5);
		hueScrollBar.setBlockIncrement(10);
		hueScrollBar.addAdjustmentListener(this);
		hueScrollBar.addMouseListener(this);
		
		intensityLabel = new JLabel("亮度");
		contrastLabel = new JLabel("对比度");
		saturationLabel = new JLabel("饱和度");
		hueLabel = new JLabel("色相");

		this.setLayout(new GridLayout(8, 1));
		this.add(intensityLabel);
		this.add(intensityScrollBar);
		this.add(contrastLabel);
		this.add(contrastScrollBar);
		this.add(saturationLabel);
		this.add(saturationScrollBar);
		this.add(hueLabel);
		this.add(hueScrollBar);
		
		setLocation(0, 30);
		setSize(200, 300);

	}
	

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == intensityScrollBar)
		{
			intensityValue = e.getValue();
			
		}
		else if (e.getSource() == contrastScrollBar)
		{
			contrastValue = e.getValue();
		}
		else if (e.getSource() == saturationScrollBar)
		{
			saturationValue = e.getValue();
		}
		else
		{
			hueValue = e.getValue();
		}
		
	}

	

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
//		MainFrame.displayImage = IntensityAndContrast.getImage(MainFrame.sourceImage, intensityValue, contrastValue, 50);
//		MainFrame.paintImage();
		
		MainFrame.getInstance().setMainImagePanel(Constants.TYPE_INTENSITY_CONTRAST, intensityValue,contrastValue,50);
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
