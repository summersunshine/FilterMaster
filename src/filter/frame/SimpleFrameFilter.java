package filter.frame;

import java.awt.image.BufferedImage;

public class SimpleFrameFilter extends FrameFilter
{

	@Override
	public BufferedImage getFrameImage()
	{
		// TODO Auto-generated method stub
		String fileName = "res/frame_film.png";

		return getInternalImage(fileName);
	}

}
