package luunt.observertest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    EditText edtMess;
    Button btnOk;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        edtMess = (EditText) view.findViewById(R.id.edt_mss);
        btnOk = (Button) view.findViewById(R.id.btnTest);
        addListener();
        return view;
    }

    private void addListener() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxBus.getInstance().send("aaaaaaaaaaa");


                ((MainActivity) getActivity()).getMyData().setMessage(edtMess.getText().toString());
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fr_container, new SecondFragment())
                        .addToBackStack("")
                        .commit();
            }
        });
    }
}
