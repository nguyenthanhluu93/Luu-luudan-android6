package luunt.observertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class SecondActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void update(Observable observable, Object o) {
        Toast.makeText(this, "Message board changed: " + o, Toast.LENGTH_SHORT).show();
    }
}
