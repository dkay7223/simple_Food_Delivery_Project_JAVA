import java.util.Random;

public class FoodItems {

	private String name;
	private double price;
	private String description;
	private int foodid;

	// ***********Random Class***********
	Random rand = new Random();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFoodid() {
		return foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}

	// **********************************
	FoodItems(String name, String description, double price) {
		this.description = description;
		this.name = name;
		this.price = price;
		this.setFoodid(rand.nextInt(1000));
	}

}