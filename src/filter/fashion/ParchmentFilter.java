package filter.fashion;

import java.awt.image.BufferedImage;

import util.image.AlphaMerge;
import filter.Filter;

public class ParchmentFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		BufferedImage paperImage = getInternalImage("res/paper.jpg");

		outputImage = AlphaMerge.getImage(paperImage, image, 0.5f);
	}

}
