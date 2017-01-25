package luunt.observertest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import rx.Subscriber;
import rx.Subscription;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements Observer {
    private static final String TAG = "log11";
    TextView tvMess;
    private Subscription sub;

    public static SecondFragment newInstance() {
        Bundle args = new Bundle();

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sub = RxBus.getInstance().subscribe(null, new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(Object o) {
                Log.d(TAG, "onNext: " + o);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sub.unsubscribe();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ((MainActivity) getActivity()).getMyData().addObserver(this);
        tvMess = (TextView) view.findViewById(R.id.tvText);
        return view;
    }

    @Override
    public void update(Observable observable, Object data) {
        Log.e("luunt", data.toString());
        tvMess.setText(data.toString());
    }
}
