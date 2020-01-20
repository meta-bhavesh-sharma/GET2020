class search
{
	/**
	 * 
	 * @param arr sorted integer array 
	 * @param start starting index
	 * @param end end index
	 * @param item element to be searched
	 * @return index of element else -1
	 */
	public int binarySearch(int[] arr,int start,int end,int item)
	{ 
		if(start==end && arr[start]==item)
			return start;
		else if(start==end)
			return -1;
		int mid =(start+end)/2;
		if(item>arr[end])
			return -1;
		else if(item==arr[mid])
			return mid;
		else if(item>arr[mid])
			return(binarySearch(arr,mid+1,end,item));
		else if(item<arr[mid])
			return (binarySearch(arr,start,mid,item));
		else
			return -1;
	}
	/**
	 * 
	 * @param arr sorted integer array 
	 * @param index index to be checked
	 * @param item element to be searched
	 * @return index of element else -1
	 */
	public  int linearSearch(int[] arr,int index,int item)
	{
		if(index==arr.length)
			return -1;
		if(arr[index]==item)
			return index;
		else
			return(linearSearch(arr,index+1,item));
	}
	public static void main(String args[])
	{
		search s=new search();
		int[] arr={1,2,3,5,6,7,9};
		System.out.println(" linear "+s.linearSearch(arr,0,7));
		System.out.println(" binary "+s.binarySearch(arr,0,arr.length-1,11));
	} 
}