package filter.factory;

import app.Constants;
import filter.Filter;
import filter.style.DuskStyleFilter;
import filter.style.RetroStyleFilter;
import filter.style.YouthStyleFilter;

public class StyleFilterFactory
{
	/**
	 * 依据类型参数获取新的滤波器
	 * 
	 * @param type
	 *            类型
	 * */
	public static Filter getFilter(int type)
	{
		switch (type)
		{
		case (Constants.TYPE_RETRO_STYLE):
			return new RetroStyleFilter();
		case (Constants.TYPE_DUSK_STYLE):
			return new DuskStyleFilter();
		case (Constants.TYPE_YOUTH_STYLE):
			return new YouthStyleFilter();
		default:
			return null;
		}
	}
}
