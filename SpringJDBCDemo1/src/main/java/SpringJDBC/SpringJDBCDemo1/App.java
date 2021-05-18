package SpringJDBC.SpringJDBCDemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jdbc.models.Company;
import com.jdbc.models.Holiday;
import com.jdbc.service.ICompanyService;
import com.jdbc.service.IHolidayService;

/**
 * Hello world!
 *
 */
@ComponentScan("com.jdbc")
public class App {
	public static void main(String[] args) throws ParseException, IOException {
		var ctx = new AnnotationConfigApplicationContext(App.class);
		var app = ctx.getBean(App.class);
		app.Run();

		ctx.close();
	}

	@Autowired
	private IHolidayService holiayService;
	@Autowired
	private ICompanyService companyService;

	private void Run() throws ParseException, IOException {
		int choise = 0;
		while (choise >= 1 || choise <= 5) {
			Menu();
			Scanner input = new Scanner(System.in);
			System.out.println("Choose from these choices: ");
			choise = input.nextInt();
			
			switch (choise) {
			case 1:
				var companies = (List<Company>) companyService.getAll();
				System.out.println(String.format("%s\t\t|\t%s\t|\t%s", "Name", "Code", "Language"));
				companies.forEach(item -> {
					System.out.println(String.format("%s\t\t|\t%s1\t|\t%s2", item.getName(), item.getCode(), item.getLanguage()));
				});
				break;
			case 2:
				var holidays = (List<Holiday>) holiayService.getAll();
				System.out.println(String.format("%s\t\t|\t%s\t|", "Date", "Des"));
				holidays.forEach(item -> {
					System.out.println(String.format("%s\t\t|\t%s1\t", item.getDate(), item.getDescription()));
				});
				break;
			case 3:
				Holiday hd = new Holiday();
				var id = UUID.randomUUID().toString();
				hd.setHolidayID(id);
				hd.setCompanyID("6A94FFD2-4F69-41C2-85D3-558AAA3B1523");
				hd.setType((byte)3);
				Scanner hdInput = new Scanner(System.in);
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter date(yyyy-MM-dd): ");
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(hdInput.next());
				hd.setDate(date);
				System.out.println("Enter description: ");
				hd.setDescription(reader.readLine());
				try {
					holiayService.Insert(hd);
					System.out.println("Insert success!");
				}
				catch(Exception ex) {
					System.out.println("Insert fail!");
				}	
				
				break;
			case 4:
				Holiday hd1 = new Holiday();
				hd1.setCompanyID("6A94FFD2-4F69-41C2-85D3-558AAA3B1523");
				hd1.setType((byte)3);
				Scanner hdInput1 = new Scanner(System.in);
				BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter date(yyyy-MM-dd): ");
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(hdInput1.next());
				hd1.setDate(date1);
				System.out.println("Enter description: ");
				hd1.setDescription(reader1.readLine());
				try {
					holiayService.InsertByStore(hd1);
					System.out.println("Insert success!");
				}
				catch(Exception ex) {
					System.out.println("Insert fail!");
				}	
				
				break;
			case 5:
				Holiday hd2 = new Holiday();
				Scanner hdInput2 = new Scanner(System.in);
				System.out.println("Enter holiday ID: ");
				hd2.setHolidayID(hdInput2.nextLine());
				System.out.println("Enter date(yyyy-MM-dd): ");
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(hdInput2.next());
				hd2.setDate(date2);
				System.out.println("Enter description: ");
				hd2.setDescription(hdInput2.nextLine());
				try {
					holiayService.Update(hd2);
					System.out.println("Update success!");
				}
				catch(Exception ex) {
					System.out.println("Update fail!");
				}	
				
				break;
			case 6:
				Scanner hdInput3 = new Scanner(System.in);
				System.out.println("Enter holiday ID: ");
				String holidayID = hdInput3.nextLine();
				try {
					holiayService.Delete(holidayID);
					System.out.println("Delete success!");
				}
				catch(Exception ex) {
					System.out.println("Delete fail!");
				}	
				break;
			case 7:
				System.out.println ("Exiting the program... thank you");
                System.exit(0);	// Exits the program
				break;
			default:
				 System.out.println("Error! " + choise +
                         " is not a valid menu option");
			}
		}

	}

	private void Menu() {
		System.out.println("\n------------MENU-------------\n");
		System.out.println("1 - Export company list");
		System.out.println("2 - Export holiday list");
		System.out.println("3 - Insert a holiday");
		System.out.println("4 - Insert a holiday by store procedure");
		System.out.println("5 - Update a holiday");
		System.out.println("6 - Delete a holiday");
		System.out.println("7 - Quit");
		System.out.println("\n----------------------------\n");

	}
}
