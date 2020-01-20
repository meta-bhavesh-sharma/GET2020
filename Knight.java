//main class to implement Knight tour problem 
class Knight
{
    public static int n=8;
    public static int count=0;
    /** the main use of the method is to move at each and every possible value and backtrack if no solution found
     * 
     * @param chess 2 dimentional array for chess
     * @param x raw dimention
     * @param y column dimention
     * @param xways raw moves array
     * @param yways column moves array
     * @return boolean true if success false else  
     */
    static boolean move(int[][] chess,int x,int y,int[] xways,int[] yways)
    {
        if(count==64)
            return true;
        for(int i=0;i<8;i++)
        {
            if(isSafe(chess,x,y))
            {
                chess[x][y]=count++;
                if(move(chess,x+xways[i],y+yways[i],xways,yways))
                    return true;
                else
                {
                    count--;
                    chess[x][y]=0;
                }
            }
        }
        return false;

    }
    /**the main use of this method is to check if the place for the knight is safe or not 
     * 
     * @param chess 2 dimentional array for chess
     * @param x raw dimention
     * @param y column dimention
     * @return true if the place is safe for knight false else 
     */
    static boolean isSafe(int[][] chess,int x,int y)
    {
        if(x<8 && y<8 && x>=0 && y>=0 && chess[x][y]==0)
            return true;
        else 
            return false;
    }
    public static void main(String args[])
    {
        int[][] chess=new int[8][8];
        int xways[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yways[] = {1, 2, 2, 1, -1, -2, -2, -1};
        boolean b=Knight.move(chess,0,0,xways,yways);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(" "+chess[i][j]);
            }
            System.out.println("");
        } 
    }
}