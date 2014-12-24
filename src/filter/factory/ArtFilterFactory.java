package filter.factory;

import app.Constants;
import filter.Filter;
import filter.art.OilPaintFilter;
import filter.art.PencilFilter;
import filter.art.SculptureFilter;
import filter.art.SketchFilter;
import filter.art.StrokeAreaFilter;

public class ArtFilterFactory
{
	public static Filter getFilter(int type)
	{
		switch (type)
		{
		case (Constants.TYPE_OIL_PAINT):
			return new OilPaintFilter();
		case (Constants.TYPE_PENCIL):
			return new PencilFilter();
		case (Constants.TYPE_SCULPTUE):
			return new SculptureFilter();
		case (Constants.TYPE_SKETCH):
			return new SketchFilter();
		case (Constants.TYPE_STOKEAREA):
			return new StrokeAreaFilter();
		default:
			return null;
		}
	}
}
