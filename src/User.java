import java.util.*;

public abstract class User {

	private String name;
	private String address;
	private String phone;
	private String email;
	private String pass;
	private int id;
	private Usertype type;
	private double balance;
	private HashMap<Integer, Orders> order = new HashMap<Integer, Orders>();
	private HashMap<Integer, CartItems> cart = new HashMap<Integer, CartItems>();

	Random rand = new Random();


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	public Usertype getType() {
		return type;
	}

	public void setType(Usertype type) {
		this.type = type;
	}
	
	public HashMap<Integer, Orders> getOrder() {
		return order;
	}

	public void setOrder(HashMap<Integer, Orders> order) {
		this.order = order;
	}

	public HashMap<Integer, CartItems> getCart() {
		return cart;
	}

	public void setCart(HashMap<Integer, CartItems> cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User(String name, String address, String phone, String email) {
		this.setId(rand.nextInt(1000));
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		

	}
	
	enum Usertype{
		ADMIN,CUSTOMER,RIDER
	}

	void profile() {
		System.out.println("\n**********USER PROFILE***********");
		System.out.println("Name : " + this.getName());
		System.out.println("Email : " + this.getEmail());
		System.out.println("ID : " + this.getId());
		System.out.println("Address : " + this.getAddress());
		System.out.println("Phone : " + this.getPhone());
		System.out.println("**********************************\n\n");

	}

	
	abstract void menu(FoodonWheels FDW) ;

}
