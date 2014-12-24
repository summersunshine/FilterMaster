package filter.factory;

import app.Constants;
import filter.Filter;
import filter.fun.ConcaveMirrorFilter;
import filter.fun.ConvexMirrorFilter;
import filter.fun.MosaicFilter;
import filter.fun.PartMosaicFilter;

public class FunFilterFactory
{
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
