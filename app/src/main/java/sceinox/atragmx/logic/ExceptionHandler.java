package sceinox.atragmx.logic;

import android.content.Context;
import android.widget.Toast;

class ExceptionHandler {

    static void handleDatabaseExceptionForAddingANewGun(Exception ex, Context context) {
        Toast.makeText(context, "Could not create new gun. Maybe you're trying to add a gun that's already existing.", Toast.LENGTH_LONG).show();
    }

    static void handleDatabaseExceptionForDeletingAGun(Exception ex, Context context) {
        Toast.makeText(context, "Could not delete gun. If this problem happens, please message the development team", Toast.LENGTH_LONG).show();
    }
}
