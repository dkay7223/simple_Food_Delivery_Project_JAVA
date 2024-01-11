import java.util.Scanner;

public class Admin extends User {

	private final String name = "Administator";
	private final String email = "admin@gmail.com";
	private final String phone = "03335454636";
	private final String address = "Islamabad";
	private final int id = 1001;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public int getId() {
		return id;
	}

	public Admin(String Name, String Address, String Phone, String Email) {
		super(Name, Address, Phone, Email);
		super.setAddress(this.address);
		super.setEmail(this.email);
		super.setName(this.name);
		super.setPhone(this.phone);
		super.setPass("1234");
		super.setType(Usertype.ADMIN);
	}

	void menu(FoodonWheels FDW) {
		Scanner input = new Scanner(System.in);
		System.out.println(" 1. Manage Vendors\n" + " 2. Manage Vendor Products\n" + " 3. Manage Customers\n"
				+ " 4. Manage Food Order Details\n" + " 5. Manage Payment Details\n" + " 6. Manage Riders\n"
				+ " 7. Return to Main Menu");
		int choice = input.nextInt();
		switch (choice) {

		case 1: {
			manageVendors(FDW);
			menu(FDW);
			break;
		}
		case 2: {
			manageVendorMenue(FDW);
			menu(FDW);
			break;
		}
		case 3: {
			manageCustomers(FDW);
			menu(FDW);
			break;
		}
		case 4: {
			manageFoodOrderdetails(FDW);
			menu(FDW);
			break;
		}

		case 5: {

			menu(FDW);
			break;
		}
		case 6: {
			manageRiders(FDW);
			menu(FDW);
			break;
		}
		case 7: {
			break;
		}
		}
	}

	void viewAllVendors(FoodonWheels FDW) {
		int k = 1;
		for (int i : FDW.getRestaurants().keySet()) {
			System.out.println(k + ". " + FDW.getRestaurants().get(i).getName() + "Restaurant ID : "
					+ FDW.getRestaurants().get(i).getId());
			k++;
		}
	}

	void viewAllCustomers(FoodonWheels FDW) {
		int k = 1;
		for (int i : FDW.getCustomers().keySet()) {
			System.out.println(k + ". " + FDW.getCustomers().get(i).getName() + "    Customer ID : "
					+ FDW.getCustomers().get(i).getId());
			k++;
		}
	}

	void viewAllRiders(FoodonWheels FDW) {
		int k = 1;
		for (int i : FDW.getRiders().keySet()) {
			System.out.println(
					k + ". " + FDW.getRiders().get(i).getName() + "    Rider ID : " + FDW.getRiders().get(i).getId());
			k++;
		}
	}

	void manageVendors(FoodonWheels FDW) {
		viewAllVendors(FDW);
		if(FDW.getRestaurants().size()>0) {
		System.out.println("\nDo you Want to Remove a Vendor\n1. Yes\n2. No");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		if (choose == 1) {
			System.out.println("Enter Restaurant ID to Remove : ");
			int id = input.nextInt();
			FDW.getRestaurants().remove(id);		
			System.out.println("\nRestaurant Successfull Removed.\n");
			viewAllVendors(FDW);
		}}
		else {
			System.out.println("No Vendors Available.");
		}

	}

	void manageVendorMenue(FoodonWheels FDW) {
		viewAllVendors(FDW);
		if(FDW.getRestaurants().size()>0) {
		System.out.println("\nEnter Restaurant ID to Manage It's Menu : ");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		FDW.getRestaurants().get(id).menue();
		if(FDW.getRestaurants().get(id).getMenue().size()>0) {
		System.out.println("\nDo you Want to Remove a Menu Item\n1. Yes\n2. No");

		int choose = input.nextInt();
		if (choose == 1) {

			System.out.println("\nEnter Menu ID to Remove : ");
			int menu_id = input.nextInt();
			FDW.getRestaurants().get(id).getMenue().remove(menu_id);
			System.out.println("\nMenu Item Successfully Removed.\n");
			FDW.getRestaurants().get(id).menu(FDW);
		}
		}
		else {
			System.out.println("No Menu Items Available.");
		}
		}
		else {
			System.out.println("No Vendor Available.");
		}
	}

	void manageCustomers(FoodonWheels FDW) {

		viewAllCustomers(FDW);
		if(FDW.getCustomers().size()>0) {
		System.out.println("\nDo you Want to Remove a Customer\n1. Yes\n2. No");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		if (choose == 1) {
			System.out.println("Enter Customer ID to Remove : ");
			int id = input.nextInt();
			
			
			for(int i=0;i<FDW.getUsers().size();i++) {
				if(FDW.getUsers().get(i).getId()==FDW.getCustomers().get(id).getId()) {
					FDW.getUsers().remove(i);
					FDW.getCustomers().remove(id);
					System.out.println("\nCustomer Successfull Removed.\n");
				}
			}
			
			viewAllCustomers(FDW);
		}
		}
		else {
			System.out.println("No Customers Availabel.");
		}
	}

	void manageFoodOrderdetails(FoodonWheels FDW) {
		viewAllVendors(FDW);
		System.out.println("Enter Restaurant ID to view Orders : ");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		System.out.println("\n\n*************ORDERS FOR " + FDW.getRestaurants().get(id).getName() + "***************");
		int k = 1;
		for (int i : FDW.getRestaurants().get(id).getOrder().keySet()) {
			System.out.println(k + ".  Customer Name : "
					+ FDW.getRestaurants().get(id).getOrder().get(i).getCartitem().getCustomer_Name()
					+ "         Order Item : "
					+ FDW.getRestaurants().get(id).getOrder().get(i).getCartitem().getFood_item().getName()
					+ "       Order Id : " + FDW.getRestaurants().get(id).getOrder().get(i).getOrder_id());
			k++;
		}
		System.out.println("\n\n");
	}

	void managePaymentdetails() {

	}

	void manageRiders(FoodonWheels FDW) {

		viewAllRiders(FDW);
		if(FDW.getRiders().size()>0) {
		System.out.println("\nDo you Want to Remove a Rider\n1. Yes\n2. No");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		if (choose == 1) {
			System.out.println("Enter Rider ID to Remove : ");
			int id = input.nextInt();
			for(int i=0;i<FDW.getUsers().size();i++) {
				if(FDW.getUsers().get(i).getId()==FDW.getRiders().get(id).getId()) {
					FDW.getUsers().remove(i);
					FDW.getRiders().remove(id);
					System.out.println("\nRider Successfull Removed.\n");
				}
			}
			viewAllCustomers(FDW);
		}

	}
		else {
			System.out.println("No Riders Available.");
		}
		}

}
