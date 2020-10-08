package cs.lab;

import sun.security.x509.Extension;

public class RegistrApp {

    private String semester;
    private String code;
    private String language;
    private String course;
    private int section;
    private String week;
    private String teacher;
    private String date;
    private String hour;
    private String type;
    private String link;

    public RegistrApp(String semesterAt, String codeAt, String languageAt, String courseAt, int sectionAt, String weekAt, 
    String teacherAt, String dataAt, String hourAt, String typeAt, String linkAt) {
        semester = semesterAt;
        code = codeAt;
        language = languageAt;
        course = courseAt;
        section = sectionAt;
        week = weekAt;
        teacher = teacherAt;
        date = dataAt;
        hour = hourAt;
        type = typeAt;
        link = linkAt;
    }

    public void parsing(){
        
    }
    
    public boolean verify() throws Extension{
        String semesterExtensionI = semester.charAt(4) + semester.charAt(5);
        String semesterExtensionII = semester.charAt(4) + semester.charAt(5) + semester.charAt(6);

        if (semesterExtensionI != "-I" && semesterExtensionII != "-II"){
            throw new Exception("Wrong semester");
        }

        if (code.length() != 6 || code == " "){
            throw new Exception("Wrong code");
        }

        if (language != "ES" || language != "EN"){
            throw new Exception("Wrong language");
        }

        if (course == " "){
            throw new Exception("No course name");
        }

        String weekNum = week.charAt(6) + week.charAt(7);

        if(Integer.parseInt(weekNum) < 1 || Integer.parseInt(weekNum) > 17){
            throw new Exception("Wrong week");
        }

        if (teacher == " "){
            throw new Exception("No teacher");
        }

        if (date == " "){
            throw new Exception("No year");
        }

        String morningHour = hour.charAt(0) + hour.charAt(1);
        String afternoonHour = hour.charAt(6) + hour.charAt(7);

        if (Integer.parseInt(morningHour) < 7 || Integer.parseInt(afternoonHour) > 22){
            throw new Exception("Class hour not permitted");
        }

        if (type != "Laboratorio" || type != "Teoria"){
            throw new Exception("Wrong type");
        }

        String linkBase = "​https://utec.zoom.us/rec/share/";
        StringBuilder linkComparetive = new StringBuilder();
        for(int i = 0; i < linkBase.length(); i++){
            linkComparetive.append(link.charAt(i));
        }

        if (linkComparetive.toString() != linkBase){
            throw new Exception("Wrong link");
        }

        return true;

    }

    public void notifyObserver() {
        if(verify()){
            Observer observer = new Observer();
            observer.update(true);
        } 
    }

    public String getSemester() {
        return semester;
    }

    public String getCode() {
        return code;
    }

    public String getLanguage() {
        return language;
    }

    public String getCourse() {
        return course;
    }

    public int getSection() {
        return section;
    }

    public String getWeek() {
        return week;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getType() {
        return type;
    }

    public String getLink() {
        return link;
    }

    public static void main(String[] args) {
        
    }

}
