package com.choosemuse.example.libmuse;

import android.os.AsyncTask;
import android.util.Log;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by smart on 9/18/2016.
 */
public class NetworkGuy extends AsyncTask<String, Void, String> {
    Socket s;
    PrintWriter out;
    @Override
    protected String doInBackground(String... params){
        try {
            s = new Socket("192.168.42.1", 8080);
            out = new PrintWriter(s.getOutputStream(), true);
        }catch (Exception e) {
            Log.d("InitialMyla", e.getMessage());
        }
        try {
            out.println(params[0]);
            out.close();
            s.close();
        }catch(Exception e){
            Log.d("HI", e.getMessage());
        }
        return "Exec";
    }
}
