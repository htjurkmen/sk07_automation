package lecture09;


import java.time.LocalDate;

//Create class Person which has the following attributes: name, sex, religion, language spoken, job, nationality,
//EGN, date of birth, age, country of residence.
//The date of birth attribute and age are composed during the creation of an object based on the EGN.
//EGN consists of 10 digits. If provided value for EGN or sex are not correct throw exception.
//If wrong sex is provided program must continue its normal execution with printing relevant message.
//Only job and country of residence could change their values. All other attributes can`t be changes once they are
//set.
public class Person {
    private final String name;
    private final String religion;
    private final String nationality;
    private final String language;
    private String sex;
    private String job;
    private String dateOfBirth;
    private String country;
    private int age;
    private int EGN;

    public Person(String name, String sex, String religion, String language, String job, String nationality, String country, long egn) {
        this.name = name;
        this.religion = religion;
        this.language = language;
        this.job = job;
        this.nationality = nationality;
        this.country = country;
        setSex(sex);
        setEGN(EGN);
        setAge();
        setDateOfBirth();
    }

    private void setSex(String sex) {
        if (sex != "Male" || sex != "Female") {
            System.out.printf("Incorrect sex provided %s. Setting sex to be Male.", sex);
            sex = "Male";
        }
        this.sex = sex;
    }

    private void setAge() {
        String birthYear = "19" + Integer.toString(EGN).substring(0, 2);
        int currentYear = LocalDate.now().getYear();
        this.age = currentYear - Integer.parseInt(birthYear);
    }

    private void setDateOfBirth() {
        String date = Integer.toString(EGN).substring(4, 6);
        String month = Integer.toString(EGN).substring(2, 4);
        this.dateOfBirth = month + "-" + date;
    }

    private void setEGN(int egn) {
        String egnString = Integer.toString(egn);
        if (egnString.length() != 10) {
            throw new RuntimeException("The EGN must be exactly 10 digits!");
        }
        this.EGN = egn;
    }
}
