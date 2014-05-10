package Utils;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import org.omg.PortableServer.Current;

import javax.xml.ws.spi.http.HttpContext;
import java.io.*;

/**
 * Created by Sergio on 28.04.14.
 */
public class Adapter {
    public static String combine(String path1, String path2){
        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();
    }
}
