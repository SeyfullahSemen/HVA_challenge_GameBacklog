package app.portal.hva.semen.seyfullah.com.gamebacklog;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import app.portal.hva.semen.seyfullah.com.gamebacklog.Classes.AppDatabase;
import app.portal.hva.semen.seyfullah.com.gamebacklog.Classes.Games;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdateActivity extends AppCompatActivity {

    private static final String TAG = UpdateActivity.class.getSimpleName();
    @BindView(R.id.txtUpdateTitle)
    EditText mUpdateGameTitle;
    @BindView(R.id.txtUpdatePlatform)
    EditText mUpdatePlatform;
    @BindView(R.id.status_update_spinner)
    Spinner mUpdateSpinner;
    @BindView(R.id.txtUpdateNotes)
    EditText mUpdateNotes;
    @BindView(R.id.update_fab)
    FloatingActionButton mUpdateFab;

    static AppDatabase db;

    public static final int TASK_UPDATE_GAME = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
        db = AppDatabase.getInstance(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_of_game, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mUpdateSpinner.setAdapter(adapter);

        final Games reminderUpdate = getIntent().getParcelableExtra(MainActivity.EXTRA_GAME);
        mUpdateGameTitle.setText(reminderUpdate.getmGameTitle());
        mUpdatePlatform.setText(reminderUpdate.getPlatformTitle());
        mUpdateSpinner.setSelection(0);
        mUpdateNotes.setText(reminderUpdate.getNote());

        mUpdateFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = mUpdateGameTitle.getText().toString();
                String platform = mUpdatePlatform.getText().toString();
                String status = mUpdateSpinner.getSelectedItem().toString();
                String notes = mUpdateNotes.getText().toString();

                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                reminderUpdate.setmGameTitle(title);
                reminderUpdate.setmPlatformTitle(platform);
                reminderUpdate.setmStatus(status);
                reminderUpdate.setNote(notes);

                intent.putExtra(MainActivity.EXTRA_GAME, reminderUpdate);

                setResult(Activity.RESULT_OK, intent);
                finish();

                Log.i(TAG, "onClick: Inserted ");
            }
        });
    }

    public class GameAsyncTask extends AsyncTask<Games, Void, List> {

        private int taskCode;

        public GameAsyncTask(int taskCode) {
            this.taskCode = taskCode;
        }

        @Override
        protected List doInBackground(Games... games) {
            switch (taskCode) {
                case TASK_UPDATE_GAME:
                    db.reminderDao().updateGame(games[0]);
                    break;
            }
            //To return a new list with the updated data, we get all the data from the database again.
            return db.reminderDao().getAllGames();
        }

        @Override
        protected void onPostExecute(List list) {
            super.onPostExecute(list);
        }


    }


}
