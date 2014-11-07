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


	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{
		case (Constants.TYPE_OIL_PAINT):
			return OilPaint.getImage(image);
		case (Constants.TYPE_PENCIL):
			return Pencil.getImage(image, 180);
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
