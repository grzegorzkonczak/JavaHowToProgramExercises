// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.13 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class ShapesTest {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[6];
		
		shapes[0] = new Circle(5);
		shapes[1] = new Square(5);
		shapes[2] = new Triangle(5, 5);
		shapes[3] = new Sphere(5);
		shapes[4] = new Cube(5);
		shapes[5] = new Tetrahedron(5, 5);
		
		for(Shape currentShape : shapes){
			System.out.println(currentShape.getClass().getSimpleName());
			System.out.printf("Area: %.2f%n", currentShape.getArea());
			
			if (currentShape instanceof ThreeDimensionalShape) {
				ThreeDimensionalShape current3D = (ThreeDimensionalShape) currentShape;
				System.out.printf("Volume: %.2f%n", current3D.getVolume());
				System.out.println("Part of ThreeDimensionalShape hierarchy");
			}else
				System.out.println("Part of TwoDimensionalShape hierarchy");
			
			
			System.out.println();
		}
	}
}
