package connsolr.bean;

import java.io.Serializable;

/**
 * @author hx
 * @version 1.0
 * @date 2021/4/13 15:59
 */
public class User implements Serializable {

    String id;
    String name;
    String age;
    String conn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getConn() {
        return conn;
    }

    public void setConn(String conn) {
        this.conn = conn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", conn='" + conn + '\'' +
                '}';
    }
}
