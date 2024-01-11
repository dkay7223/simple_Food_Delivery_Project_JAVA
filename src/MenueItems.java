import java.util.Random;

public class MenueItems {

	private FoodItems food;
	private int menu_id;
	private int restaurantid;

	Random rand = new Random();

	
	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public FoodItems getFood() {
		return food;
	}

	public void setFood(FoodItems food) {
		this.food = food;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	// ********************************
	MenueItems(int restaurantid,FoodItems food) {
		this.restaurantid=restaurantid;
		this.menu_id = rand.nextInt(1000);
		this.food = food;

	}



}
