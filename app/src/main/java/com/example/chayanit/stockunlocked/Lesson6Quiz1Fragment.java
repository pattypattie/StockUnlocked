package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson6Quiz1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson6Quiz1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson6Quiz1Fragment extends Fragment {

    TextView result, candleName;
    ImageView bullPic, bullAns, bearPic, bearAns;
    int randomCandle;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Lesson6Quiz1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson6Quiz1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson6Quiz1Fragment newInstance(String param1, String param2) {
        Lesson6Quiz1Fragment fragment = new Lesson6Quiz1Fragment();
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

        View myFragmentView = inflater.inflate(R.layout.fragment_lesson6_quiz1, container, false);

        final Button openHint = myFragmentView.findViewById(R.id.hintbtn);
        final TextView hintText = myFragmentView.findViewById(R.id.textView34);
        final Button submitbtn = myFragmentView.findViewById(R.id.button5);
        final EditText text1 = myFragmentView.findViewById(R.id.editText);
        final EditText text2 = myFragmentView.findViewById(R.id.editText2);
        final EditText text3 = myFragmentView.findViewById(R.id.editText3);
        final EditText text4 = myFragmentView.findViewById(R.id.editText4);
        result  = myFragmentView.findViewById(R.id.textView42);
        candleName = myFragmentView.findViewById(R.id.textView35);
        bullPic = myFragmentView.findViewById(R.id.imageView33);
        bearPic = myFragmentView.findViewById(R.id.imageView69);
        bullAns = myFragmentView.findViewById(R.id.imageView67);
        bearAns = myFragmentView.findViewById(R.id.imageView68);

        randomCandle = (int)(Math.random()*2);

        if(randomCandle==0){
            candleName.setText("Bullish Candlestick");
            bullPic.setVisibility(View.VISIBLE);
        } else {
            candleName.setText("Bearish Candlestick");
            bearPic.setVisibility(View.VISIBLE);
        }

        openHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHint.setVisibility(View.INVISIBLE);
                hintText.setVisibility(View.VISIBLE);
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text1.getText().toString().equals("")||text2.getText().toString().equals("")||text3.getText().toString().equals("")||text4.getText().toString().equals("")){
                    result.setText("Please fill in all the blanks");
                }else{
                    if((randomCandle==0&&text1.getText().toString().equalsIgnoreCase("close")&&text2.getText().toString().equalsIgnoreCase("low")&&text3.getText().toString().equalsIgnoreCase("high")&&text4.getText().toString().equalsIgnoreCase("open"))||(randomCandle==1&&text1.getText().toString().equalsIgnoreCase("open")&&text2.getText().toString().equalsIgnoreCase("low")&&text3.getText().toString().equalsIgnoreCase("high")&&text4.getText().toString().equalsIgnoreCase("close"))){
                        result.setText("Correct!");
                    } else{
                        result.setText("Incorrect. The correct answer is given below.");
                        if(randomCandle==0){
                            bullAns.setVisibility(View.VISIBLE);
                        } else{
                            bearAns.setVisibility(View.VISIBLE);
                        }
                    }
                    text1.setEnabled(false);
                    text2.setEnabled(false);
                    text3.setEnabled(false);
                    text4.setEnabled(false);
                    openHint.setEnabled(false);
                }

            }
        });

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
