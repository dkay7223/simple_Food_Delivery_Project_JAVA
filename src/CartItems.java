import java.util.Random;

public class CartItems {

	private String Customer_Name;
	private int Customer_id;
	private int quantity;
	private FoodItems food_item;
	private int cartItem_id;
	private int restaurantId;

	Random rand = new Random();

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public FoodItems getFood_item() {
		return food_item;
	}

	public void setFood_item(FoodItems food_item) {
		this.food_item = food_item;
	}

	public int getCartItem_id() {
		return cartItem_id;
	}

	public void setCartItem_id(int cartItem_id) {
		this.cartItem_id = cartItem_id;
	}
	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	CartItems(int restaurantId,String name, int id, int quantity, FoodItems food_item) {
		this.restaurantId=restaurantId;
		this.Customer_id = id;
		this.Customer_Name = name;
		this.quantity = quantity;
		this.food_item = food_item;
		this.cartItem_id = rand.nextInt(1000);
	}



}
