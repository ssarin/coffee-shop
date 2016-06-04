/**Generic Lab
 * 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 02/17/2016
 * 
 * @author	Surtej
 * 
 */

/**
   Computes the average of a set of data values.
 */
public class DataSetGen<T>
{
	//T stands for type
	//private T t;
	private double sum;
	private T maximum;
	private int count;

	/**
      Constructs an empty data set.
	 */
	public DataSetGen()
	{
		sum = 0;
		count = 0;
		maximum = null;
	}
	
	/**
	 * Constructs a parametrized data set.
	 * @param t
	 */
	public DataSetGen(T t)
	{
		//this.t = t;
		sum = 0;
		count = 0;
		this.maximum = t;
	}

	/**
      Adds a data value to the data set.
      @param x a generic data value
	 */
	public void add(T x)
	{
		sum = sum + ((Measurable) x).getMeasure();
		if (count == 0 || ((Measurable) maximum).getMeasure() < ((Measurable) x).getMeasure())
			maximum = (T) x;
		count++;
	}

	/**
      Gets the average of the added data.
      @return the average or 0 if no data has been added
	 */
	public double getAverage()
	{
		if (count == 0)
			return 0;
		else
			return sum / count;
	}

	/**
      Gets the largest of the added data.
      @return the generic type maximum or 0 if no data has been added
	 */
	public T getMaximum()
	{
		return maximum;
	}
}