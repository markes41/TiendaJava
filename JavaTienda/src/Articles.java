
public class Articles {
	private int code;
	private String desc, name;
	private double price;
	
	public Articles(int code, String desc, String name, double price) {
		super();
		this.code = code;
		this.desc = desc;
		this.name = name;
		this.price = price;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
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
	
	
}
