package model;

public class User {
    private String maKH;
    private String tenKH;
    private String email;
    private String soDT;
    private String passWord;
    private String diaChi;
    private int roleID;

    public User() {
    }

    public User(String maKH, String tenKH, String email, String soDT, String passWord, String diaChi, int roleID) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.email = email;
        this.soDT = soDT;
        this.passWord = passWord;
        this.diaChi = diaChi;
        this.roleID = roleID;
    }

    public User(String tenKH, String email, String soDT, String passWord, String diaChi, int roleID) {
        this.tenKH = tenKH;
        this.email = email;
        this.soDT = soDT;
        this.passWord = passWord;
        this.diaChi = diaChi;
        this.roleID = roleID;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
