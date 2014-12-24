package filter.factory;

import app.Constants;
import filter.Filter;

public class FilterFactory
{
	public static Filter getFilter(int type)
	{
		int classify = type / 100;

		switch (classify)
		{
		case (Constants.TYPE_ART):
			return ArtFilterFactory.getFilter(type);
		case (Constants.TYPE_BAISC):
			return BasicFilterFactory.getFilter(type);
		case (Constants.TYPE_BLUR):
			return BlurFilterFactory.getFilter(type);
		case (Constants.TYPE_FUN):
			return FunFilterFactory.getFilter(type);
		case (Constants.TYPE_LOMO):
			return LomoFilterFactory.getFilter(type);
		case (Constants.TYPE_STYLE):
			return StyleFilterFactory.getFilter(type);
		case (Constants.TYPE_FASHION):
			return FashionFilterFactory.getFilter(type);
		case (Constants.TYPE_FRAME):
			return FrameFilterFactory.getFilter(type);
		default:
			return null;
		}
	}
}
