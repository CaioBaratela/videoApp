package com.example.caioferrari.videoapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.example.caioferrari.videoapp.R;
import com.example.caioferrari.videoapp.view.fragment.CameraFragment;
import com.example.caioferrari.videoapp.view.fragment.PreviewFragment;

public class CameraActivity extends AppCompatActivity implements CameraFragment.OnFragmentInteractionListener,
                                                                 PreviewFragment.OnFragmentInteractionListener{

    private float x1;
    private float x2;
    private float y1;
    private float y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, CameraFragment.newInstance())
                    .commit();
        }
    }

    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                this.x1 = touchEvent.getX();
                this.y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                this.x2 = touchEvent.getX();
                this.y2 = touchEvent.getY();
                if(x1 > x2){
                    final Intent feedIntent = new Intent(CameraActivity.this,FeedActivity.class);
                    startActivity(feedIntent);
                }
                break;
        }
        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
