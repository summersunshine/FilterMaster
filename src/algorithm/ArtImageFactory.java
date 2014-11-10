package algorithm;

import java.awt.image.BufferedImage;

import algorithm.art.OilPaint;
import algorithm.art.Pencil;
import algorithm.art.Sculpture;
import algorithm.art.Sketch;
import algorithm.basic.Gray;
import algorithm.basic.IntensityAndContrast;
import algorithm.basic.Inverse;
import algorithm.basic.Scale;
import algorithm.basic.Sharpen;
import algorithm.blur.GuassBlur;
import algorithm.blur.Laser;
import algorithm.blur.MotionBlur;
import algorithm.fun.AlphaMerge;

public class ArtImageFactory
{

	/**
	 * 依据类型，图像，参数获取新的艺术化图像
	 * 
	 * @param type
	 *            类型
	 * @param image
	 *            图像
	 * @param paramter
	 *            不定参数
	 * */
	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{
		case (Constants.TYPE_OIL_PAINT):
			return OilPaint.getImage(image);
		case (Constants.TYPE_PENCIL):
			return Pencil.getImage(image, 30);
		case (Constants.TYPE_SCULPTUE):
			return Sculpture.getImage(image);
		case (Constants.TYPE_SKETCH):
			return Sketch.getImage(image);
		case (Constants.TYPE_STOKEAREA):
			return Sketch.getImage(image);
		default:
			return null;
		}

	}

}
