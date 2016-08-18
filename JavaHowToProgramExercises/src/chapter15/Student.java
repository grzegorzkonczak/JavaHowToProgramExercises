// Grzegorz Koñczak, 18.08.2016
// Exercise number 15.6 page 723
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.Serializable;

public class Student implements Serializable{

	private int id;
	private String name;
	private double grade1;
	private double grade2;
	private double grade3;
	
	public Student(int id, String name, double grade1, double grade2, double grade3) {
		this.id = id;
		this.name = name;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade1() {
		return grade1;
	}
	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}
	public double getGrade2() {
		return grade2;
	}
	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}
	public double getGrade3() {
		return grade3;
	}
	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}
	
	
}
