
public class Test6 {

	float width;
	float height;
	
	public Test6(int w, int h)
	{
		width = w;
		height = h;
	}
	
	public float triangle()
	{
		float triArea = (width*height)/2;
		return triArea;
	}
	
	public float rectangle()
	{
		float rectArea = (width*height);
		return rectArea;
	}
	
	
	
	public static void main(String[] args) {
		
		Test6 x = new Test6(10, 20);
		System.out.println("Area of Triangle = "+x.triangle());
		System.out.println("Area of Triangle = "+x.rectangle());
	}

}
