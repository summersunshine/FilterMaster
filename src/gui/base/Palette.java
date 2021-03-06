package gui.base;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Palette extends JFrame implements AdjustmentListener
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JScrollBar			redScrollBar;
	private JScrollBar			blueScrollBar;
	private JScrollBar			greenScrollBar;

	private JLabel				lbScale;
	private JLabel				lbRedScale;
	private JLabel				lbBlueScale;
	private JLabel				lbGreenScale;
	private JPanel				lbColorPallet;

	private int					redValue;
	private int					blueValue;
	private int					greenValue;

	public Palette(String title) throws HeadlessException
	{
		super(title);
		redScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 265);
		redScrollBar.setUnitIncrement(5);
		redScrollBar.setBlockIncrement(10);
		redScrollBar.addAdjustmentListener(this);

		blueScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 265);
		blueScrollBar.setUnitIncrement(5);
		blueScrollBar.setBlockIncrement(10);
		blueScrollBar.addAdjustmentListener(this);

		greenScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 265);
		greenScrollBar.setUnitIncrement(5);
		greenScrollBar.setBlockIncrement(10);
		greenScrollBar.addAdjustmentListener(this);

		lbScale = new JLabel("刻度：red:0 blue:0 green:0");
		lbRedScale = new JLabel("红色");
		lbBlueScale = new JLabel("蓝色");
		lbGreenScale = new JLabel("绿色");
		lbColorPallet = new JPanel();
		lbColorPallet.setSize(200, 200);
		lbColorPallet.setBackground(new Color(0, 0, 0));
		// lbColorPallet.setBorder(BorderFactory.createEmptyBorder());
		lbColorPallet.setOpaque(true);

		Container panel = getContentPane();
		panel.setLayout(new GridLayout(8, 1));
		panel.add(lbScale);
		panel.add(lbColorPallet);
		panel.add(lbRedScale);
		panel.add(redScrollBar);
		panel.add(lbBlueScale);
		panel.add(blueScrollBar);
		panel.add(lbGreenScale);
		panel.add(greenScrollBar);
		setLocation(300, 200);
		setSize(400, 200);
		setVisible(true);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == redScrollBar)
		{
			redValue = e.getValue();
		}
		if (e.getSource() == blueScrollBar)
		{
			blueValue = e.getValue();
		}
		if (e.getSource() == greenScrollBar)
		{
			greenValue = e.getValue();
		}
		lbScale.setText("刻度：" + "red:" + redValue + "blue:" + blueValue + "green:" + greenValue);

		paintComponent();
	}

	protected void paintComponent()
	{
		Graphics2D graphics2d = (Graphics2D) getContentPane().getGraphics();

		graphics2d.setColor(new Color((int) redValue, (int) greenValue, (int) blueValue));
		graphics2d.fillRect(0, 0, 100, 100);

	}

}
