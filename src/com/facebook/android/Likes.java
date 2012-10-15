package com.facebook.android;

import android.content.Context;
import java.io.*;

public class Likes {
    
    public String getLikes(Context ctx) throws Exception {
        InputStream is = ctx.getResources().openRawResource(R.raw.likes);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        
        String jsonString = writer.toString();
        
        return jsonString;
    }
}