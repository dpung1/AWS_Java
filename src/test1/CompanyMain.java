package test1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
class Company {
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
}

public class CompanyMain {
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Company company = Company.builder()
				.companyId(100)
				.companyName("Apple")
				.address("Apple Computer Ine. 1 infinite Loop")
				.city("Cupertino")
				.state("CA")
				.zipCode("95014")
				.build();
		
		String jsonData = gson.toJson(company);
		System.out.println(jsonData);
		
		
	}
}
