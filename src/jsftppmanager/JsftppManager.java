/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsftppmanager;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 *
 * @author gcr
 */
public class JsftppManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet("http://sftppmanager/audit/checkparamjson/3/6");

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());

                // Get hold of the response entity
                HttpEntity entity = response.getEntity();

                // If the response does not enclose an entity, there is no need
                // to bother about connection release
                if (entity != null) {
                    System.out.println(EntityUtils.toString(entity));
/*
                    InputStream instream = entity.getContent();
                    try {
                        instream.read();
                        // do something useful with the response
                    } catch (IOException ex) {
                        // In case of an IOException the connection will be released
                        // back to the connection manager automatically
                        throw ex;
                    } finally {
                        // Closing the input stream will trigger connection release
                        instream.close();
                    }
                    */ 
                }
                else
                {
                    System.out.println("error ?");                
                }
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
