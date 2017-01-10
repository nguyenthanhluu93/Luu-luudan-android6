package luunt.demoobserver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class ObjectObserverPattern extends Activity implements Observer,
		OnClickListener {
	BaseApp myBase;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		myBase = (BaseApp) getApplication();
		myBase.getObserver().addObserver(this);
		// myBase.getObserver().setValue(10);

		btn = (Button) findViewById(R.id.button1);
		btn.setText("value: " + myBase.getObserver().getValue());
		btn.setOnClickListener(this);

	}

	@Override
	public void update(Observable observable, Object data) {
		// This method is notified after data changes.
		Toast.makeText(this, "I am notified" + myBase.getObserver().getValue(), Toast.LENGTH_SHORT).show();
		btn.setText("value: " + myBase.getObserver().getValue());

	}

	@Override
	public void onClick(View v) {
		startActivity(new Intent(ObjectObserverPattern.this,
				SecondActivity.class));

	}
}
