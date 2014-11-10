package gui.preview;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import app.Global;

public class PreviewListPanelWithScrollBar extends JPanel implements AdjustmentListener
{
	// 如果现实内容超过了面板，就使用scrollBar
	private JScrollBar scrollBar;

	private PreviewListPanel previewListPanel;

	public PreviewListPanelWithScrollBar(BufferedImage previewImage, int type)
	{
		initPrevieListPanel(previewImage, type);
		initScrollBar();

		// this.setBounds(0, 0, 280, 720);
	}

	private void initPrevieListPanel(BufferedImage previewImage, int type)
	{
		previewListPanel = new PreviewListPanel(previewImage, type);
		previewListPanel.setBounds(0, 0, 240, 720);
		add(previewListPanel);
		repaint();
	}

	private void initScrollBar()
	{
		int contentHeight = previewListPanel.getContentHeight();
		if (contentHeight > Global.SCREEN_HEIGHT)
		{
			return;
		}

		int difference = contentHeight - Global.SCREEN_HEIGHT;
		scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, difference);
		scrollBar.setBounds(200, 0, 40, 720);
		scrollBar.setUnitIncrement(5);
		scrollBar.setBlockIncrement(10);
		scrollBar.addAdjustmentListener(this);
		add(scrollBar);

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == scrollBar)
		{
			// scrollBar.setLocation(scrollBar.getX(), scrollBar.);
			previewListPanel.setLocation(this.getX(), -scrollBar.getValue());
		}
	}
}
