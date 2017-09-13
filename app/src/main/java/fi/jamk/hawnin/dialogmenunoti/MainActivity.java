package fi.jamk.hawnin.dialogmenunoti;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Process;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

        private String [] items= {"John Koch","Peter Michell","Ina kudson"};

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setListAdapter(new ArrayAdapter<String> (
                    this,
                    android.R.layout.simple_list_item_1,
                    items
            ));
            // register contextMenu for this ListActivity
            registerForContextMenu(getListView());
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
        }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // context menu item
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        // text view in list
        TextView textView = (TextView) info.targetView;
        // name in textview
        String name = textView.getText().toString();
        // action
        switch (item.getItemId()) {
            case R.id.Do:
                Toast.makeText(getBaseContext(), "Do Your Assignments First "+name, Toast.LENGTH_LONG).show();
                return true;
            case R.id.Not:
                Toast.makeText(getBaseContext(), "Not Hesitate to open a can of Beer Meinwhile "+name, Toast.LENGTH_LONG).show();
                return true;
            case R.id.Open:
                Toast.makeText(getBaseContext(), "Open your neighbours door "+name, Toast.LENGTH_LONG).show();
                return true;
            case R.id.My:
                Toast.makeText(getBaseContext(), "Mount a pack of beer to his/her Back " +
                        "Notify him/her about her position for the next week that he/she will be your Beer carrier " +
                        " "+name, Toast.LENGTH_LONG).show();
                return true;
            case R.id.Notification_and_Close:
                Toast.makeText(getBaseContext()," I Told you to not to touch my NOTIFIATION RAAAAGGEEEEE"+name, Toast.LENGTH_LONG).show();
                int i=0;
                Process.killProcess(Process.myPid());
                System.exit(1);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
