package main.java.com.fullcell.demo.controller;

@restController
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/phone")
    public List<Phone> getPhone(){
        return phoneRepository.findAll();
    }


}
