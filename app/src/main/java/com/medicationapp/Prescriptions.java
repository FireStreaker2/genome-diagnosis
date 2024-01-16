package com.medicationapp;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.medicationapp.databinding.PrescriptionsBinding;

import java.util.HashMap;
import java.util.Map;

public class Prescriptions extends Fragment {
    private PrescriptionsBinding binding;
    private static final int REQUEST_CAMERA_PERMISSION_CODE = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    Button takePhoto;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = PrescriptionsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        view.findViewById(R.id.take_photo).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                captureImage(v);
            }
        });
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
    public void captureImage(View view){
        if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_PERMISSION_CODE);
            return;
        }

        // open the camera app
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
