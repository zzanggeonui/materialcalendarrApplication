package com.example.sibalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.sibalapplication.CalendarDecor.BoldDecor;
import com.example.sibalapplication.CalendarDecor.CustomDecorator;
import com.example.sibalapplication.CalendarDecor.SatDecor;
import com.example.sibalapplication.CalendarDecor.SundayDecor;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Date selectedDate;

    MaterialCalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Context context = this;
        calendarView = findViewById(R.id.calendarview);



        //일자 커스텀
        CustomDecorator customDecorator = new CustomDecorator(this);
        calendarView.addDecorator(customDecorator);

        //일요일 색칠
        SundayDecor sundayDecor = new SundayDecor(this);
        calendarView.addDecorator(sundayDecor);

        //토요일 색칠
        SatDecor satDecor = new SatDecor(this);
        calendarView.addDecorator(satDecor);

        //평일 진하게
        BoldDecor boldDecor = new BoldDecor(this);
        calendarView.addDecorator(boldDecor);


        // 연/월
        calendarView.setTitleFormatter(new TitleFormatter() {
            @Override
            public CharSequence format(CalendarDay day) {
                // 선택한 날짜의 월과 연도를 포맷팅하여 반환
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM", Locale.getDefault());
                return sdf.format(day.getDate());
            }
        });





        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {






                selectedDate = date.getDate();



//                Intent intent = new Intent(MainActivity.this, SelectedExerciseActivity.class);
//                intent.putExtra("selected_date", selectedDate);
//                startActivity(intent);
            }
        });

    }
}