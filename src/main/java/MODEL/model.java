package MODEL;

import java.time.LocalDate;

import org.apache.tomcat.util.compat.JrePlatform;

public class model {
	private OTTPlatform ottPlatform;

	public OTTPlatform getOttPlatform() {
	    return ottPlatform;
	}

	public void setOttPlatform(OTTPlatform ottPlatform) {
	    this.ottPlatform = ottPlatform;
	}

    // ===== USER DETAILS =====
    private String fullname;
    private String username;
    private String email;
    private String contact;
    private String password;

    // ===== SUBSCRIPTION DETAILS =====
    private int subId;
    
	private String planName;
	private String Platform;
	public String getPlatform() {
		return Platform;
	}

	public void setPlatform(String platform) {
		Platform = platform;
	}

	private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate daysleft;
    private LocalDate currentplan;
    
    
    public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

    public LocalDate getCurrentplan() {
		return currentplan;
	}

	public void setCurrentplan(LocalDate currentplan) {
		this.currentplan = currentplan;
	}

	public LocalDate getDaysleft() {
		return daysleft;
	}

	public void setDaysleft(LocalDate daysleft) {
		this.daysleft = daysleft;
	}

	private String status;

    // ===== USER GETTERS & SETTERS =====
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ===== SUBSCRIPTION GETTERS & SETTERS =====
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
