package gui.compare;

import java.awt.Rectangle;

public class CompareSetting
{
	// 竖直放置
	public static final int TYPE_VETTICAL = 1;

	// 水平放置
	public static final int TYPE_HORIZONTAL = 2;

	// 放置类型
	public static int layoutType = TYPE_VETTICAL;

	//frame的宽度
	public static final int FRAME_WIDTH = 640;

	//frame的高度
	public static final int FRAME_HEIGHT = 720;

	//最大的图像宽度
	public static final int MAX_IMAGE_WDITH = 640;

	//最大的图像高度
	public static final int MAX_IMAGE_HEIGHT = 640;

	//图像面板的宽度
	public static final int IMAGE_PANEL_WIDTH = 640;

	//图像面板的高度
	public static final int IMAGE_PANEL_HEIGHT = 640;

	//frame宽度的一半
	public static final int FRAME_HALF_WIDTH = FRAME_WIDTH / 2;

	//vertical按钮的位置
	public static final Rectangle VERTICAL_BUTTON_TRCTANGLE = new Rectangle(FRAME_HALF_WIDTH - 100, 0, 100, 40);

	//horizontal按钮的位置
	public static final Rectangle HOZRIONTAL_BUTTON_RECTANGLE = new Rectangle(FRAME_HALF_WIDTH, 0, 100, 40);

	/**
	 * 使用width和height设置放置类型
	 * 
	 * @param width
	 * @param height
	 * */
	public static void setLayoutType(int width, int height)
	{
		if (width < height)
		{
			layoutType = TYPE_HORIZONTAL;
		}
		else
		{
			layoutType = TYPE_VETTICAL;
		}
	}

	/**
	 * 是否是竖直放置
	 * */
	public static boolean isVertical()
	{
		return layoutType == TYPE_VETTICAL;
	}

	/**
	 * 是否是水平放置
	 * */
	public static boolean isHorizontal()
	{
		return layoutType == TYPE_HORIZONTAL;
	}

}
