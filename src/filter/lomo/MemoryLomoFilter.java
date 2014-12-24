package filter.lomo;

import algorithm.style.YouthStyle;

public class MemoryLomoFilter extends ClassicalLomoFilter
{

	@Override
	public void processor()
	{
		// TODO Auto-generated method stub
		super.processor();
		outputImage = YouthStyle.getImage(outputImage);
	}

}
