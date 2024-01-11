import java.util.Random;

public class Orders {

	private CartItems cartitem;
	private Order_Status status;
	private int order_id;
	private int restaurant_id;

	Random rand = new Random();

	
	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public Orders.Order_Status isStatus() {
		return status;
	}

	public void setStatus(Orders.Order_Status status) {
		this.status = status;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public CartItems getCartitem() {
		return cartitem;
	}

	public void setCartitem(CartItems cartitem) {
		this.cartitem = cartitem;
	}

	enum Order_Status {
		CANCELED, REALIZED, DRAFT, DISPATCHED, DELIVERED,
	}

	// ********************************
	Orders(int restaurantId,CartItems cartitem) {
		this.restaurant_id=restaurantId;
		this.cartitem = cartitem;
		this.setStatus(Order_Status.DRAFT);
		this.order_id = rand.nextInt(1000);
	}



}
