package by.files.store.bean;

import by.files.store.cleaner.Cleaner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * При запуске приложения запускает поток для удаления старых файлов
 */
@Component
public class CleanerStarter {

    @PostConstruct
    private void init() {
        (new Thread(new Cleaner())).start();
    }
}
