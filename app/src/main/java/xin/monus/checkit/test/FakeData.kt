package xin.monus.checkit.test

import android.content.Context
import xin.monus.checkit.db.LocalDbHelper


object FakeData {

    @JvmStatic fun generateData(context : Context) {
//        if (LocalDbHelper.deleteDatabase(context)) {
//            println("delete fake database success")
//        } else {
//            println("no database to be deleted")
//        }

        val dbHelper = LocalDbHelper(context)
        with(dbHelper.writableDatabase) {
            execSQL(LocalDbHelper.OPEN_FOREIGN_KEYS)

//            // USER
//            execSQL("INSERT INTO USER(username, password, nickname)" +
//                    "    VALUES ('test1', 'hello', 'myth');")
//            // INBOX_ITEM
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete1 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete2 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete3 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete4 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete5 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete6 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete7 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete8 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'complete9 homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'completeA homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'completeB homework', DATETIME('2017-12-08 17:00'), 0 );")
//            execSQL("INSERT INTO INBOX_ITEM (username, content, deadline, complete)" +
//                    "  VALUES ('test1', 'completeC homework', DATETIME('2017-12-08 17:00'), 0 );")
//
//
//            // PROJECT
//            execSQL("INSERT INTO PROJECT (username, content, deadline, flag)" +
//                    "  VALUES ('test1', 'android project', DATETIME('2017-12-08 17:00'), 1 );")
//            execSQL("INSERT INTO PROJECT (username, content, deadline, flag)" +
//                    "  VALUES ('test1', 'proposal', DATETIME('2017-12-08 17:00'), 2 );")
//
//            //  ACTION (parent)
//            execSQL("INSERT INTO ACTION (project_id, content, deadline, complete)" +
//                    "  VALUES ('1', 'action1', DATETIME('2017-12-08 17:00'), 1);")
//            execSQL("INSERT INTO ACTION (project_id, content, deadline)" +
//                    "  VALUES ('1', 'action2', DATETIME('2017-12-08 17:00'));")
//
//            // ACTION (son)
//            execSQL("INSERT INTO ACTION(project_id, content, deadline, parent_action_id)" +
//                    "    VALUES ('1', 'sub action1', DATETIME('2017-12-08 17:00'), '1');")
//            execSQL("INSERT INTO ACTION(project_id, content, deadline, parent_action_id)" +
//                    "    VALUES ('1', 'sub action2', DATETIME('2017-12-08 17:00'), '1');")
//            execSQL("INSERT INTO ACTION(project_id, content, deadline, parent_action_id)" +
//                    "    VALUES ('1', 'sub action3', DATETIME('2017-12-08 17:00'), '1');")

            //DAILY
            execSQL("INSERT INTO DAILY (username, content, remind_time)" +
                    "    VALUES ('ass', 'learn english', TIME('21:30', 'localtime'));")
            execSQL("INSERT INTO DAILY (username, content, remind_time)" +
                    "    VALUES ('ass', 'running', TIME('21:30', 'localtime'));")
            execSQL("INSERT INTO DAILY (username, content, remind_time)" +
                    "    VALUES ('ass', 'review', TIME('21:30', 'localtime'));")

            close()
        }
        dbHelper.close()
    }

}