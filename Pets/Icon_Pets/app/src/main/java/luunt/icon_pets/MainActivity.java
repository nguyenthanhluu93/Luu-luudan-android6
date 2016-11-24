package luunt.icon_pets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    CustomButton btnReg;
    CircleImageView imgAva;
    private String url = "https://avatars.githubusercontent.com/u/1?v=3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReg = (CustomButton) findViewById(R.id.btn_reg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        imgAva = (CircleImageView) findViewById(R.id.img_ava);
        Picasso.with(this).load(url).into(imgAva);
    }
}
