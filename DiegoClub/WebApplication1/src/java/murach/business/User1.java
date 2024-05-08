package murach.business;

import java.io.Serializable;

public class User1 implements Serializable {

    private String fullName;
    private String email;
    private String phone;
    private String program;
    private String yearLevel;

    public User1() {
        fullName = "";
        email = "";
        phone = "";
        program = "";
        yearLevel = "";
    }

    public User1(String fullName,String email,String phone,
            String program,String yearLevel) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.program = program;
        this.yearLevel = yearLevel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getProgram(){
       return program;
    }
    
    public void setProgram(String program){
        this.program = program;
    }
    
    public String getyearLevel(){
        return yearLevel;
    }
    
    public void setyearLevel(String yearLevel){
        this.yearLevel = yearLevel;
    }
}
