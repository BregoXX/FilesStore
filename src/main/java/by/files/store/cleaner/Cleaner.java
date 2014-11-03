package by.files.store.cleaner;


import by.files.store.servlet.UploadServlet;

import java.io.File;
import java.util.Date;

/**
 * Поток для удаления файлов. Раз в 5 секунд проверяет все файлы и удаляет старые
 */
public class Cleaner implements Runnable {

    public static final int TIME_TO_LIVE = 30 * 1000;//10 * 60 * 1000;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                File root = new File(UploadServlet.STORAGE_PATH);
                Date currentDate = new Date();
                for (File file : root.listFiles()) {
                    if(isOldFile(currentDate, file)) {
                        file.delete();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isOldFile(Date date, File file) {
        return date.getTime() - file.lastModified() > TIME_TO_LIVE;
    }
}
