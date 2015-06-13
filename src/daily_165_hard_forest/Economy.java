package daily_165_hard_forest;

public class Economy {
	private double priceLumberjack;
	private double priceWood;
	
	public Economy() {
		this.priceLumberjack = 10;
		this.priceWood = 1.0;
	}
	
	public double sellWood() {
		this.priceWood -= 0.01;
		if (this.priceWood <= 0) {
			this.priceWood = 0.02;
		}
		return this.priceWood;
	}
	
	public double buyLumberjack() {
		this.priceLumberjack += 10;
		return this.priceLumberjack;
	}
	
	public void tick() {
		//TODO: beter pricing
		this.priceLumberjack = 10;
		this.priceWood = 1.0;
	}
	
}
