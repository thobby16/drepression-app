package micheal.cob.depressionapp.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import micheal.cob.depressionapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CausesFragment extends Fragment {


    public CausesFragment() {
        // Required empty public constructor
    }
    TextView causesTV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_causes, container, false);
        causesTV= view.findViewById(R.id.depression_causes);
        causesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = causesTV.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return view;
    }

}
