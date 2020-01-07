package com.bridgelabz.felloship.operations;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.felloship.control.control;
import com.bridgelabz.felloship.inventory.Product;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class operations {

	public static String spath = "/home/admin1/Desktop/inventory.json";
	static Scanner scanner = new Scanner(System.in);
	static ObjectMapper mapper = new ObjectMapper();

	public static void del() throws IOException {
		List<Product> list = control.read();
		System.out.println("enter product name: ");
		String inputname = scanner.next();
		for (Product product : list) {
			if (product.name.equals(inputname)) {
				continue;
			}
			list.add(product);
		}
		control.write(list);
	}

	public static void update() throws IOException {
		List<Product> list = control.read();
		System.out.println("enter product name: ");
		String inputname = scanner.next();
		for (Product product : list) {
			if (product.name.equals(inputname)) {
				System.out.println("1.product\n " + "2. price\n" + "3. weight");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("new name");
					product.setName(scanner.next());
					break;
				case 2:
					System.out.println("new price");
					product.setPrice(scanner.nextInt());
					break;
				case 3:
					System.out.println("change weight");
					product.setWeight(scanner.nextInt());
					break;
				default:
					break;
				}
			}

		}
		control.write(list);
	}

	public static void add() throws JsonGenerationException, JsonMappingException, IOException {

		List<Product> array = control.read();
		System.out.print("enter product sub types: ");
		int productsubtypes = scanner.nextInt();
		for (int i = 0; i < productsubtypes; i++) {
			Product p = new Product();
			System.out.println("enter the name");
			p.setName(scanner.next());
			System.out.println("enter the Weight: ");
			p.setWeight(scanner.nextInt());

			System.out.println("enter the price per Kg: ");
			p.setPrice(scanner.nextInt());

			array.add(p);
		}
		control.write(array);

	}

	public static void display() throws JsonParseException, JsonMappingException, IOException {
		List<Product> list = control.read();
		System.out.println("enter the product");
		String input = scanner.next();
		for (Product product : list) {
			if (product.name.equals(input)) {
				System.out.print("the total price is: ");
				System.out.println(product.price * product.weight + " for " + product.weight + " kg");
			}
		}
	}

}
