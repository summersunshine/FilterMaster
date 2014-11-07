package algorithm;

import java.beans.IntrospectionException;

public class Constants
{
	
	public static final int TYPE_ART=1;
	public static final int TYPE_BAISC=2;
	public static final int TYPE_BLUR=3;
	public static final int TYPE_FUN=4;
	public static final int TYPE_LOMO=5;
	public static final int TYPE_STYLE=6;
	

	
	// art
	public static final int TYPE_OIL_PAINT = 101;
	public static final int TYPE_PENCIL = 102;
	public static final int TYPE_SCULPTUE = 103;
	public static final int TYPE_SKETCH = 104;
	public static final int TYPE_STOKEAREA = 105;
	
	// basic
	public static final int TYPE_GRAY = 201;
	public static final int TYPE_INTENSITY_CONTRAST = 202;
	public static final int TYPE_INVERSE = 203;
	public static final int TYPE_SCALE = 204;
	public static final int TYPE_SHARPEN = 205;
	
	// blur
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
	
	
	// style
	public static final int TYPE_RETRO_STYLE = 601;
	
	
	public static int [] TYPE_ALPA_LIST = {TYPE_OIL_PAINT,TYPE_PENCIL,TYPE_SCULPTUE,TYPE_SKETCH,TYPE_STOKEAREA};
	
	
	
	public static int [] TYPE_BASIC_LIST = {TYPE_GRAY,TYPE_INVERSE,TYPE_SHARPEN};
	
	public static int [] TYPE_BLUR_LIST = {TYPE_GUASS_BLUR,TYPE_LASER,TYPE_MOTION_BLUR};
	
	public static int [] TYPE_FUN_LIST = {TYPE_ALPHA_MERGE,TYPE_ALPHA_MERGE_1,TYPE_ALPHA_MERGE_2,TYPE_ALPHA_MERGE_3,
		TYPE_ALPHA_MERGE_4,TYPE_MAGIC_MIRROIR_1,TYPE_MAGIC_MIRROIR_2,TYPE_MOSIC};
	
	public static int [] TYPE_LOMO_LIST = {TYPE_LOMO_CLASSIC};
	
	public static int [] TYPE_STYLE_LIST = {TYPE_RETRO_STYLE};
	
	
	public static String [] DESCRIBE_ALPA_LIST = {"ÓÍ»­","Ç¦±Ê","¸¡µñ","ËØÃè","ËØÃè"};
	public static String [] DESCRIBE_BASIC_LIST = {"»Ò¶ÈÍ¼","¸ºÆ¬","Èñ»¯"};
	public static String [] DESCRIBE_BLUR_LIST = {"¸ßË¹Ä£ºý","¹âÏßÄ£ºý","¶¯Ì¬Ä£ºý"};
	public static String [] DESCRIBE_LOMO_LIST = {"¾­µä"};
	public static String [] DESCRIBE_STYLE_LIST = {"¸´¹Å"};
	
}
