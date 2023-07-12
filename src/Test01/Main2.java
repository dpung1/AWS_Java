package Test01;

import java.util.Arrays;
import java.util.List;

class SubjectService {
	private List<String> subjects;
	
	public SubjectService(List<String> subject) {
		this.subjects = subject;
	}
	
	public void showsubject() {
		
		int lenght = 3;
		for(int i = 0; i < lenght; i++) {
			
			System.out.println(subjects.get(i));
		}
	}
}

public class Main2 {
	public static void main(String[] args) {
		List<String> subjects = Arrays.asList(new String[] {"C", "Java", "Python"});
		SubjectService subjectService = new SubjectService(subjects);
		subjectService.showsubject();
	}
}
