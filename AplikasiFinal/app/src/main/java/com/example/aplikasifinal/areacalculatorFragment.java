package com.example.aplikasifinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link areacalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class areacalculatorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public areacalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment areacalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static areacalculatorFragment newInstance(String param1, String param2) {
        areacalculatorFragment fragment = new areacalculatorFragment();
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
        return inflater.inflate(R.layout.fragment_areacalculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView squareArea = view.findViewById(R.id.areaSquare);
        TextView triangleArea = view.findViewById(R.id.areaTriangle);
        TextView circleArea = view.findViewById(R.id.areaCircle);

        EditText sideSquare = view.findViewById(R.id.sideSquare);
        EditText baseTriangle = view.findViewById(R.id.baseTriangle);
        EditText heightTriangle = view.findViewById(R.id.heightTriangle);
        EditText radiusCircle = view.findViewById(R.id.radiusCircle);

        Button squareButton = view.findViewById(R.id.squareButton);
        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double side = Double.parseDouble(sideSquare.getText().toString());

                double square_area = side * side;
                squareArea.setText(String.valueOf(square_area));
            }
        });
        Button triangleButton = view.findViewById(R.id.triangleButton);
        triangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double triheight = Double.parseDouble(heightTriangle.getText().toString());
                double tribase = Double.parseDouble(baseTriangle.getText().toString());

                double triangle_area = 0.5 * tribase * triheight;
                triangleArea.setText(String.valueOf(triangle_area));
            }
        });
        Button circleButton = view.findViewById(R.id.circleButton);
        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double radius = Double.parseDouble(radiusCircle.getText().toString());
                double circle_area = (double) 22/7*radius*radius;
                circleArea.setText(String.valueOf(circle_area));
            }
        });
    }
}