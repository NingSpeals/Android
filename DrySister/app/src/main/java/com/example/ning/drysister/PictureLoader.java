package com.example.ning.drysister;

import android.widget.ImageView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class PictureLoader{
    private ImageView loadImg;
    private  String imgUrl;
    private byte[] picByte;
    Handler handler = new Handler() {
        @Override
        public void publish(LogRecord logRecord) {
            
        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };

}