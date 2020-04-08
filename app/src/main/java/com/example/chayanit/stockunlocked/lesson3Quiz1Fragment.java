package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link lesson3Quiz1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link lesson3Quiz1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class lesson3Quiz1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    int numClick = 0;

    String img_pre;
    Button bt_pre;
    TextView tv_pre;

    private Quiz1Library mQuestionLibrary = new Quiz1Library();
    Integer[] arr = new Integer[mQuestionLibrary.ls3q1.length];


    public lesson3Quiz1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lesson3Quiz1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static lesson3Quiz1Fragment newInstance(String param1, String param2) {
        lesson3Quiz1Fragment fragment = new lesson3Quiz1Fragment();
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
    public void checkCount(String img, Button bt, TextView tv){
            if(numClick == 1){
                img_pre = img;
                bt_pre = bt;
                tv_pre = tv;


            } else if (numClick == 2) {
                if((img_pre=="bull"&&img=="bear")||(img_pre=="bear"&&img=="bull")||(img_pre=="lamp"&&img=="wood")||(img_pre=="wood"&&img=="lamp")
                        ||(img_pre=="sell"&&img=="stock")||(img_pre=="stock"&&img=="sell")
                        ){
                    Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
                    bt_pre.setVisibility(View.GONE);
                    bt.setVisibility(View.GONE);
                    tv_pre.setVisibility(View.GONE);
                    tv.setVisibility(View.GONE);
                    numClick = 0;
                } else {
                    int image_resid = getResources().getIdentifier(img, "drawable", getActivity().getPackageName());
                    bt.setBackgroundResource(image_resid);
                    int imgpre = getResources().getIdentifier(img_pre,"drawable",getActivity().getPackageName());
                    bt_pre.setBackgroundResource(imgpre);
                    numClick = 0;
                    Toast.makeText(getActivity(), "Try Again", Toast.LENGTH_SHORT).show();
                }

            }
    }

//    public static void buttonEffect(View button){
//        button.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN: {
//                        v.getBackground().setColorFilter(0xe0f47521,PorterDuff.Mode.SRC_ATOP);
//                        v.invalidate();
//                        break;
//                    }
//                    case MotionEvent.ACTION_UP: {
//                        v.getBackground().clearColorFilter();
//                        v.invalidate();
//                        break;
//                    }
//                }
//                return false;
//            }
//        });
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmentView = inflater.inflate(R.layout.fragment_lesson3_quiz1, container, false);


        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));

        final Button button1 = myFragmentView.findViewById(R.id.button1);
        final Button button2 = myFragmentView.findViewById(R.id.button2);
        final Button button3 = myFragmentView.findViewById(R.id.button4);

        final Button button4 = myFragmentView.findViewById(R.id.button5);
        final Button button5 = myFragmentView.findViewById(R.id.button7);
        final Button button6 = myFragmentView.findViewById(R.id.button8);

        final TextView bt1 = myFragmentView.findViewById(R.id.bt1);
        final TextView bt2 = myFragmentView.findViewById(R.id.bt2);
        final TextView bt3 = myFragmentView.findViewById(R.id.bt3);
        final TextView bt4 = myFragmentView.findViewById(R.id.bt4);
        final TextView bt5 = myFragmentView.findViewById(R.id.bt5);
        final TextView bt6 = myFragmentView.findViewById(R.id.bt6);


        final String img = mQuestionLibrary.ls3q1[arr[0]];

        int image_resid = getResources().getIdentifier(img, "drawable", getActivity().getPackageName());
        button1.setBackgroundResource(image_resid);
        setText(img,bt1);

      final  String img2 = mQuestionLibrary.ls3q1[arr[1]];
       int image_resid2 = getResources().getIdentifier(img2, "drawable", getActivity().getPackageName());
        button2.setBackgroundResource(image_resid2);
        setText(img2,bt2);

        final String img3 = mQuestionLibrary.ls3q1[arr[2]];
        int image_resid3 = getResources().getIdentifier(img3, "drawable", getActivity().getPackageName());
        button3.setBackgroundResource(image_resid3);
        setText(img3,bt3);

        final String img4 = mQuestionLibrary.ls3q1[arr[3]];
        int image_resid4 = getResources().getIdentifier(img4, "drawable", getActivity().getPackageName());
        button4.setBackgroundResource(image_resid4);
        setText(img4,bt4);

        final String img5 = mQuestionLibrary.ls3q1[arr[4]];
        int image_resid5 = getResources().getIdentifier(img5, "drawable", getActivity().getPackageName());
        button5.setBackgroundResource(image_resid5);
        setText(img5,bt5);

        final String img6 = mQuestionLibrary.ls3q1[arr[5]];
        int image_resid6 = getResources().getIdentifier(img6, "drawable", getActivity().getPackageName());
        button6.setBackgroundResource(image_resid6);
        setText(img6,bt6);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                button1.setBackgroundColor(Color.GREEN);
//                button1.setBackgroundResource(image_resid);
//                buttonEffect(button1);
                String imgbg = img+"_withbg";
                int imagebg = getResources().getIdentifier(imgbg, "drawable", getActivity().getPackageName());
                button1.setBackgroundResource(imagebg);
                numClick++;
                checkCount(img,button1,bt1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imgbg2 = img2+"_withbg";
                int imagebg2 = getResources().getIdentifier(imgbg2, "drawable", getActivity().getPackageName());
                button2.setBackgroundResource(imagebg2);
                numClick++;
                checkCount(img2,button2,bt2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imgbg3 = img3+"_withbg";
                int imagebg3 = getResources().getIdentifier(imgbg3, "drawable", getActivity().getPackageName());
                button3.setBackgroundResource(imagebg3);
                numClick++;
                checkCount(img3,button3,bt3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imgbg4 = img4+"_withbg";
                int imagebg4 = getResources().getIdentifier(imgbg4, "drawable", getActivity().getPackageName());
                button4.setBackgroundResource(imagebg4);
                numClick++;
                checkCount(img4,button4,bt4);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imgbg5 = img5+"_withbg";
                int imagebg5 = getResources().getIdentifier(imgbg5, "drawable", getActivity().getPackageName());
                button5.setBackgroundResource(imagebg5);
                numClick++;
                checkCount(img5,button5,bt5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imgbg6 = img6+"_withbg";
                int imagebg6 = getResources().getIdentifier(imgbg6, "drawable", getActivity().getPackageName());
                button6.setBackgroundResource(imagebg6);
                numClick++;
                checkCount(img6,button6,bt6);
            }
        });


        return myFragmentView;


//        View myFragmentView = inflater.inflate(R.layout.fragment_lesson3_quiz1, container, false);
//        final TextView hi = myFragmentView.findViewById(R.id.hello);


        //return myFragmentView;
    }
    public void setText(String text, TextView bt){
        switch (text){
            case "bull" : bt.setText("Bull Market"); break;
            case "bear" : bt.setText("Bear Market");break;
            case "lamp" : bt.setText("Ceiling");break;
            case "wood" : bt.setText("Floor");break;
            case "sell" : bt.setText("Offer");break;
            case "stock" : bt.setText("Bid");break;
            default: bt.setText("testtttt");
        }

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
