package sceinox.atragmx;

import android.content.Context;
import android.widget.Toast;

class ExceptionHandler {

    static void handleDatabaseExceptionForAddingANewGun(Exception ex, Context context){
        Toast.makeText(context ,"Could not create new gun. Maybe you're trying to add a gun that's already exisiting.", Toast.LENGTH_LONG).show();
    }
}
