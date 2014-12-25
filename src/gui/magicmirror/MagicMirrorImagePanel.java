package gui.magicmirror;

import filter.Filter;
import filter.factory.FilterFactory;
import filter.fun.ConcaveMirrorFilter;
import filter.fun.ConvexMirrorFilter;
import gui.base.BaseImagePanel;

import java.awt.image.BufferedImage;

import app.Constants;

public class MagicMirrorImagePanel extends BaseImagePanel
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private Filter				filter;

	public MagicMirrorImagePanel(BufferedImage image)
	{
		super(image);
		// TODO Auto-generated constructor stub
		sourceImage = image;

	}

	/**
	 * ����type��radius����ͼ��
	 * 
	 * @param type
	 *            ����
	 * @param radius
	 *            �뾶
	 * */
	public void updateImage(int type, float radius)
	{

		System.out.println("Type " + type + " radius " + radius);

		filter = FilterFactory.getFilter(MagicMirrorSetting.type);

		if (MagicMirrorSetting.type == Constants.TYPE_CONCAVE_MIRROIR)
		{
			ConcaveMirrorFilter.radius = radius;
		}
		else
		{
			ConvexMirrorFilter.radius = radius;
		}

		displayImage = filter.getImage(sourceImage);

		repaint();
	}
}
