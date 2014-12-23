package gui.scrawl;

import java.awt.Color;
import java.awt.Rectangle;

import app.Constants;

public class ScrawlSetting
{

	public static int type = Constants.TYPE_BAISC;

	// 画笔大小
	public static int sizeValue = 10;

	// 画笔大小 最小值
	public static final int minSizeValue = 10;

	// 画笔大小 最大值
	public static final int maxSizeValue = 100;

	// 画笔调节 间隔
	public static final int sizeExtent = 5;

	// Alpha大小 最小值
	public static final int minAlphaValue = 0;

	// Alpha大小 最大值
	public static final int maxAlphaValue = 255;

	//Alpha调节 间隔
	public static final int alphaExtent = 5;
	
	
	//颜色最小值
	public static final int minColorValue = 0;

	//颜色最大值
	public static final int maxColorValue = 255;

	//颜色间隔
	public static final int colorExtent = 1;

	//R
	public static int redValue = minColorValue;
	
	//G
	public static int greenValue = minColorValue;
	
	//B
	public static int blueValue = minColorValue;
	
	//A
	public static int alphaValue = maxAlphaValue;
	
	//brush color
	public static Color brushColor = new Color(redValue,greenValue,blueValue,alphaValue);

	public static void updateBrushColor()
	{
		brushColor = new Color(redValue,greenValue, blueValue,alphaValue);
	}

	// adjustpanel bounds
	public static final Rectangle ADJUST_PANEL_RECTANGLE = new Rectangle(0, 0, 200, 175);

	// color select panel bounds
	public static final Rectangle COLOR_SELECT_PANEL_RECTANGLE = new Rectangle(0, 200, 200, 300);

	// size label bounds
	public static final Rectangle SIZE_LABEL_RECTANGLE = new Rectangle(100, 75, 30, 40);

	// size scrollbar bounds
	public static final Rectangle SIZE_SCROLLBAR_RECTANGLE = new Rectangle(20, 100, 160, 20);

	// size label bounds
	public static final Rectangle ALPHA_LABEL_RECTANGLE = new Rectangle(100, 125, 30, 40);

	// size scrollbar bounds
	public static final Rectangle ALPHA_SCROLLBAR_RECTANGLE = new Rectangle(20, 150, 160, 20);
	
	// paint button bounds
	public static final Rectangle PAINT_BUTTON_RECTANGLE = new Rectangle(0, 0, 100, 40);

	// erase button bounds
	public static final Rectangle ERASE_BUTTON_RECTANGLE = new Rectangle(100, 0, 100, 40);

	// red scrollbar bounds
	public static final Rectangle RED_SCROLLBAR_RECTANGLE = new Rectangle(20, 150, 160, 20);

	// green scrollbar bounds
	public static final Rectangle GREEN_SCROLLBAR_RECTANGLE = new Rectangle(20, 200, 160, 20);

	// blue scrollbar bounds
	public static final Rectangle BLUE_SCROLLBAR_RECTANGLE = new Rectangle(20, 250, 160, 20);

	// red label bounds
	public static final Rectangle RED_LABEL_RECTANGLE = new Rectangle(20, 125, 160, 20);

	// green label bounds
	public static final Rectangle GREEN_LABEL_RECTANGLE = new Rectangle(20, 175, 160, 20);

	// blue label bounds
	public static final Rectangle BLUE_LABEL_RECTANGLE = new Rectangle(20, 225, 160, 20);

	// 颜色显示rect
	public static final Rectangle COLOR_RECTANGLE = new Rectangle(50, 0, 100, 100);
}
