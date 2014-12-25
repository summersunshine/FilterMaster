package filter.fashion;

import java.awt.image.BufferedImage;

import util.image.AlphaMerge;
import util.image.ImageUtil;
import filter.Filter;

public class PhotonFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		BufferedImage flareImage = ImageUtil.getImage("res/flare.jpg");

		outputImage = AlphaMerge.getImage(flareImage, image, 0.5f);
	}

}
