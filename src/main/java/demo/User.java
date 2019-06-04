package demo;

/**
 * @Description:
 * @Auther: mengmei
 * @Date: 2018/12/17 0017
 */
public class User {
    private Integer id;
    private String name;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        System.out.println(Thread.currentThread().getName() + ":" + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(Thread.currentThread().getName() + ":" + name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
