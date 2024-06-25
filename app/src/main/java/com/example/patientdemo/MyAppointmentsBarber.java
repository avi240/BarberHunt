package com.example.patientdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAppointmentsBarber extends AppCompatActivity {

    DrawerLayout drawerLayout;
    TextView nav_name;
    CircleImageView image;

    RecyclerView drCards;
    MyAppointmentsBarberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments_barber);

        drawerLayout = findViewById(R.id.drawer_layout);
        image = findViewById(R.id.nav_image);
        image.setImageResource(R.drawable.doctor_image);
        nav_name = findViewById(R.id.nav_name);
        nav_name.setText("Barber"+MainActivity.UserName);

        drCards = findViewById(R.id.appointments_recycler_doc);
        drCards();


        //Service Done

//        Button serviceButton = findViewById(R.id.service_done_button);
//        serviceButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Hide the button
//                serviceButton.setVisibility(View.GONE);
//
//                // Create an intent to start ActiveAppointments activity
//                Intent intent = new Intent(MyAppointmentsBarber.this, ActiveAppointments.class);
//                // Pass the message "Service done" as an extra
//                intent.putExtra("message", "Service done");
//                // Start ActiveAppointments activity
//                startActivity(intent);
//            }
//        });


    }

    private void drCards() {
        drCards.setHasFixedSize(true);
        drCards.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MyAppointmentsBarberModel> options =
                new FirebaseRecyclerOptions.Builder<MyAppointmentsBarberModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("barbers")
                                .child(MainActivity.UserName).child("my_app"), MyAppointmentsBarberModel.class)
                        .build();

        adapter = new MyAppointmentsBarberAdapter(options, this);
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



    public void ClickMenu(View view) {
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickUpdateProfile(View view) {
        MainActivity.redirectActivity(this, UpdateProfile.class);
    }

    public void ClickLogout(View view) {
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}