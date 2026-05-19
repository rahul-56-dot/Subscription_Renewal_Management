package MODEL;

public class OTTPlatform {
    private int id;
    private String name;
    private String description;
    private String image;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	private String planName;

    private int Platform;
//	private int planId;
	private double price;
	private String duration;

//	public int getPlanId() {
//	    return planId;
//	}
//	public void setPlanId(int planId) {
//	    this.planId = planId;
//	}

	public double getPrice() {
	    return price;
	}
	public void setPrice(double price) {
	    this.price = price;
	}

	public String getDuration() {
	    return duration;
	}
	public void setDuration(String duration) {
	    this.duration = duration;
	}
    public int getPlatform() {
		return Platform;
	}

	public void setPlatform(int platform) {
		Platform = platform;
	}

	
}
