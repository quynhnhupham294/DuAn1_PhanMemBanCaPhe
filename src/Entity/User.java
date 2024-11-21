package Entity;

public class User {
    private String idUser;
    private String userName;
    private String password;
    private String phone;
    private String address;
    private String description;
    private String email;
    private boolean idRole;

    public User() {
    }

    public User(String idUser, String userName, String password, String phone, String address, String description, String email, boolean idRole) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.description = description;
        this.email = email;
        this.idRole = idRole;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIdRole() {
        return idRole;
    }

    public void setIdRole(boolean idRole) {
        this.idRole = idRole;
    }

    
    
}
