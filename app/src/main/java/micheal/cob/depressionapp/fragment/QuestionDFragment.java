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
public class QuestionDFragment extends Fragment {


    public QuestionDFragment() {
        // Required empty public constructor
    }
    QuestionEFragment questionEFragment;
    CheckBox option1, option2, option3, option4, option5;
    private static int valueD;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_d, container, false);

        option1 = view.findViewById(R.id.option_d1);
        option2 = view.findViewById(R.id.option_d2);
        option3 = view.findViewById(R.id.option_d3);
        option4 = view.findViewById(R.id.option_d4);
        option5 = view.findViewById(R.id.option_d5);

        if(option1.isChecked()){
            valueD=0;
        }else if (option2.isChecked()){
            valueD=1;
        }else if (option3.isChecked()){
            valueD = 2;
        }else if (option4.isChecked()){
            valueD = 3;
        }else if (option5.isChecked()){
            valueD = 4;
        }else{
            valueD =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueC = getArguments().getInt("currentValueC");


        TextView next = view.findViewById(R.id.next_d);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionEFragment = new QuestionEFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionEFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueD = valueD + valueC;
                bundle.putInt("currentValueD", valueD);
                questionEFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
