package filter.factory;

import app.Constants;
import filter.Filter;
import filter.lomo.ClassicalLomoFilter;
import filter.lomo.MemoryLomoFilter;

public class LomoFilterFactory
{
	public static Filter getFilter(int type)
	{
		switch (type)
		{
		case (Constants.TYPE_LOMO_CLASSIC):
			return new ClassicalLomoFilter();
		case (Constants.TYPE_LOMO_MEMORY):
			return new MemoryLomoFilter();
		default:
			return null;
		}
	}
}
