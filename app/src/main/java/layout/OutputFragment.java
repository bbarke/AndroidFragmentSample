package layout;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.brent.androidfragmentsample.R;

public class OutputFragment extends Fragment {
    private static final String TAG = "OutputFragment";
    private TextView textView;

    public OutputFragment() {
        Log.d(TAG, "constructor called");
        // Required empty public constructor
    }

    public static OutputFragment newInstance() {
        Log.d(TAG, "newInstance()");
        return new OutputFragment();
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
        View view = inflater.inflate(R.layout.fragment_output, container, false);
        textView = (TextView) view.findViewById(R.id.outputText);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "onAttachView()");
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach()");
        super.onDetach();
    }

    public void setOutputText(String outputText) {
        textView.setText(outputText);
    }
}
