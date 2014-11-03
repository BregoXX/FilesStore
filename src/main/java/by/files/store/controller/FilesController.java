package by.files.store.controller;

import by.files.store.servlet.UploadServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Загружает из хранилища список всех ранее сохраненных файлов
 */
@Controller
@RequestMapping("/")
public class FilesController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> files = new ArrayList<String>();
        File root = new File(UploadServlet.STORAGE_PATH);
        for (File file : root.listFiles()) {
            files.add(file.getName());
        }
        model.addAttribute("items", files);//добавляем файлы, которые будут отображены на jsp
        return "/items";
    }
}