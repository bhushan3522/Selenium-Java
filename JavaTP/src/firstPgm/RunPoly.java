package firstPgm;

public class RunPoly {

	public static void main(String[] args) {

		Bird b = new Chicken();
		b.fly();
		b.layEggs();
		

	}

}

class Bird{
	public void layEggs()
	{
		System.out.println("Birds lays eggs");
	}
	public void sing()
	{
		System.out.println("Birds can sing");
	}
	public void fly()
	{
		System.out.println("Birds can fly");
	}
}

class Chicken extends Bird{
	public void layEggs()
	{
		System.out.println("Chicken lays eggs");
	}
	public void food()
	{
		System.out.println("Chicken are eaten");
	}
}
