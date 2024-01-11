import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FoodonWheels {

	private ArrayList<User> users=new ArrayList<User>();
	private HashMap<Integer, Restaurant> Restaurants = new HashMap<Integer, Restaurant>();
	private HashMap<Integer, User> Riders = new HashMap<Integer, User>();
	private HashMap<Integer, User> Customers = new HashMap<Integer, User>();



	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	
	public HashMap<Integer, User> getCustomers() {
		return Customers;
	}

	public void setCustomers(HashMap<Integer, User> customers) {
		Customers = customers;
	}

	public HashMap<Integer, User> getRiders() {
		return Riders;
	}

	public void setRiders(HashMap<Integer, User> riders) {
		Riders = riders;
	}

	public HashMap<Integer, Restaurant> getRestaurants() {
		return Restaurants;
	}

	public void setRestaurants(HashMap<Integer, Restaurant> restaurants) {
		Restaurants = restaurants;
	}

	// ***********************MAIN************************
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FoodonWheels FDW = new FoodonWheels();
		User admin = new Admin("", "", "", "");
		FDW.users.add(admin);

		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {

			System.out.println("1. Login\n2. Sign Up\n3. Exit\n Enter choice : ");
			choice = input.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter Your Login ID.");
				int id = input.nextInt();
				System.out.println("Enter Your Password.");
				String pass = input.next();

				
				for(int i=0;i<FDW.users.size();i++) {
					if(FDW.users.get(i).getId()==id) {
						if(FDW.users.get(i).getPass().equals(pass)) {
							FDW.users.get(i).menu(FDW);
						}
					}
				}
	

				for (int i : FDW.Restaurants.keySet()) {
					if (id == FDW.Restaurants.get(i).getId()) {
						if (pass.equals(FDW.getRestaurants().get(i).getPass())) {
							FDW.getRestaurants().get(i).menu(FDW);
						}
					}
				}

				break;
			}
			case 2: {
				System.out
						.println("1. Sign Up a Restaurant\n2. Sign Up a Rider\n3. Sign Up a Customer\nEnter choice : ");
				int choice_1 = input.nextInt();

				switch (choice_1) {
				case 1: {
					input.nextLine();
					System.out.println("Enter your Name of Restaurants: ");
					String name = input.nextLine();
					System.out.println("Enter your Address : ");
					String address = input.nextLine();
					System.out.println("Enter your Active Telephone line : ");
					String phone = input.nextLine();
					System.out.println("Enter your Official Email : ");
					String email = input.nextLine();
					Restaurant res = new Restaurant(name, address, phone, email);
					res.profile();
					FDW.Restaurants.put(res.getId(), res);
					

					break;
				}
				case 2: {
					input.nextLine();
					System.out.println("Enter your Name : ");
					String name = input.nextLine();
					System.out.println("Enter your Address : ");
					String address = input.nextLine();
					System.out.println("Enter your Phone : ");
					String phone = input.nextLine();
					System.out.println("Enter your Email : ");
					String email = input.nextLine();
					User rider = new Rider(name, address, phone, email);
					rider.profile();
					FDW.users.add(rider);
					FDW.Riders.put(rider.getId(), rider);
					

					break;
				}
				case 3: {
					input.nextLine();
					System.out.println("Enter your Name : ");
					String name = input.nextLine();
					System.out.println("Enter your Address : ");
					String address = input.nextLine();
					System.out.println("Enter your Phone : ");
					String phone = input.nextLine();
					System.out.println("Enter your Email : ");
					String email = input.nextLine();
					User customer = new Customer(name, address, phone, email);
					customer.profile();
					FDW.users.add(customer);
					FDW.Customers.put(customer.getId(), customer);

					break;
				}
				}
				break;
			}
			case 3: {

				break;
			}
			}

		} while (choice != 3);

		Serialization S=new Serialization();
		S.Serialize(FDW);
	}

}
