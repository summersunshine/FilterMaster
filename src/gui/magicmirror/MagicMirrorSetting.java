package gui.magicmirror;

import java.awt.Rectangle;

import app.Constants;

public class MagicMirrorSetting
{
	
	//作用半径
	public static int radiusValue = 100;
	
	//滤镜类型
	public static int type = Constants.TYPE_CONCAVE_MIRROIR;
	


	// 模糊力度最小值
	public static final int minRadiusValue = 10;

	// 模糊力度最大值
	public static final int maxRadiusValue = 1000;

	// 模糊力度调节的间隔
	public static final int radiusExtent = 10;
	
	
	// adjustpanel的bounds
	public static final Rectangle ADJUST_PANEL_RECTANGLE = new Rectangle(0, 200, 200, 300);
	
	// size label的bounds
	public static final Rectangle RADIUS_LABEL_RECTANGLE = new Rectangle(100, 70, 30, 40);

	// size scrollbar的bounds
	public static final Rectangle RADIUS_SCROLLBAR_RECTANGLE = new Rectangle(20, 100, 160, 20);

	// paint button的bounds
	public static final Rectangle CONVEX_BUTTON_RECTANGLE = new Rectangle(0, 0, 100, 40);

	// erase button的bounds
	public static final Rectangle CONCAVE_BUTTON_RECTANGLE = new Rectangle(100, 0, 100, 40);
}
