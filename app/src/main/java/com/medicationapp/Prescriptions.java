package com.medicationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.medicationapp.databinding.PrescriptionsBinding;

import java.util.HashMap;
import java.util.Map;

public class Prescriptions extends Fragment {
    private PrescriptionsBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = PrescriptionsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // development placeholders
        HashMap<String, String> patientToPrescription = new HashMap<>();
        patientToPrescription.put("bob", "funny mushrooms");
        patientToPrescription.put("joe", "unfunny mushrooms");


        super.onViewCreated(view, savedInstanceState);
        LinearLayout testLayout = view.findViewById(R.id.prescriptionsHolder);

        for (Map.Entry<String, String> set : patientToPrescription.entrySet()) {
            TextView text = new TextView(getContext());
            text.setTextSize(20);

            text.setText(set.getKey() + ": " + set.getValue()); // TODO: fix this so it doesnt throw a warning
            text.setOnClickListener(view13 -> NavHostFragment.findNavController(Prescriptions.this)
                    .navigate(R.id.action_perscriptions3_to_prescriptions_descriptions));
            testLayout.addView(text);
        }

        return binding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
