package filter.Blur;

public class CircleBlurFilter extends InteractiveBlurFilter
{

	@Override
	public void processor()
	{
		int distance = 0, rgb = 0;

		// TODO Auto-generated method stub
		for (int y = HALF_MAX_MASK_SIZE; y < height - HALF_MAX_MASK_SIZE; y++)
		{
			for (int x = HALF_MAX_MASK_SIZE; x < width - HALF_MAX_MASK_SIZE; x++)
			{
				distance = getDistance(x, y, centerX, centerY);
				rgb = getRGBValue(x, y, distance);
				outputImage.setRGB(x, y, rgb);
			}
		}
	}
}
