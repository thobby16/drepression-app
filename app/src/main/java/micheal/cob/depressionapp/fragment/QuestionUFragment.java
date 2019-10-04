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
public class QuestionUFragment extends Fragment {


    public QuestionUFragment() {
        // Required empty public constructor
    }
    CheckBox option1, option2, option3, option4;
    int valueU;
    ResultFragment resultFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_u, container, false);
        option1 = view.findViewById(R.id.option_u1);
        option2 = view.findViewById(R.id.option_u2);
        option3 = view.findViewById(R.id.option_u3);
        option4 = view.findViewById(R.id.option_u4);

        if(option1.isChecked()){
            valueU= 0;
        }else if (option2.isChecked()){
            valueU=1;
        }else if (option3.isChecked()){
            valueU = 2;
        }else if (option4.isChecked()){
            valueU = 3;
        }else{
            valueU =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueT = getArguments().getInt("currentValueT");

        TextView next = view.findViewById(R.id.submit);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultFragment = new ResultFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, resultFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueU = valueU+ valueT;
                bundle.putInt("currentValueU", valueU);
                resultFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
