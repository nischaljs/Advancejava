import java.util.*;

class Person{
    private String name, address;
    private int age;
    void setAll(String name, String address, int age){
        this.name = name;
        this.address=address;
        this.age= age;
    }
    String getName(){
        return name;
    }
    String getAddress(){
        return address;
    }
    int getAge(){
        return age;
    }
}

class Student extends Person {
    private int rollNo;
    void setRoll(int rollNo){
        this.rollNo=rollNo;
    }
    int getRollNo(){
        return rollNo;
    }
}


public class MyStudent {
    public static void main(String[] args) {
        Student  p = new Student();
        p.setAll("Nischal", "Jhumka", 20);
        if(p.getAge()>18){
            p.setRoll(12);
        }
        System.out.println(p.getName(),p.getAddress(),p.getAge(),p.getRollNo());
    }
}
