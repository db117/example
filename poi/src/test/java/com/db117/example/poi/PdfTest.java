package com.db117.example.poi;

import cn.hutool.core.io.FileUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author db117
 * @date 2020/6/2/002 18:40
 */
public class PdfTest {

    @Test
    public void tt() {
        FileUtil.loopFiles("C:\\Users\\117\\Desktop\\电子凭证").forEach(file -> {
            System.out.println(file.getName());
            System.out.println(toText(file));
        });

    }

    @Test
    public void dddd() {
        String tt = "1";
        System.out.println(tt.split("-")[0]);
    }

    private String toText(File file) {
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
            System.out.println(document.getEncryption());
            document.getSignatureFields().forEach(System.out::println);
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
