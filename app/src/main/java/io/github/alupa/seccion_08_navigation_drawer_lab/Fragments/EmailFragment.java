package io.github.alupa.seccion_08_navigation_drawer_lab.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import io.github.alupa.seccion_08_navigation_drawer_lab.R;

public class EmailFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {

    private TextView textViewTitle;
    private FloatingActionButton fab;

    private AlertDialog.Builder builder;
    private EditText editTextMail;

    public EmailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);

        return view;
    }

    @Override
    public void onClick(View v) {
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("E-MAIL");
        builder.setMessage("Type your e-mail address to be displayed in the middle of the screen");

        // Set up the input
        editTextMail = new EditText(getContext());
        editTextMail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        builder.setView(editTextMail);

        // Set up the buttons
        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("Cancel", this);
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE){
            String email = editTextMail.getText().toString();
            if (!email.isEmpty()) textViewTitle.setText(email);
        } else if (which == DialogInterface.BUTTON_NEGATIVE){
            dialog.cancel();
        }
    }
}
