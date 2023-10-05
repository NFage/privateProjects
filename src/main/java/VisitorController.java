import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisitorController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/checkin")
    public String checkin() {
        return "checkin";
    }

    @PostMapping("/submitCheckin")
    public String submitCheckin(@RequestParam String companyName,
                                @RequestParam String visitorName,
                                @RequestParam(required = false) boolean isVisiting) {
        // Implement logic to save check-in details to the database
        // You can use a service class to interact with the database
        // For simplicity, we'll print the details for now
        System.out.println("Company Name: " + companyName);
        System.out.println("Visitor Name: " + visitorName);
        System.out.println("Is Visiting: " + isVisiting);

        // Redirect back to the welcome page after submission
        return "redirect:/";
    }
}

