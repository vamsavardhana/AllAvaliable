package edu.cmu.nsompura.allavailable.exception;

/**
 * Created by nidhish on 4/15/16.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class customexception extends RuntimeException{

    String message;

    fix1to100 f1 = new fix1to100();

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return message;
    }
    public customexception(){

    }

    public customexception(String message) {
        this.message = message;
        DateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date dat = new Date();
        System.out.println(dFormat.format(dat));



    }


    public int fix(int errno) {

        switch (errno) {
            case 1:
                int a = f1.fix1(errno);
            {

                return a;
            }
        }

        return 0;
    }
}