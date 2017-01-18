package sceinox.atragmx.logic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ATragMX.db";
    private static final String GUNS_TABLE_GUN = "GUNS";

    private static final String GUNS_COLUMN_ID = "ID";
    private static final String GUNS_COLUMN_NAME = "NAME";
    private static final String GUNS_COLUMN_BOREHEIGHT = "BOREHEIGHT";
    private static final String GUNS_COLUMN_BULLETWEIGHT = "BULLETWEIGHT";
    private static final String GUNS_COLUMN_BULLETDIAMETER = "DIAMETER";
    private static final String GUNS_COLUMN_C1COEFFICIENT = "COEFFICIENT";
    private static final String GUNS_COLUMN_RIFLETWIST = "RIFLETWIST";
    private static final String GUNS_COLUMN_MUZZLEVELOCITY = "MUZZLEVELOCITY";
    private static final String GUNS_COLUMN_ZERORANGE = "ZERORANGE";
    private static final String GUNS_COLUMN_NOTE = "NOTE";

    private static Context context = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        DatabaseHelper.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + GUNS_TABLE_GUN + "(" +
                GUNS_COLUMN_ID + " INTEGER UNIQUE NOT NULL, " +
                GUNS_COLUMN_NAME + " TEXT PRIMARY KEY NOT NULL, " +
                GUNS_COLUMN_BOREHEIGHT + " DOUBLE NOT NULL, " +
                GUNS_COLUMN_BULLETWEIGHT + " DOUBLE NOT NULL, " +
                GUNS_COLUMN_BULLETDIAMETER + " DOUBLE NOT NULL, " +
                GUNS_COLUMN_C1COEFFICIENT + " DOUBLE NOT NULL, " +
                GUNS_COLUMN_RIFLETWIST + " DOUBLE NOT NULL, " +
                GUNS_COLUMN_MUZZLEVELOCITY + " DOUBLE NOT NULL, " +
                GUNS_COLUMN_ZERORANGE + " INTEGER NOT NULL, " +
                GUNS_COLUMN_NOTE + " TEXT" +
                ")");

        addGunsForDatabaseCreation(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE " + GUNS_TABLE_GUN);
        onCreate(sqLiteDatabase);
    }

    public void addNewGun(String name, double boreHeight, double bulletWeight, double bulletDiameter, double c1Coefficient, double rifleTwist, double muzzleVelocity, int zeroRange, String note) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String query = "INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + " (" +
                getNewID(sqLiteDatabase) + ", " + "\"" + name + "\"" + ", " + boreHeight + ", " + bulletWeight + ", " + bulletDiameter + ", " + c1Coefficient + ", " + rifleTwist + ", " + muzzleVelocity + ", " + zeroRange + ", " + note +
                ")";

        try {
            sqLiteDatabase.execSQL(query);
        } catch (Exception ex) {
            ExceptionHandler.handleDatabaseExceptionForAddingANewGun(ex, context);
        }
    }

    public void deleteGun(String name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String query = "DELETE FROM " + GUNS_TABLE_GUN +
                " WHERE " + GUNS_COLUMN_NAME + " = " + "\"" + name + "\"";

        try {
            sqLiteDatabase.execSQL(query);
        } catch (Exception ex) {
            ExceptionHandler.handleDatabaseExceptionForDeletingAGun(ex, context);
        }
    }

    public String[] getNamesOfAllGuns() {
        ArrayList<String> nameOfAllGuns = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String query = "SELECT " + GUNS_COLUMN_NAME + " FROM " + GUNS_TABLE_GUN;

        try (Cursor cursor = sqLiteDatabase.rawQuery(query, null)) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
                nameOfAllGuns.add(cursor.getString(0));
        }

        String[] nameOfAllGunsAsString = new String[nameOfAllGuns.size()];

        for (int i = 0; i < nameOfAllGuns.size(); i++)
            nameOfAllGunsAsString[i] = nameOfAllGuns.get(i);

        return nameOfAllGunsAsString;
    }

    public String[] getGunAsArrayByName(String name) {
        String[] returnGun = new String[9];

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + GUNS_TABLE_GUN + " WHERE " + GUNS_COLUMN_NAME + "=" + "\"" + name + "\"" + " ORDER BY " + GUNS_COLUMN_ID;

        try (Cursor cursor = sqLiteDatabase.rawQuery(query, null)) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    returnGun[i] = cursor.getString(i);
                }
            }
        }
        return returnGun;
    }

    public void resetDatabase() {
        onUpgrade(this.getWritableDatabase(), 1, 1);
    }

    private String getNewID(SQLiteDatabase sqLiteDatabase) {
        String query = "SELECT MAX(" + GUNS_COLUMN_ID + ") FROM " + GUNS_TABLE_GUN;

        try (Cursor cursor = sqLiteDatabase.rawQuery(query, null)) {
            cursor.moveToFirst();

            return String.valueOf(cursor.getInt(cursor.getColumnCount() - 1) + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + GUNS_TABLE_GUN;

        try (Cursor cursor = sqLiteDatabase.rawQuery(query, null)) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    returnString.append(cursor.getColumnName(i)).append(": \t").append(cursor.getString(i)).append(" || ");
                }
                returnString.append("\n\n");
            }
        }

        return returnString.toString();
    }

    private void addGunsForDatabaseCreation(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "0, \"127x108mm\", 3.81, 48, 1.27, 0.638, 38.1, 820, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "1, \"127x99mm\", 3.81, 42, 1.27, 0.575, 38.1, 900, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "2, \"127x99mm AMAX\", 3.81, 49, 1.27, 0.366, 38.1, 860, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "3, \"127x99mm API\", 3.81, 42, 1.29, 0.575, 38.1, 900, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "4, \"300WM Berger OTM\", 3.81, 12, 0.78, 0.705, 25.4, 900, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "5, \"300WM Mk248 Mod0\", 3.81, 12, 0.78, 0.705, 25.4, 900, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "6, \"300WM Mk248 Mod1\", 3.81, 14, 0.78, 0.612, 25.4, 867, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "7, \"338LM 250gr\", 3.81, 16, 0.858, 0.591, 25.4, 880, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "8, \"338LM 300gr\", 3.81, 19, 0.858, 0.522, 25.4, 800, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "9, \"338LM API 526\", 3.81, 16, 0.858, 0.696, 25.4, 895, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "10, \"408 CheyTac\", 3.81, 27, 1.04, 0.389, 33.02, 910, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "11, \"127x54mm\", 3.81, 49, 1.27, 0.193, 24.13, 300, 100, null" +
                ")");

        sqLiteDatabase.execSQL("INSERT INTO " + GUNS_TABLE_GUN + " VALUES " + "(" +
                "12, \"93x64mm\", 3.81, 15, 0.93, 1.085, 35.56, 870, 100, null" +
                ")");
    }
}
