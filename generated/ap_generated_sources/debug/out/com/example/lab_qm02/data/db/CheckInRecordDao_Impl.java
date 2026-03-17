package com.example.lab_qm02.data.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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
public final class CheckInRecordDao_Impl implements CheckInRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CheckInRecord> __insertionAdapterOfCheckInRecord;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  public CheckInRecordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCheckInRecord = new EntityInsertionAdapter<CheckInRecord>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `check_in_records` (`id`,`userId`,`checkInType`,`checkInDate`,`checkInTime`,`remark`,`points`,`isMakeup`,`consecutiveDays`,`createTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CheckInRecord value) {
        stmt.bindLong(1, value.id);
        if (value.userId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.userId);
        }
        if (value.checkInType == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.checkInType);
        }
        if (value.checkInDate == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.checkInDate);
        }
        stmt.bindLong(5, value.checkInTime);
        if (value.remark == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.remark);
        }
        stmt.bindLong(7, value.points);
        final int _tmp = value.isMakeup ? 1 : 0;
        stmt.bindLong(8, _tmp);
        stmt.bindLong(9, value.consecutiveDays);
        stmt.bindLong(10, value.createTime);
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM check_in_records WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final CheckInRecord record) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCheckInRecord.insert(record);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<CheckInRecord> records) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCheckInRecord.insert(records);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteById(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  public CheckInRecord getCheckInByUserDateType(final String userId, final String date,
      final String type) {
    final String _sql = "SELECT * FROM check_in_records WHERE userId = ? AND checkInDate = ? AND checkInType = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    _argIndex = 3;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfCheckInType = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInType");
      final int _cursorIndexOfCheckInDate = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInDate");
      final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "points");
      final int _cursorIndexOfIsMakeup = CursorUtil.getColumnIndexOrThrow(_cursor, "isMakeup");
      final int _cursorIndexOfConsecutiveDays = CursorUtil.getColumnIndexOrThrow(_cursor, "consecutiveDays");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final CheckInRecord _result;
      if(_cursor.moveToFirst()) {
        _result = new CheckInRecord();
        _result.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getString(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInType)) {
          _result.checkInType = null;
        } else {
          _result.checkInType = _cursor.getString(_cursorIndexOfCheckInType);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInDate)) {
          _result.checkInDate = null;
        } else {
          _result.checkInDate = _cursor.getString(_cursorIndexOfCheckInDate);
        }
        _result.checkInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _result.remark = null;
        } else {
          _result.remark = _cursor.getString(_cursorIndexOfRemark);
        }
        _result.points = _cursor.getInt(_cursorIndexOfPoints);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsMakeup);
        _result.isMakeup = _tmp != 0;
        _result.consecutiveDays = _cursor.getInt(_cursorIndexOfConsecutiveDays);
        _result.createTime = _cursor.getLong(_cursorIndexOfCreateTime);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CheckInRecord> getCheckInsByUserDate(final String userId, final String date) {
    final String _sql = "SELECT * FROM check_in_records WHERE userId = ? AND checkInDate = ? ORDER BY checkInTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfCheckInType = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInType");
      final int _cursorIndexOfCheckInDate = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInDate");
      final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "points");
      final int _cursorIndexOfIsMakeup = CursorUtil.getColumnIndexOrThrow(_cursor, "isMakeup");
      final int _cursorIndexOfConsecutiveDays = CursorUtil.getColumnIndexOrThrow(_cursor, "consecutiveDays");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final List<CheckInRecord> _result = new ArrayList<CheckInRecord>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CheckInRecord _item;
        _item = new CheckInRecord();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getString(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInType)) {
          _item.checkInType = null;
        } else {
          _item.checkInType = _cursor.getString(_cursorIndexOfCheckInType);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInDate)) {
          _item.checkInDate = null;
        } else {
          _item.checkInDate = _cursor.getString(_cursorIndexOfCheckInDate);
        }
        _item.checkInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _item.remark = null;
        } else {
          _item.remark = _cursor.getString(_cursorIndexOfRemark);
        }
        _item.points = _cursor.getInt(_cursorIndexOfPoints);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsMakeup);
        _item.isMakeup = _tmp != 0;
        _item.consecutiveDays = _cursor.getInt(_cursorIndexOfConsecutiveDays);
        _item.createTime = _cursor.getLong(_cursorIndexOfCreateTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CheckInRecord> getCheckInsByUserType(final String userId, final String type) {
    final String _sql = "SELECT * FROM check_in_records WHERE userId = ? AND checkInType = ? ORDER BY checkInDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfCheckInType = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInType");
      final int _cursorIndexOfCheckInDate = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInDate");
      final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "points");
      final int _cursorIndexOfIsMakeup = CursorUtil.getColumnIndexOrThrow(_cursor, "isMakeup");
      final int _cursorIndexOfConsecutiveDays = CursorUtil.getColumnIndexOrThrow(_cursor, "consecutiveDays");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final List<CheckInRecord> _result = new ArrayList<CheckInRecord>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CheckInRecord _item;
        _item = new CheckInRecord();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getString(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInType)) {
          _item.checkInType = null;
        } else {
          _item.checkInType = _cursor.getString(_cursorIndexOfCheckInType);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInDate)) {
          _item.checkInDate = null;
        } else {
          _item.checkInDate = _cursor.getString(_cursorIndexOfCheckInDate);
        }
        _item.checkInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _item.remark = null;
        } else {
          _item.remark = _cursor.getString(_cursorIndexOfRemark);
        }
        _item.points = _cursor.getInt(_cursorIndexOfPoints);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsMakeup);
        _item.isMakeup = _tmp != 0;
        _item.consecutiveDays = _cursor.getInt(_cursorIndexOfConsecutiveDays);
        _item.createTime = _cursor.getLong(_cursorIndexOfCreateTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CheckInRecord> getCheckInsByMonth(final String userId, final String monthPattern) {
    final String _sql = "SELECT * FROM check_in_records WHERE userId = ? AND checkInDate LIKE ? ORDER BY checkInDate ASC, checkInTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (monthPattern == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, monthPattern);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfCheckInType = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInType");
      final int _cursorIndexOfCheckInDate = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInDate");
      final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "points");
      final int _cursorIndexOfIsMakeup = CursorUtil.getColumnIndexOrThrow(_cursor, "isMakeup");
      final int _cursorIndexOfConsecutiveDays = CursorUtil.getColumnIndexOrThrow(_cursor, "consecutiveDays");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final List<CheckInRecord> _result = new ArrayList<CheckInRecord>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CheckInRecord _item;
        _item = new CheckInRecord();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getString(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInType)) {
          _item.checkInType = null;
        } else {
          _item.checkInType = _cursor.getString(_cursorIndexOfCheckInType);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInDate)) {
          _item.checkInDate = null;
        } else {
          _item.checkInDate = _cursor.getString(_cursorIndexOfCheckInDate);
        }
        _item.checkInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _item.remark = null;
        } else {
          _item.remark = _cursor.getString(_cursorIndexOfRemark);
        }
        _item.points = _cursor.getInt(_cursorIndexOfPoints);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsMakeup);
        _item.isMakeup = _tmp != 0;
        _item.consecutiveDays = _cursor.getInt(_cursorIndexOfConsecutiveDays);
        _item.createTime = _cursor.getLong(_cursorIndexOfCreateTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CheckInRecord getLatestCheckInByType(final String userId, final String type) {
    final String _sql = "SELECT * FROM check_in_records WHERE userId = ? AND checkInType = ? ORDER BY checkInDate DESC, checkInTime DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfCheckInType = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInType");
      final int _cursorIndexOfCheckInDate = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInDate");
      final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "points");
      final int _cursorIndexOfIsMakeup = CursorUtil.getColumnIndexOrThrow(_cursor, "isMakeup");
      final int _cursorIndexOfConsecutiveDays = CursorUtil.getColumnIndexOrThrow(_cursor, "consecutiveDays");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final CheckInRecord _result;
      if(_cursor.moveToFirst()) {
        _result = new CheckInRecord();
        _result.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getString(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInType)) {
          _result.checkInType = null;
        } else {
          _result.checkInType = _cursor.getString(_cursorIndexOfCheckInType);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInDate)) {
          _result.checkInDate = null;
        } else {
          _result.checkInDate = _cursor.getString(_cursorIndexOfCheckInDate);
        }
        _result.checkInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _result.remark = null;
        } else {
          _result.remark = _cursor.getString(_cursorIndexOfRemark);
        }
        _result.points = _cursor.getInt(_cursorIndexOfPoints);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsMakeup);
        _result.isMakeup = _tmp != 0;
        _result.consecutiveDays = _cursor.getInt(_cursorIndexOfConsecutiveDays);
        _result.createTime = _cursor.getLong(_cursorIndexOfCreateTime);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CheckInRecord getLastCheckInByType(final String userId, final String type) {
    final String _sql = "SELECT * FROM check_in_records WHERE userId = ? AND checkInType = ? ORDER BY checkInDate DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfCheckInType = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInType");
      final int _cursorIndexOfCheckInDate = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInDate");
      final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
      final int _cursorIndexOfRemark = CursorUtil.getColumnIndexOrThrow(_cursor, "remark");
      final int _cursorIndexOfPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "points");
      final int _cursorIndexOfIsMakeup = CursorUtil.getColumnIndexOrThrow(_cursor, "isMakeup");
      final int _cursorIndexOfConsecutiveDays = CursorUtil.getColumnIndexOrThrow(_cursor, "consecutiveDays");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final CheckInRecord _result;
      if(_cursor.moveToFirst()) {
        _result = new CheckInRecord();
        _result.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getString(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInType)) {
          _result.checkInType = null;
        } else {
          _result.checkInType = _cursor.getString(_cursorIndexOfCheckInType);
        }
        if (_cursor.isNull(_cursorIndexOfCheckInDate)) {
          _result.checkInDate = null;
        } else {
          _result.checkInDate = _cursor.getString(_cursorIndexOfCheckInDate);
        }
        _result.checkInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
        if (_cursor.isNull(_cursorIndexOfRemark)) {
          _result.remark = null;
        } else {
          _result.remark = _cursor.getString(_cursorIndexOfRemark);
        }
        _result.points = _cursor.getInt(_cursorIndexOfPoints);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsMakeup);
        _result.isMakeup = _tmp != 0;
        _result.consecutiveDays = _cursor.getInt(_cursorIndexOfConsecutiveDays);
        _result.createTime = _cursor.getLong(_cursorIndexOfCreateTime);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getCheckInCountByType(final String userId, final String type) {
    final String _sql = "SELECT COUNT(*) FROM check_in_records WHERE userId = ? AND checkInType = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
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

  @Override
  public int getCheckInCountByMonth(final String userId, final String monthPattern) {
    final String _sql = "SELECT COUNT(*) FROM check_in_records WHERE userId = ? AND checkInDate LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (monthPattern == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, monthPattern);
    }
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

  @Override
  public int getCheckInCountByTypeAndMonth(final String userId, final String type,
      final String monthPattern) {
    final String _sql = "SELECT COUNT(*) FROM check_in_records WHERE userId = ? AND checkInType = ? AND checkInDate LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    _argIndex = 3;
    if (monthPattern == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, monthPattern);
    }
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

  @Override
  public List<String> getCheckInDatesByType(final String userId, final String type) {
    final String _sql = "SELECT DISTINCT checkInDate FROM check_in_records WHERE userId = ? AND checkInType = ? ORDER BY checkInDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
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
