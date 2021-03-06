package gui.preview;

import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.Constants;

public class PreviewTabbedPanel extends JTabbedPane implements ChangeListener
{

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;

	// 艺术化面板
	public PreviewListPanel			artPanel;

	// 基础面板
	public PreviewListPanel			basicPanel;

	// 模糊面板
	public PreviewListPanel			blurPanel;

	// lomo面板
	public PreviewListPanel			lomoPanel;

	// 风格化面板
	public PreviewListPanel			stylePanel;

	// 时尚面板
	public PreviewListPanel			fashionPanel;

	// 相框面板
	public PreviewListPanel			framePanel;

	public Vector<PreviewListPanel>	previewListPanels;

	private BufferedImage			previewImage;

	public PreviewTabbedPanel(BufferedImage previewImage)
	{
		super(JTabbedPane.LEFT);

		this.previewImage = previewImage;

		this.addChangeListener(this);

		initPreviewListPanels();
		repaintPreviewListPanels();

		// this.setSelectedIndex(5);
		this.setBounds(1040, 0, 240, 720);
		this.setVisible(true);

	}

	/**
	 * 使用预览图初始化所有的预览面板
	 * 
	 * @param previewImage
	 * */
	private void initPreviewListPanels()
	{
		previewListPanels = new Vector<>();
		artPanel = new PreviewListPanel(previewImage, Constants.TYPE_ART);
		basicPanel = new PreviewListPanel(previewImage, Constants.TYPE_BAISC);
		blurPanel = new PreviewListPanel(previewImage, Constants.TYPE_BLUR);
		lomoPanel = new PreviewListPanel(previewImage, Constants.TYPE_LOMO);
		stylePanel = new PreviewListPanel(previewImage, Constants.TYPE_STYLE);
		fashionPanel = new PreviewListPanel(previewImage, Constants.TYPE_FASHION);
		framePanel = new PreviewListPanel(previewImage, Constants.TYPE_FRAME);
		JScrollPane artScrollPane = new JScrollPane(artPanel);
		JScrollPane basicJScrollPane = new JScrollPane(basicPanel);

		this.addTab("Art", artScrollPane);
		this.addTab("Basic", basicJScrollPane);
		this.addTab("Blur", blurPanel);
		this.addTab("Lomo", lomoPanel);
		this.addTab("Style", stylePanel);
		this.addTab("Fashion", fashionPanel);
		this.addTab("Frame", framePanel);
	}

	/**
	 * 重画所有的面板
	 * */
	private void repaintPreviewListPanels()
	{
		artPanel.repaint();
		basicPanel.repaint();
		blurPanel.repaint();
		lomoPanel.repaint();
		stylePanel.repaint();
		fashionPanel.repaint();
		framePanel.repaint();
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		// TODO Auto-generated method stub
		// 获得选中的选项卡索引
		int selectedIndex = getSelectedIndex();
		// 获得选项卡标签
		// String title = getTitleAt(selectedIndex);

		System.out.println("state change" + selectedIndex);

	}

}
