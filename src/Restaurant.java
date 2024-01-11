
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Restaurant {

	private String Name;
	private String Address;
	private String phone;
	private String email;
	private int id;
	private String pass;

	private HashMap<Integer, Orders> order;
	private HashMap<Integer, MenueItems> menue;

	Random rand = new Random();

	public HashMap<Integer, MenueItems> getMenue() {
		return menue;
	}

	public void setMenue(HashMap<Integer, MenueItems> menue) {
		this.menue = menue;
	}

	public HashMap<Integer, Orders> getOrder() {
		return order;
	}

	public void setOrder(HashMap<Integer, Orders> order) {
		this.order = order;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	Restaurant(String Name, String Address, String phone, String email) {
		this.Name = Name;
		this.Address = Address;
		this.phone = phone;
		this.email = email;
		this.id = rand.nextInt(1000);
		Scanner input = new Scanner(System.in);
		System.out.println("Set Password : ");
		String pass = input.next();
		this.setPass(pass);
		setMenue(new HashMap<Integer, MenueItems>());
		setOrder(new HashMap<Integer, Orders>());

	}

	void profile() {
		System.out.println("\n**********RESTAURANT PROFILE***********");
		System.out.println("Name : " + this.getName());
		System.out.println("Email : " + this.getEmail());
		System.out.println("ID : " + this.getId());
		System.out.println("Address : " + this.getAddress());
		System.out.println("Phone : " + this.getPhone());
		System.out.println("***************************************");

	}

	void menu(FoodonWheels FDW) {
		Scanner input = new Scanner(System.in);
		System.out.println("1. Our Menu\n" + "2. Add Food details\n" + "3. Update Food details\n" + "4. Delete Food\n"
				+ "5. Check food order\n" + "6. Update food delivery status\n" + "7. Calculate Bills\n"
				+ "8. Return to Main Menu");
		int choice = input.nextInt();
		switch (choice) {
		case 1: {
			menue();
			menu(FDW);
			break;
		}

		case 2: {
			addFood();
			menu(FDW);
			break;
		}
		case 3: {
			updateFood();
			menu(FDW);
			break;
		}
		case 4: {
			deleteFood();
			menu(FDW);
			break;
		}
		case 5: {
			checkOrder(FDW);
			menu(FDW);
			break;
		}

		case 6: {
			break;
		}
		case 7: {
			break;
		}
		case 8: {
			break;
		}
		}
	}

	void menue() {
		if (this.menue.size() > 0) {
			System.out.println("\n\n*************MENU**************");
			int k = 1;
			for (int i : this.getMenue().keySet()) {
				System.out.println(k + ".   Menue ID : " + this.getMenue().get(i).getMenu_id() + "    Food Item : "
						+ this.getMenue().get(i).getFood().getName() + "      Description : "
						+ this.getMenue().get(i).getFood().getDescription() + "        Price : "
						+ this.getMenue().get(i).getFood().getPrice());
				k++;
			}
			System.out.println("\n\n");
		} else {
			System.out.println("\nNo Menu Available.\n");
		}
	}

	void addFood() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("\n\nEnter Food Name ");
			String food = input.next();
			input.nextLine();
			System.out.println("Enter the Description of Food");
			String description = input.nextLine();
			System.out.println("Enter the Price ");
			double price = input.nextDouble();
			FoodItems F = new FoodItems(food, description, price);
			MenueItems M = new MenueItems(this.getId(),F);
			this.getMenue().put(M.getMenu_id(), M);
			System.out.println("\nPress 1 to enter more food items\nPress 2 to Stop Entering Food Items");
			int choice = input.nextInt();
			if (choice == 1) {
				addFood();
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	void updateFood() {

		menue();
		try {
			System.out.println("***********************************");
			Scanner input = new Scanner(System.in);
			System.out.println("\nEnter Menu ID you want to Update : ");
			int id = input.nextInt();

			for (int i : this.getMenue().keySet()) {
				if (id == this.getMenue().get(i).getMenu_id()) {

					System.out.println(
							"Which Field Do you want to Update ?\n1. Name\n2. Description\n3. Price\n  Enter your choice : ");
					int choice = input.nextInt();
					switch (choice) {
					case 1: {
						System.out.println("Enter Food Name ");
						String food = input.next();

						this.getMenue().get(i).getFood().setName(food);

						break;
					}
					case 2: {
						System.out.println("Enter the Description of Food");
						String description = input.nextLine();

						this.getMenue().get(i).getFood().setDescription(description);

						break;
					}
					case 3: {
						System.out.println("Enter the Price ");
						double price = input.nextDouble();

						this.getMenue().get(i).getFood().setPrice(price);
						break;
					}
					}

				}
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	void deleteFood() throws InputMismatchException {
		Scanner input = new Scanner(System.in);

		menue();
		try {
			System.out.println("Enter Menu ID you want to Delete : ");
			int id = input.nextInt();
			for (int i : this.getMenue().keySet()) {
				if (id == this.getMenue().get(i).getMenu_id()) {
					System.out.println("Are you Sure you want to delete this food item ?\n1. Yes\n2. No");
					int choice = input.nextInt();
					if (choice == 1) {
						this.getMenue().remove(i);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("\nException : Kindly Enter the Appropriate Input Data Type.\n");
		}
	}

	void checkOrder(FoodonWheels FDW) {
		Scanner input = new Scanner(System.in);
		System.out.println("----------------------Your Orders---------------------------");
		for (int i : this.getOrder().keySet()) {
			if (this.getOrder().get(i).isStatus().equals(Orders.Order_Status.DRAFT))
				System.out.println(
						i + ".   " + "Food Item : " + this.getOrder().get(i).getCartitem().getFood_item().getName()
								+ "   Quantity : " + this.getOrder().get(i).getCartitem().getQuantity());
		}

		try {
			System.out.println("Select Order to Prepare ");
			int choice = input.nextInt();
			this.getOrder().get(choice).setStatus(Orders.Order_Status.REALIZED);

			for (int i : FDW.getCustomers().keySet()) {
				if (FDW.getCustomers().get(i).getId() == this.getOrder().get(choice).getCartitem().getCustomer_id()) {

					for (int j : FDW.getCustomers().get(i).getOrder().keySet()) {
						if (FDW.getCustomers().get(i).getOrder().get(j).equals(this.getOrder().get(choice))) {
							FDW.getCustomers().get(i).getOrder().get(j).setStatus(Orders.Order_Status.REALIZED);
						}
					}

				}
			}
			calculateBill(this.getOrder().get(choice));
			System.out.println("Your Order Has been Prepared. A Rider will soon Deliver it.\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void calculateBill(Orders order) {
		Invoice bill = new Invoice(order);
		bill.generateInvoice(bill);
	}

}
