package com.example.ibmhackathon3;

import com.example.ibmhackathon3.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class IbmHackathon3Application implements CommandLineRunner {

	public static List<User> users = new ArrayList<User>();
	public static List<Store> stores = new ArrayList<Store>();
	public static List<Appointment> appointments = new ArrayList<Appointment>();

	public static List<Appointment> sortAppointmentsBy (Form.Type type, List<Appointment> appointments) {
		List<Appointment> sortedAppointments = new ArrayList<Appointment>(appointments);
		switch (type) {
			case Date:
				sortedAppointments.sort((a1, a2) -> a1.date().compareTo(a2.date()));
				break;
			case Time:
				sortedAppointments.sort((a1, a2) -> a1.time().compareTo(a2.time()));
				break;
			case Distance:
				sortedAppointments.sort((a1, a2) -> (int) (a1.getPickUpDistance(users.get(2).getCurrentLocation()) - a2.getPickUpDistance(users.get(2).getCurrentLocation())));
				break;
			case Rating:
				sortedAppointments.sort((a1, a2) -> (int) (a2.getDriver().getStars() - a1.getDriver().getStars()));
				break;
			case isMale:
				sortedAppointments = filterAppointmentsBy(Form.Type.isMale, appointments, users.get(2));
				break;
			case isNotMale:
				sortedAppointments = filterAppointmentsBy(Form.Type.isNotMale, appointments, users.get(2));
				break;
			case All:
				break;
		}
		return sortedAppointments;
	}

	public static List<Appointment> filterAppointmentsBy (Form.Type type, List<Appointment> appointments, User user) {
		List<Appointment> filteredAppointments = new ArrayList<Appointment>();
		switch (type) {
			case isMale:
				for (Appointment appointment : appointments) {
					if (appointment.getDriver().getMale()) {
						filteredAppointments.add(appointment);
					}
				}
				break;
			case isNotMale:
				for (Appointment appointment : appointments) {
					if (!appointment.getDriver().getMale()) {
						filteredAppointments.add(appointment);
					}
				}
				break;
		}
		return filteredAppointments;
	}

	public static List<Appointment> filterAppointmentsBy (Form.Type type, List<Appointment> appointments, double value) {
		List<Appointment> filteredAppointments = new ArrayList<Appointment>();
		switch (type) {
			case Distance:
				for (Appointment appointment : appointments) {
					if (appointment.getPickUpDistance(users.get(2).getCurrentLocation()) <= value) {
						filteredAppointments.add(appointment);
					}
				}
				break;
			case Rating:
				for (Appointment appointment : appointments) {
					if (appointment.getDriver().getStars() >= value) {
						filteredAppointments.add(appointment);
					}
				}
				break;
		}
		return filteredAppointments;
	}

	public static List<Appointment> filterAppointmentsBy (Form.Type type, List<Appointment> appointments, Date date) {
		List<Appointment> filteredAppointments = new ArrayList<Appointment>();
		switch (type) {
			case Date:
				for (Appointment appointment : appointments) {
					if (appointment.getDate().getYear() == date.getYear() && appointment.getDate().getMonth() == date.getMonth() && appointment.getDate().getDate() == date.getDate()) {
						filteredAppointments.add(appointment);
					}
				}
				break;
			case Time:
				for (Appointment appointment : appointments) {
					if (appointment.getDate().getHours() == date.getHours() && appointment.getDate().getMinutes() == date.getMinutes()) {
						filteredAppointments.add(appointment);
					}
				}
				break;
		}
		return filteredAppointments;
	}

	public static void main(String[] args) {
		SpringApplication.run(IbmHackathon3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Generate test users
		User user1 = new User();
		user1.setFname("Ben");
		user1.setLname("Seager");
		user1.setUsername("BSeager");
		user1.setEmail("bs356@student.le.ac.uk");
		user1.setPhone("0700567222");
		user1.setDob(new Date(2003, 11, 19));
		user1.setMale(true);
		user1.addPreferredPickup(52.619820, -1.132340);

		Vehicle car = new Vehicle();
		car.setReg("WG56 1PA");
		car.setDriver(user1);
		car.setSeats(3);
		car.setLicense("ABC123");
		car.setStars(5);

		user1.addVehicle(car);
		users.add(user1);

		User user2 = new User();
		user2.setFname("John");
		user2.setLname("Doe");
		user2.setUsername("JDoe32");
		user2.setEmail("jdoe32@gmail.com");
		user2.setPhone("0700111222");
		user2.setDob(new Date(1995, 1, 12));
		user2.setMale(true);
		user2.addPreferredPickup(52.619820, -1.532340);
		users.add(user2);

		User user3 = new User();
		user3.setFname("Jane");
		user3.setLname("Doe");
		user3.setUsername("DoeJane");
		user3.setEmail("doejane@gmail.com");
		user3.setPhone("0700111222");
		user3.setDob(new Date(1998, 5, 3));
		user3.setMale(false);
		user3.addPreferredPickup(52.619820, -1.532340);
		user3.setCurrentLocation(52.619820, -1.532340);
		users.add(user3);

		// Generate test stores
		Store tesco = new Store();
		tesco.setName("Tesco");
		tesco.setLocation(52.619820, -1.132340);
		tesco.setAddress("123 Fake Street");
		tesco.setPhone("0116 123 4567");
		tesco.setWebpage("www.tesco.com");
		tesco.addOpeningHours("Monday", new String[] {"08:00", "20:00"});
		tesco.addOpeningHours("Tuesday", new String[] {"08:00", "20:00"});
		tesco.addOpeningHours("Wednesday", new String[] {"08:00", "20:00"});
		tesco.addOpeningHours("Thursday", new String[] {"08:00", "20:00"});
		tesco.addOpeningHours("Friday", new String[] {"08:00", "20:00"});
		tesco.addOpeningHours("Saturday", new String[] {"08:00", "22:00"});
		tesco.addOpeningHours("Sunday", new String[] {"10:00", "16:00"});
		stores.add(tesco);

		Store sainsburys = new Store();
		sainsburys.setName("Sainsburys");
		sainsburys.setLocation(40.7128, -74.0060);
		sainsburys.setAddress("456 Fake Street");
		sainsburys.setPhone("0116 123 4567");
		sainsburys.setWebpage("www.sainsburys.com");
		sainsburys.addOpeningHours("Monday", new String[] {"08:00", "20:00"});
		sainsburys.addOpeningHours("Tuesday", new String[] {"08:00", "20:00"});
		sainsburys.addOpeningHours("Wednesday", new String[] {"08:00", "20:00"});
		sainsburys.addOpeningHours("Thursday", new String[] {"08:00", "20:00"});
		sainsburys.addOpeningHours("Friday", new String[] {"08:00", "20:00"});
		sainsburys.addOpeningHours("Saturday", new String[] {"08:00", "22:00"});
		sainsburys.addOpeningHours("Sunday", new String[] {"10:00", "16:00"});
		stores.add(sainsburys);

		Store asda = new Store();
		asda.setName("Asda");
		asda.setLocation(51.5074, -0.1278);
		asda.setAddress("789 Fake Street");
		asda.setPhone("0116 123 4567");
		asda.setWebpage("www.asda.com");
		asda.addOpeningHours("Monday", new String[] {"08:00", "20:00"});
		asda.addOpeningHours("Tuesday", new String[] {"08:00", "20:00"});
		asda.addOpeningHours("Wednesday", new String[] {"08:00", "20:00"});
		asda.addOpeningHours("Thursday", new String[] {"08:00", "20:00"});
		asda.addOpeningHours("Friday", new String[] {"08:00", "20:00"});
		asda.addOpeningHours("Saturday", new String[] {"08:00", "22:00"});
		asda.addOpeningHours("Sunday", new String[] {"10:00", "16:00"});
		stores.add(asda);

		// Generate test appointments
		Appointment appointment1 = new Appointment();
		appointment1.setDriver(user1);
		appointment1.addParticipant(user2);
		appointment1.addParticipant(user3);
		appointment1.setDate(new Date(2024, 2, 18, 13, 15));
		appointment1.setStore(tesco);
		appointment1.setPickUp(52.619820, -1.132340);
		appointments.add(appointment1);

		Appointment appointment2 = new Appointment();
		appointment2.setDriver(user1);
		appointment2.addParticipant(user2);
		appointment2.setDate(new Date(2024, 1, 12, 12, 15));
		appointment2.setStore(sainsburys);
		appointment2.setPickUp(50.619820, -2.0060);
		appointments.add(appointment2);

		appointments = sortAppointmentsBy(Form.Type.Distance, appointments);

	}

}
