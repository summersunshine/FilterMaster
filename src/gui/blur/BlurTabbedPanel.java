package gui.blur;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import filter.Blur.InteractiveBlur;
import app.Constants;

public class BlurTabbedPanel extends JTabbedPane implements ChangeListener
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	BlurAdjustPanel				adjustPanel;

	BlurControlPanel			controlPanel;

	BlurFrame					parent;

	public BlurTabbedPanel(BlurFrame parent)
	{
		super(JTabbedPane.BOTTOM);

		this.parent = parent;

		adjustPanel = new BlurAdjustPanel(parent);

		controlPanel = new BlurControlPanel(parent);

		this.addTab("Art", adjustPanel);
		this.addTab("Basic", controlPanel);

		this.addChangeListener(this);
		this.setBounds(BlurSetting.TABBED_PANEL_RECTANGLE);
		this.setVisible(true);

	}

	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		// TODO Auto-generated method stub
		int selectedIndex = getSelectedIndex();
		System.out.println("state change" + selectedIndex);

		if (selectedIndex == 0)
		{
			BlurSetting.model = BlurSetting.ADJUST_MODEL;
			BlurSetting.type = Constants.TYPE_GUASS_BLUR;
		}
		else
		{
			BlurSetting.model = BlurSetting.CONTORL_MODEL;
			BlurSetting.type = InteractiveBlur.TYPE_CIRCLE;
		}

		parent.imagePanel.switchModel();
	}

}
