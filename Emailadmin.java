import java.util.Scanner;

public class Emailadmin{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength=10;
    private String alternateEmail;
    private String companySuffix = "TTScompamy.com";


    //Constructor to recieve firstname and lastname
    public Emailadmin(String firstname,String lastName){
        this.firstName = firstname;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED:" + this.firstName + " " + this.lastName);


        this.department =setDepartment();
        System.out.println("Department choosen is :" + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password is :" + this.password);

        //Combine elements to generate email
        email = firstname.toLowerCase() + lastName.toLowerCase() +"@" +
                 department +"." +companySuffix;
                 System.out.println("Email is:" +email);
                

    }
    public String setDepartment()
    {
        System.out.print("DEPARTMENT CODES\n1.For SALES \n2.FOR DEVELOPMENT \n3.FOR ACCOUNTING \n0.FOR NONE \nEnter DEPARTMENT CODE HERE  ");
        Scanner scan= new Scanner(System.in);
        int deptChoice = scan.nextInt();
        if(deptChoice == 1){
            return "SALES";}
        else if(deptChoice == 2){
            return "DEVELOPMENT";}
        else if (deptChoice == 3){
            return "ACCOUNTING";}
        else {
            return " ";
        }
    }
    private String randomPassword(int length)
    {
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
           int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);

        }
        return new String (password);
    }

    //set methods
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;

    }
    public void changePassword(String password){
        this.password = password;
    }

    //Get methods
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display name:" +firstName + " " + lastName +
               "\nCompany Email:" +email +"\nMailbox Capacity:" +mailboxCapacity + "mb";
    }
}