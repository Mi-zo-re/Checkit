package xin.monus.checkit.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import xin.monus.checkit.R
import xin.monus.checkit.data.entity.InboxItem
import xin.monus.checkit.data.source.InboxItemDataSource
import xin.monus.checkit.data.source.local.InboxItemLocalDataSource
import xin.monus.checkit.db.LocalDbHelper


class TestActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        if (LocalDbHelper.deleteDatabase(this)) {
            println("delete database success")
        } else {
            println("no database to be deleted")
        }

        val dbHelper = LocalDbHelper(this)
        with(dbHelper.writableDatabase) {
            execSQL(LocalDbHelper.OPEN_FOREIGN_KEYS)
            execSQL("INSERT INTO USER(username, password, nickname)" +
                    "    VALUES ('test', 'hello', 'myth');")
            execSQL("INSERT INTO USER(username, password, nickname)" +
                    "    VALUES ('test1', 'hello', 'myth');")
            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
                    "  VALUES ('test1', 'complete homework', DATETIME('2017-12-08 17:00'), 1 );")
            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
                    "  VALUES ('test1', 'complete homework', DATETIME('2017-12-08 17:00'), 1 );")
            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
                    "  VALUES ('test1', 'complete homework', DATETIME('2017-12-08 17:00'), 1 );")
//            execSQL("DELETE FROM USER WHERE username = 'test1';")
        }

        val item = InboxItem(username = "test",
                content = "smart ass",
                deadline = "2017-12-23 18:00",
                complete = false,
                flag = true
                )

        val ldb = InboxItemLocalDataSource.getInstance(this)

        ldb.addInboxItem(item, object : InboxItemDataSource.OperationCallback {
            override fun success() {
                println("add success")
            }
            override fun fail() {
                println("add failed")
            }

        })

    }
}