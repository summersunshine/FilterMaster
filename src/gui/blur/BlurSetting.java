package gui.blur;

import java.awt.Rectangle;

import app.Constants;

public class BlurSetting
{
	
	public static final int ADJUST_MODEL = 0;
	public static final int CONTORL_MODEL = 1;
	
	public static int model;
	
	//作用的坐标x
	public static int x;
	
	//作用的坐标y
	public static int y;
	
	// 类型
	public static int type = Constants.TYPE_ERASE;

	// 画笔的大小
	public static int sizeValue = 10;

	// 模糊的力度
	public static int levelValue = 3;
	
	//范围大小
	public static int rangeValue = 50;

	// 画笔大小的最小值
	public static final int minSizeValue = 10;

	// 画笔大小的最大值
	public static final int maxSizeValue = 100;

	// 画笔调节的间隔
	public static final int sizeExtent = 5;

	// 模糊力度最小值
	public static final int minLevelValue = 3;

	// 模糊力度最大值
	public static final int maxLevelValue = 11;

	// 模糊力度调节的间隔
	public static final int levelExtent = 2;
	
	//作用范围最小值
	public static final int minRangeValue = 20;
	
	//作用范围最大值
	public static final int maxRangeValue  = 300;
	
	//作用范围调节的间隔
	public static final int rangeExtent = 5;
	
	
	// adjustpanel的bounds
	public static final Rectangle TABBED_PANEL_RECTANGLE = new Rectangle(0, 200, 200, 400);

	// adjustpanel的bounds
	public static final Rectangle ADJUST_PANEL_RECTANGLE = new Rectangle(0, 200, 200, 300);

	// size label的bounds
	public static final Rectangle SIZE_LABEL_RECTANGLE = new Rectangle(100, 70, 30, 40);

	// size scrollbar的bounds
	public static final Rectangle SIZE_SCROLLBAR_RECTANGLE = new Rectangle(20, 100, 160, 20);

	// level label的bounds
	public static final Rectangle LEVEL_LABEL_RECTANGLE = new Rectangle(100, 170, 30, 40);

	// level scrollbar的bounds
	public static final Rectangle LEVEL_SCROLLBAR_RECTANGLE = new Rectangle(20, 200, 160, 20);
	
	
	// range label的bounds
	public static final Rectangle RANGE_LABEL_RECTANGLE = new Rectangle(100, 70, 30, 40);

	// range scrollbar的bounds
	public static final Rectangle RANGE_SCROLLBAR_RECTANGLE = new Rectangle(20, 100, 160, 20);
	

	// paint button的bounds
	public static final Rectangle PAINT_BUTTON_RECTANGLE = new Rectangle(0, 0, 100, 40);

	// erase button的bounds
	public static final Rectangle ERASE_BUTTON_RECTANGLE = new Rectangle(100, 0, 100, 40);
	
	// radial button的bounds
	public static final Rectangle RADIAL_BUTTON_RECTANGLE = new Rectangle(0, 0, 60, 40);

	// vertical button的bounds
	public static final Rectangle VERTICAL_BUTTON_RECTANGLE = new Rectangle(70, 0, 60, 40);
	
	//horziontal button bounds
	public static final Rectangle HORZIONTAL_BUTTON_RECTANGLE = new Rectangle(140,0,60,40);
	

}
