package filter.factory;

import app.Constants;
import filter.Filter;
import filter.style.DuskStyleFilter;
import filter.style.RetroStyleFilter;
import filter.style.YouthStyleFilter;

public class StyleFilterFactory
{
	/**
	 * �������Ͳ�����ȡ�µ��˲���
	 * 
	 * @param type
	 *            ����
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
