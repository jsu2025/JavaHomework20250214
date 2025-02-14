package model;

public class Porder {
	private Integer id;
	private String name;
	private Integer lcd;
	private Integer ram;
	private Integer mouse;
	public Porder(String name, Integer lcd, Integer ram, Integer mouse) {
		super();
		this.name = name;
		this.lcd = lcd;
		this.ram = ram;
		this.mouse = mouse;
	}
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLcd() {
		return lcd;
	}
	public void setLcd(Integer lcd) {
		this.lcd = lcd;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public Integer getMouse() {
		return mouse;
	}
	public void setMouse(Integer mouse) {
		this.mouse = mouse;
	}
	
	
	
	

}