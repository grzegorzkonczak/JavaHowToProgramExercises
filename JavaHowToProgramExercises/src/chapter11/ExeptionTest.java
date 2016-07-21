// Grzegorz Koñczak, 21.07.2016
// Exercise number 11.16/17 page 514
// Exercise from Java:How to program 10th edition

package chapter11;

import java.io.IOException;

public class ExeptionTest {

	public static void main(String[] args) {
		try{
			throw new ExeptionA();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			throw new ExeptionB();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			throw new NullPointerException();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		try{
			throw new IOException();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
