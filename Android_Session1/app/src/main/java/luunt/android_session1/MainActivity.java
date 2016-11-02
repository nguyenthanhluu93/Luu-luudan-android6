package luunt.android_session1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edWeight, edHeight;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edWeight = (EditText) findViewById(R.id.et_weight);
        edHeight = (EditText) findViewById(R.id.et_height);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate_bmi();
            }
        });
    }

    private void calculate_bmi() {
        double weight = Double.parseDouble(edWeight.getText().toString());
        double height = Double.parseDouble(edHeight.getText().toString()) / 100;
        double result = weight / (height * height);
        String s;
        if (result < 16) {
            s = "severely underweight";
        } else if (result > 16 && result < 18.5) {
            s = "underweight";
        } else if (result > 18.5 && result < 25){
            s = "normal";
        } else if (result > 25 && result < 30) {
            s = "overweight";
        } else {
            s = "obese";
        }
        tvResult.setText(String.format("Your BMI is %.1f, %s", result, s));
    }
}
