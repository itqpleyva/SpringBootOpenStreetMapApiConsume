package Main.Model;

public class Location {

	private String name;
	private String latitude;
	private String longitud;
	private String country;
	private String place_id;
	

	@Override
	public String toString() {
		return "Location [name=" + name + ", latitude=" + latitude + ", longitud=" + longitud + ", country=" + country
				+ ", place_id=" + place_id + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location(String name, String latitude, String longitud, String country, String place_id) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitud = longitud;
		this.country = country;
		this.place_id = place_id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
