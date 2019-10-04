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
public class QuestionKFragment extends Fragment {


    public QuestionKFragment() {
        // Required empty public constructor
    }

    CheckBox option1, option2, option3, option4;
    int valueK;

    QuestionLFragment questionLFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_k, container, false);
        option1 = view.findViewById(R.id.option_k1);
        option2 = view.findViewById(R.id.option_k2);
        option3 = view.findViewById(R.id.option_k3);
        option4 = view.findViewById(R.id.option_k4);


        if(option1.isChecked()){
            valueK=0;
        }else if (option2.isChecked()){
            valueK=1;
        }else if (option3.isChecked()){
            valueK = 2;
        }else if (option4.isChecked()){
            valueK = 3;
        }else{
            valueK =0;
            Toast.makeText(getContext(), "First option is selected by default", Toast.LENGTH_SHORT).show();
        }

        final int valueJ = getArguments().getInt("currentValueJ");

        TextView next = view.findViewById(R.id.next_k);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionLFragment = new QuestionLFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, questionLFragment);
                fragmentTransaction.commit();
                Bundle bundle = new Bundle();
                valueK = valueK+ valueJ;
                bundle.putInt("currentValueK", valueK);
                questionLFragment.setArguments(bundle);
            }
        });
        return view;
    }

}
