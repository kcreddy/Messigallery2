package com.example.messigallery;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.ByteArrayOutputStream;


public class Frame extends ActionBarActivity {

    //the images to display fg
    Integer[] frameIDs = {
            R.drawable.frame1,
            R.drawable.frame2,
            R.drawable.frame3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        // Note that Gallery view is deprecated in Android 4.1---
        Gallery gallery2 = (Gallery) findViewById(R.id.gallery2);
        gallery2.setAdapter(new Frame.ImageAdapter(this));
        gallery2.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position,long id)
            {
                Toast.makeText(getBaseContext(), "frame" + (position + 1) + " selected",
                        Toast.LENGTH_LONG).show();
                // display the images selected
                ImageView imageView = (ImageView) findViewById(R.id.image2);
                imageView.setImageResource(frameIDs[position]);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;
            // sets a grey background; wraps around the images
            TypedArray a =obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }
        // returns the number of images
        public int getCount() {
            return frameIDs.length;
        }
        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }
        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }
        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(frameIDs[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(250, 250));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }

    public void merge(View view)
    {

        Intent intent2 = new Intent(this, Merge.class);

        startActivity(intent2);
    }
}
