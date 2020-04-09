package com.npappdev.chayanit.stockunlocked;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson3Quiz3Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson3Quiz3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson3Quiz3Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private Quiz1Library mQuestionLibrary = new Quiz1Library();


    public Lesson3Quiz3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson3Quiz3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson3Quiz3Fragment newInstance(String param1, String param2) {
        Lesson3Quiz3Fragment fragment = new Lesson3Quiz3Fragment();
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
        View myFragmentView = inflater.inflate(R.layout.fragment_lesson3_quiz3, container, false);
        final TextView mQuestionView = myFragmentView.findViewById(R.id.question);
        final Button mButtonChoice1 = myFragmentView.findViewById(R.id.choice1);
        final Button mButtonChoice2 = myFragmentView.findViewById(R.id.choice2);
        final TextView resultq3 = myFragmentView.findViewById(R.id.resultq3);


        final String mAnswer;
        int mQuestionNumber;
        final String mresult;
        int rand = (int)(Math.random()*3);
        mQuestionNumber = rand;
        mButtonChoice1.setText("true");
        mButtonChoice2.setText("false");

        mQuestionView.setText(mQuestionLibrary.ls3q3getQuestion(mQuestionNumber));
        mAnswer = mQuestionLibrary.ls3q3getCorrectAnswer(mQuestionNumber);
        mresult = mQuestionLibrary.ls3q3getResult(mQuestionNumber);

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  if(mButtonChoice1.getText() == mAnswer){
                                                      mButtonChoice2.setBackgroundColor(Color.GRAY);
                                                      mButtonChoice2.setEnabled(false);
                                                      mButtonChoice1.setEnabled(false);
                                                      resultq3.setText("Correct!\n"+mresult);
                                                  } else {
                                                      resultq3.setText("Incorrect Try again");
                                                  }
                                              }
                                          }


        );
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  if(mButtonChoice2.getText() == mAnswer){
                                                      mButtonChoice1.setBackgroundColor(Color.GRAY);
                                                      mButtonChoice1.setEnabled(false);
                                                      mButtonChoice2.setEnabled(false);
                                                      resultq3.setText("Correct!\n"+mresult);
                                                  } else {
                                                      resultq3.setText("Incorrect Try again");
                                                  }
                                              }
                                          }
        );



        return myFragmentView;
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
