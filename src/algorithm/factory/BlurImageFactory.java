package algorithm.factory;

import java.awt.image.BufferedImage;

import algorithm.blur.DoubleGuassBlur;
import algorithm.blur.Laser;
import algorithm.blur.MotionBlur;
import algorithm.blur.TiltShiftCamera;
import app.Constants;

public class BlurImageFactory
{
	/**
	 * 依据类型，图像，参数获取新的模糊图像
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
		case (Constants.TYPE_DOUBLE_GUASS_BLUR):
			return DoubleGuassBlur.getImage(image);
		case (Constants.TYPE_GUASS_BLUR):
			return TiltShiftCamera.getImage(image, 0.1f);
			// return GuassBlur.getImage(image);
		case (Constants.TYPE_LASER):
			return Laser.getImage(image);
		case (Constants.TYPE_MOTION_BLUR):
			return MotionBlur.getImage(image);
		default:
			return null;
		}

	}
}
