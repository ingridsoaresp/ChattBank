package com.example.chattbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account {

    private int acctNo;
    private int custId;
    private String type;
    private double balance;

    public Account() {
        this.acctNo = 0;
        this.custId = 0;
        this.type = "";
        this.balance = 0.0;
    }

    public Account(int acctNo, int custId, String type, double balance) {
        this.acctNo = acctNo;
        this.custId = custId;
        this.type = type;
        this.balance = balance;
    }

    public int getAcctNo() { return acctNo; }
    public void setAcctNo(int acctNo) { this.acctNo = acctNo; }

    public int getCustId() { return custId; }
    public void setCustId(int custId) { this.custId = custId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public void display() {
        System.out.println("Account:");
        System.out.println("  acctNo: " + acctNo);
        System.out.println("  custId: " + custId);
        System.out.println("  type: " + type);
        System.out.println("  balance: " + balance);
    }

    public void selectDB(int acctNo) {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/ChattBank/src/main/webapp/WEB-INF/db/ChattBankACCDB.accdb";
            String dbUrl = "jdbc:ucanaccess://" + dbPath;

            Connection conn = DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM Accounts WHERE AcctNo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, acctNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.acctNo = rs.getInt("AcctNo");
                this.custId = rs.getInt("Cid");
                this.type = rs.getString("Type");
                this.balance = rs.getDouble("Balance");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertDB(int acctNo, int custId, String type, double balance) {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String dbPath = "C:/Users/ingri/Desktop/College/JavaIII/ChattBank/src/main/webapp/WEB-INF/db/ChattBankACCDB.accdb";
            String dbUrl = "jdbc:ucanaccess://" + dbPath;

            Connection conn = DriverManager.getConnection(dbUrl);

            String sql = "INSERT INTO Accounts (AcctNo, Cid, Type, Balance) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, acctNo);
            ps.setInt(2, custId);
            ps.setString(3, type);
            ps.setDouble(4, balance);

            ps.executeUpdate();
            conn.close();

            this.acctNo = acctNo;
            this.custId = custId;
            this.type = type;
            this.balance = balance;

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

            String sql = "DELETE FROM Accounts WHERE AcctNo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, this.acctNo);

            ps.executeUpdate();
            conn.close();

            this.acctNo = 0;
            this.custId = 0;
            this.type = "";
            this.balance = 0.0;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}