package com.example.xyz.colorchange;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Drawable oldBackground = null;

    private Drawable bg_a;
    private Drawable bg_b;
    LinearLayout up;
    int isWhat=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up =(LinearLayout) findViewById(R.id.up);

        up.setBackgroundResource(R.mipmap.a);

        bg_a = getResources().getDrawable(R.mipmap.a);
        bg_b =getResources().getDrawable(R.mipmap.b);

        //初始颜色

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isWhat==1)
                    aTob();
                else if(isWhat==2)
                    bToa();
            }
        });
    }



    private void aTob() {
        up.setBackgroundResource(R.mipmap.a);
        //渐变切换
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{bg_a, bg_b});
        up.setBackgroundDrawable(td);
        td.startTransition(1000);
        isWhat=2;
    }


    private void bToa() {
        up.setBackgroundResource(R.mipmap.b);
        //渐变切换
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{bg_b, bg_a});
        up.setBackgroundDrawable(td);
        td.startTransition(1000);
        isWhat=1;
    }
}
