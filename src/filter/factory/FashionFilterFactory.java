package filter.factory;

import app.Constants;
import filter.Filter;
import filter.fashion.FlareFilter;
import filter.fashion.ParchmentFilter;
import filter.fashion.PhotonFilter;
import filter.fashion.RainbowFilter;

public class FashionFilterFactory
{
	/**
	 * 依据类型参数获取新的fashion图像
	 * 
	 * @param type
	 *            类型
	 * */
	public static Filter getFilter(int type)
	{
		switch (type)
		{
		case (Constants.TYPE_RAINBOW):
			return new RainbowFilter();
		case (Constants.TYPE_PHOTON):
			return new PhotonFilter();
		case (Constants.TYPE_PARCHMENT):
			return new ParchmentFilter();
		case (Constants.TYPE_FLARE):
			return new FlareFilter();
		default:
			return null;
		}
	}
}
