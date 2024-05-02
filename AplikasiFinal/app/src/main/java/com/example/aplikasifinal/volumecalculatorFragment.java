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
 * Use the {@link volumecalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class volumecalculatorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public volumecalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment volumecalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static volumecalculatorFragment newInstance(String param1, String param2) {
        volumecalculatorFragment fragment = new volumecalculatorFragment();
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
        return inflater.inflate(R.layout.fragment_volumecalculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView volumeCuboid = view.findViewById(R.id.volumeCuboid);
        TextView volumePyramid = view.findViewById(R.id.volumePyramid);
        TextView volumeCylinder = view.findViewById(R.id.volumeCylinder);

        EditText lengthCuboid = view.findViewById(R.id.lengthCuboid);
        EditText breadthCuboid = view.findViewById(R.id.breadthCuboid);
        EditText heightCuboid = view.findViewById(R.id.heightCuboid);
        EditText basePyramid= view.findViewById(R.id.basePyramid);
        EditText heightPyramid = view.findViewById(R.id.heightPyramid);
        EditText radiusCylinder = view.findViewById(R.id.radiusCylinder);
        EditText heightCylinder = view.findViewById(R.id.heightCylinder);

        Button cuboidButton = view.findViewById(R.id.cuboidButton);
        cuboidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double l_cuboid = Double.parseDouble(lengthCuboid.getText().toString());
                double b_cuboid = Double.parseDouble(breadthCuboid.getText().toString());
                double h_cuboid = Double.parseDouble(heightCuboid.getText().toString());

                double cuboid_volume = l_cuboid * b_cuboid * h_cuboid;
                volumeCuboid.setText(String.valueOf(cuboid_volume));
            }
        });
        Button pyramidButton = view.findViewById(R.id.pyramidButton);
        pyramidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double base_pyr = Double.parseDouble(basePyramid.getText().toString());
                double h_pyr = Double.parseDouble(heightPyramid.getText().toString());

                double pyr_volume = 1 / 3 * base_pyr * h_pyr;
                volumePyramid.setText(String.valueOf(pyr_volume));
            }
        });
        Button cylinderButton = view.findViewById(R.id.cylinderButton);
        cylinderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double rad_cylinder = Double.parseDouble(radiusCylinder.getText().toString());
                double h_cylinder = Double.parseDouble(heightCylinder.getText().toString());

                double cylinder_volume = (double) 22 / 7 * rad_cylinder * rad_cylinder * h_cylinder;
                volumeCylinder.setText(String.valueOf(cylinder_volume));
            }
        });
    }
}