package com.mustafa.CVMaker;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) throws Exception {

        String path = "C:\\Users\\mustafa\\Desktop\\cv.pdf";

        List<Person> personInformationList = new ArrayList<>();
        personInformationList.add(new Person(
                "Shane Lawson",
                "P.O. Box 1605, Lebanon, OH 45036",
                "+1 (555) 123-4567",
                "shanelawson@gmail.com"
        ));

        String aboutYourself = "Software engineer with 5 years of experience in web technologies, cloud infrastructure, and microservices. " +
                "Proficient in Java, Python, JavaScript, and React. Led 15+ large-scale projects with AWS and Azure expertise. " +
                "Strong advocate of Agile methodologies and DevOps practices.";

        List<Education> educationList = new ArrayList<>();
        educationList.add(new Education(
                "09.2015 - 06.2019",
                "Stanford University - B.S. in Computer Science, Stanford, CA",
                "GPA: 3.65/4.00. Computer Club President, hackathon winner, IEEE member."
        ));

        educationList.add(new Education(
                "09.2019 - 06.2021",
                "MIT - M.S. in Computer Science, Cambridge, MA",
                "Advanced studies in machine learning and distributed systems.\n GPA: 3.80/4.00."
        ));

        String skills = "• Programming: Java, Python, JavaScript, TypeScript, C++, Go\n" +
                "• Web: React.js, Node.js, Spring Boot, Next.js, Angular\n" +
                "• Database: PostgreSQL, MongoDB, Redis, DynamoDB\n" +
                "• Cloud: AWS (EC2, S3, Lambda, RDS), Azure, GCP\n" +
                "• DevOps: Docker, Kubernetes, Jenkins, GitHub Actions, Terraform\n";

        List<WorkExperience> workExperienceList = new ArrayList<>();
        workExperienceList.add(new WorkExperience(
                "01.2022 - Present",
                "TechVision Corp., San Francisco, CA",
                "Senior Software Engineer",
                "Develop payment systems with microservices handling 5M+ monthly transactions. " +
                        "Lead team of 6 developers. Optimized CI/CD pipelines reducing deployment time by 60%."
        ));

        workExperienceList.add(new WorkExperience(
                "06.2019 - 12.2021",
                "NextGen Solutions, Austin, TX",
                "Software Developer",
                "Developed e-commerce applications using Node.js and React. " +
                        "Collaborated with cross-functional teams on high-quality solutions."
        ));

        String certificates = "• AWS Certified Solutions Architect - Associate (2023)\n" +
                "• Oracle Certified Professional: Java SE 11 Developer (2022)\n" +
                "• Microsoft Azure Fundamentals (2022)\n" +
                "• Docker Certified Associate (2021)\n";

        createBasicPdf(path, personInformationList, aboutYourself,
                educationList, skills, workExperienceList, certificates);

    }

    public static void createBasicPdf(String dest, List<Person> personInformationList,String aboutYourself, List<Education> educationList,
                                      String skills, List<WorkExperience> workExperienceList, String certificates) throws Exception {

        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        LineSeparator line = new LineSeparator(new SolidLine());

        addPersonalDetails(document, personInformationList);

        document.add(line);

        addPersonalInfo(document, aboutYourself);

        document.add(line);

        addEducation(document, educationList);

        document.add(line);

        addSkills(document, skills);

        document.add(line);

        addWorkExperience(document, workExperienceList);

        document.add(line);

        addCertificates(document, certificates);

        document.close();
    }

    private static void addPersonalDetails(Document doc, List<Person> personInformationList) throws IOException {

        PdfFont font1 = PdfFontFactory.createFont(StandardFonts.COURIER);

        doc.add(new Paragraph("PERSONAL DETAILS").setFontSize(12).setBold().setFont(font1));

        Table personalTable = new Table(UnitValue.createPercentArray(new float[]{30, 40, 30}));
        personalTable.setWidth(UnitValue.createPercentValue(100));

        Cell leftCell = new Cell();
        leftCell.setBorder(null);

        leftCell.add(new Paragraph("Name").setFontSize(10).setFont(font1));
        leftCell.add(new Paragraph("Address").setFontSize(10).setFont(font1));
        leftCell.add(new Paragraph("Phone number").setFontSize(10).setFont(font1));
        leftCell.add(new Paragraph("Email").setFontSize(10).setFont(font1));

        Cell middleCell = new Cell();
        middleCell.setBorder(null);

        for(Person person: personInformationList){
            middleCell.add(new Paragraph(person.getFullName()).setFontSize(10).setFont(font1).setBold());
            middleCell.add(new Paragraph(person.getAddress()).setFontSize(10).setFont(font1).setBold());
            middleCell.add(new Paragraph(person.getPhoneNumber()).setFontSize(10).setFont(font1).setBold());
            middleCell.add(new Paragraph(person.getEmail()).setFontSize(10).setFont(font1).setBold());
        }

        Cell rightCell = new Cell();
        rightCell.setBorder(null);

        Image image = addImage();
        rightCell.add(image);

        personalTable.addCell(leftCell);
        personalTable.addCell(middleCell);
        personalTable.addCell(rightCell);

        doc.add(personalTable);
        doc.add(new Paragraph(" "));
    }

    private static void addPersonalInfo(Document doc, String personalInfo) throws IOException {

        PdfFont font1 = PdfFontFactory.createFont(StandardFonts.COURIER);;

        doc.add(new Paragraph("PERSONAL PROFILE").setFontSize(12).setBold().setFont(font1));
        doc.add(new Paragraph(personalInfo).setFontSize(9).setFont(font1));
        doc.add(new Paragraph(" "));
    }

    private static void addEducation(Document doc, List<Education> educationList) throws IOException{

        PdfFont font1 = PdfFontFactory.createFont(StandardFonts.COURIER);

        doc.add(new Paragraph("EDUCATION").setFontSize(12).setBold().setFont(font1));

        for(Education edu: educationList){
            Table eduTable = new Table(UnitValue.createPercentArray(new float[]{20, 80}));
            eduTable.setWidth(UnitValue.createPercentValue(100));

            Cell dateCell = new Cell();
            dateCell.setBorder(null);
            dateCell.add(new Paragraph(edu.getDate()).setFontSize(9).setFont(font1).setBold());

            Cell detailsCell = new Cell();
            detailsCell.setBorder(null);

            detailsCell.add(new Paragraph(edu.getSchoolName()).setFontSize(9).setFont(font1).setBold());
            detailsCell.add(new Paragraph(edu.getDescription()).setFontSize(9).setFont(font1));

            eduTable.addCell(dateCell);
            eduTable.addCell(detailsCell);

            doc.add(eduTable);
            doc.add(new Paragraph(" "));
        }
    }

    private static void addSkills(Document doc, String skills) throws IOException {

        PdfFont font1 = PdfFontFactory.createFont(StandardFonts.COURIER);

        doc.add(new Paragraph("SKILLS").setFontSize(12).setBold().setFont(font1));
        doc.add(new Paragraph(skills).setFontSize(9).setFont(font1));
        doc.add(new Paragraph(" "));
    }

    private static void addWorkExperience(Document doc, List<WorkExperience> workExperienceList) throws IOException {

        PdfFont font1 = PdfFontFactory.createFont(StandardFonts.COURIER);

        doc.add(new Paragraph("WORK EXPERIENCE").setFontSize(12).setBold().setFont(font1));

        for(WorkExperience work: workExperienceList){

            doc.add(new Paragraph(work.getRole() + " | " + work.getCompany() + " | " + work.getDate()).setFontSize(10).setBold().setFont(font1));
            doc.add(new Paragraph(work.getDescription()).setFontSize(9).setFont(font1));
            doc.add(new Paragraph(" "));
        }
    }

    private static void addCertificates(Document doc, String certificates) throws IOException {

        PdfFont font1 = PdfFontFactory.createFont(StandardFonts.COURIER);

        doc.add(new Paragraph("CERTIFICATES").setFontSize(12).setFont(font1).setBold());
        doc.add(new Paragraph(certificates).setFontSize(9).setFont(font1));
        doc.add(new Paragraph(" "));
    }

    private static Image addImage() throws MalformedURLException {

        String imagePath = "C:\\Users\\mustafa\\Desktop\\ryangosling.jpg";
        ImageData imageData = ImageDataFactory.create(imagePath);
        Image image = new Image(imageData);

        image.setWidth(70);
        image.setHeight(70);

        image.setHorizontalAlignment(HorizontalAlignment.CENTER);

        return image;
    }
}