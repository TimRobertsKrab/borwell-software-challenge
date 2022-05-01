import java.util.Scanner;

public class borwell_challenge{
	// I acquired this value from coatings.org.uk
    static final double litresPerSquareMetres = 1/12.0;

    // I acquired these values from jbkind.com
    // It's the average area of a UK door.
    static final double doorWidth = 0.762;
    static final double doorHeight = 1.981;
    static final double doorArea = doorHeight * doorWidth;

    //I acquired this value from myhomeextension.co.uk;
    static final double minimumHeight = 2.2;

	public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Provides the dimensions
        System.out.print("Enter room width in metres: ");
        double width = enterDouble(input,doorWidth);
        System.out.print("Enter room length in metres: ");
        double length = enterDouble(input,doorWidth);
        System.out.print("Enter room height in metres: ");
        double height = enterDouble(input,minimumHeight);

        
        double wallArea = ((length * height) + (width*height)) * 2;

        //This assumes that there is 1 standard door and no windows.
        double paintRequired = (wallArea - doorArea) * litresPerSquareMetres;


        System.out.println("\nFloor area = " + width*length + "m^2");
        System.out.println("Litres of paint required to paint the walls with 1 coat = " + paintRequired+ " litres");

        System.out.println("Volume = " + width*height*length + "m^3");

	}

    //This ensures the input is valid and doesn't result in ridiculously small dimensions.
	static double enterDouble(Scanner i, double limit){
		double d;
        while (true) {
            try {
                d = Double.parseDouble(i.next());
                if (d< limit){
                	throw new IllegalArgumentException();
                }
                break; 
            }
            catch (Exception e) {
                System.out.print("Enter a positive value no less than " + limit + ": ");
            }
	    }
	    return d;
	}
}