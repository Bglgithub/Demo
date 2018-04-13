package com.bgl.storage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

//    @TargetApi(Build.VERSION_CODES.N)
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path ;
        File file;

//        path = getApplicationInfo().dataDir;
//        Log.d("cwq", "获取方式: getApplicationInfo().dataDir:  地址:" + path + "\n");
//
//        file = getCacheDir();
//        path = file.getPath();
//        Log.d("cwq", "获取方式: context.getCacheDir():  地址:" + path + "\n");
//
//        file = getFilesDir();
//        path = file.getPath();
//        Log.d("cwq", "获取方式: context.getFilesDir():  地址:" + path + "\n");
//
//        file = getDir("bgl", MODE_PRIVATE);
//        path = file.getPath();
//        Log.d("cwq", "获取方式: context.getDir():  地址:" + path + "\n");





//        file = getExternalCacheDir();
//        path = file.getPath();
//        Log.d("cwq", "获取方式:  context.getExternalCacheDir():  地址:" + path + "\n");
//
//        file = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        path = file.getPath();
//        Log.d("cwq", "获取方式:  context.getExternalFilesDir(PICTURES):  地址:" + path + "\n");
//
//        file = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
//        path = file.getPath();
//        Log.d("cwq", "获取方式:  context.getExternalFilesDir(MUSIC):  地址:" + path + "\n");


//        String state = Environment.getExternalStorageState();
//        Log.d("cwq", "Environment.getExternalStorageState(): " + state + "\n");

        file = Environment.getExternalStorageDirectory();
        path = file.getPath();
        Log.d("cwq", "获取方式:  Environment.getExternalStorageDirectory(): " + path + "\n");

        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        path = file.getPath();
        Log.d("cwq", "获取方式:  Environment.getExternalStoragePublicDirectory(PICTURES): " + path + "\n");

        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        path = file.getPath();
        Log.d("cwq", "获取方式:  Environment.getExternalStoragePublicDirectory(MUSIC): " + path + "\n");

//        file = Environment.getRootDirectory();
//        path = file.getPath();
//        Log.d("cwq", "Environment.getRootDirectory(): " + path + "\n");
//
//        file = Environment.getDataDirectory();
//        path = file.getPath();
//        Log.d("cwq", "Environment.getDataDirectory(): " + path + "\n");
//
//        file = Environment.getDownloadCacheDirectory();
//        path = file.getPath();
//        Log.d("cwq", "Environment.getDownloadCacheDirectory(): " + path + "\n");

//        file = Environment.getExternalStorageDirectory();
//        path = file.getPath();
//        File newfile = new File(path, "bglcwq1111");
//        try {
//            newfile.createNewFile();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
