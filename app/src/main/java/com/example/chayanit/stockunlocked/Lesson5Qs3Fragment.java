package com.example.chayanit.stockunlocked;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson5Qs3Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson5Qs3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson5Qs3Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Lesson5Qs3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lesson5Qs3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Lesson5Qs3Fragment newInstance(String param1, String param2) {
        Lesson5Qs3Fragment fragment = new Lesson5Qs3Fragment();
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
        View myFragmentView = inflater.inflate(R.layout.fragment_lesson5_qs3, container, false);

        final EditText ans1 = myFragmentView.findViewById(R.id.Ans1);
        final EditText ans2 = myFragmentView.findViewById(R.id.Ans2);
        final EditText ans3 = myFragmentView.findViewById(R.id.Ans3);
        Button submit = myFragmentView.findViewById(R.id.submitbtn);
        final TextView result = myFragmentView.findViewById(R.id.result);

//        final String input1 = ans1.getText().toString();
//        final String input2 = ans2.getText().toString();
//        final String input3 = ans3.getText().toString();
//        input1.toLowerCase();
//        input2.toLowerCase();
//        input3.toLowerCase();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //result.setText(ans1.getText().toString());

                if (ans1.getText().toString().equals("economic")&&ans2.getText().toString().equals("industry")&&ans3.getText().toString().equals("company")){
//                if (input1.equals("economic")&&input2.equals("industry")&&input3.equals("company")){
                    result.setText("Correct!");
                } else {
                    result.setText("Try again!");
                    ans1.getText().clear();
                    ans2.getText().clear();
                    ans3.getText().clear();
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
