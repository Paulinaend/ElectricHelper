package ru.synergy.chooseyourtechnic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.ref.WeakReference;

import ru.synergy.chooseyourtechnic.notedb.NoteDatabase;
import ru.synergy.chooseyourtechnic.notedb.model.Note;

public class AddNoteActivity extends AppCompatActivity {

    private TextInputEditText et_power, et_voltage, et_phase, et_cosFi;
    private NoteDatabase noteDatabase;
    private Note note;
    private boolean update;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        et_power = findViewById(R.id.PowerSet);
        et_voltage = findViewById(R.id.VoltageSet);
        et_phase = findViewById(R.id.PhaseSet);
        et_cosFi = findViewById(R.id.CosFiSet);
        noteDatabase = NoteDatabase.getInstance(AddNoteActivity.this);
        Button button = findViewById(R.id.but_save);
        if ((note = (Note) getIntent().getSerializableExtra("note")) != null) {
            getSupportActionBar().setTitle("Update Note");
            update = true;
            button.setText("Update");
            et_power.setText(note.getPower());
            et_voltage.setText(note.getVoltage());
            et_phase.setText(note.getPhase());
            et_cosFi.setText(note.getCosFi());
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (update) {
                    note.setPower(et_power.getText().toString());
                    note.setVoltage(et_voltage.getText().toString());
                    note.setPhase(et_phase.getText().toString());
                    note.setCosFi(et_cosFi.getText().toString());
                    noteDatabase.getNoteDao().updateNote(note);
                    setResult(note, 2);
                } else {
                    note = new Note(et_power.getText().toString(), et_voltage.getText().toString(), et_phase.getText().toString(), et_cosFi.getText().toString());
                    new InsertTask(AddNoteActivity.this, note).execute();
                }
            }
        });
    }

    private void setResult(Note note, int flag) {
        setResult(flag, new Intent().putExtra("note", note));
        finish();
    }

    private static class InsertTask extends AsyncTask<Void, Void, Boolean> {

        private WeakReference<AddNoteActivity> activityReference;
        private Note note;

        // only retain a weak reference to the activity
        InsertTask(AddNoteActivity context, Note note) {
            activityReference = new WeakReference<>(context);
            this.note = note;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... objs) {
            // retrieve auto incremented note id
            long j = activityReference.get().noteDatabase.getNoteDao().insertNote(note);
            note.setNote_id(j);
            Log.e("ID ", "doInBackground: " + j);
            return true;
        }

        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool) {
                activityReference.get().setResult(note, 1);
                activityReference.get().finish();
            }
        }
    }


}
