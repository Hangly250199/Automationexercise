package TestComponents;

import java.util.Random;

public class DataGen {
    static Random random = new Random();
    public static String genPhoneNum(){
//        Random random = new Random();
        String phoneNum="0";
        for(int i=0;i<9;i++){
            int singleDigit = random.nextInt(10);
            phoneNum += singleDigit;
        }
        return phoneNum;
    }
    public static String genNationalID(){
//        Random random = new Random();
        StringBuilder nationalID= new StringBuilder();
        for(int i=0;i<12;i++){
            int singleDigit = random.nextInt(10);
            nationalID.append(singleDigit);
        }
        return nationalID.toString();
    }
    public static String genEmail(){
//        Random random =new Random();
        return "hangly" + System.currentTimeMillis() + "@gmail.com";
    }
}
