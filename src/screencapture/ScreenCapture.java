/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screencapture;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static screencapture.login.found;

/**
 *
 * @author aa
 */
public class ScreenCapture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      boolean flag=false;
       directory();
      String  location="D:\\screenshots\\credentials\\";
        File f=new File(location);
        String[] l=f.list();
        for(String x:l)
        {
            if(x.equals("credential.coded.txt"))
            {
                found=true;
                 try {
        new mainff().setVisible(true);
     return;
     } catch (Exception ex){}
       
    }}
    if(!flag)
    {
        new login().setVisible(true);
    }}
 static   public void directory()
    {
         File f=new File("D:\\");
        File files[]=f.listFiles();
        for(File x:files)
        {
            if(x.getName().equals("screenshots"))
            {
                return;
            }
        }
        f=new File("D:\\screenshots\\credentials");
        f.mkdirs();
        f=new File("D:\\screenshots\\pdf");
        f.mkdir();
         f=new File("D:\\screenshots\\zip");
        f.mkdir();
         f=new File("D:\\screenshots\\Video");
        f.mkdir();
         f=new File("D:\\screenshots\\shots");
        f.mkdir();
    }
}
