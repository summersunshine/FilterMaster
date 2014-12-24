package filter.fashion;

import java.awt.image.BufferedImage;

import util.ImgUtil;
import algorithm.basic.Sharpen;
import algorithm.fun.AlphaMerge;
import filter.Filter;

public class ParchmentFilter extends Filter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		BufferedImage paperImage = ImgUtil.getImg("res/paper.jpg");

		outputImage = AlphaMerge.getImage(paperImage, Sharpen.getImage(image), 0.5f);
	}

}
