package com.crayfish.notes.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.crayfish.notes.data.local.entity.NoteEntity;
import com.crayfish.notes.data.local.entity.NoteTagCrossRef;
import com.crayfish.notes.data.local.entity.TagEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDao_Impl implements NoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NoteEntity> __insertionAdapterOfNoteEntity;

  private final EntityInsertionAdapter<TagEntity> __insertionAdapterOfTagEntity;

  private final EntityInsertionAdapter<NoteTagCrossRef> __insertionAdapterOfNoteTagCrossRef;

  private final EntityDeletionOrUpdateAdapter<NoteEntity> __deletionAdapterOfNoteEntity;

  private final EntityDeletionOrUpdateAdapter<NoteEntity> __updateAdapterOfNoteEntity;

  public NoteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNoteEntity = new EntityInsertionAdapter<NoteEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `notes` (`id`,`title`,`content`,`created_at`,`updated_at`,`bg_color`,`is_archived`,`sync_status`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NoteEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getContent() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContent());
        }
        statement.bindLong(4, entity.getCreatedAt());
        statement.bindLong(5, entity.getUpdatedAt());
        if (entity.getBgColor() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getBgColor());
        }
        final int _tmp = entity.isArchived() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getSyncStatus());
      }
    };
    this.__insertionAdapterOfTagEntity = new EntityInsertionAdapter<TagEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tags` (`id`,`name`,`tag_color`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TagEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getTagColor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTagColor());
        }
      }
    };
    this.__insertionAdapterOfNoteTagCrossRef = new EntityInsertionAdapter<NoteTagCrossRef>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `note_tag_cross_ref` (`note_id`,`tag_id`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NoteTagCrossRef entity) {
        if (entity.getNoteId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getNoteId());
        }
        if (entity.getTagId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTagId());
        }
      }
    };
    this.__deletionAdapterOfNoteEntity = new EntityDeletionOrUpdateAdapter<NoteEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `notes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NoteEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfNoteEntity = new EntityDeletionOrUpdateAdapter<NoteEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `notes` SET `id` = ?,`title` = ?,`content` = ?,`created_at` = ?,`updated_at` = ?,`bg_color` = ?,`is_archived` = ?,`sync_status` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NoteEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getContent() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContent());
        }
        statement.bindLong(4, entity.getCreatedAt());
        statement.bindLong(5, entity.getUpdatedAt());
        if (entity.getBgColor() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getBgColor());
        }
        final int _tmp = entity.isArchived() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getSyncStatus());
        if (entity.getId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertNote(final NoteEntity note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNoteEntity.insert(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertTag(final TagEntity tag, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTagEntity.insert(tag);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertNoteTagCrossRef(final NoteTagCrossRef crossRef,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNoteTagCrossRef.insert(crossRef);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNote(final NoteEntity note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNoteEntity.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNote(final NoteEntity note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNoteEntity.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<NoteEntity>> getAllNotesFlow() {
    final String _sql = "SELECT * FROM notes WHERE is_archived = 0 ORDER BY created_at DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"notes"}, new Callable<List<NoteEntity>>() {
      @Override
      @NonNull
      public List<NoteEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfBgColor = CursorUtil.getColumnIndexOrThrow(_cursor, "bg_color");
          final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "is_archived");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
          final List<NoteEntity> _result = new ArrayList<NoteEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NoteEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final String _tmpBgColor;
            if (_cursor.isNull(_cursorIndexOfBgColor)) {
              _tmpBgColor = null;
            } else {
              _tmpBgColor = _cursor.getString(_cursorIndexOfBgColor);
            }
            final boolean _tmpIsArchived;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsArchived);
            _tmpIsArchived = _tmp != 0;
            final int _tmpSyncStatus;
            _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
            _item = new NoteEntity(_tmpId,_tmpTitle,_tmpContent,_tmpCreatedAt,_tmpUpdatedAt,_tmpBgColor,_tmpIsArchived,_tmpSyncStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getNoteById(final String id, final Continuation<? super NoteEntity> $completion) {
    final String _sql = "SELECT * FROM notes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<NoteEntity>() {
      @Override
      @Nullable
      public NoteEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfBgColor = CursorUtil.getColumnIndexOrThrow(_cursor, "bg_color");
          final int _cursorIndexOfIsArchived = CursorUtil.getColumnIndexOrThrow(_cursor, "is_archived");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
          final NoteEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final String _tmpBgColor;
            if (_cursor.isNull(_cursorIndexOfBgColor)) {
              _tmpBgColor = null;
            } else {
              _tmpBgColor = _cursor.getString(_cursorIndexOfBgColor);
            }
            final boolean _tmpIsArchived;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsArchived);
            _tmpIsArchived = _tmp != 0;
            final int _tmpSyncStatus;
            _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
            _result = new NoteEntity(_tmpId,_tmpTitle,_tmpContent,_tmpCreatedAt,_tmpUpdatedAt,_tmpBgColor,_tmpIsArchived,_tmpSyncStatus);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<TagEntity>> getAllTagsFlow() {
    final String _sql = "SELECT * FROM tags";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tags"}, new Callable<List<TagEntity>>() {
      @Override
      @NonNull
      public List<TagEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfTagColor = CursorUtil.getColumnIndexOrThrow(_cursor, "tag_color");
          final List<TagEntity> _result = new ArrayList<TagEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TagEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpTagColor;
            if (_cursor.isNull(_cursorIndexOfTagColor)) {
              _tmpTagColor = null;
            } else {
              _tmpTagColor = _cursor.getString(_cursorIndexOfTagColor);
            }
            _item = new TagEntity(_tmpId,_tmpName,_tmpTagColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<TagEntity>> getTagsForNote(final String noteId) {
    final String _sql = "\n"
            + "        SELECT * FROM tags \n"
            + "        INNER JOIN note_tag_cross_ref ON tags.id = note_tag_cross_ref.tag_id \n"
            + "        WHERE note_tag_cross_ref.note_id = ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (noteId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, noteId);
    }
    return CoroutinesRoom.createFlow(__db, true, new String[] {"tags",
        "note_tag_cross_ref"}, new Callable<List<TagEntity>>() {
      @Override
      @NonNull
      public List<TagEntity> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfTagColor = CursorUtil.getColumnIndexOrThrow(_cursor, "tag_color");
            final List<TagEntity> _result = new ArrayList<TagEntity>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final TagEntity _item;
              final String _tmpId;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpId = null;
              } else {
                _tmpId = _cursor.getString(_cursorIndexOfId);
              }
              final String _tmpName;
              if (_cursor.isNull(_cursorIndexOfName)) {
                _tmpName = null;
              } else {
                _tmpName = _cursor.getString(_cursorIndexOfName);
              }
              final String _tmpTagColor;
              if (_cursor.isNull(_cursorIndexOfTagColor)) {
                _tmpTagColor = null;
              } else {
                _tmpTagColor = _cursor.getString(_cursorIndexOfTagColor);
              }
              _item = new TagEntity(_tmpId,_tmpName,_tmpTagColor);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
