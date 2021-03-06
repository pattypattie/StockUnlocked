package com.npappdev.chayanit.stockunlocked;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson5Qs1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson5Qs1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson5Qs1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Lesson5Qs1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson5Qs1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson5Qs1Fragment newInstance(String param1, String param2) {
        Lesson5Qs1Fragment fragment = new Lesson5Qs1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmentView = inflater.inflate(R.layout.fragment_lesson5_qs1, container, false);

        final Button choice1 = myFragmentView.findViewById(R.id.choice1);
        final Button choice2 = myFragmentView.findViewById(R.id.choice2);
        final Button choice3 = myFragmentView.findViewById(R.id.choice3);
        final TextView result = myFragmentView.findViewById(R.id.result);

        final Button next = myFragmentView.findViewById(R.id.nextQ);
        next.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), QuizResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("finalScore", 3);
                bundle.putInt("QsNum", 5);
                i.putExtras(bundle);
                getActivity().finish();
                startActivity(i);
            }
        });

        final Button spinAg = myFragmentView.findViewById(R.id.btn_spin);
        spinAg.setVisibility(View.INVISIBLE);
        spinAg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Quiz5Activity.class));
            }
        });


        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //result.setText("Incorrect! Try again");
                Toast.makeText(getActivity(), "Try again!", Toast.LENGTH_SHORT).show();

            }
        });
        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //result.setText("Incorrect! Try again");
                Toast.makeText(getActivity(), "Try again!", Toast.LENGTH_SHORT).show();
            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //choice1.setBackgroundColor(Color.RED);
                choice1.setBackgroundColor(Color.GRAY);
                choice2.setEnabled(false);
                choice1.setEnabled(false);
                choice3.setEnabled(false);
                choice2.setBackgroundColor(Color.parseColor("#66a103"));
                choice3.setBackgroundColor(Color.GRAY);
                next.setVisibility(View.VISIBLE);
                spinAg.setVisibility(View.VISIBLE);
                result.setText("Correct!"+"\nFundamental analysis is the study of the financial data and other qualitative measures of the company and the environment in which they operate to determine the value of a company.");

            }
        });


        return  myFragmentView;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
