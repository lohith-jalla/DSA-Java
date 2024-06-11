import java.util.*;

class Students {

    int id;
    String name;
    double cgpa;

   void Student(int id,String name,double cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
   }
   public int getID(){
       return this.id;
   }
    public String getName(){
        return this.name;
    }
    public double getCgpa(){
        return this.cgpa;
    }
}

class StudentComparator implements Comparator<Students> {
        @Override
        public int compare(Students s1, Students s2) {
            int cgpaComparison = Double.compare(s2.getCgpa(), s1.getCgpa());
            if (cgpaComparison != 0) {
                return cgpaComparison;
            }
            int nameComparison = s1.getName().compareTo(s2.getName());
            if (nameComparison != 0) {
                return nameComparison;
            }
            return Double.compare(s1.getID(), s2.getID());
        }
}
class StudentSorter {
    public List<Students> getStudents(List<Students> students) {
            Collections.sort(students, new StudentComparator());
            return students;
    }
}





