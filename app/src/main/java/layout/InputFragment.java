package layout;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.brent.androidfragmentsample.R;

public class InputFragment extends Fragment {

    private static final String TAG = "InputFragment";
    private EditText editText;

    InputFragmentListener mListener;
    public InputFragment() {
        Log.d(TAG, "Constructor called");
        // Required empty public constructor
    }

    public static InputFragment newInstance() {
        Log.d(TAG, "newInstance()");
        return new InputFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        Button button = (Button) view.findViewById(R.id.submitButton);
        editText = (EditText) view.findViewById(R.id.submitEditText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onUpdateText(editText.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "onAttachView()");
        super.onAttach(activity);
        if (activity instanceof InputFragmentListener) {
            mListener = (InputFragmentListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach()");
        super.onDetach();
        mListener = null;
    }
}
