package com.bridgelabz.felloship.inventory;

import java.io.IOException;
import java.util.Scanner;
import com.bridgelabz.felloship.operations.*;
import com.bridgelabz.felloship.productmenu.*;

public class JSONInventoryDataManagement {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		InventoryManager.pricemenu();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1: add\n" + "2: del\n" + "3: update\n" + "4: display\n" + "5: exit");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			operations.add();
			break;
		case 2:
			operations.del();
			break;
		case 3:
			operations.update();
			break;
		case 4:
			operations.display();
			break;
		case 5:
			return;
		default:
			break;
		}
	}

}
