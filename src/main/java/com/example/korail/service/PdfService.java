package com.example.korail.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.example.korail.dto.OrderDto;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;

import com.itextpdf.layout.borders.DottedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.BorderCollapsePropertyValue;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.springframework.stereotype.Service;


@Service
public class PdfService {

    public byte[] generatePdf(OrderDto orderDto){
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Font 선언 및 변수에 적용
            String fontPath = "static/font/NanumBarunGothic.ttf";
            PdfFont fontTitle = PdfFontFactory.createFont(fontPath, "Identity-H", true);
            PdfFont fontMain = PdfFontFactory.createFont(fontPath, "Identity-H", true);

            // OrderDto 변수 선언
            int cancel = orderDto.getCancel();
            String cardnum = orderDto.getCardnum();
            String reservnum = orderDto.getReservnum();
            String rdate = orderDto.getRdate();
            int price = orderDto.getPrice();
            String deptime = orderDto.getDepPlandTime();
            String sstation = orderDto.getSstation();
            String dstation = orderDto.getDstation();
            String stime = orderDto.getStime();
            int ticketqty = orderDto.getTicketqty();

            // table 생성
            Table table_h = new Table(1);
            Table table_m = new Table(1);
            Table table = new Table(2, true);
            Table table_etc = new Table(2, true);

            // table width 조정
            table_h.setWidth(UnitValue.createPercentValue(50));
            table_m.setWidth(UnitValue.createPercentValue(50));
            table.setWidth(UnitValue.createPercentValue(50));
            table_etc.setWidth(UnitValue.createPercentValue(50));
            table.setKeepTogether(true);

            // table의 border-bottom 생성
            table.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
            // 본문 삽입
            String[] mains = {"상호 : (주)중앙고속", "사업자 번호 : 219-81-01636"};
            String[] labels = {
                    "카드사", "BC",
                    "카드번호", cardnum,
                    "승인번호", reservnum,
                    "승인일시", rdate,
                    "승인금액", String.valueOf(price),
                    "결제금액", String.valueOf(price),
            };

            String[] labels2 = {
                    "출발일 ", deptime,
                    "출발지 ", sstation,
                    "도착지 ", dstation,
                    "출발시간", stime,
                    "일반매수", String.valueOf(ticketqty)
            };

            // pdf-header 부분 생성 및 폰트 조절
            Paragraph headParagraph = new Paragraph("KTX 영수증(카드)");
            headParagraph.setFont(fontTitle).setFontSize(24).setBold();
            Cell headCell = new Cell().add(headParagraph);

            // border 삭제 후 border-bottom만 생성
            headCell.setBorder(Border.NO_BORDER);
            headCell.setBorderBottom(new SolidBorder(ColorConstants.BLACK, 2f)); // headCell의 bottom border 설정

            table_h.addCell(headCell);

            for (String mian : mains) {
                // cell 생성 후 text 삽입, 폰트 조절, 셀 삽입
                Cell cell = new Cell();
                cell.setBorder(Border.NO_BORDER);
                Paragraph paragraph = new Paragraph(mian);
                paragraph.setFont(fontMain).setFontSize(13);
                cell.add(paragraph);

                // main String[] border 조정
                table_m.setBorder(Border.NO_BORDER);
                table_m.setBorderBottom(new DottedBorder(ColorConstants.BLACK, 2f));
                table_m.addCell(cell);
                table.setBorderBottom(new DottedBorder(ColorConstants.BLACK, 2f));
            }

            for (int i = 0; i < labels.length; i += 2) {
                String label = labels[i];
                String value = labels[i + 1];

                Cell labelCell = new Cell();
                labelCell.setBorder(Border.NO_BORDER);
                Paragraph labelParagraph = new Paragraph(label);
                labelParagraph.setFont(fontMain).setFontSize(13);
                if (label.equals("결제금액")) {
                    labelParagraph.setFont(fontMain).setFontSize(18);
                    labelParagraph.setBold();
                }
                labelCell.add(labelParagraph).setTextAlignment(TextAlignment.LEFT);
                table.addCell(labelCell);

                Cell valueCell = new Cell();
                valueCell.setBorder(Border.NO_BORDER);
                Paragraph valueParagraph = new Paragraph(value);
                valueParagraph.setFont(fontMain).setFontSize(13);
                if (label.equals("결제금액")) {
                    valueParagraph.setFont(fontMain).setFontSize(18);
                    valueParagraph.setBold();
                } else if (label.equals("카드번호")) {
                    valueParagraph.setFont(fontMain).setFontSize(13);
                }
                valueCell.add(valueParagraph).setTextAlignment(TextAlignment.RIGHT);
                table.addCell(valueCell);
            }

            for (int i = 0; i < labels2.length; i += 2) {
                String label = labels[i];
                String value = labels[i + 1];

                Cell labelCell = new Cell();
                labelCell.setBorder(Border.NO_BORDER);
                Paragraph labelParagraph = new Paragraph(label);
                labelParagraph.setFont(fontMain).setFontSize(13);
                labelCell.add(labelParagraph).setTextAlignment(TextAlignment.LEFT);
                table_etc.addCell(labelCell);

                Cell valueCell = new Cell();
                valueCell.setBorder(Border.NO_BORDER);
                Paragraph valueParagraph = new Paragraph(value);
                valueParagraph.setFont(fontMain).setFontSize(13);
                valueCell.add(valueParagraph).setTextAlignment(TextAlignment.RIGHT);
                table_etc.addCell(valueCell);
            }

            table_h.setHorizontalAlignment(HorizontalAlignment.CENTER);
            table_m.setHorizontalAlignment(HorizontalAlignment.CENTER);
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);
            table_etc.setHorizontalAlignment(HorizontalAlignment.CENTER);

            if (cancel == 1) {
                // 배경 이미지 추가
                String imagePath = "classpath:static/images/bg_cancelTicket_com.png";
                Image backgroundImage = new Image(ImageDataFactory.create(imagePath));
                float pageHeight = document.getPdfDocument().getDefaultPageSize().getHeight();
                float imageHeight = backgroundImage.getImageHeight();
                float imageY = pageHeight - imageHeight - 200;


                backgroundImage.setFixedPosition(35, imageY);
                document.add(backgroundImage);

            }


            document.add(table_h);
            document.add(table_m);
            document.add(table);
            document.add(table_etc);

            document.close();

            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리를 적절하게 수행
        }
        return null;
    }
}
