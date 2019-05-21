package com.epic.excel_uploader.controller;

import com.epic.excel_uploader.entities.Employee;
import com.epic.excel_uploader.service.EmployeeService;
import com.epic.excel_uploader.service.ExcelExporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    ExcelExporterService exporterService;

    Calendar c = Calendar.getInstance();
    String month=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );

    //    private static String UPLOADED_FOLDER = "F://temp;
    private  String UPLOADED_FOLDER = "C://Users//Danidu//Downloads//TestUpload//";






//    @GetMapping("/")
//    public String dashboard() {
//        System.out.println("DONE");
//        return "dashboard";
//    }

    @GetMapping("/")
    public String excelUploader() {
        System.out.println("Upload Service Started");
        return "ExcelFileUploder";
    }


    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes, HttpServletRequest request) {

        String fileType=file.getContentType();

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                return "redirect:uploadStatus";
            }


                exporterService.excelExporterPrimeXlx(path.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "ExcelFileUploder";
    }
}
