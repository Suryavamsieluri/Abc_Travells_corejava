package com;

import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AbcUtil {

	Model model = new Model();
	Map<String, User> usersMap = model.getMap();
	List<Bus> busList = model.busList;
	List<Ticket> tktList = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	public void wish() throws FileNotFoundException {
		//file for printing logo
		File file=new File("C:\\Users\\Ambika\\Desktop\\logo.txt");
		Scanner reader=new Scanner(file);
		while(reader.hasNext()) {
			String line=reader.nextLine();
			System.out.println(line);
		}
		reader.close();

	}

	public void menu() {

		System.out.println("1. New User Registration");
		System.out.println("2. login");
		System.out.println("3. Enquery");
		System.out.println("Chose any one option: ");
	}

	public void createUser() {

		
		System.out.println("enter your first name:");
		String firstName = sc.nextLine();

		System.out.println("enter your last name:");
		String lastName = sc.nextLine();
		System.out.println("enter your mobile number:");
		String phoneNumber = sc.nextLine();
		boolean validNum = isValidNum(phoneNumber);
		if (validNum) {
			System.out.println("Valid phone number");
			System.out.println("enter your gender:");
			String gender = sc.nextLine();
			System.out.println("enter your email:");
			String email = sc.nextLine();
			// checkEmail(email);
			// validateEmail(email);
			System.out.println("enter your password:");
			String password = sc.nextLine();
			User newUser = new User(firstName, lastName, phoneNumber, gender, email, password);
			usersMap.put(email, newUser);
			System.out.println(newUser);
			Set<Entry<String, User>> entrySet = usersMap.entrySet();
			for (Entry<String, User> s : entrySet) {
				System.out.println(s);
			}
		} else {
			System.out.println("invalid phone number");
		}

	}

	public static boolean isValidNum(String phoneNum) {

		if (phoneNum.length() == 10
				&& (phoneNum.charAt(0) == '9' || phoneNum.charAt(0) == '7' || phoneNum.charAt(0) == '8')) {
			return true;
		}
		return false;
	}

	public void login() {
		
		System.out.println("enter your email: ");
		String email = sc.nextLine();
		//if user enters an email which is not in our list it will print "email is not in our records" 
		User user = usersMap.get(email);
		if (user == null) {
			System.out.println("your email is not in our records");
		} else {
			System.out.println("enter your password: ");
			String password = sc.nextLine();
			if (user.getPassword().equals(password)) {
				user.setFailedCount(0);
				System.out.println("Hey " + user.getFirstName() + " Welcome to ABC Travells");
				while (true) {
					System.out.println("enter your choice:");
					loginMenu();
					int inChoice = sc.nextInt();
					switch (inChoice) {
					case (1): {
						Bus bus = showBuses();
						System.out.println("No of tickets requuired: ");
						int noOfTkts = sc.nextInt();
						sc.nextLine();

						// here we need to add local date
						System.out.println("enter your journey date(DD-MM-YYYY):");
						String date = sc.nextLine();
						LocalDate dateObj = getDateObj(date);

						if (!(noOfTkts > bus.getSeats() || dateObj.isBefore(LocalDate.now()))) {
							System.out.println("your tickets booked successfully");
							System.out.println("your bill is: " + noOfTkts * bus.getPrice());
							// bus.setSeats(bus.getSeats() - noOfTkts);
							bus.dateAndSeat.put(date, bus.getSeats() - noOfTkts);
							Ticket tkt = new Ticket(bus.getStartPoint(), bus.getEndPoint(), bus.getPrice(), noOfTkts,
									dateObj);
							tktList.add(tkt);
						}

						break;
					}
					case (2): {
						System.out.println("your booking history is:");
						for (Ticket t : tktList) {
							System.out.println(t + " " + t.getSeats());
						}
						break;
					}
					case (3): {
						int ticketChoice = 0;
						for (Ticket t : tktList) {
							System.out.println(ticketChoice + ". " + t.getBoarding() + " TO " + t.getDroping() + " AT "
									+ t.getDate());
							ticketChoice++;
						}
						System.out.println("select a ticktet to edit your journey:");
						// int ticketNum = sc.nextInt();
					}

					}
					if (inChoice == 4) {
						break;

					}
				}

			} else {
				int failedCount = user.getFailedCount();
				failedCount += 1;
				System.out.println("Sorry wrong Password, You have " + (5 - failedCount) + " Chances only");
				user.setFailedCount(failedCount);
			}

		}
	}

	public Bus showBuses() {
		System.out.println("Choose your boarding :");
		System.out.println("1. Hyderabad");
		System.out.println("2. Vijayawada");
		int bchoice = sc.nextInt();
		String boardingCity = getBCityByInt(bchoice);
		List<String> departures = getDeparture(boardingCity, busList);
		int j = 1;
		for (String d : departures) {
			System.out.println(j + ". " + d);
			j++;
		}
		System.out.println("Choose your Departure:");
		int dchoice = sc.nextInt();
		String departureCity = departures.get(dchoice - 1);

		Bus bus = getBus(boardingCity, departureCity, busList);
		return bus;

	}

	public void loginMenu() {
		System.out.println("1. Plan Journey");
		System.out.println("2. view history");
		System.out.println("3. Edit Journey");
		System.out.println("4. LogOut");
	}

	public static LocalDate getDateObj(String date) {

		String[] dates = date.split("-");

		int[] intDate = new int[dates.length];
		for (int i = 0; i < dates.length; i++) {
			intDate[i] = Integer.parseInt(dates[i]);
		}
		LocalDate journeyDate = LocalDate.of(intDate[2], intDate[1], intDate[0]);
		return journeyDate;

	}

	public static String getBCityByInt(int bchoice) {
		if (bchoice == 1)
			return "Hyderabad";
		else if (bchoice == 2)
			return "Vijayawada";
		return null;
	}

	public static List<String> getDeparture(String boarding, List<Bus> buses) {
		List<String> departure = new ArrayList<>();
		for (Bus b : buses) {
			if (b.getStartPoint().equalsIgnoreCase(boarding)) {
				departure.add(b.getEndPoint());
			}
		}
		return departure;
	}

	public static Bus getBus(String boarding, String departure, List<Bus> buses) {
		Bus bus = null;
		for (Bus b : buses) {
			if (boarding.equalsIgnoreCase(b.getStartPoint()) && departure.equalsIgnoreCase(b.getEndPoint())) {
				bus = b;
			}
		}
		return bus;

	}

	public void enquire() {
		Bus showBuses = showBuses();
		System.out.println("enter date:");
		String date = sc.next();
		int seats = getSeatsByDate(date, showBuses);
		System.out.println("No of Tickets available: " + seats);
		System.out.println("Price  of each Ticket: " + showBuses.getPrice());
		System.out.println("-----Please Login to Book tickets-----");
	}

	public static int getSeatsByDate(String date, Bus bus) {
		if (bus.dateAndSeat.get(date) == null) {
			bus.dateAndSeat.put(date, bus.getSeats());
			return (int) bus.dateAndSeat.get(date);

		} else {
			return (int) bus.dateAndSeat.get(date);
		}

	}

}
