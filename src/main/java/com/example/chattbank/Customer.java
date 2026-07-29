package com.example.chattbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer {

    private int custId;
    private String custPassword;
    private String custFirstName;
    private String custLastName;
    private String custAddress;
    private String custEmail;
    private AccountList aList;

    public Customer() {
        this.custId = 0;
        this.custPassword = "";
        this.custFirstName = "";
        this.custLastName = "";
        this.custAddress = "";
        this.custEmail = "";
        this.aList = new AccountList();
    }

    public Customer(int custId, String custPassword, String custFirstName,
                    String custLastName, String custAddress, String custEmail) {
        this.custId = custId;
        this.custPassword = custPassword;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.custAddress = custAddress;
        this.custEmail = custEmail;
        this.aList = new AccountList();

    }

    public int getCustId() { return custId; }
    public void setCustId(int custId) { this.custId = custId; }

    public String getCustPassword() { return custPassword; }
    public void setCustPassword(String custPassword) { this.custPassword = custPassword; }

    public String getCustFirstName() { return custFirstName; }
    public void setCustFirstName(String custFirstName) { this.custFirstName = custFirstName; }

    public String getCustLastName() { return custLastName; }
    public void setCustLastName(String custLastName) { this.custLastName = custLastName; }

    public String getCustAddress() { return custAddress; }
    public void setCustAddress(String custAddress) { this.custAddress = custAddress; }

    public String getCustEmail() { return custEmail; }
    public void setCustEmail(String custEmail) { this.custEmail = custEmail; }

    public void display() {
        System.out.println("Customer:");
        System.out.println("  custId: " + custId);
        System.out.println("  custPassword: " + custPassword);
        System.out.println("  custFirstName: " + custFirstName);
        System.out.println("  custLastName: " + custLastName);
        System.out.println("  custAddress: " + custAddress);
        System.out.println("  custEmail: " + custEmail);
    }

    public void selectDB(int custId) {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/ChattBank/src/main/webapp/WEB-INF/db/ChattBankACCDB.accdb";
            String dbUrl = "jdbc:ucanaccess://" + dbPath;

            Connection conn = DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Customers WHERE CustID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, custId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.custId = rs.getInt("CustID");
                this.custPassword = rs.getString("CustPassword");
                this.custFirstName = rs.getString("CustFirstName");
                this.custLastName = rs.getString("CustLastName");
                this.custAddress = rs.getString("CustAddress");
                this.custEmail = rs.getString("CustEmail");
            }

            String sql2 = "SELECT * FROM Accounts WHERE Cid = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, custId);

            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                Account acct = new Account();
                acct.setAcctNo(rs2.getInt("AcctNo"));
                acct.setCustId(rs2.getInt("Cid"));
                acct.setType(rs2.getString("Type"));
                acct.setBalance(rs2.getDouble("Balance"));

                aList.add(acct);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertDB(int custId, String custPassword, String custFirstName,
                         String custLastName, String custAddress, String custEmail) {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/ChattBank/src/main/webapp/WEB-INF/db/ChattBankACCDB.accdb";
            String dbUrl = "jdbc:ucanaccess://" + dbPath;

            Connection conn = DriverManager.getConnection(dbUrl);

            String sql = "INSERT INTO Customers (CustID, CustPassword, CustFirstName, CustLastName, CustAddress, CustEmail) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, custId);
            ps.setString(2, custPassword);
            ps.setString(3, custFirstName);
            ps.setString(4, custLastName);
            ps.setString(5, custAddress);
            ps.setString(6, custEmail);

            ps.executeUpdate();
            conn.close();

            this.custId = custId;
            this.custPassword = custPassword;
            this.custFirstName = custFirstName;
            this.custLastName = custLastName;
            this.custAddress = custAddress;
            this.custEmail = custEmail;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDB() {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/ChattBank/src/main/webapp/WEB-INF/db/ChattBankACCDB.accdb";
            String dbUrl = "jdbc:ucanaccess://" + dbPath;

            Connection conn = DriverManager.getConnection(dbUrl);

            String sql = "DELETE FROM Customers WHERE CustID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, this.custId);

            ps.executeUpdate();
            conn.close();

            this.custId = 0;
            this.custPassword = "";
            this.custFirstName = "";
            this.custLastName = "";
            this.custAddress = "";
            this.custEmail = "";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AccountList getAList() {
        return aList;
    }
}