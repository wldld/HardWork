package domain;

public class User {
    private String id;
    private String username;
    private String password;
    private String realname;
    private String gender;
    private Integer age;
    private String personalSignature;
    public User(){

    }
    public User(int age,String gender, String password,String personalSignature,
                String realname,String username){
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.personalSignature = personalSignature;
        this.realname = realname;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }
}