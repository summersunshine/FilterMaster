package gui.blur;

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

import algorithm.blur.InteractiveBlur;

public class BlurControlPanel extends JPanel implements ActionListener, AdjustmentListener,MouseListener
{
	
	//作用范围lebel
	private JLabel rangeLabel;
	
	// 作用范围滚动条
	private JScrollBar rangeScrollBar;
	
	public JButton radialButton;
	public JButton verticalButton;
	public JButton horziontalButton;
	
	public BlurFrame parent;
	
	public BlurControlPanel(BlurFrame parent)
	{
		this.setLayout(null);

		this.parent = parent;
		
		this.initButtons();
		
		this.initRangeBar();
		
		this.setBounds(BlurSetting.ADJUST_PANEL_RECTANGLE);
	}
	
	private void initButtons()
	{
		// TODO Auto-generated method stub
		radialButton = new JButton("圆形");
		radialButton.setBounds(BlurSetting.RADIAL_BUTTON_RECTANGLE);
		radialButton.addActionListener(this);
		
		verticalButton = new JButton("垂直");
		verticalButton.setBounds(BlurSetting.VERTICAL_BUTTON_RECTANGLE);
		verticalButton.addActionListener(this);
		
		horziontalButton = new JButton("水平");
		horziontalButton.setBounds(BlurSetting.HORZIONTAL_BUTTON_RECTANGLE);
		horziontalButton.addActionListener(this);
		
		this.add(radialButton);
		this.add(verticalButton);
		this.add(horziontalButton);
	}
	
	private void initRangeBar()
	{
		rangeLabel = new JLabel("范围");
		rangeLabel.setBounds(BlurSetting.RANGE_LABEL_RECTANGLE);

		int value = BlurSetting.rangeValue;
		int extent = BlurSetting.rangeExtent;
		int min = BlurSetting.minRangeValue;
		int max = BlurSetting.maxRangeValue;
		
		rangeScrollBar= new JScrollBar(JScrollBar.HORIZONTAL, value,extent,min,max);
		rangeScrollBar.setBounds(BlurSetting.RANGE_SCROLLBAR_RECTANGLE);
		rangeScrollBar.setUnitIncrement(extent);
		rangeScrollBar.setBlockIncrement(extent);
		rangeScrollBar.addAdjustmentListener(this);

		this.add(rangeLabel);
		this.add(rangeScrollBar);
		
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent event)
	{
		// TODO Auto-generated method stub
		if (event.getSource() == rangeScrollBar)
		{
			BlurSetting.rangeValue = event.getValue();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if (event.getSource() == radialButton)
		{
			BlurSetting.type = InteractiveBlur.TYPE_CIRCLE;
		}
		else if (event.getSource() == verticalButton)
		{
			BlurSetting.type = InteractiveBlur.TYPE_VERTCIAL;
		}
		else
		{
			BlurSetting.type = InteractiveBlur.TYPE_HORIZONTAL;
		}
		
		parent.imagePanel.switchModel();
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

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		parent.imagePanel.updateClearRange();
	}
	
	
	
}
