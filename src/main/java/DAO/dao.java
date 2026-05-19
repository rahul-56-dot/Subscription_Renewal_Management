package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Subscription;

import MODEL.OTTPlatform;
import MODEL.model;

public class dao {
	// Add plan
	public void addPlan(OTTPlatform p) {
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(
	            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
	            "postgres.yzmmkzddhvmgyhxazuxr",
	            "R@hulvar#51"
	        );

	        PreparedStatement ps = con.prepareStatement(
	            "INSERT INTO ott_plans(platform_id, plan_name, price, duration) VALUES(?,?,?,?)"
	        );
	        ps.setInt(1, p.getPlatform());       // ✅ correct
	        ps.setString(2, p.getName());
	        ps.setDouble(3, p.getPrice());
	        ps.setString(4, p.getDuration());      // ✅ store as string
	        ps.executeUpdate();

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// Get plans by platform
	public List<OTTPlatform> getPlansByPlatformId(int platformId) {
	    List<OTTPlatform> plans = new ArrayList<>();
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(
	            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
	            "postgres.yzmmkzddhvmgyhxazuxr",
	            "R@hulvar#51"
	        );

	        String sql = "SELECT * FROM ott_plans WHERE platform_id = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, platformId);
	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {
	            OTTPlatform plan = new OTTPlatform();
	            plan.setId(rs.getInt("id"));
	            plan.setPlatform(rs.getInt("platform_id"));
	            plan.setName(rs.getString("plan_name"));
	            plan.setPrice(rs.getDouble("price"));
	            plan.setDuration(rs.getString("duration")); // string for months/days
	            plans.add(plan);
	        }
	        con.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return plans;
	}


	public OTTPlatform getPlatformById(int id,String planName,OTTPlatform platform) {
//	    OTTPlatform platform = null;
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(
	            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
	            "postgres.yzmmkzddhvmgyhxazuxr",
	            "R@hulvar#51"
	        );

	        String sql = "SELECT * FROM ott_platforms WHERE id = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if(rs.next()) {
	            platform = new OTTPlatform();
	            platform.setId(rs.getInt("id"));
	            platform.setName(rs.getString("name"));
	            platform.setDescription(rs.getString("description"));
	            platform.setImage(rs.getString("image"));
	        }
	        con.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return platform;
	}
	public OTTPlatform getPlatformById(int platformId) {

	   OTTPlatform platform = null;
		

	    try {
	    	 Class.forName("org.postgresql.Driver");
		        Connection con = DriverManager.getConnection(
		            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
		            "postgres.yzmmkzddhvmgyhxazuxr",
		            "R@hulvar#51"
		        );

	        String sql = "SELECT * FROM ott_platforms WHERE id = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, platformId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	             platform = new OTTPlatform();
	            platform.setPlatform(rs.getInt("id"));
	            platform.setName(rs.getString("name"));
	            platform.setDescription(rs.getString("description"));
	            platform.setImage(rs.getString("image"));
	        }

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
return platform;
	    
	}

	public OTTPlatform getPlanByPlatformAndName(int platform, String planName) {
	    OTTPlatform plan = null;
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(
	            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
	            "postgres.yzmmkzddhvmgyhxazuxr",
	            "R@hulvar#51"
	        );

	        String sql = "SELECT * FROM ott_plans WHERE platform_id = ? AND plan_name = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, platform);
	        ps.setString(2, planName);
	        ResultSet rs = ps.executeQuery();

	        if(rs.next()) {
	            plan = new OTTPlatform();
	            plan.setId(rs.getInt("id"));
	            plan.setPlatform(rs.getInt("platform_id"));
	            plan.setName(rs.getString("plan_name"));
	            plan.setPrice(rs.getDouble("price"));
	            plan.setDuration(rs.getString("duration"));
	        }

	        con.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return plan;
	}



