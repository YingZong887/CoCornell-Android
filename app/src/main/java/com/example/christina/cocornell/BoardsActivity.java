package com.example.christina.cocornell;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BoardsActivity extends AppCompatActivity {

    private Button AddBoardButton;
    private List<Button> Boards = new ArrayList<>();
    private View mBoardsFormView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boards);
        final Button AddBoardButton = (Button) findViewById(R.id.AddBoard);
        AddBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.BoardLinear);
//                TextView testView = new TextView(BoardsActivity.this);
//                testView.setText("Board" + (Boards.size() + 1));
//                LinearLayout textLayout = new LinearLayout(BoardsActivity.this);
//                textLayout.addView(testView);


                final Button newboard = new Button(BoardsActivity.this);
                Boards.add(newboard);
                newboard.setText("board" + Boards.size());
                newboard.setWidth(80);
                newboard.setTag(Boards.size() - 1);
                linearLayout.addView(newboard);
                newboard.setId(Boards.size() - 1);
                newboard.setOnClickListener(new BoardstoListListener(newboard.getId()));
            }
        });
    }
    private class BoardstoListListener implements Button.OnClickListener {
        int tag;
        BoardstoListListener(int tag) {
            this.tag = tag;
        }
        @Override
        public void onClick(View v) {
            Intent listIntent = new Intent();
            listIntent.setClass(BoardsActivity.this, ListsActivity.class);
            BoardsActivity.this.startActivity(listIntent);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
