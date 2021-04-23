package com.cross.easygoband_test.utils;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cross.easygoband_test.R;
import com.cross.easygoband_test.TicketFragment;
import com.cross.easygoband_test.pojo.Ticket;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private List<Ticket> tickets;

    public TicketAdapter(List<Ticket> arrayList) {
        tickets = arrayList;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        Ticket object = tickets.get(position);
        String name = object.getName();
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;

        public TicketViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.list_name);
        }

        @Override
        public void onClick(View view) {
            Ticket current = tickets.get(getAdapterPosition());
            Bundle args = new Bundle();
            args.putString("name", current.getName());
            args.putString("modified", current.getModified().substring(0,9));
            args.putString("access", current.getAccess_group_name());
            args.putString("sessions", current.getSessions().get(0).getName());
            args.putString("usages", current.getTotal_uses()+"");

            Activity activity = (Activity) view.getContext();
            Fragment ticketFragment = new TicketFragment();
            ticketFragment.setArguments(args);
            activity.getFragmentManager().beginTransaction().replace(R.id.result_fragment_placeholder, ticketFragment).addToBackStack(null).commit();
        }
    }

}

