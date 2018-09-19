package Encryption;
//Import thư viện crypto
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class encrypt {
	//Tạo 1 phương thức mã hóa với SHA 256 với đối số truyền vào là chuỗi cần mã hóa
	public static String hashWith256(String input) {
		//Ban đầu chuỗi mã hóa là rỗng
        String encode = "";
        try {
        	//Khai báo kiểu mã hóa là SHA 256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //Mã hóa từng kí tự
            md.update(input.getBytes());

            //Tạo 1 mãng kiểu byte để lưu chuỗi sau khi băm lần thứ 1 ở kiễu dữ liệu là byte
            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            //Tạo chuỗi để để mã hóa
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
            	//Tiến hành mã hóa theo thuật toán SHA 256
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Gán kết quả đã mã hóa cho chuỗi mã hóa ban đầu
            encode = sb.toString();
            
          //Bắt trường hợp không tìm thấy thuật toán phù hợp
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //Trả về chuỗi má hóa
        return encode;
    }
	
	//3DES cho hoa don
	public static byte[] encrypt(String message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
                .getBytes("utf-8"));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        final byte[] plainTextBytes = message.getBytes("utf-8");
        final byte[] cipherText = cipher.doFinal(plainTextBytes);
        // final String encodedCipherText = new sun.misc.BASE64Encoder()
        // .encode(cipherText);

        return cipherText;
    }

    public static String decrypt(byte[] message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
                .getBytes("utf-8")); // Khóa K là: HG58YZ3CR9 ( tạo random)
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        decipher.init(Cipher.DECRYPT_MODE, key, iv);

        // final byte[] encData = new
        // sun.misc.BASE64Decoder().decodeBuffer(message);
        final byte[] plainText = decipher.doFinal(message);

        return new String(plainText, "UTF-8");
    }
}
