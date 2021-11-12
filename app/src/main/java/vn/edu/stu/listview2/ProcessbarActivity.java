package vn.edu.stu.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcessbarActivity extends AppCompatActivity {

    private TextView textView_info;
    private ProgressBar progressBar;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processbar);

        init();
        doStartProgressBar();
    }
    private void init(){
        textView_info= findViewById(R.id.textView_info);
        progressBar=findViewById(R.id.progressBar);
    }
    public void doStartProgressBar()  {

        this.progressBar.setIndeterminate(true);

        Thread thread = new Thread(new Runnable()  {

            @Override
            public void run() {
                // Update interface
                handler.post(new Runnable() {
                    public void run() {
                        textView_info.setText("Working...");
                    }
                });
                // Do something ... (Update database,..)
                SystemClock.sleep(3000); // Sleep 5 seconds.

                progressBar.setMax(1);
                progressBar.setProgress(1);

                // Update interface
                handler.post(new Runnable() {
                    public void run() {
                        textView_info.setText("Completed!");
                        progressBar.setIndeterminate(false);
                        finish();
                    }
                });
            }
        });
        thread.start();
    }
}