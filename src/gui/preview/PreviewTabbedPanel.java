package gui.preview;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import algorithm.Constants;

public class PreviewTabbedPanel extends JTabbedPane
{

	public PreviewListPanel artPanel;
	public PreviewListPanel basicPanel;
	public PreviewListPanel blurPanel;
	public PreviewListPanel lomoPanel;
	public PreviewListPanel stylePanel;
	
	
	
	public PreviewTabbedPanel(BufferedImage previewImage)
	{
		super(JTabbedPane.LEFT);
		
		artPanel = new PreviewListPanel(previewImage, Constants.TYPE_ART);
		basicPanel = new PreviewListPanel(previewImage, Constants.TYPE_BAISC);
		blurPanel = new PreviewListPanel(previewImage, Constants.TYPE_BLUR);
		lomoPanel = new PreviewListPanel(previewImage, Constants.TYPE_LOMO);
		stylePanel = new PreviewListPanel(previewImage, Constants.TYPE_STYLE);
		
		this.addTab("Art",artPanel);
		this.addTab("Basic", basicPanel);
		this.addTab("Blur", blurPanel);
		this.addTab("Lomo", lomoPanel);
		this.addTab("Style", stylePanel);
		
		artPanel.repaint();
		basicPanel.repaint();
		blurPanel.repaint();
		lomoPanel.repaint();
		stylePanel.repaint();
		
		//this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		this.addChangeListener(new ChangeListener()
		{
			
			@Override
			public void stateChanged(ChangeEvent e)
			{
				// TODO Auto-generated method stub
	             int selectedIndex = getSelectedIndex();  //获得选中的选项卡索引
	             String title = getTitleAt(selectedIndex); //获得选项卡标签
	             System.out.println(title);
			}
		});
		
		this.setSelectedIndex(2);
		this.setSize(200, 720);
		this.setVisible(true);
		
	}
}
