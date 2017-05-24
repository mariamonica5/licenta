package repository;

import domain.Student;
import domain.validators.Validator;
import domain.validators.ValidatorException;

import java.io.*;

public class StudentFileRepository extends AbstractFileRepository<Student,String> {
	public StudentFileRepository(Validator<Student> v, String fName) {
		super(v,fName);
	}

	public void loadData()
	{
		try(BufferedReader br=new BufferedReader(new FileReader(super.fileName))){
			String line;
			while((line=br.readLine())!=null){
				String[] atributes=line.split(";");
				if(atributes.length!=4)
					throw new Exception("Linia nu este valida!");
				Student t=new Student(atributes[0],atributes[1],atributes[2],atributes[3]);
				super.save(t);

			}
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void writeToFile() {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(super.fileName))){
			super.entities.forEach(x -> {
				try {
					br.write(x.studentFileLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}