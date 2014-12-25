package gui.blur;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.Constants;

public class BlurTabbedPanel extends JTabbedPane implements ChangeListener
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	BlurSmearPanel				adjustPanel;

	BlurTempletPanel			controlPanel;

	BlurFrame					parent;

	public BlurTabbedPanel(BlurFrame parent)
	{
		super(JTabbedPane.TOP);

		this.parent = parent;

		adjustPanel = new BlurSmearPanel(parent);

		controlPanel = new BlurTempletPanel(parent);

		this.addTab("Í¿Ä¨Ê½±³¾°Ä£ºý", adjustPanel);
		this.addTab("Ä£°åÊ½±³¾°Ä£ºý", controlPanel);

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
			BlurSetting.type = Constants.TYPE_CIRCLE_BLUR;
		}

		parent.getImagePanel().switchModel();
	}

}
