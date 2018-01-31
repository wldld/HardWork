package domain;

public class User {
    private int  id;
    private String username;
    private String password;
    private String realname;
    private String gender;
    private Integer age;
    private String personalsignature;
    public User(){

    }
    public User(int age,String gender, String password,String personalSignature,
                String realname,String username){
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.personalsignature = personalSignature;
        this.realname = realname;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPersonalSignature() {
        return personalsignature;
    }

    public void setPersonalSignature(String personalsignature) {
        this.personalsignature = personalsignature;
    }
}
