package gui.compare;

import java.awt.Rectangle;

public class CompareSetting
{
	// ��ֱ����
	public static final int TYPE_VETTICAL = 1;

	// ˮƽ����
	public static final int TYPE_HORIZONTAL = 2;

	// ��������
	public static int layoutType = TYPE_VETTICAL;

	//frame�Ŀ��
	public static final int FRAME_WIDTH = 640;

	//frame�ĸ߶�
	public static final int FRAME_HEIGHT = 720;

	//����ͼ����
	public static final int MAX_IMAGE_WDITH = 640;

	//����ͼ��߶�
	public static final int MAX_IMAGE_HEIGHT = 640;

	//ͼ�����Ŀ��
	public static final int IMAGE_PANEL_WIDTH = 640;

	//ͼ�����ĸ߶�
	public static final int IMAGE_PANEL_HEIGHT = 640;

	//frame��ȵ�һ��
	public static final int FRAME_HALF_WIDTH = FRAME_WIDTH / 2;

	//vertical��ť��λ��
	public static final Rectangle VERTICAL_BUTTON_TRCTANGLE = new Rectangle(FRAME_HALF_WIDTH - 100, 0, 100, 40);

	//horizontal��ť��λ��
	public static final Rectangle HOZRIONTAL_BUTTON_RECTANGLE = new Rectangle(FRAME_HALF_WIDTH, 0, 100, 40);

	/**
	 * ʹ��width��height���÷�������
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
	 * �Ƿ�����ֱ����
	 * */
	public static boolean isVertical()
	{
		return layoutType == TYPE_VETTICAL;
	}

	/**
	 * �Ƿ���ˮƽ����
	 * */
	public static boolean isHorizontal()
	{
		return layoutType == TYPE_HORIZONTAL;
	}

}
