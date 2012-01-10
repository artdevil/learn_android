package learn.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Learn_androidActivity extends Activity {
    /** Called when the activity is first created. */
	CharSequence[] items = {"google","microsoft","apple"};
	boolean[] itemsChecked = new boolean [items.length];
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn = (Button) findViewById(R.id.btn_dialog);
        btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				showDialog(0);
				
			}
		});
    }
    
    protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 0:
			return new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("this is a dialog with some text...")
			.setPositiveButton("OK",new 
					DialogInterface.OnClickListener() {			
						@Override
						public void onClick(DialogInterface dialog, int whichButton) {
							Toast.makeText(getBaseContext(), "OK clicked", Toast.LENGTH_SHORT).show();	
						}
					})
			.setNegativeButton("cancel",new
					DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int whichButton) {
							Toast.makeText(getBaseContext(), "cancel clicked!!", Toast.LENGTH_SHORT).show();
							
						}
					})
			.setMultiChoiceItems(items,itemsChecked,new
					DialogInterface.OnMultiChoiceClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which, boolean isChecked) {
							Toast.makeText(getBaseContext(), 
									items[which] + (isChecked ? "checked !!":"unchecked"), 
									Toast.LENGTH_SHORT).show();		
						}
					}
			)
			.create();
	}
		return null;
    }
}