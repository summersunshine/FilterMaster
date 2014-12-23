package gui.blur;

import java.awt.Rectangle;

import app.Constants;

public class BlurSetting
{
	
	public static final int ADJUST_MODEL = 0;
	public static final int CONTORL_MODEL = 1;
	
	public static int model;
	
	//���õ�����x
	public static int x;
	
	//���õ�����y
	public static int y;
	
	// ����
	public static int type = Constants.TYPE_ERASE;

	// ���ʵĴ�С
	public static int sizeValue = 10;

	// ģ��������
	public static int levelValue = 3;
	
	//��Χ��С
	public static int rangeValue = 50;

	// ���ʴ�С����Сֵ
	public static final int minSizeValue = 10;

	// ���ʴ�С�����ֵ
	public static final int maxSizeValue = 100;

	// ���ʵ��ڵļ��
	public static final int sizeExtent = 5;

	// ģ��������Сֵ
	public static final int minLevelValue = 3;

	// ģ���������ֵ
	public static final int maxLevelValue = 11;

	// ģ�����ȵ��ڵļ��
	public static final int levelExtent = 2;
	
	//���÷�Χ��Сֵ
	public static final int minRangeValue = 20;
	
	//���÷�Χ���ֵ
	public static final int maxRangeValue  = 300;
	
	//���÷�Χ���ڵļ��
	public static final int rangeExtent = 5;
	
	
	// adjustpanel��bounds
	public static final Rectangle TABBED_PANEL_RECTANGLE = new Rectangle(0, 200, 200, 400);

	// adjustpanel��bounds
	public static final Rectangle ADJUST_PANEL_RECTANGLE = new Rectangle(0, 200, 200, 300);

	// size label��bounds
	public static final Rectangle SIZE_LABEL_RECTANGLE = new Rectangle(100, 70, 30, 40);

	// size scrollbar��bounds
	public static final Rectangle SIZE_SCROLLBAR_RECTANGLE = new Rectangle(20, 100, 160, 20);

	// level label��bounds
	public static final Rectangle LEVEL_LABEL_RECTANGLE = new Rectangle(100, 170, 30, 40);

	// level scrollbar��bounds
	public static final Rectangle LEVEL_SCROLLBAR_RECTANGLE = new Rectangle(20, 200, 160, 20);
	
	
	// range label��bounds
	public static final Rectangle RANGE_LABEL_RECTANGLE = new Rectangle(100, 70, 30, 40);

	// range scrollbar��bounds
	public static final Rectangle RANGE_SCROLLBAR_RECTANGLE = new Rectangle(20, 100, 160, 20);
	

	// paint button��bounds
	public static final Rectangle PAINT_BUTTON_RECTANGLE = new Rectangle(0, 0, 100, 40);

	// erase button��bounds
	public static final Rectangle ERASE_BUTTON_RECTANGLE = new Rectangle(100, 0, 100, 40);
	
	// radial button��bounds
	public static final Rectangle RADIAL_BUTTON_RECTANGLE = new Rectangle(0, 0, 60, 40);

	// vertical button��bounds
	public static final Rectangle VERTICAL_BUTTON_RECTANGLE = new Rectangle(70, 0, 60, 40);
	
	//horziontal button bounds
	public static final Rectangle HORZIONTAL_BUTTON_RECTANGLE = new Rectangle(140,0,60,40);
	

}
