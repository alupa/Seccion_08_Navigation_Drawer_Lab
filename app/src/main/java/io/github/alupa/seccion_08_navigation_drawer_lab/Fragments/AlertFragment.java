package io.github.alupa.seccion_08_navigation_drawer_lab.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import io.github.alupa.seccion_08_navigation_drawer_lab.R;

public class AlertFragment extends Fragment implements View.OnClickListener, AlertDialog.OnClickListener {

    private FloatingActionButton fab;
    private TextView textViewTitle;

    private AlertDialog.Builder builder;
    private Switch aSwitch;

    public AlertFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alert, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);

        return view;
    }

    @Override
    public void onClick(View v) {
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("E-MAIL");
        builder.setMessage("Type your email address to be displayed in the middle of the screen");

        // Get your layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_fragment_alert, null);

        aSwitch = (Switch) dialogView.findViewById(R.id.switchDialog);

        builder.setView(dialogView);

        //Set up the buttons
        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("Cancel", this);
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE){
            if (aSwitch.isChecked()) textViewTitle.setText("Alerts enabled"); else textViewTitle.setText("Alerts disabled");
        } else if (which == DialogInterface.BUTTON_NEGATIVE){
            dialog.cancel();
        }
    }
}
