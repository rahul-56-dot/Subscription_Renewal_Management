# Subscription Renewal Management System (SRMS)

A web-based **Subscription Renewal Management System** built using **Java Servlets, JSP, JDBC, PostgreSQL, and Jakarta Mail (JavaMail API)**. The application allows users to subscribe to and manage plans for various OTT platforms (such as Netflix, Amazon Prime, Hotstar, and Aha) while providing admins with features to manage platforms, plans, and monitor active user subscriptions.

---

## 🚀 Features

### 👤 User Module
* **User Authentication:** Registration, Login, and Logout functionality.
* **Dashboard:** Overview of active/inactive OTT subscriptions.
* **Plan Explorer:** View and select standard subscription plans for different platforms (Netflix, Prime, Aha, Hotstar).
* **Subscription Management:** Subscribe to new plans, enable/disable **Auto-Renewal**, or deactivate active plans.
* **Email Alerts:** Automatically receives email notifications (using the Jakarta Mail API) when subscriptions are 7 days and 3 days away from expiring.

### 🔑 Admin Module
* **Admin Dashboard:** Monitor all user subscriptions, status, and days remaining for expiry.
* **Platform Management:** Add new OTT platforms with name, description, and logo, or delete existing ones.
* **Plan Management:** Create and configure new pricing plans (price, duration, etc.) for any platform.
* **Send Alerts:** Manually trigger alerts/notices to users regarding their subscriptions.

### ⚙️ Background Services (Schedulers)
* **AutoMailScheduler:** Runs automatically in the background (configured via `ServletContainerListener`) once daily to query expiring subscriptions and send reminder emails to users.
* **AutoRenewScheduler:** Automatically renews active subscriptions with `auto_renew = TRUE` on their exact expiry date, extending their end-date by 30 days and resetting alert statuses.

---

## 🛠️ Tech Stack
* **Backend:** Java (Servlets, JSP, JDBC)
* **Frontend:** HTML5, CSS3, JavaScript
* **Database:** PostgreSQL
* **Mail Client:** Jakarta Mail (JavaMail API)
* **Web Server:** Tomcat 10+ (supporting Jakarta packages)

---

## 📂 Project Directory Structure

```
Subscription_Renewal_Management/
├── src/main/java/
│   ├── Controller/        # Java Servlets handling User & Admin HTTP requests
│   ├── DAO/               # Database Access Object (dao.java) and Background Schedulers
│   └── MODEL/             # Model classes (model.java, OTTPlatform.java)
├── src/main/webapp/
│   ├── assets/            # Static image assets and logos
│   ├── META-INF/          # Manifest and deployment descriptors
│   ├── WEB-INF/           # Deployment descriptors and JAR libraries
│   │   ├── lib/           # Jakarta Mail & Activation JARs
│   │   └── web.xml
│   ├── style.css          # Main stylesheet
│   ├── slider.js          # JavaScript slider utilities
│   ├── *.jsp              # Dynamic Java Server Pages (Dashboard, Plans, etc.)
│   └── *.html             # Static pages (Login, Registration, Admin Portal)
├── .gitignore             # Git exclusion rules
└── README.md              # Project documentation
```

---

## 🗄️ Database Schema Setup (PostgreSQL)

You can set up your PostgreSQL database using the following SQL commands:

```sql
-- 1. User Registration Table
CREATE TABLE registration (
    "Fullname" VARCHAR(100),
    "Username" VARCHAR(50) PRIMARY KEY,
    "Email" VARCHAR(100) UNIQUE,
    "Contact" VARCHAR(20),
    "Password" VARCHAR(100)
);

-- 2. OTT Platforms Table
CREATE TABLE ott_platforms (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    image VARCHAR(255)
);

-- 3. OTT Plans Table
CREATE TABLE ott_plans (
    id SERIAL PRIMARY KEY,
    platform_id INT REFERENCES ott_platforms(id) ON DELETE CASCADE,
    plan_name VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    duration VARCHAR(50) NOT NULL
);

-- 4. User Subscriptions Table
CREATE TABLE subscriptions (
    sub_id SERIAL PRIMARY KEY,
    username VARCHAR(50) REFERENCES registration("Username") ON DELETE CASCADE,
    platform VARCHAR(50),
    plan_name VARCHAR(100),
    start_date DATE DEFAULT CURRENT_DATE,
    end_date DATE,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    alert_sent BOOLEAN DEFAULT FALSE,
    auto_renew BOOLEAN DEFAULT FALSE
);
```

---

## ⚙️ How to Configure Schedulers & Mail
The background schedulers boot automatically when the web server starts up, thanks to the `@WebListener` configured in `SchedulerListener.java`.
To configure your SMTP server details (for outgoing reminder emails), update the credentials in `DAO/MailUtil.java`.

---

## 🏁 How to Run Locally

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/rahul-56-dot/Subscription_Renewal_Management.git
   ```
2. **Setup Database:**
   * Run the SQL scripts from the **Database Schema Setup** section in your PostgreSQL query editor.
   * Update the connection URL, username, and password in `DAO/dao.java` (under `DriverManager.getConnection()`).
3. **Deploy on Tomcat:**
   * Import the project into your IDE (Eclipse or IntelliJ).
   * Ensure that the Tomcat server (version 10 or newer for `jakarta.*` packages support) is configured.
   * Add the project to the server runtime and run it.
