package gui.backgroundblur;

import gui.MainFrame;
import gui.MainImagePanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

import algorithm.blur.DoubleGuassBlur;

public class BackgroundBlurFrame extends JFrame implements AdjustmentListener
{
	public static int sizeValue = 40;
	public static int levelValue = 40;

	public BufferedImage sourceImage;
	public BufferedImage displayImage;

	public BackgroundBlurImagePanel imagePanel;
	public BackgroundAdjustPanel adjustPanel;

	public BackgroundBlurFrame(BufferedImage image)
	{
		this.setSize(1280, 720);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sourceImage = image;
		displayImage = DoubleGuassBlur.getImage(image);
		// displayImage = image;

		initAdjustPanel();

		initImagePanel();

	}

	public void initAdjustPanel()
	{
		this.setLayout(new BorderLayout());

		adjustPanel = new BackgroundAdjustPanel();
		imagePanel = new BackgroundBlurImagePanel(displayImage);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.weighty = 1;
		constraints.weightx = 1;

		// constraints.fill = GridBagConstraints.REMAINDER;

		// getContentPane().add(adjustPanel,BorderLayout.WEST);
		// getContentPane().add(imagePanel,BorderLayout.CENTER);

		imagePanel.repaint();
	}

	public void initImagePanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.ipadx = 200;
		constraints.ipady = 720;

		getContentPane().add(adjustPanel, constraints);

		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;
		getContentPane().add(imagePanel, constraints);
		//
		imagePanel.repaint();
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub

	}

}
