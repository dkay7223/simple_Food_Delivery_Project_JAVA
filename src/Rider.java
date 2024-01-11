import java.util.Scanner;


public class Rider extends User {

	Orders delivery;

	Rider(String Name, String Address, String phone, String email) {
		super(Name, Address, phone, email);
		super.setType(Usertype.RIDER);
		this.delivery = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Set Password : ");
		String pass = input.next();
		this.setPass(pass);

	}

	void menu(FoodonWheels FDW) {
		Scanner input = new Scanner(System.in);
		System.out.println(" 1. View Orders\n" + " 2. Accept or Reject Orders\n" + " 3. Cash Collection Update\n"
				+ " 4. Return to Main Menu");
		int choice = input.nextInt();
		switch (choice) {

		case 1: {
			viewallOrders(FDW);
			menu(FDW);
			break;
		}
		case 2: {
			AcceptRejectOrders(FDW);
			menu(FDW);
			break;
		}
		case 3: {
			cashCollectionUpdate(FDW);
			menu(FDW);
			break;
		}
		case 4: {
			break;
		}
		}
	}

	void viewallOrders(FoodonWheels FDW) {

		System.out.println("********************All Orders********************");

		int k = 1;
		for (int i : FDW.getRestaurants().keySet()) {
			for (int j : FDW.getRestaurants().get(i).getOrder().keySet()) {
				if (FDW.getRestaurants().get(i).getOrder().get(j).isStatus().equals(Orders.Order_Status.REALIZED)) {
					System.out.println(k + ".  Restaurant : " + FDW.getRestaurants().get(i).getName()
							+ "        Order : "
							+ FDW.getRestaurants().get(i).getOrder().get(j).getCartitem().getFood_item().getName());
					k++;

				}

			}
		}

	}

	void AcceptRejectOrders(FoodonWheels FDW) {

		System.out.println("********************All Orders********************");

		int k = 1;
		for (int i : FDW.getRestaurants().keySet()) {
			for (int j : FDW.getRestaurants().get(i).getOrder().keySet()) {
				if (FDW.getRestaurants().get(i).getOrder().get(j).isStatus().equals(Orders.Order_Status.REALIZED)) {
					System.out
							.println(k + ".  Restaurant : " + FDW.getRestaurants().get(i).getName() + "        Order : "
									+ FDW.getRestaurants().get(i).getOrder().get(j).getCartitem().getFood_item()
											.getName()
									+ "        Order Id : "
									+ FDW.getRestaurants().get(i).getOrder().get(j).getOrder_id());
					k++;

				}

			}
		}

		System.out.println("Select The OrderId You Want to Accept : ");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();

		for (int i : FDW.getRestaurants().keySet()) {
			for (int j : FDW.getRestaurants().get(i).getOrder().keySet()) {
				if (FDW.getRestaurants().get(i).getOrder().get(j).getOrder_id() == id) {

					FDW.getRestaurants().get(i).getOrder().get(j).setStatus(Orders.Order_Status.DISPATCHED);
					this.delivery = FDW.getRestaurants().get(i).getOrder().get(j);
				}

			}
		}

		for (int i : FDW.getCustomers().keySet()) {
			for (int j : FDW.getCustomers().get(i).getOrder().keySet()) {
				if (FDW.getCustomers().get(i).getOrder().get(j).getOrder_id() == id) {

					FDW.getCustomers().get(i).getOrder().get(j).setStatus(Orders.Order_Status.DISPATCHED);
				}

			}

		}

	}

	void cashCollectionUpdate(FoodonWheels FDW) {

		Invoice bill = new Invoice(this.delivery);

		if (!bill.getInvoice_status()) {

			bill.generateInvoice(bill);

			System.out.println("\nHas the Customer Payed His Bill ? 1. Yes \n 2. No\n");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("\nThankYou for Paying you Bill\n");

				for (int i : FDW.getRestaurants().keySet()) {
					for (int j : FDW.getRestaurants().get(i).getOrder().keySet()) {
						if (FDW.getRestaurants().get(i).getOrder().get(j).equals(this.delivery)) {
							FDW.getRestaurants().get(i).getOrder().get(j).setStatus(Orders.Order_Status.DELIVERED);
						}
					}
				}

				for (int i : FDW.getCustomers().keySet()) {
					for (int j : FDW.getCustomers().get(i).getOrder().keySet()) {
						if (FDW.getCustomers().get(i).getOrder().get(j).equals(this.delivery)) {

							FDW.getCustomers().get(i).getOrder().get(j).setStatus(Orders.Order_Status.DELIVERED);
						}
					}
				}

				break;
			}

			case 2: {
				for (int i : FDW.getRestaurants().keySet()) {
					for (int j : FDW.getRestaurants().get(i).getOrder().keySet()) {
						if (FDW.getRestaurants().get(i).getOrder().get(j).equals(this.delivery)) {
							FDW.getRestaurants().get(i).getOrder().get(j).setStatus(Orders.Order_Status.CANCELED);
						}
					}
				}

				for (int i : FDW.getCustomers().keySet()) {
					for (int j : FDW.getCustomers().get(i).getOrder().keySet()) {
						if (FDW.getCustomers().get(i).getOrder().get(j).equals(this.delivery)) {

							FDW.getCustomers().get(i).getOrder().get(j).setStatus(Orders.Order_Status.CANCELED);
						}
					}
				}

				break;
			}

			}

		}

		else {

			for (int i : FDW.getRestaurants().keySet()) {
				for (int j : FDW.getRestaurants().get(i).getOrder().keySet()) {
					if (FDW.getRestaurants().get(i).getOrder().get(j).equals(this.delivery)) {
						FDW.getRestaurants().get(i).getOrder().get(j).setStatus(Orders.Order_Status.DELIVERED);
					}
				}
			}

			for (int i : FDW.getCustomers().keySet()) {
				for (int j : FDW.getCustomers().get(i).getOrder().keySet()) {
					if (FDW.getCustomers().get(i).getOrder().get(j).equals(this.delivery)) {

						FDW.getCustomers().get(i).getOrder().get(j).setStatus(Orders.Order_Status.DELIVERED);
					}
				}
			}
			System.out.println("\nThankyou For Shopping Here.");

		}

	}

}