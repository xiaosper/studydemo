package thread.demo;



import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yumingxiao1
 * @Date 2020/1/7
 * @since 1.0.0
 */
public class Test {

        public static void main(String[] args) throws Exception {

            MessageDigest digest  = MessageDigest.getInstance("SHA-1");
            byte digestBytes[] = digest.digest("JdEdicm231".getBytes(StandardCharsets.UTF_8)); // SHA-1 ( password )
            String passwdDigest = Base64.encode(digestBytes); // Base64 ( SHA-1 ( password ) )

//		String passWord="JdEdicm231"; m4ZH%2ByS8rhFflbCvUmAVGkO52lU%3D
           /* String passWord="gateway_test";
            MessageDigest digest  = MessageDigest.getInstance("SHA-1");
            byte digestBytes[] = digest.digest(passWord.getBytes(StandardCharsets.UTF_8)); // SHA-1 ( password )
            String passwdDigest = Base64.encode(digestBytes); //Base64 ( SHA-1 ( password ) )*/
            System.out.println(URLEncoder.encode(passwdDigest, "UTF-8"));
        }
    }

