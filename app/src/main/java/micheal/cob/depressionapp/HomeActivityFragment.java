package micheal.cob.depressionapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import micheal.cob.depressionapp.R;
import micheal.cob.depressionapp.fragment.InfoFragment;
import micheal.cob.depressionapp.fragment.QuestionAFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    QuestionAFragment questionAFragment;
    InfoFragment infoFragment;

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_home, container, false);
        /*ImageView imageView = view.findViewById(R.id.take_test);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionAFragment = new QuestionAFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, questionAFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_left);
                fragmentTransaction.commit();

            }
        });*/

        LinearLayout infoPage = view.findViewById(R.id.info);
        infoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoFragment = new InfoFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, infoFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
