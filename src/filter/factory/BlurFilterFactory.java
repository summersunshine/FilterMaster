package filter.factory;

import app.Constants;
import filter.Filter;
import filter.Blur.GuassBlurFilter;
import filter.Blur.LaserFilter;
import filter.Blur.MotionBlurFilter;

public class BlurFilterFactory
{
	/**
	 * 依据类型参数获取新的模糊图像
	 * 
	 * @param type
	 *            类型
	 * */
	public static Filter getFilter(int type)
	{
		switch (type)
		{
		case (Constants.TYPE_GUASS_BLUR):
			return new GuassBlurFilter();
		case (Constants.TYPE_LASER):
			return new LaserFilter();
		case (Constants.TYPE_MOTION_BLUR):
			return new MotionBlurFilter();
		default:
			return null;
		}
	}
}
