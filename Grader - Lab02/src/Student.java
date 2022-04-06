//Lauren Hodges
import java.io.*;
import java.util.Scanner;
public class Student {


    private double labSum;
    private double labCount;
    private double labRSum;
    private double labRCount;
    private double hwSum;
    private double hwCount;
    private double exam01;
    private double exam02;
    private double finalExam;
    private double rawGrade;

    public Student(){
        labSum = 0.0;
        labCount = 0.0;
        labRSum = 0.0;
        labRCount=0.0;
        hwCount = 0.0;
        hwSum = 0.0;
        exam01 = 0.0;
        exam02 = 0.0;
        finalExam=0.0;
    }

    public double getLabAverage(){
        return labSum/labCount;
    }
    public double getLabReportAverage(){
        return labRSum/labRCount;
    }
    public double getHomeworkAverage(){
        return hwSum/hwCount;
    }
    public double getExam01(){
        return exam01;
    }
    public double getExam02(){
        return exam02;
    }
    public double getFinal(){
        return finalExam;
    }

    public void addGrade(String aType, double aGrade){
        if(aType.equalsIgnoreCase("LABS")) {
            labCount++;
            labSum = labSum + aGrade;
        }
        if(aType.equalsIgnoreCase("LAB REPORTS")){
            labRCount++;
            labRSum = labRSum + aGrade;
        }
        if(aType.equalsIgnoreCase("homework")){
            hwCount++;
            hwSum = hwSum + aGrade;
        }
        if(aType.equalsIgnoreCase("exam01")){
            exam01 = aGrade;
        }
        if(aType.equalsIgnoreCase("exam02")){
            exam02 = aGrade;
        }
        if(aType.equalsIgnoreCase("final")){
            finalExam = aGrade;
        }
    }

    public double getGradeNumeric(){
        double highestEx = 0;
        double secondEx=0;
        if(exam01>=exam02&&exam01>=finalExam){
            highestEx = exam01;
        }
        if(exam02>=exam01&&exam02>=finalExam){
            highestEx=exam02;
        }
        if(finalExam>=exam01&&finalExam>=exam02){
            highestEx = finalExam;
        }
        if(exam02>=finalExam&&exam02<=highestEx&&exam02>=exam01){
            secondEx = exam02;
        }
        if(exam01>=finalExam&&exam01<=highestEx&&exam01>=exam02){
            secondEx = exam01;
        }
        if(finalExam>=exam01&&finalExam<=highestEx&&finalExam>=exam02){
            secondEx = finalExam;
        }

        rawGrade = ((getLabReportAverage()*.1)+(getLabAverage()*.1)+(getHomeworkAverage()*.2)+(highestEx*.3)+(secondEx*.3));
        return rawGrade;
    }

    public double getGradeRounded(){
        return Math.ceil(rawGrade);
    }

    public String getGradeLetter(){
        double roundGrade = Math.ceil(rawGrade);
        String letter = null;
        if(roundGrade>=90){
            letter = "A";
        }
        else if(roundGrade>=85){
            letter = "B+";
        }
        else if(roundGrade>=80){
            letter = "B";
        }
        else if(roundGrade>=75){
            letter = "C+";
        }
        else if(roundGrade>=70){
            letter = "C";
        }
        else if(roundGrade>=65){
            letter = "D+";
        }
        else if(roundGrade>=60){
            letter = "D";
        }
        else
            letter = "F";

        return letter;
    }
    public void readGradeFile(String aFile){
        try{
            Scanner fileScanner = new Scanner(new File(aFile));
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String [] currLine = line.split("\t",2);
                String type = currLine[0];
                Double grade = Double.parseDouble(currLine[1]);
                if(type.equalsIgnoreCase("lab report")){
                    type = "LAB REPORTS";
                }
                else if(type.equalsIgnoreCase("lab")){
                    type = "LABS";
                }
                else if(type.equalsIgnoreCase("homework")){
                    type = "HOMEWORK";
                }
                else if(type.equalsIgnoreCase("exam 1")){
                    type = "EXAM01";
                }
                else if(type.equalsIgnoreCase("exam 2")){
                    type = "EXAM02";
                }
                else if(type.equalsIgnoreCase("final")){
                    type = "FINAL";
                }
                this.addGrade(type, grade);
            }
            fileScanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public String toString(){
        return "Lab Average: "+getLabAverage()
                +"\nLab Report Average: "+getLabReportAverage()
                +"\nHomework Average: "+getHomeworkAverage()
                +"\nExam 1 Grade: "+getExam01()+"\nExam 2 Grade: "
                +getExam02()+"\nFinal Exam Grade: "+getFinal()+
                "\nRaw Grade: "+getGradeNumeric()+"\nRounded Grade: "
                +getGradeRounded()+"\nLetter Grade: "+getGradeLetter();
    }






}
