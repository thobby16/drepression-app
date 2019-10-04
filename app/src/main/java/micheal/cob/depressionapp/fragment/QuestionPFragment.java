package micheal.cob.depressionapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import micheal.cob.depressionapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionPFragment extends Fragment {


    public QuestionPFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4;
    int valueP;
    QuestionQFragment questionQFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        option1 = view.findViewById(R.id.option_p1);
        option2 = view.findViewById(R.id.option_p2);
        option3 = view.findViewById(R.id.option_p3);
        option4 = view.findViewById(R.id.option_p4);

        if(option1.isChecked()){
            valueP=0;
        }else if (option2.isChecked()){
            valueP=1;
        }else if (option3.isChecked()){
            valueP = 2;
        }else if (option4.isChecked()){
            valueP = 3;
        }else{
            valueP =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueO = getArguments().getInt("currentValueO");

        TextView next = view.findViewById(R.id.next_p);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionQFragment = new QuestionQFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionQFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueP = valueP+ valueO;
                bundle.putInt("currentValueP", valueP);
                questionQFragment.setArguments(bundle);
            }
        });


        return view;
    }

}
