package com.example.chayanit.stockunlocked;

import android.content.Context;
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
 * {@link lesson3Quiz2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link lesson3Quiz2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class lesson3Quiz2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";





    private Quiz1Library mQuestionLibrary = new Quiz1Library();






    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public lesson3Quiz2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lesson3Quiz2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static lesson3Quiz2Fragment newInstance(String param1, String param2) {
        lesson3Quiz2Fragment fragment = new lesson3Quiz2Fragment();
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
        View myFragmentView = inflater.inflate(R.layout.fragment_lesson3_quiz2, container, false);
        final TextView mQuestionView = myFragmentView.findViewById(R.id.question);
        final Button mButtonChoice1 = myFragmentView.findViewById(R.id.choice1);
        final Button mButtonChoice2 = myFragmentView.findViewById(R.id.choice2);
        final Button mButtonChoice3 = myFragmentView.findViewById(R.id.choice3);
        final TextView result = myFragmentView.findViewById(R.id.result);


        final String mAnswer;
        int mQuestionNumber;
        int rand = (int)(Math.random()*3);
        mQuestionNumber = rand;

        mQuestionView.setText(mQuestionLibrary.ls3q2getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.ls3q2choices[0][0]);
        mButtonChoice2.setText(mQuestionLibrary.ls3q2choices[0][1]);
        mButtonChoice3.setText(mQuestionLibrary.ls3q2choices[0][2]);
        mAnswer = mQuestionLibrary.ls3q2getCorrectAnswer(mQuestionNumber);

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  if(mButtonChoice1.getText() == mAnswer){
                                                      result.setText("Correct!");
                                                  } else {
                                                      result.setText("Incorrect Try again");
                                                  }
                                              }
                                          }


        );
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice2.getText() == mAnswer){
                    result.setText("Correct!");
                } else {
                    result.setText("Incorrect Try again");
                }
            }
        }
        );
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  if(mButtonChoice3.getText() == mAnswer){
                                                      result.setText("Correct!");
                                                  } else {
                                                      result.setText("Incorrect Try again");
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
