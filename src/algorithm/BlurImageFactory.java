package algorithm;

import java.awt.image.BufferedImage;

import algorithm.blur.DoubleGuassBlur;
import algorithm.blur.GuassBlur;
import algorithm.blur.Laser;
import algorithm.blur.MotionBlur;

public class BlurImageFactory
{



	public static BufferedImage getImage(int type, BufferedImage image, Object... parameter)
	{
		switch (type)
		{
		case (Constants.TYPE_DOUBLE_GUASS_BLUR):
			return DoubleGuassBlur.getImage(image);
		case (Constants.TYPE_GUASS_BLUR):
			return GuassBlur.getImage(image);
		case (Constants.TYPE_LASER):
			return Laser.getImage(image);
		case (Constants.TYPE_MOTION_BLUR):
			return MotionBlur.getImage(image);
		default:
			return null;
		}

	}
}
