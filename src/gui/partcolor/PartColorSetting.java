package gui.partcolor;

import java.awt.Rectangle;

import app.Constants;

public class PartColorSetting
{
	//�˾�����
	public static int type = Constants.TYPE_ERASE;

	//���ʴ�С
	public static int sizeValue = 10;
	
	// ���ʴ�С����Сֵ
	public static final int minSizeValue = 10;

	// ���ʴ�С�����ֵ
	public static final int maxSizeValue = 100;

	// ���ʵ��ڵļ��
	public static final int sizeExtent = 5;
	
	
	// adjustpanel��bounds
	public static final Rectangle ADJUST_PANEL_RECTANGLE = new Rectangle(0, 200, 200, 300);
	
	
	// size label��bounds
	public static final Rectangle SIZE_LABEL_RECTANGLE = new Rectangle(100, 70, 30, 40);

	// size scrollbar��bounds
	public static final Rectangle SIZE_SCROLLBAR_RECTANGLE = new Rectangle(20, 100, 160, 20);
	
	
	// paint button��bounds
	public static final Rectangle PAINT_BUTTON_RECTANGLE = new Rectangle(0, 0, 100, 40);

	// erase button��bounds
	public static final Rectangle ERASE_BUTTON_RECTANGLE = new Rectangle(100, 0, 100, 40);
	
}