	// ✅ ADD OTT
	public void addPlatform(OTTPlatform p) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
					"postgres.yzmmkzddhvmgyhxazuxr", "R@hulvar#51");
			String sql = "INSERT INTO ott_platforms(id,name, description, image) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getDescription());
			ps.setString(4,p.getImage()	);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ✅ GET ALL OTTS
	public List<OTTPlatform> getAllPlatforms() {
		List<OTTPlatform> list = new ArrayList<>();
		/* try (PreparedStatement ps = con.prepareStatement(sql); */
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
					"postgres.yzmmkzddhvmgyhxazuxr", "R@hulvar#51");
			String sql = "SELECT * FROM ott_platforms";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OTTPlatform p = new OTTPlatform();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("image"));
				list.add(p);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public void deleteOttPlatform(int id) {


	    try  {
	    	Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
					"postgres.yzmmkzddhvmgyhxazuxr", "R@hulvar#51");
		    String sql = "DELETE FROM ott_platforms WHERE id = ?";
		    PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// Deactivate subscription by ID
	public void deactivatePlan(int subId) throws Exception {
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
					"postgres.yzmmkzddhvmgyhxazuxr", "R@hulvar#51");
			String sql = """
					    UPDATE subscriptions
					    SET status = 'INACTIVE'
					    WHERE sub_id = ?
					""";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, subId);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// admin
	public ResultSet getAllUserSubscriptions() throws Exception {
		PreparedStatement ps = null;
		int subId = 0;
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
					"postgres.yzmmkzddhvmgyhxazuxr", "R@hulvar#51");
			String sql = """
					SELECT s.sub_id,
					u."Username",
					u."Email", s.plan_name,
					s.start_date,
					s.end_date,
					(s.end_date - CURRENT_DATE) AS days_left,
					 s.status
					 FROM registration u
					 JOIN subscriptions s
					 ON u."Username" = s.username
					  ORDER BY s.end_date
					   """;
			ps = con.prepareStatement(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ps.executeQuery();
	}

	// ================= AUTO ALERT METHODS =================

	public List<model> getSubscriptionsForAlert() throws Exception {

		List<model> list = new ArrayList<>();

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres", "postgres.yzmmkzddhvmgyhxazuxr",
				"R@hulvar#51");

		String sql = """
				    SELECT sub_id, plan_name, end_date, u."Email"
				    FROM subscriptions s
				    JOIN registration u
				    ON s.username = u."Username"
				    WHERE (end_date - CURRENT_DATE) IN (7,3)
				    AND alert_sent = FALSE
				    AND status = 'ACTIVE'
				""";

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			model m = new model();
			m.setSubId(rs.getInt("sub_id"));
			m.setPlanName(rs.getString("plan_name"));
			m.setEndDate(rs.getDate("end_date").toLocalDate());
			m.setEmail(rs.getString("Email"));
			list.add(m);
		}

		con.close();
		return list;
	}
	// ================= MARK AUTO ALERT AS SENT =================

	public void markAlertSent(int subId) throws Exception {

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres", "postgres.yzmmkzddhvmgyhxazuxr",
				"R@hulvar#51");

		PreparedStatement ps = con.prepareStatement("UPDATE subscriptions SET alert_sent = TRUE WHERE sub_id = ?");

		ps.setInt(1, subId);
		ps.executeUpdate();

		ps.close();
		con.close();
	}

	// ================= AUTO RENEW METHODS =================

	public List<model> getAutoRenewPlans() throws Exception {

		List<model> list = new ArrayList<>();

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres", "postgres.yzmmkzddhvmgyhxazuxr",
				"R@hulvar#51");

		String sql = """
				    SELECT sub_id, u."Email"
				    FROM subscriptions s
				    JOIN registration u
				    ON s.username = u."Username"
				    WHERE s.end_date = CURRENT_DATE
				    AND s.auto_renew = TRUE
				    AND s.status = 'ACTIVE'
				""";

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			model m = new model();
			m.setSubId(rs.getInt("sub_id"));
			m.setEmail(rs.getString("Email"));
			list.add(m);
		}

		con.close();
		return list;
	}

	public void autoRenewSubscription(int subId) throws Exception {

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres", "postgres.yzmmkzddhvmgyhxazuxr",
				"R@hulvar#51");

		PreparedStatement ps = con.prepareStatement("""
				    UPDATE subscriptions
				    SET end_date = end_date + INTERVAL '30 days',
				        alert_sent = FALSE
				    WHERE sub_id = ?
				""");

		ps.setInt(1, subId);
		ps.executeUpdate();

		ps.close();
		con.close();
	}

	// current plan
	public List<model> getAllSubscriptions(String username) throws Exception {

	    List<model> plans = new ArrayList<>();

	    System.out.println("=== getAllSubscriptions START for username: [" + username + "]");

	    Class.forName("org.postgresql.Driver");

	    Connection con = DriverManager.getConnection(
	        "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
	        "postgres.yzmmkzddhvmgyhxazuxr",
	        "R@hulvar#51"
	    );

	    System.out.println("=== DB Connected successfully");

	    // STEP 1: Check raw subscriptions first
	    PreparedStatement rawPs = con.prepareStatement(
	        "SELECT * FROM subscriptions WHERE username = ?"
	    );
	    rawPs.setString(1, username);
	    ResultSet rawRs = rawPs.executeQuery();

	    System.out.println("=== RAW subscriptions rows:");
	    boolean hasRaw = false;
	    while (rawRs.next()) {
	        hasRaw = true;
	        System.out.println("  sub_id=" + rawRs.getInt("sub_id")
	            + " | username=[" + rawRs.getString("username") + "]"
	            + " | platform=[" + rawRs.getString("platform") + "]"
	            + " | plan_name=[" + rawRs.getString("plan_name") + "]"
	            + " | status=[" + rawRs.getString("status") + "]"
	            + " | start=" + rawRs.getDate("start_date")
	            + " | end=" + rawRs.getDate("end_date")
	        );
	    }
	    if (!hasRaw) {
	        System.out.println("  ❌ NO ROWS found in subscriptions for username: [" + username + "]");
	    }

	    // STEP 2: Check ott_platforms
	    PreparedStatement ottPs = con.prepareStatement("SELECT id, name FROM ott_platforms");
	    ResultSet ottRs = ottPs.executeQuery();
	    System.out.println("=== ott_platforms rows:");
	    while (ottRs.next()) {
	        System.out.println("  id=" + ottRs.getInt("id") + " | name=[" + ottRs.getString("name") + "]");
	    }

	    // STEP 3: Run the actual JOIN query
	    PreparedStatement ps = con.prepareStatement(
	        "SELECT s.*, o.id AS ott_id, o.name AS ott_name " +
	        "FROM subscriptions s " +
	        "LEFT JOIN ott_platforms o ON LOWER(TRIM(s.platform)) = LOWER(TRIM(o.name)) " +
	        "WHERE s.username = ?"
	    );
	    ps.setString(1, username);
	    ResultSet rs = ps.executeQuery();

	    System.out.println("=== JOIN query rows:");
	    boolean hasJoin = false;
	    while (rs.next()) {
	        hasJoin = true;
	        System.out.println("  platform=[" + rs.getString("platform") + "]"
	            + " | ott_name=[" + rs.getString("ott_name") + "]"
	            + " | ott_id=" + rs.getInt("ott_id")
	        );

	        model m = new model();
	        OTTPlatform platform = new OTTPlatform();
	        String ottName = rs.getString("ott_name");
	        platform.setName(ottName != null ? ottName : rs.getString("platform"));
	        platform.setId(rs.getInt("ott_id"));
	        m.setOttPlatform(platform);
	        m.setPlanName(rs.getString("plan_name"));
	        m.setStartDate(rs.getDate("start_date").toLocalDate());
	        m.setEndDate(rs.getDate("end_date").toLocalDate());
	        m.setStatus(rs.getString("status"));
	        plans.add(m);
	    }
	    if (!hasJoin) {
	        System.out.println("  ❌ JOIN returned NO ROWS");
	    }

	    con.close();
	    System.out.println("=== getAllSubscriptions END — plans.size()=" + plans.size());
	    return plans;
	}


	// Subscription
	public static boolean addSubscription(model s) {

	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(
	            "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
	            "postgres.yzmmkzddhvmgyhxazuxr",
	            "R@hulvar#51"
	        );

	        // 🚫 BLOCK SAME PLATFORM
	        PreparedStatement checkPs = con.prepareStatement(
	            "SELECT 1 FROM subscriptions WHERE username=? AND platform=? AND status='ACTIVE'"
	        );
	        checkPs.setString(1, s.getUsername());
	        checkPs.setString(2, s.getPlatform());

	        if (checkPs.executeQuery().next()) {
	            con.close();
	            return false; // ❌ already subscribed to this platform
	        }

	        // ✅ INSERT NEW SUBSCRIPTION
	        PreparedStatement ps = con.prepareStatement(
	            """
	            INSERT INTO subscriptions
	            (username, plan_name, start_date, end_date, status, platform)
	            VALUES (?,?,?,?,?,?)
	            """
	        );

	        ps.setString(1, s.getUsername());
	        ps.setString(2, s.getPlanName());
	        ps.setDate(3, Date.valueOf(s.getStartDate()));
	        ps.setDate(4, Date.valueOf(s.getEndDate()));
	        ps.setString(5, "ACTIVE");
	        ps.setString(6, s.getPlatform());

	        ps.executeUpdate();
	        con.close();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	

//	private static String getPlatformFromPlan(String planName) {
//		planName = planName.toLowerCase();
//		if (planName.contains("netflix"))
//			return "Netflix";
//		if (planName.contains("aha"))
//			return "Aha";
//		if (planName.contains("amazon Prime"))
//			return "Amazon Prime";
//		if (planName.contains("hotstar"))
//			return "Hotstar";
//
//		// Add more platforms here if needed
//		return "this platform";
//	}

	// Login Page
	public boolean login(model ml) {

		boolean result = false;

		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
					"postgres.yzmmkzddhvmgyhxazuxr", "R@hulvar#51");

			PreparedStatement psmt = con
					.prepareStatement("SELECT 1 FROM registration WHERE \"Username\" = ? AND \"Password\" = ?");

			psmt.setString(1, ml.getUsername());
			psmt.setString(2, ml.getPassword());

			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// Registration Page
	public int register(model mv) {
		int result = 0;
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres",
					"postgres.yzmmkzddhvmgyhxazuxr", "R@hulvar#51");
			System.out.println("Data Base is connected Successfully : " + con);
			PreparedStatement psmt = con.prepareStatement("Insert into registration values(?,?,?,?,?)");
			psmt.setString(1, mv.getFullname());
			psmt.setString(2, mv.getUsername());
			psmt.setString(3, mv.getEmail());
			psmt.setString(4, mv.getContact());
			psmt.setString(5, mv.getPassword());

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
