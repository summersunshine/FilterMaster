package gui.preview;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.text.BreakIterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.xml.ws.handler.MessageContext.Scope;

import algorithm.Constants;
import app.Global;

public class PreviewListPanel extends JScrollPane
{
	// 类型列表
	private int[] typeList;

	// 描述列表
	private String[] describeList;

	// 现实内容的高度
	private int contentHeight;

	public PreviewListPanel(BufferedImage previewImage, int type)
	{

		initTypeList(type);
		initDescribeList(type);
		initPanel(previewImage);
	}

	/**
	 * 依据type初始化typelist
	 * 
	 * @param type
	 * */
	private void initTypeList(int type)
	{
		switch (type)
		{
		case Constants.TYPE_ART:
			typeList = Constants.TYPE_ALPA_LIST;
			break;
		case Constants.TYPE_BAISC:
			typeList = Constants.TYPE_BASIC_LIST;
			break;
		case Constants.TYPE_BLUR:
			typeList = Constants.TYPE_BLUR_LIST;
			break;
		case Constants.TYPE_LOMO:
			typeList = Constants.TYPE_LOMO_LIST;
			break;
		case Constants.TYPE_STYLE:
			typeList = Constants.TYPE_STYLE_LIST;
			break;

		default:
			typeList = null;
			break;
		}
	}

	/**
	 * 依据type初始化desribe list
	 * 
	 * @param type
	 * */
	private void initDescribeList(int type)
	{
		switch (type)
		{
		case Constants.TYPE_ART:
			describeList = Constants.DESCRIBE_ART_LIST;
			break;
		case Constants.TYPE_BAISC:
			describeList = Constants.DESCRIBE_BASIC_LIST;
			break;
		case Constants.TYPE_BLUR:
			describeList = Constants.DESCRIBE_BLUR_LIST;
			break;
		case Constants.TYPE_LOMO:
			describeList = Constants.DESCRIBE_LOMO_LIST;
			break;
		case Constants.TYPE_STYLE:
			describeList = Constants.DESCRIBE_STYLE_LIST;
			break;

		default:
			typeList = null;
			break;
		}
	}

	/**
	 * 依据源预览图像生产其他的效果预览图
	 * 
	 * @param previewImage
	 * */
	private void initPanel(BufferedImage previewImage)
	{
		contentHeight = 0;
		this.setLayout(null);
		for (int i = 0; i < typeList.length; i++)
		{
			JLabel label = new JLabel(describeList[i]);
			label.setBounds(20, i * 150, 200, 50);
			add(label);

			PreviewPanel previewPanel = new PreviewPanel(typeList[i], previewImage);
			previewPanel.setBounds(20, i * 150 + 50, 200, 100);
			add(previewPanel);
			previewPanel.repaint();

			contentHeight += 150;
		}

		this.setPreferredSize(new Dimension(240, 800));
	}

	public int getContentHeight()
	{
		return contentHeight;
	}

}
