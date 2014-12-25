package filter.lomo;

import filter.style.YouthStyleFilter;

public class MemoryLomoFilter extends ClassicalLomoFilter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		super.processor();

		YouthStyleFilter youthStyleFilter = new YouthStyleFilter();
		outputImage = youthStyleFilter.getImage(outputImage);
	}
}
