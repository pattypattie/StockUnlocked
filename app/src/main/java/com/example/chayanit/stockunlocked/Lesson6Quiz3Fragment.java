package com.example.chayanit.stockunlocked;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson6Quiz3Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson6Quiz3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson6Quiz3Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    int randomTrend;
    ImageView uptrendImg, downtrendImg;
    Button submitbtn, buybtn, moredemandbtn, sellbtn, moresupplybtn, uptrendbtn, downtrendbtn;
    LinearLayout dropArea1, dropArea2, dropArea3;
    String clipdt;
    boolean ans1, ans2, ans3;
    TextView checkAnsText, selAns1, selAns2, selAns3, explainAnsText;

    private OnFragmentInteractionListener mListener;

    public Lesson6Quiz3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson6Quiz3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson6Quiz3Fragment newInstance(String param1, String param2) {
        Lesson6Quiz3Fragment fragment = new Lesson6Quiz3Fragment();
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

        View myFragmentView = inflater.inflate(R.layout.fragment_lesson6_quiz3, container, false);
        submitbtn = myFragmentView.findViewById(R.id.submitButton);
        buybtn = myFragmentView.findViewById(R.id.buyChoice);
        moredemandbtn = myFragmentView.findViewById(R.id.moredemandChoice);
        sellbtn = myFragmentView.findViewById(R.id.sellChoice);
        moresupplybtn = myFragmentView.findViewById(R.id.moreSupplyChoice);
        uptrendbtn = myFragmentView.findViewById(R.id.uptrendChoice);
        downtrendbtn = myFragmentView.findViewById(R.id.downtrendChoice);
        uptrendImg = myFragmentView.findViewById(R.id.upImg);
        downtrendImg = myFragmentView.findViewById(R.id.downImg);
        dropArea1 = (LinearLayout) myFragmentView.findViewById(R.id.ans_area_1);
        dropArea2 = (LinearLayout) myFragmentView.findViewById(R.id.ans_area_2);
        dropArea3 = (LinearLayout) myFragmentView.findViewById(R.id.ans_area_3);
        checkAnsText = myFragmentView.findViewById(R.id.checkAns);
        selAns1 = myFragmentView.findViewById(R.id.selectedAns1);
        selAns2 = myFragmentView.findViewById(R.id.selectedAns2);
        selAns3 = myFragmentView.findViewById(R.id.selectedAns3);
        explainAnsText = myFragmentView.findViewById(R.id.explainAns);

        moredemandbtn.setText("Demand > Supply");
        moresupplybtn.setText("Supply > Demand");

        randomTrend = (int)(Math.random()*2);

        if(randomTrend==0){
            uptrendImg.setVisibility(View.VISIBLE);
            explainAnsText.setText("During uptrend, the demand of the share is high, so the stock price will keep increasing. The circled points, which are the high points, will keep rising, thus early buying is recommended.");
        } else {
            downtrendImg.setVisibility(View.VISIBLE);
            explainAnsText.setText("During downtrend, there is an oversupply for the share, so the stock price will keep decreasing. The circled points, which are the low points, will keep falling, thus early selling is recommended.");

        }

        dropArea1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundColor(Color.rgb(146, 219, 253));
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundColor(Color.rgb(222, 243, 253    ));
                        break;
                    case DragEvent.ACTION_DROP: {
                        v.setBackgroundColor(Color.rgb(146, 219, 253));
                        clipdt = event.getClipData().getDescription().getLabel().toString();

                        selAns1.setText(clipdt);
                        if(randomTrend==0){
                            if(clipdt.equals("UPTREND")){
                                ans1 = true;
                            }else{
                                ans1 = false;
                            }
                        }else{
                            if(clipdt.equals("DOWNTREND")){
                                ans1 = true;
                            }else{
                                ans1 = false;
                            }
                        }

                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED: {
                        return (true);
                    }
                    default:
                        break;
                }
                return true;
            }
        });

        dropArea2.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundColor(Color.rgb(146, 219, 253));
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundColor(Color.rgb(222, 243, 253    ));
                        break;
                    case DragEvent.ACTION_DROP: {
                        v.setBackgroundColor(Color.rgb(146, 219, 253));
                        clipdt = event.getClipData().getDescription().getLabel().toString();

                        selAns2.setText(clipdt);
                        if(randomTrend==0){
                            if(clipdt.equals("DEMAND > SUPPLY")){
                                ans2 = true;
                            }else{
                                ans2 = false;
                            }
                        }else{
                            if(clipdt.equals("SUPPLY > DEMAND")){
                                ans2 = true;
                            }else{
                                ans2 = false;
                            }
                        }

                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED: {
                        return (true);
                    }
                    default:
                        break;
                }
                return true;
            }
        });

        dropArea3.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundColor(Color.rgb(146, 219, 253));
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundColor(Color.rgb(222, 243, 253    ));
                        break;
                    case DragEvent.ACTION_DROP: {
                        v.setBackgroundColor(Color.rgb(146, 219, 253));
                        clipdt = event.getClipData().getDescription().getLabel().toString();

                        selAns3.setText(clipdt);
                        if(randomTrend==0){
                            if(clipdt.equals("BUY")){
                                ans3 = true;
                            }else{
                                ans3 = false;
                            }
                        }else{
                            if(clipdt.equals("SELL")){
                                ans3 = true;
                            }else{
                                ans3 = false;
                            }
                        }

                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED: {
                        return (true);
                    }
                    default:
                        break;
                }
                return true;
            }
        });

        buybtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                ClipData data1 = ClipData.newPlainText("BUY", "BUY");
                View.DragShadowBuilder shadow1 = new View.DragShadowBuilder(buybtn);
                v.startDrag(data1, shadow1, null, 0);
                return false;
            }
        });

        moredemandbtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                ClipData data1 = ClipData.newPlainText("DEMAND > SUPPLY", "DEMAND > SUPPLY");
                View.DragShadowBuilder shadow1 = new View.DragShadowBuilder(moredemandbtn);
                v.startDrag(data1, shadow1, null, 0);
                return false;
            }
        });
        sellbtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                ClipData data1 = ClipData.newPlainText("SELL", "SELL");
                View.DragShadowBuilder shadow1 = new View.DragShadowBuilder(sellbtn);
                v.startDrag(data1, shadow1, null, 0);
                return false;
            }
        });

        moresupplybtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                ClipData data1 = ClipData.newPlainText("SUPPLY > DEMAND", "SUPPLY > DEMAND");
                View.DragShadowBuilder shadow1 = new View.DragShadowBuilder(moresupplybtn);
                v.startDrag(data1, shadow1, null, 0);
                return false;
            }
        });

        uptrendbtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                ClipData data1 = ClipData.newPlainText("UPTREND", "UPTREND");
                View.DragShadowBuilder shadow1 = new View.DragShadowBuilder(uptrendbtn);
                v.startDrag(data1, shadow1, null, 0);
                return false;
            }
        });

        downtrendbtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                ClipData data1 = ClipData.newPlainText("DOWNTREND", "DOWNTREND");
                View.DragShadowBuilder shadow1 = new View.DragShadowBuilder(downtrendbtn);
                v.startDrag(data1, shadow1, null, 0);
                return false;
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans1&&ans2&&ans3){
                    checkAnsText.setText("Correct!");
                    explainAnsText.setVisibility(View.VISIBLE);
                    buybtn.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    moredemandbtn.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    sellbtn.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    moresupplybtn.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    uptrendbtn.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    downtrendbtn.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    submitbtn.setEnabled(false);
                } else{
                    checkAnsText.setText("Incorrect. Please Try Again.");
                    selAns1.setText("");
                    selAns2.setText("");
                    selAns3.setText("");

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
