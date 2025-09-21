package org.example.chipmongdemotest.controller;
import org.example.chipmongdemotest.model.*;
import org.example.chipmongdemotest.repository.*;
import org.example.chipmongdemotest.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;
    private final ProvinceMapper provinceMapper;
    private final AmphurMapper amphurMapper;
    private final DistrictMapper districtMapper;

    public ContactController(ContactService contactService, ProvinceMapper provinceMapper,
                             AmphurMapper amphurMapper, DistrictMapper districtMapper) {
        this.contactService = contactService;
        this.provinceMapper = provinceMapper;
        this.amphurMapper = amphurMapper;
        this.districtMapper = districtMapper;
    }

    // Load all provinces for the form
    @ModelAttribute("provinces")
    public List<Province> getProvinces() {
        return provinceMapper.findAll();
    }

    // Return Amphurs by Province (for AJAX)
    @GetMapping("/amphurs")
    @ResponseBody
    public List<Amphur> getAmphurs(@RequestParam Long provinceId) {
        return amphurMapper.findByProvinceId(provinceId);
    }

    // Return Districts by Amphur (for AJAX)
    @GetMapping("/districts")
    @ResponseBody
    public List<District> getDistricts(@RequestParam Long amphurId) {
        return districtMapper.findByAmphurId(amphurId);
    }

    // Show new contact form
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact_form";
    }

    // Save contact
    @PostMapping("/save")
    public String save(@ModelAttribute Contact contact) {
        if (contact.getProvinceId() != null) {
            Province p = provinceMapper.findById(contact.getProvinceId());
            contact.setProvinceName(p != null ? p.getName() : null);
        }
        if (contact.getAmphurId() != null) {
            Amphur a = amphurMapper.findById(contact.getAmphurId());
            contact.setAmphurName(a != null ? a.getName() : null);
        }
        if (contact.getDistrictId() != null) {
            District d = districtMapper.findById(contact.getDistrictId());
            contact.setDistrictName(d != null ? d.getName() : null);
        }

        contactService.saveContact(contact);
        return "redirect:/contacts/new?success";
    }

}
