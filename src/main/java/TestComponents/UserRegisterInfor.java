package TestComponents;

public class UserRegisterInfor {
    private String genderTitle;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;
    public UserRegisterInfor(){
        this.genderTitle = "Mrs.";
        this.password=DefaultValue.defaultPassword;
        this.dayOfBirth="25";
        this.monthOfBirth="January";
        this.yearOfBirth="1999";
        this.firstName=DefaultValue.defaulFirstName;
        this.lastName=DefaultValue.defaulLastName;
        this.company=DefaultValue.defaultCompany;
        this.address1=DefaultValue.defaultAddress1;
        this.address2=DefaultValue.defaultAddress2;
        this.country="Canada";
        this.state=DefaultValue.defaultState;
        this.city=DefaultValue.defaultCity;
        this.zipcode=DefaultValue.defaultZip;
        this.mobileNumber=DataGen.genPhoneNum();
    }
    public String getGenderTitle() {
        return genderTitle;
    }
    public String getPassword(){
        return password;
    }
    public String getDayOfBirth(){
        return dayOfBirth;
    }
    public String getMonthOfBirth(){
        return monthOfBirth;
    }
    public String getYearOfBirth(){
        return yearOfBirth;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getCompany(){
        return company;
    }
    public String getAddress1(){
        return address1;
    }
    public String getAddress2(){
        return address2;
    }
    public String getCountry(){
        return country;
    }
    public String getState(){
        return state;
    }
    public String getZipcode(){
        return zipcode;
    }
    public String getCity(){
        return city;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public String getFullNameTitle(){
        return genderTitle+" "+firstName+" "+lastName;
    }
    public String getFullName(){
        return firstName+" "+lastName;
    }
    public String getCityStateZip(){
        return city+" "+state+" "+zipcode;
    }
}
