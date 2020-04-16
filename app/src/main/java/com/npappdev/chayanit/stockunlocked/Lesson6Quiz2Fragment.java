package com.npappdev.chayanit.stockunlocked;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson6Quiz2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson6Quiz2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson6Quiz2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Lesson6Quiz2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson6Quiz2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson6Quiz2Fragment newInstance(String param1, String param2) {
        Lesson6Quiz2Fragment fragment = new Lesson6Quiz2Fragment();
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

        final View myFragmentView = inflater.inflate(R.layout.fragment_lesson6_quiz2, container, false);

        final TextView ansText = myFragmentView.findViewById(R.id.textView43);
        final TextView ansExplain = myFragmentView.findViewById(R.id.textView44);
        final Button submitBtn = myFragmentView.findViewById(R.id.submitl6q2);
        final ImageView ansImg = myFragmentView.findViewById(R.id.imageView69);
        final RadioButton buybtn = myFragmentView.findViewById(R.id.buy);
        final RadioButton sellbtn = myFragmentView.findViewById(R.id.sell);
        final RadioGroup buysellgroup = myFragmentView.findViewById(R.id.buysell);
        final Button next = myFragmentView.findViewById(R.id.nextQ);
        next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentl6, new Lesson6Quiz3Fragment());
                fragmentTransaction.commit();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sellbtn.isChecked()) {
                    ansText.setText("Correct!");
                    ansText.setVisibility(View.VISIBLE);
                    ansImg.setVisibility(View.VISIBLE);
                    ansExplain.setVisibility(View.VISIBLE);

                    String texttext = "&emsp In the question, the chart is rising to the resistance level. Normally, a resistance level prevents the price from going higher, but it is still possible for the graph to break through. However, " +
                            "it is shown in the graph that the price is dropping a little once it hits the resistance level. This indicates that the price tends to respect the resistance level and is likely to continue falling below the level to remain " +
                            "within the same support and resistance area. Thus, <b>SELLING</b> at this point " +
                            "is the best solution to get a high price for the stock. The graph below reveals what happens later.";
                    ansExplain.setText(Html.fromHtml(texttext));

                    submitBtn.setEnabled(false);
                    buysellgroup.setEnabled(false);
                    buybtn.setEnabled(false);
                    sellbtn.setEnabled(false);
                    next.setVisibility(View.VISIBLE);
                }else{
                    //ansText.setText("Incorrect.");
                    Toast.makeText(getActivity(), "Try again!", Toast.LENGTH_SHORT).show();
                }
//                ansText.setVisibility(View.VISIBLE);
//                ansImg.setVisibility(View.VISIBLE);
//                ansExplain.setVisibility(View.VISIBLE);
//
//                String texttext = "&emsp In the question, the chart is rising to the resistance level. Normally, a resistance level prevents the price from going higher, but it is still possible for the graph to break through. However, " +
//                        "it is shown in the graph that the price is dropping a little once it hits the resistance level. This indicates that the price tends to respect the resistance level and is likely to continue falling below the level to remain " +
//                        "within the same support and resistance area. Thus, <b>SELLING</b> at this point " +
//                        "is the best solution to get a high price for the stock. The graph below reveals what happens later.";
//                ansExplain.setText(Html.fromHtml(texttext));
//
//                submitBtn.setEnabled(false);
//                buysellgroup.setEnabled(false);
//                buybtn.setEnabled(false);
//                sellbtn.setEnabled(false);

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
