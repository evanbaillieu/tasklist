package com.example.tasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tasklist.metier.CustomListAdapter;
import com.example.tasklist.metier.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // public List<Task> tasks;
    private DatePicker datePicker;
    private EditText editTextTitle;
    private Button buttonSubmit;
    private Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    //    this.tasks = new ArrayList<Task>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_task);

        this.datePicker = (DatePicker) this.findViewById(R.id.datePicker);
        this.editTextTitle = (EditText) this.findViewById(R.id.editTextTaskTitle);
        this.buttonSubmit = (Button) this.findViewById(R.id.button3);
        this.buttonReset = (Button) this.findViewById(R.id.button4);

        this.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDate();
            }
        });


       /* List<Task> tasks = getListDate();
        ListView listView = (ListView)findViewById(R.id.listTask);
        listView.setAdapter(new CustomListAdapter(this, tasks));

        listView.setOnItemClickListener (new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Object o = listView.getItemAtPosition(position);
                Task task = (Task) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + task.getTitle(), Toast.LENGTH_LONG).show();
            }
            });*/

    }

    public void showDate(){
        int year = this.datePicker.getYear();
        int month = this.datePicker.getMonth(); // 0 - 11
        int day = this.datePicker.getDayOfMonth();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        SimpleDateFormat formater =  new SimpleDateFormat("dd-mm-yyyy");
        String dateformat = formater.format(calendar.getTime());
        String title = this.editTextTitle.getText().toString();

        Toast.makeText(this, title + " Date: " + dateformat, Toast.LENGTH_LONG).show();
    }

    public List<Task> getListDate(){

        Task t = new Task(1, "heat", new Date());
        Task t2 = new Task(1, "heat", new Date());
        Task t3 = new Task(1, "heat", new Date());
        Task t4 = new Task(1, "heat", new Date());
        Task t5 = new Task(1, "heat", new Date());
        Task t6 = new Task(1, "heat", new Date());
        List<Task> tasks = new ArrayList<Task>();

        tasks.add(t);
        tasks.add(t2);
        tasks.add(t3);
        tasks.add(t4);
        tasks.add(t5);
        tasks.add(t6);

        return tasks;
    }
}