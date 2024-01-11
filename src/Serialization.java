import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Serialization {
	
	
	void Serialize(FoodonWheels FDW) {
		serializeUsers(FDW);
		serializeRestaurants(FDW);
		serializeMenu(FDW);
		serializeOrders(FDW);
		serializeCart(FDW);
	}

	void serializeUsers(FoodonWheels FDW) {
		// create file Users
		try {
			File users = new File("Users.txt");
			if (users.createNewFile()) {
				System.out.println("File created: " + users.getName());
			} else {
				System.out.println("Users File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// write to a file
		try {
			FileWriter myWriter = new FileWriter("Users.txt");

			for (int i = 0; i < FDW.getUsers().size(); i++) {
				myWriter.write(FDW.getUsers().get(i).getType() + ",");
				myWriter.write(FDW.getUsers().get(i).getId() + ",");
				myWriter.write(FDW.getUsers().get(i).getName() + ",");
				myWriter.write(FDW.getUsers().get(i).getEmail() + ",");
				myWriter.write(FDW.getUsers().get(i).getAddress() + ",");
				myWriter.write(FDW.getUsers().get(i).getPhone() + ",");
				myWriter.write(FDW.getUsers().get(i).getPass() + ",");
				myWriter.write(FDW.getUsers().get(i).getBalance() + "\n");

			}
			myWriter.close();
			System.out.println("Successfully wrote to the Accounts file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	void serializeRestaurants(FoodonWheels FDW) {
		// create file Users
		try {
			File Restaurants = new File("Restaurants.txt");
			if (Restaurants.createNewFile()) {
				System.out.println("File created: " + Restaurants.getName());
			} else {
				System.out.println("Restaurants File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// write to a file
		try {
			FileWriter myWriter = new FileWriter("Restaurants.txt");

			for (int i : FDW.getRestaurants().keySet()) {
				myWriter.write(FDW.getRestaurants().get(i).getId() + ",");
				myWriter.write(FDW.getRestaurants().get(i).getName() + ",");
				myWriter.write(FDW.getRestaurants().get(i).getEmail() + ",");
				myWriter.write(FDW.getRestaurants().get(i).getAddress() + ",");
				myWriter.write(FDW.getRestaurants().get(i).getPhone() + ",");
				myWriter.write(FDW.getRestaurants().get(i).getPass() + "\n");
			}
			myWriter.close();
			System.out.println("Successfully wrote to the Restaurants file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	
	
	void serializeMenu(FoodonWheels FDW) {
		// create file Users
		try {
			File Menue = new File("Menue.txt");
			if (Menue.createNewFile()) {
				System.out.println("File created: " + Menue.getName());
			} else {
				System.out.println("Menue File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// write to a file
		try {
			FileWriter myWriter = new FileWriter("Menue.txt");
			
			for(int j : FDW.getRestaurants().keySet()) {
			for (int i : FDW.getRestaurants().get(j).getMenue().keySet()) {
				myWriter.write(FDW.getRestaurants().get(j).getMenue().get(i).getMenu_id() + ",");
				myWriter.write(FDW.getRestaurants().get(j).getMenue().get(i).getRestaurantid() + ",");
				myWriter.write(FDW.getRestaurants().get(j).getMenue().get(i).getFood().getFoodid() + ",");
				myWriter.write(FDW.getRestaurants().get(j).getMenue().get(i).getFood().getName() + ",");
				myWriter.write(FDW.getRestaurants().get(j).getMenue().get(i).getFood().getDescription() + ",");
				myWriter.write(FDW.getRestaurants().get(j).getMenue().get(i).getFood().getPrice() + "\n");
			}}
			myWriter.close();
			System.out.println("Successfully wrote to the Menue file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	
	
	void serializeOrders(FoodonWheels FDW) {
		// create file Users
		try {
			File Orders = new File("Orders.txt");
			if (Orders.createNewFile()) {
				System.out.println("File created: " + Orders.getName());
			} else {
				System.out.println("Orders File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// write to a file
		try {
			FileWriter myWriter = new FileWriter("Orders.txt");
			for(int j : FDW.getCustomers().keySet()) {
				for(int i : FDW.getCustomers().get(j).getOrder().keySet()) {
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getOrder_id() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getRestaurant_id() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getCartitem().getCartItem_id() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getCartitem().getCustomer_id() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getCartitem().getCustomer_Name() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getCartitem().getQuantity() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getCartitem().getFood_item().getFoodid() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getCartitem().getFood_item().getName() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getCartitem().getFood_item().getPrice() + ",");
				myWriter.write(FDW.getCustomers().get(j).getOrder().get(i).getCartitem().getFood_item().getDescription() + "\n");
			}}
			myWriter.close();
			System.out.println("Successfully wrote to the Menue file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	
	void serializeCart(FoodonWheels FDW) {
		// create file Users
		try {
			File Cart = new File("Cart.txt");
			if (Cart.createNewFile()) {
				System.out.println("File created: " + Cart.getName());
			} else {
				System.out.println("Cart File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// write to a file
		try {
			FileWriter myWriter = new FileWriter("Cart.txt");
			for(int j : FDW.getCustomers().keySet()) {
				for(int i : FDW.getCustomers().get(j).getCart().keySet()) {
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getCartItem_id() + ",");
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getCustomer_id() + ",");
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getCustomer_Name() + ",");
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getRestaurantId() + ",");
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getQuantity() + ",");
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getFood_item().getName() + ",");
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getFood_item().getFoodid() + ",");
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getFood_item().getDescription() + ",");
				myWriter.write(FDW.getCustomers().get(j).getCart().get(i).getFood_item().getPrice() + "\n");
			}}
			myWriter.close();
			System.out.println("Successfully wrote to the Menue file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	

}
