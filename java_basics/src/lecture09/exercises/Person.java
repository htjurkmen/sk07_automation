package lecture09.exercises;


import java.time.LocalDate;

//Create class Person which has the following attributes: name, sex, religion, language spoken, job, nationality,
//EGN, date of birth, age, country of residence.
//The date of birth attribute and age are composed during the creation of an object based on the EGN.
//EGN consists of 10 digits. If provided value for EGN or sex are not correct throw exception.
//If wrong sex is provided program must continue its normal execution with printing relevant message.
//Only job and country of residence could change their values. All other attributes can`t be changes once they are
//set.
//The Person class should have methods – sayHello(), celebrateEaster(), isAdult(), canTakeLoan() with the relevant
//        parameters if any.
//        sayHello() should print Hello based on concrete person spoken language, default is in English.
//        celebrateEastershould print if the concrete person celebrates Easter based on their religion.
//        isAdultshould take in consideration the country of residence.
//        canTakeLoan is based on the job.
//        Languages – Bulgarian / Italian / English; Countries – Bulgaria (18) / Italy (18) / USA (21); Sex – Male /
//        Female
//        Religions – Orthodox / Catholic / Islam
public class Person {
    private final String name;
    private final String religion;
    private final String nationality;
    private final String language;
    private final String sex;
    private String job;
    private final String dateOfBirth;
    private String country;
    private final int age;
    private final String EGN;

    public Person(String name, String sex, String religion, String language, String job, String nationality, String country, String egn) {
        validateSex(sex);
        validateEGN(egn);
        this.name = name;
        this.sex = sex;
        this.age = calculateAge(egn);
        this.dateOfBirth = getDateOfBirth(egn);
        this.religion = religion;
        this.language = language;
        this.job = job;
        this.nationality = nationality;
        this.EGN = egn;
        this.country = country;
    }

    public void sayHello() {
        switch (this.language) {
            case "Bulgarian":
                System.out.println("Здравей!");
                break;
            case "Italian":
                System.out.println("Buongiorno!");
                break;
            default:
                System.out.println("Hello!");
        }
    }

    public void celebrateEaster() {
        Boolean celebrates = false;
        if (religion.equals("Orthodox") || religion.equals("Catholic")) {
            celebrates = true;
        }
        String celebrateString = celebrates ? "I celebrate Easter!" : "I don't celebrate Easter, my relligion is " + this.religion;
        System.out.println(celebrateString);
    }

    public boolean isAdult() {
        switch (country) {
            case "Bulgaria":
            case "Italy":
            case "UK":
                return age >= 18;
            case "USA":
                return age >= 21;
            default:
                throw new RuntimeException("No information available for country: " + country);
        }
    }

    public boolean canTakeLoan() {
        return isAdult() && job != null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Sex: ").append(sex).append("\n");
        sb.append("Nationality: ").append(nationality).append("\n");
        sb.append("Birth day: ").append(dateOfBirth).append("\n");
        sb.append("Age: ").append(age).append("\n");
        return sb.toString();
    }

    private int calculateAge(String EGN) {
        String birthYear;
        String yearDigits = EGN.substring(0, 2);
        String monthDigits = EGN.substring(2, 4);
        int monthNumber = Integer.parseInt(monthDigits);
        if (monthNumber > 40) {
            birthYear = "20" + yearDigits;
        } else if (monthNumber > 20) {
            birthYear = "18" + yearDigits;
        } else {
            birthYear = "19" + yearDigits;
        }
        int currentYear = LocalDate.now().getYear();
        return currentYear - Integer.parseInt(birthYear);
    }

    private String getDateOfBirth(String EGN) {
        String dayDigits = EGN.substring(4, 6);
        String monthDigits = EGN.substring(2, 4);
        int monthNumber = Integer.parseInt(monthDigits);
        if (monthNumber > 40) {
            monthNumber -= 40;
        } else if (monthNumber > 20) {
            monthNumber -= 20;
        }
        return monthNumber + "-" + dayDigits;
    }

    private void validateEGN(String EGN) {
        int egnLenght = EGN.length();
        if (egnLenght != 10 || !EGN.matches("[0-9]+")) {
            throw new RuntimeException("The EGN must be 10 digits!");
        }
    }

    private void validateSex(String sex) {
        String male = "Male";
        String female = "Female";
        if (sex != male && sex != female) {
            throw new RuntimeException("Invalid sex. Should be Male or Female.");
        }
    }
}
