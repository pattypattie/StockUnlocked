package com.npappdev.chayanit.stockunlocked;

import android.content.ClipData;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson2Quiz2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson2Quiz2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson2Quiz2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    LinearLayout dropArea1, dropArea2, dropArea3;
    TextView sol;
    ImageView dragCashAcc, dragCashBal, dragCreditBal, cashAccArea1, cashBalArea1, creditBalArea1, cashAccArea2, cashBalArea2, creditBalArea2, cashAccArea3, cashBalArea3, creditBalArea3;
    String clipdt;
    boolean ans1, ans2, ans3;
    Button submitButton;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Lesson2Quiz2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson2Quiz2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson2Quiz2Fragment newInstance(String param1, String param2) {
        Lesson2Quiz2Fragment fragment = new Lesson2Quiz2Fragment();
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

        View myFragmentView = inflater.inflate(R.layout.fragment_lesson2_quiz2, container, false);

        final Button next = myFragmentView.findViewById(R.id.nextQ);
        dropArea1 = (LinearLayout) myFragmentView.findViewById(R.id.drop_area_1);
        dropArea2 = (LinearLayout) myFragmentView.findViewById(R.id.drop_area_2);
        dropArea3 = (LinearLayout) myFragmentView.findViewById(R.id.drop_area_3);
        submitButton = (Button) myFragmentView.findViewById(R.id.submitbtn);
        sol = (TextView) myFragmentView.findViewById(R.id.textView77);
        dragCashAcc = (ImageView) myFragmentView.findViewById(R.id.cashAcc);
        dragCashBal = (ImageView) myFragmentView.findViewById(R.id.cashBal);
        dragCreditBal = (ImageView) myFragmentView.findViewById(R.id.creditBal);
        cashAccArea1 = (ImageView) myFragmentView.findViewById(R.id.cashAccOnArea1);
        cashBalArea1 = (ImageView) myFragmentView.findViewById(R.id.cashBalOnArea1);
        creditBalArea1 = (ImageView) myFragmentView.findViewById(R.id.creditBalOnArea1);
        cashAccArea2 = (ImageView) myFragmentView.findViewById(R.id.cashAccOnArea2);
        cashBalArea2 = (ImageView) myFragmentView.findViewById(R.id.cashBalOnArea2);
        creditBalArea2 = (ImageView) myFragmentView.findViewById(R.id.creditBalOnArea2);
        cashAccArea3 = (ImageView) myFragmentView.findViewById(R.id.cashAccOnArea3);
        cashBalArea3 = (ImageView) myFragmentView.findViewById(R.id.cashBalOnArea3);
        creditBalArea3 = (ImageView) myFragmentView.findViewById(R.id.creditBalOnArea3);

        next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity()
                            .getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentl2, new Lesson2Quiz1Fragment());
                    fragmentTransaction.commit();
            }
        });

        dropArea1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundColor(Color.rgb(214, 137, 16));
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundColor(Color.rgb(248, 196, 113    ));
                        break;
                    case DragEvent.ACTION_DROP: {
                        v.setBackgroundColor(Color.rgb(214, 137, 16));
                        clipdt = event.getClipData().getDescription().getLabel().toString();
                        cashAccArea1.setVisibility(View.INVISIBLE);
                        cashBalArea1.setVisibility(View.INVISIBLE);
                        creditBalArea1.setVisibility(View.INVISIBLE);
                        if(clipdt.equals("a1")){
                            ans1 = true;
                            cashAccArea1.setVisibility(View.VISIBLE);
                        }else{
                            ans1 = false;
                            if(clipdt.equals("a2")){
                                cashBalArea1.setVisibility(View.VISIBLE);
                            } else if(clipdt.equals("a3")){
                                creditBalArea1.setVisibility(View.VISIBLE);
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
                        v.setBackgroundColor(Color.rgb(214, 137, 16));
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundColor(Color.rgb(248, 196, 113    ));
                        break;
                    case DragEvent.ACTION_DROP: {
                        v.setBackgroundColor(Color.rgb(214, 137, 16));
                        clipdt = event.getClipData().getDescription().getLabel().toString();
                        cashAccArea2.setVisibility(View.INVISIBLE);
                        cashBalArea2.setVisibility(View.INVISIBLE);
                        creditBalArea2.setVisibility(View.INVISIBLE);
                        if(clipdt.equals("a2")){
                            ans2 = true;
                            cashBalArea2.setVisibility(View.VISIBLE);
                        }else{
                            ans2 = false;
                            if(clipdt.equals("a1")){
                                cashAccArea2.setVisibility(View.VISIBLE);
                            }else if(clipdt.equals("a3")){
                                creditBalArea2.setVisibility(View.VISIBLE);
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
                        v.setBackgroundColor(Color.rgb(214, 137, 16));
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundColor(Color.rgb(248, 196, 113    ));
                        break;
                    case DragEvent.ACTION_DROP: {
                        v.setBackgroundColor(Color.rgb(214, 137, 16));
                        clipdt = event.getClipData().getDescription().getLabel().toString();
                        cashAccArea3.setVisibility(View.INVISIBLE);
                        cashBalArea3.setVisibility(View.INVISIBLE);
                        creditBalArea3.setVisibility(View.INVISIBLE);
                        if(clipdt.equals("a3")){
                            ans3 = true;
                            creditBalArea3.setVisibility(View.VISIBLE);
                        }else{
                            ans3 = false;
                            if(clipdt.equals("a2")){
                                cashBalArea3.setVisibility(View.VISIBLE);
                            }else if(clipdt.equals("a1")){
                                cashAccArea3.setVisibility(View.VISIBLE);
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

        dragCashAcc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
// TODO Auto-generated method stub
                ClipData data1 = ClipData.newPlainText("a1", "acc1");
                View.DragShadowBuilder shadow1 = new View.DragShadowBuilder(dragCashAcc);
                v.startDrag(data1, shadow1, null, 0);
                return false;
            }
        });


        dragCashBal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v2, MotionEvent arg2) {
                ClipData data2 = ClipData.newPlainText("a2", "acc2");
                View.DragShadowBuilder shadow2 = new View.DragShadowBuilder(dragCashBal);
                v2.startDrag(data2, shadow2, null, 0);
                return false;
            }
        });

        dragCreditBal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v3, MotionEvent arg3) {
                ClipData data3 = ClipData.newPlainText("a3", "acc3");
                View.DragShadowBuilder shadow3 = new View.DragShadowBuilder(dragCreditBal);
                v3.startDrag(data3, shadow3, null, 0);
                return false;
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans1&&ans2&&ans3){
                    sol.setText("Correct!");
                    dragCashAcc.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    dragCashBal.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    dragCreditBal.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    submitButton.setEnabled(false);
                   next.setVisibility(View.VISIBLE);
                } else{
                    //sol.setText("Incorrect. Please Try Again.");
                    Toast.makeText(getActivity(), "Try again!", Toast.LENGTH_SHORT).show();
                    cashAccArea1.setVisibility(View.GONE);
                    cashAccArea2.setVisibility(View.GONE);
                    cashAccArea3.setVisibility(View.GONE);
                    creditBalArea1.setVisibility(View.GONE);
                    creditBalArea2.setVisibility(View.GONE);
                    creditBalArea3.setVisibility(View.GONE);
                    cashBalArea1.setVisibility(View.GONE);
                    cashBalArea2.setVisibility(View.GONE);
                    cashBalArea3.setVisibility(View.GONE);
//                    FragmentTransaction fragmentTransaction = getActivity()
//                            .getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.fragmentl2, new Lesson2Quiz1Fragment());
//                    fragmentTransaction.commit();

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
