package edu.cmu.nsompura.allavailable.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import edu.cmu.nsompura.allavailable.R;

/**
 * Created by anna on 4/4/16.
 */
public class sendpicture extends Activity {
    Button ret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_sendpicture);

        //Set location of where image file is saved


        Button btn1=(Button)findViewById(R.id.clickapicture);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(Environment.getExternalStorageDirectory() + "/photo1.jpeg");
                Log.i("Line1",Environment.getExternalStorageDirectory().getAbsolutePath() + "/photo1.jpeg" );
                Uri outputFileUri = Uri.fromFile(file);

                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
                startActivityForResult(intent, 1);
                            }
        });



    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Garbage collector used to free memory advised to not use it on stackoverflow
        //    System.gc();
//        File file = new File(Environment.getExternalStorageDirectory() + "/photo1.jpeg");
//        Log.i("Line1",Environment.getExternalStorageDirectory().getAbsolutePath() + "/photo1.jpeg" );
        Uri uri = Uri.parse("file://"+Environment.getExternalStorageDirectory()+"/photo1.jpeg");
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra("address","9294229976");
        i.putExtra("sms_body","This is the text mms");
        i.putExtra(Intent.EXTRA_STREAM,uri);
        i.setType("image/png");
        startActivity(i);


        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    // Call function MakeFolder to create folder structure if
                    // its not created

                    //to make imagebitmap not initialized error go away
                    Bitmap imageBitmap = null;
                    if (imageBitmap != null) {
                        imageBitmap = null;
                        imageBitmap.recycle();
                    }

                    //Make folder doesn't need to exist as I am storing in the SD card directly
                    //MakeFolder();


                    // Get file from temp1 file where image has been stored
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 3;
                    imageBitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/photo1.jpg", options);

////                    boolean isImageTaken = true;
////                    // Name for image
////                    IMAGEPATH = getString(R.string.chassisImage)
////                            + System.currentTimeMillis();
////                    SaveImageFile(imageBitmap,IMAGEPATH);
                } catch (Exception e) {
                    Toast.makeText(this, "Picture Not taken",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }
    }}
