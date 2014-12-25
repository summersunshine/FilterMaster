package filter.factory;

import app.Constants;
import filter.Filter;
import filter.fun.ConcaveMirrorFilter;
import filter.fun.ConvexMirrorFilter;
import filter.fun.MosaicFilter;
import filter.fun.PartMosaicFilter;

public class FunFilterFactory
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
		case (Constants.TYPE_CONCAVE_MIRROIR):
			return new ConcaveMirrorFilter();
		case (Constants.TYPE_CONVEX_MIRROIR):
			return new ConvexMirrorFilter();
		case (Constants.TYPE_MOSIC):
			return new MosaicFilter();
		case (Constants.TYPE_PART_MOSIC):
			return new PartMosaicFilter();
		default:
			return null;
		}
	}
}
