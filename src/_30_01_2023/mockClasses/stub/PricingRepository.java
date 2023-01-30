package _30_01_2023.mockClasses.stub;

public class PricingRepository {

	// [... other methods ...]

	public Price getPriceForTrade(Trade trade) {
		return trade.price;
	}
}