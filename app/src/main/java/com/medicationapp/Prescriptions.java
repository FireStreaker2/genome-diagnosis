package com.medicationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.medicationapp.databinding.PerscriptionsBinding;

import java.util.HashMap;
import java.util.Map;

public class Prescriptions extends Fragment {
    private PerscriptionsBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = PerscriptionsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        HashMap<String,String> patientToPrescription = new HashMap<String, String>();
        patientToPrescription.put("bob","funny mushrooms");
        patientToPrescription.put("joe","unfunny mushrooms");
        super.onViewCreated(view, savedInstanceState);
        LinearLayout testLayout = (LinearLayout) view.findViewById(R.id.prescriptionsHolder);

        for (Map.Entry<String, String> set :
                patientToPrescription.entrySet()) {
            TextView text = new TextView(getContext());
            text.setTextSize(20);
            text.setText(set.getKey()+": "+set.getValue());
            testLayout.addView(text);

        }
        return binding.getRoot();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}
