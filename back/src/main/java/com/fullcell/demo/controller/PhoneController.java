package main.java.com.fullcell.demo.controller;

@RestController
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/phone")
    public List<Phone> getPhone(){
        return phoneRepository.findAll();
    }


}
