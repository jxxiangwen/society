package cn.edu.shu.society.domain;

/**
 * Created by jxxia on 2016/4/12 0012.
 */
public class User {
    private int id;
    private String user_name;
    private String password;
    private int age;

    public User() {
    }

    public User(int id, String user_name, String password, int age) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
