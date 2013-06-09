//
//  AMImageDownloader.java
//
//
//  Created by Ruben on 08/06/13.
¡//  Copyright (c) 2013 Ruben Domínguez. All rights reserved.
//  MIT Licensed
//



package org.apache.cordova.plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;


@TargetApi(Build.VERSION_CODES.FROYO)
public class AMImageDownloader extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try{
          if (action.equals("downloadAndSaveImage")) {
            String urlString = args.getString(0);
            Bitmap image = this.downloadAndSaveImage(urlString);
            if (image != null){
              savePhoto(image);
              callbackContext.success("success");
              return true;
            }
            else{
              callbackContext.error("Expected one non-empty string argument.");
              return false;
            }
          }
          else{
            callbackContext.error("Expected one non-empty string argument.");
            return false;
          }
        }catch (Exception e) {
          e.printStackTrace();
          return false;
        }
    }

    private Bitmap downloadAndSaveImage(String urlString) {
      Bitmap bitmap = null;
        if (urlString != null && urlString.length() > 0) {
          try{
            InputStream input = new java.net.URL(urlString)
                .openStream();
            bitmap = BitmapFactory.decodeStream(input);
          }catch (Exception e){
            System.out.println("Exc="+e);
            return null;
          }
        }
      return bitmap;
    }


    private void savePhoto(Bitmap bmp){
      OutputStream fOut = null;
      Calendar c = Calendar.getInstance();
      String date = String.valueOf((c.get(Calendar.MONTH)))
        + String.valueOf((c.get(Calendar.DAY_OF_MONTH)))
        + String.valueOf((c.get(Calendar.YEAR)))
        + String.valueOf((c.get(Calendar.HOUR_OF_DAY)))
        + String.valueOf((c.get(Calendar.MINUTE)))
        + String.valueOf((c.get(Calendar.SECOND)));

      File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),date.toString() + ".png");
      try {
        fOut = new FileOutputStream(file);
        bmp.compress(Bitmap.CompressFormat.PNG, 85, fOut);
        fOut.flush();
        fOut.close();

        /**Update image to gallery**/
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(file);
        mediaScanIntent.setData(contentUri);
        this.cordova.getActivity().sendBroadcast(mediaScanIntent);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
