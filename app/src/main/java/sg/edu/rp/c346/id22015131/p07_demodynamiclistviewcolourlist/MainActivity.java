package sg.edu.rp.c346.id22015131.p07_demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvColour;
    Button btnAdd, btnRemove, btnUpdate;
    EditText etElement, etPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvColour = findViewById(R.id.listViewColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        etElement = findViewById(R.id.editTextColour);
        etPosition = findViewById(R.id.editTextIndex);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);

        ArrayList<String> alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(v -> {
            String newColour = etElement.getText().toString();
            int newPos = Integer.parseInt(etPosition.getText().toString());
            alColours.add(newPos-1, newColour);
            aaColour.notifyDataSetChanged();
        });

        btnRemove.setOnClickListener(v -> {
            int pos = Integer.parseInt(etPosition.getText().toString());
            alColours.remove(pos-1);
            aaColour.notifyDataSetChanged();
        });

        btnUpdate.setOnClickListener(v -> {
            String newColour = etElement.getText().toString();
            int pos = Integer.parseInt(etPosition.getText().toString());
            alColours.set(pos-1, newColour);
            aaColour.notifyDataSetChanged();
        });

        lvColour.setOnItemClickListener((parent, view, position, id) -> {
            String colour = alColours.get(position);
            Toast.makeText(getApplicationContext(), colour, Toast.LENGTH_SHORT).show();
        });
    }
}