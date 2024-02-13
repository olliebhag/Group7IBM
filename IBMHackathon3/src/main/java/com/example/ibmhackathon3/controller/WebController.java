package com.example.ibmhackathon3.controller;

import com.example.ibmhackathon3.IbmHackathon3Application;
import com.example.ibmhackathon3.domain.Appointment;
import com.example.ibmhackathon3.domain.Form;
import com.example.ibmhackathon3.domain.User;
import com.example.ibmhackathon3.domain.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class WebController {
    @RequestMapping("/")
    public String start(Model model) {
        model.addAttribute("user", IbmHackathon3Application.users.get(2));
        model.addAttribute("events", IbmHackathon3Application.appointments);
        model.addAttribute("stores", IbmHackathon3Application.stores);
        return "app/home";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("user", IbmHackathon3Application.users.get(2));
        model.addAttribute("events", IbmHackathon3Application.appointments);
        model.addAttribute("stores", IbmHackathon3Application.stores);
        model.addAttribute("random", new Random().nextInt(7));
        return "app/profile";
    }

    @RequestMapping("/viewprofile")
    public String viewProfile(@RequestParam String id, Model model) {
        System.out.println("DEBUG ID: " + IbmHackathon3Application.users.get(Integer.parseInt(id)));
        model.addAttribute("user", IbmHackathon3Application.users.get(Integer.parseInt(id)));
        model.addAttribute("events", IbmHackathon3Application.appointments);
        model.addAttribute("stores", IbmHackathon3Application.stores);
        model.addAttribute("random", new Random().nextInt(7));
        return "app/viewprofile";
    }

    @RequestMapping("/search")
    public String search(Model model) {
        model.addAttribute("sort", new Form(Form.Type.Date));
        model.addAttribute("user", IbmHackathon3Application.users.get(2));
        model.addAttribute("events", IbmHackathon3Application.appointments);
        model.addAttribute("stores", IbmHackathon3Application.stores);
        return "app/search";
    }

    @RequestMapping("/sortSearch")
    public String sortSearch(@ModelAttribute Form sort, Model model) {
        model.addAttribute("sort", sort);
        model.addAttribute("user", IbmHackathon3Application.users.get(2));
        model.addAttribute("events", IbmHackathon3Application.sortAppointmentsBy(sort.getType(), IbmHackathon3Application.appointments));
        model.addAttribute("stores", IbmHackathon3Application.stores);
        return "app/search";
    }

    @RequestMapping("/getEvent")
    public String getEvent(@RequestParam int id, Model model) {
        model.addAttribute("user", IbmHackathon3Application.users.get(2));
        model.addAttribute("event", IbmHackathon3Application.appointments.get(id));
        model.addAttribute("stores", IbmHackathon3Application.stores);
        model.addAttribute("seats", IbmHackathon3Application.appointments.get(id).getDriver().getVehicles().get(0).getSeats() - IbmHackathon3Application.appointments.get(id).getParticipants().size() - 1);
        model.addAttribute("size", IbmHackathon3Application.appointments.get(id).getParticipants().size());

        return "app/event";
    }

    @RequestMapping("/deleteEvent")
    public String deleteEvent (@RequestParam int id, Model model) {
        IbmHackathon3Application.appointments.remove(id);
        return "redirect:/";
    }

    @RequestMapping("/joinEvent")
    public String joinEvent (@RequestParam int id, @RequestParam int user, Model model) {
        model.addAttribute("user", IbmHackathon3Application.users.get(user));
        model.addAttribute("event", IbmHackathon3Application.appointments.get(id));
        model.addAttribute("stores", IbmHackathon3Application.stores);
        model.addAttribute("seats", IbmHackathon3Application.appointments.get(id).getDriver().getVehicles().get(0).getSeats() - IbmHackathon3Application.appointments.get(id).getParticipants().size() - 1);
        model.addAttribute("size", IbmHackathon3Application.appointments.get(id).getParticipants().size());
        if (IbmHackathon3Application.appointments.get(id).getDriver().getVehicles().get(0).getSeats() == IbmHackathon3Application.appointments.get(id).getParticipants().size() + 1) {
            return "redirect:/";
        }

        IbmHackathon3Application.appointments.get(id).addParticipant(IbmHackathon3Application.users.get(user));
        return "redirect:/event?id=" + id;
    }

    @RequestMapping("/leaveEvent")
    public String leaveEvent (@RequestParam int id, @RequestParam int user, Model model) {
        IbmHackathon3Application.appointments.get(id).removeParticipant(IbmHackathon3Application.users.get(user));
        return "redirect:/";
    }

    @RequestMapping("/createVehicle")
    public String createVehicle (@RequestParam int id, Model model) {
        User user = IbmHackathon3Application.users.get(id);
        Vehicle car = new Vehicle();
        car.setDriver(user);
        car.setSeats(new Random().nextInt(4) + 1);
        car.setReg("ABC" + (new Random().nextInt(900) + 100));
        user.addVehicle(car);
        model.addAttribute("user", user);
        return "redirect:/profile";
    }
}
