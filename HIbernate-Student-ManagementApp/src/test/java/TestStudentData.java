import com.sri.sm.dao.StudentDAOImpl;
import com.sri.sm.domain.Student;

public class TestStudentData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentDAOImpl st = new StudentDAOImpl();
		Student student = st.getStudent(2);
		System.out.println(student);
		
		
		
		
	}

}
