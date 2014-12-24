package filter.factory;

import app.Constants;
import filter.Filter;
import filter.frame.FilmFrameFilter;
import filter.frame.InstantFrameFilter;
import filter.frame.SimpleFrameFilter;
import filter.frame.WoodFrameFilter;

public class FrameFilterFactory
{

	public static Filter getFilter(int type)
	{
		switch (type)
		{
		case (Constants.TYPE_FRAME_WOOD):
			return new WoodFrameFilter();
		case (Constants.TYPE_FRAME_INSTANT):
			return new InstantFrameFilter();
		case (Constants.TYPE_FRAME_FILM):
			return new FilmFrameFilter();
		case (Constants.TYPE_FRAME_SIMPLE):
			return new SimpleFrameFilter();
		default:
			return null;
		}

	}
}
