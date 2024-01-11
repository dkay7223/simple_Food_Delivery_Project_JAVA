import java.util.Random;

public class Invoice {

	private Orders final_order;
	private int Invoice_id;
	private boolean invoice_status;

	Random rand = new Random();

	public boolean getInvoice_status() {
		return invoice_status;
	}

	public void setInvoice_status(boolean invoice_status) {
		this.invoice_status = invoice_status;
	}

	public Orders getFinal_order() {
		return final_order;
	}

	public void setFinal_order(Orders final_order) {
		this.final_order = final_order;
	}

	public int getInvoice_id() {
		return Invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		Invoice_id = invoice_id;
	}

	Invoice(Orders final_order) {
		this.final_order = final_order;
		this.Invoice_id = rand.nextInt(1000);
		this.setInvoice_status(false);

	}

	void generateInvoice(Invoice bill) {
		System.out.println("\n\n------------------INVOICE-----------------");
		System.out.println("Name : " + bill.getFinal_order().getCartitem().getCustomer_Name());
		System.out.println("Purchased Items : " + bill.getFinal_order().getCartitem().getFood_item().getName());
		System.out.println("Qunatity : " + bill.getFinal_order().getCartitem().getQuantity());
		System.out.println("Price per Item : " + bill.getFinal_order().getCartitem().getFood_item().getPrice());
		System.out.println("______________________________________________");
		System.out.println("Total Payable Amount : " + bill.getFinal_order().getCartitem().getQuantity()
				* bill.getFinal_order().getCartitem().getFood_item().getPrice());
		System.out.println("______________________________________________\n");

		if (!bill.getInvoice_status()) {
			System.out.println("You Have Not Yet Payed For Your Order\n");
		} else {
			System.out.println("You Have Payed For Your Order\n");
		}

	}

}
