import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Customer extends User {


	Customer(String Name, String Address, String phone, String email) {
		super(Name, Address, phone, email);
		super.setCart(new HashMap<Integer, CartItems>());
		super.setOrder(new HashMap<Integer, Orders>());
		super.setType(Usertype.CUSTOMER);
		Scanner input = new Scanner(System.in);
		System.out.println("Set Password : ");
		String pass = input.next();
		this.setPass(pass);
		System.out.println("Do you want to add balance to your Account ? \n1. Yes\n2. No\n");
		int choice = input.nextInt();
		if (choice == 1) {
			System.out.println("Enter Balance : ");
			double bal = input.nextDouble();
			super.setBalance(bal);
		} else {
			this.setBalance(0);
		}

	}

	void menu(FoodonWheels FDW) {
		Scanner input = new Scanner(System.in);
		System.out.println(" 1. View Food details\n" + " 2. place order\n" + " 3. Cancel Order\n" + " 4. Update Cart\n"
				+ " 5. Check Food delivery status\n" + " 6. Return to Main Menu");
		int choice = input.nextInt();
		switch (choice) {

		case 1: {
			viewFood(FDW);
			menu(FDW);
			break;
		}
		case 2: {
			placeOrder(FDW);
			menu(FDW);
			break;
		}
		case 3: {
			cancelOrder(FDW);
			menu(FDW);
			break;
		}
		case 4: {
			updateCart();
			menu(FDW);
			break;
		}

		case 5: {
			viewOrders();
			menu(FDW);
			break;
		}
		case 6: {
			break;
		}
		}
	}

	void viewCart() {
		System.out.println("\n-------------------------Your Cart---------------------");
		int k = 1;
		for (int i : this.getCart().keySet()) {
			System.out.println(k + " ID : " + this.getCart().get(i).getCartItem_id() + "     Food Item : "
					+ this.getCart().get(i).getFood_item().getName() + "  Price : "
					+ this.getCart().get(i).getFood_item().getPrice());
			k++;
		}
	}

	void viewOrders() {
		System.out.println("\n\n**********************Your Orders*******************");
		int k = 1;
		for (int i : this.getOrder().keySet()) {

			System.out.println(k + ". Food Item : " + this.getOrder().get(i).getCartitem().getFood_item().getName()
					+ "  Price : " + this.getOrder().get(i).getCartitem().getFood_item().getPrice() + "    Status : "
					+ this.getOrder().get(i).isStatus());
			k++;
		}
	}

	void viewFood(FoodonWheels FDW) {
		
			int k = 1;
			for (int i : FDW.getRestaurants().keySet()) {
				System.out.println(k + ". " + FDW.getRestaurants().get(i).getName() + "Restaurant ID : "
						+ FDW.getRestaurants().get(i).getId());
				k++;
			}
			
			try {
			System.out.println("\nChoose Restaurant by Entering ID : ");
			Scanner input = new Scanner(System.in);
			int id = input.nextInt();
			FDW.getRestaurants().get(id).menue();
			System.out.println("Select Food Item by Menu ID to Add to Cart : ");
			int menu_id = input.nextInt();
			FDW.getRestaurants().get(id).getMenue().get(menu_id);
			System.out.println("Enter the Quantity of Item");
			int quantity = input.nextInt();
			CartItems CI = new CartItems(FDW.getRestaurants().get(id).getId(), this.getName(), this.getId(), quantity,
					FDW.getRestaurants().get(id).getMenue().get(menu_id).getFood());
			this.getCart().put(CI.getCartItem_id(), CI);
			System.out.println("\nAdd more Items to Cart : \n1. Yes\n2. No");
			id = input.nextInt();
			if (id == 1) {
				viewFood(FDW);
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	void placeOrder(FoodonWheels FDW) {
		viewCart();

		try {
			System.out.println("Choose Food Item by Entering ID : ");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();

			System.out.println("\n**********************CheckOut********************");
			System.out.println("-----------------Your Order Details-----------------");
			System.out.println("Name : " + this.getCart().get(choice).getFood_item().getName());
			System.out.println("Description : " + this.getCart().get(choice).getFood_item().getDescription());
			System.out.println("Qunatity : " + this.getCart().get(choice).getQuantity());
			System.out.println("Price : " + this.getCart().get(choice).getFood_item().getPrice());
			System.out.println("---------------------------------------------------\n");
			System.out.println("\nSelect Your Payment Method\n1. Cash On Deliery\n2. Online Payment\n Enter your Choice ");
			int choice_1 = input.nextInt();
			switch (choice_1) {
			case 1: {
				
				Orders O = new Orders(this.getCart().get(choice).getRestaurantId(), this.getCart().get(choice));
				this.getOrder().put(O.getOrder_id(), O);
				Invoice bill = new Invoice(O);
				bill.generateInvoice(bill);
				for (int j : FDW.getRestaurants().keySet()) {
					for (int k : FDW.getRestaurants().get(j).getMenue().keySet()) {
						if (FDW.getRestaurants().get(j).getMenue().get(k).getFood()
								.equals(this.getCart().get(choice).getFood_item())) {
							FDW.getRestaurants().get(j).getOrder().put(O.getOrder_id(), O);

						}

					}
				}

				this.getCart().remove(choice);
				System.out.println("\nYour Order has Been Placed\nPay for your Order once you recieve your Order\n\n");
				break;
			}
			case 2: {
				double price = this.getCart().get(choice).getQuantity()
						* this.getCart().get(choice).getFood_item().getPrice();

				if (price < this.getBalance()) {
					Orders O = new Orders(this.getCart().get(choice).getRestaurantId(), this.getCart().get(choice));
					this.getOrder().put(O.getOrder_id(), O);
					Invoice bill = new Invoice(O);
					bill.setInvoice_status(true);
					bill.generateInvoice(bill);
					for (int j : FDW.getRestaurants().keySet()) {
						for (int k : FDW.getRestaurants().get(j).getMenue().keySet()) {
							if (FDW.getRestaurants().get(j).getMenue().get(k).getFood()
									.equals(this.getCart().get(choice).getFood_item())) {
								FDW.getRestaurants().get(j).getOrder().put(O.getOrder_id(), O);
							}
						}
					}

					this.getCart().remove(choice);
					System.out.println("Your Order Has Been Placed.");
					this.setBalance(getBalance() - price);
				} else {
					System.out.println("Your Balance is Insufficient. Order not Placed.");
				}
				break;
			}
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}

	}

	void updateCart() {
		viewCart();
		
		try {
			System.out.println("\n1.Remove Item from Cart\n2.Change Qunatity\n");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the ID of the item you want to Remove : ");
				choice = input.nextInt();
				this.getCart().remove(choice);
				System.out.println("\nItem Removed Successfully.");
				break;
			}
			case 2: {
				System.out.println("Enter the ID of the item you want to Change Quantity of : ");
				choice = input.nextInt();
				System.out.println(
						"Enter the new Quantity of " + this.getCart().get(choice).getFood_item().getName() + " : ");
				int quantity = input.nextInt();
				this.getCart().get(choice).setQuantity(quantity);
				break;
			}
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	void cancelOrder(FoodonWheels FDW) {
		viewOrders();
		try {
			System.out.println("\nEnter the ID of the Order you want to Cancel : ");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();

			if (this.getOrder().get(choice).isStatus().equals(Orders.Order_Status.DRAFT)
					|| this.getOrder().get(choice).isStatus().equals(Orders.Order_Status.REALIZED) || this.getOrder().get(choice).isStatus().equals(Orders.Order_Status.CANCELED)) {
				FDW.getRestaurants().get(this.getOrder().get(choice).getRestaurant_id()).getOrder().get(choice)
						.setStatus(Orders.Order_Status.CANCELED);
				this.getOrder().remove(choice);
				System.out.println("Your Order has been Cancelled Successfully.");
				System.out.println("\n\n");
			}

			else {
				System.out.println("Sorry You Cannot Cancel Your Order Now, It has Already been Dispatched.");
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

}
