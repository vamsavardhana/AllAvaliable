package edu.cmu.nsompura.allavailable.exception;

/**
 * Created by nidhish on 4/15/16.
 */
import android.app.Activity;
import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;





public class fix1to100 extends Activity{
    File path = Environment.getExternalStorageDirectory();
    File file = new File(path, "/" + "Log.txt");

    public Formatter x;
    public FileWriter f;

    fix1to100() {
        try {
            f = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        x = new Formatter(f);



    }

    public int fix1(int errno){




        DateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date dat = new Date();




        x.format("Error No:%d, Empty username and Empty password,Date & Time:%s\n", errno, dFormat.format(dat).toString());

       // System.out.println("Error No: " + Integer.toString(errno) + ": Wallpaper can't be set,Date & Time:" + dFormat.format(dat).toString());
        int a=1;
        x.close();



        return a;




    }


}