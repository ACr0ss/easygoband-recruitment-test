package com.cross.easygoband_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cross.easygoband_test.pojo.Ticket;
import com.cross.easygoband_test.utils.TicketAdapter;

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private List<Ticket> tickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        tickets = (List<Ticket>) extras.getSerializable("data");

        setView();
    }

    private void setView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ticket_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TicketAdapter adapter = new TicketAdapter(tickets);
        recyclerView.setAdapter(adapter);
    }
}