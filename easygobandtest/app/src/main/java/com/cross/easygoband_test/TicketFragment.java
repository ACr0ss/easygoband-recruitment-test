package com.cross.easygoband_test;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class TicketFragment extends Fragment implements View.OnClickListener {

    private String name, modified, access, sessions, usages;

    public TicketFragment() {    }

    public static TicketFragment newInstance(String name, String modified, String access, String sessions, String usages) {
        TicketFragment fragment = new TicketFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("modified", modified);
        args.putString("access", access);
        args.putString("sessions", sessions);
        args.putString("usages", usages);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("name");
            modified = getArguments().getString("modified");
            access = getArguments().getString("access");
            sessions = getArguments().getString("sessions");
            usages = getArguments().getString("usages");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket, container, false);

        TextView textViewName = view.findViewById(R.id.name);
        textViewName.setText(name);
        TextView textViewModified = view.findViewById(R.id.modified);
        textViewModified.setText(modified);
        TextView textViewAccess = view.findViewById(R.id.access);
        textViewAccess.setText(access);
        TextView textViewSessions = view.findViewById(R.id.sessions);
        textViewSessions.setText(sessions);
        TextView textViewUsages = view.findViewById(R.id.usages);
        textViewUsages.setText(usages);
        FrameLayout fragmentBase = view.findViewById(R.id.fragment_base);
        fragmentBase.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getFragmentManager().popBackStack();
    }

    @Override
    public void onClick(View v) {
        closeFragment();
    }

    private void closeFragment() {
        getActivity().getFragmentManager().beginTransaction().remove(TicketFragment.this).commit();
    }


}
