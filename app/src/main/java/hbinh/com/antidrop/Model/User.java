package hbinh.com.antidrop.Model;

public class User {

    String username;
    String password;
    String gender;
    String ngaysinh;
    int acctype;

    public User(String username, String password, String gender, String ngaysinh, int acctype) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.ngaysinh = ngaysinh;
        this.acctype = acctype;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }


    public int getAcctype() {
        return acctype;
    }

    public void setAcctype(int acctype) {
        this.acctype = acctype;
    }
}
