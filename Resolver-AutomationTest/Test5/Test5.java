public class Test5 {

	public void numbers(int start, int end)
	{
		for(int i=start; i<=end; i++)
		{
			System.out.println(i);
			
			//To check whether number is divisble by 3 or 5
			if((i%3) == 0 || (i%5) == 0)
			{
				//To check whether number is divisble by 3 and 5
				if((i%3) == 0 && (i%5) == 0)
				{
					System.out.println("Resolver");
					//if 'yes' then break the loop here and continue with next iteration
					continue;
				}
				//if 'No' then it must be multiple either 3 or 5
				else if((i%5) == 0)
				{
					System.out.println("MFive");
				}
				else if((i%3) == 0)
				{
					System.out.println("MThree");
				}
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		//To call the function we declared Obj & calling by Obj
		Test5 x =new Test5();
		x.numbers(1, 100);
	}
}
