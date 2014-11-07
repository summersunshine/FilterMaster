package gui.backgroundblur;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class BackgroundAdjustPanel extends JPanel implements AdjustmentListener
{
	private JScrollBar sizeScrollBar;
	private JScrollBar levelScrollBar;

	public BackgroundAdjustPanel() throws HeadlessException
	{
		sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 40, 1, 40, 200);
		sizeScrollBar.setUnitIncrement(5);
		sizeScrollBar.setBlockIncrement(10);
		sizeScrollBar.addAdjustmentListener(this);

		levelScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 40, 1, 40, 200);
		levelScrollBar.setUnitIncrement(5);
		levelScrollBar.setBlockIncrement(10);
		levelScrollBar.addAdjustmentListener(this);

		JLabel sizeLabel = new JLabel("大小");
		JLabel levelLabel = new JLabel("力度");

		this.setLayout(new GridLayout(8, 1, 10, 10));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.NONE;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(100, 10, 10, 10);
		// this.add(null);
		// this.add(null);
		this.add(sizeLabel);

		constraints.gridy = 1;
		constraints.insets = new Insets(20, 10, 100, 10);
		this.add(sizeScrollBar);

		constraints.gridy = 2;
		constraints.insets = new Insets(100, 10, 10, 10);
		this.add(levelLabel);

		constraints.gridy = 3;
		constraints.insets = new Insets(20, 10, 100, 10);
		this.add(levelScrollBar);

		setLocation(300, 200);
		setSize(400, 200);

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == sizeScrollBar)
		{
			BackgroundBlurFrame.sizeValue = e.getValue();
		}
		if (e.getSource() == levelScrollBar)
		{
			BackgroundBlurFrame.levelValue = e.getValue();
		}
	}

}
