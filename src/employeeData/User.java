package employeeData;

public class User {
    private String name;
    private String companyname;
    private int yearOfjoining;
    private String email;
    private String password;

    public User(String name, String companyname, int yearOfjoining) {
        this.name = name;
        this.companyname = companyname;
        this.yearOfjoining = yearOfjoining;
        this.email = createUseremail();
        this.password = createUserpassword();
    }


    private String createUserpassword() {
        StringBuilder sb = new StringBuilder();
        sb.append(generateRandomCharacter());
        for (int i = 0; i < 4; i++) {
            sb.append(generateRandomIntegerFromLimit(10));
        }
        sb.append(getFirst5charactersFromUserName());
        sb.append(generateRandomSpecialSymbol());
        return sb.toString();
    }

    private String createUseremail() {
        return String.format("%s_%d@%s.com", getName().toLowerCase(), getYearOfjoining(), getCompanyname().toLowerCase());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public int getYearOfjoining() {
        return yearOfjoining;
    }

    public void setYearOfjoining(int yearOfjoining) {
        this.yearOfjoining = yearOfjoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String getFirst5charactersFromUserName() {
        if (getName().length() < 5) {
            int difference = 5 - getName().length();
            StringBuilder tempName = new StringBuilder(getName());
            for (int i = 0; i < difference; i++) {
                tempName.append("0");
            }
            return tempName.toString();
        } else {
            return getName().substring(0, 5);
        }
    }

    private char generateRandomSpecialSymbol() {
        char[] specialSymbols =
                {
                        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}', '[', ']', '|', '\\',
                        ';', ':', '\'', '\"', '<', '>', ',', '.', '?', '/'
                };
        int randomInteger = generateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomInteger];
    }

    private char generateRandomCharacter() {
        int randomNumberUpto26 = generateRandomIntegerFromLimit(26);
        return (char) ('a' + randomNumberUpto26);
    }

    public int generateRandomIntegerFromLimit(int limit) {
        return (int) (Math.random() * limit);
    }
}

class UserEntry {
    public static void main(String[] args) {
        User obj = new User("Priyanshu", "Google", 2022);
        System.out.println(obj.getEmail());
        System.out.println(obj.getPassword());
    }
}
