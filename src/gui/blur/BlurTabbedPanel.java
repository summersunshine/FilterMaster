package gui.blur;

import java.awt.image.BufferedImage;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import algorithm.blur.InteractiveBlur;
import app.Constants;

public class BlurTabbedPanel extends JTabbedPane implements ChangeListener
{
	
	
	BlurAdjustPanel adjustPanel;
	
	BlurControlPanel controlPanel;
	
	BlurFrame parent;
	
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
		// 获得选项卡标签
		String title = getTitleAt(selectedIndex);
		
		System.out.println("state change" + selectedIndex);
		
		if (selectedIndex == 0)
		{
			BlurSetting.model = BlurSetting.ADJUST_MODEL;
			BlurSetting.type = Constants.TYPE_DOUBLE_GUASS_BLUR;
		}
		else
		{
			BlurSetting.model = BlurSetting.CONTORL_MODEL;
			BlurSetting.type = InteractiveBlur.TYPE_CIRCLE;
		}
		
		parent.imagePanel.switchModel();
	}

}
