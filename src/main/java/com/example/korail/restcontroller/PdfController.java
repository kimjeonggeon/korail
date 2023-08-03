package com.example.korail.restcontroller;

import com.example.korail.dto.OrderDto;
import com.example.korail.service.PdfService;
import com.example.korail.service.PmyhisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    PdfService pdfService;

    @Autowired
    PmyhisService pmyhisService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/myreservation_receipt/{reservnum}")
    public ResponseEntity<byte[]> generatePdf(@PathVariable String reservnum) {

        OrderDto orderDto = pmyhisService.getInfo(reservnum);

        // 새로운 Pdf 생성
        byte[] pdfBytes = pdfService.generatePdf(orderDto);
        HttpHeaders headers = new HttpHeaders();
        //contentType="application/pdf;를 대신한다.
        headers.setContentType(MediaType.APPLICATION_PDF);
        // attachement는 해당 파일 다운로드를 수행한다.
        headers.setContentDispositionFormData("attachment", "Korail_receipt_" + reservnum + ".pdf");
        //클라이언트 요청 수행 시, 리소스 학인 1차 2차 3차
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/myreservation_receipts")
    public ResponseEntity<byte[]> generateZipPdf(@RequestParam("urls") List<String> urls) {
        List<String> reservnums = new ArrayList<>();
        for (String url : urls) {
            int startIndex = url.lastIndexOf("/") + 1;
            int endIndex = url.length()-1;

            if (url.endsWith("]")) {
                endIndex -- ;
            }

            String reservnum = url.substring(startIndex, endIndex);
            reservnums.add(reservnum);
        }

        try {
            // 임시 디렉토리 생성
            File tempDir = createTempDirectory();

            // PDF 파일 생성 및 임시 디렉토리에 저장
            List<File> pdfFiles = new ArrayList<>();
            for (String reservnum : reservnums) {
                OrderDto orderDto = pmyhisService.getInfo(reservnum);
                byte[] pdfBytes = pdfService.generatePdf(orderDto);

                File pdfFile = new File(tempDir, "Korail_receipt_" + reservnum + ".pdf");
                try (OutputStream outputStream = new FileOutputStream(pdfFile)) {
                    outputStream.write(pdfBytes);
                }

                pdfFiles.add(pdfFile);
            }

            // 압축 파일 생성
            File zipFile = new File(tempDir, "Korail_receipts.zip");
            createZipArchive(zipFile, pdfFiles);

            // 압축 파일을 응답으로 반환
            byte[] zipBytes = getBytesFromFile(zipFile);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", zipFile.getName());
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            return new ResponseEntity<>(zipBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리를 적절하게 수행
        }

        return ResponseEntity.ok().build();
    }

    private File createTempDirectory() throws IOException {
        File tempDir = File.createTempFile("temp", Long.toString(System.nanoTime()));
        tempDir.delete();
        tempDir.mkdir();
        return tempDir;
    }

    private void createZipArchive(File zipFile, List<File> files) throws IOException {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
            for (File file : files) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);

                try (InputStream inputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        zipOutputStream.write(buffer, 0, bytesRead);
                    }
                }

                zipOutputStream.closeEntry();
            }
        }
    }

    private byte[] getBytesFromFile(File file) throws IOException {
        byte[] buffer = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(buffer);
        }
        return buffer;
    }
}
