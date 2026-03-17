package com.example.lab_qm02.data.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuizQuestionDao_Impl implements QuizQuestionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QuizQuestionEntity> __insertionAdapterOfQuizQuestionEntity;

  public QuizQuestionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuizQuestionEntity = new EntityInsertionAdapter<QuizQuestionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `quiz_question` (`id`,`bizId`,`stem`,`type`,`difficulty`,`optionsJson`,`correctIndex`,`explanation`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuizQuestionEntity value) {
        stmt.bindLong(1, value.id);
        if (value.bizId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.bizId);
        }
        if (value.stem == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.stem);
        }
        if (value.type == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.type);
        }
        if (value.difficulty == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.difficulty);
        }
        if (value.optionsJson == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.optionsJson);
        }
        stmt.bindLong(7, value.correctIndex);
        if (value.explanation == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.explanation);
        }
      }
    };
  }

  @Override
  public void insertAll(final List<QuizQuestionEntity> questions) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuizQuestionEntity.insert(questions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<QuizQuestionEntity> randomByDifficulty(final String difficulty, final int count) {
    final String _sql = "SELECT * FROM quiz_question WHERE difficulty = ? ORDER BY RANDOM() LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (difficulty == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, difficulty);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, count);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfBizId = CursorUtil.getColumnIndexOrThrow(_cursor, "bizId");
      final int _cursorIndexOfStem = CursorUtil.getColumnIndexOrThrow(_cursor, "stem");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
      final int _cursorIndexOfOptionsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "optionsJson");
      final int _cursorIndexOfCorrectIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "correctIndex");
      final int _cursorIndexOfExplanation = CursorUtil.getColumnIndexOrThrow(_cursor, "explanation");
      final List<QuizQuestionEntity> _result = new ArrayList<QuizQuestionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final QuizQuestionEntity _item;
        _item = new QuizQuestionEntity();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfBizId)) {
          _item.bizId = null;
        } else {
          _item.bizId = _cursor.getString(_cursorIndexOfBizId);
        }
        if (_cursor.isNull(_cursorIndexOfStem)) {
          _item.stem = null;
        } else {
          _item.stem = _cursor.getString(_cursorIndexOfStem);
        }
        if (_cursor.isNull(_cursorIndexOfType)) {
          _item.type = null;
        } else {
          _item.type = _cursor.getString(_cursorIndexOfType);
        }
        if (_cursor.isNull(_cursorIndexOfDifficulty)) {
          _item.difficulty = null;
        } else {
          _item.difficulty = _cursor.getString(_cursorIndexOfDifficulty);
        }
        if (_cursor.isNull(_cursorIndexOfOptionsJson)) {
          _item.optionsJson = null;
        } else {
          _item.optionsJson = _cursor.getString(_cursorIndexOfOptionsJson);
        }
        _item.correctIndex = _cursor.getInt(_cursorIndexOfCorrectIndex);
        if (_cursor.isNull(_cursorIndexOfExplanation)) {
          _item.explanation = null;
        } else {
          _item.explanation = _cursor.getString(_cursorIndexOfExplanation);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<QuizQuestionEntity> randomForPractice(final int count) {
    final String _sql = "SELECT * FROM quiz_question ORDER BY RANDOM() LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, count);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfBizId = CursorUtil.getColumnIndexOrThrow(_cursor, "bizId");
      final int _cursorIndexOfStem = CursorUtil.getColumnIndexOrThrow(_cursor, "stem");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
      final int _cursorIndexOfOptionsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "optionsJson");
      final int _cursorIndexOfCorrectIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "correctIndex");
      final int _cursorIndexOfExplanation = CursorUtil.getColumnIndexOrThrow(_cursor, "explanation");
      final List<QuizQuestionEntity> _result = new ArrayList<QuizQuestionEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final QuizQuestionEntity _item;
        _item = new QuizQuestionEntity();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfBizId)) {
          _item.bizId = null;
        } else {
          _item.bizId = _cursor.getString(_cursorIndexOfBizId);
        }
        if (_cursor.isNull(_cursorIndexOfStem)) {
          _item.stem = null;
        } else {
          _item.stem = _cursor.getString(_cursorIndexOfStem);
        }
        if (_cursor.isNull(_cursorIndexOfType)) {
          _item.type = null;
        } else {
          _item.type = _cursor.getString(_cursorIndexOfType);
        }
        if (_cursor.isNull(_cursorIndexOfDifficulty)) {
          _item.difficulty = null;
        } else {
          _item.difficulty = _cursor.getString(_cursorIndexOfDifficulty);
        }
        if (_cursor.isNull(_cursorIndexOfOptionsJson)) {
          _item.optionsJson = null;
        } else {
          _item.optionsJson = _cursor.getString(_cursorIndexOfOptionsJson);
        }
        _item.correctIndex = _cursor.getInt(_cursorIndexOfCorrectIndex);
        if (_cursor.isNull(_cursorIndexOfExplanation)) {
          _item.explanation = null;
        } else {
          _item.explanation = _cursor.getString(_cursorIndexOfExplanation);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int countAll() {
    final String _sql = "SELECT COUNT(*) FROM quiz_question";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
