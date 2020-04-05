package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson2Quiz1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson2Quiz1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson2Quiz1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Lesson2Quiz1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson2Quiz1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson2Quiz1Fragment newInstance(String param1, String param2) {
        Lesson2Quiz1Fragment fragment = new Lesson2Quiz1Fragment();
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

        View myFragmentView = inflater.inflate(R.layout.fragment_lesson2_quiz1, container, false);
        final Button confirmbtn = (Button) myFragmentView.findViewById(R.id.buttonConfirm);
        //final Button next = myFragmentView.findViewById(R.id.nextQ);
        final CheckBox chb1 = (CheckBox) myFragmentView.findViewById(R.id.checkBox1);
        final CheckBox chb2 = (CheckBox) myFragmentView.findViewById(R.id.checkBox2);
        final CheckBox chb3 = (CheckBox) myFragmentView.findViewById(R.id.checkBox3);
        final CheckBox chb4 = (CheckBox) myFragmentView.findViewById(R.id.checkBox4);
        final CheckBox chb5 = (CheckBox) myFragmentView.findViewById(R.id.checkBox5);
        final CheckBox chb6 = (CheckBox) myFragmentView.findViewById(R.id.checkBox6);

        final TextView l2q1anstext = (TextView) myFragmentView.findViewById(R.id.l2q1ans);
        l2q1anstext.setVisibility(View.INVISIBLE);

        //next.setVisibility(View.INVISIBLE);



//        chb1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(chb1.)
//            }
//        });

        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                l2q1anstext.setVisibility(View.VISIBLE);
//                int[] checkedDocument = {0,0,0,0,0,0};
//                int[] correctChecked = {1,0,0,0,0,0};
//
//                if (chb1.isChecked()) {
//                    checkedDocument[0] = 1;
//                }
//                if(Arrays.equals(checkedDocument, correctChecked)){
//                    confirmbtn.setVisibility(View.INVISIBLE);
//                }
                if(chb1.isChecked()&&chb3.isChecked()&&chb4.isChecked()&&chb6.isChecked()){
                    l2q1anstext.setText("Correct! \n The documents required for the broker to open your brokerage account consists of \n1.ID card \n2.Bank Book \n3.House Registration \n4.Bank Statement.");
                    confirmbtn.setVisibility(View.INVISIBLE);
                    //next.setVisibility(View.VISIBLE);
                    chb1.setEnabled(false);
                    chb2.setEnabled(false);
                    chb3.setEnabled(false);
                    chb4.setEnabled(false);
                    chb5.setEnabled(false);
                    chb6.setEnabled(false);

                } else{
                    l2q1anstext.setText("Incorrect. Try again.");
                }
            }
        });

        //return inflater.inflate(R.layout.fragment_lesson2_quiz1, container, false);
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
