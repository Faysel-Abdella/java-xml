package com.example.carwash.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.carwash.Frame220;
import com.example.carwash.PaymentScreen;
import com.example.carwash.R;

public class FragmentFrame245 extends Fragment {

    private CardView cardbox1, cardbox2, cardbox3, cardbox4, cardbox5, cardbox6, cardbox7, cardbox8, cardbox9, cardbox10;
    private TextView box1, box2, box3, box4, box5, box6, box7, box8, box9, box10;

    public FragmentFrame245() {
        // Required empty public constructor
    }

    public static FragmentFrame245 newInstance(String param1, String param2) {
        FragmentFrame245 fragment = new FragmentFrame245();
        Bundle args = new Bundle();
        args.putString("ARG_PARAM1", param1);
        args.putString("ARG_PARAM2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Handle parameters if needed
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frame245, container, false);

        // Initialize CardViews
        cardbox1 = view.findViewById(R.id.cardbox_1);
        cardbox2 = view.findViewById(R.id.cardbox_2);
        cardbox3 = view.findViewById(R.id.cardbox_3);
        cardbox4 = view.findViewById(R.id.cardbox_4);
        cardbox5 = view.findViewById(R.id.cardbox_5);
        cardbox6 = view.findViewById(R.id.cardbox_6);
        cardbox7 = view.findViewById(R.id.cardbox_7);
        cardbox8 = view.findViewById(R.id.cardbox_8);
        cardbox9 = view.findViewById(R.id.cardbox_9);
        cardbox10 = view.findViewById(R.id.cardbox_10);

        // Initialize TextViews
        box1 = view.findViewById(R.id.box_1);
        box2 = view.findViewById(R.id.box_2);
        box3 = view.findViewById(R.id.box_3);
        box4 = view.findViewById(R.id.box_4);
        box5 = view.findViewById(R.id.box_5);
        box6 = view.findViewById(R.id.box_6);
        box7 = view.findViewById(R.id.box_7);
        box8 = view.findViewById(R.id.box_8);
        box9 = view.findViewById(R.id.box_9);
        box10 = view.findViewById(R.id.box_10);

        // Set click listeners
        setCardClickListener(cardbox1, box1, "01", R.id.real1);
        setCardClickListener(cardbox2, box2, "02", R.id.real2);
        setCardClickListener(cardbox3, box3, "03", R.id.real3);
        setCardClickListener(cardbox4, box4, "04", R.id.real4);
        setCardClickListener(cardbox5, box5, "05", R.id.real5);
        setCardClickListener(cardbox6, box6, "06", R.id.real6);
        setCardClickListener(cardbox7, box7, "07", R.id.real7);
        setCardClickListener(cardbox8, box8, "08", R.id.real8);
        setCardClickListener(cardbox9, box9, "09", R.id.real9);
        setCardClickListener(cardbox10, box10, "10", R.id.real10);

        return view;
    }

    private void setCardClickListener(CardView cardView, TextView textView, String value, int relativeLayoutId) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Find the RelativeLayout inside the CardView
                RelativeLayout relativeLayout = cardView.findViewById(relativeLayoutId);
                if (relativeLayout != null) {
                    // Change the background color of the RelativeLayout
                    relativeLayout.setBackgroundColor(Color.parseColor("#F2F0FF"));


                }

                // Update the corresponding textview with the value
                textView.setText(value);

                // Disable the card after click to prevent multiple selections
                cardView.setEnabled(false);
            }
        });
    }
}