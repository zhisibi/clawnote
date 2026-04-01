package com.crayfish.notes.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.crayfish.notes.data.local.dao.NoteDao;
import com.crayfish.notes.data.local.dao.NoteDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile NoteDao _noteDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `notes` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `bg_color` TEXT NOT NULL, `is_archived` INTEGER NOT NULL, `sync_status` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tags` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `tag_color` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `note_tag_cross_ref` (`note_id` TEXT NOT NULL, `tag_id` TEXT NOT NULL, PRIMARY KEY(`note_id`, `tag_id`), FOREIGN KEY(`note_id`) REFERENCES `notes`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`tag_id`) REFERENCES `tags`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_note_tag_cross_ref_note_id` ON `note_tag_cross_ref` (`note_id`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_note_tag_cross_ref_tag_id` ON `note_tag_cross_ref` (`tag_id`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c3fdcee8e88ba412b3979ba4f9782afe')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `notes`");
        db.execSQL("DROP TABLE IF EXISTS `tags`");
        db.execSQL("DROP TABLE IF EXISTS `note_tag_cross_ref`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsNotes = new HashMap<String, TableInfo.Column>(8);
        _columnsNotes.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("bg_color", new TableInfo.Column("bg_color", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("is_archived", new TableInfo.Column("is_archived", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("sync_status", new TableInfo.Column("sync_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotes = new TableInfo("notes", _columnsNotes, _foreignKeysNotes, _indicesNotes);
        final TableInfo _existingNotes = TableInfo.read(db, "notes");
        if (!_infoNotes.equals(_existingNotes)) {
          return new RoomOpenHelper.ValidationResult(false, "notes(com.crayfish.notes.data.local.entity.NoteEntity).\n"
                  + " Expected:\n" + _infoNotes + "\n"
                  + " Found:\n" + _existingNotes);
        }
        final HashMap<String, TableInfo.Column> _columnsTags = new HashMap<String, TableInfo.Column>(3);
        _columnsTags.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTags.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTags.put("tag_color", new TableInfo.Column("tag_color", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTags = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTags = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTags = new TableInfo("tags", _columnsTags, _foreignKeysTags, _indicesTags);
        final TableInfo _existingTags = TableInfo.read(db, "tags");
        if (!_infoTags.equals(_existingTags)) {
          return new RoomOpenHelper.ValidationResult(false, "tags(com.crayfish.notes.data.local.entity.TagEntity).\n"
                  + " Expected:\n" + _infoTags + "\n"
                  + " Found:\n" + _existingTags);
        }
        final HashMap<String, TableInfo.Column> _columnsNoteTagCrossRef = new HashMap<String, TableInfo.Column>(2);
        _columnsNoteTagCrossRef.put("note_id", new TableInfo.Column("note_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteTagCrossRef.put("tag_id", new TableInfo.Column("tag_id", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNoteTagCrossRef = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysNoteTagCrossRef.add(new TableInfo.ForeignKey("notes", "CASCADE", "NO ACTION", Arrays.asList("note_id"), Arrays.asList("id")));
        _foreignKeysNoteTagCrossRef.add(new TableInfo.ForeignKey("tags", "CASCADE", "NO ACTION", Arrays.asList("tag_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesNoteTagCrossRef = new HashSet<TableInfo.Index>(2);
        _indicesNoteTagCrossRef.add(new TableInfo.Index("index_note_tag_cross_ref_note_id", false, Arrays.asList("note_id"), Arrays.asList("ASC")));
        _indicesNoteTagCrossRef.add(new TableInfo.Index("index_note_tag_cross_ref_tag_id", false, Arrays.asList("tag_id"), Arrays.asList("ASC")));
        final TableInfo _infoNoteTagCrossRef = new TableInfo("note_tag_cross_ref", _columnsNoteTagCrossRef, _foreignKeysNoteTagCrossRef, _indicesNoteTagCrossRef);
        final TableInfo _existingNoteTagCrossRef = TableInfo.read(db, "note_tag_cross_ref");
        if (!_infoNoteTagCrossRef.equals(_existingNoteTagCrossRef)) {
          return new RoomOpenHelper.ValidationResult(false, "note_tag_cross_ref(com.crayfish.notes.data.local.entity.NoteTagCrossRef).\n"
                  + " Expected:\n" + _infoNoteTagCrossRef + "\n"
                  + " Found:\n" + _existingNoteTagCrossRef);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c3fdcee8e88ba412b3979ba4f9782afe", "beb2d02b616ac5531f98308522c227d5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "notes","tags","note_tag_cross_ref");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `notes`");
      _db.execSQL("DELETE FROM `tags`");
      _db.execSQL("DELETE FROM `note_tag_cross_ref`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(NoteDao.class, NoteDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public NoteDao noteDao() {
    if (_noteDao != null) {
      return _noteDao;
    } else {
      synchronized(this) {
        if(_noteDao == null) {
          _noteDao = new NoteDao_Impl(this);
        }
        return _noteDao;
      }
    }
  }
}
