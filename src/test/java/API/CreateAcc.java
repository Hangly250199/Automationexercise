package API;

import TestComponents.DataGen;
import TestComponents.UserRegisterInfor;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CreateAcc {
    /**
     * Gọi API tạo tài khoản tự động và trả về email ngẫu nhiên vừa tạo.
     *
     * @return String email (Nếu thành công) hoặc null (Nếu thất bại)
     */
    public static String createNewAccount(UserRegisterInfor userRegisterInfor) {
        String randomEmail = DataGen.genEmail();
        try {
            URL url = new URL("https://automationexercise.com/api/createAccount");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Cấu hình các tham số gửi đi theo mẫu curl của bạn
            String urlParameters = String.format("name=%s&email=%s&password=%s&title=%s&birth_date=%s&birth_month=%s&birth_year=%s"
                    + "&firstname=%s&lastname=%s&company=%s&address1=%s&address2=%s&country=%s"
                    + "&zipcode=%s&state=%s&city=%s&mobile_number=%s",
                    userRegisterInfor.getFullName(),
                    randomEmail,
                    userRegisterInfor.getPassword(),
                    userRegisterInfor.getGenderTitle().replace(".",""),
                    userRegisterInfor.getDayOfBirth(),
                    userRegisterInfor.getMonthOfBirth(),
                    userRegisterInfor.getYearOfBirth(),
                    userRegisterInfor.getFirstName(),
                    userRegisterInfor.getLastName(),
                    userRegisterInfor.getCompany(),
                    userRegisterInfor.getAddress1(),
                    userRegisterInfor.getAddress2(),
                    userRegisterInfor.getCountry(),
                    userRegisterInfor.getZipcode(),
                    userRegisterInfor.getState(),
                    userRegisterInfor.getCity(),
                    userRegisterInfor.getMobileNumber()
                    );
//                    "name=Nguyen Test"
//                    + "&email=" + randomEmail
//                    + "&password=123456"
//                    + "&title=Mrs"
//                    + "&birth_date=01"
//                    + "&birth_month=01"
//                    + "&birth_year=1995"
//                    + "&firstname=Nguyen"
//                    + "&lastname=Hang"
//                    + "&company=Company ABC"
//                    + "&address1=123 Street A"
//                    + "&address2=District 1"
//                    + "&country=India"
//                    + "&zipcode=100000"
//                    + "&state=Hanoi"
//                    + "&city=Hanoi"
//                    + "&mobile_number=0901234567";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = urlParameters.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200 || responseCode == 201) {
                System.out.println("======> API SETUP: Tạo tài khoản thành công! Email: " + randomEmail);
                return randomEmail;
            } else {
                System.out.println("======> API SETUP: Thất bại. Mã lỗi từ Server: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("======> API SETUP: Gặp lỗi kết nối hệ thống.");
            e.printStackTrace();
        }
        return null;
    }
}

