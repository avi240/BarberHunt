package com.example.patientdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BarberList extends AppCompatActivity {

    DrawerLayout drawerLayout;
    TextView nav_name;
    public static String UserName;

    RecyclerView drCards;
    BarberListAdapter adapter;
    public String specialist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_list);

        drawerLayout = findViewById(R.id.drawer_layout);
        UserName = getIntent().getStringExtra("UserName");
        nav_name = findViewById(R.id.nav_name);
        nav_name.setText(UserName);

        Bundle extras = getIntent().getExtras();
        specialist = extras.getString("title");

        drCards = findViewById(R.id.drCards);
        drCards();
    }

    private void drCards() {
        drCards.setHasFixedSize(true);
        drCards.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<BarberListModel> options =
                new FirebaseRecyclerOptions.Builder<BarberListModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("specialists").child(specialist), BarberListModel.class)
                        .build();

        adapter = new BarberListAdapter(options, this);
        drCards.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    // ---------------------------- NAVIGATION BAR ---------------------------- //
    public void ClickMenu(View view) {
        CustomerDashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        CustomerDashboard.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        CustomerDashboard.redirectActivity(this, CustomerDashboard.class);
    }

    public void ClickUpdateProfile(View view) {
        CustomerDashboard.redirectActivity(this, UpdateProfileCustomer.class);
    }

    public void ClickLogout(View view) {
        CustomerDashboard.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CustomerDashboard.closeDrawer(drawerLayout);
    }
    // ----------------------------------------------------------------------- //
}