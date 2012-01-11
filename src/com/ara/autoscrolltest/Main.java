package com.ara.autoscrolltest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main extends Activity {

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            
            Button b = (Button) findViewById(R.id.addButton);
            b.setOnClickListener(new AddListener());
            
            add();
        }

        /** Add a View to the layout. */
        private void add() {
            LinearLayout l = (LinearLayout) findViewById(R.id.list);
            final HorizontalScrollView s = (HorizontalScrollView) findViewById(R.id.scroller);
            
            ImageView i = new ImageView(getApplicationContext());
            i.setImageResource(android.R.drawable.btn_star_big_on);
            l.addView(i);
            
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    s.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                }
            }, 100L);
        }

        /** Add View on button press. */
        private class AddListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                add();
            }
        }

}