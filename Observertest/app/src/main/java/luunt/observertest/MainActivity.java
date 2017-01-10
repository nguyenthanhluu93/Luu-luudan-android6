package luunt.observertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Observer {

    Button btnOnClick;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOnClick = (Button) findViewById(R.id.btn_onClick);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        MyData myData = new MyData();
        myData.addObserver(this);
        myData.changeMessage("data changed");
        btnOnClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    @Override
    public void update(Observable observable, Object o) {
        Toast.makeText(this, "Message board changed: " + ((MyData)o).getMessage(), Toast.LENGTH_SHORT).show();
        tvMessage.setText(((MyData)o).getMessage());
    }
}
