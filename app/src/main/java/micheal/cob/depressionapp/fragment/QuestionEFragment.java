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
public class QuestionEFragment extends Fragment {


    public QuestionEFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4, option5;
    private static int valueE;
    QuestionFFragment questionFFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_e, container, false);

        option1 = view.findViewById(R.id.option_e1);
        option2 = view.findViewById(R.id.option_e2);
        option3 = view.findViewById(R.id.option_e3);
        option4 = view.findViewById(R.id.option_e4);
        option5 = view.findViewById(R.id.option_e5);

        if(option1.isChecked()){
            valueE=0;
        }else if (option2.isChecked()){
            valueE=1;
        }else if (option3.isChecked()){
            valueE = 2;
        }else if (option4.isChecked()){
            valueE = 3;
        }else if (option5.isChecked()){
            valueE = 4;
        }else{
            valueE =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueD = getArguments().getInt("currentValueD");


        TextView next = view.findViewById(R.id.next_e);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionFFragment = new QuestionFFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionFFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueE = valueE + valueD;
                bundle.putInt("currentValueE", valueE);
                questionFFragment.setArguments(bundle);
            }
        });


        return view;
    }

}
