package filter.factory;

import app.Constants;
import filter.Filter;
import filter.basic.EdgeDetectorFilter;
import filter.basic.GrayFilter;
import filter.basic.InverseFilter;
import filter.basic.SharpenFilter;

public class BasicFilterFactory
{
	public static Filter getFilter(int type)
	{
		switch (type)
		{

		case (Constants.TYPE_GRAY):
			return new GrayFilter();
		case (Constants.TYPE_INVERSE):
			return new InverseFilter();
		case (Constants.TYPE_SHARPEN):
			return new SharpenFilter();
		case (Constants.TYPE_EDGE_SOBEL_X):
		case (Constants.TYPE_EDGE_SOBEL_Y):
		case (Constants.TYPE_EDGE_LAPLACE):
			EdgeDetectorFilter.type = type;
			return new EdgeDetectorFilter();
		default:
			return null;
		}
	}
}
