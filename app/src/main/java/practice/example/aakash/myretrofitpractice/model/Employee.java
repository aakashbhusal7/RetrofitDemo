package practice.example.aakash.myretrofitpractice.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aakash on 3/3/18.
 */

public class Employee {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @SerializedName("phone")
    private String phone;

    public Employee(String name, String email, String  phone){
        this.name=name;
        this.email=email;
        this.phone=phone;
    }
}
