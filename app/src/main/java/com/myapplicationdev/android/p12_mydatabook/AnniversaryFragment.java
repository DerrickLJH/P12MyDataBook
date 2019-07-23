package com.myapplicationdev.android.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnniversaryFragment extends Fragment {
    public static final String USER_PREF = "USER_PREF";
    SharedPreferences sp;
    Button btnEdit;
    TextView tvData;
    public AnniversaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.anniversaryfragment, container, false);
        btnEdit = v.findViewById(R.id.btnEdit);
        tvData = v.findViewById(R.id.tvData);
        sp = getActivity().getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        return v;
    }

    public void openDialog(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        View mView = getLayoutInflater().inflate(R.layout.dialog_edit, null);
        final EditText etInput = mView.findViewById(R.id.etInput);
        etInput.setText(tvData.getText().toString());
        mBuilder.setTitle("Edit Anniversary").setView(mView).setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String text = etInput.getText().toString();
                        tvData.setText(text);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("anni_data", tvData.getText().toString());
        editor.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        String data = sp.getString("anni_data","Default Text");
        tvData.setText(data);
    }
}
