package dms;

/**
 * Created by hjhuang on 2017/6/19.
 */
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import jcifs.util.Hexdump;
import jcifs.util.MD4;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;

public class CryptGenerator
{
    private static UnixCrypt cs = new UnixCrypt();

    public static String generateSecerete(String password)
    {
        return generateSecereteWithCrypt(password);
    }

    public static String generateSecereteWithSmbencrypt(String password)
    {
        return hashNTPassword(password);
    }

    public static String generateSecereteWithCrypt(String password)
    {
        return UnixCrypt.crypt(password);
    }

    public static boolean passWithCrypt(String key, String password)
    {
        if ((key == null) || (password == null))
            return false;
        String newSeceret = UnixCrypt.crypt(password, key);

        return newSeceret.equals(key);
    }

    public static boolean pass(String key, String password) {
        return passWithSmbencrypt(key, password);
    }

    public static boolean passWithSmbencrypt(String key, String password)
    {
        if ((key == null) || (password == null))
            return false;
        String newSeceret = hashNTPassword(password);

        return newSeceret.equals(key);
    }

    static String hashNTPassword(String password) {
        MD4 md4 = new MD4();
        try
        {
            byte[] bpass = password.getBytes("UnicodeLittleUnmarked");

            md4.engineUpdate(bpass, 0, bpass.length);
            byte[] hashbytes = md4.engineDigest();
            return Hexdump.toHexString(hashbytes, 0, hashbytes.length * 2);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(generateSecereteWithSmbencrypt("kddms@tethrnet.com"));
        System.out.println(pass("F770E698D43818F9A412EA38908C1F6E", "12345678qaz"));
    }

    @Test
    public void test() {
        System.out.println(hashNTPassword("123456a"));
        System.out.println(pass("69CBE3ACBC48A3A289E8CDB000C2B7A8", "123456a"));
    }
}