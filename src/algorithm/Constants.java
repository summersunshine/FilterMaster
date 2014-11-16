package algorithm;

import java.beans.IntrospectionException;

import javax.naming.InitialContext;

public class Constants
{
	public static final int TYPE_ERASE = 0;
	public static final int TYPE_ART = 1;
	public static final int TYPE_BAISC = 2;
	public static final int TYPE_BLUR = 3;
	public static final int TYPE_FUN = 4;
	public static final int TYPE_LOMO = 5;
	public static final int TYPE_STYLE = 6;
	public static final int TYPE_FASHION = 7;
	public static final int TYPE_FRAME = 8;

	// art
	public static final int TYPE_OIL_PAINT = 101;
	public static final int TYPE_PENCIL = 102;
	public static final int TYPE_SCULPTUE = 103;
	public static final int TYPE_SKETCH = 104;
	public static final int TYPE_STOKEAREA = 105;

	// basic
	public static final int TYPE_GRAY = 201;
	public static final int TYPE_INTENSITY_CONTRAST = 202;
	public static final int TYPE_SATURATION_HUE = 203;
	public static final int TYPE_INVERSE = 204;
	public static final int TYPE_SCALE = 205;
	public static final int TYPE_SHARPEN = 206;

	// blur
	public static final int TYPE_DOUBLE_GUASS_BLUR = 300;
	public static final int TYPE_GUASS_BLUR = 301;
	public static final int TYPE_LASER = 302;
	public static final int TYPE_MOTION_BLUR = 303;

	// fun
	public static final int TYPE_ALPHA_MERGE = 400;
	public static final int TYPE_ALPHA_MERGE_1 = 401;
	public static final int TYPE_ALPHA_MERGE_2 = 402;
	public static final int TYPE_ALPHA_MERGE_3 = 403;
	public static final int TYPE_ALPHA_MERGE_4 = 404;
	public static final int TYPE_MAGIC_MIRROIR_1 = 405;
	public static final int TYPE_MAGIC_MIRROIR_2 = 406;
	public static final int TYPE_MOSIC = 407;

	// lomo
	public static final int TYPE_LOMO_CLASSIC = 501;
	public static final int TYPE_LOMO_MEMORY = 502;

	// style
	public static final int TYPE_RETRO_STYLE = 601;
	public static final int TYPE_DUSK_STYLE = 602;
	public static final int TYPE_YOUTH_STYLE = 603;
	
	//fashion
	public static final int TYPE_RAINBOW = 701;
	public static final int TYPE_PHOTON = 702;
	public static final int TYPE_PARCHMENT = 703;
	public static final int TYPE_FLARE = 704;
	
	
	//frame
	public static final int TYPE_FRAME_WOOD = 801;
	public static final int TYPE_FRAME_INSTANT = 802;
	public static final int TYPE_FRAME_FILM = 803;
	public static final int TYPE_FRAME_SIMPLE = 804;
	

	public static int[] TYPE_ALPA_LIST = { TYPE_OIL_PAINT, TYPE_PENCIL, TYPE_SCULPTUE, TYPE_SKETCH, TYPE_STOKEAREA };

	public static int[] TYPE_BASIC_LIST = { TYPE_GRAY, TYPE_INVERSE, TYPE_SHARPEN };

	public static int[] TYPE_BLUR_LIST = { TYPE_DOUBLE_GUASS_BLUR, TYPE_GUASS_BLUR, TYPE_LASER, TYPE_MOTION_BLUR };

	public static int[] TYPE_FUN_LIST = { TYPE_ALPHA_MERGE, TYPE_ALPHA_MERGE_1, TYPE_ALPHA_MERGE_2, TYPE_ALPHA_MERGE_3, TYPE_ALPHA_MERGE_4,
			TYPE_MAGIC_MIRROIR_1, TYPE_MAGIC_MIRROIR_2, TYPE_MOSIC };

	public static int[] TYPE_LOMO_LIST = { TYPE_LOMO_CLASSIC ,TYPE_LOMO_MEMORY};

	public static int[] TYPE_STYLE_LIST = { TYPE_RETRO_STYLE ,TYPE_DUSK_STYLE,TYPE_YOUTH_STYLE};

	public static int[] TYPE_FASHION_LIST = {TYPE_RAINBOW,TYPE_PHOTON,TYPE_PARCHMENT,TYPE_FLARE};
	
	public static int[] TYPE_FRAME_LIST = {TYPE_FRAME_WOOD,TYPE_FRAME_INSTANT,TYPE_FRAME_FILM,TYPE_FRAME_SIMPLE};
	
	
	public static String[] DESCRIBE_ART_LIST = { "油画", "铅笔", "浮雕", "素描", "笔触区域" };
	
	public static String[] DESCRIBE_BASIC_LIST = { "灰度图", "负片", "锐化" };
	
	public static String[] DESCRIBE_BLUR_LIST = { "高倍高斯模糊", "高斯模糊", "光线模糊", "动态模糊" };
	
	public static String[] DESCRIBE_LOMO_LIST = { "经典" ,"回忆"};
	
	public static String[] DESCRIBE_STYLE_LIST = { "复古","黄昏","青春" };
	
	public static String[] DESCRIBE_FASHION_LIST = {"彩虹","极光","羊皮纸","光晕"};
	
	public static String[] DESCRIBE_FRAME_LIST = {"木制","拍立得","胶片","简单"};

}
