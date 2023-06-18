package javaAccModifierFirst;

import java.awt.Color;

public abstract class Computer_Abstract_Class {
	// Ngược với Final Class
	// - Có cho kế thừa
	// - Không cho khởi tạo đối tượng
	public static void main(String[] args) {
		Animal a = new Animal();
		a.color = "yellow";
		System.out.println(a.color);
	}
}
