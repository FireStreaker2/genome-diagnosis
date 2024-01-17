package com.medicationapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.medicationapp.databinding.HomeBinding;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    private HomeBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = HomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // graph located on the home screen
        LineChart lineChart = root.findViewById(R.id.graph);

        // example placeholder data
        // in the future we can just pull the data from
        // the place we store it
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 10));
        entries.add(new Entry(2, 3));
        entries.add(new Entry(3, 5));
        entries.add(new Entry(4, 9));
        entries.add(new Entry(5, 8));
        entries.add(new Entry(6, 1));

        LineDataSet dataSet = new LineDataSet(entries, "Medicine Taken");
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.RED);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);

        Description description = new Description();
        description.setText("Medicine Taken Over Days");
        lineChart.setDescription(description);

        lineChart.getAxisRight().setEnabled(false);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}