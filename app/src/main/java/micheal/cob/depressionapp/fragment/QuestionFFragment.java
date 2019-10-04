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
public class QuestionFFragment extends Fragment {


    public QuestionFFragment() {
        // Required empty public constructor
    }

    public CheckBox option1, option2, option3, option4, option5;
    public static int valueF;
    QuestionGFragment questionGFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_f, container, false);
        option1 = view.findViewById(R.id.option_f1);
        option2 = view.findViewById(R.id.option_f2);
        option3 = view.findViewById(R.id.option_f3);
        option4 = view.findViewById(R.id.option_f4);
        option5 = view.findViewById(R.id.option_f5);

        if(option1.isChecked()){
            valueF=0;
        }else if (option2.isChecked()){
            valueF=1;
        }else if (option3.isChecked()){
            valueF = 2;
        }else if (option4.isChecked()){
            valueF = 3;
        }else if (option5.isChecked()){
            valueF = 4;
        }else{
            valueF =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueE = getArguments().getInt("currentValueE");

        TextView next = view.findViewById(R.id.next_f);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionGFragment = new QuestionGFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionGFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueF = valueF + valueE;
                bundle.putInt("currentValueF", valueF);
                questionGFragment.setArguments(bundle);
            }
        });

        return view;
    }

}
