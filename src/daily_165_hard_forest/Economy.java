package daily_165_hard_forest;

public class Economy {
	private double priceLumberjack;
	private double priceWood;
	
	public Economy() {
		this.priceLumberjack = 6;
		this.priceWood = 1.0;
	}
	
	public double sellWood() {
		this.priceWood -= 0.001;
		if (this.priceWood <= 0) {
			this.priceWood = 0.03;
		}
		return this.priceWood;
	}
	
	public double buyLumberjack() {
		this.priceLumberjack += 0.3;
		return this.priceLumberjack;
	}
	
	public void tick() {
		//TODO: beter pricing
		this.priceLumberjack = 6;
		this.priceWood = 1.0;
	}
	
}
