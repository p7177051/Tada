package lyp.bawei.com.jinri.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import lyp.bawei.com.jinri.R;

public class MainActivity extends AppCompatActivity {

    private TextView m_text;
    private Handler handler=new Handler();
    int time=3;
    Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_text = (TextView) findViewById(R.id.m_text);
        m_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,ZhuYeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(time>0){
                    m_text.setText(time+"秒后跳转");
                    time--;
                    handler.postDelayed(this,1000);
                }else {
                    if(intent==null){
                        intent=new Intent(MainActivity.this,ZhuYeActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }

            }
        },1000) ;
    }
}
