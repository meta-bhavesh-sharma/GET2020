class LcmHcf
{
	/**
	 * 
	 * @param x integer parameter 1
	 * @param y	integer parameter 1
	 * @return LCM of these 2 values
	 */
	public int LCM(int x,int y)
	{
		int z=HCF(x,y);
		return(z*(x/z)*(y/z));

	}
	/**
	 * 
	 * @param x integer parameter 1
	 * @param y	integer parameter 1
	 * @return HCF of these 2 values
	 */
	int HCF(int element1, int element2) 
	{ 
    	if (element1 == 0) 
       		return element2; 
    	return HCF(element2 % element1, element1); 
	}  
}