package filter.fashion;

import java.awt.image.BufferedImage;

import util.image.AlphaMerge;
import filter.Filter;

public class RainbowFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		BufferedImage flareImage = getInternalImage("res/rainbow.jpg");

		outputImage = AlphaMerge.getImage(flareImage, image, 0.5f);
	}

}
