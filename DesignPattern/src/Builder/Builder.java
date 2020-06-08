package Builder;

/**
 * 
 * @author Cao Minh Duc
 * Builder dùng để tạo ra những Object phức tạp từng bước một
 * Ví dụ như: Mình xây nhà, nhưng sau này mình có thể xây nhà có cây, nhà có hồ bơi, nhà có garage
 * Composite, Adapter, Proxy, Decorator, Template Method, Stragtegy, State, Observer
 */

interface OrderBuilder {
	public void buildOrderType(OrderType orderType);
	public void buildBreadType(BreadType breadType);
	public void buildSauceType(SauceType sauceType);
	public void buildVegetableType(VegetableType vegetableType);
	public Order buildOrder();
}

class FastFoodOrderBuilder implements OrderBuilder {
	
	private Order order = new Order();
	
	@Override
	public void buildBreadType(BreadType breadType) {
		this.order.setBreadType(breadType);
	}

	@Override
	public Order buildOrder() {
		return this.order;
	}

	@Override
	public void buildOrderType(OrderType orderType) {
		this.order.setOrderType(orderType);
	}

	@Override
	public void buildSauceType(SauceType sauceType) {
		this.order.setSauceType(sauceType);
	}

	@Override
	public void buildVegetableType(VegetableType vegetableType) {
		this.order.setVegetableType(vegetableType);
	}
	
}

class Order {
	private OrderType orderType;
	private BreadType breadType;
	private SauceType sauceType;
	private VegetableType vegetableType;
	
	public Order(OrderType orderType, BreadType breadType, SauceType sauceType, VegetableType vegetableType) {
		super();
		this.orderType = orderType;
		this.breadType = breadType;
		this.sauceType = sauceType;
		this.vegetableType = vegetableType;
	}

	public Order() {

	}

	public OrderType getOrderType() {
		return orderType;
	}
	
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	public BreadType getBreadType() {
		return breadType;
	}
	
	public void setBreadType(BreadType breadType) {
		this.breadType = breadType;
	}
	
	public SauceType getSauceType() {
		return sauceType;
	}
	
	public void setSauceType(SauceType sauceType) {
		this.sauceType = sauceType;
	}
	
	public VegetableType getVegetableType() {
		return vegetableType;
	}
	
	public void setVegetableType(VegetableType vegetableType) {
		this.vegetableType = vegetableType;
	}

	@Override
	public String toString() {
		return "Order [orderType=" + orderType + ", breadType=" + breadType + ", sauceType=" + sauceType
				+ ", vegetableType=" + vegetableType + "]";
	}
}

enum BreadType {
	SIMPLE, OMELETTE, FRIED_EGG, GRILLED_FIS, PORK, BEEF
}

enum OrderType {
	ON_SITE, TAKE_AWAY
}

enum SauceType {
	SOY_SAUCE, FISH_SAUCE, OLIVE_OIL, KETCHUP, MUSTARD
}

enum VegetableType {
	SALAD, CUCUMBER, TOMATO
}

public class Builder {
	public static void main(String[] args) {
		OrderBuilder fastOrderBuilder = new FastFoodOrderBuilder();
		fastOrderBuilder.buildBreadType(BreadType.BEEF);
		fastOrderBuilder.buildOrderType(OrderType.ON_SITE);
		fastOrderBuilder.buildSauceType(SauceType.FISH_SAUCE);
		fastOrderBuilder.buildVegetableType(VegetableType.CUCUMBER);
		Order order = fastOrderBuilder.buildOrder();
		System.out.println(order);
	}
}
